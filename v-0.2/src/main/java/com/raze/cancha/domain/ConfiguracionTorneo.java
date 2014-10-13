package com.raze.cancha.domain;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.DecimalMax;
import com.raze.cancha.catalog.TipoCobro;
import com.raze.cancha.catalog.DiasJuego;
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
@RooJpaActiveRecord(finders = { "findConfiguracionTorneosByTorneoAndActivo", "findConfiguracionTorneosByTipoCobroAndActivo", "findConfiguracionTorneosByInscripcionAndActivo" })
@RooJson(deepSerialize = true)
public class ConfiguracionTorneo {

    /**
     */
    @NotNull
    @ManyToOne
    private Torneo torneo;

    /**
     */
    private Boolean inscripcion;

    /**
     */
    @DecimalMax("2")
    private double costoIncripcion;

    /**
     */
    @ManyToOne
    private TipoCobro tipoCobro;

    /**
     */
    @DecimalMax("2")
    private double costo;

    /**
     */
    private int numeroPagos;

    /**
     */
    private int numeroJugadoresXEquipo;

    /**
     */
    @ManyToOne
    private DiasJuego diasJuego;

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

	public static final List<String> fieldNames4OrderClauseFilter = java.util.Arrays.asList("torneo", "inscripcion", "costoIncripcion", "tipoCobro", "costo", "numeroPagos", "numeroJugadoresXEquipo", "diasJuego", "activo", "usuario", "fechaCreacion", "fechaModificacion");

	public static final EntityManager entityManager() {
        EntityManager em = new ConfiguracionTorneo().entityManager;
        if (em == null) throw new IllegalStateException("Entity manager has not been injected (is the Spring Aspects JAR configured as an AJC/AJDT aspects library?)");
        return em;
    }

	public static long countConfiguracionTorneos() {
        return entityManager().createQuery("SELECT COUNT(o) FROM ConfiguracionTorneo o", Long.class).getSingleResult();
    }

	public static List<ConfiguracionTorneo> findAllConfiguracionTorneos() {
        return entityManager().createQuery("SELECT o FROM ConfiguracionTorneo o", ConfiguracionTorneo.class).getResultList();
    }

	public static List<ConfiguracionTorneo> findAllConfiguracionTorneos(String sortFieldName, String sortOrder) {
        String jpaQuery = "SELECT o FROM ConfiguracionTorneo o";
        if (fieldNames4OrderClauseFilter.contains(sortFieldName)) {
            jpaQuery = jpaQuery + " ORDER BY " + sortFieldName;
            if ("ASC".equalsIgnoreCase(sortOrder) || "DESC".equalsIgnoreCase(sortOrder)) {
                jpaQuery = jpaQuery + " " + sortOrder;
            }
        }
        return entityManager().createQuery(jpaQuery, ConfiguracionTorneo.class).getResultList();
    }

	public static ConfiguracionTorneo findConfiguracionTorneo(Long id) {
        if (id == null) return null;
        return entityManager().find(ConfiguracionTorneo.class, id);
    }

