package com.raze.cancha.domain;
import com.raze.cancha.catalog.Rol;
import com.raze.cancha.catalog.RolDataOnDemand;
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
@RooDataOnDemand(entity = Usuario.class)
public class UsuarioDataOnDemand {

	private Random rnd = new SecureRandom();

	private List<Usuario> data;

	@Autowired
    EmpresaDataOnDemand empresaDataOnDemand;

	@Autowired
    RolDataOnDemand rolDataOnDemand;

	public Usuario getNewTransientUsuario(int index) {
        Usuario obj = new Usuario();
        setActivo(obj, index);
        setApellidoMaterno(obj, index);
        setApellidoPaterno(obj, index);
        setCelular(obj, index);
        setCorreoE(obj, index);
        setDomicilio(obj, index);
        setEmpresa(obj, index);
        setFechaCreacion(obj, index);
        setFechaModificacion(obj, index);
        setFechaNacimiento(obj, index);
        setNombre(obj, index);
        setNumeroIntentos(obj, index);
        setPassword(obj, index);
        setRol(obj, index);
        setTelefono(obj, index);
        setUsuario(obj, index);
        return obj;
    }

	public void setActivo(Usuario obj, int index) {
        Boolean activo = Boolean.TRUE;
        obj.setActivo(activo);
    }

	public void setApellidoMaterno(Usuario obj, int index) {
        String apellidoMaterno = "apellidoMaterno_" + index;
        obj.setApellidoMaterno(apellidoMaterno);
    }

	public void setApellidoPaterno(Usuario obj, int index) {
        String apellidoPaterno = "apellidoPaterno_" + index;
        obj.setApellidoPaterno(apellidoPaterno);
    }

	public void setCelular(Usuario obj, int index) {
        String celular = "celular_" + index;
        obj.setCelular(celular);
    }

	public void setCorreoE(Usuario obj, int index) {
        String correoE = "correoE_" + index;
        obj.setCorreoE(correoE);
    }

	public void setDomicilio(Usuario obj, int index) {
        String domicilio = "domicilio_" + index;
        obj.setDomicilio(domicilio);
    }

	public void setEmpresa(Usuario obj, int index) {
        Empresa empresa = empresaDataOnDemand.getRandomEmpresa();
        obj.setEmpresa(empresa);
    }

	public void setFechaCreacion(Usuario obj, int index) {
        Date fechaCreacion = new GregorianCalendar(Calendar.getInstance().get(Calendar.YEAR), Calendar.getInstance().get(Calendar.MONTH), Calendar.getInstance().get(Calendar.DAY_OF_MONTH), Calendar.getInstance().get(Calendar.HOUR_OF_DAY), Calendar.getInstance().get(Calendar.MINUTE), Calendar.getInstance().get(Calendar.SECOND) + new Double(Math.random() * 1000).intValue()).getTime();
        obj.setFechaCreacion(fechaCreacion);
    }

	public void setFechaModificacion(Usuario obj, int index) {
        Date fechaModificacion = new GregorianCalendar(Calendar.getInstance().get(Calendar.YEAR), Calendar.getInstance().get(Calendar.MONTH), Calendar.getInstance().get(Calendar.DAY_OF_MONTH), Calendar.getInstance().get(Calendar.HOUR_OF_DAY), Calendar.getInstance().get(Calendar.MINUTE), Calendar.getInstance().get(Calendar.SECOND) + new Double(Math.random() * 1000).intValue()).getTime();
        obj.setFechaModificacion(fechaModificacion);
    }

	public void setFechaNacimiento(Usuario obj, int index) {
        Date fechaNacimiento = new GregorianCalendar(Calendar.getInstance().get(Calendar.YEAR), Calendar.getInstance().get(Calendar.MONTH), Calendar.getInstance().get(Calendar.DAY_OF_MONTH), Calendar.getInstance().get(Calendar.HOUR_OF_DAY), Calendar.getInstance().get(Calendar.MINUTE), Calendar.getInstance().get(Calendar.SECOND) + new Double(Math.random() * 1000).intValue()).getTime();
        obj.setFechaNacimiento(fechaNacimiento);
    }

	public void setNombre(Usuario obj, int index) {
        String nombre = "nombre_" + index;
        obj.setNombre(nombre);
    }

	public void setNumeroIntentos(Usuario obj, int index) {
        int numeroIntentos = index;
        obj.setNumeroIntentos(numeroIntentos);
    }

	public void setPassword(Usuario obj, int index) {
        String password = "password_" + index;
        obj.setPassword(password);
    }

	public void setRol(Usuario obj, int index) {
        Rol rol = rolDataOnDemand.getRandomRol();
        obj.setRol(rol);
    }

	public void setTelefono(Usuario obj, int index) {
        String telefono = "telefono_" + index;
        obj.setTelefono(telefono);
    }

	public void setUsuario(Usuario obj, int index) {
        Usuario usuario = obj;
        obj.setUsuario(usuario);
    }

	public Usuario getSpecificUsuario(int index) {
        init();
        if (index < 0) {
            index = 0;
        }
        if (index > (data.size() - 1)) {
            index = data.size() - 1;
        }
        Usuario obj = data.get(index);
        Long id = obj.getId();
        return Usuario.findUsuario(id);
    }

	public Usuario getRandomUsuario() {
        init();
        Usuario obj = data.get(rnd.nextInt(data.size()));
        Long id = obj.getId();
        return Usuario.findUsuario(id);
    }

	public boolean modifyUsuario(Usuario obj) {
        return false;
    }

	public void init() {
        int from = 0;
        int to = 10;
        data = Usuario.findUsuarioEntries(from, to);
        if (data == null) {
            throw new IllegalStateException("Find entries implementation for 'Usuario' illegally returned null");
        }
        if (!data.isEmpty()) {
            return;
        }
        
        data = new ArrayList<Usuario>();
        for (int i = 0; i < 10; i++) {
            Usuario obj = getNewTransientUsuario(i);
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
