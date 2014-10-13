package com.raze.cancha.domain;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;
import flexjson.JSONDeserializer;
import flexjson.JSONSerializer;
import javax.validation.constraints.NotNull;
import javax.persistence.Lob;
import org.springframework.roo.classpath.operations.jsr303.RooUploadedFile;
import javax.persistence.ManyToOne;
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
import org.springframework.roo.addon.json.RooJson;
import org.springframework.transaction.annotation.Transactional;

@Entity
@Configurable
@RooJavaBean
@RooToString
@RooJpaActiveRecord(finders = { "findEmpresasByActivo", "findEmpresasByNombreComercialLikeAndActivo", "findEmpresasByNombreLikeAndActivo" })
@RooJson(deepSerialize = true)
public class Empresa {

    /**
     */
    @NotNull
    private String nombre;

    /**
     */
    private String nombreComercial;

    /**
     */
    private String domicilio;

    /**
     */
    private String telefono;

    /**
     */
    private String correoE;

    /**
     */
    @RooUploadedFile(contentType = "image/jpeg", autoUpload = true)
    @Lob
    private byte[] logo;

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

	public static Long countFindEmpresasByActivo(Boolean activo) {
        if (activo == null) throw new IllegalArgumentException("The activo argument is required");
        EntityManager em = Empresa.entityManager();
        TypedQuery q = em.createQuery("SELECT COUNT(o) FROM Empresa AS o WHERE o.activo = :activo", Long.class);
        q.setParameter("activo", activo);
        return ((Long) q.getSingleResult());
    }

	public static Long countFindEmpresasByNombreComercialLikeAndActivo(String nombreComercial, Boolean activo) {
        if (nombreComercial == null || nombreComercial.length() == 0) throw new IllegalArgumentException("The nombreComercial argument is required");
        nombreComercial = nombreComercial.replace('*', '%');
        if (nombreComercial.charAt(0) != '%') {
            nombreComercial = "%" + nombreComercial;
        }
        if (nombreComercial.charAt(nombreComercial.length() - 1) != '%') {
            nombreComercial = nombreComercial + "%";
        }
        if (activo == null) throw new IllegalArgumentException("The activo argument is required");
        EntityManager em = Empresa.entityManager();
        TypedQuery q = em.createQuery("SELECT COUNT(o) FROM Empresa AS o WHERE LOWER(o.nombreComercial) LIKE LOWER(:nombreComercial)  AND o.activo = :activo", Long.class);
        q.setParameter("nombreComercial", nombreComercial);
        q.setParameter("activo", activo);
        return ((Long) q.getSingleResult());
    }

	public static Long countFindEmpresasByNombreLikeAndActivo(String nombre, Boolean activo) {
        if (nombre == null || nombre.length() == 0) throw new IllegalArgumentException("The nombre argument is required");
        nombre = nombre.replace('*', '%');
        if (nombre.charAt(0) != '%') {
            nombre = "%" + nombre;
        }
        if (nombre.charAt(nombre.length() - 1) != '%') {
            nombre = nombre + "%";
        }
        if (activo == null) throw new IllegalArgumentException("The activo argument is required");
        EntityManager em = Empresa.entityManager();
        TypedQuery q = em.createQuery("SELECT COUNT(o) FROM Empresa AS o WHERE LOWER(o.nombre) LIKE LOWER(:nombre)  AND o.activo = :activo", Long.class);
        q.setParameter("nombre", nombre);
        q.setParameter("activo", activo);
        return ((Long) q.getSingleResult());
    }

	public static TypedQuery<Empresa> findEmpresasByActivo(Boolean activo) {
        if (activo == null) throw new IllegalArgumentException("The activo argument is required");
        EntityManager em = Empresa.entityManager();
        TypedQuery<Empresa> q = em.createQuery("SELECT o FROM Empresa AS o WHERE o.activo = :activo", Empresa.class);
        q.setParameter("activo", activo);
        return q;
    }

	public static TypedQuery<Empresa> findEmpresasByActivo(Boolean activo, String sortFieldName, String sortOrder) {
        if (activo == null) throw new IllegalArgumentException("The activo argument is required");
        EntityManager em = Empresa.entityManager();
        String jpaQuery = "SELECT o FROM Empresa AS o WHERE o.activo = :activo";
        if (fieldNames4OrderClauseFilter.contains(sortFieldName)) {
            jpaQuery = jpaQuery + " ORDER BY " + sortFieldName;
            if ("ASC".equalsIgnoreCase(sortOrder) || "DESC".equalsIgnoreCase(sortOrder)) {
                jpaQuery = jpaQuery + " " + sortOrder;
            }
        }
        TypedQuery<Empresa> q = em.createQuery(jpaQuery, Empresa.class);
        q.setParameter("activo", activo);
        return q;
    }

