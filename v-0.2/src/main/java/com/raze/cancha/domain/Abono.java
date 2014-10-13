package com.raze.cancha.domain;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import com.raze.cancha.catalog.MetodoPago;
import com.raze.cancha.catalog.Descuento;
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
@RooJpaActiveRecord(finders = { "findAbonoesByDescuentoAndFechaCreacionBetween", "findAbonoesByStatusAndFechaCreacionBetween", "findAbonoesByMetodoPagoAndFechaCreacionBetween", "findAbonoesByCargoAndFechaCreacionBetween" })
@RooJson(deepSerialize = true)
public class Abono {

    /**
     */
    @NotNull
    @ManyToOne
    private Cargo cargo;

    /**
     */
    @NotNull
    @ManyToOne
    private MetodoPago metodoPago;

    /**
     */
    @ManyToOne
    private Descuento descuento;

    /**
     */
    private String observaciones;

    /**
     */
    @NotNull
    @ManyToOne
    private StatusCargoAbono status;

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

	public static Long countFindAbonoesByCargoAndFechaCreacionBetween(Cargo cargo, Date minFechaCreacion, Date maxFechaCreacion) {
        if (cargo == null) throw new IllegalArgumentException("The cargo argument is required");
        if (minFechaCreacion == null) throw new IllegalArgumentException("The minFechaCreacion argument is required");
        if (maxFechaCreacion == null) throw new IllegalArgumentException("The maxFechaCreacion argument is required");
        EntityManager em = Abono.entityManager();
        TypedQuery q = em.createQuery("SELECT COUNT(o) FROM Abono AS o WHERE o.cargo = :cargo AND o.fechaCreacion BETWEEN :minFechaCreacion AND :maxFechaCreacion", Long.class);
        q.setParameter("cargo", cargo);
        q.setParameter("minFechaCreacion", minFechaCreacion);
        q.setParameter("maxFechaCreacion", maxFechaCreacion);
        return ((Long) q.getSingleResult());
    }

	public static Long countFindAbonoesByDescuentoAndFechaCreacionBetween(Descuento descuento, Date minFechaCreacion, Date maxFechaCreacion) {
        if (descuento == null) throw new IllegalArgumentException("The descuento argument is required");
        if (minFechaCreacion == null) throw new IllegalArgumentException("The minFechaCreacion argument is required");
        if (maxFechaCreacion == null) throw new IllegalArgumentException("The maxFechaCreacion argument is required");
        EntityManager em = Abono.entityManager();
        TypedQuery q = em.createQuery("SELECT COUNT(o) FROM Abono AS o WHERE o.descuento = :descuento AND o.fechaCreacion BETWEEN :minFechaCreacion AND :maxFechaCreacion", Long.class);
        q.setParameter("descuento", descuento);
        q.setParameter("minFechaCreacion", minFechaCreacion);
        q.setParameter("maxFechaCreacion", maxFechaCreacion);
        return ((Long) q.getSingleResult());
    }

	public static Long countFindAbonoesByMetodoPagoAndFechaCreacionBetween(MetodoPago metodoPago, Date minFechaCreacion, Date maxFechaCreacion) {
        if (metodoPago == null) throw new IllegalArgumentException("The metodoPago argument is required");
        if (minFechaCreacion == null) throw new IllegalArgumentException("The minFechaCreacion argument is required");
        if (maxFechaCreacion == null) throw new IllegalArgumentException("The maxFechaCreacion argument is required");
        EntityManager em = Abono.entityManager();
        TypedQuery q = em.createQuery("SELECT COUNT(o) FROM Abono AS o WHERE o.metodoPago = :metodoPago AND o.fechaCreacion BETWEEN :minFechaCreacion AND :maxFechaCreacion", Long.class);
        q.setParameter("metodoPago", metodoPago);
        q.setParameter("minFechaCreacion", minFechaCreacion);
        q.setParameter("maxFechaCreacion", maxFechaCreacion);
        return ((Long) q.getSingleResult());
    }

	public static Long countFindAbonoesByStatusAndFechaCreacionBetween(StatusCargoAbono status, Date minFechaCreacion, Date maxFechaCreacion) {
        if (status == null) throw new IllegalArgumentException("The status argument is required");
        if (minFechaCreacion == null) throw new IllegalArgumentException("The minFechaCreacion argument is required");
        if (maxFechaCreacion == null) throw new IllegalArgumentException("The maxFechaCreacion argument is required");
        EntityManager em = Abono.entityManager();
        TypedQuery q = em.createQuery("SELECT COUNT(o) FROM Abono AS o WHERE o.status = :status AND o.fechaCreacion BETWEEN :minFechaCreacion AND :maxFechaCreacion", Long.class);
        q.setParameter("status", status);
        q.setParameter("minFechaCreacion", minFechaCreacion);
        q.setParameter("maxFechaCreacion", maxFechaCreacion);
        return ((Long) q.getSingleResult());
    }

