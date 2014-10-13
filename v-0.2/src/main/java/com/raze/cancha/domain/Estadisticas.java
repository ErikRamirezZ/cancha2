package com.raze.cancha.domain;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import com.raze.cancha.catalog.Accion;
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
@RooJpaActiveRecord(finders = { "findEstadisticasesByAlineacion", "findEstadisticasesByAccion" })
@RooJson(deepSerialize = true)
public class Estadisticas {

    /**
     */
    @NotNull
    @ManyToOne
    private Alineacion alineacion;

    /**
     */
    @NotNull
    @ManyToOne
    private Accion accion;

    /**
     */
    @NotNull
    private int minuto;

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

	public String toJson() {
        return new JSONSerializer()
        .exclude("*.class").deepSerialize(this);
    }

	public String toJson(String[] fields) {
        return new JSONSerializer()
        .include(fields).exclude("*.class").deepSerialize(this);
    }

	public static Estadisticas fromJsonToEstadisticas(String json) {
        return new JSONDeserializer<Estadisticas>()
        .use(null, Estadisticas.class).deserialize(json);
    }

	public static String toJsonArray(Collection<Estadisticas> collection) {
        return new JSONSerializer()
        .exclude("*.class").deepSerialize(collection);
    }

	public static String toJsonArray(Collection<Estadisticas> collection, String[] fields) {
        return new JSONSerializer()
        .include(fields).exclude("*.class").deepSerialize(collection);
    }

	public static Collection<Estadisticas> fromJsonArrayToEstadisticases(String json) {
        return new JSONDeserializer<List<Estadisticas>>()
        .use("values", Estadisticas.class).deserialize(json);
    }

	public static Long countFindEstadisticasesByAccion(Accion accion) {
        if (accion == null) throw new IllegalArgumentException("The accion argument is required");
        EntityManager em = Estadisticas.entityManager();
        TypedQuery q = em.createQuery("SELECT COUNT(o) FROM Estadisticas AS o WHERE o.accion = :accion", Long.class);
        q.setParameter("accion", accion);
        return ((Long) q.getSingleResult());
    }

	public static Long countFindEstadisticasesByAlineacion(Alineacion alineacion) {
        if (alineacion == null) throw new IllegalArgumentException("The alineacion argument is required");
        EntityManager em = Estadisticas.entityManager();
        TypedQuery q = em.createQuery("SELECT COUNT(o) FROM Estadisticas AS o WHERE o.alineacion = :alineacion", Long.class);
        q.setParameter("alineacion", alineacion);
        return ((Long) q.getSingleResult());
    }

	public static TypedQuery<Estadisticas> findEstadisticasesByAccion(Accion accion) {
        if (accion == null) throw new IllegalArgumentException("The accion argument is required");
        EntityManager em = Estadisticas.entityManager();
        TypedQuery<Estadisticas> q = em.createQuery("SELECT o FROM Estadisticas AS o WHERE o.accion = :accion", Estadisticas.class);
        q.setParameter("accion", accion);
        return q;
    }

	public static TypedQuery<Estadisticas> findEstadisticasesByAccion(Accion accion, String sortFieldName, String sortOrder) {
        if (accion == null) throw new IllegalArgumentException("The accion argument is required");
        EntityManager em = Estadisticas.entityManager();
        String jpaQuery = "SELECT o FROM Estadisticas AS o WHERE o.accion = :accion";
        if (fieldNames4OrderClauseFilter.contains(sortFieldName)) {
            jpaQuery = jpaQuery + " ORDER BY " + sortFieldName;
            if ("ASC".equalsIgnoreCase(sortOrder) || "DESC".equalsIgnoreCase(sortOrder)) {
                jpaQuery = jpaQuery + " " + sortOrder;
            }
        }
        TypedQuery<Estadisticas> q = em.createQuery(jpaQuery, Estadisticas.class);
        q.setParameter("accion", accion);
        return q;
    }

	public static TypedQuery<Estadisticas> findEstadisticasesByAlineacion(Alineacion alineacion) {
        if (alineacion == null) throw new IllegalArgumentException("The alineacion argument is required");
        EntityManager em = Estadisticas.entityManager();
        TypedQuery<Estadisticas> q = em.createQuery("SELECT o FROM Estadisticas AS o WHERE o.alineacion = :alineacion", Estadisticas.class);
        q.setParameter("alineacion", alineacion);
        return q;
    }

