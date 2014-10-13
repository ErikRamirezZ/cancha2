package com.raze.cancha.domain;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;
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
import javax.persistence.Lob;
import org.springframework.roo.classpath.operations.jsr303.RooUploadedFile;
import com.raze.cancha.catalog.Posicion;
import com.raze.cancha.catalog.StatusEquipoJugador;
import flexjson.JSONDeserializer;
import flexjson.JSONSerializer;
import org.springframework.roo.addon.json.RooJson;
import org.springframework.transaction.annotation.Transactional;

@Entity
@Configurable
@RooJavaBean
@RooToString
@RooJpaActiveRecord(finders = { "findJugadorsByEquipoAndActivo", "findJugadorsByEquipoAndNombreLikeAndActivo", "findJugadorsByEquipoAndNombreLikeAndApellidoPaternoLikeAndActivo", "findJugadorsByEquipoAndStatusAndActivo", "findJugadorsByEquipoAndEsDelegadoAndActivo", "findJugadorsByEquipoAndPosicionAndActivo" })
@RooJson(deepSerialize = true)
public class Jugador {

    /**
     */
    @NotNull
    @ManyToOne
    private Equipo equipo;

    /**
     */
    @NotNull
    private String nombre;

    /**
     */
    private String apellidoPaterno;

    /**
     */
    private String apellidoMaterno;

    /**
     */
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(style = "M-")
    private Date fechaNacimiento;

    /**
     */
    @RooUploadedFile(contentType = "image/jpeg", autoUpload = true)
    @Lob
    private byte[] foto;

    /**
     */
    private String domicilio;

    /**
     */
    private String telefono;

    /**
     */
    private String correoE;

    /**
     */
    private Boolean esDelegado;

    /**
     */
    @ManyToOne
    private Posicion posicion;

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

	public static Long countFindJugadorsByEquipoAndActivo(Equipo equipo, Boolean activo) {
        if (equipo == null) throw new IllegalArgumentException("The equipo argument is required");
        if (activo == null) throw new IllegalArgumentException("The activo argument is required");
        EntityManager em = Jugador.entityManager();
        TypedQuery q = em.createQuery("SELECT COUNT(o) FROM Jugador AS o WHERE o.equipo = :equipo AND o.activo = :activo", Long.class);
        q.setParameter("equipo", equipo);
        q.setParameter("activo", activo);
        return ((Long) q.getSingleResult());
    }

	public static Long countFindJugadorsByEquipoAndEsDelegadoAndActivo(Equipo equipo, Boolean esDelegado, Boolean activo) {
        if (equipo == null) throw new IllegalArgumentException("The equipo argument is required");
        if (esDelegado == null) throw new IllegalArgumentException("The esDelegado argument is required");
        if (activo == null) throw new IllegalArgumentException("The activo argument is required");
        EntityManager em = Jugador.entityManager();
        TypedQuery q = em.createQuery("SELECT COUNT(o) FROM Jugador AS o WHERE o.equipo = :equipo AND o.esDelegado = :esDelegado AND o.activo = :activo", Long.class);
        q.setParameter("equipo", equipo);
        q.setParameter("esDelegado", esDelegado);
        q.setParameter("activo", activo);
        return ((Long) q.getSingleResult());
    }

	public static Long countFindJugadorsByEquipoAndNombreLikeAndActivo(Equipo equipo, String nombre, Boolean activo) {
        if (equipo == null) throw new IllegalArgumentException("The equipo argument is required");
        if (nombre == null || nombre.length() == 0) throw new IllegalArgumentException("The nombre argument is required");
        nombre = nombre.replace('*', '%');
        if (nombre.charAt(0) != '%') {
            nombre = "%" + nombre;
        }
        if (nombre.charAt(nombre.length() - 1) != '%') {
            nombre = nombre + "%";
        }
        if (activo == null) throw new IllegalArgumentException("The activo argument is required");
        EntityManager em = Jugador.entityManager();
        TypedQuery q = em.createQuery("SELECT COUNT(o) FROM Jugador AS o WHERE o.equipo = :equipo AND LOWER(o.nombre) LIKE LOWER(:nombre)  AND o.activo = :activo", Long.class);
        q.setParameter("equipo", equipo);
        q.setParameter("nombre", nombre);
        q.setParameter("activo", activo);
        return ((Long) q.getSingleResult());
    }

