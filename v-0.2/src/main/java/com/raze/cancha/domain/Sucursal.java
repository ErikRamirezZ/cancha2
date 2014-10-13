package com.raze.cancha.domain;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;
import flexjson.JSONDeserializer;
import flexjson.JSONSerializer;
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
import org.springframework.roo.addon.json.RooJson;
import org.springframework.transaction.annotation.Transactional;

@Entity
@Configurable
@RooJavaBean
@RooToString
@RooJpaActiveRecord(finders = { "findSucursalsByEmpresaAndActivo" })
@RooJson(deepSerialize = true)
public class Sucursal {

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
    private String domicilio;

    /**
     */
    private String telefono;

    /**
     */
    private String correoE;

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

	public static Long countFindSucursalsByEmpresaAndActivo(Empresa empresa, Boolean activo) {
        if (empresa == null) throw new IllegalArgumentException("The empresa argument is required");
        if (activo == null) throw new IllegalArgumentException("The activo argument is required");
        EntityManager em = Sucursal.entityManager();
        TypedQuery q = em.createQuery("SELECT COUNT(o) FROM Sucursal AS o WHERE o.empresa = :empresa AND o.activo = :activo", Long.class);
        q.setParameter("empresa", empresa);
        q.setParameter("activo", activo);
        return ((Long) q.getSingleResult());
    }

	public static TypedQuery<Sucursal> findSucursalsByEmpresaAndActivo(Empresa empresa, Boolean activo) {
        if (empresa == null) throw new IllegalArgumentException("The empresa argument is required");
        if (activo == null) throw new IllegalArgumentException("The activo argument is required");
        EntityManager em = Sucursal.entityManager();
        TypedQuery<Sucursal> q = em.createQuery("SELECT o FROM Sucursal AS o WHERE o.empresa = :empresa AND o.activo = :activo", Sucursal.class);
        q.setParameter("empresa", empresa);
        q.setParameter("activo", activo);
        return q;
    }

	public static TypedQuery<Sucursal> findSucursalsByEmpresaAndActivo(Empresa empresa, Boolean activo, String sortFieldName, String sortOrder) {
        if (empresa == null) throw new IllegalArgumentException("The empresa argument is required");
        if (activo == null) throw new IllegalArgumentException("The activo argument is required");
        EntityManager em = Sucursal.entityManager();
        String jpaQuery = "SELECT o FROM Sucursal AS o WHERE o.empresa = :empresa AND o.activo = :activo";
        if (fieldNames4OrderClauseFilter.contains(sortFieldName)) {
            jpaQuery = jpaQuery + " ORDER BY " + sortFieldName;
            if ("ASC".equalsIgnoreCase(sortOrder) || "DESC".equalsIgnoreCase(sortOrder)) {
                jpaQuery = jpaQuery + " " + sortOrder;
            }
        }
        TypedQuery<Sucursal> q = em.createQuery(jpaQuery, Sucursal.class);
        q.setParameter("empresa", empresa);
        q.setParameter("activo", activo);
        return q;
    }

	public String toJson() {
        return new JSONSerializer()
        .exclude("*.class").deepSerialize(this);
    }

	public String toJson(String[] fields) {
        return new JSONSerializer()
        .include(fields).exclude("*.class").deepSerialize(this);
    }

	public static Sucursal fromJsonToSucursal(String json) {
        return new JSONDeserializer<Sucursal>()
        .use(null, Sucursal.class).deserialize(json);
    }

	public static String toJsonArray(Collection<Sucursal> collection) {
        return new JSONSerializer()
        .exclude("*.class").deepSerialize(collection);
    }

	public static String toJsonArray(Collection<Sucursal> collection, String[] fields) {
        return new JSONSerializer()
        .include(fields).exclude("*.class").deepSerialize(collection);
    }

	public static Collection<Sucursal> fromJsonArrayToSucursals(String json) {
        return new JSONDeserializer<List<Sucursal>>()
        .use("values", Sucursal.class).deserialize(json);
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

	public String toString() {
        return ReflectionToStringBuilder.toString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }

	@PersistenceContext
    transient EntityManager entityManager;

	public static final List<String> fieldNames4OrderClauseFilter = java.util.Arrays.asList("empresa", "nombre", "domicilio", "telefono", "correoE", "activo", "usuario", "fechaCreacion", "fechaModificacion");

	public static final EntityManager entityManager() {
        EntityManager em = new Sucursal().entityManager;
        if (em == null) throw new IllegalStateException("Entity manager has not been injected (is the Spring Aspects JAR configured as an AJC/AJDT aspects library?)");
        return em;
    }

	public static long countSucursals() {
        return entityManager().createQuery("SELECT COUNT(o) FROM Sucursal o", Long.class).getSingleResult();
    }

	public static List<Sucursal> findAllSucursals() {
        return entityManager().createQuery("SELECT o FROM Sucursal o", Sucursal.class).getResultList();
    }

	public static List<Sucursal> findAllSucursals(String sortFieldName, String sortOrder) {
        String jpaQuery = "SELECT o FROM Sucursal o";
        if (fieldNames4OrderClauseFilter.contains(sortFieldName)) {
            jpaQuery = jpaQuery + " ORDER BY " + sortFieldName;
            if ("ASC".equalsIgnoreCase(sortOrder) || "DESC".equalsIgnoreCase(sortOrder)) {
                jpaQuery = jpaQuery + " " + sortOrder;
            }
        }
        return entityManager().createQuery(jpaQuery, Sucursal.class).getResultList();
    }

	public static Sucursal findSucursal(Long id) {
        if (id == null) return null;
        return entityManager().find(Sucursal.class, id);
    }

	public static List<Sucursal> findSucursalEntries(int firstResult, int maxResults) {
        return entityManager().createQuery("SELECT o FROM Sucursal o", Sucursal.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }

	public static List<Sucursal> findSucursalEntries(int firstResult, int maxResults, String sortFieldName, String sortOrder) {
        String jpaQuery = "SELECT o FROM Sucursal o";
        if (fieldNames4OrderClauseFilter.contains(sortFieldName)) {
            jpaQuery = jpaQuery + " ORDER BY " + sortFieldName;
            if ("ASC".equalsIgnoreCase(sortOrder) || "DESC".equalsIgnoreCase(sortOrder)) {
                jpaQuery = jpaQuery + " " + sortOrder;
            }
        }
        return entityManager().createQuery(jpaQuery, Sucursal.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
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
            Sucursal attached = Sucursal.findSucursal(this.id);
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
    public Sucursal merge() {
        if (this.entityManager == null) this.entityManager = entityManager();
        Sucursal merged = this.entityManager.merge(this);
        this.entityManager.flush();
        return merged;
    }
}