	public static TypedQuery<Abono> findAbonoesByCargoAndFechaCreacionBetween(Cargo cargo, Date minFechaCreacion, Date maxFechaCreacion) {
        if (cargo == null) throw new IllegalArgumentException("The cargo argument is required");
        if (minFechaCreacion == null) throw new IllegalArgumentException("The minFechaCreacion argument is required");
        if (maxFechaCreacion == null) throw new IllegalArgumentException("The maxFechaCreacion argument is required");
        EntityManager em = Abono.entityManager();
        TypedQuery<Abono> q = em.createQuery("SELECT o FROM Abono AS o WHERE o.cargo = :cargo AND o.fechaCreacion BETWEEN :minFechaCreacion AND :maxFechaCreacion", Abono.class);
        q.setParameter("cargo", cargo);
        q.setParameter("minFechaCreacion", minFechaCreacion);
        q.setParameter("maxFechaCreacion", maxFechaCreacion);
        return q;
    }

	public static TypedQuery<Abono> findAbonoesByCargoAndFechaCreacionBetween(Cargo cargo, Date minFechaCreacion, Date maxFechaCreacion, String sortFieldName, String sortOrder) {
        if (cargo == null) throw new IllegalArgumentException("The cargo argument is required");
        if (minFechaCreacion == null) throw new IllegalArgumentException("The minFechaCreacion argument is required");
        if (maxFechaCreacion == null) throw new IllegalArgumentException("The maxFechaCreacion argument is required");
        EntityManager em = Abono.entityManager();
        String jpaQuery = "SELECT o FROM Abono AS o WHERE o.cargo = :cargo AND o.fechaCreacion BETWEEN :minFechaCreacion AND :maxFechaCreacion";
        if (fieldNames4OrderClauseFilter.contains(sortFieldName)) {
            jpaQuery = jpaQuery + " ORDER BY " + sortFieldName;
            if ("ASC".equalsIgnoreCase(sortOrder) || "DESC".equalsIgnoreCase(sortOrder)) {
                jpaQuery = jpaQuery + " " + sortOrder;
            }
        }
        TypedQuery<Abono> q = em.createQuery(jpaQuery, Abono.class);
        q.setParameter("cargo", cargo);
        q.setParameter("minFechaCreacion", minFechaCreacion);
        q.setParameter("maxFechaCreacion", maxFechaCreacion);
        return q;
    }

	public static TypedQuery<Abono> findAbonoesByDescuentoAndFechaCreacionBetween(Descuento descuento, Date minFechaCreacion, Date maxFechaCreacion) {
        if (descuento == null) throw new IllegalArgumentException("The descuento argument is required");
        if (minFechaCreacion == null) throw new IllegalArgumentException("The minFechaCreacion argument is required");
        if (maxFechaCreacion == null) throw new IllegalArgumentException("The maxFechaCreacion argument is required");
        EntityManager em = Abono.entityManager();
        TypedQuery<Abono> q = em.createQuery("SELECT o FROM Abono AS o WHERE o.descuento = :descuento AND o.fechaCreacion BETWEEN :minFechaCreacion AND :maxFechaCreacion", Abono.class);
        q.setParameter("descuento", descuento);
        q.setParameter("minFechaCreacion", minFechaCreacion);
        q.setParameter("maxFechaCreacion", maxFechaCreacion);
        return q;
    }

	public static TypedQuery<Abono> findAbonoesByDescuentoAndFechaCreacionBetween(Descuento descuento, Date minFechaCreacion, Date maxFechaCreacion, String sortFieldName, String sortOrder) {
        if (descuento == null) throw new IllegalArgumentException("The descuento argument is required");
        if (minFechaCreacion == null) throw new IllegalArgumentException("The minFechaCreacion argument is required");
        if (maxFechaCreacion == null) throw new IllegalArgumentException("The maxFechaCreacion argument is required");
        EntityManager em = Abono.entityManager();
        String jpaQuery = "SELECT o FROM Abono AS o WHERE o.descuento = :descuento AND o.fechaCreacion BETWEEN :minFechaCreacion AND :maxFechaCreacion";
        if (fieldNames4OrderClauseFilter.contains(sortFieldName)) {
            jpaQuery = jpaQuery + " ORDER BY " + sortFieldName;
            if ("ASC".equalsIgnoreCase(sortOrder) || "DESC".equalsIgnoreCase(sortOrder)) {
                jpaQuery = jpaQuery + " " + sortOrder;
            }
        }
        TypedQuery<Abono> q = em.createQuery(jpaQuery, Abono.class);
        q.setParameter("descuento", descuento);
        q.setParameter("minFechaCreacion", minFechaCreacion);
        q.setParameter("maxFechaCreacion", maxFechaCreacion);
        return q;
    }

