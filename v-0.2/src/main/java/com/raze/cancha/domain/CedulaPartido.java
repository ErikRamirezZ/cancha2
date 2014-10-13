package com.raze.cancha.domain;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import com.raze.cancha.catalog.StatusCedula;
import flexjson.JSONDeserializer;
import flexjson.JSONSerializer;
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
@RooJpaActiveRecord(finders = { "findCedulaPartidoesByPartido", "findCedulaPartidoesByPartidoAndStatus" })
@RooJson(deepSerialize = true)
public class CedulaPartido {

    /**
     */
    @NotNull
    @ManyToOne
    private Partido partido;

    /**
     */
    private int marcadorEquipoLocal;

    /**
     */
    private int marcadorEquipoVisitante;

    /**
     */
    private String observaciones;

    /**
     */
    @NotNull
    @ManyToOne
    private StatusCedula status;

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

	public Partido getPartido() {
        return this.partido;
    }

	public void setPartido(Partido partido) {
        this.partido = partido;
    }

	public int getMarcadorEquipoLocal() {
        return this.marcadorEquipoLocal;
    }

	public void setMarcadorEquipoLocal(int marcadorEquipoLocal) {
        this.marcadorEquipoLocal = marcadorEquipoLocal;
    }

	public int getMarcadorEquipoVisitante() {
        return this.marcadorEquipoVisitante;
    }

	public void setMarcadorEquipoVisitante(int marcadorEquipoVisitante) {
        this.marcadorEquipoVisitante = marcadorEquipoVisitante;
    }

	public String getObservaciones() {
        return this.observaciones;
    }

	public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

	public StatusCedula getStatus() {
        return this.status;
    }