	public static Long countFindJugadorsByEquipoAndNombreLikeAndApellidoPaternoLikeAndActivo(Equipo equipo, String nombre, String apellidoPaterno, Boolean activo) {
        if (equipo == null) throw new IllegalArgumentException("The equipo argument is required");
        if (nombre == null || nombre.length() == 0) throw new IllegalArgumentException("The nombre argument is required");
        nombre = nombre.replace('*', '%');
        if (nombre.charAt(0) != '%') {
            nombre = "%" + nombre;
        }
        if (nombre.charAt(nombre.length() - 1) != '%') {
            nombre = nombre + "%";
        }
        if (apellidoPaterno == null || apellidoPaterno.length() == 0) throw new IllegalArgumentException("The apellidoPaterno argument is required");
        apellidoPaterno = apellidoPaterno.replace('*', '%');
        if (apellidoPaterno.charAt(0) != '%') {
            apellidoPaterno = "%" + apellidoPaterno;
        }
        if (apellidoPaterno.charAt(apellidoPaterno.length() - 1) != '%') {
            apellidoPaterno = apellidoPaterno + "%";
        }
        if (activo == null) throw new IllegalArgumentException("The activo argument is required");
        EntityManager em = Jugador.entityManager();
        TypedQuery q = em.createQuery("SELECT COUNT(o) FROM Jugador AS o WHERE o.equipo = :equipo AND LOWER(o.nombre) LIKE LOWER(:nombre)  AND LOWER(o.apellidoPaterno) LIKE LOWER(:apellidoPaterno)  AND o.activo = :activo", Long.class);
        q.setParameter("equipo", equipo);
        q.setParameter("nombre", nombre);
        q.setParameter("apellidoPaterno", apellidoPaterno);
        q.setParameter("activo", activo);
        return ((Long) q.getSingleResult());
    }

	public static Long countFindJugadorsByEquipoAndPosicionAndActivo(Equipo equipo, Posicion posicion, Boolean activo) {
        if (equipo == null) throw new IllegalArgumentException("The equipo argument is required");
        if (posicion == null) throw new IllegalArgumentException("The posicion argument is required");
        if (activo == null) throw new IllegalArgumentException("The activo argument is required");
        EntityManager em = Jugador.entityManager();
        TypedQuery q = em.createQuery("SELECT COUNT(o) FROM Jugador AS o WHERE o.equipo = :equipo AND o.posicion = :posicion AND o.activo = :activo", Long.class);
        q.setParameter("equipo", equipo);
        q.setParameter("posicion", posicion);
        q.setParameter("activo", activo);
        return ((Long) q.getSingleResult());
    }

	public static Long countFindJugadorsByEquipoAndStatusAndActivo(Equipo equipo, StatusEquipoJugador status, Boolean activo) {
        if (equipo == null) throw new IllegalArgumentException("The equipo argument is required");
        if (status == null) throw new IllegalArgumentException("The status argument is required");
        if (activo == null) throw new IllegalArgumentException("The activo argument is required");
        EntityManager em = Jugador.entityManager();
        TypedQuery q = em.createQuery("SELECT COUNT(o) FROM Jugador AS o WHERE o.equipo = :equipo AND o.status = :status AND o.activo = :activo", Long.class);
        q.setParameter("equipo", equipo);
        q.setParameter("status", status);
        q.setParameter("activo", activo);
        return ((Long) q.getSingleResult());
    }

	public static TypedQuery<Jugador> findJugadorsByEquipoAndActivo(Equipo equipo, Boolean activo) {
        if (equipo == null) throw new IllegalArgumentException("The equipo argument is required");
        if (activo == null) throw new IllegalArgumentException("The activo argument is required");
        EntityManager em = Jugador.entityManager();
        TypedQuery<Jugador> q = em.createQuery("SELECT o FROM Jugador AS o WHERE o.equipo = :equipo AND o.activo = :activo", Jugador.class);
        q.setParameter("equipo", equipo);
        q.setParameter("activo", activo);
        return q;
    }

	public static TypedQuery<Jugador> findJugadorsByEquipoAndActivo(Equipo equipo, Boolean activo, String sortFieldName, String sortOrder) {
        if (equipo == null) throw new IllegalArgumentException("The equipo argument is required");
        if (activo == null) throw new IllegalArgumentException("The activo argument is required");
        EntityManager em = Jugador.entityManager();
        String jpaQuery = "SELECT o FROM Jugador AS o WHERE o.equipo = :equipo AND o.activo = :activo";
        if (fieldNames4OrderClauseFilter.contains(sortFieldName)) {
            jpaQuery = jpaQuery + " ORDER BY " + sortFieldName;
            if ("ASC".equalsIgnoreCase(sortOrder) || "DESC".equalsIgnoreCase(sortOrder)) {
                jpaQuery = jpaQuery + " " + sortOrder;
            }
        }
        TypedQuery<Jugador> q = em.createQuery(jpaQuery, Jugador.class);
        q.setParameter("equipo", equipo);
        q.setParameter("activo", activo);
        return q;
    }

