package com.raze.cancha.domain;
import com.raze.cancha.catalog.FechaVencimientoTCDataOnDemand;
import com.raze.cancha.catalog.TipoTarjetaDataOnDemand;
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
@RooDataOnDemand(entity = ControlPago.class)
public class ControlPagoDataOnDemand {

	private Random rnd = new SecureRandom();

	private List<ControlPago> data;

	@Autowired
    EmpresaDataOnDemand empresaDataOnDemand;

	@Autowired
    FechaVencimientoTCDataOnDemand fechaVencimientoTCDataOnDemand;

	@Autowired
    TipoTarjetaDataOnDemand tipoTarjetaDataOnDemand;

	@Autowired
    UsuarioDataOnDemand usuarioDataOnDemand;

	public ControlPago getNewTransientControlPago(int index) {
        ControlPago obj = new ControlPago();
        setCodigoSeguridad(obj, index);
        setCuenta(obj, index);
        setEmpresa(obj, index);
        setFechaCreacion(obj, index);
        setFechaModificacion(obj, index);
        setNoReferencia(obj, index);
        setNoTC(obj, index);
        setTarifa(obj, index);
        return obj;
    }

	public void setCodigoSeguridad(ControlPago obj, int index) {
        int codigoSeguridad = index;
        obj.setCodigoSeguridad(codigoSeguridad);
    }

	public void setCuenta(ControlPago obj, int index) {
        int cuenta = index;
        obj.setCuenta(cuenta);
    }

	public void setEmpresa(ControlPago obj, int index) {
        Empresa empresa = empresaDataOnDemand.getRandomEmpresa();
        obj.setEmpresa(empresa);
    }

	public void setFechaCreacion(ControlPago obj, int index) {
        Date fechaCreacion = new GregorianCalendar(Calendar.getInstance().get(Calendar.YEAR), Calendar.getInstance().get(Calendar.MONTH), Calendar.getInstance().get(Calendar.DAY_OF_MONTH), Calendar.getInstance().get(Calendar.HOUR_OF_DAY), Calendar.getInstance().get(Calendar.MINUTE), Calendar.getInstance().get(Calendar.SECOND) + new Double(Math.random() * 1000).intValue()).getTime();
        obj.setFechaCreacion(fechaCreacion);
    }

	public void setFechaModificacion(ControlPago obj, int index) {
        Date fechaModificacion = new GregorianCalendar(Calendar.getInstance().get(Calendar.YEAR), Calendar.getInstance().get(Calendar.MONTH), Calendar.getInstance().get(Calendar.DAY_OF_MONTH), Calendar.getInstance().get(Calendar.HOUR_OF_DAY), Calendar.getInstance().get(Calendar.MINUTE), Calendar.getInstance().get(Calendar.SECOND) + new Double(Math.random() * 1000).intValue()).getTime();
        obj.setFechaModificacion(fechaModificacion);
    }

	public void setNoReferencia(ControlPago obj, int index) {
        int noReferencia = index;
        obj.setNoReferencia(noReferencia);
    }

	public void setNoTC(ControlPago obj, int index) {
        int noTC = index;
        obj.setNoTC(noTC);
    }

	public void setTarifa(ControlPago obj, int index) {
        double tarifa = new Integer(index).doubleValue();
        obj.setTarifa(tarifa);
    }

	public ControlPago getSpecificControlPago(int index) {
        init();
        if (index < 0) {
            index = 0;
        }
        if (index > (data.size() - 1)) {
            index = data.size() - 1;
        }
        ControlPago obj = data.get(index);
        Long id = obj.getId();
        return ControlPago.findControlPago(id);
    }

	public ControlPago getRandomControlPago() {
        init();
        ControlPago obj = data.get(rnd.nextInt(data.size()));
        Long id = obj.getId();
        return ControlPago.findControlPago(id);
    }

	public boolean modifyControlPago(ControlPago obj) {
        return false;
    }

	public void init() {
        int from = 0;
        int to = 10;
        data = ControlPago.findControlPagoEntries(from, to);
        if (data == null) {
            throw new IllegalStateException("Find entries implementation for 'ControlPago' illegally returned null");
        }
        if (!data.isEmpty()) {
            return;
        }
        
        data = new ArrayList<ControlPago>();
        for (int i = 0; i < 10; i++) {
            ControlPago obj = getNewTransientControlPago(i);
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
