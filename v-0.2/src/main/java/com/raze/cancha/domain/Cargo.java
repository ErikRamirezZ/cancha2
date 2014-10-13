package com.raze.cancha.domain;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;
import com.raze.cancha.catalog.ConceptoCobro;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import com.raze.cancha.catalog.StatusCargoAbono;
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

@Entity
@Configurable
@RooJavaBean
@RooToString
@RooJpaActiveRecord(finders = { "findCargoesByConceptoCobroAndFechaCreacionBetween", "findCargoesByConceptoCobroAndTorneo", "findCargoesByConceptoCobroAndTorneoAndEquipo", "findCargoesByConceptoCobroAndStatus", "findCargoesByConceptoCobroAndTorneoAndFechaModificacionBetween", "findCargoesByConceptoCobroAndTorneoAndEquipoAndFechaModificacionBetween" })
@RooJson(deepSerialize = true)
public class Cargo {

    /**
     */
    @NotNull
    @ManyToOne
    private ConceptoCobro conceptoCobro;

    /**
     */
    @NotNull
    @ManyToOne
    private Torneo torneo;

    /**
     */
    @NotNull
    @ManyToOne
    private Equipo equipo;

    /**
     */
    @NotNull
    private double monto;

    /**
     */
    private String observaciones;

    /**
     */
    @ManyToOne
    private StatusCargoAbono status;

    /**
     */
    @ManyToOne
    private Abono abono;

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

	public String toJson() {
        return new JSONSerializer()
        .exclude("*.class").deepSerialize(this);
    }

	public String toJson(String[] fields) {
        return new JSONSerializer()
        .include(fields).exclude("*.class").deepSerialize(this);
    }

	public static Cargo fromJsonToCargo(String json) {
        return new JSONDeserializer<Cargo>()
        .use(null, Cargo.class).deserialize(json);
    }

	public static String toJsonArray(Collection<Cargo> collection) {
        return new JSONSerializer()
        .exclude("*.class").deepSerialize(collection);
    }

	public static String toJsonArray(Collection<Cargo> collection, String[] fields) {
        return new JSONSerializer()
        .include(fields).exclude("*.class").deepSerialize(collection);
    }

	public static Collection<Cargo> fromJsonArrayToCargoes(String json) {
        return new JSONDeserializer<List<Cargo>>()
        .use("values", Cargo.class).deserialize(json);
    }

	@PersistenceContext
    transient EntityManager entityManager;

	public static final List<String> fieldNames4OrderClauseFilter = java.util.Arrays.asList("conceptoCobro", "torneo", "equipo", "monto", "observaciones", "status", "abono", "usuario", "fechaCreacion", "fechaModificacion");

	public static final EntityManager entityManager() {
        EntityManager em = new Cargo().entityManager;
        if (em == null) throw new IllegalStateException("Entity manager has not been injected (is the Spring Aspects JAR configured as an AJC/AJDT aspects library?)");
        return em;
    }

	public static long countCargoes() {
        return entityManager().createQuery("SELECT COUNT(o) FROM Cargo o", Long.class).getSingleResult();
    }

	public static List<Cargo> findAllCargoes() {
        return entityManager().createQuery("SELECT o FROM Cargo o", Cargo.class).getResultList();
    }

	public static List<Cargo> findAllCargoes(String sortFieldName, String sortOrder) {
        String jpaQuery = "SELECT o FROM Cargo o";
        if (fieldNames4OrderClauseFilter.contains(sortFieldName)) {
            jpaQuery = jpaQuery + " ORDER BY " + sortFieldName;
            if ("ASC".equalsIgnoreCase(sortOrder) || "DESC".equalsIgnoreCase(sortOrder)) {
                jpaQuery = jpaQuery + " " + sortOrder;
            }
        }
        return entityManager().createQuery(jpaQuery, Cargo.class).getResultList();
    }

	public static Cargo findCargo(Long id) {
        if (id == null) return null;
        return entityManager().find(Cargo.class, id);
    }