	public static TypedQuery<Jugador> findJugadorsByEquipoAndEsDelegadoAndActivo(Equipo equipo, Boolean esDelegado, Boolean activo) {
        if (equipo == null) throw new IllegalArgumentException("The equipo argument is required");
        if (esDelegado == null) throw new IllegalArgumentException("The esDelegado argument is required");
        if (activo == null) throw new IllegalArgumentException("The activo argument is required");
        EntityManager em = Jugador.entityManager();
        TypedQuery<Jugador> q = em.createQuery("SELECT o FROM Jugador AS o WHERE o.equipo = :equipo AND o.esDelegado = :esDelegado AND o.activo = :activo", Jugador.class);
        q.setParameter("equipo", equipo);
        q.setParameter("esDelegado", esDelegado);
        q.setParameter("activo", activo);
        return q;
    }

	public static TypedQuery<Jugador> findJugadorsByEquipoAndEsDelegadoAndActivo(Equipo equipo, Boolean esDelegado, Boolean activo, String sortFieldName, String sortOrder) {
        if (equipo == null) throw new IllegalArgumentException("The equipo argument is required");
        if (esDelegado == null) throw new IllegalArgumentException("The esDelegado argument is required");
        if (activo == null) throw new IllegalArgumentException("The activo argument is required");
        EntityManager em = Jugador.entityManager();
        String jpaQuery = "SELECT o FROM Jugador AS o WHERE o.equipo = :equipo AND o.esDelegado = :esDelegado AND o.activo = :activo";
        if (fieldNames4OrderClauseFilter.contains(sortFieldName)) {
            jpaQuery = jpaQuery + " ORDER BY " + sortFieldName;
            if ("ASC".equalsIgnoreCase(sortOrder) || "DESC".equalsIgnoreCase(sortOrder)) {
                jpaQuery = jpaQuery + " " + sortOrder;
            }
        }
        TypedQuery<Jugador> q = em.createQuery(jpaQuery, Jugador.class);
        q.setParameter("equipo", equipo);
        q.setParameter("esDelegado", esDelegado);
        q.setParameter("activo", activo);
        return q;
    }

	public static TypedQuery<Jugador> findJugadorsByEquipoAndNombreLikeAndActivo(Equipo equipo, String nombre, Boolean activo) {
        if (equipo == null) throw new IllegalArgumentException("The equipo argument is required");
        if (nombre == null || nombre.length() == 0) throw new IllegalArgumentException("The nombre argument is required");
        nombre = nombre.replace('*', '%');
        if (nombre.charAt(0) != '%') {
            nombre = "%" + nombre;
        }
        if (nombre.charAt(nombre.length() - 1) != '%') {
            nombre = nombre + "%";
        }
        if (activo == null) throw new IllegalArgumentException("The activo argument is required");
        EntityManager em = Jugador.entityManager();
        TypedQuery<Jugador> q = em.createQuery("SELECT o FROM Jugador AS o WHERE o.equipo = :equipo AND LOWER(o.nombre) LIKE LOWER(:nombre)  AND o.activo = :activo", Jugador.class);
        q.setParameter("equipo", equipo);
        q.setParameter("nombre", nombre);
        q.setParameter("activo", activo);
        return q;
    }

	public static TypedQuery<Jugador> findJugadorsByEquipoAndNombreLikeAndActivo(Equipo equipo, String nombre, Boolean activo, String sortFieldName, String sortOrder) {
        if (equipo == null) throw new IllegalArgumentException("The equipo argument is required");
        if (nombre == null || nombre.length() == 0) throw new IllegalArgumentException("The nombre argument is required");
        nombre = nombre.replace('*', '%');
        if (nombre.charAt(0) != '%') {
            nombre = "%" + nombre;
        }
        if (nombre.charAt(nombre.length() - 1) != '%') {
            nombre = nombre + "%";
        }
        if (activo == null) throw new IllegalArgumentException("The activo argument is required");
        EntityManager em = Jugador.entityManager();
        String jpaQuery = "SELECT o FROM Jugador AS o WHERE o.equipo = :equipo AND LOWER(o.nombre) LIKE LOWER(:nombre)  AND o.activo = :activo";
        if (fieldNames4OrderClauseFilter.contains(sortFieldName)) {
            jpaQuery = jpaQuery + " ORDER BY " + sortFieldName;
            if ("ASC".equalsIgnoreCase(sortOrder) || "DESC".equalsIgnoreCase(sortOrder)) {
                jpaQuery = jpaQuery + " " + sortOrder;
            }
        }
        TypedQuery<Jugador> q = em.createQuery(jpaQuery, Jugador.class);
        q.setParameter("equipo", equipo);
        q.setParameter("nombre", nombre);
        q.setParameter("activo", activo);
        return q;
    }

