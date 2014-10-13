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
@RooJpaActiveRecord(finders = { "findAlineacionsByPartido", "findAlineacionsByJugador", "findAlineacionsByPartidoAndFechaCreacionBetween", "findAlineacionsByJugadorAndFechaCreacionBetween" })
@RooJson(deepSerialize = true)
public class Alineacion {

    /**
     */
    @ManyToOne
    private Partido partido;

    /**
     */
    @ManyToOne
    private Jugador jugador;

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

	public static final List<String> fieldNames4OrderClauseFilter = java.util.Arrays.asList("partido", "jugador", "usuario", "fechaCreacion", "fechaModificacion");

	public static final EntityManager entityManager() {
        EntityManager em = new Alineacion().entityManager;
        if (em == null) throw new IllegalStateException("Entity manager has not been injected (is the Spring Aspects JAR configured as an AJC/AJDT aspects library?)");
        return em;
    }

	public static long countAlineacions() {
        return entityManager().createQuery("SELECT COUNT(o) FROM Alineacion o", Long.class).getSingleResult();
    }

	public static List<Alineacion> findAllAlineacions() {
        return entityManager().createQuery("SELECT o FROM Alineacion o", Alineacion.class).getResultList();
    }

	public static List<Alineacion> findAllAlineacions(String sortFieldName, String sortOrder) {
        String jpaQuery = "SELECT o FROM Alineacion o";
        if (fieldNames4OrderClauseFilter.contains(sortFieldName)) {
            jpaQuery = jpaQuery + " ORDER BY " + sortFieldName;
            if ("ASC".equalsIgnoreCase(sortOrder) || "DESC".equalsIgnoreCase(sortOrder)) {
                jpaQuery = jpaQuery + " " + sortOrder;
            }
        }
        return entityManager().createQuery(jpaQuery, Alineacion.class).getResultList();
    }

	public static Alineacion findAlineacion(Long id) {
        if (id == null) return null;
        return entityManager().find(Alineacion.class, id);
    }

