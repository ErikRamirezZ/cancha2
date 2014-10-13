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
@RooJpaActiveRecord(finders = { "findStatusPartidoesByActivo" })
@RooJson(deepSerialize = true)
public class StatusPartido {

    /**
     */
    @NotNull
    private String nombreStatusPartido;

    /**
     */
    @NotNull
    private String descripcion;

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

	public static final List<String> fieldNames4OrderClauseFilter = java.util.Arrays.asList("nombreStatusPartido", "descripcion", "activo", "usuario", "fechaCreacion", "fechaModificacion");

	public static final EntityManager entityManager() {
        EntityManager em = new StatusPartido().entityManager;
        if (em == null) throw new IllegalStateException("Entity manager has not been injected (is the Spring Aspects JAR configured as an AJC/AJDT aspects library?)");
        return em;
    }

	public static long countStatusPartidoes() {
        return entityManager().createQuery("SELECT COUNT(o) FROM StatusPartido o", Long.class).getSingleResult();
    }

	public static List<StatusPartido> findAllStatusPartidoes() {
        return entityManager().createQuery("SELECT o FROM StatusPartido o", StatusPartido.class).getResultList();
    }

	public static List<StatusPartido> findAllStatusPartidoes(String sortFieldName, String sortOrder) {
        String jpaQuery = "SELECT o FROM StatusPartido o";
        if (fieldNames4OrderClauseFilter.contains(sortFieldName)) {
            jpaQuery = jpaQuery + " ORDER BY " + sortFieldName;
            if ("ASC".equalsIgnoreCase(sortOrder) || "DESC".equalsIgnoreCase(sortOrder)) {
                jpaQuery = jpaQuery + " " + sortOrder;
            }
        }
        return entityManager().createQuery(jpaQuery, StatusPartido.class).getResultList();
    }

	public static StatusPartido findStatusPartido(Long id) {
        if (id == null) return null;
        return entityManager().find(StatusPartido.class, id);
    }

	public static List<StatusPartido> findStatusPartidoEntries(int firstResult, int maxResults) {
        return entityManager().createQuery("SELECT o FROM StatusPartido o", StatusPartido.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }

	public static List<StatusPartido> findStatusPartidoEntries(int firstResult, int maxResults, String sortFieldName, String sortOrder) {
        String jpaQuery = "SELECT o FROM StatusPartido o";
        if (fieldNames4OrderClauseFilter.contains(sortFieldName)) {
            jpaQuery = jpaQuery + " ORDER BY " + sortFieldName;
            if ("ASC".equalsIgnoreCase(sortOrder) || "DESC".equalsIgnoreCase(sortOrder)) {
                jpaQuery = jpaQuery + " " + sortOrder;
            }
        }
        return entityManager().createQuery(jpaQuery, StatusPartido.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
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
            StatusPartido attached = StatusPartido.findStatusPartido(this.id);
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
    public StatusPartido merge() {
        if (this.entityManager == null) this.entityManager = entityManager();
        StatusPartido merged = this.entityManager.merge(this);
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

	public static StatusPartido fromJsonToStatusPartido(String json) {
        return new JSONDeserializer<StatusPartido>()
        .use(null, StatusPartido.class).deserialize(json);
    }

	public static String toJsonArray(Collection<StatusPartido> collection) {
        return new JSONSerializer()
        .exclude("*.class").deepSerialize(collection);
    }

	public static String toJsonArray(Collection<StatusPartido> collection, String[] fields) {
        return new JSONSerializer()
        .include(fields).exclude("*.class").deepSerialize(collection);
    }

	public static Collection<StatusPartido> fromJsonArrayToStatusPartidoes(String json) {
        return new JSONDeserializer<List<StatusPartido>>()
        .use("values", StatusPartido.class).deserialize(json);
    }

	public String toString() {
        return ReflectionToStringBuilder.toString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }

	public static Long countFindStatusPartidoesByActivo(Boolean activo) {
        if (activo == null) throw new IllegalArgumentException("The activo argument is required");
        EntityManager em = StatusPartido.entityManager();
        TypedQuery q = em.createQuery("SELECT COUNT(o) FROM StatusPartido AS o WHERE o.activo = :activo", Long.class);
        q.setParameter("activo", activo);
        return ((Long) q.getSingleResult());
    }

	public static TypedQuery<StatusPartido> findStatusPartidoesByActivo(Boolean activo) {
        if (activo == null) throw new IllegalArgumentException("The activo argument is required");
        EntityManager em = StatusPartido.entityManager();
        TypedQuery<StatusPartido> q = em.createQuery("SELECT o FROM StatusPartido AS o WHERE o.activo = :activo", StatusPartido.class);
        q.setParameter("activo", activo);
        return q;
    }

	public static TypedQuery<StatusPartido> findStatusPartidoesByActivo(Boolean activo, String sortFieldName, String sortOrder) {
        if (activo == null) throw new IllegalArgumentException("The activo argument is required");
        EntityManager em = StatusPartido.entityManager();
        String jpaQuery = "SELECT o FROM StatusPartido AS o WHERE o.activo = :activo";
        if (fieldNames4OrderClauseFilter.contains(sortFieldName)) {
            jpaQuery = jpaQuery + " ORDER BY " + sortFieldName;
            if ("ASC".equalsIgnoreCase(sortOrder) || "DESC".equalsIgnoreCase(sortOrder)) {
                jpaQuery = jpaQuery + " " + sortOrder;
            }
        }
        TypedQuery<StatusPartido> q = em.createQuery(jpaQuery, StatusPartido.class);
        q.setParameter("activo", activo);
        return q;
    }

	public String getNombreStatusPartido() {
        return this.nombreStatusPartido;
    }

	public void setNombreStatusPartido(String nombreStatusPartido) {
        this.nombreStatusPartido = nombreStatusPartido;
    }

	public String getDescripcion() {
        return this.descripcion;
    }

	public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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
}