	public static List<ConfiguracionTorneo> findConfiguracionTorneoEntries(int firstResult, int maxResults) {
        return entityManager().createQuery("SELECT o FROM ConfiguracionTorneo o", ConfiguracionTorneo.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }

	public static List<ConfiguracionTorneo> findConfiguracionTorneoEntries(int firstResult, int maxResults, String sortFieldName, String sortOrder) {
        String jpaQuery = "SELECT o FROM ConfiguracionTorneo o";
        if (fieldNames4OrderClauseFilter.contains(sortFieldName)) {
            jpaQuery = jpaQuery + " ORDER BY " + sortFieldName;
            if ("ASC".equalsIgnoreCase(sortOrder) || "DESC".equalsIgnoreCase(sortOrder)) {
                jpaQuery = jpaQuery + " " + sortOrder;
            }
        }
        return entityManager().createQuery(jpaQuery, ConfiguracionTorneo.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
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
            ConfiguracionTorneo attached = ConfiguracionTorneo.findConfiguracionTorneo(this.id);
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
    public ConfiguracionTorneo merge() {
        if (this.entityManager == null) this.entityManager = entityManager();
        ConfiguracionTorneo merged = this.entityManager.merge(this);
        this.entityManager.flush();
        return merged;
    }

	public Torneo getTorneo() {
        return this.torneo;
    }

	public void setTorneo(Torneo torneo) {
        this.torneo = torneo;
    }

	public Boolean getInscripcion() {
        return this.inscripcion;
    }

	public void setInscripcion(Boolean inscripcion) {
        this.inscripcion = inscripcion;
    }

	public double getCostoIncripcion() {
        return this.costoIncripcion;
    }

	public void setCostoIncripcion(double costoIncripcion) {
        this.costoIncripcion = costoIncripcion;
    }

	public TipoCobro getTipoCobro() {
        return this.tipoCobro;
    }

	public void setTipoCobro(TipoCobro tipoCobro) {
        this.tipoCobro = tipoCobro;
    }

	public double getCosto() {
        return this.costo;
    }

	public void setCosto(double costo) {
        this.costo = costo;
    }

	public int getNumeroPagos() {
        return this.numeroPagos;
    }

	public void setNumeroPagos(int numeroPagos) {
        this.numeroPagos = numeroPagos;
    }

	public int getNumeroJugadoresXEquipo() {
        return this.numeroJugadoresXEquipo;
    }

	public void setNumeroJugadoresXEquipo(int numeroJugadoresXEquipo) {
        this.numeroJugadoresXEquipo = numeroJugadoresXEquipo;
    }

	public DiasJuego getDiasJuego() {
        return this.diasJuego;
    }

	public void setDiasJuego(DiasJuego diasJuego) {
        this.diasJuego = diasJuego;
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

	public static Long countFindConfiguracionTorneosByInscripcionAndActivo(Boolean inscripcion, Boolean activo) {
        if (inscripcion == null) throw new IllegalArgumentException("The inscripcion argument is required");
        if (activo == null) throw new IllegalArgumentException("The activo argument is required");
        EntityManager em = ConfiguracionTorneo.entityManager();
        TypedQuery q = em.createQuery("SELECT COUNT(o) FROM ConfiguracionTorneo AS o WHERE o.inscripcion = :inscripcion AND o.activo = :activo", Long.class);
        q.setParameter("inscripcion", inscripcion);
        q.setParameter("activo", activo);
        return ((Long) q.getSingleResult());
    }

	public static Long countFindConfiguracionTorneosByTipoCobroAndActivo(TipoCobro tipoCobro, Boolean activo) {
        if (tipoCobro == null) throw new IllegalArgumentException("The tipoCobro argument is required");
        if (activo == null) throw new IllegalArgumentException("The activo argument is required");
        EntityManager em = ConfiguracionTorneo.entityManager();
        TypedQuery q = em.createQuery("SELECT COUNT(o) FROM ConfiguracionTorneo AS o WHERE o.tipoCobro = :tipoCobro AND o.activo = :activo", Long.class);
        q.setParameter("tipoCobro", tipoCobro);
        q.setParameter("activo", activo);
        return ((Long) q.getSingleResult());
    }

	public static Long countFindConfiguracionTorneosByTorneoAndActivo(Torneo torneo, Boolean activo) {
        if (torneo == null) throw new IllegalArgumentException("The torneo argument is required");
        if (activo == null) throw new IllegalArgumentException("The activo argument is required");
        EntityManager em = ConfiguracionTorneo.entityManager();
        TypedQuery q = em.createQuery("SELECT COUNT(o) FROM ConfiguracionTorneo AS o WHERE o.torneo = :torneo AND o.activo = :activo", Long.class);
        q.setParameter("torneo", torneo);
        q.setParameter("activo", activo);
        return ((Long) q.getSingleResult());
    }

	public static TypedQuery<ConfiguracionTorneo> findConfiguracionTorneosByInscripcionAndActivo(Boolean inscripcion, Boolean activo) {
        if (inscripcion == null) throw new IllegalArgumentException("The inscripcion argument is required");
        if (activo == null) throw new IllegalArgumentException("The activo argument is required");
        EntityManager em = ConfiguracionTorneo.entityManager();
        TypedQuery<ConfiguracionTorneo> q = em.createQuery("SELECT o FROM ConfiguracionTorneo AS o WHERE o.inscripcion = :inscripcion AND o.activo = :activo", ConfiguracionTorneo.class);
        q.setParameter("inscripcion", inscripcion);
        q.setParameter("activo", activo);
        return q;
    }

	public static TypedQuery<ConfiguracionTorneo> findConfiguracionTorneosByInscripcionAndActivo(Boolean inscripcion, Boolean activo, String sortFieldName, String sortOrder) {
        if (inscripcion == null) throw new IllegalArgumentException("The inscripcion argument is required");
        if (activo == null) throw new IllegalArgumentException("The activo argument is required");
        EntityManager em = ConfiguracionTorneo.entityManager();
        String jpaQuery = "SELECT o FROM ConfiguracionTorneo AS o WHERE o.inscripcion = :inscripcion AND o.activo = :activo";
        if (fieldNames4OrderClauseFilter.contains(sortFieldName)) {
            jpaQuery = jpaQuery + " ORDER BY " + sortFieldName;
            if ("ASC".equalsIgnoreCase(sortOrder) || "DESC".equalsIgnoreCase(sortOrder)) {
                jpaQuery = jpaQuery + " " + sortOrder;
            }
        }
        TypedQuery<ConfiguracionTorneo> q = em.createQuery(jpaQuery, ConfiguracionTorneo.class);
        q.setParameter("inscripcion", inscripcion);
        q.setParameter("activo", activo);
        return q;
    }

	public static TypedQuery<ConfiguracionTorneo> findConfiguracionTorneosByTipoCobroAndActivo(TipoCobro tipoCobro, Boolean activo) {
        if (tipoCobro == null) throw new IllegalArgumentException("The tipoCobro argument is required");
        if (activo == null) throw new IllegalArgumentException("The activo argument is required");
        EntityManager em = ConfiguracionTorneo.entityManager();
        TypedQuery<ConfiguracionTorneo> q = em.createQuery("SELECT o FROM ConfiguracionTorneo AS o WHERE o.tipoCobro = :tipoCobro AND o.activo = :activo", ConfiguracionTorneo.class);
        q.setParameter("tipoCobro", tipoCobro);
        q.setParameter("activo", activo);
        return q;
    }

	public static TypedQuery<ConfiguracionTorneo> findConfiguracionTorneosByTipoCobroAndActivo(TipoCobro tipoCobro, Boolean activo, String sortFieldName, String sortOrder) {
        if (tipoCobro == null) throw new IllegalArgumentException("The tipoCobro argument is required");
        if (activo == null) throw new IllegalArgumentException("The activo argument is required");
        EntityManager em = ConfiguracionTorneo.entityManager();
        String jpaQuery = "SELECT o FROM ConfiguracionTorneo AS o WHERE o.tipoCobro = :tipoCobro AND o.activo = :activo";
        if (fieldNames4OrderClauseFilter.contains(sortFieldName)) {
            jpaQuery = jpaQuery + " ORDER BY " + sortFieldName;
            if ("ASC".equalsIgnoreCase(sortOrder) || "DESC".equalsIgnoreCase(sortOrder)) {
                jpaQuery = jpaQuery + " " + sortOrder;
            }
        }
        TypedQuery<ConfiguracionTorneo> q = em.createQuery(jpaQuery, ConfiguracionTorneo.class);
        q.setParameter("tipoCobro", tipoCobro);
        q.setParameter("activo", activo);
        return q;
    }

	public static TypedQuery<ConfiguracionTorneo> findConfiguracionTorneosByTorneoAndActivo(Torneo torneo, Boolean activo) {
        if (torneo == null) throw new IllegalArgumentException("The torneo argument is required");
        if (activo == null) throw new IllegalArgumentException("The activo argument is required");
        EntityManager em = ConfiguracionTorneo.entityManager();
        TypedQuery<ConfiguracionTorneo> q = em.createQuery("SELECT o FROM ConfiguracionTorneo AS o WHERE o.torneo = :torneo AND o.activo = :activo", ConfiguracionTorneo.class);
        q.setParameter("torneo", torneo);
        q.setParameter("activo", activo);
        return q;
    }

	public static TypedQuery<ConfiguracionTorneo> findConfiguracionTorneosByTorneoAndActivo(Torneo torneo, Boolean activo, String sortFieldName, String sortOrder) {
        if (torneo == null) throw new IllegalArgumentException("The torneo argument is required");
        if (activo == null) throw new IllegalArgumentException("The activo argument is required");
        EntityManager em = ConfiguracionTorneo.entityManager();
        String jpaQuery = "SELECT o FROM ConfiguracionTorneo AS o WHERE o.torneo = :torneo AND o.activo = :activo";
        if (fieldNames4OrderClauseFilter.contains(sortFieldName)) {
            jpaQuery = jpaQuery + " ORDER BY " + sortFieldName;
            if ("ASC".equalsIgnoreCase(sortOrder) || "DESC".equalsIgnoreCase(sortOrder)) {
                jpaQuery = jpaQuery + " " + sortOrder;
            }
        }
        TypedQuery<ConfiguracionTorneo> q = em.createQuery(jpaQuery, ConfiguracionTorneo.class);
        q.setParameter("torneo", torneo);
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

	public static ConfiguracionTorneo fromJsonToConfiguracionTorneo(String json) {
        return new JSONDeserializer<ConfiguracionTorneo>()
        .use(null, ConfiguracionTorneo.class).deserialize(json);
    }

	public static String toJsonArray(Collection<ConfiguracionTorneo> collection) {
        return new JSONSerializer()
        .exclude("*.class").deepSerialize(collection);
    }

	public static String toJsonArray(Collection<ConfiguracionTorneo> collection, String[] fields) {
        return new JSONSerializer()
        .include(fields).exclude("*.class").deepSerialize(collection);
    }

	public static Collection<ConfiguracionTorneo> fromJsonArrayToConfiguracionTorneos(String json) {
        return new JSONDeserializer<List<ConfiguracionTorneo>>()
        .use("values", ConfiguracionTorneo.class).deserialize(json);
    }

	public String toString() {
        return ReflectionToStringBuilder.toString(this, ToStringStyle.SHORT_PREFIX_STYLE);
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