	public static List<Alineacion> findAlineacionEntries(int firstResult, int maxResults) {
        return entityManager().createQuery("SELECT o FROM Alineacion o", Alineacion.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }

	public static List<Alineacion> findAlineacionEntries(int firstResult, int maxResults, String sortFieldName, String sortOrder) {
        String jpaQuery = "SELECT o FROM Alineacion o";
        if (fieldNames4OrderClauseFilter.contains(sortFieldName)) {
            jpaQuery = jpaQuery + " ORDER BY " + sortFieldName;
            if ("ASC".equalsIgnoreCase(sortOrder) || "DESC".equalsIgnoreCase(sortOrder)) {
                jpaQuery = jpaQuery + " " + sortOrder;
            }
        }
        return entityManager().createQuery(jpaQuery, Alineacion.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
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
            Alineacion attached = Alineacion.findAlineacion(this.id);
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
    public Alineacion merge() {
        if (this.entityManager == null) this.entityManager = entityManager();
        Alineacion merged = this.entityManager.merge(this);
        this.entityManager.flush();
        return merged;
    }

	public Partido getPartido() {
        return this.partido;
    }

	public void setPartido(Partido partido) {
        this.partido = partido;
    }

	public Jugador getJugador() {
        return this.jugador;
    }

	public void setJugador(Jugador jugador) {
        this.jugador = jugador;
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

	public static Long countFindAlineacionsByJugador(Jugador jugador) {
        if (jugador == null) throw new IllegalArgumentException("The jugador argument is required");
        EntityManager em = Alineacion.entityManager();
        TypedQuery q = em.createQuery("SELECT COUNT(o) FROM Alineacion AS o WHERE o.jugador = :jugador", Long.class);
        q.setParameter("jugador", jugador);
        return ((Long) q.getSingleResult());
    }

	public static Long countFindAlineacionsByJugadorAndFechaCreacionBetween(Jugador jugador, Date minFechaCreacion, Date maxFechaCreacion) {
        if (jugador == null) throw new IllegalArgumentException("The jugador argument is required");
        if (minFechaCreacion == null) throw new IllegalArgumentException("The minFechaCreacion argument is required");
        if (maxFechaCreacion == null) throw new IllegalArgumentException("The maxFechaCreacion argument is required");
        EntityManager em = Alineacion.entityManager();
        TypedQuery q = em.createQuery("SELECT COUNT(o) FROM Alineacion AS o WHERE o.jugador = :jugador AND o.fechaCreacion BETWEEN :minFechaCreacion AND :maxFechaCreacion", Long.class);
        q.setParameter("jugador", jugador);
        q.setParameter("minFechaCreacion", minFechaCreacion);
        q.setParameter("maxFechaCreacion", maxFechaCreacion);
        return ((Long) q.getSingleResult());
    }

	public static Long countFindAlineacionsByPartido(Partido partido) {
        if (partido == null) throw new IllegalArgumentException("The partido argument is required");
        EntityManager em = Alineacion.entityManager();
        TypedQuery q = em.createQuery("SELECT COUNT(o) FROM Alineacion AS o WHERE o.partido = :partido", Long.class);
        q.setParameter("partido", partido);
        return ((Long) q.getSingleResult());
    }

	public static Long countFindAlineacionsByPartidoAndFechaCreacionBetween(Partido partido, Date minFechaCreacion, Date maxFechaCreacion) {
        if (partido == null) throw new IllegalArgumentException("The partido argument is required");
        if (minFechaCreacion == null) throw new IllegalArgumentException("The minFechaCreacion argument is required");
        if (maxFechaCreacion == null) throw new IllegalArgumentException("The maxFechaCreacion argument is required");
        EntityManager em = Alineacion.entityManager();
        TypedQuery q = em.createQuery("SELECT COUNT(o) FROM Alineacion AS o WHERE o.partido = :partido AND o.fechaCreacion BETWEEN :minFechaCreacion AND :maxFechaCreacion", Long.class);
        q.setParameter("partido", partido);
        q.setParameter("minFechaCreacion", minFechaCreacion);
        q.setParameter("maxFechaCreacion", maxFechaCreacion);
        return ((Long) q.getSingleResult());
    }

	public static TypedQuery<Alineacion> findAlineacionsByJugador(Jugador jugador) {
        if (jugador == null) throw new IllegalArgumentException("The jugador argument is required");
        EntityManager em = Alineacion.entityManager();
        TypedQuery<Alineacion> q = em.createQuery("SELECT o FROM Alineacion AS o WHERE o.jugador = :jugador", Alineacion.class);
        q.setParameter("jugador", jugador);
        return q;
    }

	public static TypedQuery<Alineacion> findAlineacionsByJugador(Jugador jugador, String sortFieldName, String sortOrder) {
        if (jugador == null) throw new IllegalArgumentException("The jugador argument is required");
        EntityManager em = Alineacion.entityManager();
        String jpaQuery = "SELECT o FROM Alineacion AS o WHERE o.jugador = :jugador";
        if (fieldNames4OrderClauseFilter.contains(sortFieldName)) {
            jpaQuery = jpaQuery + " ORDER BY " + sortFieldName;
            if ("ASC".equalsIgnoreCase(sortOrder) || "DESC".equalsIgnoreCase(sortOrder)) {
                jpaQuery = jpaQuery + " " + sortOrder;
            }
        }
        TypedQuery<Alineacion> q = em.createQuery(jpaQuery, Alineacion.class);
        q.setParameter("jugador", jugador);
        return q;
    }

	public static TypedQuery<Alineacion> findAlineacionsByJugadorAndFechaCreacionBetween(Jugador jugador, Date minFechaCreacion, Date maxFechaCreacion) {
        if (jugador == null) throw new IllegalArgumentException("The jugador argument is required");
        if (minFechaCreacion == null) throw new IllegalArgumentException("The minFechaCreacion argument is required");
        if (maxFechaCreacion == null) throw new IllegalArgumentException("The maxFechaCreacion argument is required");
        EntityManager em = Alineacion.entityManager();
        TypedQuery<Alineacion> q = em.createQuery("SELECT o FROM Alineacion AS o WHERE o.jugador = :jugador AND o.fechaCreacion BETWEEN :minFechaCreacion AND :maxFechaCreacion", Alineacion.class);
        q.setParameter("jugador", jugador);
        q.setParameter("minFechaCreacion", minFechaCreacion);
        q.setParameter("maxFechaCreacion", maxFechaCreacion);
        return q;
    }

	public static TypedQuery<Alineacion> findAlineacionsByJugadorAndFechaCreacionBetween(Jugador jugador, Date minFechaCreacion, Date maxFechaCreacion, String sortFieldName, String sortOrder) {
        if (jugador == null) throw new IllegalArgumentException("The jugador argument is required");
        if (minFechaCreacion == null) throw new IllegalArgumentException("The minFechaCreacion argument is required");
        if (maxFechaCreacion == null) throw new IllegalArgumentException("The maxFechaCreacion argument is required");
        EntityManager em = Alineacion.entityManager();
        String jpaQuery = "SELECT o FROM Alineacion AS o WHERE o.jugador = :jugador AND o.fechaCreacion BETWEEN :minFechaCreacion AND :maxFechaCreacion";
        if (fieldNames4OrderClauseFilter.contains(sortFieldName)) {
            jpaQuery = jpaQuery + " ORDER BY " + sortFieldName;
            if ("ASC".equalsIgnoreCase(sortOrder) || "DESC".equalsIgnoreCase(sortOrder)) {
                jpaQuery = jpaQuery + " " + sortOrder;
            }
        }
        TypedQuery<Alineacion> q = em.createQuery(jpaQuery, Alineacion.class);
        q.setParameter("jugador", jugador);
        q.setParameter("minFechaCreacion", minFechaCreacion);
        q.setParameter("maxFechaCreacion", maxFechaCreacion);
        return q;
    }

	public static TypedQuery<Alineacion> findAlineacionsByPartido(Partido partido) {
        if (partido == null) throw new IllegalArgumentException("The partido argument is required");
        EntityManager em = Alineacion.entityManager();
        TypedQuery<Alineacion> q = em.createQuery("SELECT o FROM Alineacion AS o WHERE o.partido = :partido", Alineacion.class);
        q.setParameter("partido", partido);
        return q;
    }

	public static TypedQuery<Alineacion> findAlineacionsByPartido(Partido partido, String sortFieldName, String sortOrder) {
        if (partido == null) throw new IllegalArgumentException("The partido argument is required");
        EntityManager em = Alineacion.entityManager();
        String jpaQuery = "SELECT o FROM Alineacion AS o WHERE o.partido = :partido";
        if (fieldNames4OrderClauseFilter.contains(sortFieldName)) {
            jpaQuery = jpaQuery + " ORDER BY " + sortFieldName;
            if ("ASC".equalsIgnoreCase(sortOrder) || "DESC".equalsIgnoreCase(sortOrder)) {
                jpaQuery = jpaQuery + " " + sortOrder;
            }
        }
        TypedQuery<Alineacion> q = em.createQuery(jpaQuery, Alineacion.class);
        q.setParameter("partido", partido);
        return q;
    }

	public static TypedQuery<Alineacion> findAlineacionsByPartidoAndFechaCreacionBetween(Partido partido, Date minFechaCreacion, Date maxFechaCreacion) {
        if (partido == null) throw new IllegalArgumentException("The partido argument is required");
        if (minFechaCreacion == null) throw new IllegalArgumentException("The minFechaCreacion argument is required");
        if (maxFechaCreacion == null) throw new IllegalArgumentException("The maxFechaCreacion argument is required");
        EntityManager em = Alineacion.entityManager();
        TypedQuery<Alineacion> q = em.createQuery("SELECT o FROM Alineacion AS o WHERE o.partido = :partido AND o.fechaCreacion BETWEEN :minFechaCreacion AND :maxFechaCreacion", Alineacion.class);
        q.setParameter("partido", partido);
        q.setParameter("minFechaCreacion", minFechaCreacion);
        q.setParameter("maxFechaCreacion", maxFechaCreacion);
        return q;
    }

	public static TypedQuery<Alineacion> findAlineacionsByPartidoAndFechaCreacionBetween(Partido partido, Date minFechaCreacion, Date maxFechaCreacion, String sortFieldName, String sortOrder) {
        if (partido == null) throw new IllegalArgumentException("The partido argument is required");
        if (minFechaCreacion == null) throw new IllegalArgumentException("The minFechaCreacion argument is required");
        if (maxFechaCreacion == null) throw new IllegalArgumentException("The maxFechaCreacion argument is required");
        EntityManager em = Alineacion.entityManager();
        String jpaQuery = "SELECT o FROM Alineacion AS o WHERE o.partido = :partido AND o.fechaCreacion BETWEEN :minFechaCreacion AND :maxFechaCreacion";
        if (fieldNames4OrderClauseFilter.contains(sortFieldName)) {
            jpaQuery = jpaQuery + " ORDER BY " + sortFieldName;
            if ("ASC".equalsIgnoreCase(sortOrder) || "DESC".equalsIgnoreCase(sortOrder)) {
                jpaQuery = jpaQuery + " " + sortOrder;
            }
        }
        TypedQuery<Alineacion> q = em.createQuery(jpaQuery, Alineacion.class);
        q.setParameter("partido", partido);
        q.setParameter("minFechaCreacion", minFechaCreacion);
        q.setParameter("maxFechaCreacion", maxFechaCreacion);
        return q;
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

	public static Alineacion fromJsonToAlineacion(String json) {
        return new JSONDeserializer<Alineacion>()
        .use(null, Alineacion.class).deserialize(json);
    }

	public static String toJsonArray(Collection<Alineacion> collection) {
        return new JSONSerializer()
        .exclude("*.class").deepSerialize(collection);
    }

	public static String toJsonArray(Collection<Alineacion> collection, String[] fields) {
        return new JSONSerializer()
        .include(fields).exclude("*.class").deepSerialize(collection);
    }

	public static Collection<Alineacion> fromJsonArrayToAlineacions(String json) {
        return new JSONDeserializer<List<Alineacion>>()
        .use("values", Alineacion.class).deserialize(json);
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