	public static TypedQuery<Jugador> findJugadorsByEquipoAndNombreLikeAndApellidoPaternoLikeAndActivo(Equipo equipo, String nombre, String apellidoPaterno, Boolean activo) {
        if (equipo == null) throw new IllegalArgumentException("The equipo argument is required");
        if (nombre == null || nombre.length() == 0) throw new IllegalArgumentException("The nombre argument is required");
        nombre = nombre.replace('*', '%');
        if (nombre.charAt(0) != '%') {
            nombre = "%" + nombre;
        }
        if (nombre.charAt(nombre.length() - 1) != '%') {
            nombre = nombre + "%";
        }
        if (apellidoPaterno == null || apellidoPaterno.length() == 0) throw new IllegalArgumentException("The apellidoPaterno argument is required");
        apellidoPaterno = apellidoPaterno.replace('*', '%');
        if (apellidoPaterno.charAt(0) != '%') {
            apellidoPaterno = "%" + apellidoPaterno;
        }
        if (apellidoPaterno.charAt(apellidoPaterno.length() - 1) != '%') {
            apellidoPaterno = apellidoPaterno + "%";
        }
        if (activo == null) throw new IllegalArgumentException("The activo argument is required");
        EntityManager em = Jugador.entityManager();
        TypedQuery<Jugador> q = em.createQuery("SELECT o FROM Jugador AS o WHERE o.equipo = :equipo AND LOWER(o.nombre) LIKE LOWER(:nombre)  AND LOWER(o.apellidoPaterno) LIKE LOWER(:apellidoPaterno)  AND o.activo = :activo", Jugador.class);
        q.setParameter("equipo", equipo);
        q.setParameter("nombre", nombre);
        q.setParameter("apellidoPaterno", apellidoPaterno);
        q.setParameter("activo", activo);
        return q;
    }

	public static TypedQuery<Jugador> findJugadorsByEquipoAndNombreLikeAndApellidoPaternoLikeAndActivo(Equipo equipo, String nombre, String apellidoPaterno, Boolean activo, String sortFieldName, String sortOrder) {
        if (equipo == null) throw new IllegalArgumentException("The equipo argument is required");
        if (nombre == null || nombre.length() == 0) throw new IllegalArgumentException("The nombre argument is required");
        nombre = nombre.replace('*', '%');
        if (nombre.charAt(0) != '%') {
            nombre = "%" + nombre;
        }
        if (nombre.charAt(nombre.length() - 1) != '%') {
            nombre = nombre + "%";
        }
        if (apellidoPaterno == null || apellidoPaterno.length() == 0) throw new IllegalArgumentException("The apellidoPaterno argument is required");
        apellidoPaterno = apellidoPaterno.replace('*', '%');
        if (apellidoPaterno.charAt(0) != '%') {
            apellidoPaterno = "%" + apellidoPaterno;
        }
        if (apellidoPaterno.charAt(apellidoPaterno.length() - 1) != '%') {
            apellidoPaterno = apellidoPaterno + "%";
        }
        if (activo == null) throw new IllegalArgumentException("The activo argument is required");
        EntityManager em = Jugador.entityManager();
        String jpaQuery = "SELECT o FROM Jugador AS o WHERE o.equipo = :equipo AND LOWER(o.nombre) LIKE LOWER(:nombre)  AND LOWER(o.apellidoPaterno) LIKE LOWER(:apellidoPaterno)  AND o.activo = :activo";
        if (fieldNames4OrderClauseFilter.contains(sortFieldName)) {
            jpaQuery = jpaQuery + " ORDER BY " + sortFieldName;
            if ("ASC".equalsIgnoreCase(sortOrder) || "DESC".equalsIgnoreCase(sortOrder)) {
                jpaQuery = jpaQuery + " " + sortOrder;
            }
        }
        TypedQuery<Jugador> q = em.createQuery(jpaQuery, Jugador.class);
        q.setParameter("equipo", equipo);
        q.setParameter("nombre", nombre);
        q.setParameter("apellidoPaterno", apellidoPaterno);
        q.setParameter("activo", activo);
        return q;
    }

