package com.raze.cancha.domain;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import com.raze.cancha.catalog.TipoTarjeta;
import com.raze.cancha.catalog.FechaVencimientoTC;
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
import javax.persistence.Version;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.roo.addon.json.RooJson;
import org.springframework.transaction.annotation.Transactional;

@Entity
@Configurable
@RooJavaBean
@RooToString
@RooJpaActiveRecord
@RooJson(deepSerialize = true)
public class ControlPago {

    /**
     */
    @NotNull
    @ManyToOne
    private Empresa empresa;

    /**
     */
    @NotNull
    private double tarifa;

    /**
     */
    private int cuenta;

    /**
     */
    private int noReferencia;

    /**
     */
    @ManyToOne
    private TipoTarjeta tipoTarjeta;

    /**
     */
    private int noTC;

    /**
     */
    private int codigoSeguridad;

    /**
     */
    @ManyToOne
    private FechaVencimientoTC fechaVencimientoTC;

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

	public static final List<String> fieldNames4OrderClauseFilter = java.util.Arrays.asList("empresa", "tarifa", "cuenta", "noReferencia", "tipoTarjeta", "noTC", "codigoSeguridad", "fechaVencimientoTC", "usuario", "fechaCreacion", "fechaModificacion");

	public static final EntityManager entityManager() {
        EntityManager em = new ControlPago().entityManager;
        if (em == null) throw new IllegalStateException("Entity manager has not been injected (is the Spring Aspects JAR configured as an AJC/AJDT aspects library?)");
        return em;
    }

	public static long countControlPagoes() {
        return entityManager().createQuery("SELECT COUNT(o) FROM ControlPago o", Long.class).getSingleResult();
    }

	public static List<ControlPago> findAllControlPagoes() {
        return entityManager().createQuery("SELECT o FROM ControlPago o", ControlPago.class).getResultList();
    }

	public static List<ControlPago> findAllControlPagoes(String sortFieldName, String sortOrder) {
        String jpaQuery = "SELECT o FROM ControlPago o";
        if (fieldNames4OrderClauseFilter.contains(sortFieldName)) {
            jpaQuery = jpaQuery + " ORDER BY " + sortFieldName;
            if ("ASC".equalsIgnoreCase(sortOrder) || "DESC".equalsIgnoreCase(sortOrder)) {
                jpaQuery = jpaQuery + " " + sortOrder;
            }
        }
        return entityManager().createQuery(jpaQuery, ControlPago.class).getResultList();
    }

	public static ControlPago findControlPago(Long id) {
        if (id == null) return null;
        return entityManager().find(ControlPago.class, id);
    }

	public static List<ControlPago> findControlPagoEntries(int firstResult, int maxResults) {
        return entityManager().createQuery("SELECT o FROM ControlPago o", ControlPago.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }

	public static List<ControlPago> findControlPagoEntries(int firstResult, int maxResults, String sortFieldName, String sortOrder) {
        String jpaQuery = "SELECT o FROM ControlPago o";
        if (fieldNames4OrderClauseFilter.contains(sortFieldName)) {
            jpaQuery = jpaQuery + " ORDER BY " + sortFieldName;
            if ("ASC".equalsIgnoreCase(sortOrder) || "DESC".equalsIgnoreCase(sortOrder)) {
                jpaQuery = jpaQuery + " " + sortOrder;
            }
        }
        return entityManager().createQuery(jpaQuery, ControlPago.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
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
            ControlPago attached = ControlPago.findControlPago(this.id);
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
    public ControlPago merge() {
        if (this.entityManager == null) this.entityManager = entityManager();
        ControlPago merged = this.entityManager.merge(this);
        this.entityManager.flush();
        return merged;
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

	public static ControlPago fromJsonToControlPago(String json) {
        return new JSONDeserializer<ControlPago>()
        .use(null, ControlPago.class).deserialize(json);
    }

	public static String toJsonArray(Collection<ControlPago> collection) {
        return new JSONSerializer()
        .exclude("*.class").deepSerialize(collection);
    }

	public static String toJsonArray(Collection<ControlPago> collection, String[] fields) {
        return new JSONSerializer()
        .include(fields).exclude("*.class").deepSerialize(collection);
    }

	public static Collection<ControlPago> fromJsonArrayToControlPagoes(String json) {
        return new JSONDeserializer<List<ControlPago>>()
        .use("values", ControlPago.class).deserialize(json);
    }

	public Empresa getEmpresa() {
        return this.empresa;
    }

	public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

	public double getTarifa() {
        return this.tarifa;
    }

	public void setTarifa(double tarifa) {
        this.tarifa = tarifa;
    }

	public int getCuenta() {
        return this.cuenta;
    }

	public void setCuenta(int cuenta) {
        this.cuenta = cuenta;
    }

	public int getNoReferencia() {
        return this.noReferencia;
    }

	public void setNoReferencia(int noReferencia) {
        this.noReferencia = noReferencia;
    }

	public TipoTarjeta getTipoTarjeta() {
        return this.tipoTarjeta;
    }

	public void setTipoTarjeta(TipoTarjeta tipoTarjeta) {
        this.tipoTarjeta = tipoTarjeta;
    }

	public int getNoTC() {
        return this.noTC;
    }

	public void setNoTC(int noTC) {
        this.noTC = noTC;
    }

	public int getCodigoSeguridad() {
        return this.codigoSeguridad;
    }

	public void setCodigoSeguridad(int codigoSeguridad) {
        this.codigoSeguridad = codigoSeguridad;
    }

	public FechaVencimientoTC getFechaVencimientoTC() {
        return this.fechaVencimientoTC;
    }

	public void setFechaVencimientoTC(FechaVencimientoTC fechaVencimientoTC) {
        this.fechaVencimientoTC = fechaVencimientoTC;
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
