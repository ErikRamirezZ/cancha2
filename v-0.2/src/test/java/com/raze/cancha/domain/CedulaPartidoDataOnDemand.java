package com.raze.cancha.domain;
import com.raze.cancha.catalog.StatusCedula;
import com.raze.cancha.catalog.StatusCedulaDataOnDemand;
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

@Component
@Configurable
@RooDataOnDemand(entity = CedulaPartido.class)
public class CedulaPartidoDataOnDemand {

	private Random rnd = new SecureRandom();

	private List<CedulaPartido> data;

	@Autowired
    PartidoDataOnDemand partidoDataOnDemand;

	@Autowired
    StatusCedulaDataOnDemand statusCedulaDataOnDemand;

	@Autowired
    UsuarioDataOnDemand usuarioDataOnDemand;

	public CedulaPartido getNewTransientCedulaPartido(int index) {
        CedulaPartido obj = new CedulaPartido();
        setFechaCreacion(obj, index);
        setFechaModificacion(obj, index);
        setMarcadorEquipoLocal(obj, index);
        setMarcadorEquipoVisitante(obj, index);
        setObservaciones(obj, index);
        setPartido(obj, index);
        setStatus(obj, index);
        return obj;
    }

	public void setFechaCreacion(CedulaPartido obj, int index) {
        Date fechaCreacion = new GregorianCalendar(Calendar.getInstance().get(Calendar.YEAR), Calendar.getInstance().get(Calendar.MONTH), Calendar.getInstance().get(Calendar.DAY_OF_MONTH), Calendar.getInstance().get(Calendar.HOUR_OF_DAY), Calendar.getInstance().get(Calendar.MINUTE), Calendar.getInstance().get(Calendar.SECOND) + new Double(Math.random() * 1000).intValue()).getTime();
        obj.setFechaCreacion(fechaCreacion);
    }

	public void setFechaModificacion(CedulaPartido obj, int index) {
        Date fechaModificacion = new GregorianCalendar(Calendar.getInstance().get(Calendar.YEAR), Calendar.getInstance().get(Calendar.MONTH), Calendar.getInstance().get(Calendar.DAY_OF_MONTH), Calendar.getInstance().get(Calendar.HOUR_OF_DAY), Calendar.getInstance().get(Calendar.MINUTE), Calendar.getInstance().get(Calendar.SECOND) + new Double(Math.random() * 1000).intValue()).getTime();
        obj.setFechaModificacion(fechaModificacion);
    }

	public void setMarcadorEquipoLocal(CedulaPartido obj, int index) {
        int marcadorEquipoLocal = index;
        obj.setMarcadorEquipoLocal(marcadorEquipoLocal);
    }

	public void setMarcadorEquipoVisitante(CedulaPartido obj, int index) {
        int marcadorEquipoVisitante = index;
        obj.setMarcadorEquipoVisitante(marcadorEquipoVisitante);
    }

	public void setObservaciones(CedulaPartido obj, int index) {
        String observaciones = "observaciones_" + index;
        obj.setObservaciones(observaciones);
    }

	public void setPartido(CedulaPartido obj, int index) {
        Partido partido = partidoDataOnDemand.getRandomPartido();
        obj.setPartido(partido);
    }

	public void setStatus(CedulaPartido obj, int index) {
        StatusCedula status = statusCedulaDataOnDemand.getRandomStatusCedula();
        obj.setStatus(status);
    }

	public CedulaPartido getSpecificCedulaPartido(int index) {
        init();
        if (index < 0) {
            index = 0;
        }
        if (index > (data.size() - 1)) {
            index = data.size() - 1;
        }
        CedulaPartido obj = data.get(index);
        Long id = obj.getId();
        return CedulaPartido.findCedulaPartido(id);
    }

	public CedulaPartido getRandomCedulaPartido() {
        init();
        CedulaPartido obj = data.get(rnd.nextInt(data.size()));
        Long id = obj.getId();
        return CedulaPartido.findCedulaPartido(id);
    }

	public boolean modifyCedulaPartido(CedulaPartido obj) {
        return false;
    }

	public void init() {
        int from = 0;
        int to = 10;
        data = CedulaPartido.findCedulaPartidoEntries(from, to);
        if (data == null) {
            throw new IllegalStateException("Find entries implementation for 'CedulaPartido' illegally returned null");
        }
        if (!data.isEmpty()) {
            return;
        }
        
        data = new ArrayList<CedulaPartido>();
        for (int i = 0; i < 10; i++) {
            CedulaPartido obj = getNewTransientCedulaPartido(i);
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
