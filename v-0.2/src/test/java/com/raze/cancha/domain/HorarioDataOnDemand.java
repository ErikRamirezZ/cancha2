package com.raze.cancha.domain;
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
@RooDataOnDemand(entity = Horario.class)
public class HorarioDataOnDemand {

	private Random rnd = new SecureRandom();

	private List<Horario> data;

	@Autowired
    CanchaDataOnDemand canchaDataOnDemand;

	@Autowired
    UsuarioDataOnDemand usuarioDataOnDemand;

	public Horario getNewTransientHorario(int index) {
        Horario obj = new Horario();
        setActivo(obj, index);
        setCancha(obj, index);
        setDomingo(obj, index);
        setDuracion(obj, index);
        setFechaCreacion(obj, index);
        setFechaModificacion(obj, index);
        setHoraInicio(obj, index);
        setJueves(obj, index);
        setLunes(obj, index);
        setMartes(obj, index);
        setMiercoles(obj, index);
        setSabado(obj, index);
        setViernes(obj, index);
        return obj;
    }

	public void setActivo(Horario obj, int index) {
        Boolean activo = Boolean.TRUE;
        obj.setActivo(activo);
    }

	public void setCancha(Horario obj, int index) {
        Cancha cancha = canchaDataOnDemand.getRandomCancha();
        obj.setCancha(cancha);
    }

	public void setDomingo(Horario obj, int index) {
        Boolean domingo = Boolean.TRUE;
        obj.setDomingo(domingo);
    }

	public void setDuracion(Horario obj, int index) {
        int duracion = index;
        obj.setDuracion(duracion);
    }

	public void setFechaCreacion(Horario obj, int index) {
        Date fechaCreacion = new GregorianCalendar(Calendar.getInstance().get(Calendar.YEAR), Calendar.getInstance().get(Calendar.MONTH), Calendar.getInstance().get(Calendar.DAY_OF_MONTH), Calendar.getInstance().get(Calendar.HOUR_OF_DAY), Calendar.getInstance().get(Calendar.MINUTE), Calendar.getInstance().get(Calendar.SECOND) + new Double(Math.random() * 1000).intValue()).getTime();
        obj.setFechaCreacion(fechaCreacion);
    }

	public void setFechaModificacion(Horario obj, int index) {
        Date fechaModificacion = new GregorianCalendar(Calendar.getInstance().get(Calendar.YEAR), Calendar.getInstance().get(Calendar.MONTH), Calendar.getInstance().get(Calendar.DAY_OF_MONTH), Calendar.getInstance().get(Calendar.HOUR_OF_DAY), Calendar.getInstance().get(Calendar.MINUTE), Calendar.getInstance().get(Calendar.SECOND) + new Double(Math.random() * 1000).intValue()).getTime();
        obj.setFechaModificacion(fechaModificacion);
    }

	public void setHoraInicio(Horario obj, int index) {
        Date horaInicio = new GregorianCalendar(Calendar.getInstance().get(Calendar.YEAR), Calendar.getInstance().get(Calendar.MONTH), Calendar.getInstance().get(Calendar.DAY_OF_MONTH), Calendar.getInstance().get(Calendar.HOUR_OF_DAY), Calendar.getInstance().get(Calendar.MINUTE), Calendar.getInstance().get(Calendar.SECOND) + new Double(Math.random() * 1000).intValue()).getTime();
        obj.setHoraInicio(horaInicio);
    }

	public void setJueves(Horario obj, int index) {
        Boolean jueves = Boolean.TRUE;
        obj.setJueves(jueves);
    }

	public void setLunes(Horario obj, int index) {
        Boolean lunes = Boolean.TRUE;
        obj.setLunes(lunes);
    }

	public void setMartes(Horario obj, int index) {
        Boolean martes = Boolean.TRUE;
        obj.setMartes(martes);
    }

	public void setMiercoles(Horario obj, int index) {
        Boolean miercoles = Boolean.TRUE;
        obj.setMiercoles(miercoles);
    }

	public void setSabado(Horario obj, int index) {
        Boolean sabado = Boolean.TRUE;
        obj.setSabado(sabado);
    }

	public void setViernes(Horario obj, int index) {
        Boolean viernes = Boolean.TRUE;
        obj.setViernes(viernes);
    }

	public Horario getSpecificHorario(int index) {
        init();
        if (index < 0) {
            index = 0;
        }
        if (index > (data.size() - 1)) {
            index = data.size() - 1;
        }
        Horario obj = data.get(index);
        Long id = obj.getId();
        return Horario.findHorario(id);
    }

	public Horario getRandomHorario() {
        init();
        Horario obj = data.get(rnd.nextInt(data.size()));
        Long id = obj.getId();
        return Horario.findHorario(id);
    }

	public boolean modifyHorario(Horario obj) {
        return false;
    }

	public void init() {
        int from = 0;
        int to = 10;
        data = Horario.findHorarioEntries(from, to);
        if (data == null) {
            throw new IllegalStateException("Find entries implementation for 'Horario' illegally returned null");
        }
        if (!data.isEmpty()) {
            return;
        }
        
        data = new ArrayList<Horario>();
        for (int i = 0; i < 10; i++) {
            Horario obj = getNewTransientHorario(i);
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