	public static TypedQuery<Empresa> findEmpresasByNombreComercialLikeAndActivo(String nombreComercial, Boolean activo) {
        if (nombreComercial == null || nombreComercial.length() == 0) throw new IllegalArgumentException("The nombreComercial argument is required");
        nombreComercial = nombreComercial.replace('*', '%');
        if (nombreComercial.charAt(0) != '%') {
            nombreComercial = "%" + nombreComercial;
        }
        if (nombreComercial.charAt(nombreComercial.length() - 1) != '%') {
            nombreComercial = nombreComercial + "%";
        }
        if (activo == null) throw new IllegalArgumentException("The activo argument is required");
        EntityManager em = Empresa.entityManager();
        TypedQuery<Empresa> q = em.createQuery("SELECT o FROM Empresa AS o WHERE LOWER(o.nombreComercial) LIKE LOWER(:nombreComercial)  AND o.activo = :activo", Empresa.class);
        q.setParameter("nombreComercial", nombreComercial);
        q.setParameter("activo", activo);
        return q;
    }

	public static TypedQuery<Empresa> findEmpresasByNombreComercialLikeAndActivo(String nombreComercial, Boolean activo, String sortFieldName, String sortOrder) {
        if (nombreComercial == null || nombreComercial.length() == 0) throw new IllegalArgumentException("The nombreComercial argument is required");
        nombreComercial = nombreComercial.replace('*', '%');
        if (nombreComercial.charAt(0) != '%') {
            nombreComercial = "%" + nombreComercial;
        }
        if (nombreComercial.charAt(nombreComercial.length() - 1) != '%') {
            nombreComercial = nombreComercial + "%";
        }
        if (activo == null) throw new IllegalArgumentException("The activo argument is required");
        EntityManager em = Empresa.entityManager();
        String jpaQuery = "SELECT o FROM Empresa AS o WHERE LOWER(o.nombreComercial) LIKE LOWER(:nombreComercial)  AND o.activo = :activo";
        if (fieldNames4OrderClauseFilter.contains(sortFieldName)) {
            jpaQuery = jpaQuery + " ORDER BY " + sortFieldName;
            if ("ASC".equalsIgnoreCase(sortOrder) || "DESC".equalsIgnoreCase(sortOrder)) {
                jpaQuery = jpaQuery + " " + sortOrder;
            }
        }
        TypedQuery<Empresa> q = em.createQuery(jpaQuery, Empresa.class);
        q.setParameter("nombreComercial", nombreComercial);
        q.setParameter("activo", activo);
        return q;
    }

	public static TypedQuery<Empresa> findEmpresasByNombreLikeAndActivo(String nombre, Boolean activo) {
        if (nombre == null || nombre.length() == 0) throw new IllegalArgumentException("The nombre argument is required");
        nombre = nombre.replace('*', '%');
        if (nombre.charAt(0) != '%') {
            nombre = "%" + nombre;
        }
        if (nombre.charAt(nombre.length() - 1) != '%') {
            nombre = nombre + "%";
        }
        if (activo == null) throw new IllegalArgumentException("The activo argument is required");
        EntityManager em = Empresa.entityManager();
        TypedQuery<Empresa> q = em.createQuery("SELECT o FROM Empresa AS o WHERE LOWER(o.nombre) LIKE LOWER(:nombre)  AND o.activo = :activo", Empresa.class);
        q.setParameter("nombre", nombre);
        q.setParameter("activo", activo);
        return q;
    }

	public static TypedQuery<Empresa> findEmpresasByNombreLikeAndActivo(String nombre, Boolean activo, String sortFieldName, String sortOrder) {
        if (nombre == null || nombre.length() == 0) throw new IllegalArgumentException("The nombre argument is required");
        nombre = nombre.replace('*', '%');
        if (nombre.charAt(0) != '%') {
            nombre = "%" + nombre;
        }
        if (nombre.charAt(nombre.length() - 1) != '%') {
            nombre = nombre + "%";
        }
        if (activo == null) throw new IllegalArgumentException("The activo argument is required");
        EntityManager em = Empresa.entityManager();
        String jpaQuery = "SELECT o FROM Empresa AS o WHERE LOWER(o.nombre) LIKE LOWER(:nombre)  AND o.activo = :activo";
        if (fieldNames4OrderClauseFilter.contains(sortFieldName)) {
            jpaQuery = jpaQuery + " ORDER BY " + sortFieldName;
            if ("ASC".equalsIgnoreCase(sortOrder) || "DESC".equalsIgnoreCase(sortOrder)) {
                jpaQuery = jpaQuery + " " + sortOrder;
            }
        }
        TypedQuery<Empresa> q = em.createQuery(jpaQuery, Empresa.class);
        q.setParameter("nombre", nombre);
        q.setParameter("activo", activo);
        return q;
    }

