package com.raze.cancha.domain;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.Version;
import java.util.Date;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.format.annotation.DateTimeFormat;
import com.raze.cancha.catalog.TipoPartido;
import com.raze.cancha.catalog.StatusPartido;
import flexjson.JSONDeserializer;
import flexjson.JSONSerializer;
import org.springframework.roo.addon.json.RooJson;
import org.springframework.transaction.annotation.Transactional;

@Entity
@Configurable
@RooJavaBean
@RooToString
@RooJpaActiveRecord(finders = { "findPartidoesByTorneoEquipoLocalAndTorneoEquipoVisitanteAndEquipoLocalAndEquipoVisitante", "findPartidoesByTorneoEquipoLocalOrTorneoEquipoVisitanteAndEquipoLocalOrEquipoVisitante", "findPartidoesByTorneoEquipoLocalOrTorneoEquipoVisitante", "findPartidoesByTorneoEquipoLocalAndTorneoEquipoVisitanteAndEquipoLocalAndEquipoVisitanteAndStatus", "findPartidoesByTorneoEquipoLocalOrTorneoEquipoVisitanteAndEquipoLocalOrEquipoVisitanteAndStatus", "findPartidoesByTorneoEquipoLocalOrTorneoEquipoVisitanteAndStatus", "findPartidoesByCanchaAndStatusAndFechaJuegoBetween", "findPartidoesByCanchaAndStatusAndFechaJuegoEquals", "findPartidoesByCanchaAndStatus", "findPartidoesByFechaJuegoBetweenAndStatus", "findPartidoesByFechaJuegoEqualsAndStatus", "findPartidoesByCancha" })
@RooJson(deepSerialize = true)
public class Partido {

    /**
     */
    @NotNull
    @ManyToOne
    private Cancha cancha;

    /**
     */
    @ManyToMany(cascade = CascadeType.ALL)
    private Set<Usuario> arbitros = new HashSet<Usuario>();

    /**
     */
    @ManyToOne
    private Torneo torneoEquipoLocal;

    /**
     */
    @ManyToOne
    private Equipo equipoLocal;

    /**
     */
    @ManyToOne
    private Torneo torneoEquipoVisitante;

    /**
     */
    @ManyToOne
    private Equipo equipoVisitante;

    /**
     */
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(style = "M-")
    private Date fechaJuego;

    /**
     */
    @ManyToOne
    private Horario horario;

    /**
     */
    @ManyToOne
    private TipoPartido tipoPartido;

    /**
     */
    @NotNull
    @ManyToOne
    private StatusPartido status;

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

	public static final List<String> fieldNames4OrderClauseFilter = java.util.Arrays.asList("cancha", "arbitros", "torneoEquipoLocal", "equipoLocal", "torneoEquipoVisitante", "equipoVisitante", "fechaJuego", "horario", "tipoPartido", "status", "usuario", "fechaCreacion", "fechaModificacion");

	public static final EntityManager entityManager() {
        EntityManager em = new Partido().entityManager;
        if (em == null) throw new IllegalStateException("Entity manager has not been injected (is the Spring Aspects JAR configured as an AJC/AJDT aspects library?)");
        return em;
    }

	public static long countPartidoes() {
        return entityManager().createQuery("SELECT COUNT(o) FROM Partido o", Long.class).getSingleResult();
    }

	public static List<Partido> findAllPartidoes() {
        return entityManager().createQuery("SELECT o FROM Partido o", Partido.class).getResultList();
    }

	public static List<Partido> findAllPartidoes(String sortFieldName, String sortOrder) {
        String jpaQuery = "SELECT o FROM Partido o";
        if (fieldNames4OrderClauseFilter.contains(sortFieldName)) {
            jpaQuery = jpaQuery + " ORDER BY " + sortFieldName;
            if ("ASC".equalsIgnoreCase(sortOrder) || "DESC".equalsIgnoreCase(sortOrder)) {
                jpaQuery = jpaQuery + " " + sortOrder;
            }
        }
        return entityManager().createQuery(jpaQuery, Partido.class).getResultList();
    }

	public static Partido findPartido(Long id) {
        if (id == null) return null;
        return entityManager().find(Partido.class, id);
    }

