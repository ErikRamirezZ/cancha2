package com.raze.cancha.domain;
import com.raze.cancha.catalog.StatusPartido;
import com.raze.cancha.catalog.StatusPartidoDataOnDemand;
import com.raze.cancha.catalog.TipoPartidoDataOnDemand;
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
@RooDataOnDemand(entity = Partido.class)
public class PartidoDataOnDemand {

	private Random rnd = new SecureRandom();

	private List<Partido> data;

	@Autowired
    CanchaDataOnDemand canchaDataOnDemand;

	@Autowired
    EquipoDataOnDemand equipoDataOnDemand;

	@Autowired
    HorarioDataOnDemand horarioDataOnDemand;

	@Autowired
    StatusPartidoDataOnDemand statusPartidoDataOnDemand;

	@Autowired
    TipoPartidoDataOnDemand tipoPartidoDataOnDemand;

	@Autowired
    TorneoDataOnDemand torneoDataOnDemand;

	@Autowired
    UsuarioDataOnDemand usuarioDataOnDemand;

	public Partido getNewTransientPartido(int index) {
        Partido obj = new Partido();
        setCancha(obj, index);
        setFechaCreacion(obj, index);
        setFechaJuego(obj, index);
        setFechaModificacion(obj, index);
        setStatus(obj, index);
        return obj;
    }

	public void setCancha(Partido obj, int index) {
        Cancha cancha = canchaDataOnDemand.getRandomCancha();
        obj.setCancha(cancha);
    }

	public void setFechaCreacion(Partido obj, int index) {
        Date fechaCreacion = new GregorianCalendar(Calendar.getInstance().get(Calendar.YEAR), Calendar.getInstance().get(Calendar.MONTH), Calendar.getInstance().get(Calendar.DAY_OF_MONTH), Calendar.getInstance().get(Calendar.HOUR_OF_DAY), Calendar.getInstance().get(Calendar.MINUTE), Calendar.getInstance().get(Calendar.SECOND) + new Double(Math.random() * 1000).intValue()).getTime();
        obj.setFechaCreacion(fechaCreacion);
    }

	public void setFechaJuego(Partido obj, int index) {
        Date fechaJuego = new GregorianCalendar(Calendar.getInstance().get(Calendar.YEAR), Calendar.getInstance().get(Calendar.MONTH), Calendar.getInstance().get(Calendar.DAY_OF_MONTH), Calendar.getInstance().get(Calendar.HOUR_OF_DAY), Calendar.getInstance().get(Calendar.MINUTE), Calendar.getInstance().get(Calendar.SECOND) + new Double(Math.random() * 1000).intValue()).getTime();
        obj.setFechaJuego(fechaJuego);
    }

	public void setFechaModificacion(Partido obj, int index) {
        Date fechaModificacion = new GregorianCalendar(Calendar.getInstance().get(Calendar.YEAR), Calendar.getInstance().get(Calendar.MONTH), Calendar.getInstance().get(Calendar.DAY_OF_MONTH), Calendar.getInstance().get(Calendar.HOUR_OF_DAY), Calendar.getInstance().get(Calendar.MINUTE), Calendar.getInstance().get(Calendar.SECOND) + new Double(Math.random() * 1000).intValue()).getTime();
        obj.setFechaModificacion(fechaModificacion);
    }

	public void setStatus(Partido obj, int index) {
        StatusPartido status = statusPartidoDataOnDemand.getRandomStatusPartido();
        obj.setStatus(status);
    }

	public Partido getSpecificPartido(int index) {
        init();
        if (index < 0) {
            index = 0;
        }
        if (index > (data.size() - 1)) {
            index = data.size() - 1;
        }
        Partido obj = data.get(index);
        Long id = obj.getId();
        return Partido.findPartido(id);
    }

	public Partido getRandomPartido() {
        init();
        Partido obj = data.get(rnd.nextInt(data.size()));
        Long id = obj.getId();
        return Partido.findPartido(id);
    }

	public boolean modifyPartido(Partido obj) {
        return false;
    }

	public void init() {
        int from = 0;
        int to = 10;
        data = Partido.findPartidoEntries(from, to);
        if (data == null) {
            throw new IllegalStateException("Find entries implementation for 'Partido' illegally returned null");
        }
        if (!data.isEmpty()) {
            return;
        }
        
        data = new ArrayList<Partido>();
        for (int i = 0; i < 10; i++) {
            Partido obj = getNewTransientPartido(i);
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