	public static TypedQuery<Jugador> findJugadorsByEquipoAndPosicionAndActivo(Equipo equipo, Posicion posicion, Boolean activo) {
        if (equipo == null) throw new IllegalArgumentException("The equipo argument is required");
        if (posicion == null) throw new IllegalArgumentException("The posicion argument is required");
        if (activo == null) throw new IllegalArgumentException("The activo argument is required");
        EntityManager em = Jugador.entityManager();
        TypedQuery<Jugador> q = em.createQuery("SELECT o FROM Jugador AS o WHERE o.equipo = :equipo AND o.posicion = :posicion AND o.activo = :activo", Jugador.class);
        q.setParameter("equipo", equipo);
        q.setParameter("posicion", posicion);
        q.setParameter("activo", activo);
        return q;
    }

	public static TypedQuery<Jugador> findJugadorsByEquipoAndPosicionAndActivo(Equipo equipo, Posicion posicion, Boolean activo, String sortFieldName, String sortOrder) {
        if (equipo == null) throw new IllegalArgumentException("The equipo argument is required");
        if (posicion == null) throw new IllegalArgumentException("The posicion argument is required");
        if (activo == null) throw new IllegalArgumentException("The activo argument is required");
        EntityManager em = Jugador.entityManager();
        String jpaQuery = "SELECT o FROM Jugador AS o WHERE o.equipo = :equipo AND o.posicion = :posicion AND o.activo = :activo";
        if (fieldNames4OrderClauseFilter.contains(sortFieldName)) {
            jpaQuery = jpaQuery + " ORDER BY " + sortFieldName;
            if ("ASC".equalsIgnoreCase(sortOrder) || "DESC".equalsIgnoreCase(sortOrder)) {
                jpaQuery = jpaQuery + " " + sortOrder;
            }
        }
        TypedQuery<Jugador> q = em.createQuery(jpaQuery, Jugador.class);
        q.setParameter("equipo", equipo);
        q.setParameter("posicion", posicion);
        q.setParameter("activo", activo);
        return q;
    }

	public static TypedQuery<Jugador> findJugadorsByEquipoAndStatusAndActivo(Equipo equipo, StatusEquipoJugador status, Boolean activo) {
        if (equipo == null) throw new IllegalArgumentException("The equipo argument is required");
        if (status == null) throw new IllegalArgumentException("The status argument is required");
        if (activo == null) throw new IllegalArgumentException("The activo argument is required");
        EntityManager em = Jugador.entityManager();
        TypedQuery<Jugador> q = em.createQuery("SELECT o FROM Jugador AS o WHERE o.equipo = :equipo AND o.status = :status AND o.activo = :activo", Jugador.class);
        q.setParameter("equipo", equipo);
        q.setParameter("status", status);
        q.setParameter("activo", activo);
        return q;
    }

