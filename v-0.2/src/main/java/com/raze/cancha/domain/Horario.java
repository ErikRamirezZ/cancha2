package com.raze.cancha.domain;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;
import flexjson.JSONDeserializer;
import flexjson.JSONSerializer;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
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
@RooJpaActiveRecord(finders = { "findHorariosByActivo", "findHorariosByCanchaAndActivo" })
@RooJson(deepSerialize = true)
public class Horario {

    /**
     */
    @NotNull
    @ManyToOne
    private Cancha cancha;

    /**
     */
    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(style = "M-")
    private Date horaInicio;

    /**
     */
    private int duracion;

    /**
     */
    private Boolean lunes;

    /**
     */
    private Boolean martes;

    /**
     */
    private Boolean miercoles;

    /**
     */
    private Boolean jueves;

    /**
     */
    private Boolean viernes;

    /**
     */
    private Boolean sabado;

    /**
     */
    private Boolean domingo;

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

	public static final List<String> fieldNames4OrderClauseFilter = java.util.Arrays.asList("cancha", "horaInicio", "duracion", "lunes", "martes", "miercoles", "jueves", "viernes", "sabado", "domingo", "activo", "usuario", "fechaCreacion", "fechaModificacion");

	public static final EntityManager entityManager() {
        EntityManager em = new Horario().entityManager;
        if (em == null) throw new IllegalStateException("Entity manager has not been injected (is the Spring Aspects JAR configured as an AJC/AJDT aspects library?)");
        return em;
    }

	public static long countHorarios() {
        return entityManager().createQuery("SELECT COUNT(o) FROM Horario o", Long.class).getSingleResult();
    }

	public static List<Horario> findAllHorarios() {
        return entityManager().createQuery("SELECT o FROM Horario o", Horario.class).getResultList();
    }

	public static List<Horario> findAllHorarios(String sortFieldName, String sortOrder) {
        String jpaQuery = "SELECT o FROM Horario o";
        if (fieldNames4OrderClauseFilter.contains(sortFieldName)) {
            jpaQuery = jpaQuery + " ORDER BY " + sortFieldName;
            if ("ASC".equalsIgnoreCase(sortOrder) || "DESC".equalsIgnoreCase(sortOrder)) {
                jpaQuery = jpaQuery + " " + sortOrder;
            }
        }
        return entityManager().createQuery(jpaQuery, Horario.class).getResultList();
    }

	public static Horario findHorario(Long id) {
        if (id == null) return null;
        return entityManager().find(Horario.class, id);
    }

