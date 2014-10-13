package com.raze.cancha.domain;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;
import javax.validation.constraints.NotNull;
import javax.persistence.Lob;
import org.springframework.roo.classpath.operations.jsr303.RooUploadedFile;
import com.raze.cancha.catalog.StatusEquipoJugador;
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
@RooJpaActiveRecord(finders = { "findEquipoesByActivo", "findEquipoesByStatusAndActivo" })
@RooJson(deepSerialize = true)
public class Equipo {

    /**
     */
    @NotNull
    private String nombre;

    /**
     */
    @NotNull
    private String nombreCorto;

    /**
     */
    private String nombreLargo;

    /**
     */
    @RooUploadedFile(contentType = "image/jpeg", autoUpload = true)
    @Lob
    private byte[] logo;

    /**
     */
    @ManyToOne
    private StatusEquipoJugador status;

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

	public static Long countFindEquipoesByActivo(Boolean activo) {
        if (activo == null) throw new IllegalArgumentException("The activo argument is required");
        EntityManager em = Equipo.entityManager();
        TypedQuery q = em.createQuery("SELECT COUNT(o) FROM Equipo AS o WHERE o.activo = :activo", Long.class);
        q.setParameter("activo", activo);
        return ((Long) q.getSingleResult());
    }

	public static Long countFindEquipoesByStatusAndActivo(StatusEquipoJugador status, Boolean activo) {
        if (status == null) throw new IllegalArgumentException("The status argument is required");
        if (activo == null) throw new IllegalArgumentException("The activo argument is required");
        EntityManager em = Equipo.entityManager();
        TypedQuery q = em.createQuery("SELECT COUNT(o) FROM Equipo AS o WHERE o.status = :status AND o.activo = :activo", Long.class);
        q.setParameter("status", status);
        q.setParameter("activo", activo);
        return ((Long) q.getSingleResult());
    }

	public static TypedQuery<Equipo> findEquipoesByActivo(Boolean activo) {
        if (activo == null) throw new IllegalArgumentException("The activo argument is required");
        EntityManager em = Equipo.entityManager();
        TypedQuery<Equipo> q = em.createQuery("SELECT o FROM Equipo AS o WHERE o.activo = :activo", Equipo.class);
        q.setParameter("activo", activo);
        return q;
    }

	public static TypedQuery<Equipo> findEquipoesByActivo(Boolean activo, String sortFieldName, String sortOrder) {
        if (activo == null) throw new IllegalArgumentException("The activo argument is required");
        EntityManager em = Equipo.entityManager();
        String jpaQuery = "SELECT o FROM Equipo AS o WHERE o.activo = :activo";
        if (fieldNames4OrderClauseFilter.contains(sortFieldName)) {
            jpaQuery = jpaQuery + " ORDER BY " + sortFieldName;
            if ("ASC".equalsIgnoreCase(sortOrder) || "DESC".equalsIgnoreCase(sortOrder)) {
                jpaQuery = jpaQuery + " " + sortOrder;
            }
        }
        TypedQuery<Equipo> q = em.createQuery(jpaQuery, Equipo.class);
        q.setParameter("activo", activo);
        return q;
    }

	public static TypedQuery<Equipo> findEquipoesByStatusAndActivo(StatusEquipoJugador status, Boolean activo) {
        if (status == null) throw new IllegalArgumentException("The status argument is required");
        if (activo == null) throw new IllegalArgumentException("The activo argument is required");
        EntityManager em = Equipo.entityManager();
        TypedQuery<Equipo> q = em.createQuery("SELECT o FROM Equipo AS o WHERE o.status = :status AND o.activo = :activo", Equipo.class);
        q.setParameter("status", status);
        q.setParameter("activo", activo);
        return q;
    }

