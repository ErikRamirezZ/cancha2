package com.raze.cancha.domain;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;
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
@RooJpaActiveRecord(finders = { "findTorneoEquipoesByEquipo", "findTorneoEquipoesByTorneo" })
@RooJson(deepSerialize = true)
public class TorneoEquipo {

    /**
     */
    @ManyToOne
    private Torneo torneo;

    /**
     */
    @ManyToOne
    private Equipo equipo;

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

	public Torneo getTorneo() {
        return this.torneo;
    }

	public void setTorneo(Torneo torneo) {
        this.torneo = torneo;
    }

	public Equipo getEquipo() {
        return this.equipo;
    }

	public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
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

	public String toJson() {
        return new JSONSerializer()
        .exclude("*.class").deepSerialize(this);
    }

	public String toJson(String[] fields) {
        return new JSONSerializer()
        .include(fields).exclude("*.class").deepSerialize(this);
    }

	public static TorneoEquipo fromJsonToTorneoEquipo(String json) {
        return new JSONDeserializer<TorneoEquipo>()
        .use(null, TorneoEquipo.class).deserialize(json);
    }

	public static String toJsonArray(Collection<TorneoEquipo> collection) {
        return new JSONSerializer()
        .exclude("*.class").deepSerialize(collection);
    }

	public static String toJsonArray(Collection<TorneoEquipo> collection, String[] fields) {
        return new JSONSerializer()
        .include(fields).exclude("*.class").deepSerialize(collection);
    }

	public static Collection<TorneoEquipo> fromJsonArrayToTorneoEquipoes(String json) {
        return new JSONDeserializer<List<TorneoEquipo>>()
        .use("values", TorneoEquipo.class).deserialize(json);
    }

	public String toString() {
        return ReflectionToStringBuilder.toString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }

	@PersistenceContext
    transient EntityManager entityManager;

	public static final List<String> fieldNames4OrderClauseFilter = java.util.Arrays.asList("torneo", "equipo", "activo", "usuario", "fechaCreacion", "fechaModificacion");

	public static final EntityManager entityManager() {
        EntityManager em = new TorneoEquipo().entityManager;
        if (em == null) throw new IllegalStateException("Entity manager has not been injected (is the Spring Aspects JAR configured as an AJC/AJDT aspects library?)");
        return em;
    }

	public static long countTorneoEquipoes() {
        return entityManager().createQuery("SELECT COUNT(o) FROM TorneoEquipo o", Long.class).getSingleResult();
    }

	public static List<TorneoEquipo> findAllTorneoEquipoes() {
        return entityManager().createQuery("SELECT o FROM TorneoEquipo o", TorneoEquipo.class).getResultList();
    }

	public static List<TorneoEquipo> findAllTorneoEquipoes(String sortFieldName, String sortOrder) {
        String jpaQuery = "SELECT o FROM TorneoEquipo o";
        if (fieldNames4OrderClauseFilter.contains(sortFieldName)) {
            jpaQuery = jpaQuery + " ORDER BY " + sortFieldName;
            if ("ASC".equalsIgnoreCase(sortOrder) || "DESC".equalsIgnoreCase(sortOrder)) {
                jpaQuery = jpaQuery + " " + sortOrder;
            }
        }
        return entityManager().createQuery(jpaQuery, TorneoEquipo.class).getResultList();
    }

	public static TorneoEquipo findTorneoEquipo(Long id) {
        if (id == null) return null;
        return entityManager().find(TorneoEquipo.class, id);
    }

