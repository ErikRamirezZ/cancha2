package com.raze.cancha.domain;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PersistenceContext;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.TypedQuery;
import javax.persistence.Version;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.format.annotation.DateTimeFormat;
import com.raze.cancha.catalog.Rol;
import flexjson.JSONDeserializer;
import flexjson.JSONSerializer;
import org.springframework.roo.addon.json.RooJson;
import org.springframework.transaction.annotation.Transactional;

@Entity
@Configurable
@RooJavaBean
@RooToString
@RooJpaActiveRecord(finders = { "findUsuariosByEmpresaAndActivo", "findUsuariosByEmpresaCorreoELikeAndActivo", "findUsuariosByEmpresaAndNombreLikeAndActivo", "findUsuariosByApellidoPaternoLike", "findUsuariosByRolAndActivo" })
@RooJson(deepSerialize = true)
public class Usuario {

    /**
     */
    @NotNull
    @ManyToOne
    private Empresa empresa;

    /**
     */
    @NotNull
    private String nombre;

    /**
     */
    private String apellidoPaterno;

    /**
     */
    private String apellidoMaterno;

    /**
     */
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(style = "M-")
    private Date fechaNacimiento;

    /**
     */
    private String domicilio;

    /**
     */
    private String telefono;

    /**
     */
    private String celular;

    /**
     */
    @NotNull
    private String correoE;

    /**
     */
    private String password;

    /**
     */
    @NotNull
    @ManyToOne
    private Rol rol;

    /**
     */
    private int numeroIntentos;

    /**
     */
    private Boolean activo;

    /**
     */
    @ManyToOne
    private Usuario usuario;

    /**
     */
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(style = "M-")
    private Date fechaCreacion;

    /**
     */
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(style = "M-")
    private Date fechaModificacion;

	@PersistenceContext
    transient EntityManager entityManager;

	public static final List<String> fieldNames4OrderClauseFilter = java.util.Arrays.asList("empresa", "nombre", "apellidoPaterno", "apellidoMaterno", "fechaNacimiento", "domicilio", "telefono", "celular", "correoE", "password", "rol", "numeroIntentos", "activo", "usuario", "fechaCreacion", "fechaModificacion");

	public static final EntityManager entityManager() {
        EntityManager em = new Usuario().entityManager;
        if (em == null) throw new IllegalStateException("Entity manager has not been injected (is the Spring Aspects JAR configured as an AJC/AJDT aspects library?)");
        return em;
    }

	public static long countUsuarios() {
        return entityManager().createQuery("SELECT COUNT(o) FROM Usuario o", Long.class).getSingleResult();
    }

	public static List<Usuario> findAllUsuarios() {
        return entityManager().createQuery("SELECT o FROM Usuario o", Usuario.class).getResultList();
    }

	public static List<Usuario> findAllUsuarios(String sortFieldName, String sortOrder) {
        String jpaQuery = "SELECT o FROM Usuario o";
        if (fieldNames4OrderClauseFilter.contains(sortFieldName)) {
            jpaQuery = jpaQuery + " ORDER BY " + sortFieldName;
            if ("ASC".equalsIgnoreCase(sortOrder) || "DESC".equalsIgnoreCase(sortOrder)) {
                jpaQuery = jpaQuery + " " + sortOrder;
            }
        }
        return entityManager().createQuery(jpaQuery, Usuario.class).getResultList();
    }

	public static Usuario findUsuario(Long id) {
        if (id == null) return null;
        return entityManager().find(Usuario.class, id);
    }