	public String toString() {
        return ReflectionToStringBuilder.toString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }

	public String getNombre() {
        return this.nombre;
    }

	public void setNombre(String nombre) {
        this.nombre = nombre;
    }

	public String getNombreComercial() {
        return this.nombreComercial;
    }

	public void setNombreComercial(String nombreComercial) {
        this.nombreComercial = nombreComercial;
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

	public String getCorreoE() {
        return this.correoE;
    }

	public void setCorreoE(String correoE) {
        this.correoE = correoE;
    }

	public byte[] getLogo() {
        return this.logo;
    }

	public void setLogo(byte[] logo) {
        this.logo = logo;
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

	@PersistenceContext
    transient EntityManager entityManager;

	public static final List<String> fieldNames4OrderClauseFilter = java.util.Arrays.asList("nombre", "nombreComercial", "domicilio", "telefono", "correoE", "logo", "activo", "usuario", "fechaCreacion", "fechaModificacion");

	public static final EntityManager entityManager() {
        EntityManager em = new Empresa().entityManager;
        if (em == null) throw new IllegalStateException("Entity manager has not been injected (is the Spring Aspects JAR configured as an AJC/AJDT aspects library?)");
        return em;
    }

	public static long countEmpresas() {
        return entityManager().createQuery("SELECT COUNT(o) FROM Empresa o", Long.class).getSingleResult();
    }

	public static List<Empresa> findAllEmpresas() {
        return entityManager().createQuery("SELECT o FROM Empresa o", Empresa.class).getResultList();
    }

	public static List<Empresa> findAllEmpresas(String sortFieldName, String sortOrder) {
        String jpaQuery = "SELECT o FROM Empresa o";
        if (fieldNames4OrderClauseFilter.contains(sortFieldName)) {
            jpaQuery = jpaQuery + " ORDER BY " + sortFieldName;
            if ("ASC".equalsIgnoreCase(sortOrder) || "DESC".equalsIgnoreCase(sortOrder)) {
                jpaQuery = jpaQuery + " " + sortOrder;
            }
        }
        return entityManager().createQuery(jpaQuery, Empresa.class).getResultList();
    }

	public static Empresa findEmpresa(Long id) {
        if (id == null) return null;
        return entityManager().find(Empresa.class, id);
    }

	public static List<Empresa> findEmpresaEntries(int firstResult, int maxResults) {
        return entityManager().createQuery("SELECT o FROM Empresa o", Empresa.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }

	public static List<Empresa> findEmpresaEntries(int firstResult, int maxResults, String sortFieldName, String sortOrder) {
        String jpaQuery = "SELECT o FROM Empresa o";
        if (fieldNames4OrderClauseFilter.contains(sortFieldName)) {
            jpaQuery = jpaQuery + " ORDER BY " + sortFieldName;
            if ("ASC".equalsIgnoreCase(sortOrder) || "DESC".equalsIgnoreCase(sortOrder)) {
                jpaQuery = jpaQuery + " " + sortOrder;
            }
        }
        return entityManager().createQuery(jpaQuery, Empresa.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
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
            Empresa attached = Empresa.findEmpresa(this.id);
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
    public Empresa merge() {
        if (this.entityManager == null) this.entityManager = entityManager();
        Empresa merged = this.entityManager.merge(this);
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

	public static Empresa fromJsonToEmpresa(String json) {
        return new JSONDeserializer<Empresa>()
        .use(null, Empresa.class).deserialize(json);
    }

	public static String toJsonArray(Collection<Empresa> collection) {
        return new JSONSerializer()
        .exclude("*.class").deepSerialize(collection);
    }

	public static String toJsonArray(Collection<Empresa> collection, String[] fields) {
        return new JSONSerializer()
        .include(fields).exclude("*.class").deepSerialize(collection);
    }

	public static Collection<Empresa> fromJsonArrayToEmpresas(String json) {
        return new JSONDeserializer<List<Empresa>>()
        .use("values", Empresa.class).deserialize(json);
    }
}