	public static List<TorneoEquipo> findTorneoEquipoEntries(int firstResult, int maxResults) {
        return entityManager().createQuery("SELECT o FROM TorneoEquipo o", TorneoEquipo.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }

	public static List<TorneoEquipo> findTorneoEquipoEntries(int firstResult, int maxResults, String sortFieldName, String sortOrder) {
        String jpaQuery = "SELECT o FROM TorneoEquipo o";
        if (fieldNames4OrderClauseFilter.contains(sortFieldName)) {
            jpaQuery = jpaQuery + " ORDER BY " + sortFieldName;
            if ("ASC".equalsIgnoreCase(sortOrder) || "DESC".equalsIgnoreCase(sortOrder)) {
                jpaQuery = jpaQuery + " " + sortOrder;
            }
        }
        return entityManager().createQuery(jpaQuery, TorneoEquipo.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
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
            TorneoEquipo attached = TorneoEquipo.findTorneoEquipo(this.id);
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
    public TorneoEquipo merge() {
        if (this.entityManager == null) this.entityManager = entityManager();
        TorneoEquipo merged = this.entityManager.merge(this);
        this.entityManager.flush();
        return merged;
    }

	public static Long countFindTorneoEquipoesByEquipo(Equipo equipo) {
        if (equipo == null) throw new IllegalArgumentException("The equipo argument is required");
        EntityManager em = TorneoEquipo.entityManager();
        TypedQuery q = em.createQuery("SELECT COUNT(o) FROM TorneoEquipo AS o WHERE o.equipo = :equipo", Long.class);
        q.setParameter("equipo", equipo);
        return ((Long) q.getSingleResult());
    }

	public static Long countFindTorneoEquipoesByTorneo(Torneo torneo) {
        if (torneo == null) throw new IllegalArgumentException("The torneo argument is required");
        EntityManager em = TorneoEquipo.entityManager();
        TypedQuery q = em.createQuery("SELECT COUNT(o) FROM TorneoEquipo AS o WHERE o.torneo = :torneo", Long.class);
        q.setParameter("torneo", torneo);
        return ((Long) q.getSingleResult());
    }

	public static TypedQuery<TorneoEquipo> findTorneoEquipoesByEquipo(Equipo equipo) {
        if (equipo == null) throw new IllegalArgumentException("The equipo argument is required");
        EntityManager em = TorneoEquipo.entityManager();
        TypedQuery<TorneoEquipo> q = em.createQuery("SELECT o FROM TorneoEquipo AS o WHERE o.equipo = :equipo", TorneoEquipo.class);
        q.setParameter("equipo", equipo);
        return q;
    }

	public static TypedQuery<TorneoEquipo> findTorneoEquipoesByEquipo(Equipo equipo, String sortFieldName, String sortOrder) {
        if (equipo == null) throw new IllegalArgumentException("The equipo argument is required");
        EntityManager em = TorneoEquipo.entityManager();
        String jpaQuery = "SELECT o FROM TorneoEquipo AS o WHERE o.equipo = :equipo";
        if (fieldNames4OrderClauseFilter.contains(sortFieldName)) {
            jpaQuery = jpaQuery + " ORDER BY " + sortFieldName;
            if ("ASC".equalsIgnoreCase(sortOrder) || "DESC".equalsIgnoreCase(sortOrder)) {
                jpaQuery = jpaQuery + " " + sortOrder;
            }
        }
        TypedQuery<TorneoEquipo> q = em.createQuery(jpaQuery, TorneoEquipo.class);
        q.setParameter("equipo", equipo);
        return q;
    }

	public static TypedQuery<TorneoEquipo> findTorneoEquipoesByTorneo(Torneo torneo) {
        if (torneo == null) throw new IllegalArgumentException("The torneo argument is required");
        EntityManager em = TorneoEquipo.entityManager();
        TypedQuery<TorneoEquipo> q = em.createQuery("SELECT o FROM TorneoEquipo AS o WHERE o.torneo = :torneo", TorneoEquipo.class);
        q.setParameter("torneo", torneo);
        return q;
    }

	public static TypedQuery<TorneoEquipo> findTorneoEquipoesByTorneo(Torneo torneo, String sortFieldName, String sortOrder) {
        if (torneo == null) throw new IllegalArgumentException("The torneo argument is required");
        EntityManager em = TorneoEquipo.entityManager();
        String jpaQuery = "SELECT o FROM TorneoEquipo AS o WHERE o.torneo = :torneo";
        if (fieldNames4OrderClauseFilter.contains(sortFieldName)) {
            jpaQuery = jpaQuery + " ORDER BY " + sortFieldName;
            if ("ASC".equalsIgnoreCase(sortOrder) || "DESC".equalsIgnoreCase(sortOrder)) {
                jpaQuery = jpaQuery + " " + sortOrder;
            }
        }
        TypedQuery<TorneoEquipo> q = em.createQuery(jpaQuery, TorneoEquipo.class);
        q.setParameter("torneo", torneo);
        return q;
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