	public static List<Usuario> findUsuarioEntries(int firstResult, int maxResults) {
        return entityManager().createQuery("SELECT o FROM Usuario o", Usuario.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }

	public static List<Usuario> findUsuarioEntries(int firstResult, int maxResults, String sortFieldName, String sortOrder) {
        String jpaQuery = "SELECT o FROM Usuario o";
        if (fieldNames4OrderClauseFilter.contains(sortFieldName)) {
            jpaQuery = jpaQuery + " ORDER BY " + sortFieldName;
            if ("ASC".equalsIgnoreCase(sortOrder) || "DESC".equalsIgnoreCase(sortOrder)) {
                jpaQuery = jpaQuery + " " + sortOrder;
            }
        }
        return entityManager().createQuery(jpaQuery, Usuario.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }

	@Transactional
    public void persist() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.persist(this);
    }

	@Transactional
    public void remove() {
        if (this.entityManager == null) this.entityManager = entityManager();
        if (this.entityManager.contains(this)) {
            this.entityManager.remove(this);
        } else {
            Usuario attached = Usuario.findUsuario(this.id);
            this.entityManager.remove(attached);
        }
    }

	@Transactional
    public void flush() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.flush();
    }

	@Transactional
    public void clear() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.clear();
    }

	@Transactional
    public Usuario merge() {
        if (this.entityManager == null) this.entityManager = entityManager();
        Usuario merged = this.entityManager.merge(this);
        this.entityManager.flush();
        return merged;
    }

	public String toJson() {
        return new JSONSerializer()
        .exclude("*.class").deepSerialize(this);
    }

	public String toJson(String[] fields) {
        return new JSONSerializer()
        .include(fields).exclude("*.class").deepSerialize(this);
    }

	public static Usuario fromJsonToUsuario(String json) {
        return new JSONDeserializer<Usuario>()
        .use(null, Usuario.class).deserialize(json);
    }

	public static String toJsonArray(Collection<Usuario> collection) {
        return new JSONSerializer()
        .exclude("*.class").deepSerialize(collection);
    }

	public static String toJsonArray(Collection<Usuario> collection, String[] fields) {
        return new JSONSerializer()
        .include(fields).exclude("*.class").deepSerialize(collection);
    }

	public static Collection<Usuario> fromJsonArrayToUsuarios(String json) {
        return new JSONDeserializer<List<Usuario>>()
        .use("values", Usuario.class).deserialize(json);
    }

	public String toString() {
        return ReflectionToStringBuilder.toString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }

	public Empresa getEmpresa() {
        return this.empresa;
    }

	public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

	public String getNombre() {
        return this.nombre;
    }

	public void setNombre(String nombre) {
        this.nombre = nombre;
    }

	public String getApellidoPaterno() {
        return this.apellidoPaterno;
    }

	public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

	public String getApellidoMaterno() {
        return this.apellidoMaterno;
    }

	public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

	public Date getFechaNacimiento() {
        return this.fechaNacimiento;
    }

	public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

	public String getDomicilio() {
        return this.domicilio;
    }

	public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

	public String getTelefono() {
        return this.telefono;
    }

	public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

	public String getCelular() {
        return this.celular;
    }

	public void setCelular(String celular) {
        this.celular = celular;
    }

	public String getCorreoE() {
        return this.correoE;
    }

	public void setCorreoE(String correoE) {
        this.correoE = correoE;
    }

	public String getPassword() {
        return this.password;
    }

	public void setPassword(String password) {
        this.password = password;
    }

	public Rol getRol() {
        return this.rol;
    }

	public void setRol(Rol rol) {
        this.rol = rol;
    }

	public int getNumeroIntentos() {
        return this.numeroIntentos;
    }

	public void setNumeroIntentos(int numeroIntentos) {
        this.numeroIntentos = numeroIntentos;
    }

	public Boolean getActivo() {
        return this.activo;
    }

	public void setActivo(Boolean activo) {
        this.activo = activo;
    }

	public Usuario getUsuario() {
        return this.usuario;
    }

	public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

	public Date getFechaCreacion() {
        return this.fechaCreacion;
    }

	public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

	public Date getFechaModificacion() {
        return this.fechaModificacion;
    }

	public void setFechaModificacion(Date fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

	@Version
    @Column(name = "version")
    private Integer version;

	public Long getId() {
        return this.id;
    }

	public void setId(Long id) {
        this.id = id;
    }

	public Integer getVersion() {
        return this.version;
    }

	public void setVersion(Integer version) {
        this.version = version;
    }

	public static Long countFindUsuariosByApellidoPaternoLike(String apellidoPaterno) {
        if (apellidoPaterno == null || apellidoPaterno.length() == 0) throw new IllegalArgumentException("The apellidoPaterno argument is required");
        apellidoPaterno = apellidoPaterno.replace('*', '%');
        if (apellidoPaterno.charAt(0) != '%') {
            apellidoPaterno = "%" + apellidoPaterno;
        }
        if (apellidoPaterno.charAt(apellidoPaterno.length() - 1) != '%') {
            apellidoPaterno = apellidoPaterno + "%";
        }
        EntityManager em = Usuario.entityManager();
        TypedQuery q = em.createQuery("SELECT COUNT(o) FROM Usuario AS o WHERE LOWER(o.apellidoPaterno) LIKE LOWER(:apellidoPaterno)", Long.class);
        q.setParameter("apellidoPaterno", apellidoPaterno);
        return ((Long) q.getSingleResult());
    }

	public static Long countFindUsuariosByEmpresaAndActivo(Empresa empresa, Boolean activo) {
        if (empresa == null) throw new IllegalArgumentException("The empresa argument is required");
        if (activo == null) throw new IllegalArgumentException("The activo argument is required");
        EntityManager em = Usuario.entityManager();
        TypedQuery q = em.createQuery("SELECT COUNT(o) FROM Usuario AS o WHERE o.empresa = :empresa AND o.activo = :activo", Long.class);
        q.setParameter("empresa", empresa);
        q.setParameter("activo", activo);
        return ((Long) q.getSingleResult());
    }

	public static Long countFindUsuariosByEmpresaAndNombreLikeAndActivo(Empresa empresa, String nombre, Boolean activo) {
        if (empresa == null) throw new IllegalArgumentException("The empresa argument is required");
        if (nombre == null || nombre.length() == 0) throw new IllegalArgumentException("The nombre argument is required");
        nombre = nombre.replace('*', '%');
        if (nombre.charAt(0) != '%') {
            nombre = "%" + nombre;
        }
        if (nombre.charAt(nombre.length() - 1) != '%') {
            nombre = nombre + "%";
        }
        if (activo == null) throw new IllegalArgumentException("The activo argument is required");
        EntityManager em = Usuario.entityManager();
        TypedQuery q = em.createQuery("SELECT COUNT(o) FROM Usuario AS o WHERE o.empresa = :empresa AND LOWER(o.nombre) LIKE LOWER(:nombre)  AND o.activo = :activo", Long.class);
        q.setParameter("empresa", empresa);
        q.setParameter("nombre", nombre);
        q.setParameter("activo", activo);
        return ((Long) q.getSingleResult());
    }

	public static Long countFindUsuariosByEmpresaCorreoELikeAndActivo(Empresa empresa, String correoE, Boolean activo) {
        if (empresa == null) throw new IllegalArgumentException("The empresa argument is required");
        if (correoE == null || correoE.length() == 0) throw new IllegalArgumentException("The correoE argument is required");
        correoE = correoE.replace('*', '%');
        if (correoE.charAt(0) != '%') {
            correoE = "%" + correoE;
        }
        if (correoE.charAt(correoE.length() - 1) != '%') {
            correoE = correoE + "%";
        }
        if (activo == null) throw new IllegalArgumentException("The activo argument is required");
        EntityManager em = Usuario.entityManager();
        TypedQuery q = em.createQuery("SELECT COUNT(o) FROM Usuario AS o WHERE LOWER(o.correoE) LIKE LOWER(:correoE)  AND o.activo = :activo", Long.class);
        q.setParameter("empresa", empresa);
        q.setParameter("correoE", correoE);
        q.setParameter("activo", activo);
        return ((Long) q.getSingleResult());
    }

	public static Long countFindUsuariosByRolAndActivo(Rol rol, Boolean activo) {
        if (rol == null) throw new IllegalArgumentException("The rol argument is required");
        if (activo == null) throw new IllegalArgumentException("The activo argument is required");
        EntityManager em = Usuario.entityManager();
        TypedQuery q = em.createQuery("SELECT COUNT(o) FROM Usuario AS o WHERE o.rol = :rol AND o.activo = :activo", Long.class);
        q.setParameter("rol", rol);
        q.setParameter("activo", activo);
        return ((Long) q.getSingleResult());
    }

	public static TypedQuery<Usuario> findUsuariosByApellidoPaternoLike(String apellidoPaterno) {
        if (apellidoPaterno == null || apellidoPaterno.length() == 0) throw new IllegalArgumentException("The apellidoPaterno argument is required");
        apellidoPaterno = apellidoPaterno.replace('*', '%');
        if (apellidoPaterno.charAt(0) != '%') {
            apellidoPaterno = "%" + apellidoPaterno;
        }
        if (apellidoPaterno.charAt(apellidoPaterno.length() - 1) != '%') {
            apellidoPaterno = apellidoPaterno + "%";
        }
        EntityManager em = Usuario.entityManager();
        TypedQuery<Usuario> q = em.createQuery("SELECT o FROM Usuario AS o WHERE LOWER(o.apellidoPaterno) LIKE LOWER(:apellidoPaterno)", Usuario.class);
        q.setParameter("apellidoPaterno", apellidoPaterno);
        return q;
    }

	public static TypedQuery<Usuario> findUsuariosByApellidoPaternoLike(String apellidoPaterno, String sortFieldName, String sortOrder) {
        if (apellidoPaterno == null || apellidoPaterno.length() == 0) throw new IllegalArgumentException("The apellidoPaterno argument is required");
        apellidoPaterno = apellidoPaterno.replace('*', '%');
        if (apellidoPaterno.charAt(0) != '%') {
            apellidoPaterno = "%" + apellidoPaterno;
        }
        if (apellidoPaterno.charAt(apellidoPaterno.length() - 1) != '%') {
            apellidoPaterno = apellidoPaterno + "%";
        }
        EntityManager em = Usuario.entityManager();
        String jpaQuery = "SELECT o FROM Usuario AS o WHERE LOWER(o.apellidoPaterno) LIKE LOWER(:apellidoPaterno)";
        if (fieldNames4OrderClauseFilter.contains(sortFieldName)) {
            jpaQuery = jpaQuery + " ORDER BY " + sortFieldName;
            if ("ASC".equalsIgnoreCase(sortOrder) || "DESC".equalsIgnoreCase(sortOrder)) {
                jpaQuery = jpaQuery + " " + sortOrder;
            }
        }
        TypedQuery<Usuario> q = em.createQuery(jpaQuery, Usuario.class);
        q.setParameter("apellidoPaterno", apellidoPaterno);
        return q;
    }

	public static TypedQuery<Usuario> findUsuariosByEmpresaAndActivo(Empresa empresa, Boolean activo) {
        if (empresa == null) throw new IllegalArgumentException("The empresa argument is required");
        if (activo == null) throw new IllegalArgumentException("The activo argument is required");
        EntityManager em = Usuario.entityManager();
        TypedQuery<Usuario> q = em.createQuery("SELECT o FROM Usuario AS o WHERE o.empresa = :empresa AND o.activo = :activo", Usuario.class);
        q.setParameter("empresa", empresa);
        q.setParameter("activo", activo);
        return q;
    }

	public static TypedQuery<Usuario> findUsuariosByEmpresaAndActivo(Empresa empresa, Boolean activo, String sortFieldName, String sortOrder) {
        if (empresa == null) throw new IllegalArgumentException("The empresa argument is required");
        if (activo == null) throw new IllegalArgumentException("The activo argument is required");
        EntityManager em = Usuario.entityManager();
        String jpaQuery = "SELECT o FROM Usuario AS o WHERE o.empresa = :empresa AND o.activo = :activo";
        if (fieldNames4OrderClauseFilter.contains(sortFieldName)) {
            jpaQuery = jpaQuery + " ORDER BY " + sortFieldName;
            if ("ASC".equalsIgnoreCase(sortOrder) || "DESC".equalsIgnoreCase(sortOrder)) {
                jpaQuery = jpaQuery + " " + sortOrder;
            }
        }
        TypedQuery<Usuario> q = em.createQuery(jpaQuery, Usuario.class);
        q.setParameter("empresa", empresa);
        q.setParameter("activo", activo);
        return q;
    }

	public static TypedQuery<Usuario> findUsuariosByEmpresaAndNombreLikeAndActivo(Empresa empresa, String nombre, Boolean activo) {
        if (empresa == null) throw new IllegalArgumentException("The empresa argument is required");
        if (nombre == null || nombre.length() == 0) throw new IllegalArgumentException("The nombre argument is required");
        nombre = nombre.replace('*', '%');
        if (nombre.charAt(0) != '%') {
            nombre = "%" + nombre;
        }
        if (nombre.charAt(nombre.length() - 1) != '%') {
            nombre = nombre + "%";
        }
        if (activo == null) throw new IllegalArgumentException("The activo argument is required");
        EntityManager em = Usuario.entityManager();
        TypedQuery<Usuario> q = em.createQuery("SELECT o FROM Usuario AS o WHERE o.empresa = :empresa AND LOWER(o.nombre) LIKE LOWER(:nombre)  AND o.activo = :activo", Usuario.class);
        q.setParameter("empresa", empresa);
        q.setParameter("nombre", nombre);
        q.setParameter("activo", activo);
        return q;
    }

	public static TypedQuery<Usuario> findUsuariosByEmpresaAndNombreLikeAndActivo(Empresa empresa, String nombre, Boolean activo, String sortFieldName, String sortOrder) {
        if (empresa == null) throw new IllegalArgumentException("The empresa argument is required");
        if (nombre == null || nombre.length() == 0) throw new IllegalArgumentException("The nombre argument is required");
        nombre = nombre.replace('*', '%');
        if (nombre.charAt(0) != '%') {
            nombre = "%" + nombre;
        }
        if (nombre.charAt(nombre.length() - 1) != '%') {
            nombre = nombre + "%";
        }
        if (activo == null) throw new IllegalArgumentException("The activo argument is required");
        EntityManager em = Usuario.entityManager();
        String jpaQuery = "SELECT o FROM Usuario AS o WHERE o.empresa = :empresa AND LOWER(o.nombre) LIKE LOWER(:nombre)  AND o.activo = :activo";
        if (fieldNames4OrderClauseFilter.contains(sortFieldName)) {
            jpaQuery = jpaQuery + " ORDER BY " + sortFieldName;
            if ("ASC".equalsIgnoreCase(sortOrder) || "DESC".equalsIgnoreCase(sortOrder)) {
                jpaQuery = jpaQuery + " " + sortOrder;
            }
        }
        TypedQuery<Usuario> q = em.createQuery(jpaQuery, Usuario.class);
        q.setParameter("empresa", empresa);
        q.setParameter("nombre", nombre);
        q.setParameter("activo", activo);
        return q;
    }

	public static TypedQuery<Usuario> findUsuariosByEmpresaCorreoELikeAndActivo(Empresa empresa, String correoE, Boolean activo) {
        if (empresa == null) throw new IllegalArgumentException("The empresa argument is required");
        if (correoE == null || correoE.length() == 0) throw new IllegalArgumentException("The correoE argument is required");
        correoE = correoE.replace('*', '%');
        if (correoE.charAt(0) != '%') {
            correoE = "%" + correoE;
        }
        if (correoE.charAt(correoE.length() - 1) != '%') {
            correoE = correoE + "%";
        }
        if (activo == null) throw new IllegalArgumentException("The activo argument is required");
        EntityManager em = Usuario.entityManager();
        TypedQuery<Usuario> q = em.createQuery("SELECT o FROM Usuario AS o WHERE LOWER(o.correoE) LIKE LOWER(:correoE)  AND o.activo = :activo", Usuario.class);
        q.setParameter("empresa", empresa);
        q.setParameter("correoE", correoE);
        q.setParameter("activo", activo);
        return q;
    }

	public static TypedQuery<Usuario> findUsuariosByEmpresaCorreoELikeAndActivo(Empresa empresa, String correoE, Boolean activo, String sortFieldName, String sortOrder) {
        if (empresa == null) throw new IllegalArgumentException("The empresa argument is required");
        if (correoE == null || correoE.length() == 0) throw new IllegalArgumentException("The correoE argument is required");
        correoE = correoE.replace('*', '%');
        if (correoE.charAt(0) != '%') {
            correoE = "%" + correoE;
        }
        if (correoE.charAt(correoE.length() - 1) != '%') {
            correoE = correoE + "%";
        }
        if (activo == null) throw new IllegalArgumentException("The activo argument is required");
        EntityManager em = Usuario.entityManager();
        String jpaQuery = "SELECT o FROM Usuario AS o WHERE LOWER(o.correoE) LIKE LOWER(:correoE)  AND o.activo = :activo";
        if (fieldNames4OrderClauseFilter.contains(sortFieldName)) {
            jpaQuery = jpaQuery + " ORDER BY " + sortFieldName;
            if ("ASC".equalsIgnoreCase(sortOrder) || "DESC".equalsIgnoreCase(sortOrder)) {
                jpaQuery = jpaQuery + " " + sortOrder;
            }
        }
        TypedQuery<Usuario> q = em.createQuery(jpaQuery, Usuario.class);
        q.setParameter("empresa", empresa);
        q.setParameter("correoE", correoE);
        q.setParameter("activo", activo);
        return q;
    }

	public static TypedQuery<Usuario> findUsuariosByRolAndActivo(Rol rol, Boolean activo) {
        if (rol == null) throw new IllegalArgumentException("The rol argument is required");
        if (activo == null) throw new IllegalArgumentException("The activo argument is required");
        EntityManager em = Usuario.entityManager();
        TypedQuery<Usuario> q = em.createQuery("SELECT o FROM Usuario AS o WHERE o.rol = :rol AND o.activo = :activo", Usuario.class);
        q.setParameter("rol", rol);
        q.setParameter("activo", activo);
        return q;
    }

	public static TypedQuery<Usuario> findUsuariosByRolAndActivo(Rol rol, Boolean activo, String sortFieldName, String sortOrder) {
        if (rol == null) throw new IllegalArgumentException("The rol argument is required");
        if (activo == null) throw new IllegalArgumentException("The activo argument is required");
        EntityManager em = Usuario.entityManager();
        String jpaQuery = "SELECT o FROM Usuario AS o WHERE o.rol = :rol AND o.activo = :activo";
        if (fieldNames4OrderClauseFilter.contains(sortFieldName)) {
            jpaQuery = jpaQuery + " ORDER BY " + sortFieldName;
            if ("ASC".equalsIgnoreCase(sortOrder) || "DESC".equalsIgnoreCase(sortOrder)) {
                jpaQuery = jpaQuery + " " + sortOrder;
            }
        }
        TypedQuery<Usuario> q = em.createQuery(jpaQuery, Usuario.class);
        q.setParameter("rol", rol);
        q.setParameter("activo", activo);
        return q;
    }
}