	public static List<Horario> findHorarioEntries(int firstResult, int maxResults) {
        return entityManager().createQuery("SELECT o FROM Horario o", Horario.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }

	public static List<Horario> findHorarioEntries(int firstResult, int maxResults, String sortFieldName, String sortOrder) {
        String jpaQuery = "SELECT o FROM Horario o";
        if (fieldNames4OrderClauseFilter.contains(sortFieldName)) {
            jpaQuery = jpaQuery + " ORDER BY " + sortFieldName;
            if ("ASC".equalsIgnoreCase(sortOrder) || "DESC".equalsIgnoreCase(sortOrder)) {
                jpaQuery = jpaQuery + " " + sortOrder;
            }
        }
        return entityManager().createQuery(jpaQuery, Horario.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
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
            Horario attached = Horario.findHorario(this.id);
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
    public Horario merge() {
        if (this.entityManager == null) this.entityManager = entityManager();
        Horario merged = this.entityManager.merge(this);
        this.entityManager.flush();
        return merged;
    }

	public static Long countFindHorariosByActivo(Boolean activo) {
        if (activo == null) throw new IllegalArgumentException("The activo argument is required");
        EntityManager em = Horario.entityManager();
        TypedQuery q = em.createQuery("SELECT COUNT(o) FROM Horario AS o WHERE o.activo = :activo", Long.class);
        q.setParameter("activo", activo);
        return ((Long) q.getSingleResult());
    }

	public static Long countFindHorariosByCanchaAndActivo(Cancha cancha, Boolean activo) {
        if (cancha == null) throw new IllegalArgumentException("The cancha argument is required");
        if (activo == null) throw new IllegalArgumentException("The activo argument is required");
        EntityManager em = Horario.entityManager();
        TypedQuery q = em.createQuery("SELECT COUNT(o) FROM Horario AS o WHERE o.cancha = :cancha AND o.activo = :activo", Long.class);
        q.setParameter("cancha", cancha);
        q.setParameter("activo", activo);
        return ((Long) q.getSingleResult());
    }

	public static TypedQuery<Horario> findHorariosByActivo(Boolean activo) {
        if (activo == null) throw new IllegalArgumentException("The activo argument is required");
        EntityManager em = Horario.entityManager();
        TypedQuery<Horario> q = em.createQuery("SELECT o FROM Horario AS o WHERE o.activo = :activo", Horario.class);
        q.setParameter("activo", activo);
        return q;
    }

	public static TypedQuery<Horario> findHorariosByActivo(Boolean activo, String sortFieldName, String sortOrder) {
        if (activo == null) throw new IllegalArgumentException("The activo argument is required");
        EntityManager em = Horario.entityManager();
        String jpaQuery = "SELECT o FROM Horario AS o WHERE o.activo = :activo";
        if (fieldNames4OrderClauseFilter.contains(sortFieldName)) {
            jpaQuery = jpaQuery + " ORDER BY " + sortFieldName;
            if ("ASC".equalsIgnoreCase(sortOrder) || "DESC".equalsIgnoreCase(sortOrder)) {
                jpaQuery = jpaQuery + " " + sortOrder;
            }
        }
        TypedQuery<Horario> q = em.createQuery(jpaQuery, Horario.class);
        q.setParameter("activo", activo);
        return q;
    }

	public static TypedQuery<Horario> findHorariosByCanchaAndActivo(Cancha cancha, Boolean activo) {
        if (cancha == null) throw new IllegalArgumentException("The cancha argument is required");
        if (activo == null) throw new IllegalArgumentException("The activo argument is required");
        EntityManager em = Horario.entityManager();
        TypedQuery<Horario> q = em.createQuery("SELECT o FROM Horario AS o WHERE o.cancha = :cancha AND o.activo = :activo", Horario.class);
        q.setParameter("cancha", cancha);
        q.setParameter("activo", activo);
        return q;
    }

	public static TypedQuery<Horario> findHorariosByCanchaAndActivo(Cancha cancha, Boolean activo, String sortFieldName, String sortOrder) {
        if (cancha == null) throw new IllegalArgumentException("The cancha argument is required");
        if (activo == null) throw new IllegalArgumentException("The activo argument is required");
        EntityManager em = Horario.entityManager();
        String jpaQuery = "SELECT o FROM Horario AS o WHERE o.cancha = :cancha AND o.activo = :activo";
        if (fieldNames4OrderClauseFilter.contains(sortFieldName)) {
            jpaQuery = jpaQuery + " ORDER BY " + sortFieldName;
            if ("ASC".equalsIgnoreCase(sortOrder) || "DESC".equalsIgnoreCase(sortOrder)) {
                jpaQuery = jpaQuery + " " + sortOrder;
            }
        }
        TypedQuery<Horario> q = em.createQuery(jpaQuery, Horario.class);
        q.setParameter("cancha", cancha);
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

	public static Horario fromJsonToHorario(String json) {
        return new JSONDeserializer<Horario>()
        .use(null, Horario.class).deserialize(json);
    }

	public static String toJsonArray(Collection<Horario> collection) {
        return new JSONSerializer()
        .exclude("*.class").deepSerialize(collection);
    }

	public static String toJsonArray(Collection<Horario> collection, String[] fields) {
        return new JSONSerializer()
        .include(fields).exclude("*.class").deepSerialize(collection);
    }

	public static Collection<Horario> fromJsonArrayToHorarios(String json) {
        return new JSONDeserializer<List<Horario>>()
        .use("values", Horario.class).deserialize(json);
    }

	public Cancha getCancha() {
        return this.cancha;
    }

	public void setCancha(Cancha cancha) {
        this.cancha = cancha;
    }

	public Date getHoraInicio() {
        return this.horaInicio;
    }

	public void setHoraInicio(Date horaInicio) {
        this.horaInicio = horaInicio;
    }

	public int getDuracion() {
        return this.duracion;
    }

	public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

	public Boolean getLunes() {
        return this.lunes;
    }

	public void setLunes(Boolean lunes) {
        this.lunes = lunes;
    }

	public Boolean getMartes() {
        return this.martes;
    }

	public void setMartes(Boolean martes) {
        this.martes = martes;
    }

	public Boolean getMiercoles() {
        return this.miercoles;
    }

	public void setMiercoles(Boolean miercoles) {
        this.miercoles = miercoles;
    }

	public Boolean getJueves() {
        return this.jueves;
    }

	public void setJueves(Boolean jueves) {
        this.jueves = jueves;
    }

	public Boolean getViernes() {
        return this.viernes;
    }

	public void setViernes(Boolean viernes) {
        this.viernes = viernes;
    }

	public Boolean getSabado() {
        return this.sabado;
    }

	public void setSabado(Boolean sabado) {
        this.sabado = sabado;
    }

	public Boolean getDomingo() {
        return this.domingo;
    }

	public void setDomingo(Boolean domingo) {
        this.domingo = domingo;
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

	public String toString() {
        return ReflectionToStringBuilder.toString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
}
