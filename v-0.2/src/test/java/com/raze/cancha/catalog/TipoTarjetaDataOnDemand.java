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
@RooDataOnDemand(entity = TipoTarjeta.class)
public class TipoTarjetaDataOnDemand {

	private Random rnd = new SecureRandom();

	private List<TipoTarjeta> data;

	@Autowired
    UsuarioDataOnDemand usuarioDataOnDemand;

	public TipoTarjeta getNewTransientTipoTarjeta(int index) {
        TipoTarjeta obj = new TipoTarjeta();
        setActivo(obj, index);
        setDescripcion(obj, index);
        setFechaCreacion(obj, index);
        setFechaModificacion(obj, index);
        setNombreTipoTarjeta(obj, index);
        return obj;
    }

	public void setActivo(TipoTarjeta obj, int index) {
        Boolean activo = Boolean.TRUE;
        obj.setActivo(activo);
    }

	public void setDescripcion(TipoTarjeta obj, int index) {
        String descripcion = "descripcion_" + index;
        obj.setDescripcion(descripcion);
    }

	public void setFechaCreacion(TipoTarjeta obj, int index) {
        Date fechaCreacion = new GregorianCalendar(Calendar.getInstance().get(Calendar.YEAR), Calendar.getInstance().get(Calendar.MONTH), Calendar.getInstance().get(Calendar.DAY_OF_MONTH), Calendar.getInstance().get(Calendar.HOUR_OF_DAY), Calendar.getInstance().get(Calendar.MINUTE), Calendar.getInstance().get(Calendar.SECOND) + new Double(Math.random() * 1000).intValue()).getTime();
        obj.setFechaCreacion(fechaCreacion);
    }

	public void setFechaModificacion(TipoTarjeta obj, int index) {
        Date fechaModificacion = new GregorianCalendar(Calendar.getInstance().get(Calendar.YEAR), Calendar.getInstance().get(Calendar.MONTH), Calendar.getInstance().get(Calendar.DAY_OF_MONTH), Calendar.getInstance().get(Calendar.HOUR_OF_DAY), Calendar.getInstance().get(Calendar.MINUTE), Calendar.getInstance().get(Calendar.SECOND) + new Double(Math.random() * 1000).intValue()).getTime();
        obj.setFechaModificacion(fechaModificacion);
    }

	public void setNombreTipoTarjeta(TipoTarjeta obj, int index) {
        String nombreTipoTarjeta = "nombreTipoTarjeta_" + index;
        obj.setNombreTipoTarjeta(nombreTipoTarjeta);
    }

	public TipoTarjeta getSpecificTipoTarjeta(int index) {
        init();
        if (index < 0) {
            index = 0;
        }
        if (index > (data.size() - 1)) {
            index = data.size() - 1;
        }
        TipoTarjeta obj = data.get(index);
        Long id = obj.getId();
        return TipoTarjeta.findTipoTarjeta(id);
    }

	public TipoTarjeta getRandomTipoTarjeta() {
        init();
        TipoTarjeta obj = data.get(rnd.nextInt(data.size()));
        Long id = obj.getId();
        return TipoTarjeta.findTipoTarjeta(id);
    }

	public boolean modifyTipoTarjeta(TipoTarjeta obj) {
        return false;
    }

	public void init() {
        int from = 0;
        int to = 10;
        data = TipoTarjeta.findTipoTarjetaEntries(from, to);
        if (data == null) {
            throw new IllegalStateException("Find entries implementation for 'TipoTarjeta' illegally returned null");
        }
        if (!data.isEmpty()) {
            return;
        }
        
        data = new ArrayList<TipoTarjeta>();
        for (int i = 0; i < 10; i++) {
            TipoTarjeta obj = getNewTransientTipoTarjeta(i);
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
