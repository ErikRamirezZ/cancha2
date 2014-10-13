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

@Entity
@Configurable
@RooJavaBean
@RooToString
@RooJpaActiveRecord(finders = { "findStatusEquipoJugadorsByActivo" })
@RooJson(deepSerialize = true)
public class StatusEquipoJugador {

    /**
     */
    @NotNull
    private String nombreStatusEquipoJugador;

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

	public String getNombreStatusEquipoJugador() {
        return this.nombreStatusEquipoJugador;
    }

	public void setNombreStatusEquipoJugador(String nombreStatusEquipoJugador) {
        this.nombreStatusEquipoJugador = nombreStatusEquipoJugador;
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

	public String toJson() {
        return new JSONSerializer()
        .exclude("*.class").deepSerialize(this);
    }

	public String toJson(String[] fields) {
        return new JSONSerializer()
        .include(fields).exclude("*.class").deepSerialize(this);
    }

	public static StatusEquipoJugador fromJsonToStatusEquipoJugador(String json) {
        return new JSONDeserializer<StatusEquipoJugador>()
        .use(null, StatusEquipoJugador.class).deserialize(json);
    }

	public static String toJsonArray(Collection<StatusEquipoJugador> collection) {
        return new JSONSerializer()
        .exclude("*.class").deepSerialize(collection);
    }

	public static String toJsonArray(Collection<StatusEquipoJugador> collection, String[] fields) {
        return new JSONSerializer()
        .include(fields).exclude("*.class").deepSerialize(collection);
    }

	public static Collection<StatusEquipoJugador> fromJsonArrayToStatusEquipoJugadors(String json) {
        return new JSONDeserializer<List<StatusEquipoJugador>>()
        .use("values", StatusEquipoJugador.class).deserialize(json);
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

	public static final List<String> fieldNames4OrderClauseFilter = java.util.Arrays.asList("nombreStatusEquipoJugador", "descripcion", "activo", "usuario", "fechaCreacion", "fechaModificacion");

	public static final EntityManager entityManager() {
        EntityManager em = new StatusEquipoJugador().entityManager;
        if (em == null) throw new IllegalStateException("Entity manager has not been injected (is the Spring Aspects JAR configured as an AJC/AJDT aspects library?)");
        return em;
    }

	public static long countStatusEquipoJugadors() {
        return entityManager().createQuery("SELECT COUNT(o) FROM StatusEquipoJugador o", Long.class).getSingleResult();
    }

	public static List<StatusEquipoJugador> findAllStatusEquipoJugadors() {
        return entityManager().createQuery("SELECT o FROM StatusEquipoJugador o", StatusEquipoJugador.class).getResultList();
    }

	public static List<StatusEquipoJugador> findAllStatusEquipoJugadors(String sortFieldName, String sortOrder) {
        String jpaQuery = "SELECT o FROM StatusEquipoJugador o";
        if (fieldNames4OrderClauseFilter.contains(sortFieldName)) {
            jpaQuery = jpaQuery + " ORDER BY " + sortFieldName;
            if ("ASC".equalsIgnoreCase(sortOrder) || "DESC".equalsIgnoreCase(sortOrder)) {
                jpaQuery = jpaQuery + " " + sortOrder;
            }
        }
        return entityManager().createQuery(jpaQuery, StatusEquipoJugador.class).getResultList();
    }

	public static StatusEquipoJugador findStatusEquipoJugador(Long id) {
        if (id == null) return null;
        return entityManager().find(StatusEquipoJugador.class, id);
    }

	public static List<StatusEquipoJugador> findStatusEquipoJugadorEntries(int firstResult, int maxResults) {
        return entityManager().createQuery("SELECT o FROM StatusEquipoJugador o", StatusEquipoJugador.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }

	public static List<StatusEquipoJugador> findStatusEquipoJugadorEntries(int firstResult, int maxResults, String sortFieldName, String sortOrder) {
        String jpaQuery = "SELECT o FROM StatusEquipoJugador o";
        if (fieldNames4OrderClauseFilter.contains(sortFieldName)) {
            jpaQuery = jpaQuery + " ORDER BY " + sortFieldName;
            if ("ASC".equalsIgnoreCase(sortOrder) || "DESC".equalsIgnoreCase(sortOrder)) {
                jpaQuery = jpaQuery + " " + sortOrder;
            }
        }
        return entityManager().createQuery(jpaQuery, StatusEquipoJugador.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
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
            StatusEquipoJugador attached = StatusEquipoJugador.findStatusEquipoJugador(this.id);
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
    public StatusEquipoJugador merge() {
        if (this.entityManager == null) this.entityManager = entityManager();
        StatusEquipoJugador merged = this.entityManager.merge(this);
        this.entityManager.flush();
        return merged;
    }

	public static Long countFindStatusEquipoJugadorsByActivo(Boolean activo) {
        if (activo == null) throw new IllegalArgumentException("The activo argument is required");
        EntityManager em = StatusEquipoJugador.entityManager();
        TypedQuery q = em.createQuery("SELECT COUNT(o) FROM StatusEquipoJugador AS o WHERE o.activo = :activo", Long.class);
        q.setParameter("activo", activo);
        return ((Long) q.getSingleResult());
    }

	public static TypedQuery<StatusEquipoJugador> findStatusEquipoJugadorsByActivo(Boolean activo) {
        if (activo == null) throw new IllegalArgumentException("The activo argument is required");
        EntityManager em = StatusEquipoJugador.entityManager();
        TypedQuery<StatusEquipoJugador> q = em.createQuery("SELECT o FROM StatusEquipoJugador AS o WHERE o.activo = :activo", StatusEquipoJugador.class);
        q.setParameter("activo", activo);
        return q;
    }

	public static TypedQuery<StatusEquipoJugador> findStatusEquipoJugadorsByActivo(Boolean activo, String sortFieldName, String sortOrder) {
        if (activo == null) throw new IllegalArgumentException("The activo argument is required");
        EntityManager em = StatusEquipoJugador.entityManager();
        String jpaQuery = "SELECT o FROM StatusEquipoJugador AS o WHERE o.activo = :activo";
        if (fieldNames4OrderClauseFilter.contains(sortFieldName)) {
            jpaQuery = jpaQuery + " ORDER BY " + sortFieldName;
            if ("ASC".equalsIgnoreCase(sortOrder) || "DESC".equalsIgnoreCase(sortOrder)) {
                jpaQuery = jpaQuery + " " + sortOrder;
            }
        }
        TypedQuery<StatusEquipoJugador> q = em.createQuery(jpaQuery, StatusEquipoJugador.class);
        q.setParameter("activo", activo);
        return q;
    }

	public String toString() {
        return ReflectionToStringBuilder.toString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
}
