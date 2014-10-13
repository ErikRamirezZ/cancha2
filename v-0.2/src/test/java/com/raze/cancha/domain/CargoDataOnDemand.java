package com.raze.cancha.domain;
import com.raze.cancha.catalog.ConceptoCobro;
import com.raze.cancha.catalog.ConceptoCobroDataOnDemand;
import com.raze.cancha.catalog.StatusCargoAbonoDataOnDemand;
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
@RooDataOnDemand(entity = Cargo.class)
public class CargoDataOnDemand {

	private Random rnd = new SecureRandom();

	private List<Cargo> data;

	@Autowired
    AbonoDataOnDemand abonoDataOnDemand;

	@Autowired
    ConceptoCobroDataOnDemand conceptoCobroDataOnDemand;

	@Autowired
    EquipoDataOnDemand equipoDataOnDemand;

	@Autowired
    StatusCargoAbonoDataOnDemand statusCargoAbonoDataOnDemand;

	@Autowired
    TorneoDataOnDemand torneoDataOnDemand;

	@Autowired
    UsuarioDataOnDemand usuarioDataOnDemand;

	public Cargo getNewTransientCargo(int index) {
        Cargo obj = new Cargo();
        setConceptoCobro(obj, index);
        setEquipo(obj, index);
        setFechaCreacion(obj, index);
        setFechaModificacion(obj, index);
        setMonto(obj, index);
        setObservaciones(obj, index);
        setTorneo(obj, index);
        return obj;
    }

	public void setConceptoCobro(Cargo obj, int index) {
        ConceptoCobro conceptoCobro = conceptoCobroDataOnDemand.getRandomConceptoCobro();
        obj.setConceptoCobro(conceptoCobro);
    }

	public void setEquipo(Cargo obj, int index) {
        Equipo equipo = equipoDataOnDemand.getRandomEquipo();
        obj.setEquipo(equipo);
    }

	public void setFechaCreacion(Cargo obj, int index) {
        Date fechaCreacion = new GregorianCalendar(Calendar.getInstance().get(Calendar.YEAR), Calendar.getInstance().get(Calendar.MONTH), Calendar.getInstance().get(Calendar.DAY_OF_MONTH), Calendar.getInstance().get(Calendar.HOUR_OF_DAY), Calendar.getInstance().get(Calendar.MINUTE), Calendar.getInstance().get(Calendar.SECOND) + new Double(Math.random() * 1000).intValue()).getTime();
        obj.setFechaCreacion(fechaCreacion);
    }

	public void setFechaModificacion(Cargo obj, int index) {
        Date fechaModificacion = new GregorianCalendar(Calendar.getInstance().get(Calendar.YEAR), Calendar.getInstance().get(Calendar.MONTH), Calendar.getInstance().get(Calendar.DAY_OF_MONTH), Calendar.getInstance().get(Calendar.HOUR_OF_DAY), Calendar.getInstance().get(Calendar.MINUTE), Calendar.getInstance().get(Calendar.SECOND) + new Double(Math.random() * 1000).intValue()).getTime();
        obj.setFechaModificacion(fechaModificacion);
    }

	public void setMonto(Cargo obj, int index) {
        double monto = new Integer(index).doubleValue();
        obj.setMonto(monto);
    }

	public void setObservaciones(Cargo obj, int index) {
        String observaciones = "observaciones_" + index;
        obj.setObservaciones(observaciones);
    }

	public void setTorneo(Cargo obj, int index) {
        Torneo torneo = torneoDataOnDemand.getRandomTorneo();
        obj.setTorneo(torneo);
    }

	public Cargo getSpecificCargo(int index) {
        init();
        if (index < 0) {
            index = 0;
        }
        if (index > (data.size() - 1)) {
            index = data.size() - 1;
        }
        Cargo obj = data.get(index);
        Long id = obj.getId();
        return Cargo.findCargo(id);
    }

	public Cargo getRandomCargo() {
        init();
        Cargo obj = data.get(rnd.nextInt(data.size()));
        Long id = obj.getId();
        return Cargo.findCargo(id);
    }

	public boolean modifyCargo(Cargo obj) {
        return false;
    }

	public void init() {
        int from = 0;
        int to = 10;
        data = Cargo.findCargoEntries(from, to);
        if (data == null) {
            throw new IllegalStateException("Find entries implementation for 'Cargo' illegally returned null");
        }
        if (!data.isEmpty()) {
            return;
        }
        
        data = new ArrayList<Cargo>();
        for (int i = 0; i < 10; i++) {
            Cargo obj = getNewTransientCargo(i);
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
