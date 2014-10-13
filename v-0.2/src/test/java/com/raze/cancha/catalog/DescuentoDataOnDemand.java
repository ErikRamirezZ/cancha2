package com.raze.cancha.catalog;
import com.raze.cancha.domain.UsuarioDataOnDemand;
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
@RooDataOnDemand(entity = Descuento.class)
public class DescuentoDataOnDemand {

	private Random rnd = new SecureRandom();

	private List<Descuento> data;

	@Autowired
    UsuarioDataOnDemand usuarioDataOnDemand;

	public Descuento getNewTransientDescuento(int index) {
        Descuento obj = new Descuento();
        setActivo(obj, index);
        setDescripcion(obj, index);
        setFechaCreacion(obj, index);
        setFechaModificacion(obj, index);
        setNombreDescuento(obj, index);
        return obj;
    }

	public void setActivo(Descuento obj, int index) {
        Boolean activo = Boolean.TRUE;
        obj.setActivo(activo);
    }

	public void setDescripcion(Descuento obj, int index) {
        String descripcion = "descripcion_" + index;
        obj.setDescripcion(descripcion);
    }

	public void setFechaCreacion(Descuento obj, int index) {
        Date fechaCreacion = new GregorianCalendar(Calendar.getInstance().get(Calendar.YEAR), Calendar.getInstance().get(Calendar.MONTH), Calendar.getInstance().get(Calendar.DAY_OF_MONTH), Calendar.getInstance().get(Calendar.HOUR_OF_DAY), Calendar.getInstance().get(Calendar.MINUTE), Calendar.getInstance().get(Calendar.SECOND) + new Double(Math.random() * 1000).intValue()).getTime();
        obj.setFechaCreacion(fechaCreacion);
    }

	public void setFechaModificacion(Descuento obj, int index) {
        Date fechaModificacion = new GregorianCalendar(Calendar.getInstance().get(Calendar.YEAR), Calendar.getInstance().get(Calendar.MONTH), Calendar.getInstance().get(Calendar.DAY_OF_MONTH), Calendar.getInstance().get(Calendar.HOUR_OF_DAY), Calendar.getInstance().get(Calendar.MINUTE), Calendar.getInstance().get(Calendar.SECOND) + new Double(Math.random() * 1000).intValue()).getTime();
        obj.setFechaModificacion(fechaModificacion);
    }

	public void setNombreDescuento(Descuento obj, int index) {
        String nombreDescuento = "nombreDescuento_" + index;
        obj.setNombreDescuento(nombreDescuento);
    }

	public Descuento getSpecificDescuento(int index) {
        init();
        if (index < 0) {
            index = 0;
        }
        if (index > (data.size() - 1)) {
            index = data.size() - 1;
        }
        Descuento obj = data.get(index);
        Long id = obj.getId();
        return Descuento.findDescuento(id);
    }

	public Descuento getRandomDescuento() {
        init();
        Descuento obj = data.get(rnd.nextInt(data.size()));
        Long id = obj.getId();
        return Descuento.findDescuento(id);
    }

	public boolean modifyDescuento(Descuento obj) {
        return false;
    }

	public void init() {
        int from = 0;
        int to = 10;
        data = Descuento.findDescuentoEntries(from, to);
        if (data == null) {
            throw new IllegalStateException("Find entries implementation for 'Descuento' illegally returned null");
        }
        if (!data.isEmpty()) {
            return;
        }
        
        data = new ArrayList<Descuento>();
        for (int i = 0; i < 10; i++) {
            Descuento obj = getNewTransientDescuento(i);
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