	public static TypedQuery<Equipo> findEquipoesByStatusAndActivo(StatusEquipoJugador status, Boolean activo, String sortFieldName, String sortOrder) {
        if (status == null) throw new IllegalArgumentException("The status argument is required");
        if (activo == null) throw new IllegalArgumentException("The activo argument is required");
        EntityManager em = Equipo.entityManager();
        String jpaQuery = "SELECT o FROM Equipo AS o WHERE o.status = :status AND o.activo = :activo";
        if (fieldNames4OrderClauseFilter.contains(sortFieldName)) {
            jpaQuery = jpaQuery + " ORDER BY " + sortFieldName;
            if ("ASC".equalsIgnoreCase(sortOrder) || "DESC".equalsIgnoreCase(sortOrder)) {
                jpaQuery = jpaQuery + " " + sortOrder;
            }
        }
        TypedQuery<Equipo> q = em.createQuery(jpaQuery, Equipo.class);
        q.setParameter("status", status);
        q.setParameter("activo", activo);
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

	public static Equipo fromJsonToEquipo(String json) {
        return new JSONDeserializer<Equipo>()
        .use(null, Equipo.class).deserialize(json);
    }

	public static String toJsonArray(Collection<Equipo> collection) {
        return new JSONSerializer()
        .exclude("*.class").deepSerialize(collection);
    }

	public static String toJsonArray(Collection<Equipo> collection, String[] fields) {
        return new JSONSerializer()
        .include(fields).exclude("*.class").deepSerialize(collection);
    }

	public static Collection<Equipo> fromJsonArrayToEquipoes(String json) {
        return new JSONDeserializer<List<Equipo>>()
        .use("values", Equipo.class).deserialize(json);
    }

	@PersistenceContext
    transient EntityManager entityManager;

	public static final List<String> fieldNames4OrderClauseFilter = java.util.Arrays.asList("nombre", "nombreCorto", "nombreLargo", "logo", "status", "activo", "usuario", "fechaCreacion", "fechaModificacion");

	public static final EntityManager entityManager() {
        EntityManager em = new Equipo().entityManager;
        if (em == null) throw new IllegalStateException("Entity manager has not been injected (is the Spring Aspects JAR configured as an AJC/AJDT aspects library?)");
        return em;
    }

	public static long countEquipoes() {
        return entityManager().createQuery("SELECT COUNT(o) FROM Equipo o", Long.class).getSingleResult();
    }

	public static List<Equipo> findAllEquipoes() {
        return entityManager().createQuery("SELECT o FROM Equipo o", Equipo.class).getResultList();
    }

	public static List<Equipo> findAllEquipoes(String sortFieldName, String sortOrder) {
        String jpaQuery = "SELECT o FROM Equipo o";
        if (fieldNames4OrderClauseFilter.contains(sortFieldName)) {
            jpaQuery = jpaQuery + " ORDER BY " + sortFieldName;
            if ("ASC".equalsIgnoreCase(sortOrder) || "DESC".equalsIgnoreCase(sortOrder)) {
                jpaQuery = jpaQuery + " " + sortOrder;
            }
        }
        return entityManager().createQuery(jpaQuery, Equipo.class).getResultList();
    }

	public static Equipo findEquipo(Long id) {
        if (id == null) return null;
        return entityManager().find(Equipo.class, id);
    }

	public static List<Equipo> findEquipoEntries(int firstResult, int maxResults) {
        return entityManager().createQuery("SELECT o FROM Equipo o", Equipo.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }

	public static List<Equipo> findEquipoEntries(int firstResult, int maxResults, String sortFieldName, String sortOrder) {
        String jpaQuery = "SELECT o FROM Equipo o";
        if (fieldNames4OrderClauseFilter.contains(sortFieldName)) {
            jpaQuery = jpaQuery + " ORDER BY " + sortFieldName;
            if ("ASC".equalsIgnoreCase(sortOrder) || "DESC".equalsIgnoreCase(sortOrder)) {
                jpaQuery = jpaQuery + " " + sortOrder;
            }
        }
        return entityManager().createQuery(jpaQuery, Equipo.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
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
            Equipo attached = Equipo.findEquipo(this.id);
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
    public Equipo merge() {
        if (this.entityManager == null) this.entityManager = entityManager();
        Equipo merged = this.entityManager.merge(this);
        this.entityManager.flush();
        return merged;
    }

	public String getNombre() {
        return this.nombre;
    }

	public void setNombre(String nombre) {
        this.nombre = nombre;
    }

	public String getNombreCorto() {
        return this.nombreCorto;
    }

	public void setNombreCorto(String nombreCorto) {
        this.nombreCorto = nombreCorto;
    }

	public String getNombreLargo() {
        return this.nombreLargo;
    }

	public void setNombreLargo(String nombreLargo) {
        this.nombreLargo = nombreLargo;
    }

	public byte[] getLogo() {
        return this.logo;
    }

	public void setLogo(byte[] logo) {
        this.logo = logo;
    }

	public StatusEquipoJugador getStatus() {
        return this.status;
    }

	public void setStatus(StatusEquipoJugador status) {
        this.status = status;
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
}