	public static TypedQuery<Abono> findAbonoesByMetodoPagoAndFechaCreacionBetween(MetodoPago metodoPago, Date minFechaCreacion, Date maxFechaCreacion) {
        if (metodoPago == null) throw new IllegalArgumentException("The metodoPago argument is required");
        if (minFechaCreacion == null) throw new IllegalArgumentException("The minFechaCreacion argument is required");
        if (maxFechaCreacion == null) throw new IllegalArgumentException("The maxFechaCreacion argument is required");
        EntityManager em = Abono.entityManager();
        TypedQuery<Abono> q = em.createQuery("SELECT o FROM Abono AS o WHERE o.metodoPago = :metodoPago AND o.fechaCreacion BETWEEN :minFechaCreacion AND :maxFechaCreacion", Abono.class);
        q.setParameter("metodoPago", metodoPago);
        q.setParameter("minFechaCreacion", minFechaCreacion);
        q.setParameter("maxFechaCreacion", maxFechaCreacion);
        return q;
    }

	public static TypedQuery<Abono> findAbonoesByMetodoPagoAndFechaCreacionBetween(MetodoPago metodoPago, Date minFechaCreacion, Date maxFechaCreacion, String sortFieldName, String sortOrder) {
        if (metodoPago == null) throw new IllegalArgumentException("The metodoPago argument is required");
        if (minFechaCreacion == null) throw new IllegalArgumentException("The minFechaCreacion argument is required");
        if (maxFechaCreacion == null) throw new IllegalArgumentException("The maxFechaCreacion argument is required");
        EntityManager em = Abono.entityManager();
        String jpaQuery = "SELECT o FROM Abono AS o WHERE o.metodoPago = :metodoPago AND o.fechaCreacion BETWEEN :minFechaCreacion AND :maxFechaCreacion";
        if (fieldNames4OrderClauseFilter.contains(sortFieldName)) {
            jpaQuery = jpaQuery + " ORDER BY " + sortFieldName;
            if ("ASC".equalsIgnoreCase(sortOrder) || "DESC".equalsIgnoreCase(sortOrder)) {
                jpaQuery = jpaQuery + " " + sortOrder;
            }
        }
        TypedQuery<Abono> q = em.createQuery(jpaQuery, Abono.class);
        q.setParameter("metodoPago", metodoPago);
        q.setParameter("minFechaCreacion", minFechaCreacion);
        q.setParameter("maxFechaCreacion", maxFechaCreacion);
        return q;
    }

	public static TypedQuery<Abono> findAbonoesByStatusAndFechaCreacionBetween(StatusCargoAbono status, Date minFechaCreacion, Date maxFechaCreacion) {
        if (status == null) throw new IllegalArgumentException("The status argument is required");
        if (minFechaCreacion == null) throw new IllegalArgumentException("The minFechaCreacion argument is required");
        if (maxFechaCreacion == null) throw new IllegalArgumentException("The maxFechaCreacion argument is required");
        EntityManager em = Abono.entityManager();
        TypedQuery<Abono> q = em.createQuery("SELECT o FROM Abono AS o WHERE o.status = :status AND o.fechaCreacion BETWEEN :minFechaCreacion AND :maxFechaCreacion", Abono.class);
        q.setParameter("status", status);
        q.setParameter("minFechaCreacion", minFechaCreacion);
        q.setParameter("maxFechaCreacion", maxFechaCreacion);
        return q;
    }