	public static List<Partido> findPartidoEntries(int firstResult, int maxResults) {
        return entityManager().createQuery("SELECT o FROM Partido o", Partido.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }

	public static List<Partido> findPartidoEntries(int firstResult, int maxResults, String sortFieldName, String sortOrder) {
        String jpaQuery = "SELECT o FROM Partido o";
        if (fieldNames4OrderClauseFilter.contains(sortFieldName)) {
            jpaQuery = jpaQuery + " ORDER BY " + sortFieldName;
            if ("ASC".equalsIgnoreCase(sortOrder) || "DESC".equalsIgnoreCase(sortOrder)) {
                jpaQuery = jpaQuery + " " + sortOrder;
            }
        }
        return entityManager().createQuery(jpaQuery, Partido.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
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
            Partido attached = Partido.findPartido(this.id);
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
    public Partido merge() {
        if (this.entityManager == null) this.entityManager = entityManager();
        Partido merged = this.entityManager.merge(this);
        this.entityManager.flush();
        return merged;
    }

	public static Long countFindPartidoesByCancha(Cancha cancha) {
        if (cancha == null) throw new IllegalArgumentException("The cancha argument is required");
        EntityManager em = Partido.entityManager();
        TypedQuery q = em.createQuery("SELECT COUNT(o) FROM Partido AS o WHERE o.cancha = :cancha", Long.class);
        q.setParameter("cancha", cancha);
        return ((Long) q.getSingleResult());
    }

	public static Long countFindPartidoesByCanchaAndStatus(Cancha cancha, StatusPartido status) {
        if (cancha == null) throw new IllegalArgumentException("The cancha argument is required");
        if (status == null) throw new IllegalArgumentException("The status argument is required");
        EntityManager em = Partido.entityManager();
        TypedQuery q = em.createQuery("SELECT COUNT(o) FROM Partido AS o WHERE o.cancha = :cancha AND o.status = :status", Long.class);
        q.setParameter("cancha", cancha);
        q.setParameter("status", status);
        return ((Long) q.getSingleResult());
    }

	public static Long countFindPartidoesByCanchaAndStatusAndFechaJuegoBetween(Cancha cancha, StatusPartido status, Date minFechaJuego, Date maxFechaJuego) {
        if (cancha == null) throw new IllegalArgumentException("The cancha argument is required");
        if (status == null) throw new IllegalArgumentException("The status argument is required");
        if (minFechaJuego == null) throw new IllegalArgumentException("The minFechaJuego argument is required");
        if (maxFechaJuego == null) throw new IllegalArgumentException("The maxFechaJuego argument is required");
        EntityManager em = Partido.entityManager();
        TypedQuery q = em.createQuery("SELECT COUNT(o) FROM Partido AS o WHERE o.cancha = :cancha AND o.status = :status AND o.fechaJuego BETWEEN :minFechaJuego AND :maxFechaJuego", Long.class);
        q.setParameter("cancha", cancha);
        q.setParameter("status", status);
        q.setParameter("minFechaJuego", minFechaJuego);
        q.setParameter("maxFechaJuego", maxFechaJuego);
        return ((Long) q.getSingleResult());
    }

	public static Long countFindPartidoesByCanchaAndStatusAndFechaJuegoEquals(Cancha cancha, StatusPartido status, Date fechaJuego) {
        if (cancha == null) throw new IllegalArgumentException("The cancha argument is required");
        if (status == null) throw new IllegalArgumentException("The status argument is required");
        if (fechaJuego == null) throw new IllegalArgumentException("The fechaJuego argument is required");
        EntityManager em = Partido.entityManager();
        TypedQuery q = em.createQuery("SELECT COUNT(o) FROM Partido AS o WHERE o.cancha = :cancha AND o.status = :status AND o.fechaJuego = :fechaJuego", Long.class);
        q.setParameter("cancha", cancha);
        q.setParameter("status", status);
        q.setParameter("fechaJuego", fechaJuego);
        return ((Long) q.getSingleResult());
    }

	public static Long countFindPartidoesByFechaJuegoBetweenAndStatus(Date minFechaJuego, Date maxFechaJuego, StatusPartido status) {
        if (minFechaJuego == null) throw new IllegalArgumentException("The minFechaJuego argument is required");
        if (maxFechaJuego == null) throw new IllegalArgumentException("The maxFechaJuego argument is required");
        if (status == null) throw new IllegalArgumentException("The status argument is required");
        EntityManager em = Partido.entityManager();
        TypedQuery q = em.createQuery("SELECT COUNT(o) FROM Partido AS o WHERE o.fechaJuego BETWEEN :minFechaJuego AND :maxFechaJuego  AND o.status = :status", Long.class);
        q.setParameter("minFechaJuego", minFechaJuego);
        q.setParameter("maxFechaJuego", maxFechaJuego);
        q.setParameter("status", status);
        return ((Long) q.getSingleResult());
    }

	public static Long countFindPartidoesByFechaJuegoEqualsAndStatus(Date fechaJuego, StatusPartido status) {
        if (fechaJuego == null) throw new IllegalArgumentException("The fechaJuego argument is required");
        if (status == null) throw new IllegalArgumentException("The status argument is required");
        EntityManager em = Partido.entityManager();
        TypedQuery q = em.createQuery("SELECT COUNT(o) FROM Partido AS o WHERE o.fechaJuego = :fechaJuego  AND o.status = :status", Long.class);
        q.setParameter("fechaJuego", fechaJuego);
        q.setParameter("status", status);
        return ((Long) q.getSingleResult());
    }

	public static Long countFindPartidoesByTorneoEquipoLocalAndTorneoEquipoVisitanteAndEquipoLocalAndEquipoVisitante(Torneo torneoEquipoLocal, Torneo torneoEquipoVisitante, Equipo equipoLocal, Equipo equipoVisitante) {
        if (torneoEquipoLocal == null) throw new IllegalArgumentException("The torneoEquipoLocal argument is required");
        if (torneoEquipoVisitante == null) throw new IllegalArgumentException("The torneoEquipoVisitante argument is required");
        if (equipoLocal == null) throw new IllegalArgumentException("The equipoLocal argument is required");
        if (equipoVisitante == null) throw new IllegalArgumentException("The equipoVisitante argument is required");
        EntityManager em = Partido.entityManager();
        TypedQuery q = em.createQuery("SELECT COUNT(o) FROM Partido AS o WHERE o.torneoEquipoLocal = :torneoEquipoLocal AND o.torneoEquipoVisitante = :torneoEquipoVisitante AND o.equipoLocal = :equipoLocal AND o.equipoVisitante = :equipoVisitante", Long.class);
        q.setParameter("torneoEquipoLocal", torneoEquipoLocal);
        q.setParameter("torneoEquipoVisitante", torneoEquipoVisitante);
        q.setParameter("equipoLocal", equipoLocal);
        q.setParameter("equipoVisitante", equipoVisitante);
        return ((Long) q.getSingleResult());
    }

	public static Long countFindPartidoesByTorneoEquipoLocalAndTorneoEquipoVisitanteAndEquipoLocalAndEquipoVisitanteAndStatus(Torneo torneoEquipoLocal, Torneo torneoEquipoVisitante, Equipo equipoLocal, Equipo equipoVisitante, StatusPartido status) {
        if (torneoEquipoLocal == null) throw new IllegalArgumentException("The torneoEquipoLocal argument is required");
        if (torneoEquipoVisitante == null) throw new IllegalArgumentException("The torneoEquipoVisitante argument is required");
        if (equipoLocal == null) throw new IllegalArgumentException("The equipoLocal argument is required");
        if (equipoVisitante == null) throw new IllegalArgumentException("The equipoVisitante argument is required");
        if (status == null) throw new IllegalArgumentException("The status argument is required");
        EntityManager em = Partido.entityManager();
        TypedQuery q = em.createQuery("SELECT COUNT(o) FROM Partido AS o WHERE o.torneoEquipoLocal = :torneoEquipoLocal AND o.torneoEquipoVisitante = :torneoEquipoVisitante AND o.equipoLocal = :equipoLocal AND o.equipoVisitante = :equipoVisitante AND o.status = :status", Long.class);
        q.setParameter("torneoEquipoLocal", torneoEquipoLocal);
        q.setParameter("torneoEquipoVisitante", torneoEquipoVisitante);
        q.setParameter("equipoLocal", equipoLocal);
        q.setParameter("equipoVisitante", equipoVisitante);
        q.setParameter("status", status);
        return ((Long) q.getSingleResult());
    }

	public static Long countFindPartidoesByTorneoEquipoLocalOrTorneoEquipoVisitante(Torneo torneoEquipoLocal, Torneo torneoEquipoVisitante) {
        if (torneoEquipoLocal == null) throw new IllegalArgumentException("The torneoEquipoLocal argument is required");
        if (torneoEquipoVisitante == null) throw new IllegalArgumentException("The torneoEquipoVisitante argument is required");
        EntityManager em = Partido.entityManager();
        TypedQuery q = em.createQuery("SELECT COUNT(o) FROM Partido AS o WHERE o.torneoEquipoLocal = :torneoEquipoLocal OR o.torneoEquipoVisitante = :torneoEquipoVisitante", Long.class);
        q.setParameter("torneoEquipoLocal", torneoEquipoLocal);
        q.setParameter("torneoEquipoVisitante", torneoEquipoVisitante);
        return ((Long) q.getSingleResult());
    }

	public static Long countFindPartidoesByTorneoEquipoLocalOrTorneoEquipoVisitanteAndEquipoLocalOrEquipoVisitante(Torneo torneoEquipoLocal, Torneo torneoEquipoVisitante, Equipo equipoLocal, Equipo equipoVisitante) {
        if (torneoEquipoLocal == null) throw new IllegalArgumentException("The torneoEquipoLocal argument is required");
        if (torneoEquipoVisitante == null) throw new IllegalArgumentException("The torneoEquipoVisitante argument is required");
        if (equipoLocal == null) throw new IllegalArgumentException("The equipoLocal argument is required");
        if (equipoVisitante == null) throw new IllegalArgumentException("The equipoVisitante argument is required");
        EntityManager em = Partido.entityManager();
        TypedQuery q = em.createQuery("SELECT COUNT(o) FROM Partido AS o WHERE o.torneoEquipoLocal = :torneoEquipoLocal OR o.torneoEquipoVisitante = :torneoEquipoVisitante AND o.equipoLocal = :equipoLocal OR o.equipoVisitante = :equipoVisitante", Long.class);
        q.setParameter("torneoEquipoLocal", torneoEquipoLocal);
        q.setParameter("torneoEquipoVisitante", torneoEquipoVisitante);
        q.setParameter("equipoLocal", equipoLocal);
        q.setParameter("equipoVisitante", equipoVisitante);
        return ((Long) q.getSingleResult());
    }

	public static Long countFindPartidoesByTorneoEquipoLocalOrTorneoEquipoVisitanteAndEquipoLocalOrEquipoVisitanteAndStatus(Torneo torneoEquipoLocal, Torneo torneoEquipoVisitante, Equipo equipoLocal, Equipo equipoVisitante, StatusPartido status) {
        if (torneoEquipoLocal == null) throw new IllegalArgumentException("The torneoEquipoLocal argument is required");
        if (torneoEquipoVisitante == null) throw new IllegalArgumentException("The torneoEquipoVisitante argument is required");
        if (equipoLocal == null) throw new IllegalArgumentException("The equipoLocal argument is required");
        if (equipoVisitante == null) throw new IllegalArgumentException("The equipoVisitante argument is required");
        if (status == null) throw new IllegalArgumentException("The status argument is required");
        EntityManager em = Partido.entityManager();
        TypedQuery q = em.createQuery("SELECT COUNT(o) FROM Partido AS o WHERE o.torneoEquipoLocal = :torneoEquipoLocal OR o.torneoEquipoVisitante = :torneoEquipoVisitante AND o.equipoLocal = :equipoLocal OR o.equipoVisitante = :equipoVisitante AND o.status = :status", Long.class);
        q.setParameter("torneoEquipoLocal", torneoEquipoLocal);
        q.setParameter("torneoEquipoVisitante", torneoEquipoVisitante);
        q.setParameter("equipoLocal", equipoLocal);
        q.setParameter("equipoVisitante", equipoVisitante);
        q.setParameter("status", status);
        return ((Long) q.getSingleResult());
    }

	public static Long countFindPartidoesByTorneoEquipoLocalOrTorneoEquipoVisitanteAndStatus(Torneo torneoEquipoLocal, Torneo torneoEquipoVisitante, StatusPartido status) {
        if (torneoEquipoLocal == null) throw new IllegalArgumentException("The torneoEquipoLocal argument is required");
        if (torneoEquipoVisitante == null) throw new IllegalArgumentException("The torneoEquipoVisitante argument is required");
        if (status == null) throw new IllegalArgumentException("The status argument is required");
        EntityManager em = Partido.entityManager();
        TypedQuery q = em.createQuery("SELECT COUNT(o) FROM Partido AS o WHERE o.torneoEquipoLocal = :torneoEquipoLocal OR o.torneoEquipoVisitante = :torneoEquipoVisitante AND o.status = :status", Long.class);
        q.setParameter("torneoEquipoLocal", torneoEquipoLocal);
        q.setParameter("torneoEquipoVisitante", torneoEquipoVisitante);
        q.setParameter("status", status);
        return ((Long) q.getSingleResult());
    }

	public static TypedQuery<Partido> findPartidoesByCancha(Cancha cancha) {
        if (cancha == null) throw new IllegalArgumentException("The cancha argument is required");
        EntityManager em = Partido.entityManager();
        TypedQuery<Partido> q = em.createQuery("SELECT o FROM Partido AS o WHERE o.cancha = :cancha", Partido.class);
        q.setParameter("cancha", cancha);
        return q;
    }

	public static TypedQuery<Partido> findPartidoesByCancha(Cancha cancha, String sortFieldName, String sortOrder) {
        if (cancha == null) throw new IllegalArgumentException("The cancha argument is required");
        EntityManager em = Partido.entityManager();
        String jpaQuery = "SELECT o FROM Partido AS o WHERE o.cancha = :cancha";
        if (fieldNames4OrderClauseFilter.contains(sortFieldName)) {
            jpaQuery = jpaQuery + " ORDER BY " + sortFieldName;
            if ("ASC".equalsIgnoreCase(sortOrder) || "DESC".equalsIgnoreCase(sortOrder)) {
                jpaQuery = jpaQuery + " " + sortOrder;
            }
        }
        TypedQuery<Partido> q = em.createQuery(jpaQuery, Partido.class);
        q.setParameter("cancha", cancha);
        return q;
    }

	public static TypedQuery<Partido> findPartidoesByCanchaAndStatus(Cancha cancha, StatusPartido status) {
        if (cancha == null) throw new IllegalArgumentException("The cancha argument is required");
        if (status == null) throw new IllegalArgumentException("The status argument is required");
        EntityManager em = Partido.entityManager();
        TypedQuery<Partido> q = em.createQuery("SELECT o FROM Partido AS o WHERE o.cancha = :cancha AND o.status = :status", Partido.class);
        q.setParameter("cancha", cancha);
        q.setParameter("status", status);
        return q;
    }

	public static TypedQuery<Partido> findPartidoesByCanchaAndStatus(Cancha cancha, StatusPartido status, String sortFieldName, String sortOrder) {
        if (cancha == null) throw new IllegalArgumentException("The cancha argument is required");
        if (status == null) throw new IllegalArgumentException("The status argument is required");
        EntityManager em = Partido.entityManager();
        String jpaQuery = "SELECT o FROM Partido AS o WHERE o.cancha = :cancha AND o.status = :status";
        if (fieldNames4OrderClauseFilter.contains(sortFieldName)) {
            jpaQuery = jpaQuery + " ORDER BY " + sortFieldName;
            if ("ASC".equalsIgnoreCase(sortOrder) || "DESC".equalsIgnoreCase(sortOrder)) {
                jpaQuery = jpaQuery + " " + sortOrder;
            }
        }
        TypedQuery<Partido> q = em.createQuery(jpaQuery, Partido.class);
        q.setParameter("cancha", cancha);
        q.setParameter("status", status);
        return q;
    }

	public static TypedQuery<Partido> findPartidoesByCanchaAndStatusAndFechaJuegoBetween(Cancha cancha, StatusPartido status, Date minFechaJuego, Date maxFechaJuego) {
        if (cancha == null) throw new IllegalArgumentException("The cancha argument is required");
        if (status == null) throw new IllegalArgumentException("The status argument is required");
        if (minFechaJuego == null) throw new IllegalArgumentException("The minFechaJuego argument is required");
        if (maxFechaJuego == null) throw new IllegalArgumentException("The maxFechaJuego argument is required");
        EntityManager em = Partido.entityManager();
        TypedQuery<Partido> q = em.createQuery("SELECT o FROM Partido AS o WHERE o.cancha = :cancha AND o.status = :status AND o.fechaJuego BETWEEN :minFechaJuego AND :maxFechaJuego", Partido.class);
        q.setParameter("cancha", cancha);
        q.setParameter("status", status);
        q.setParameter("minFechaJuego", minFechaJuego);
        q.setParameter("maxFechaJuego", maxFechaJuego);
        return q;
    }

	public static TypedQuery<Partido> findPartidoesByCanchaAndStatusAndFechaJuegoBetween(Cancha cancha, StatusPartido status, Date minFechaJuego, Date maxFechaJuego, String sortFieldName, String sortOrder) {
        if (cancha == null) throw new IllegalArgumentException("The cancha argument is required");
        if (status == null) throw new IllegalArgumentException("The status argument is required");
        if (minFechaJuego == null) throw new IllegalArgumentException("The minFechaJuego argument is required");
        if (maxFechaJuego == null) throw new IllegalArgumentException("The maxFechaJuego argument is required");
        EntityManager em = Partido.entityManager();
        String jpaQuery = "SELECT o FROM Partido AS o WHERE o.cancha = :cancha AND o.status = :status AND o.fechaJuego BETWEEN :minFechaJuego AND :maxFechaJuego";
        if (fieldNames4OrderClauseFilter.contains(sortFieldName)) {
            jpaQuery = jpaQuery + " ORDER BY " + sortFieldName;
            if ("ASC".equalsIgnoreCase(sortOrder) || "DESC".equalsIgnoreCase(sortOrder)) {
                jpaQuery = jpaQuery + " " + sortOrder;
            }
        }
        TypedQuery<Partido> q = em.createQuery(jpaQuery, Partido.class);
        q.setParameter("cancha", cancha);
        q.setParameter("status", status);
        q.setParameter("minFechaJuego", minFechaJuego);
        q.setParameter("maxFechaJuego", maxFechaJuego);
        return q;
    }

	public static TypedQuery<Partido> findPartidoesByCanchaAndStatusAndFechaJuegoEquals(Cancha cancha, StatusPartido status, Date fechaJuego) {
        if (cancha == null) throw new IllegalArgumentException("The cancha argument is required");
        if (status == null) throw new IllegalArgumentException("The status argument is required");
        if (fechaJuego == null) throw new IllegalArgumentException("The fechaJuego argument is required");
        EntityManager em = Partido.entityManager();
        TypedQuery<Partido> q = em.createQuery("SELECT o FROM Partido AS o WHERE o.cancha = :cancha AND o.status = :status AND o.fechaJuego = :fechaJuego", Partido.class);
        q.setParameter("cancha", cancha);
        q.setParameter("status", status);
        q.setParameter("fechaJuego", fechaJuego);
        return q;
    }

	public static TypedQuery<Partido> findPartidoesByCanchaAndStatusAndFechaJuegoEquals(Cancha cancha, StatusPartido status, Date fechaJuego, String sortFieldName, String sortOrder) {
        if (cancha == null) throw new IllegalArgumentException("The cancha argument is required");
        if (status == null) throw new IllegalArgumentException("The status argument is required");
        if (fechaJuego == null) throw new IllegalArgumentException("The fechaJuego argument is required");
        EntityManager em = Partido.entityManager();
        String jpaQuery = "SELECT o FROM Partido AS o WHERE o.cancha = :cancha AND o.status = :status AND o.fechaJuego = :fechaJuego";
        if (fieldNames4OrderClauseFilter.contains(sortFieldName)) {
            jpaQuery = jpaQuery + " ORDER BY " + sortFieldName;
            if ("ASC".equalsIgnoreCase(sortOrder) || "DESC".equalsIgnoreCase(sortOrder)) {
                jpaQuery = jpaQuery + " " + sortOrder;
            }
        }
        TypedQuery<Partido> q = em.createQuery(jpaQuery, Partido.class);
        q.setParameter("cancha", cancha);
        q.setParameter("status", status);
        q.setParameter("fechaJuego", fechaJuego);
        return q;
    }

	public static TypedQuery<Partido> findPartidoesByFechaJuegoBetweenAndStatus(Date minFechaJuego, Date maxFechaJuego, StatusPartido status) {
        if (minFechaJuego == null) throw new IllegalArgumentException("The minFechaJuego argument is required");
        if (maxFechaJuego == null) throw new IllegalArgumentException("The maxFechaJuego argument is required");
        if (status == null) throw new IllegalArgumentException("The status argument is required");
        EntityManager em = Partido.entityManager();
        TypedQuery<Partido> q = em.createQuery("SELECT o FROM Partido AS o WHERE o.fechaJuego BETWEEN :minFechaJuego AND :maxFechaJuego  AND o.status = :status", Partido.class);
        q.setParameter("minFechaJuego", minFechaJuego);
        q.setParameter("maxFechaJuego", maxFechaJuego);
        q.setParameter("status", status);
        return q;
    }

	public static TypedQuery<Partido> findPartidoesByFechaJuegoBetweenAndStatus(Date minFechaJuego, Date maxFechaJuego, StatusPartido status, String sortFieldName, String sortOrder) {
        if (minFechaJuego == null) throw new IllegalArgumentException("The minFechaJuego argument is required");
        if (maxFechaJuego == null) throw new IllegalArgumentException("The maxFechaJuego argument is required");
        if (status == null) throw new IllegalArgumentException("The status argument is required");
        EntityManager em = Partido.entityManager();
        String jpaQuery = "SELECT o FROM Partido AS o WHERE o.fechaJuego BETWEEN :minFechaJuego AND :maxFechaJuego  AND o.status = :status";
        if (fieldNames4OrderClauseFilter.contains(sortFieldName)) {
            jpaQuery = jpaQuery + " ORDER BY " + sortFieldName;
            if ("ASC".equalsIgnoreCase(sortOrder) || "DESC".equalsIgnoreCase(sortOrder)) {
                jpaQuery = jpaQuery + " " + sortOrder;
            }
        }
        TypedQuery<Partido> q = em.createQuery(jpaQuery, Partido.class);
        q.setParameter("minFechaJuego", minFechaJuego);
        q.setParameter("maxFechaJuego", maxFechaJuego);
        q.setParameter("status", status);
        return q;
    }

	public static TypedQuery<Partido> findPartidoesByFechaJuegoEqualsAndStatus(Date fechaJuego, StatusPartido status) {
        if (fechaJuego == null) throw new IllegalArgumentException("The fechaJuego argument is required");
        if (status == null) throw new IllegalArgumentException("The status argument is required");
        EntityManager em = Partido.entityManager();
        TypedQuery<Partido> q = em.createQuery("SELECT o FROM Partido AS o WHERE o.fechaJuego = :fechaJuego  AND o.status = :status", Partido.class);
        q.setParameter("fechaJuego", fechaJuego);
        q.setParameter("status", status);
        return q;
    }

	public static TypedQuery<Partido> findPartidoesByFechaJuegoEqualsAndStatus(Date fechaJuego, StatusPartido status, String sortFieldName, String sortOrder) {
        if (fechaJuego == null) throw new IllegalArgumentException("The fechaJuego argument is required");
        if (status == null) throw new IllegalArgumentException("The status argument is required");
        EntityManager em = Partido.entityManager();
        String jpaQuery = "SELECT o FROM Partido AS o WHERE o.fechaJuego = :fechaJuego  AND o.status = :status";
        if (fieldNames4OrderClauseFilter.contains(sortFieldName)) {
            jpaQuery = jpaQuery + " ORDER BY " + sortFieldName;
            if ("ASC".equalsIgnoreCase(sortOrder) || "DESC".equalsIgnoreCase(sortOrder)) {
                jpaQuery = jpaQuery + " " + sortOrder;
            }
        }
        TypedQuery<Partido> q = em.createQuery(jpaQuery, Partido.class);
        q.setParameter("fechaJuego", fechaJuego);
        q.setParameter("status", status);
        return q;
    }

	public static TypedQuery<Partido> findPartidoesByTorneoEquipoLocalAndTorneoEquipoVisitanteAndEquipoLocalAndEquipoVisitante(Torneo torneoEquipoLocal, Torneo torneoEquipoVisitante, Equipo equipoLocal, Equipo equipoVisitante) {
        if (torneoEquipoLocal == null) throw new IllegalArgumentException("The torneoEquipoLocal argument is required");
        if (torneoEquipoVisitante == null) throw new IllegalArgumentException("The torneoEquipoVisitante argument is required");
        if (equipoLocal == null) throw new IllegalArgumentException("The equipoLocal argument is required");
        if (equipoVisitante == null) throw new IllegalArgumentException("The equipoVisitante argument is required");
        EntityManager em = Partido.entityManager();
        TypedQuery<Partido> q = em.createQuery("SELECT o FROM Partido AS o WHERE o.torneoEquipoLocal = :torneoEquipoLocal AND o.torneoEquipoVisitante = :torneoEquipoVisitante AND o.equipoLocal = :equipoLocal AND o.equipoVisitante = :equipoVisitante", Partido.class);
        q.setParameter("torneoEquipoLocal", torneoEquipoLocal);
        q.setParameter("torneoEquipoVisitante", torneoEquipoVisitante);
        q.setParameter("equipoLocal", equipoLocal);
        q.setParameter("equipoVisitante", equipoVisitante);
        return q;
    }

	public static TypedQuery<Partido> findPartidoesByTorneoEquipoLocalAndTorneoEquipoVisitanteAndEquipoLocalAndEquipoVisitante(Torneo torneoEquipoLocal, Torneo torneoEquipoVisitante, Equipo equipoLocal, Equipo equipoVisitante, String sortFieldName, String sortOrder) {
        if (torneoEquipoLocal == null) throw new IllegalArgumentException("The torneoEquipoLocal argument is required");
        if (torneoEquipoVisitante == null) throw new IllegalArgumentException("The torneoEquipoVisitante argument is required");
        if (equipoLocal == null) throw new IllegalArgumentException("The equipoLocal argument is required");
        if (equipoVisitante == null) throw new IllegalArgumentException("The equipoVisitante argument is required");
        EntityManager em = Partido.entityManager();
        String jpaQuery = "SELECT o FROM Partido AS o WHERE o.torneoEquipoLocal = :torneoEquipoLocal AND o.torneoEquipoVisitante = :torneoEquipoVisitante AND o.equipoLocal = :equipoLocal AND o.equipoVisitante = :equipoVisitante";
        if (fieldNames4OrderClauseFilter.contains(sortFieldName)) {
            jpaQuery = jpaQuery + " ORDER BY " + sortFieldName;
            if ("ASC".equalsIgnoreCase(sortOrder) || "DESC".equalsIgnoreCase(sortOrder)) {
                jpaQuery = jpaQuery + " " + sortOrder;
            }
        }
        TypedQuery<Partido> q = em.createQuery(jpaQuery, Partido.class);
        q.setParameter("torneoEquipoLocal", torneoEquipoLocal);
        q.setParameter("torneoEquipoVisitante", torneoEquipoVisitante);
        q.setParameter("equipoLocal", equipoLocal);
        q.setParameter("equipoVisitante", equipoVisitante);
        return q;
    }

	public static TypedQuery<Partido> findPartidoesByTorneoEquipoLocalAndTorneoEquipoVisitanteAndEquipoLocalAndEquipoVisitanteAndStatus(Torneo torneoEquipoLocal, Torneo torneoEquipoVisitante, Equipo equipoLocal, Equipo equipoVisitante, StatusPartido status) {
        if (torneoEquipoLocal == null) throw new IllegalArgumentException("The torneoEquipoLocal argument is required");
        if (torneoEquipoVisitante == null) throw new IllegalArgumentException("The torneoEquipoVisitante argument is required");
        if (equipoLocal == null) throw new IllegalArgumentException("The equipoLocal argument is required");
        if (equipoVisitante == null) throw new IllegalArgumentException("The equipoVisitante argument is required");
        if (status == null) throw new IllegalArgumentException("The status argument is required");
        EntityManager em = Partido.entityManager();
        TypedQuery<Partido> q = em.createQuery("SELECT o FROM Partido AS o WHERE o.torneoEquipoLocal = :torneoEquipoLocal AND o.torneoEquipoVisitante = :torneoEquipoVisitante AND o.equipoLocal = :equipoLocal AND o.equipoVisitante = :equipoVisitante AND o.status = :status", Partido.class);
        q.setParameter("torneoEquipoLocal", torneoEquipoLocal);
        q.setParameter("torneoEquipoVisitante", torneoEquipoVisitante);
        q.setParameter("equipoLocal", equipoLocal);
        q.setParameter("equipoVisitante", equipoVisitante);
        q.setParameter("status", status);
        return q;
    }

	public static TypedQuery<Partido> findPartidoesByTorneoEquipoLocalAndTorneoEquipoVisitanteAndEquipoLocalAndEquipoVisitanteAndStatus(Torneo torneoEquipoLocal, Torneo torneoEquipoVisitante, Equipo equipoLocal, Equipo equipoVisitante, StatusPartido status, String sortFieldName, String sortOrder) {
        if (torneoEquipoLocal == null) throw new IllegalArgumentException("The torneoEquipoLocal argument is required");
        if (torneoEquipoVisitante == null) throw new IllegalArgumentException("The torneoEquipoVisitante argument is required");
        if (equipoLocal == null) throw new IllegalArgumentException("The equipoLocal argument is required");
        if (equipoVisitante == null) throw new IllegalArgumentException("The equipoVisitante argument is required");
        if (status == null) throw new IllegalArgumentException("The status argument is required");
        EntityManager em = Partido.entityManager();
        String jpaQuery = "SELECT o FROM Partido AS o WHERE o.torneoEquipoLocal = :torneoEquipoLocal AND o.torneoEquipoVisitante = :torneoEquipoVisitante AND o.equipoLocal = :equipoLocal AND o.equipoVisitante = :equipoVisitante AND o.status = :status";
        if (fieldNames4OrderClauseFilter.contains(sortFieldName)) {
            jpaQuery = jpaQuery + " ORDER BY " + sortFieldName;
            if ("ASC".equalsIgnoreCase(sortOrder) || "DESC".equalsIgnoreCase(sortOrder)) {
                jpaQuery = jpaQuery + " " + sortOrder;
            }
        }
        TypedQuery<Partido> q = em.createQuery(jpaQuery, Partido.class);
        q.setParameter("torneoEquipoLocal", torneoEquipoLocal);
        q.setParameter("torneoEquipoVisitante", torneoEquipoVisitante);
        q.setParameter("equipoLocal", equipoLocal);
        q.setParameter("equipoVisitante", equipoVisitante);
        q.setParameter("status", status);
        return q;
    }

	public static TypedQuery<Partido> findPartidoesByTorneoEquipoLocalOrTorneoEquipoVisitante(Torneo torneoEquipoLocal, Torneo torneoEquipoVisitante) {
        if (torneoEquipoLocal == null) throw new IllegalArgumentException("The torneoEquipoLocal argument is required");
        if (torneoEquipoVisitante == null) throw new IllegalArgumentException("The torneoEquipoVisitante argument is required");
        EntityManager em = Partido.entityManager();
        TypedQuery<Partido> q = em.createQuery("SELECT o FROM Partido AS o WHERE o.torneoEquipoLocal = :torneoEquipoLocal OR o.torneoEquipoVisitante = :torneoEquipoVisitante", Partido.class);
        q.setParameter("torneoEquipoLocal", torneoEquipoLocal);
        q.setParameter("torneoEquipoVisitante", torneoEquipoVisitante);
        return q;
    }

	public static TypedQuery<Partido> findPartidoesByTorneoEquipoLocalOrTorneoEquipoVisitante(Torneo torneoEquipoLocal, Torneo torneoEquipoVisitante, String sortFieldName, String sortOrder) {
        if (torneoEquipoLocal == null) throw new IllegalArgumentException("The torneoEquipoLocal argument is required");
        if (torneoEquipoVisitante == null) throw new IllegalArgumentException("The torneoEquipoVisitante argument is required");
        EntityManager em = Partido.entityManager();
        String jpaQuery = "SELECT o FROM Partido AS o WHERE o.torneoEquipoLocal = :torneoEquipoLocal OR o.torneoEquipoVisitante = :torneoEquipoVisitante";
        if (fieldNames4OrderClauseFilter.contains(sortFieldName)) {
            jpaQuery = jpaQuery + " ORDER BY " + sortFieldName;
            if ("ASC".equalsIgnoreCase(sortOrder) || "DESC".equalsIgnoreCase(sortOrder)) {
                jpaQuery = jpaQuery + " " + sortOrder;
            }
        }
        TypedQuery<Partido> q = em.createQuery(jpaQuery, Partido.class);
        q.setParameter("torneoEquipoLocal", torneoEquipoLocal);
        q.setParameter("torneoEquipoVisitante", torneoEquipoVisitante);
        return q;
    }

	public static TypedQuery<Partido> findPartidoesByTorneoEquipoLocalOrTorneoEquipoVisitanteAndEquipoLocalOrEquipoVisitante(Torneo torneoEquipoLocal, Torneo torneoEquipoVisitante, Equipo equipoLocal, Equipo equipoVisitante) {
        if (torneoEquipoLocal == null) throw new IllegalArgumentException("The torneoEquipoLocal argument is required");
        if (torneoEquipoVisitante == null) throw new IllegalArgumentException("The torneoEquipoVisitante argument is required");
        if (equipoLocal == null) throw new IllegalArgumentException("The equipoLocal argument is required");
        if (equipoVisitante == null) throw new IllegalArgumentException("The equipoVisitante argument is required");
        EntityManager em = Partido.entityManager();
        TypedQuery<Partido> q = em.createQuery("SELECT o FROM Partido AS o WHERE o.torneoEquipoLocal = :torneoEquipoLocal OR o.torneoEquipoVisitante = :torneoEquipoVisitante AND o.equipoLocal = :equipoLocal OR o.equipoVisitante = :equipoVisitante", Partido.class);
        q.setParameter("torneoEquipoLocal", torneoEquipoLocal);
        q.setParameter("torneoEquipoVisitante", torneoEquipoVisitante);
        q.setParameter("equipoLocal", equipoLocal);
        q.setParameter("equipoVisitante", equipoVisitante);
        return q;
    }

	public static TypedQuery<Partido> findPartidoesByTorneoEquipoLocalOrTorneoEquipoVisitanteAndEquipoLocalOrEquipoVisitante(Torneo torneoEquipoLocal, Torneo torneoEquipoVisitante, Equipo equipoLocal, Equipo equipoVisitante, String sortFieldName, String sortOrder) {
        if (torneoEquipoLocal == null) throw new IllegalArgumentException("The torneoEquipoLocal argument is required");
        if (torneoEquipoVisitante == null) throw new IllegalArgumentException("The torneoEquipoVisitante argument is required");
        if (equipoLocal == null) throw new IllegalArgumentException("The equipoLocal argument is required");
        if (equipoVisitante == null) throw new IllegalArgumentException("The equipoVisitante argument is required");
        EntityManager em = Partido.entityManager();
        String jpaQuery = "SELECT o FROM Partido AS o WHERE o.torneoEquipoLocal = :torneoEquipoLocal OR o.torneoEquipoVisitante = :torneoEquipoVisitante AND o.equipoLocal = :equipoLocal OR o.equipoVisitante = :equipoVisitante";
        if (fieldNames4OrderClauseFilter.contains(sortFieldName)) {
            jpaQuery = jpaQuery + " ORDER BY " + sortFieldName;
            if ("ASC".equalsIgnoreCase(sortOrder) || "DESC".equalsIgnoreCase(sortOrder)) {
                jpaQuery = jpaQuery + " " + sortOrder;
            }
        }
        TypedQuery<Partido> q = em.createQuery(jpaQuery, Partido.class);
        q.setParameter("torneoEquipoLocal", torneoEquipoLocal);
        q.setParameter("torneoEquipoVisitante", torneoEquipoVisitante);
        q.setParameter("equipoLocal", equipoLocal);
        q.setParameter("equipoVisitante", equipoVisitante);
        return q;
    }

	public static TypedQuery<Partido> findPartidoesByTorneoEquipoLocalOrTorneoEquipoVisitanteAndEquipoLocalOrEquipoVisitanteAndStatus(Torneo torneoEquipoLocal, Torneo torneoEquipoVisitante, Equipo equipoLocal, Equipo equipoVisitante, StatusPartido status) {
        if (torneoEquipoLocal == null) throw new IllegalArgumentException("The torneoEquipoLocal argument is required");
        if (torneoEquipoVisitante == null) throw new IllegalArgumentException("The torneoEquipoVisitante argument is required");
        if (equipoLocal == null) throw new IllegalArgumentException("The equipoLocal argument is required");
        if (equipoVisitante == null) throw new IllegalArgumentException("The equipoVisitante argument is required");
        if (status == null) throw new IllegalArgumentException("The status argument is required");
        EntityManager em = Partido.entityManager();
        TypedQuery<Partido> q = em.createQuery("SELECT o FROM Partido AS o WHERE o.torneoEquipoLocal = :torneoEquipoLocal OR o.torneoEquipoVisitante = :torneoEquipoVisitante AND o.equipoLocal = :equipoLocal OR o.equipoVisitante = :equipoVisitante AND o.status = :status", Partido.class);
        q.setParameter("torneoEquipoLocal", torneoEquipoLocal);
        q.setParameter("torneoEquipoVisitante", torneoEquipoVisitante);
        q.setParameter("equipoLocal", equipoLocal);
        q.setParameter("equipoVisitante", equipoVisitante);
        q.setParameter("status", status);
        return q;
    }

	public static TypedQuery<Partido> findPartidoesByTorneoEquipoLocalOrTorneoEquipoVisitanteAndEquipoLocalOrEquipoVisitanteAndStatus(Torneo torneoEquipoLocal, Torneo torneoEquipoVisitante, Equipo equipoLocal, Equipo equipoVisitante, StatusPartido status, String sortFieldName, String sortOrder) {
        if (torneoEquipoLocal == null) throw new IllegalArgumentException("The torneoEquipoLocal argument is required");
        if (torneoEquipoVisitante == null) throw new IllegalArgumentException("The torneoEquipoVisitante argument is required");
        if (equipoLocal == null) throw new IllegalArgumentException("The equipoLocal argument is required");
        if (equipoVisitante == null) throw new IllegalArgumentException("The equipoVisitante argument is required");
        if (status == null) throw new IllegalArgumentException("The status argument is required");
        EntityManager em = Partido.entityManager();
        String jpaQuery = "SELECT o FROM Partido AS o WHERE o.torneoEquipoLocal = :torneoEquipoLocal OR o.torneoEquipoVisitante = :torneoEquipoVisitante AND o.equipoLocal = :equipoLocal OR o.equipoVisitante = :equipoVisitante AND o.status = :status";
        if (fieldNames4OrderClauseFilter.contains(sortFieldName)) {
            jpaQuery = jpaQuery + " ORDER BY " + sortFieldName;
            if ("ASC".equalsIgnoreCase(sortOrder) || "DESC".equalsIgnoreCase(sortOrder)) {
                jpaQuery = jpaQuery + " " + sortOrder;
            }
        }
        TypedQuery<Partido> q = em.createQuery(jpaQuery, Partido.class);
        q.setParameter("torneoEquipoLocal", torneoEquipoLocal);
        q.setParameter("torneoEquipoVisitante", torneoEquipoVisitante);
        q.setParameter("equipoLocal", equipoLocal);
        q.setParameter("equipoVisitante", equipoVisitante);
        q.setParameter("status", status);
        return q;
    }

	public static TypedQuery<Partido> findPartidoesByTorneoEquipoLocalOrTorneoEquipoVisitanteAndStatus(Torneo torneoEquipoLocal, Torneo torneoEquipoVisitante, StatusPartido status) {
        if (torneoEquipoLocal == null) throw new IllegalArgumentException("The torneoEquipoLocal argument is required");
        if (torneoEquipoVisitante == null) throw new IllegalArgumentException("The torneoEquipoVisitante argument is required");
        if (status == null) throw new IllegalArgumentException("The status argument is required");
        EntityManager em = Partido.entityManager();
        TypedQuery<Partido> q = em.createQuery("SELECT o FROM Partido AS o WHERE o.torneoEquipoLocal = :torneoEquipoLocal OR o.torneoEquipoVisitante = :torneoEquipoVisitante AND o.status = :status", Partido.class);
        q.setParameter("torneoEquipoLocal", torneoEquipoLocal);
        q.setParameter("torneoEquipoVisitante", torneoEquipoVisitante);
        q.setParameter("status", status);
        return q;
    }

	public static TypedQuery<Partido> findPartidoesByTorneoEquipoLocalOrTorneoEquipoVisitanteAndStatus(Torneo torneoEquipoLocal, Torneo torneoEquipoVisitante, StatusPartido status, String sortFieldName, String sortOrder) {
        if (torneoEquipoLocal == null) throw new IllegalArgumentException("The torneoEquipoLocal argument is required");
        if (torneoEquipoVisitante == null) throw new IllegalArgumentException("The torneoEquipoVisitante argument is required");
        if (status == null) throw new IllegalArgumentException("The status argument is required");
        EntityManager em = Partido.entityManager();
        String jpaQuery = "SELECT o FROM Partido AS o WHERE o.torneoEquipoLocal = :torneoEquipoLocal OR o.torneoEquipoVisitante = :torneoEquipoVisitante AND o.status = :status";
        if (fieldNames4OrderClauseFilter.contains(sortFieldName)) {
            jpaQuery = jpaQuery + " ORDER BY " + sortFieldName;
            if ("ASC".equalsIgnoreCase(sortOrder) || "DESC".equalsIgnoreCase(sortOrder)) {
                jpaQuery = jpaQuery + " " + sortOrder;
            }
        }
        TypedQuery<Partido> q = em.createQuery(jpaQuery, Partido.class);
        q.setParameter("torneoEquipoLocal", torneoEquipoLocal);
        q.setParameter("torneoEquipoVisitante", torneoEquipoVisitante);
        q.setParameter("status", status);
        return q;
    }

	public Cancha getCancha() {
        return this.cancha;
    }

	public void setCancha(Cancha cancha) {
        this.cancha = cancha;
    }

	public Set<Usuario> getArbitros() {
        return this.arbitros;
    }

	public void setArbitros(Set<Usuario> arbitros) {
        this.arbitros = arbitros;
    }

	public Torneo getTorneoEquipoLocal() {
        return this.torneoEquipoLocal;
    }

	public void setTorneoEquipoLocal(Torneo torneoEquipoLocal) {
        this.torneoEquipoLocal = torneoEquipoLocal;
    }

	public Equipo getEquipoLocal() {
        return this.equipoLocal;
    }

	public void setEquipoLocal(Equipo equipoLocal) {
        this.equipoLocal = equipoLocal;
    }

	public Torneo getTorneoEquipoVisitante() {
        return this.torneoEquipoVisitante;
    }

	public void setTorneoEquipoVisitante(Torneo torneoEquipoVisitante) {
        this.torneoEquipoVisitante = torneoEquipoVisitante;
    }

	public Equipo getEquipoVisitante() {
        return this.equipoVisitante;
    }

	public void setEquipoVisitante(Equipo equipoVisitante) {
        this.equipoVisitante = equipoVisitante;
    }

	public Date getFechaJuego() {
        return this.fechaJuego;
    }

	public void setFechaJuego(Date fechaJuego) {
        this.fechaJuego = fechaJuego;
    }

	public Horario getHorario() {
        return this.horario;
    }

	public void setHorario(Horario horario) {
        this.horario = horario;
    }

	public TipoPartido getTipoPartido() {
        return this.tipoPartido;
    }

	public void setTipoPartido(TipoPartido tipoPartido) {
        this.tipoPartido = tipoPartido;
    }

	public StatusPartido getStatus() {
        return this.status;
    }

	public void setStatus(StatusPartido status) {
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

	public static Partido fromJsonToPartido(String json) {
        return new JSONDeserializer<Partido>()
        .use(null, Partido.class).deserialize(json);
    }

	public static String toJsonArray(Collection<Partido> collection) {
        return new JSONSerializer()
        .exclude("*.class").deepSerialize(collection);
    }

	public static String toJsonArray(Collection<Partido> collection, String[] fields) {
        return new JSONSerializer()
        .include(fields).exclude("*.class").deepSerialize(collection);
    }

	public static Collection<Partido> fromJsonArrayToPartidoes(String json) {
        return new JSONDeserializer<List<Partido>>()
        .use("values", Partido.class).deserialize(json);
    }

	public String toString() {
        return ReflectionToStringBuilder.toString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
}
