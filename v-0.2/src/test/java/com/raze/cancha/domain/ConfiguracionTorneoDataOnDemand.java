package com.raze.cancha.domain;
import com.raze.cancha.catalog.DiasJuegoDataOnDemand;
import com.raze.cancha.catalog.TipoCobroDataOnDemand;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.roo.addon.dod.RooDataOnDemand;
import org.springframework.stereotype.Component;

@Configurable
@Component
@RooDataOnDemand(entity = ConfiguracionTorneo.class)
public class ConfiguracionTorneoDataOnDemand {

	private Random rnd = new SecureRandom();

	private List<ConfiguracionTorneo> data;

	@Autowired
    DiasJuegoDataOnDemand diasJuegoDataOnDemand;

	@Autowired
    TipoCobroDataOnDemand tipoCobroDataOnDemand;

	@Autowired
    TorneoDataOnDemand torneoDataOnDemand;

	@Autowired
    UsuarioDataOnDemand usuarioDataOnDemand;

	public ConfiguracionTorneo getNewTransientConfiguracionTorneo(int index) {
        ConfiguracionTorneo obj = new ConfiguracionTorneo();
        setActivo(obj, index);
        setCosto(obj, index);
        setCostoIncripcion(obj, index);
        setFechaCreacion(obj, index);
        setFechaModificacion(obj, index);
        setInscripcion(obj, index);
        setNumeroJugadoresXEquipo(obj, index);
        setNumeroPagos(obj, index);
        setTorneo(obj, index);
        return obj;
    }

	public void setActivo(ConfiguracionTorneo obj, int index) {
        Boolean activo = Boolean.TRUE;
        obj.setActivo(activo);
    }

	public void setCosto(ConfiguracionTorneo obj, int index) {
        double costo = new Integer(index).doubleValue();
        if (costo > 2D) {
            costo = 2D;
        }
        obj.setCosto(costo);
    }

	public void setCostoIncripcion(ConfiguracionTorneo obj, int index) {
        double costoIncripcion = new Integer(index).doubleValue();
        if (costoIncripcion > 2D) {
            costoIncripcion = 2D;
        }
        obj.setCostoIncripcion(costoIncripcion);
    }

	public void setFechaCreacion(ConfiguracionTorneo obj, int index) {
        Date fechaCreacion = new GregorianCalendar(Calendar.getInstance().get(Calendar.YEAR), Calendar.getInstance().get(Calendar.MONTH), Calendar.getInstance().get(Calendar.DAY_OF_MONTH), Calendar.getInstance().get(Calendar.HOUR_OF_DAY), Calendar.getInstance().get(Calendar.MINUTE), Calendar.getInstance().get(Calendar.SECOND) + new Double(Math.random() * 1000).intValue()).getTime();
        obj.setFechaCreacion(fechaCreacion);
    }

	public void setFechaModificacion(ConfiguracionTorneo obj, int index) {
        Date fechaModificacion = new GregorianCalendar(Calendar.getInstance().get(Calendar.YEAR), Calendar.getInstance().get(Calendar.MONTH), Calendar.getInstance().get(Calendar.DAY_OF_MONTH), Calendar.getInstance().get(Calendar.HOUR_OF_DAY), Calendar.getInstance().get(Calendar.MINUTE), Calendar.getInstance().get(Calendar.SECOND) + new Double(Math.random() * 1000).intValue()).getTime();
        obj.setFechaModificacion(fechaModificacion);
    }

	public void setInscripcion(ConfiguracionTorneo obj, int index) {
        Boolean inscripcion = Boolean.TRUE;
        obj.setInscripcion(inscripcion);
    }

	public void setNumeroJugadoresXEquipo(ConfiguracionTorneo obj, int index) {
        int numeroJugadoresXEquipo = index;
        obj.setNumeroJugadoresXEquipo(numeroJugadoresXEquipo);
    }

	public void setNumeroPagos(ConfiguracionTorneo obj, int index) {
        int numeroPagos = index;
        obj.setNumeroPagos(numeroPagos);
    }

	public void setTorneo(ConfiguracionTorneo obj, int index) {
        Torneo torneo = torneoDataOnDemand.getRandomTorneo();
        obj.setTorneo(torneo);
    }

	public ConfiguracionTorneo getSpecificConfiguracionTorneo(int index) {
        init();
        if (index < 0) {
            index = 0;
        }
        if (index > (data.size() - 1)) {
            index = data.size() - 1;
        }
        ConfiguracionTorneo obj = data.get(index);
        Long id = obj.getId();
        return ConfiguracionTorneo.findConfiguracionTorneo(id);
    }

	public ConfiguracionTorneo getRandomConfiguracionTorneo() {
        init();
        ConfiguracionTorneo obj = data.get(rnd.nextInt(data.size()));
        Long id = obj.getId();
        return ConfiguracionTorneo.findConfiguracionTorneo(id);
    }

	public boolean modifyConfiguracionTorneo(ConfiguracionTorneo obj) {
        return false;
    }

	public void init() {
        int from = 0;
        int to = 10;
        data = ConfiguracionTorneo.findConfiguracionTorneoEntries(from, to);
        if (data == null) {
            throw new IllegalStateException("Find entries implementation for 'ConfiguracionTorneo' illegally returned null");
        }
        if (!data.isEmpty()) {
            return;
        }
        
        data = new ArrayList<ConfiguracionTorneo>();
        for (int i = 0; i < 10; i++) {
            ConfiguracionTorneo obj = getNewTransientConfiguracionTorneo(i);
            try {
                obj.persist();
            } catch (final ConstraintViolationException e) {
                final StringBuilder msg = new StringBuilder();
                for (Iterator<ConstraintViolation<?>> iter = e.getConstraintViolations().iterator(); iter.hasNext();) {
                    final ConstraintViolation<?> cv = iter.next();
                    msg.append("[").append(cv.getRootBean().getClass().getName()).append(".").append(cv.getPropertyPath()).append(": ").append(cv.getMessage()).append(" (invalid value = ").append(cv.getInvalidValue()).append(")").append("]");
                }
                throw new IllegalStateException(msg.toString(), e);
            }
            obj.flush();
            data.add(obj);
        }
    }
}