	public static TypedQuery<Abono> findAbonoesByStatusAndFechaCreacionBetween(StatusCargoAbono status, Date minFechaCreacion, Date maxFechaCreacion, String sortFieldName, String sortOrder) {
        if (status == null) throw new IllegalArgumentException("The status argument is required");
        if (minFechaCreacion == null) throw new IllegalArgumentException("The minFechaCreacion argument is required");
        if (maxFechaCreacion == null) throw new IllegalArgumentException("The maxFechaCreacion argument is required");
        EntityManager em = Abono.entityManager();
        String jpaQuery = "SELECT o FROM Abono AS o WHERE o.status = :status AND o.fechaCreacion BETWEEN :minFechaCreacion AND :maxFechaCreacion";
        if (fieldNames4OrderClauseFilter.contains(sortFieldName)) {
            jpaQuery = jpaQuery + " ORDER BY " + sortFieldName;
            if ("ASC".equalsIgnoreCase(sortOrder) || "DESC".equalsIgnoreCase(sortOrder)) {
                jpaQuery = jpaQuery + " " + sortOrder;
            }
        }
        TypedQuery<Abono> q = em.createQuery(jpaQuery, Abono.class);
        q.setParameter("status", status);
        q.setParameter("minFechaCreacion", minFechaCreacion);
        q.setParameter("maxFechaCreacion", maxFechaCreacion);
        return q;
    }

	@PersistenceContext
    transient EntityManager entityManager;

	public static final List<String> fieldNames4OrderClauseFilter = java.util.Arrays.asList("cargo", "metodoPago", "descuento", "observaciones", "status", "usuario", "fechaCreacion", "fechaModificacion");

	public static final EntityManager entityManager() {
        EntityManager em = new Abono().entityManager;
        if (em == null) throw new IllegalStateException("Entity manager has not been injected (is the Spring Aspects JAR configured as an AJC/AJDT aspects library?)");
        return em;
    }

	public static long countAbonoes() {
        return entityManager().createQuery("SELECT COUNT(o) FROM Abono o", Long.class).getSingleResult();
    }

	public static List<Abono> findAllAbonoes() {
        return entityManager().createQuery("SELECT o FROM Abono o", Abono.class).getResultList();
    }

	public static List<Abono> findAllAbonoes(String sortFieldName, String sortOrder) {
        String jpaQuery = "SELECT o FROM Abono o";
        if (fieldNames4OrderClauseFilter.contains(sortFieldName)) {
            jpaQuery = jpaQuery + " ORDER BY " + sortFieldName;
            if ("ASC".equalsIgnoreCase(sortOrder) || "DESC".equalsIgnoreCase(sortOrder)) {
                jpaQuery = jpaQuery + " " + sortOrder;
            }
        }
        return entityManager().createQuery(jpaQuery, Abono.class).getResultList();
    }

	public static Abono findAbono(Long id) {
        if (id == null) return null;
        return entityManager().find(Abono.class, id);
    }

	public static List<Abono> findAbonoEntries(int firstResult, int maxResults) {
        return entityManager().createQuery("SELECT o FROM Abono o", Abono.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }

	public static List<Abono> findAbonoEntries(int firstResult, int maxResults, String sortFieldName, String sortOrder) {
        String jpaQuery = "SELECT o FROM Abono o";
        if (fieldNames4OrderClauseFilter.contains(sortFieldName)) {
            jpaQuery = jpaQuery + " ORDER BY " + sortFieldName;
            if ("ASC".equalsIgnoreCase(sortOrder) || "DESC".equalsIgnoreCase(sortOrder)) {
                jpaQuery = jpaQuery + " " + sortOrder;
            }
        }
        return entityManager().createQuery(jpaQuery, Abono.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
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
            Abono attached = Abono.findAbono(this.id);
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
    public Abono merge() {
        if (this.entityManager == null) this.entityManager = entityManager();
        Abono merged = this.entityManager.merge(this);
        this.entityManager.flush();
        return merged;
    }

	public String toString() {
        return ReflectionToStringBuilder.toString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }

	public Cargo getCargo() {
        return this.cargo;
    }

	public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

	public MetodoPago getMetodoPago() {
        return this.metodoPago;
    }

	public void setMetodoPago(MetodoPago metodoPago) {
        this.metodoPago = metodoPago;
    }

	public Descuento getDescuento() {
        return this.descuento;
    }

	public void setDescuento(Descuento descuento) {
        this.descuento = descuento;
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

	public static Abono fromJsonToAbono(String json) {
        return new JSONDeserializer<Abono>()
        .use(null, Abono.class).deserialize(json);
    }

	public static String toJsonArray(Collection<Abono> collection) {
        return new JSONSerializer()
        .exclude("*.class").deepSerialize(collection);
    }

	public static String toJsonArray(Collection<Abono> collection, String[] fields) {
        return new JSONSerializer()
        .include(fields).exclude("*.class").deepSerialize(collection);
    }

	public static Collection<Abono> fromJsonArrayToAbonoes(String json) {
        return new JSONDeserializer<List<Abono>>()
        .use("values", Abono.class).deserialize(json);
    }
}