	public static TypedQuery<Jugador> findJugadorsByEquipoAndStatusAndActivo(Equipo equipo, StatusEquipoJugador status, Boolean activo, String sortFieldName, String sortOrder) {
        if (equipo == null) throw new IllegalArgumentException("The equipo argument is required");
        if (status == null) throw new IllegalArgumentException("The status argument is required");
        if (activo == null) throw new IllegalArgumentException("The activo argument is required");
        EntityManager em = Jugador.entityManager();
        String jpaQuery = "SELECT o FROM Jugador AS o WHERE o.equipo = :equipo AND o.status = :status AND o.activo = :activo";
        if (fieldNames4OrderClauseFilter.contains(sortFieldName)) {
            jpaQuery = jpaQuery + " ORDER BY " + sortFieldName;
            if ("ASC".equalsIgnoreCase(sortOrder) || "DESC".equalsIgnoreCase(sortOrder)) {
                jpaQuery = jpaQuery + " " + sortOrder;
            }
        }
        TypedQuery<Jugador> q = em.createQuery(jpaQuery, Jugador.class);
        q.setParameter("equipo", equipo);
        q.setParameter("status", status);
        q.setParameter("activo", activo);
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

	public static Jugador fromJsonToJugador(String json) {
        return new JSONDeserializer<Jugador>()
        .use(null, Jugador.class).deserialize(json);
    }

	public static String toJsonArray(Collection<Jugador> collection) {
        return new JSONSerializer()
        .exclude("*.class").deepSerialize(collection);
    }

	public static String toJsonArray(Collection<Jugador> collection, String[] fields) {
        return new JSONSerializer()
        .include(fields).exclude("*.class").deepSerialize(collection);
    }

	public static Collection<Jugador> fromJsonArrayToJugadors(String json) {
        return new JSONDeserializer<List<Jugador>>()
        .use("values", Jugador.class).deserialize(json);
    }

	public Equipo getEquipo() {
        return this.equipo;
    }

	public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

	public String getNombre() {
        return this.nombre;
    }

	public void setNombre(String nombre) {
        this.nombre = nombre;
    }

	public String getApellidoPaterno() {
        return this.apellidoPaterno;
    }

	public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

	public String getApellidoMaterno() {
        return this.apellidoMaterno;
    }

	public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

	public Date getFechaNacimiento() {
        return this.fechaNacimiento;
    }

	public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

	public byte[] getFoto() {
        return this.foto;
    }

	public void setFoto(byte[] foto) {
        this.foto = foto;
    }

	public String getDomicilio() {
        return this.domicilio;
    }

	public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

	public String getTelefono() {
        return this.telefono;
    }

	public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

	public String getCorreoE() {
        return this.correoE;
    }

	public void setCorreoE(String correoE) {
        this.correoE = correoE;
    }

	public Boolean getEsDelegado() {
        return this.esDelegado;
    }

	public void setEsDelegado(Boolean esDelegado) {
        this.esDelegado = esDelegado;
    }

	public Posicion getPosicion() {
        return this.posicion;
    }

	public void setPosicion(Posicion posicion) {
        this.posicion = posicion;
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

	@PersistenceContext
    transient EntityManager entityManager;

	public static final List<String> fieldNames4OrderClauseFilter = java.util.Arrays.asList("equipo", "nombre", "apellidoPaterno", "apellidoMaterno", "fechaNacimiento", "foto", "domicilio", "telefono", "correoE", "esDelegado", "posicion", "status", "activo", "usuario", "fechaCreacion", "fechaModificacion");

	public static final EntityManager entityManager() {
        EntityManager em = new Jugador().entityManager;
        if (em == null) throw new IllegalStateException("Entity manager has not been injected (is the Spring Aspects JAR configured as an AJC/AJDT aspects library?)");
        return em;
    }

	public static long countJugadors() {
        return entityManager().createQuery("SELECT COUNT(o) FROM Jugador o", Long.class).getSingleResult();
    }

	public static List<Jugador> findAllJugadors() {
        return entityManager().createQuery("SELECT o FROM Jugador o", Jugador.class).getResultList();
    }

	public static List<Jugador> findAllJugadors(String sortFieldName, String sortOrder) {
        String jpaQuery = "SELECT o FROM Jugador o";
        if (fieldNames4OrderClauseFilter.contains(sortFieldName)) {
            jpaQuery = jpaQuery + " ORDER BY " + sortFieldName;
            if ("ASC".equalsIgnoreCase(sortOrder) || "DESC".equalsIgnoreCase(sortOrder)) {
                jpaQuery = jpaQuery + " " + sortOrder;
            }
        }
        return entityManager().createQuery(jpaQuery, Jugador.class).getResultList();
    }

	public static Jugador findJugador(Long id) {
        if (id == null) return null;
        return entityManager().find(Jugador.class, id);
    }

	public static List<Jugador> findJugadorEntries(int firstResult, int maxResults) {
        return entityManager().createQuery("SELECT o FROM Jugador o", Jugador.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }

	public static List<Jugador> findJugadorEntries(int firstResult, int maxResults, String sortFieldName, String sortOrder) {
        String jpaQuery = "SELECT o FROM Jugador o";
        if (fieldNames4OrderClauseFilter.contains(sortFieldName)) {
            jpaQuery = jpaQuery + " ORDER BY " + sortFieldName;
            if ("ASC".equalsIgnoreCase(sortOrder) || "DESC".equalsIgnoreCase(sortOrder)) {
                jpaQuery = jpaQuery + " " + sortOrder;
            }
        }
        return entityManager().createQuery(jpaQuery, Jugador.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
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
            Jugador attached = Jugador.findJugador(this.id);
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
    public Jugador merge() {
        if (this.entityManager == null) this.entityManager = entityManager();
        Jugador merged = this.entityManager.merge(this);
        this.entityManager.flush();
        return merged;
    }
}
