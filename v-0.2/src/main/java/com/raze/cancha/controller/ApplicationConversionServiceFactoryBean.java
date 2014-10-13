package com.raze.cancha.controller;

import com.raze.cancha.catalog.Accion;
import com.raze.cancha.catalog.ConceptoCobro;
import com.raze.cancha.catalog.Descuento;
import com.raze.cancha.catalog.DiasJuego;
import com.raze.cancha.catalog.FechaVencimientoTC;
import com.raze.cancha.catalog.MetodoPago;
import com.raze.cancha.catalog.Posicion;
import com.raze.cancha.catalog.Rol;
import com.raze.cancha.catalog.StatusCargoAbono;
import com.raze.cancha.catalog.StatusCedula;
import com.raze.cancha.catalog.StatusEquipoJugador;
import com.raze.cancha.catalog.StatusPartido;
import com.raze.cancha.catalog.TipoCobro;
import com.raze.cancha.catalog.TipoPartido;
import com.raze.cancha.catalog.TipoTarjeta;
import com.raze.cancha.domain.Abono;
import com.raze.cancha.domain.Alineacion;
import com.raze.cancha.domain.Cancha;
import com.raze.cancha.domain.Cargo;
import com.raze.cancha.domain.CedulaPartido;
import com.raze.cancha.domain.ConfiguracionTorneo;
import com.raze.cancha.domain.ControlPago;
import com.raze.cancha.domain.Empresa;
import com.raze.cancha.domain.Equipo;
import com.raze.cancha.domain.Estadisticas;
import com.raze.cancha.domain.Horario;
import com.raze.cancha.domain.Jugador;
import com.raze.cancha.domain.PagoHecho;
import com.raze.cancha.domain.Partido;
import com.raze.cancha.domain.Sucursal;
import com.raze.cancha.domain.Torneo;
import com.raze.cancha.domain.TorneoEquipo;
import com.raze.cancha.domain.Usuario;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.core.convert.converter.Converter;
import org.springframework.format.FormatterRegistry;
import org.springframework.format.support.FormattingConversionServiceFactoryBean;
import org.springframework.roo.addon.web.mvc.controller.converter.RooConversionService;

@Configurable
/**
 * A central place to register application converters and formatters. 
 */
@RooConversionService
public class ApplicationConversionServiceFactoryBean extends FormattingConversionServiceFactoryBean {

	@Override
	protected void installFormatters(FormatterRegistry registry) {
		super.installFormatters(registry);
		// Register application converters and formatters
	}

	public Converter<Accion, String> getAccionToStringConverter() {
        return new org.springframework.core.convert.converter.Converter<com.raze.cancha.catalog.Accion, java.lang.String>() {
            public String convert(Accion accion) {
                return new StringBuilder().append(accion.getNombreAccion()).append(' ').append(accion.getDescripcion()).append(' ').append(accion.getFechaCreacion()).append(' ').append(accion.getFechaModificacion()).toString();
            }
        };
    }