	public static List<Cargo> findCargoEntries(int firstResult, int maxResults) {
        return entityManager().createQuery("SELECT o FROM Cargo o", Cargo.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }

	public static List<Cargo> findCargoEntries(int firstResult, int maxResults, String sortFieldName, String sortOrder) {
        String jpaQuery = "SELECT o FROM Cargo o";
        if (fieldNames4OrderClauseFilter.contains(sortFieldName)) {
            jpaQuery = jpaQuery + " ORDER BY " + sortFieldName;
            if ("ASC".equalsIgnoreCase(sortOrder) || "DESC".equalsIgnoreCase(sortOrder)) {
                jpaQuery = jpaQuery + " " + sortOrder;
            }
        }
        return entityManager().createQuery(jpaQuery, Cargo.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
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
            Cargo attached = Cargo.findCargo(this.id);
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
    public Cargo merge() {
        if (this.entityManager == null) this.entityManager = entityManager();
        Cargo merged = this.entityManager.merge(this);
        this.entityManager.flush();
        return merged;
    }

	public static Long countFindCargoesByConceptoCobroAndFechaCreacionBetween(ConceptoCobro conceptoCobro, Date minFechaCreacion, Date maxFechaCreacion) {
        if (conceptoCobro == null) throw new IllegalArgumentException("The conceptoCobro argument is required");
        if (minFechaCreacion == null) throw new IllegalArgumentException("The minFechaCreacion argument is required");
        if (maxFechaCreacion == null) throw new IllegalArgumentException("The maxFechaCreacion argument is required");
        EntityManager em = Cargo.entityManager();
        TypedQuery q = em.createQuery("SELECT COUNT(o) FROM Cargo AS o WHERE o.conceptoCobro = :conceptoCobro AND o.fechaCreacion BETWEEN :minFechaCreacion AND :maxFechaCreacion", Long.class);
        q.setParameter("conceptoCobro", conceptoCobro);
        q.setParameter("minFechaCreacion", minFechaCreacion);
        q.setParameter("maxFechaCreacion", maxFechaCreacion);
        return ((Long) q.getSingleResult());
    }

	public static Long countFindCargoesByConceptoCobroAndStatus(ConceptoCobro conceptoCobro, StatusCargoAbono status) {
        if (conceptoCobro == null) throw new IllegalArgumentException("The conceptoCobro argument is required");
        if (status == null) throw new IllegalArgumentException("The status argument is required");
        EntityManager em = Cargo.entityManager();
        TypedQuery q = em.createQuery("SELECT COUNT(o) FROM Cargo AS o WHERE o.conceptoCobro = :conceptoCobro AND o.status = :status", Long.class);
        q.setParameter("conceptoCobro", conceptoCobro);
        q.setParameter("status", status);
        return ((Long) q.getSingleResult());
    }

	public static Long countFindCargoesByConceptoCobroAndTorneo(ConceptoCobro conceptoCobro, Torneo torneo) {
        if (conceptoCobro == null) throw new IllegalArgumentException("The conceptoCobro argument is required");
        if (torneo == null) throw new IllegalArgumentException("The torneo argument is required");
        EntityManager em = Cargo.entityManager();
        TypedQuery q = em.createQuery("SELECT COUNT(o) FROM Cargo AS o WHERE o.conceptoCobro = :conceptoCobro AND o.torneo = :torneo", Long.class);
        q.setParameter("conceptoCobro", conceptoCobro);
        q.setParameter("torneo", torneo);
        return ((Long) q.getSingleResult());
    }

	public static Long countFindCargoesByConceptoCobroAndTorneoAndEquipo(ConceptoCobro conceptoCobro, Torneo torneo, Equipo equipo) {
        if (conceptoCobro == null) throw new IllegalArgumentException("The conceptoCobro argument is required");
        if (torneo == null) throw new IllegalArgumentException("The torneo argument is required");
        if (equipo == null) throw new IllegalArgumentException("The equipo argument is required");
        EntityManager em = Cargo.entityManager();
        TypedQuery q = em.createQuery("SELECT COUNT(o) FROM Cargo AS o WHERE o.conceptoCobro = :conceptoCobro AND o.torneo = :torneo AND o.equipo = :equipo", Long.class);
        q.setParameter("conceptoCobro", conceptoCobro);
        q.setParameter("torneo", torneo);
        q.setParameter("equipo", equipo);
        return ((Long) q.getSingleResult());
    }

	public static Long countFindCargoesByConceptoCobroAndTorneoAndEquipoAndFechaModificacionBetween(ConceptoCobro conceptoCobro, Torneo torneo, Equipo equipo, Date minFechaModificacion, Date maxFechaModificacion) {
        if (conceptoCobro == null) throw new IllegalArgumentException("The conceptoCobro argument is required");
        if (torneo == null) throw new IllegalArgumentException("The torneo argument is required");
        if (equipo == null) throw new IllegalArgumentException("The equipo argument is required");
        if (minFechaModificacion == null) throw new IllegalArgumentException("The minFechaModificacion argument is required");
        if (maxFechaModificacion == null) throw new IllegalArgumentException("The maxFechaModificacion argument is required");
        EntityManager em = Cargo.entityManager();
        TypedQuery q = em.createQuery("SELECT COUNT(o) FROM Cargo AS o WHERE o.conceptoCobro = :conceptoCobro AND o.torneo = :torneo AND o.equipo = :equipo AND o.fechaModificacion BETWEEN :minFechaModificacion AND :maxFechaModificacion", Long.class);
        q.setParameter("conceptoCobro", conceptoCobro);
        q.setParameter("torneo", torneo);
        q.setParameter("equipo", equipo);
        q.setParameter("minFechaModificacion", minFechaModificacion);
        q.setParameter("maxFechaModificacion", maxFechaModificacion);
        return ((Long) q.getSingleResult());
    }

	public static Long countFindCargoesByConceptoCobroAndTorneoAndFechaModificacionBetween(ConceptoCobro conceptoCobro, Torneo torneo, Date minFechaModificacion, Date maxFechaModificacion) {
        if (conceptoCobro == null) throw new IllegalArgumentException("The conceptoCobro argument is required");
        if (torneo == null) throw new IllegalArgumentException("The torneo argument is required");
        if (minFechaModificacion == null) throw new IllegalArgumentException("The minFechaModificacion argument is required");
        if (maxFechaModificacion == null) throw new IllegalArgumentException("The maxFechaModificacion argument is required");
        EntityManager em = Cargo.entityManager();
        TypedQuery q = em.createQuery("SELECT COUNT(o) FROM Cargo AS o WHERE o.conceptoCobro = :conceptoCobro AND o.torneo = :torneo AND o.fechaModificacion BETWEEN :minFechaModificacion AND :maxFechaModificacion", Long.class);
        q.setParameter("conceptoCobro", conceptoCobro);
        q.setParameter("torneo", torneo);
        q.setParameter("minFechaModificacion", minFechaModificacion);
        q.setParameter("maxFechaModificacion", maxFechaModificacion);
        return ((Long) q.getSingleResult());
    }

	public static TypedQuery<Cargo> findCargoesByConceptoCobroAndFechaCreacionBetween(ConceptoCobro conceptoCobro, Date minFechaCreacion, Date maxFechaCreacion) {
        if (conceptoCobro == null) throw new IllegalArgumentException("The conceptoCobro argument is required");
        if (minFechaCreacion == null) throw new IllegalArgumentException("The minFechaCreacion argument is required");
        if (maxFechaCreacion == null) throw new IllegalArgumentException("The maxFechaCreacion argument is required");
        EntityManager em = Cargo.entityManager();
        TypedQuery<Cargo> q = em.createQuery("SELECT o FROM Cargo AS o WHERE o.conceptoCobro = :conceptoCobro AND o.fechaCreacion BETWEEN :minFechaCreacion AND :maxFechaCreacion", Cargo.class);
        q.setParameter("conceptoCobro", conceptoCobro);
        q.setParameter("minFechaCreacion", minFechaCreacion);
        q.setParameter("maxFechaCreacion", maxFechaCreacion);
        return q;
    }

	public static TypedQuery<Cargo> findCargoesByConceptoCobroAndFechaCreacionBetween(ConceptoCobro conceptoCobro, Date minFechaCreacion, Date maxFechaCreacion, String sortFieldName, String sortOrder) {
        if (conceptoCobro == null) throw new IllegalArgumentException("The conceptoCobro argument is required");
        if (minFechaCreacion == null) throw new IllegalArgumentException("The minFechaCreacion argument is required");
        if (maxFechaCreacion == null) throw new IllegalArgumentException("The maxFechaCreacion argument is required");
        EntityManager em = Cargo.entityManager();
        String jpaQuery = "SELECT o FROM Cargo AS o WHERE o.conceptoCobro = :conceptoCobro AND o.fechaCreacion BETWEEN :minFechaCreacion AND :maxFechaCreacion";
        if (fieldNames4OrderClauseFilter.contains(sortFieldName)) {
            jpaQuery = jpaQuery + " ORDER BY " + sortFieldName;
            if ("ASC".equalsIgnoreCase(sortOrder) || "DESC".equalsIgnoreCase(sortOrder)) {
                jpaQuery = jpaQuery + " " + sortOrder;
            }
        }
        TypedQuery<Cargo> q = em.createQuery(jpaQuery, Cargo.class);
        q.setParameter("conceptoCobro", conceptoCobro);
        q.setParameter("minFechaCreacion", minFechaCreacion);
        q.setParameter("maxFechaCreacion", maxFechaCreacion);
        return q;
    }

	public static TypedQuery<Cargo> findCargoesByConceptoCobroAndStatus(ConceptoCobro conceptoCobro, StatusCargoAbono status) {
        if (conceptoCobro == null) throw new IllegalArgumentException("The conceptoCobro argument is required");
        if (status == null) throw new IllegalArgumentException("The status argument is required");
        EntityManager em = Cargo.entityManager();
        TypedQuery<Cargo> q = em.createQuery("SELECT o FROM Cargo AS o WHERE o.conceptoCobro = :conceptoCobro AND o.status = :status", Cargo.class);
        q.setParameter("conceptoCobro", conceptoCobro);
        q.setParameter("status", status);
        return q;
    }

	public static TypedQuery<Cargo> findCargoesByConceptoCobroAndStatus(ConceptoCobro conceptoCobro, StatusCargoAbono status, String sortFieldName, String sortOrder) {
        if (conceptoCobro == null) throw new IllegalArgumentException("The conceptoCobro argument is required");
        if (status == null) throw new IllegalArgumentException("The status argument is required");
        EntityManager em = Cargo.entityManager();
        String jpaQuery = "SELECT o FROM Cargo AS o WHERE o.conceptoCobro = :conceptoCobro AND o.status = :status";
        if (fieldNames4OrderClauseFilter.contains(sortFieldName)) {
            jpaQuery = jpaQuery + " ORDER BY " + sortFieldName;
            if ("ASC".equalsIgnoreCase(sortOrder) || "DESC".equalsIgnoreCase(sortOrder)) {
                jpaQuery = jpaQuery + " " + sortOrder;
            }
        }
        TypedQuery<Cargo> q = em.createQuery(jpaQuery, Cargo.class);
        q.setParameter("conceptoCobro", conceptoCobro);
        q.setParameter("status", status);
        return q;
    }

	public static TypedQuery<Cargo> findCargoesByConceptoCobroAndTorneo(ConceptoCobro conceptoCobro, Torneo torneo) {
        if (conceptoCobro == null) throw new IllegalArgumentException("The conceptoCobro argument is required");
        if (torneo == null) throw new IllegalArgumentException("The torneo argument is required");
        EntityManager em = Cargo.entityManager();
        TypedQuery<Cargo> q = em.createQuery("SELECT o FROM Cargo AS o WHERE o.conceptoCobro = :conceptoCobro AND o.torneo = :torneo", Cargo.class);
        q.setParameter("conceptoCobro", conceptoCobro);
        q.setParameter("torneo", torneo);
        return q;
    }

	public static TypedQuery<Cargo> findCargoesByConceptoCobroAndTorneo(ConceptoCobro conceptoCobro, Torneo torneo, String sortFieldName, String sortOrder) {
        if (conceptoCobro == null) throw new IllegalArgumentException("The conceptoCobro argument is required");
        if (torneo == null) throw new IllegalArgumentException("The torneo argument is required");
        EntityManager em = Cargo.entityManager();
        String jpaQuery = "SELECT o FROM Cargo AS o WHERE o.conceptoCobro = :conceptoCobro AND o.torneo = :torneo";
        if (fieldNames4OrderClauseFilter.contains(sortFieldName)) {
            jpaQuery = jpaQuery + " ORDER BY " + sortFieldName;
            if ("ASC".equalsIgnoreCase(sortOrder) || "DESC".equalsIgnoreCase(sortOrder)) {
                jpaQuery = jpaQuery + " " + sortOrder;
            }
        }
        TypedQuery<Cargo> q = em.createQuery(jpaQuery, Cargo.class);
        q.setParameter("conceptoCobro", conceptoCobro);
        q.setParameter("torneo", torneo);
        return q;
    }

	public static TypedQuery<Cargo> findCargoesByConceptoCobroAndTorneoAndEquipo(ConceptoCobro conceptoCobro, Torneo torneo, Equipo equipo) {
        if (conceptoCobro == null) throw new IllegalArgumentException("The conceptoCobro argument is required");
        if (torneo == null) throw new IllegalArgumentException("The torneo argument is required");
        if (equipo == null) throw new IllegalArgumentException("The equipo argument is required");
        EntityManager em = Cargo.entityManager();
        TypedQuery<Cargo> q = em.createQuery("SELECT o FROM Cargo AS o WHERE o.conceptoCobro = :conceptoCobro AND o.torneo = :torneo AND o.equipo = :equipo", Cargo.class);
        q.setParameter("conceptoCobro", conceptoCobro);
        q.setParameter("torneo", torneo);
        q.setParameter("equipo", equipo);
        return q;
    }

	public static TypedQuery<Cargo> findCargoesByConceptoCobroAndTorneoAndEquipo(ConceptoCobro conceptoCobro, Torneo torneo, Equipo equipo, String sortFieldName, String sortOrder) {
        if (conceptoCobro == null) throw new IllegalArgumentException("The conceptoCobro argument is required");
        if (torneo == null) throw new IllegalArgumentException("The torneo argument is required");
        if (equipo == null) throw new IllegalArgumentException("The equipo argument is required");
        EntityManager em = Cargo.entityManager();
        String jpaQuery = "SELECT o FROM Cargo AS o WHERE o.conceptoCobro = :conceptoCobro AND o.torneo = :torneo AND o.equipo = :equipo";
        if (fieldNames4OrderClauseFilter.contains(sortFieldName)) {
            jpaQuery = jpaQuery + " ORDER BY " + sortFieldName;
            if ("ASC".equalsIgnoreCase(sortOrder) || "DESC".equalsIgnoreCase(sortOrder)) {
                jpaQuery = jpaQuery + " " + sortOrder;
            }
        }
        TypedQuery<Cargo> q = em.createQuery(jpaQuery, Cargo.class);
        q.setParameter("conceptoCobro", conceptoCobro);
        q.setParameter("torneo", torneo);
        q.setParameter("equipo", equipo);
        return q;
    }

	public static TypedQuery<Cargo> findCargoesByConceptoCobroAndTorneoAndEquipoAndFechaModificacionBetween(ConceptoCobro conceptoCobro, Torneo torneo, Equipo equipo, Date minFechaModificacion, Date maxFechaModificacion) {
        if (conceptoCobro == null) throw new IllegalArgumentException("The conceptoCobro argument is required");
        if (torneo == null) throw new IllegalArgumentException("The torneo argument is required");
        if (equipo == null) throw new IllegalArgumentException("The equipo argument is required");
        if (minFechaModificacion == null) throw new IllegalArgumentException("The minFechaModificacion argument is required");
        if (maxFechaModificacion == null) throw new IllegalArgumentException("The maxFechaModificacion argument is required");
        EntityManager em = Cargo.entityManager();
        TypedQuery<Cargo> q = em.createQuery("SELECT o FROM Cargo AS o WHERE o.conceptoCobro = :conceptoCobro AND o.torneo = :torneo AND o.equipo = :equipo AND o.fechaModificacion BETWEEN :minFechaModificacion AND :maxFechaModificacion", Cargo.class);
        q.setParameter("conceptoCobro", conceptoCobro);
        q.setParameter("torneo", torneo);
        q.setParameter("equipo", equipo);
        q.setParameter("minFechaModificacion", minFechaModificacion);
        q.setParameter("maxFechaModificacion", maxFechaModificacion);
        return q;
    }

	public static TypedQuery<Cargo> findCargoesByConceptoCobroAndTorneoAndEquipoAndFechaModificacionBetween(ConceptoCobro conceptoCobro, Torneo torneo, Equipo equipo, Date minFechaModificacion, Date maxFechaModificacion, String sortFieldName, String sortOrder) {
        if (conceptoCobro == null) throw new IllegalArgumentException("The conceptoCobro argument is required");
        if (torneo == null) throw new IllegalArgumentException("The torneo argument is required");
        if (equipo == null) throw new IllegalArgumentException("The equipo argument is required");
        if (minFechaModificacion == null) throw new IllegalArgumentException("The minFechaModificacion argument is required");
        if (maxFechaModificacion == null) throw new IllegalArgumentException("The maxFechaModificacion argument is required");
        EntityManager em = Cargo.entityManager();
        String jpaQuery = "SELECT o FROM Cargo AS o WHERE o.conceptoCobro = :conceptoCobro AND o.torneo = :torneo AND o.equipo = :equipo AND o.fechaModificacion BETWEEN :minFechaModificacion AND :maxFechaModificacion";
        if (fieldNames4OrderClauseFilter.contains(sortFieldName)) {
            jpaQuery = jpaQuery + " ORDER BY " + sortFieldName;
            if ("ASC".equalsIgnoreCase(sortOrder) || "DESC".equalsIgnoreCase(sortOrder)) {
                jpaQuery = jpaQuery + " " + sortOrder;
            }
        }
        TypedQuery<Cargo> q = em.createQuery(jpaQuery, Cargo.class);
        q.setParameter("conceptoCobro", conceptoCobro);
        q.setParameter("torneo", torneo);
        q.setParameter("equipo", equipo);
        q.setParameter("minFechaModificacion", minFechaModificacion);
        q.setParameter("maxFechaModificacion", maxFechaModificacion);
        return q;
    }

	public static TypedQuery<Cargo> findCargoesByConceptoCobroAndTorneoAndFechaModificacionBetween(ConceptoCobro conceptoCobro, Torneo torneo, Date minFechaModificacion, Date maxFechaModificacion) {
        if (conceptoCobro == null) throw new IllegalArgumentException("The conceptoCobro argument is required");
        if (torneo == null) throw new IllegalArgumentException("The torneo argument is required");
        if (minFechaModificacion == null) throw new IllegalArgumentException("The minFechaModificacion argument is required");
        if (maxFechaModificacion == null) throw new IllegalArgumentException("The maxFechaModificacion argument is required");
        EntityManager em = Cargo.entityManager();
        TypedQuery<Cargo> q = em.createQuery("SELECT o FROM Cargo AS o WHERE o.conceptoCobro = :conceptoCobro AND o.torneo = :torneo AND o.fechaModificacion BETWEEN :minFechaModificacion AND :maxFechaModificacion", Cargo.class);
        q.setParameter("conceptoCobro", conceptoCobro);
        q.setParameter("torneo", torneo);
        q.setParameter("minFechaModificacion", minFechaModificacion);
        q.setParameter("maxFechaModificacion", maxFechaModificacion);
        return q;
    }

	public static TypedQuery<Cargo> findCargoesByConceptoCobroAndTorneoAndFechaModificacionBetween(ConceptoCobro conceptoCobro, Torneo torneo, Date minFechaModificacion, Date maxFechaModificacion, String sortFieldName, String sortOrder) {
        if (conceptoCobro == null) throw new IllegalArgumentException("The conceptoCobro argument is required");
        if (torneo == null) throw new IllegalArgumentException("The torneo argument is required");
        if (minFechaModificacion == null) throw new IllegalArgumentException("The minFechaModificacion argument is required");
        if (maxFechaModificacion == null) throw new IllegalArgumentException("The maxFechaModificacion argument is required");
        EntityManager em = Cargo.entityManager();
        String jpaQuery = "SELECT o FROM Cargo AS o WHERE o.conceptoCobro = :conceptoCobro AND o.torneo = :torneo AND o.fechaModificacion BETWEEN :minFechaModificacion AND :maxFechaModificacion";
        if (fieldNames4OrderClauseFilter.contains(sortFieldName)) {
            jpaQuery = jpaQuery + " ORDER BY " + sortFieldName;
            if ("ASC".equalsIgnoreCase(sortOrder) || "DESC".equalsIgnoreCase(sortOrder)) {
                jpaQuery = jpaQuery + " " + sortOrder;
            }
        }
        TypedQuery<Cargo> q = em.createQuery(jpaQuery, Cargo.class);
        q.setParameter("conceptoCobro", conceptoCobro);
        q.setParameter("torneo", torneo);
        q.setParameter("minFechaModificacion", minFechaModificacion);
        q.setParameter("maxFechaModificacion", maxFechaModificacion);
        return q;
    }

	public ConceptoCobro getConceptoCobro() {
        return this.conceptoCobro;
    }

	public void setConceptoCobro(ConceptoCobro conceptoCobro) {
        this.conceptoCobro = conceptoCobro;
    }

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

	public double getMonto() {
        return this.monto;
    }

	public void setMonto(double monto) {
        this.monto = monto;
    }

	public String getObservaciones() {
        return this.observaciones;
    }

	public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

	public StatusCargoAbono getStatus() {
        return this.status;
    }

	public void setStatus(StatusCargoAbono status) {
        this.status = status;
    }

	public Abono getAbono() {
        return this.abono;
    }

	public void setAbono(Abono abono) {
        this.abono = abono;
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

	public String toString() {
        return ReflectionToStringBuilder.toString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
}
