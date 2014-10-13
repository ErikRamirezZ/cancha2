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

@Configurable
@Component
@RooDataOnDemand(entity = PagoHecho.class)
public class PagoHechoDataOnDemand {

	private Random rnd = new SecureRandom();

	private List<PagoHecho> data;

	@Autowired
    ControlPagoDataOnDemand controlPagoDataOnDemand;

	@Autowired
    UsuarioDataOnDemand usuarioDataOnDemand;

	public PagoHecho getNewTransientPagoHecho(int index) {
        PagoHecho obj = new PagoHecho();
        setControlPago(obj, index);
        setDescuento(obj, index);
        setFechaCreacion(obj, index);
        setFechaModificacion(obj, index);
        setFechaPago(obj, index);
        setFechaVencimiento(obj, index);
        setMonto(obj, index);
        return obj;
    }

	public void setControlPago(PagoHecho obj, int index) {
        ControlPago controlPago = controlPagoDataOnDemand.getRandomControlPago();
        obj.setControlPago(controlPago);
    }

	public void setDescuento(PagoHecho obj, int index) {
        int descuento = index;
        obj.setDescuento(descuento);
    }

	public void setFechaCreacion(PagoHecho obj, int index) {
        Date fechaCreacion = new GregorianCalendar(Calendar.getInstance().get(Calendar.YEAR), Calendar.getInstance().get(Calendar.MONTH), Calendar.getInstance().get(Calendar.DAY_OF_MONTH), Calendar.getInstance().get(Calendar.HOUR_OF_DAY), Calendar.getInstance().get(Calendar.MINUTE), Calendar.getInstance().get(Calendar.SECOND) + new Double(Math.random() * 1000).intValue()).getTime();
        obj.setFechaCreacion(fechaCreacion);
    }

	public void setFechaModificacion(PagoHecho obj, int index) {
        Date fechaModificacion = new GregorianCalendar(Calendar.getInstance().get(Calendar.YEAR), Calendar.getInstance().get(Calendar.MONTH), Calendar.getInstance().get(Calendar.DAY_OF_MONTH), Calendar.getInstance().get(Calendar.HOUR_OF_DAY), Calendar.getInstance().get(Calendar.MINUTE), Calendar.getInstance().get(Calendar.SECOND) + new Double(Math.random() * 1000).intValue()).getTime();
        obj.setFechaModificacion(fechaModificacion);
    }

	public void setFechaPago(PagoHecho obj, int index) {
        Date fechaPago = new GregorianCalendar(Calendar.getInstance().get(Calendar.YEAR), Calendar.getInstance().get(Calendar.MONTH), Calendar.getInstance().get(Calendar.DAY_OF_MONTH), Calendar.getInstance().get(Calendar.HOUR_OF_DAY), Calendar.getInstance().get(Calendar.MINUTE), Calendar.getInstance().get(Calendar.SECOND) + new Double(Math.random() * 1000).intValue()).getTime();
        obj.setFechaPago(fechaPago);
    }

	public void setFechaVencimiento(PagoHecho obj, int index) {
        Date fechaVencimiento = new GregorianCalendar(Calendar.getInstance().get(Calendar.YEAR), Calendar.getInstance().get(Calendar.MONTH), Calendar.getInstance().get(Calendar.DAY_OF_MONTH), Calendar.getInstance().get(Calendar.HOUR_OF_DAY), Calendar.getInstance().get(Calendar.MINUTE), Calendar.getInstance().get(Calendar.SECOND) + new Double(Math.random() * 1000).intValue()).getTime();
        obj.setFechaVencimiento(fechaVencimiento);
    }

	public void setMonto(PagoHecho obj, int index) {
        double monto = new Integer(index).doubleValue();
        obj.setMonto(monto);
    }

	public PagoHecho getSpecificPagoHecho(int index) {
        init();
        if (index < 0) {
            index = 0;
        }
        if (index > (data.size() - 1)) {
            index = data.size() - 1;
        }
        PagoHecho obj = data.get(index);
        Long id = obj.getId();
        return PagoHecho.findPagoHecho(id);
    }

	public PagoHecho getRandomPagoHecho() {
        init();
        PagoHecho obj = data.get(rnd.nextInt(data.size()));
        Long id = obj.getId();
        return PagoHecho.findPagoHecho(id);
    }

	public boolean modifyPagoHecho(PagoHecho obj) {
        return false;
    }

	public void init() {
        int from = 0;
        int to = 10;
        data = PagoHecho.findPagoHechoEntries(from, to);
        if (data == null) {
            throw new IllegalStateException("Find entries implementation for 'PagoHecho' illegally returned null");
        }
        if (!data.isEmpty()) {
            return;
        }
        
        data = new ArrayList<PagoHecho>();
        for (int i = 0; i < 10; i++) {
            PagoHecho obj = getNewTransientPagoHecho(i);
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