	public Converter<Long, Accion> getIdToAccionConverter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.Long, com.raze.cancha.catalog.Accion>() {
            public com.raze.cancha.catalog.Accion convert(java.lang.Long id) {
                return Accion.findAccion(id);
            }
        };
    }

	public Converter<String, Accion> getStringToAccionConverter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.String, com.raze.cancha.catalog.Accion>() {
            public com.raze.cancha.catalog.Accion convert(String id) {
                return getObject().convert(getObject().convert(id, Long.class), Accion.class);
            }
        };
    }

	public Converter<ConceptoCobro, String> getConceptoCobroToStringConverter() {
        return new org.springframework.core.convert.converter.Converter<com.raze.cancha.catalog.ConceptoCobro, java.lang.String>() {
            public String convert(ConceptoCobro conceptoCobro) {
                return new StringBuilder().append(conceptoCobro.getNombreConceptoCobro()).append(' ').append(conceptoCobro.getDescripcion()).append(' ').append(conceptoCobro.getFechaCreacion()).append(' ').append(conceptoCobro.getFechaModificacion()).toString();
            }
        };
    }

	public Converter<Long, ConceptoCobro> getIdToConceptoCobroConverter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.Long, com.raze.cancha.catalog.ConceptoCobro>() {
            public com.raze.cancha.catalog.ConceptoCobro convert(java.lang.Long id) {
                return ConceptoCobro.findConceptoCobro(id);
            }
        };
    }

	public Converter<String, ConceptoCobro> getStringToConceptoCobroConverter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.String, com.raze.cancha.catalog.ConceptoCobro>() {
            public com.raze.cancha.catalog.ConceptoCobro convert(String id) {
                return getObject().convert(getObject().convert(id, Long.class), ConceptoCobro.class);
            }
        };
    }

	public Converter<Descuento, String> getDescuentoToStringConverter() {
        return new org.springframework.core.convert.converter.Converter<com.raze.cancha.catalog.Descuento, java.lang.String>() {
            public String convert(Descuento descuento) {
                return new StringBuilder().append(descuento.getNombreDescuento()).append(' ').append(descuento.getDescripcion()).append(' ').append(descuento.getFechaCreacion()).append(' ').append(descuento.getFechaModificacion()).toString();
            }
        };
    }

	public Converter<Long, Descuento> getIdToDescuentoConverter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.Long, com.raze.cancha.catalog.Descuento>() {
            public com.raze.cancha.catalog.Descuento convert(java.lang.Long id) {
                return Descuento.findDescuento(id);
            }
        };
    }

	public Converter<String, Descuento> getStringToDescuentoConverter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.String, com.raze.cancha.catalog.Descuento>() {
            public com.raze.cancha.catalog.Descuento convert(String id) {
                return getObject().convert(getObject().convert(id, Long.class), Descuento.class);
            }
        };
    }

	public Converter<DiasJuego, String> getDiasJuegoToStringConverter() {
        return new org.springframework.core.convert.converter.Converter<com.raze.cancha.catalog.DiasJuego, java.lang.String>() {
            public String convert(DiasJuego diasJuego) {
                return new StringBuilder().append(diasJuego.getNombreDiasJuego()).append(' ').append(diasJuego.getDescripcion()).append(' ').append(diasJuego.getFechaCreacion()).append(' ').append(diasJuego.getFechaModificacion()).toString();
            }
        };
    }

	public Converter<Long, DiasJuego> getIdToDiasJuegoConverter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.Long, com.raze.cancha.catalog.DiasJuego>() {
            public com.raze.cancha.catalog.DiasJuego convert(java.lang.Long id) {
                return DiasJuego.findDiasJuego(id);
            }
        };
    }

	public Converter<String, DiasJuego> getStringToDiasJuegoConverter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.String, com.raze.cancha.catalog.DiasJuego>() {
            public com.raze.cancha.catalog.DiasJuego convert(String id) {
                return getObject().convert(getObject().convert(id, Long.class), DiasJuego.class);
            }
        };
    }

	public Converter<FechaVencimientoTC, String> getFechaVencimientoTCToStringConverter() {
        return new org.springframework.core.convert.converter.Converter<com.raze.cancha.catalog.FechaVencimientoTC, java.lang.String>() {
            public String convert(FechaVencimientoTC fechaVencimientoTC) {
                return new StringBuilder().append(fechaVencimientoTC.getNombreFechaVencimientoTC()).append(' ').append(fechaVencimientoTC.getDescripcion()).append(' ').append(fechaVencimientoTC.getMes()).append(' ').append(fechaVencimientoTC.getAnio()).toString();
            }
        };
    }

	public Converter<Long, FechaVencimientoTC> getIdToFechaVencimientoTCConverter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.Long, com.raze.cancha.catalog.FechaVencimientoTC>() {
            public com.raze.cancha.catalog.FechaVencimientoTC convert(java.lang.Long id) {
                return FechaVencimientoTC.findFechaVencimientoTC(id);
            }
        };
    }

	public Converter<String, FechaVencimientoTC> getStringToFechaVencimientoTCConverter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.String, com.raze.cancha.catalog.FechaVencimientoTC>() {
            public com.raze.cancha.catalog.FechaVencimientoTC convert(String id) {
                return getObject().convert(getObject().convert(id, Long.class), FechaVencimientoTC.class);
            }
        };
    }

	public Converter<MetodoPago, String> getMetodoPagoToStringConverter() {
        return new org.springframework.core.convert.converter.Converter<com.raze.cancha.catalog.MetodoPago, java.lang.String>() {
            public String convert(MetodoPago metodoPago) {
                return new StringBuilder().append(metodoPago.getNombreMetodoPago()).append(' ').append(metodoPago.getDescripcion()).append(' ').append(metodoPago.getFechaCreacion()).append(' ').append(metodoPago.getFechaModificacion()).toString();
            }
        };
    }

	public Converter<Long, MetodoPago> getIdToMetodoPagoConverter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.Long, com.raze.cancha.catalog.MetodoPago>() {
            public com.raze.cancha.catalog.MetodoPago convert(java.lang.Long id) {
                return MetodoPago.findMetodoPago(id);
            }
        };
    }

	public Converter<String, MetodoPago> getStringToMetodoPagoConverter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.String, com.raze.cancha.catalog.MetodoPago>() {
            public com.raze.cancha.catalog.MetodoPago convert(String id) {
                return getObject().convert(getObject().convert(id, Long.class), MetodoPago.class);
            }
        };
    }

	public Converter<Posicion, String> getPosicionToStringConverter() {
        return new org.springframework.core.convert.converter.Converter<com.raze.cancha.catalog.Posicion, java.lang.String>() {
            public String convert(Posicion posicion) {
                return new StringBuilder().append(posicion.getNombrePosicion()).append(' ').append(posicion.getDescripcion()).append(' ').append(posicion.getFechaCreacion()).append(' ').append(posicion.getFechaModificacion()).toString();
            }
        };
    }

	public Converter<Long, Posicion> getIdToPosicionConverter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.Long, com.raze.cancha.catalog.Posicion>() {
            public com.raze.cancha.catalog.Posicion convert(java.lang.Long id) {
                return Posicion.findPosicion(id);
            }
        };
    }

	public Converter<String, Posicion> getStringToPosicionConverter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.String, com.raze.cancha.catalog.Posicion>() {
            public com.raze.cancha.catalog.Posicion convert(String id) {
                return getObject().convert(getObject().convert(id, Long.class), Posicion.class);
            }
        };
    }

	public Converter<Rol, String> getRolToStringConverter() {
        return new org.springframework.core.convert.converter.Converter<com.raze.cancha.catalog.Rol, java.lang.String>() {
            public String convert(Rol rol) {
                return new StringBuilder().append(rol.getNombreRol()).append(' ').append(rol.getDescripcion()).append(' ').append(rol.getFechaCreacion()).append(' ').append(rol.getFechaModificacion()).toString();
            }
        };
    }

	public Converter<Long, Rol> getIdToRolConverter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.Long, com.raze.cancha.catalog.Rol>() {
            public com.raze.cancha.catalog.Rol convert(java.lang.Long id) {
                return Rol.findRol(id);
            }
        };
    }

	public Converter<String, Rol> getStringToRolConverter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.String, com.raze.cancha.catalog.Rol>() {
            public com.raze.cancha.catalog.Rol convert(String id) {
                return getObject().convert(getObject().convert(id, Long.class), Rol.class);
            }
        };
    }

	public Converter<StatusCargoAbono, String> getStatusCargoAbonoToStringConverter() {
        return new org.springframework.core.convert.converter.Converter<com.raze.cancha.catalog.StatusCargoAbono, java.lang.String>() {
            public String convert(StatusCargoAbono statusCargoAbono) {
                return new StringBuilder().append(statusCargoAbono.getNombreStatusCargoAbono()).append(' ').append(statusCargoAbono.getDescripcion()).append(' ').append(statusCargoAbono.getFechaCreacion()).append(' ').append(statusCargoAbono.getFechaModificacion()).toString();
            }
        };
    }

	public Converter<Long, StatusCargoAbono> getIdToStatusCargoAbonoConverter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.Long, com.raze.cancha.catalog.StatusCargoAbono>() {
            public com.raze.cancha.catalog.StatusCargoAbono convert(java.lang.Long id) {
                return StatusCargoAbono.findStatusCargoAbono(id);
            }
        };
    }

	public Converter<String, StatusCargoAbono> getStringToStatusCargoAbonoConverter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.String, com.raze.cancha.catalog.StatusCargoAbono>() {
            public com.raze.cancha.catalog.StatusCargoAbono convert(String id) {
                return getObject().convert(getObject().convert(id, Long.class), StatusCargoAbono.class);
            }
        };
    }

	public Converter<StatusCedula, String> getStatusCedulaToStringConverter() {
        return new org.springframework.core.convert.converter.Converter<com.raze.cancha.catalog.StatusCedula, java.lang.String>() {
            public String convert(StatusCedula statusCedula) {
                return new StringBuilder().append(statusCedula.getNombreStatusCedula()).append(' ').append(statusCedula.getDescripcion()).append(' ').append(statusCedula.getFechaCreacion()).append(' ').append(statusCedula.getFechaModificacion()).toString();
            }
        };
    }

	public Converter<Long, StatusCedula> getIdToStatusCedulaConverter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.Long, com.raze.cancha.catalog.StatusCedula>() {
            public com.raze.cancha.catalog.StatusCedula convert(java.lang.Long id) {
                return StatusCedula.findStatusCedula(id);
            }
        };
    }

	public Converter<String, StatusCedula> getStringToStatusCedulaConverter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.String, com.raze.cancha.catalog.StatusCedula>() {
            public com.raze.cancha.catalog.StatusCedula convert(String id) {
                return getObject().convert(getObject().convert(id, Long.class), StatusCedula.class);
            }
        };
    }

	public Converter<StatusEquipoJugador, String> getStatusEquipoJugadorToStringConverter() {
        return new org.springframework.core.convert.converter.Converter<com.raze.cancha.catalog.StatusEquipoJugador, java.lang.String>() {
            public String convert(StatusEquipoJugador statusEquipoJugador) {
                return new StringBuilder().append(statusEquipoJugador.getNombreStatusEquipoJugador()).append(' ').append(statusEquipoJugador.getDescripcion()).append(' ').append(statusEquipoJugador.getFechaCreacion()).append(' ').append(statusEquipoJugador.getFechaModificacion()).toString();
            }
        };
    }

	public Converter<Long, StatusEquipoJugador> getIdToStatusEquipoJugadorConverter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.Long, com.raze.cancha.catalog.StatusEquipoJugador>() {
            public com.raze.cancha.catalog.StatusEquipoJugador convert(java.lang.Long id) {
                return StatusEquipoJugador.findStatusEquipoJugador(id);
            }
        };
    }

	public Converter<String, StatusEquipoJugador> getStringToStatusEquipoJugadorConverter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.String, com.raze.cancha.catalog.StatusEquipoJugador>() {
            public com.raze.cancha.catalog.StatusEquipoJugador convert(String id) {
                return getObject().convert(getObject().convert(id, Long.class), StatusEquipoJugador.class);
            }
        };
    }

	public Converter<StatusPartido, String> getStatusPartidoToStringConverter() {
        return new org.springframework.core.convert.converter.Converter<com.raze.cancha.catalog.StatusPartido, java.lang.String>() {
            public String convert(StatusPartido statusPartido) {
                return new StringBuilder().append(statusPartido.getNombreStatusPartido()).append(' ').append(statusPartido.getDescripcion()).append(' ').append(statusPartido.getFechaCreacion()).append(' ').append(statusPartido.getFechaModificacion()).toString();
            }
        };
    }

	public Converter<Long, StatusPartido> getIdToStatusPartidoConverter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.Long, com.raze.cancha.catalog.StatusPartido>() {
            public com.raze.cancha.catalog.StatusPartido convert(java.lang.Long id) {
                return StatusPartido.findStatusPartido(id);
            }
        };
    }

	public Converter<String, StatusPartido> getStringToStatusPartidoConverter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.String, com.raze.cancha.catalog.StatusPartido>() {
            public com.raze.cancha.catalog.StatusPartido convert(String id) {
                return getObject().convert(getObject().convert(id, Long.class), StatusPartido.class);
            }
        };
    }

	public Converter<TipoCobro, String> getTipoCobroToStringConverter() {
        return new org.springframework.core.convert.converter.Converter<com.raze.cancha.catalog.TipoCobro, java.lang.String>() {
            public String convert(TipoCobro tipoCobro) {
                return new StringBuilder().append(tipoCobro.getNombreTipoCobro()).append(' ').append(tipoCobro.getDescripcion()).append(' ').append(tipoCobro.getFechaCreacion()).append(' ').append(tipoCobro.getFechaModificacion()).toString();
            }
        };
    }

	public Converter<Long, TipoCobro> getIdToTipoCobroConverter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.Long, com.raze.cancha.catalog.TipoCobro>() {
            public com.raze.cancha.catalog.TipoCobro convert(java.lang.Long id) {
                return TipoCobro.findTipoCobro(id);
            }
        };
    }

	public Converter<String, TipoCobro> getStringToTipoCobroConverter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.String, com.raze.cancha.catalog.TipoCobro>() {
            public com.raze.cancha.catalog.TipoCobro convert(String id) {
                return getObject().convert(getObject().convert(id, Long.class), TipoCobro.class);
            }
        };
    }

	public Converter<TipoPartido, String> getTipoPartidoToStringConverter() {
        return new org.springframework.core.convert.converter.Converter<com.raze.cancha.catalog.TipoPartido, java.lang.String>() {
            public String convert(TipoPartido tipoPartido) {
                return new StringBuilder().append(tipoPartido.getNombreTipoPartido()).append(' ').append(tipoPartido.getDescripcion()).append(' ').append(tipoPartido.getFechaCreacion()).append(' ').append(tipoPartido.getFechaModificacion()).toString();
            }
        };
    }

	public Converter<Long, TipoPartido> getIdToTipoPartidoConverter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.Long, com.raze.cancha.catalog.TipoPartido>() {
            public com.raze.cancha.catalog.TipoPartido convert(java.lang.Long id) {
                return TipoPartido.findTipoPartido(id);
            }
        };
    }

	public Converter<String, TipoPartido> getStringToTipoPartidoConverter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.String, com.raze.cancha.catalog.TipoPartido>() {
            public com.raze.cancha.catalog.TipoPartido convert(String id) {
                return getObject().convert(getObject().convert(id, Long.class), TipoPartido.class);
            }
        };
    }

	public Converter<TipoTarjeta, String> getTipoTarjetaToStringConverter() {
        return new org.springframework.core.convert.converter.Converter<com.raze.cancha.catalog.TipoTarjeta, java.lang.String>() {
            public String convert(TipoTarjeta tipoTarjeta) {
                return new StringBuilder().append(tipoTarjeta.getNombreTipoTarjeta()).append(' ').append(tipoTarjeta.getDescripcion()).append(' ').append(tipoTarjeta.getFechaCreacion()).append(' ').append(tipoTarjeta.getFechaModificacion()).toString();
            }
        };
    }

	public Converter<Long, TipoTarjeta> getIdToTipoTarjetaConverter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.Long, com.raze.cancha.catalog.TipoTarjeta>() {
            public com.raze.cancha.catalog.TipoTarjeta convert(java.lang.Long id) {
                return TipoTarjeta.findTipoTarjeta(id);
            }
        };
    }

	public Converter<String, TipoTarjeta> getStringToTipoTarjetaConverter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.String, com.raze.cancha.catalog.TipoTarjeta>() {
            public com.raze.cancha.catalog.TipoTarjeta convert(String id) {
                return getObject().convert(getObject().convert(id, Long.class), TipoTarjeta.class);
            }
        };
    }

	public Converter<Abono, String> getAbonoToStringConverter() {
        return new org.springframework.core.convert.converter.Converter<com.raze.cancha.domain.Abono, java.lang.String>() {
            public String convert(Abono abono) {
                return new StringBuilder().append(abono.getObservaciones()).append(' ').append(abono.getFechaCreacion()).append(' ').append(abono.getFechaModificacion()).toString();
            }
        };
    }

	public Converter<Long, Abono> getIdToAbonoConverter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.Long, com.raze.cancha.domain.Abono>() {
            public com.raze.cancha.domain.Abono convert(java.lang.Long id) {
                return Abono.findAbono(id);
            }
        };
    }

	public Converter<String, Abono> getStringToAbonoConverter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.String, com.raze.cancha.domain.Abono>() {
            public com.raze.cancha.domain.Abono convert(String id) {
                return getObject().convert(getObject().convert(id, Long.class), Abono.class);
            }
        };
    }

	public Converter<Alineacion, String> getAlineacionToStringConverter() {
        return new org.springframework.core.convert.converter.Converter<com.raze.cancha.domain.Alineacion, java.lang.String>() {
            public String convert(Alineacion alineacion) {
                return new StringBuilder().append(alineacion.getFechaCreacion()).append(' ').append(alineacion.getFechaModificacion()).toString();
            }
        };
    }

	public Converter<Long, Alineacion> getIdToAlineacionConverter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.Long, com.raze.cancha.domain.Alineacion>() {
            public com.raze.cancha.domain.Alineacion convert(java.lang.Long id) {
                return Alineacion.findAlineacion(id);
            }
        };
    }

	public Converter<String, Alineacion> getStringToAlineacionConverter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.String, com.raze.cancha.domain.Alineacion>() {
            public com.raze.cancha.domain.Alineacion convert(String id) {
                return getObject().convert(getObject().convert(id, Long.class), Alineacion.class);
            }
        };
    }

	public Converter<Cancha, String> getCanchaToStringConverter() {
        return new org.springframework.core.convert.converter.Converter<com.raze.cancha.domain.Cancha, java.lang.String>() {
            public String convert(Cancha cancha) {
                return new StringBuilder().append(cancha.getNombre()).append(' ').append(cancha.getDescripcion()).append(' ').append(cancha.getFechaCreacion()).append(' ').append(cancha.getFechaModificacion()).toString();
            }
        };
    }

	public Converter<Long, Cancha> getIdToCanchaConverter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.Long, com.raze.cancha.domain.Cancha>() {
            public com.raze.cancha.domain.Cancha convert(java.lang.Long id) {
                return Cancha.findCancha(id);
            }
        };
    }

	public Converter<String, Cancha> getStringToCanchaConverter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.String, com.raze.cancha.domain.Cancha>() {
            public com.raze.cancha.domain.Cancha convert(String id) {
                return getObject().convert(getObject().convert(id, Long.class), Cancha.class);
            }
        };
    }

	public Converter<Cargo, String> getCargoToStringConverter() {
        return new org.springframework.core.convert.converter.Converter<com.raze.cancha.domain.Cargo, java.lang.String>() {
            public String convert(Cargo cargo) {
                return new StringBuilder().append(cargo.getMonto()).append(' ').append(cargo.getObservaciones()).append(' ').append(cargo.getFechaCreacion()).append(' ').append(cargo.getFechaModificacion()).toString();
            }
        };
    }

	public Converter<Long, Cargo> getIdToCargoConverter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.Long, com.raze.cancha.domain.Cargo>() {
            public com.raze.cancha.domain.Cargo convert(java.lang.Long id) {
                return Cargo.findCargo(id);
            }
        };
    }

	public Converter<String, Cargo> getStringToCargoConverter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.String, com.raze.cancha.domain.Cargo>() {
            public com.raze.cancha.domain.Cargo convert(String id) {
                return getObject().convert(getObject().convert(id, Long.class), Cargo.class);
            }
        };
    }

	public Converter<CedulaPartido, String> getCedulaPartidoToStringConverter() {
        return new org.springframework.core.convert.converter.Converter<com.raze.cancha.domain.CedulaPartido, java.lang.String>() {
            public String convert(CedulaPartido cedulaPartido) {
                return new StringBuilder().append(cedulaPartido.getMarcadorEquipoLocal()).append(' ').append(cedulaPartido.getMarcadorEquipoVisitante()).append(' ').append(cedulaPartido.getObservaciones()).append(' ').append(cedulaPartido.getFechaCreacion()).toString();
            }
        };
    }

	public Converter<Long, CedulaPartido> getIdToCedulaPartidoConverter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.Long, com.raze.cancha.domain.CedulaPartido>() {
            public com.raze.cancha.domain.CedulaPartido convert(java.lang.Long id) {
                return CedulaPartido.findCedulaPartido(id);
            }
        };
    }

	public Converter<String, CedulaPartido> getStringToCedulaPartidoConverter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.String, com.raze.cancha.domain.CedulaPartido>() {
            public com.raze.cancha.domain.CedulaPartido convert(String id) {
                return getObject().convert(getObject().convert(id, Long.class), CedulaPartido.class);
            }
        };
    }

	public Converter<ConfiguracionTorneo, String> getConfiguracionTorneoToStringConverter() {
        return new org.springframework.core.convert.converter.Converter<com.raze.cancha.domain.ConfiguracionTorneo, java.lang.String>() {
            public String convert(ConfiguracionTorneo configuracionTorneo) {
                return new StringBuilder().append(configuracionTorneo.getCostoIncripcion()).append(' ').append(configuracionTorneo.getCosto()).append(' ').append(configuracionTorneo.getNumeroPagos()).append(' ').append(configuracionTorneo.getNumeroJugadoresXEquipo()).toString();
            }
        };
    }

	public Converter<Long, ConfiguracionTorneo> getIdToConfiguracionTorneoConverter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.Long, com.raze.cancha.domain.ConfiguracionTorneo>() {
            public com.raze.cancha.domain.ConfiguracionTorneo convert(java.lang.Long id) {
                return ConfiguracionTorneo.findConfiguracionTorneo(id);
            }
        };
    }

	public Converter<String, ConfiguracionTorneo> getStringToConfiguracionTorneoConverter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.String, com.raze.cancha.domain.ConfiguracionTorneo>() {
            public com.raze.cancha.domain.ConfiguracionTorneo convert(String id) {
                return getObject().convert(getObject().convert(id, Long.class), ConfiguracionTorneo.class);
            }
        };
    }

	public Converter<ControlPago, String> getControlPagoToStringConverter() {
        return new org.springframework.core.convert.converter.Converter<com.raze.cancha.domain.ControlPago, java.lang.String>() {
            public String convert(ControlPago controlPago) {
                return new StringBuilder().append(controlPago.getTarifa()).append(' ').append(controlPago.getCuenta()).append(' ').append(controlPago.getNoReferencia()).append(' ').append(controlPago.getNoTC()).toString();
            }
        };
    }

	public Converter<Long, ControlPago> getIdToControlPagoConverter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.Long, com.raze.cancha.domain.ControlPago>() {
            public com.raze.cancha.domain.ControlPago convert(java.lang.Long id) {
                return ControlPago.findControlPago(id);
            }
        };
    }

	public Converter<String, ControlPago> getStringToControlPagoConverter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.String, com.raze.cancha.domain.ControlPago>() {
            public com.raze.cancha.domain.ControlPago convert(String id) {
                return getObject().convert(getObject().convert(id, Long.class), ControlPago.class);
            }
        };
    }

	public Converter<Empresa, String> getEmpresaToStringConverter() {
        return new org.springframework.core.convert.converter.Converter<com.raze.cancha.domain.Empresa, java.lang.String>() {
            public String convert(Empresa empresa) {
                return new StringBuilder().append(empresa.getNombre()).append(' ').append(empresa.getNombreComercial()).append(' ').append(empresa.getDomicilio()).append(' ').append(empresa.getTelefono()).toString();
            }
        };
    }

	public Converter<Long, Empresa> getIdToEmpresaConverter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.Long, com.raze.cancha.domain.Empresa>() {
            public com.raze.cancha.domain.Empresa convert(java.lang.Long id) {
                return Empresa.findEmpresa(id);
            }
        };
    }

	public Converter<String, Empresa> getStringToEmpresaConverter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.String, com.raze.cancha.domain.Empresa>() {
            public com.raze.cancha.domain.Empresa convert(String id) {
                return getObject().convert(getObject().convert(id, Long.class), Empresa.class);
            }
        };
    }

	public Converter<Equipo, String> getEquipoToStringConverter() {
        return new org.springframework.core.convert.converter.Converter<com.raze.cancha.domain.Equipo, java.lang.String>() {
            public String convert(Equipo equipo) {
                return new StringBuilder().append(equipo.getNombre()).append(' ').append(equipo.getNombreCorto()).append(' ').append(equipo.getNombreLargo()).append(' ').append(equipo.getFechaCreacion()).toString();
            }
        };
    }

	public Converter<Long, Equipo> getIdToEquipoConverter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.Long, com.raze.cancha.domain.Equipo>() {
            public com.raze.cancha.domain.Equipo convert(java.lang.Long id) {
                return Equipo.findEquipo(id);
            }
        };
    }

	public Converter<String, Equipo> getStringToEquipoConverter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.String, com.raze.cancha.domain.Equipo>() {
            public com.raze.cancha.domain.Equipo convert(String id) {
                return getObject().convert(getObject().convert(id, Long.class), Equipo.class);
            }
        };
    }

	public Converter<Estadisticas, String> getEstadisticasToStringConverter() {
        return new org.springframework.core.convert.converter.Converter<com.raze.cancha.domain.Estadisticas, java.lang.String>() {
            public String convert(Estadisticas estadisticas) {
                return new StringBuilder().append(estadisticas.getMinuto()).append(' ').append(estadisticas.getFechaCreacion()).append(' ').append(estadisticas.getFechaModificacion()).toString();
            }
        };
    }

	public Converter<Long, Estadisticas> getIdToEstadisticasConverter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.Long, com.raze.cancha.domain.Estadisticas>() {
            public com.raze.cancha.domain.Estadisticas convert(java.lang.Long id) {
                return Estadisticas.findEstadisticas(id);
            }
        };
    }

	public Converter<String, Estadisticas> getStringToEstadisticasConverter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.String, com.raze.cancha.domain.Estadisticas>() {
            public com.raze.cancha.domain.Estadisticas convert(String id) {
                return getObject().convert(getObject().convert(id, Long.class), Estadisticas.class);
            }
        };
    }

	public Converter<Horario, String> getHorarioToStringConverter() {
        return new org.springframework.core.convert.converter.Converter<com.raze.cancha.domain.Horario, java.lang.String>() {
            public String convert(Horario horario) {
                return new StringBuilder().append(horario.getHoraInicio()).append(' ').append(horario.getDuracion()).append(' ').append(horario.getFechaCreacion()).append(' ').append(horario.getFechaModificacion()).toString();
            }
        };
    }

	public Converter<Long, Horario> getIdToHorarioConverter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.Long, com.raze.cancha.domain.Horario>() {
            public com.raze.cancha.domain.Horario convert(java.lang.Long id) {
                return Horario.findHorario(id);
            }
        };
    }

	public Converter<String, Horario> getStringToHorarioConverter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.String, com.raze.cancha.domain.Horario>() {
            public com.raze.cancha.domain.Horario convert(String id) {
                return getObject().convert(getObject().convert(id, Long.class), Horario.class);
            }
        };
    }

	public Converter<Jugador, String> getJugadorToStringConverter() {
        return new org.springframework.core.convert.converter.Converter<com.raze.cancha.domain.Jugador, java.lang.String>() {
            public String convert(Jugador jugador) {
                return new StringBuilder().append(jugador.getNombre()).append(' ').append(jugador.getApellidoPaterno()).append(' ').append(jugador.getApellidoMaterno()).append(' ').append(jugador.getFechaNacimiento()).toString();
            }
        };
    }

	public Converter<Long, Jugador> getIdToJugadorConverter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.Long, com.raze.cancha.domain.Jugador>() {
            public com.raze.cancha.domain.Jugador convert(java.lang.Long id) {
                return Jugador.findJugador(id);
            }
        };
    }

	public Converter<String, Jugador> getStringToJugadorConverter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.String, com.raze.cancha.domain.Jugador>() {
            public com.raze.cancha.domain.Jugador convert(String id) {
                return getObject().convert(getObject().convert(id, Long.class), Jugador.class);
            }
        };
    }

	public Converter<PagoHecho, String> getPagoHechoToStringConverter() {
        return new org.springframework.core.convert.converter.Converter<com.raze.cancha.domain.PagoHecho, java.lang.String>() {
            public String convert(PagoHecho pagoHecho) {
                return new StringBuilder().append(pagoHecho.getMonto()).append(' ').append(pagoHecho.getDescuento()).append(' ').append(pagoHecho.getFechaPago()).append(' ').append(pagoHecho.getFechaVencimiento()).toString();
            }
        };
    }

	public Converter<Long, PagoHecho> getIdToPagoHechoConverter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.Long, com.raze.cancha.domain.PagoHecho>() {
            public com.raze.cancha.domain.PagoHecho convert(java.lang.Long id) {
                return PagoHecho.findPagoHecho(id);
            }
        };
    }

	public Converter<String, PagoHecho> getStringToPagoHechoConverter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.String, com.raze.cancha.domain.PagoHecho>() {
            public com.raze.cancha.domain.PagoHecho convert(String id) {
                return getObject().convert(getObject().convert(id, Long.class), PagoHecho.class);
            }
        };
    }

	public Converter<Partido, String> getPartidoToStringConverter() {
        return new org.springframework.core.convert.converter.Converter<com.raze.cancha.domain.Partido, java.lang.String>() {
            public String convert(Partido partido) {
                return new StringBuilder().append(partido.getFechaJuego()).append(' ').append(partido.getFechaCreacion()).append(' ').append(partido.getFechaModificacion()).toString();
            }
        };
    }

	public Converter<Long, Partido> getIdToPartidoConverter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.Long, com.raze.cancha.domain.Partido>() {
            public com.raze.cancha.domain.Partido convert(java.lang.Long id) {
                return Partido.findPartido(id);
            }
        };
    }

	public Converter<String, Partido> getStringToPartidoConverter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.String, com.raze.cancha.domain.Partido>() {
            public com.raze.cancha.domain.Partido convert(String id) {
                return getObject().convert(getObject().convert(id, Long.class), Partido.class);
            }
        };
    }

	public Converter<Sucursal, String> getSucursalToStringConverter() {
        return new org.springframework.core.convert.converter.Converter<com.raze.cancha.domain.Sucursal, java.lang.String>() {
            public String convert(Sucursal sucursal) {
                return new StringBuilder().append(sucursal.getNombre()).append(' ').append(sucursal.getDomicilio()).append(' ').append(sucursal.getTelefono()).append(' ').append(sucursal.getCorreoE()).toString();
            }
        };
    }

	public Converter<Long, Sucursal> getIdToSucursalConverter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.Long, com.raze.cancha.domain.Sucursal>() {
            public com.raze.cancha.domain.Sucursal convert(java.lang.Long id) {
                return Sucursal.findSucursal(id);
            }
        };
    }

	public Converter<String, Sucursal> getStringToSucursalConverter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.String, com.raze.cancha.domain.Sucursal>() {
            public com.raze.cancha.domain.Sucursal convert(String id) {
                return getObject().convert(getObject().convert(id, Long.class), Sucursal.class);
            }
        };
    }

	public Converter<Torneo, String> getTorneoToStringConverter() {
        return new org.springframework.core.convert.converter.Converter<com.raze.cancha.domain.Torneo, java.lang.String>() {
            public String convert(Torneo torneo) {
                return new StringBuilder().append(torneo.getNombre()).append(' ').append(torneo.getDescripcion()).append(' ').append(torneo.getFechaInicio()).append(' ').append(torneo.getFechaFin()).toString();
            }
        };
    }

	public Converter<Long, Torneo> getIdToTorneoConverter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.Long, com.raze.cancha.domain.Torneo>() {
            public com.raze.cancha.domain.Torneo convert(java.lang.Long id) {
                return Torneo.findTorneo(id);
            }
        };
    }

	public Converter<String, Torneo> getStringToTorneoConverter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.String, com.raze.cancha.domain.Torneo>() {
            public com.raze.cancha.domain.Torneo convert(String id) {
                return getObject().convert(getObject().convert(id, Long.class), Torneo.class);
            }
        };
    }

	public Converter<TorneoEquipo, String> getTorneoEquipoToStringConverter() {
        return new org.springframework.core.convert.converter.Converter<com.raze.cancha.domain.TorneoEquipo, java.lang.String>() {
            public String convert(TorneoEquipo torneoEquipo) {
                return new StringBuilder().append(torneoEquipo.getFechaCreacion()).append(' ').append(torneoEquipo.getFechaModificacion()).toString();
            }
        };
    }

	public Converter<Long, TorneoEquipo> getIdToTorneoEquipoConverter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.Long, com.raze.cancha.domain.TorneoEquipo>() {
            public com.raze.cancha.domain.TorneoEquipo convert(java.lang.Long id) {
                return TorneoEquipo.findTorneoEquipo(id);
            }
        };
    }

	public Converter<String, TorneoEquipo> getStringToTorneoEquipoConverter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.String, com.raze.cancha.domain.TorneoEquipo>() {
            public com.raze.cancha.domain.TorneoEquipo convert(String id) {
                return getObject().convert(getObject().convert(id, Long.class), TorneoEquipo.class);
            }
        };
    }

	public Converter<Usuario, String> getUsuarioToStringConverter() {
        return new org.springframework.core.convert.converter.Converter<com.raze.cancha.domain.Usuario, java.lang.String>() {
            public String convert(Usuario usuario) {
                return new StringBuilder().append(usuario.getNombre()).append(' ').append(usuario.getApellidoPaterno()).append(' ').append(usuario.getApellidoMaterno()).append(' ').append(usuario.getFechaNacimiento()).toString();
            }
        };
    }

	public Converter<Long, Usuario> getIdToUsuarioConverter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.Long, com.raze.cancha.domain.Usuario>() {
            public com.raze.cancha.domain.Usuario convert(java.lang.Long id) {
                return Usuario.findUsuario(id);
            }
        };
    }

	public Converter<String, Usuario> getStringToUsuarioConverter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.String, com.raze.cancha.domain.Usuario>() {
            public com.raze.cancha.domain.Usuario convert(String id) {
                return getObject().convert(getObject().convert(id, Long.class), Usuario.class);
            }
        };
    }

	public void installLabelConverters(FormatterRegistry registry) {
        registry.addConverter(getAccionToStringConverter());
        registry.addConverter(getIdToAccionConverter());
        registry.addConverter(getStringToAccionConverter());
        registry.addConverter(getConceptoCobroToStringConverter());
        registry.addConverter(getIdToConceptoCobroConverter());
        registry.addConverter(getStringToConceptoCobroConverter());
        registry.addConverter(getDescuentoToStringConverter());
        registry.addConverter(getIdToDescuentoConverter());
        registry.addConverter(getStringToDescuentoConverter());
        registry.addConverter(getDiasJuegoToStringConverter());
        registry.addConverter(getIdToDiasJuegoConverter());
        registry.addConverter(getStringToDiasJuegoConverter());
        registry.addConverter(getFechaVencimientoTCToStringConverter());
        registry.addConverter(getIdToFechaVencimientoTCConverter());
        registry.addConverter(getStringToFechaVencimientoTCConverter());
        registry.addConverter(getMetodoPagoToStringConverter());
        registry.addConverter(getIdToMetodoPagoConverter());
        registry.addConverter(getStringToMetodoPagoConverter());
        registry.addConverter(getPosicionToStringConverter());
        registry.addConverter(getIdToPosicionConverter());
        registry.addConverter(getStringToPosicionConverter());
        registry.addConverter(getRolToStringConverter());
        registry.addConverter(getIdToRolConverter());
        registry.addConverter(getStringToRolConverter());
        registry.addConverter(getStatusCargoAbonoToStringConverter());
        registry.addConverter(getIdToStatusCargoAbonoConverter());
        registry.addConverter(getStringToStatusCargoAbonoConverter());
        registry.addConverter(getStatusCedulaToStringConverter());
        registry.addConverter(getIdToStatusCedulaConverter());
        registry.addConverter(getStringToStatusCedulaConverter());
        registry.addConverter(getStatusEquipoJugadorToStringConverter());
        registry.addConverter(getIdToStatusEquipoJugadorConverter());
        registry.addConverter(getStringToStatusEquipoJugadorConverter());
        registry.addConverter(getStatusPartidoToStringConverter());
        registry.addConverter(getIdToStatusPartidoConverter());
        registry.addConverter(getStringToStatusPartidoConverter());
        registry.addConverter(getTipoCobroToStringConverter());
        registry.addConverter(getIdToTipoCobroConverter());
        registry.addConverter(getStringToTipoCobroConverter());
        registry.addConverter(getTipoPartidoToStringConverter());
        registry.addConverter(getIdToTipoPartidoConverter());
        registry.addConverter(getStringToTipoPartidoConverter());
        registry.addConverter(getTipoTarjetaToStringConverter());
        registry.addConverter(getIdToTipoTarjetaConverter());
        registry.addConverter(getStringToTipoTarjetaConverter());
        registry.addConverter(getAbonoToStringConverter());
        registry.addConverter(getIdToAbonoConverter());
        registry.addConverter(getStringToAbonoConverter());
        registry.addConverter(getAlineacionToStringConverter());
        registry.addConverter(getIdToAlineacionConverter());
        registry.addConverter(getStringToAlineacionConverter());
        registry.addConverter(getCanchaToStringConverter());
        registry.addConverter(getIdToCanchaConverter());
        registry.addConverter(getStringToCanchaConverter());
        registry.addConverter(getCargoToStringConverter());
        registry.addConverter(getIdToCargoConverter());
        registry.addConverter(getStringToCargoConverter());
        registry.addConverter(getCedulaPartidoToStringConverter());
        registry.addConverter(getIdToCedulaPartidoConverter());
        registry.addConverter(getStringToCedulaPartidoConverter());
        registry.addConverter(getConfiguracionTorneoToStringConverter());
        registry.addConverter(getIdToConfiguracionTorneoConverter());
        registry.addConverter(getStringToConfiguracionTorneoConverter());
        registry.addConverter(getControlPagoToStringConverter());
        registry.addConverter(getIdToControlPagoConverter());
        registry.addConverter(getStringToControlPagoConverter());
        registry.addConverter(getEmpresaToStringConverter());
        registry.addConverter(getIdToEmpresaConverter());
        registry.addConverter(getStringToEmpresaConverter());
        registry.addConverter(getEquipoToStringConverter());
        registry.addConverter(getIdToEquipoConverter());
        registry.addConverter(getStringToEquipoConverter());
        registry.addConverter(getEstadisticasToStringConverter());
        registry.addConverter(getIdToEstadisticasConverter());
        registry.addConverter(getStringToEstadisticasConverter());
        registry.addConverter(getHorarioToStringConverter());
        registry.addConverter(getIdToHorarioConverter());
        registry.addConverter(getStringToHorarioConverter());
        registry.addConverter(getJugadorToStringConverter());
        registry.addConverter(getIdToJugadorConverter());
        registry.addConverter(getStringToJugadorConverter());
        registry.addConverter(getPagoHechoToStringConverter());
        registry.addConverter(getIdToPagoHechoConverter());
        registry.addConverter(getStringToPagoHechoConverter());
        registry.addConverter(getPartidoToStringConverter());
        registry.addConverter(getIdToPartidoConverter());
        registry.addConverter(getStringToPartidoConverter());
        registry.addConverter(getSucursalToStringConverter());
        registry.addConverter(getIdToSucursalConverter());
        registry.addConverter(getStringToSucursalConverter());
        registry.addConverter(getTorneoToStringConverter());
        registry.addConverter(getIdToTorneoConverter());
        registry.addConverter(getStringToTorneoConverter());
        registry.addConverter(getTorneoEquipoToStringConverter());
        registry.addConverter(getIdToTorneoEquipoConverter());
        registry.addConverter(getStringToTorneoEquipoConverter());
        registry.addConverter(getUsuarioToStringConverter());
        registry.addConverter(getIdToUsuarioConverter());
        registry.addConverter(getStringToUsuarioConverter());
    }

	public void afterPropertiesSet() {
        super.afterPropertiesSet();
        installLabelConverters(getObject());
    }
}