	public static TypedQuery<Estadisticas> findEstadisticasesByAlineacion(Alineacion alineacion, String sortFieldName, String sortOrder) {
        if (alineacion == null) throw new IllegalArgumentException("The alineacion argument is required");
        EntityManager em = Estadisticas.entityManager();
        String jpaQuery = "SELECT o FROM Estadisticas AS o WHERE o.alineacion = :alineacion";
        if (fieldNames4OrderClauseFilter.contains(sortFieldName)) {
            jpaQuery = jpaQuery + " ORDER BY " + sortFieldName;
            if ("ASC".equalsIgnoreCase(sortOrder) || "DESC".equalsIgnoreCase(sortOrder)) {
                jpaQuery = jpaQuery + " " + sortOrder;
            }
        }
        TypedQuery<Estadisticas> q = em.createQuery(jpaQuery, Estadisticas.class);
        q.setParameter("alineacion", alineacion);
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

	@PersistenceContext
    transient EntityManager entityManager;

	public static final List<String> fieldNames4OrderClauseFilter = java.util.Arrays.asList("alineacion", "accion", "minuto", "usuario", "fechaCreacion", "fechaModificacion");

	public static final EntityManager entityManager() {
        EntityManager em = new Estadisticas().entityManager;
        if (em == null) throw new IllegalStateException("Entity manager has not been injected (is the Spring Aspects JAR configured as an AJC/AJDT aspects library?)");
        return em;
    }

	public static long countEstadisticases() {
        return entityManager().createQuery("SELECT COUNT(o) FROM Estadisticas o", Long.class).getSingleResult();
    }

	public static List<Estadisticas> findAllEstadisticases() {
        return entityManager().createQuery("SELECT o FROM Estadisticas o", Estadisticas.class).getResultList();
    }

	public static List<Estadisticas> findAllEstadisticases(String sortFieldName, String sortOrder) {
        String jpaQuery = "SELECT o FROM Estadisticas o";
        if (fieldNames4OrderClauseFilter.contains(sortFieldName)) {
            jpaQuery = jpaQuery + " ORDER BY " + sortFieldName;
            if ("ASC".equalsIgnoreCase(sortOrder) || "DESC".equalsIgnoreCase(sortOrder)) {
                jpaQuery = jpaQuery + " " + sortOrder;
            }
        }
        return entityManager().createQuery(jpaQuery, Estadisticas.class).getResultList();
    }

	public static Estadisticas findEstadisticas(Long id) {
        if (id == null) return null;
        return entityManager().find(Estadisticas.class, id);
    }

	public static List<Estadisticas> findEstadisticasEntries(int firstResult, int maxResults) {
        return entityManager().createQuery("SELECT o FROM Estadisticas o", Estadisticas.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }

	public static List<Estadisticas> findEstadisticasEntries(int firstResult, int maxResults, String sortFieldName, String sortOrder) {
        String jpaQuery = "SELECT o FROM Estadisticas o";
        if (fieldNames4OrderClauseFilter.contains(sortFieldName)) {
            jpaQuery = jpaQuery + " ORDER BY " + sortFieldName;
            if ("ASC".equalsIgnoreCase(sortOrder) || "DESC".equalsIgnoreCase(sortOrder)) {
                jpaQuery = jpaQuery + " " + sortOrder;
            }
        }
        return entityManager().createQuery(jpaQuery, Estadisticas.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
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
            Estadisticas attached = Estadisticas.findEstadisticas(this.id);
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
    public Estadisticas merge() {
        if (this.entityManager == null) this.entityManager = entityManager();
        Estadisticas merged = this.entityManager.merge(this);
        this.entityManager.flush();
        return merged;
    }

	public String toString() {
        return ReflectionToStringBuilder.toString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }

	public Alineacion getAlineacion() {
        return this.alineacion;
    }

	public void setAlineacion(Alineacion alineacion) {
        this.alineacion = alineacion;
    }

	public Accion getAccion() {
        return this.accion;
    }

	public void setAccion(Accion accion) {
        this.accion = accion;
    }

	public int getMinuto() {
        return this.minuto;
    }

	public void setMinuto(int minuto) {
        this.minuto = minuto;
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
}
