package com.raze.cancha.catalog;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;
import javax.validation.constraints.NotNull;
import com.raze.cancha.domain.Usuario;
import flexjson.JSONDeserializer;
import flexjson.JSONSerializer;
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

@Configurable
@Entity
@RooJavaBean
@RooToString
@RooJpaActiveRecord(finders = { "findFechaVencimientoTCsByActivo" })
@RooJson(deepSerialize = true)
public class FechaVencimientoTC {

    /**
     */
    @NotNull
    private String nombreFechaVencimientoTC;

    /**
     */
    @NotNull
    private String descripcion;

    /**
     */
    @NotNull
    private int mes;

    /**
     */
    @NotNull
    private int anio;

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

	public String getNombreFechaVencimientoTC() {
        return this.nombreFechaVencimientoTC;
    }

	public void setNombreFechaVencimientoTC(String nombreFechaVencimientoTC) {
        this.nombreFechaVencimientoTC = nombreFechaVencimientoTC;
    }

	public String getDescripcion() {
        return this.descripcion;
    }

	public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

	public int getMes() {
        return this.mes;
    }

	public void setMes(int mes) {
        this.mes = mes;
    }

	public int getAnio() {
        return this.anio;
    }

	public void setAnio(int anio) {
        this.anio = anio;
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

	@PersistenceContext
    transient EntityManager entityManager;

	public static final List<String> fieldNames4OrderClauseFilter = java.util.Arrays.asList("nombreFechaVencimientoTC", "descripcion", "mes", "anio", "activo", "usuario", "fechaCreacion", "fechaModificacion");

	public static final EntityManager entityManager() {
        EntityManager em = new FechaVencimientoTC().entityManager;
        if (em == null) throw new IllegalStateException("Entity manager has not been injected (is the Spring Aspects JAR configured as an AJC/AJDT aspects library?)");
        return em;
    }

	public static long countFechaVencimientoTCs() {
        return entityManager().createQuery("SELECT COUNT(o) FROM FechaVencimientoTC o", Long.class).getSingleResult();
    }

	public static List<FechaVencimientoTC> findAllFechaVencimientoTCs() {
        return entityManager().createQuery("SELECT o FROM FechaVencimientoTC o", FechaVencimientoTC.class).getResultList();
    }

	public static List<FechaVencimientoTC> findAllFechaVencimientoTCs(String sortFieldName, String sortOrder) {
        String jpaQuery = "SELECT o FROM FechaVencimientoTC o";
        if (fieldNames4OrderClauseFilter.contains(sortFieldName)) {
            jpaQuery = jpaQuery + " ORDER BY " + sortFieldName;
            if ("ASC".equalsIgnoreCase(sortOrder) || "DESC".equalsIgnoreCase(sortOrder)) {
                jpaQuery = jpaQuery + " " + sortOrder;
            }
        }
        return entityManager().createQuery(jpaQuery, FechaVencimientoTC.class).getResultList();
    }

	public static FechaVencimientoTC findFechaVencimientoTC(Long id) {
        if (id == null) return null;
        return entityManager().find(FechaVencimientoTC.class, id);
    }

	public static List<FechaVencimientoTC> findFechaVencimientoTCEntries(int firstResult, int maxResults) {
        return entityManager().createQuery("SELECT o FROM FechaVencimientoTC o", FechaVencimientoTC.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }

	public static List<FechaVencimientoTC> findFechaVencimientoTCEntries(int firstResult, int maxResults, String sortFieldName, String sortOrder) {
        String jpaQuery = "SELECT o FROM FechaVencimientoTC o";
        if (fieldNames4OrderClauseFilter.contains(sortFieldName)) {
            jpaQuery = jpaQuery + " ORDER BY " + sortFieldName;
            if ("ASC".equalsIgnoreCase(sortOrder) || "DESC".equalsIgnoreCase(sortOrder)) {
                jpaQuery = jpaQuery + " " + sortOrder;
            }
        }
        return entityManager().createQuery(jpaQuery, FechaVencimientoTC.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
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
            FechaVencimientoTC attached = FechaVencimientoTC.findFechaVencimientoTC(this.id);
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
    public FechaVencimientoTC merge() {
        if (this.entityManager == null) this.entityManager = entityManager();
        FechaVencimientoTC merged = this.entityManager.merge(this);
        this.entityManager.flush();
        return merged;
    }

	public String toString() {
        return ReflectionToStringBuilder.toString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }

	public String toJson() {
        return new JSONSerializer()
        .exclude("*.class").deepSerialize(this);
    }

	public String toJson(String[] fields) {
        return new JSONSerializer()
        .include(fields).exclude("*.class").deepSerialize(this);
    }

	public static FechaVencimientoTC fromJsonToFechaVencimientoTC(String json) {
        return new JSONDeserializer<FechaVencimientoTC>()
        .use(null, FechaVencimientoTC.class).deserialize(json);
    }

	public static String toJsonArray(Collection<FechaVencimientoTC> collection) {
        return new JSONSerializer()
        .exclude("*.class").deepSerialize(collection);
    }

	public static String toJsonArray(Collection<FechaVencimientoTC> collection, String[] fields) {
        return new JSONSerializer()
        .include(fields).exclude("*.class").deepSerialize(collection);
    }

	public static Collection<FechaVencimientoTC> fromJsonArrayToFechaVencimientoTCs(String json) {
        return new JSONDeserializer<List<FechaVencimientoTC>>()
        .use("values", FechaVencimientoTC.class).deserialize(json);
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

	public static Long countFindFechaVencimientoTCsByActivo(Boolean activo) {
        if (activo == null) throw new IllegalArgumentException("The activo argument is required");
        EntityManager em = FechaVencimientoTC.entityManager();
        TypedQuery q = em.createQuery("SELECT COUNT(o) FROM FechaVencimientoTC AS o WHERE o.activo = :activo", Long.class);
        q.setParameter("activo", activo);
        return ((Long) q.getSingleResult());
    }

	public static TypedQuery<FechaVencimientoTC> findFechaVencimientoTCsByActivo(Boolean activo) {
        if (activo == null) throw new IllegalArgumentException("The activo argument is required");
        EntityManager em = FechaVencimientoTC.entityManager();
        TypedQuery<FechaVencimientoTC> q = em.createQuery("SELECT o FROM FechaVencimientoTC AS o WHERE o.activo = :activo", FechaVencimientoTC.class);
        q.setParameter("activo", activo);
        return q;
    }

	public static TypedQuery<FechaVencimientoTC> findFechaVencimientoTCsByActivo(Boolean activo, String sortFieldName, String sortOrder) {
        if (activo == null) throw new IllegalArgumentException("The activo argument is required");
        EntityManager em = FechaVencimientoTC.entityManager();
        String jpaQuery = "SELECT o FROM FechaVencimientoTC AS o WHERE o.activo = :activo";
        if (fieldNames4OrderClauseFilter.contains(sortFieldName)) {
            jpaQuery = jpaQuery + " ORDER BY " + sortFieldName;
            if ("ASC".equalsIgnoreCase(sortOrder) || "DESC".equalsIgnoreCase(sortOrder)) {
                jpaQuery = jpaQuery + " " + sortOrder;
            }
        }
        TypedQuery<FechaVencimientoTC> q = em.createQuery(jpaQuery, FechaVencimientoTC.class);
        q.setParameter("activo", activo);
        return q;
    }
}