	public void setStatus(StatusCedula status) {
        this.status = status;
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

	public static final List<String> fieldNames4OrderClauseFilter = java.util.Arrays.asList("partido", "marcadorEquipoLocal", "marcadorEquipoVisitante", "observaciones", "status", "usuario", "fechaCreacion", "fechaModificacion");

	public static final EntityManager entityManager() {
        EntityManager em = new CedulaPartido().entityManager;
        if (em == null) throw new IllegalStateException("Entity manager has not been injected (is the Spring Aspects JAR configured as an AJC/AJDT aspects library?)");
        return em;
    }

	public static long countCedulaPartidoes() {
        return entityManager().createQuery("SELECT COUNT(o) FROM CedulaPartido o", Long.class).getSingleResult();
    }

	public static List<CedulaPartido> findAllCedulaPartidoes() {
        return entityManager().createQuery("SELECT o FROM CedulaPartido o", CedulaPartido.class).getResultList();
    }

	public static List<CedulaPartido> findAllCedulaPartidoes(String sortFieldName, String sortOrder) {
        String jpaQuery = "SELECT o FROM CedulaPartido o";
        if (fieldNames4OrderClauseFilter.contains(sortFieldName)) {
            jpaQuery = jpaQuery + " ORDER BY " + sortFieldName;
            if ("ASC".equalsIgnoreCase(sortOrder) || "DESC".equalsIgnoreCase(sortOrder)) {
                jpaQuery = jpaQuery + " " + sortOrder;
            }
        }
        return entityManager().createQuery(jpaQuery, CedulaPartido.class).getResultList();
    }

	public static CedulaPartido findCedulaPartido(Long id) {
        if (id == null) return null;
        return entityManager().find(CedulaPartido.class, id);
    }

	public static List<CedulaPartido> findCedulaPartidoEntries(int firstResult, int maxResults) {
        return entityManager().createQuery("SELECT o FROM CedulaPartido o", CedulaPartido.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }

	public static List<CedulaPartido> findCedulaPartidoEntries(int firstResult, int maxResults, String sortFieldName, String sortOrder) {
        String jpaQuery = "SELECT o FROM CedulaPartido o";
        if (fieldNames4OrderClauseFilter.contains(sortFieldName)) {
            jpaQuery = jpaQuery + " ORDER BY " + sortFieldName;
            if ("ASC".equalsIgnoreCase(sortOrder) || "DESC".equalsIgnoreCase(sortOrder)) {
                jpaQuery = jpaQuery + " " + sortOrder;
            }
        }
        return entityManager().createQuery(jpaQuery, CedulaPartido.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
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
            CedulaPartido attached = CedulaPartido.findCedulaPartido(this.id);
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
    public CedulaPartido merge() {
        if (this.entityManager == null) this.entityManager = entityManager();
        CedulaPartido merged = this.entityManager.merge(this);
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

	public static CedulaPartido fromJsonToCedulaPartido(String json) {
        return new JSONDeserializer<CedulaPartido>()
        .use(null, CedulaPartido.class).deserialize(json);
    }

	public static String toJsonArray(Collection<CedulaPartido> collection) {
        return new JSONSerializer()
        .exclude("*.class").deepSerialize(collection);
    }

	public static String toJsonArray(Collection<CedulaPartido> collection, String[] fields) {
        return new JSONSerializer()
        .include(fields).exclude("*.class").deepSerialize(collection);
    }

	public static Collection<CedulaPartido> fromJsonArrayToCedulaPartidoes(String json) {
        return new JSONDeserializer<List<CedulaPartido>>()
        .use("values", CedulaPartido.class).deserialize(json);
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

	public static Long countFindCedulaPartidoesByPartido(Partido partido) {
        if (partido == null) throw new IllegalArgumentException("The partido argument is required");
        EntityManager em = CedulaPartido.entityManager();
        TypedQuery q = em.createQuery("SELECT COUNT(o) FROM CedulaPartido AS o WHERE o.partido = :partido", Long.class);
        q.setParameter("partido", partido);
        return ((Long) q.getSingleResult());
    }

	public static Long countFindCedulaPartidoesByPartidoAndStatus(Partido partido, StatusCedula status) {
        if (partido == null) throw new IllegalArgumentException("The partido argument is required");
        if (status == null) throw new IllegalArgumentException("The status argument is required");
        EntityManager em = CedulaPartido.entityManager();
        TypedQuery q = em.createQuery("SELECT COUNT(o) FROM CedulaPartido AS o WHERE o.partido = :partido AND o.status = :status", Long.class);
        q.setParameter("partido", partido);
        q.setParameter("status", status);
        return ((Long) q.getSingleResult());
    }

	public static TypedQuery<CedulaPartido> findCedulaPartidoesByPartido(Partido partido) {
        if (partido == null) throw new IllegalArgumentException("The partido argument is required");
        EntityManager em = CedulaPartido.entityManager();
        TypedQuery<CedulaPartido> q = em.createQuery("SELECT o FROM CedulaPartido AS o WHERE o.partido = :partido", CedulaPartido.class);
        q.setParameter("partido", partido);
        return q;
    }

	public static TypedQuery<CedulaPartido> findCedulaPartidoesByPartido(Partido partido, String sortFieldName, String sortOrder) {
        if (partido == null) throw new IllegalArgumentException("The partido argument is required");
        EntityManager em = CedulaPartido.entityManager();
        String jpaQuery = "SELECT o FROM CedulaPartido AS o WHERE o.partido = :partido";
        if (fieldNames4OrderClauseFilter.contains(sortFieldName)) {
            jpaQuery = jpaQuery + " ORDER BY " + sortFieldName;
            if ("ASC".equalsIgnoreCase(sortOrder) || "DESC".equalsIgnoreCase(sortOrder)) {
                jpaQuery = jpaQuery + " " + sortOrder;
            }
        }
        TypedQuery<CedulaPartido> q = em.createQuery(jpaQuery, CedulaPartido.class);
        q.setParameter("partido", partido);
        return q;
    }

	public static TypedQuery<CedulaPartido> findCedulaPartidoesByPartidoAndStatus(Partido partido, StatusCedula status) {
        if (partido == null) throw new IllegalArgumentException("The partido argument is required");
        if (status == null) throw new IllegalArgumentException("The status argument is required");
        EntityManager em = CedulaPartido.entityManager();
        TypedQuery<CedulaPartido> q = em.createQuery("SELECT o FROM CedulaPartido AS o WHERE o.partido = :partido AND o.status = :status", CedulaPartido.class);
        q.setParameter("partido", partido);
        q.setParameter("status", status);
        return q;
    }

	public static TypedQuery<CedulaPartido> findCedulaPartidoesByPartidoAndStatus(Partido partido, StatusCedula status, String sortFieldName, String sortOrder) {
        if (partido == null) throw new IllegalArgumentException("The partido argument is required");
        if (status == null) throw new IllegalArgumentException("The status argument is required");
        EntityManager em = CedulaPartido.entityManager();
        String jpaQuery = "SELECT o FROM CedulaPartido AS o WHERE o.partido = :partido AND o.status = :status";
        if (fieldNames4OrderClauseFilter.contains(sortFieldName)) {
            jpaQuery = jpaQuery + " ORDER BY " + sortFieldName;
            if ("ASC".equalsIgnoreCase(sortOrder) || "DESC".equalsIgnoreCase(sortOrder)) {
                jpaQuery = jpaQuery + " " + sortOrder;
            }
        }
        TypedQuery<CedulaPartido> q = em.createQuery(jpaQuery, CedulaPartido.class);
        q.setParameter("partido", partido);
        q.setParameter("status", status);
        return q;
    }

	public String toString() {
        return ReflectionToStringBuilder.toString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
}
