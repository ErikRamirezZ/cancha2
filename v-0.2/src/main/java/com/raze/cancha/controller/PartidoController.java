package com.raze.cancha.controller;
import com.raze.cancha.catalog.StatusPartido;
import com.raze.cancha.catalog.TipoPartido;
import com.raze.cancha.domain.Cancha;
import com.raze.cancha.domain.Equipo;
import com.raze.cancha.domain.Horario;
import com.raze.cancha.domain.Partido;
import com.raze.cancha.domain.Torneo;
import com.raze.cancha.domain.Usuario;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.roo.addon.web.mvc.controller.json.RooWebJson;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.util.UriComponentsBuilder;
import org.springframework.web.util.UriUtils;
import org.springframework.web.util.WebUtils;
import org.springframework.roo.addon.web.mvc.controller.scaffold.RooWebScaffold;
import org.springframework.roo.addon.web.mvc.controller.finder.RooWebFinder;

@RooWebJson(jsonObject = Partido.class)
@Controller
@RequestMapping("/partidoes")
@RooWebScaffold(path = "partidoes", formBackingObject = Partido.class)
@RooWebFinder
public class PartidoController {

	@RequestMapping(method = RequestMethod.POST, produces = "text/html")
    public String create(@Valid Partido partido, BindingResult bindingResult, Model uiModel, HttpServletRequest httpServletRequest) {
        if (bindingResult.hasErrors()) {
            populateEditForm(uiModel, partido);
            return "partidoes/create";
        }
        uiModel.asMap().clear();
        partido.persist();
        return "redirect:/partidoes/" + encodeUrlPathSegment(partido.getId().toString(), httpServletRequest);
    }

	@RequestMapping(params = "form", produces = "text/html")
    public String createForm(Model uiModel) {
        populateEditForm(uiModel, new Partido());
        List<String[]> dependencies = new ArrayList<String[]>();
        if (Cancha.countCanchas() == 0) {
            dependencies.add(new String[] { "cancha", "canchas" });
        }
        if (StatusPartido.countStatusPartidoes() == 0) {
            dependencies.add(new String[] { "statuspartido", "statuspartidoes" });
        }
        uiModel.addAttribute("dependencies", dependencies);
        return "partidoes/create";
    }

	@RequestMapping(value = "/{id}", produces = "text/html")
    public String show(@PathVariable("id") Long id, Model uiModel) {
        addDateTimeFormatPatterns(uiModel);
        uiModel.addAttribute("partido", Partido.findPartido(id));
        uiModel.addAttribute("itemId", id);
        return "partidoes/show";
    }

	@RequestMapping(produces = "text/html")
    public String list(@RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, @RequestParam(value = "sortFieldName", required = false) String sortFieldName, @RequestParam(value = "sortOrder", required = false) String sortOrder, Model uiModel) {
        if (page != null || size != null) {
            int sizeNo = size == null ? 10 : size.intValue();
            final int firstResult = page == null ? 0 : (page.intValue() - 1) * sizeNo;
            uiModel.addAttribute("partidoes", Partido.findPartidoEntries(firstResult, sizeNo, sortFieldName, sortOrder));
            float nrOfPages = (float) Partido.countPartidoes() / sizeNo;
            uiModel.addAttribute("maxPages", (int) ((nrOfPages > (int) nrOfPages || nrOfPages == 0.0) ? nrOfPages + 1 : nrOfPages));
        } else {
            uiModel.addAttribute("partidoes", Partido.findAllPartidoes(sortFieldName, sortOrder));
        }
        addDateTimeFormatPatterns(uiModel);
        return "partidoes/list";
    }

	@RequestMapping(method = RequestMethod.PUT, produces = "text/html")
    public String update(@Valid Partido partido, BindingResult bindingResult, Model uiModel, HttpServletRequest httpServletRequest) {
        if (bindingResult.hasErrors()) {
            populateEditForm(uiModel, partido);
            return "partidoes/update";
        }
        uiModel.asMap().clear();
        partido.merge();
        return "redirect:/partidoes/" + encodeUrlPathSegment(partido.getId().toString(), httpServletRequest);
    }

	@RequestMapping(value = "/{id}", params = "form", produces = "text/html")
    public String updateForm(@PathVariable("id") Long id, Model uiModel) {
        populateEditForm(uiModel, Partido.findPartido(id));
        return "partidoes/update";
    }

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = "text/html")
    public String delete(@PathVariable("id") Long id, @RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, Model uiModel) {
        Partido partido = Partido.findPartido(id);
        partido.remove();
        uiModel.asMap().clear();
        uiModel.addAttribute("page", (page == null) ? "1" : page.toString());
        uiModel.addAttribute("size", (size == null) ? "10" : size.toString());
        return "redirect:/partidoes";
    }

	void addDateTimeFormatPatterns(Model uiModel) {
        uiModel.addAttribute("partido_fechajuego_date_format", org.joda.time.format.DateTimeFormat.patternForStyle("M-", LocaleContextHolder.getLocale()));
        uiModel.addAttribute("partido_fechacreacion_date_format", org.joda.time.format.DateTimeFormat.patternForStyle("M-", LocaleContextHolder.getLocale()));
        uiModel.addAttribute("partido_fechamodificacion_date_format", org.joda.time.format.DateTimeFormat.patternForStyle("M-", LocaleContextHolder.getLocale()));
    }

	void populateEditForm(Model uiModel, Partido partido) {
        uiModel.addAttribute("partido", partido);
        addDateTimeFormatPatterns(uiModel);
        uiModel.addAttribute("statuspartidoes", StatusPartido.findAllStatusPartidoes());
        uiModel.addAttribute("tipopartidoes", TipoPartido.findAllTipoPartidoes());
        uiModel.addAttribute("canchas", Cancha.findAllCanchas());
        uiModel.addAttribute("equipoes", Equipo.findAllEquipoes());
        uiModel.addAttribute("horarios", Horario.findAllHorarios());
        uiModel.addAttribute("torneos", Torneo.findAllTorneos());
        uiModel.addAttribute("usuarios", Usuario.findAllUsuarios());
    }

	String encodeUrlPathSegment(String pathSegment, HttpServletRequest httpServletRequest) {
        String enc = httpServletRequest.getCharacterEncoding();
        if (enc == null) {
            enc = WebUtils.DEFAULT_CHARACTER_ENCODING;
        }
        try {
            pathSegment = UriUtils.encodePathSegment(pathSegment, enc);
        } catch (UnsupportedEncodingException uee) {}
        return pathSegment;
    }

	@RequestMapping(params = { "find=ByCancha", "form" }, method = RequestMethod.GET)
    public String findPartidoesByCanchaForm(Model uiModel) {
        uiModel.addAttribute("canchas", Cancha.findAllCanchas());
        return "partidoes/findPartidoesByCancha";
    }

	@RequestMapping(params = "find=ByCancha", method = RequestMethod.GET)
    public String findPartidoesByCancha(@RequestParam("cancha") Cancha cancha, @RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, @RequestParam(value = "sortFieldName", required = false) String sortFieldName, @RequestParam(value = "sortOrder", required = false) String sortOrder, Model uiModel) {
        if (page != null || size != null) {
            int sizeNo = size == null ? 10 : size.intValue();
            final int firstResult = page == null ? 0 : (page.intValue() - 1) * sizeNo;
            uiModel.addAttribute("partidoes", Partido.findPartidoesByCancha(cancha, sortFieldName, sortOrder).setFirstResult(firstResult).setMaxResults(sizeNo).getResultList());
            float nrOfPages = (float) Partido.countFindPartidoesByCancha(cancha) / sizeNo;
            uiModel.addAttribute("maxPages", (int) ((nrOfPages > (int) nrOfPages || nrOfPages == 0.0) ? nrOfPages + 1 : nrOfPages));
        } else {
            uiModel.addAttribute("partidoes", Partido.findPartidoesByCancha(cancha, sortFieldName, sortOrder).getResultList());
        }
        addDateTimeFormatPatterns(uiModel);
        return "partidoes/list";
    }

	@RequestMapping(params = { "find=ByCanchaAndStatus", "form" }, method = RequestMethod.GET)
    public String findPartidoesByCanchaAndStatusForm(Model uiModel) {
        uiModel.addAttribute("canchas", Cancha.findAllCanchas());
        uiModel.addAttribute("statuspartidoes", StatusPartido.findAllStatusPartidoes());
        return "partidoes/findPartidoesByCanchaAndStatus";
    }

	@RequestMapping(params = "find=ByCanchaAndStatus", method = RequestMethod.GET)
    public String findPartidoesByCanchaAndStatus(@RequestParam("cancha") Cancha cancha, @RequestParam("status") StatusPartido status, @RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, @RequestParam(value = "sortFieldName", required = false) String sortFieldName, @RequestParam(value = "sortOrder", required = false) String sortOrder, Model uiModel) {
        if (page != null || size != null) {
            int sizeNo = size == null ? 10 : size.intValue();
            final int firstResult = page == null ? 0 : (page.intValue() - 1) * sizeNo;
            uiModel.addAttribute("partidoes", Partido.findPartidoesByCanchaAndStatus(cancha, status, sortFieldName, sortOrder).setFirstResult(firstResult).setMaxResults(sizeNo).getResultList());
            float nrOfPages = (float) Partido.countFindPartidoesByCanchaAndStatus(cancha, status) / sizeNo;
            uiModel.addAttribute("maxPages", (int) ((nrOfPages > (int) nrOfPages || nrOfPages == 0.0) ? nrOfPages + 1 : nrOfPages));
        } else {
            uiModel.addAttribute("partidoes", Partido.findPartidoesByCanchaAndStatus(cancha, status, sortFieldName, sortOrder).getResultList());
        }
        addDateTimeFormatPatterns(uiModel);
        return "partidoes/list";
    }

	@RequestMapping(params = { "find=ByCanchaAndStatusAndFechaJuegoBetween", "form" }, method = RequestMethod.GET)
    public String findPartidoesByCanchaAndStatusAndFechaJuegoBetweenForm(Model uiModel) {
        uiModel.addAttribute("canchas", Cancha.findAllCanchas());
        uiModel.addAttribute("statuspartidoes", StatusPartido.findAllStatusPartidoes());
        addDateTimeFormatPatterns(uiModel);
        return "partidoes/findPartidoesByCanchaAndStatusAndFechaJuegoBetween";
    }

	@RequestMapping(params = "find=ByCanchaAndStatusAndFechaJuegoBetween", method = RequestMethod.GET)
    public String findPartidoesByCanchaAndStatusAndFechaJuegoBetween(@RequestParam("cancha") Cancha cancha, @RequestParam("status") StatusPartido status, @RequestParam("minFechaJuego") @DateTimeFormat(style = "M-") Date minFechaJuego, @RequestParam("maxFechaJuego") @DateTimeFormat(style = "M-") Date maxFechaJuego, @RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, @RequestParam(value = "sortFieldName", required = false) String sortFieldName, @RequestParam(value = "sortOrder", required = false) String sortOrder, Model uiModel) {
        if (page != null || size != null) {
            int sizeNo = size == null ? 10 : size.intValue();
            final int firstResult = page == null ? 0 : (page.intValue() - 1) * sizeNo;
            uiModel.addAttribute("partidoes", Partido.findPartidoesByCanchaAndStatusAndFechaJuegoBetween(cancha, status, minFechaJuego, maxFechaJuego, sortFieldName, sortOrder).setFirstResult(firstResult).setMaxResults(sizeNo).getResultList());
            float nrOfPages = (float) Partido.countFindPartidoesByCanchaAndStatusAndFechaJuegoBetween(cancha, status, minFechaJuego, maxFechaJuego) / sizeNo;
            uiModel.addAttribute("maxPages", (int) ((nrOfPages > (int) nrOfPages || nrOfPages == 0.0) ? nrOfPages + 1 : nrOfPages));
        } else {
            uiModel.addAttribute("partidoes", Partido.findPartidoesByCanchaAndStatusAndFechaJuegoBetween(cancha, status, minFechaJuego, maxFechaJuego, sortFieldName, sortOrder).getResultList());
        }
        addDateTimeFormatPatterns(uiModel);
        return "partidoes/list";
    }

	@RequestMapping(params = { "find=ByCanchaAndStatusAndFechaJuegoEquals", "form" }, method = RequestMethod.GET)
    public String findPartidoesByCanchaAndStatusAndFechaJuegoEqualsForm(Model uiModel) {
        uiModel.addAttribute("canchas", Cancha.findAllCanchas());
        uiModel.addAttribute("statuspartidoes", StatusPartido.findAllStatusPartidoes());
        addDateTimeFormatPatterns(uiModel);
        return "partidoes/findPartidoesByCanchaAndStatusAndFechaJuegoEquals";
    }

	@RequestMapping(params = "find=ByCanchaAndStatusAndFechaJuegoEquals", method = RequestMethod.GET)
    public String findPartidoesByCanchaAndStatusAndFechaJuegoEquals(@RequestParam("cancha") Cancha cancha, @RequestParam("status") StatusPartido status, @RequestParam("fechaJuego") @DateTimeFormat(style = "M-") Date fechaJuego, @RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, @RequestParam(value = "sortFieldName", required = false) String sortFieldName, @RequestParam(value = "sortOrder", required = false) String sortOrder, Model uiModel) {
        if (page != null || size != null) {
            int sizeNo = size == null ? 10 : size.intValue();
            final int firstResult = page == null ? 0 : (page.intValue() - 1) * sizeNo;
            uiModel.addAttribute("partidoes", Partido.findPartidoesByCanchaAndStatusAndFechaJuegoEquals(cancha, status, fechaJuego, sortFieldName, sortOrder).setFirstResult(firstResult).setMaxResults(sizeNo).getResultList());
            float nrOfPages = (float) Partido.countFindPartidoesByCanchaAndStatusAndFechaJuegoEquals(cancha, status, fechaJuego) / sizeNo;
            uiModel.addAttribute("maxPages", (int) ((nrOfPages > (int) nrOfPages || nrOfPages == 0.0) ? nrOfPages + 1 : nrOfPages));
        } else {
            uiModel.addAttribute("partidoes", Partido.findPartidoesByCanchaAndStatusAndFechaJuegoEquals(cancha, status, fechaJuego, sortFieldName, sortOrder).getResultList());
        }
        addDateTimeFormatPatterns(uiModel);
        return "partidoes/list";
    }

	@RequestMapping(params = { "find=ByFechaJuegoBetweenAndStatus", "form" }, method = RequestMethod.GET)
    public String findPartidoesByFechaJuegoBetweenAndStatusForm(Model uiModel) {
        uiModel.addAttribute("statuspartidoes", StatusPartido.findAllStatusPartidoes());
        addDateTimeFormatPatterns(uiModel);
        return "partidoes/findPartidoesByFechaJuegoBetweenAndStatus";
    }

	@RequestMapping(params = "find=ByFechaJuegoBetweenAndStatus", method = RequestMethod.GET)
    public String findPartidoesByFechaJuegoBetweenAndStatus(@RequestParam("minFechaJuego") @DateTimeFormat(style = "M-") Date minFechaJuego, @RequestParam("maxFechaJuego") @DateTimeFormat(style = "M-") Date maxFechaJuego, @RequestParam("status") StatusPartido status, @RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, @RequestParam(value = "sortFieldName", required = false) String sortFieldName, @RequestParam(value = "sortOrder", required = false) String sortOrder, Model uiModel) {
        if (page != null || size != null) {
            int sizeNo = size == null ? 10 : size.intValue();
            final int firstResult = page == null ? 0 : (page.intValue() - 1) * sizeNo;
            uiModel.addAttribute("partidoes", Partido.findPartidoesByFechaJuegoBetweenAndStatus(minFechaJuego, maxFechaJuego, status, sortFieldName, sortOrder).setFirstResult(firstResult).setMaxResults(sizeNo).getResultList());
            float nrOfPages = (float) Partido.countFindPartidoesByFechaJuegoBetweenAndStatus(minFechaJuego, maxFechaJuego, status) / sizeNo;
            uiModel.addAttribute("maxPages", (int) ((nrOfPages > (int) nrOfPages || nrOfPages == 0.0) ? nrOfPages + 1 : nrOfPages));
        } else {
            uiModel.addAttribute("partidoes", Partido.findPartidoesByFechaJuegoBetweenAndStatus(minFechaJuego, maxFechaJuego, status, sortFieldName, sortOrder).getResultList());
        }
        addDateTimeFormatPatterns(uiModel);
        return "partidoes/list";
    }

	@RequestMapping(params = { "find=ByFechaJuegoEqualsAndStatus", "form" }, method = RequestMethod.GET)
    public String findPartidoesByFechaJuegoEqualsAndStatusForm(Model uiModel) {
        uiModel.addAttribute("statuspartidoes", StatusPartido.findAllStatusPartidoes());
        addDateTimeFormatPatterns(uiModel);
        return "partidoes/findPartidoesByFechaJuegoEqualsAndStatus";
    }

	@RequestMapping(params = "find=ByFechaJuegoEqualsAndStatus", method = RequestMethod.GET)
    public String findPartidoesByFechaJuegoEqualsAndStatus(@RequestParam("fechaJuego") @DateTimeFormat(style = "M-") Date fechaJuego, @RequestParam("status") StatusPartido status, @RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, @RequestParam(value = "sortFieldName", required = false) String sortFieldName, @RequestParam(value = "sortOrder", required = false) String sortOrder, Model uiModel) {
        if (page != null || size != null) {
            int sizeNo = size == null ? 10 : size.intValue();
            final int firstResult = page == null ? 0 : (page.intValue() - 1) * sizeNo;
            uiModel.addAttribute("partidoes", Partido.findPartidoesByFechaJuegoEqualsAndStatus(fechaJuego, status, sortFieldName, sortOrder).setFirstResult(firstResult).setMaxResults(sizeNo).getResultList());
            float nrOfPages = (float) Partido.countFindPartidoesByFechaJuegoEqualsAndStatus(fechaJuego, status) / sizeNo;
            uiModel.addAttribute("maxPages", (int) ((nrOfPages > (int) nrOfPages || nrOfPages == 0.0) ? nrOfPages + 1 : nrOfPages));
        } else {
            uiModel.addAttribute("partidoes", Partido.findPartidoesByFechaJuegoEqualsAndStatus(fechaJuego, status, sortFieldName, sortOrder).getResultList());
        }
        addDateTimeFormatPatterns(uiModel);
        return "partidoes/list";
    }

	@RequestMapping(params = { "find=ByTorneoEquipoLocalAndTorneoEquipoVisitanteAndEquipoLocalAndEquipoVisitante", "form" }, method = RequestMethod.GET)
    public String findPartidoesByTorneoEquipoLocalAndTorneoEquipoVisitanteAndEquipoLocalAndEquipoVisitanteForm(Model uiModel) {
        uiModel.addAttribute("torneos", Torneo.findAllTorneos());
        uiModel.addAttribute("torneos", Torneo.findAllTorneos());
        uiModel.addAttribute("equipoes", Equipo.findAllEquipoes());
        uiModel.addAttribute("equipoes", Equipo.findAllEquipoes());
        return "partidoes/findPartidoesByTorneoEquipoLocalAndTorneoEquipoVisitanteAndEquipoLocalAndEquipoVisitante";
    }

	@RequestMapping(params = "find=ByTorneoEquipoLocalAndTorneoEquipoVisitanteAndEquipoLocalAndEquipoVisitante", method = RequestMethod.GET)
    public String findPartidoesByTorneoEquipoLocalAndTorneoEquipoVisitanteAndEquipoLocalAndEquipoVisitante(@RequestParam("torneoEquipoLocal") Torneo torneoEquipoLocal, @RequestParam("torneoEquipoVisitante") Torneo torneoEquipoVisitante, @RequestParam("equipoLocal") Equipo equipoLocal, @RequestParam("equipoVisitante") Equipo equipoVisitante, @RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, @RequestParam(value = "sortFieldName", required = false) String sortFieldName, @RequestParam(value = "sortOrder", required = false) String sortOrder, Model uiModel) {
        if (page != null || size != null) {
            int sizeNo = size == null ? 10 : size.intValue();
            final int firstResult = page == null ? 0 : (page.intValue() - 1) * sizeNo;
            uiModel.addAttribute("partidoes", Partido.findPartidoesByTorneoEquipoLocalAndTorneoEquipoVisitanteAndEquipoLocalAndEquipoVisitante(torneoEquipoLocal, torneoEquipoVisitante, equipoLocal, equipoVisitante, sortFieldName, sortOrder).setFirstResult(firstResult).setMaxResults(sizeNo).getResultList());
            float nrOfPages = (float) Partido.countFindPartidoesByTorneoEquipoLocalAndTorneoEquipoVisitanteAndEquipoLocalAndEquipoVisitante(torneoEquipoLocal, torneoEquipoVisitante, equipoLocal, equipoVisitante) / sizeNo;
            uiModel.addAttribute("maxPages", (int) ((nrOfPages > (int) nrOfPages || nrOfPages == 0.0) ? nrOfPages + 1 : nrOfPages));
        } else {
            uiModel.addAttribute("partidoes", Partido.findPartidoesByTorneoEquipoLocalAndTorneoEquipoVisitanteAndEquipoLocalAndEquipoVisitante(torneoEquipoLocal, torneoEquipoVisitante, equipoLocal, equipoVisitante, sortFieldName, sortOrder).getResultList());
        }
        addDateTimeFormatPatterns(uiModel);
        return "partidoes/list";
    }

	@RequestMapping(params = { "find=ByTorneoEquipoLocalAndTorneoEquipoVisitanteAndEquipoLocalAndEquipoVisitanteAndStatus", "form" }, method = RequestMethod.GET)
    public String findPartidoesByTorneoEquipoLocalAndTorneoEquipoVisitanteAndEquipoLocalAndEquipoVisitanteAndStatusForm(Model uiModel) {
        uiModel.addAttribute("torneos", Torneo.findAllTorneos());
        uiModel.addAttribute("torneos", Torneo.findAllTorneos());
        uiModel.addAttribute("equipoes", Equipo.findAllEquipoes());
        uiModel.addAttribute("equipoes", Equipo.findAllEquipoes());
        uiModel.addAttribute("statuspartidoes", StatusPartido.findAllStatusPartidoes());
        return "partidoes/findPartidoesByTorneoEquipoLocalAndTorneoEquipoVisitanteAndEquipoLocalAndEquipoVisitanteAndStatus";
    }

	@RequestMapping(params = "find=ByTorneoEquipoLocalAndTorneoEquipoVisitanteAndEquipoLocalAndEquipoVisitanteAndStatus", method = RequestMethod.GET)
    public String findPartidoesByTorneoEquipoLocalAndTorneoEquipoVisitanteAndEquipoLocalAndEquipoVisitanteAndStatus(@RequestParam("torneoEquipoLocal") Torneo torneoEquipoLocal, @RequestParam("torneoEquipoVisitante") Torneo torneoEquipoVisitante, @RequestParam("equipoLocal") Equipo equipoLocal, @RequestParam("equipoVisitante") Equipo equipoVisitante, @RequestParam("status") StatusPartido status, @RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, @RequestParam(value = "sortFieldName", required = false) String sortFieldName, @RequestParam(value = "sortOrder", required = false) String sortOrder, Model uiModel) {
        if (page != null || size != null) {
            int sizeNo = size == null ? 10 : size.intValue();
            final int firstResult = page == null ? 0 : (page.intValue() - 1) * sizeNo;
            uiModel.addAttribute("partidoes", Partido.findPartidoesByTorneoEquipoLocalAndTorneoEquipoVisitanteAndEquipoLocalAndEquipoVisitanteAndStatus(torneoEquipoLocal, torneoEquipoVisitante, equipoLocal, equipoVisitante, status, sortFieldName, sortOrder).setFirstResult(firstResult).setMaxResults(sizeNo).getResultList());
            float nrOfPages = (float) Partido.countFindPartidoesByTorneoEquipoLocalAndTorneoEquipoVisitanteAndEquipoLocalAndEquipoVisitanteAndStatus(torneoEquipoLocal, torneoEquipoVisitante, equipoLocal, equipoVisitante, status) / sizeNo;
            uiModel.addAttribute("maxPages", (int) ((nrOfPages > (int) nrOfPages || nrOfPages == 0.0) ? nrOfPages + 1 : nrOfPages));
        } else {
            uiModel.addAttribute("partidoes", Partido.findPartidoesByTorneoEquipoLocalAndTorneoEquipoVisitanteAndEquipoLocalAndEquipoVisitanteAndStatus(torneoEquipoLocal, torneoEquipoVisitante, equipoLocal, equipoVisitante, status, sortFieldName, sortOrder).getResultList());
        }
        addDateTimeFormatPatterns(uiModel);
        return "partidoes/list";
    }

	@RequestMapping(params = { "find=ByTorneoEquipoLocalOrTorneoEquipoVisitante", "form" }, method = RequestMethod.GET)
    public String findPartidoesByTorneoEquipoLocalOrTorneoEquipoVisitanteForm(Model uiModel) {
        uiModel.addAttribute("torneos", Torneo.findAllTorneos());
        uiModel.addAttribute("torneos", Torneo.findAllTorneos());
        return "partidoes/findPartidoesByTorneoEquipoLocalOrTorneoEquipoVisitante";
    }

	@RequestMapping(params = "find=ByTorneoEquipoLocalOrTorneoEquipoVisitante", method = RequestMethod.GET)
    public String findPartidoesByTorneoEquipoLocalOrTorneoEquipoVisitante(@RequestParam("torneoEquipoLocal") Torneo torneoEquipoLocal, @RequestParam("torneoEquipoVisitante") Torneo torneoEquipoVisitante, @RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, @RequestParam(value = "sortFieldName", required = false) String sortFieldName, @RequestParam(value = "sortOrder", required = false) String sortOrder, Model uiModel) {
        if (page != null || size != null) {
            int sizeNo = size == null ? 10 : size.intValue();
            final int firstResult = page == null ? 0 : (page.intValue() - 1) * sizeNo;
            uiModel.addAttribute("partidoes", Partido.findPartidoesByTorneoEquipoLocalOrTorneoEquipoVisitante(torneoEquipoLocal, torneoEquipoVisitante, sortFieldName, sortOrder).setFirstResult(firstResult).setMaxResults(sizeNo).getResultList());
            float nrOfPages = (float) Partido.countFindPartidoesByTorneoEquipoLocalOrTorneoEquipoVisitante(torneoEquipoLocal, torneoEquipoVisitante) / sizeNo;
            uiModel.addAttribute("maxPages", (int) ((nrOfPages > (int) nrOfPages || nrOfPages == 0.0) ? nrOfPages + 1 : nrOfPages));
        } else {
            uiModel.addAttribute("partidoes", Partido.findPartidoesByTorneoEquipoLocalOrTorneoEquipoVisitante(torneoEquipoLocal, torneoEquipoVisitante, sortFieldName, sortOrder).getResultList());
        }
        addDateTimeFormatPatterns(uiModel);
        return "partidoes/list";
    }

	@RequestMapping(params = { "find=ByTorneoEquipoLocalOrTorneoEquipoVisitanteAndEquipoLocalOrEquipoVisitante", "form" }, method = RequestMethod.GET)
    public String findPartidoesByTorneoEquipoLocalOrTorneoEquipoVisitanteAndEquipoLocalOrEquipoVisitanteForm(Model uiModel) {
        uiModel.addAttribute("torneos", Torneo.findAllTorneos());
        uiModel.addAttribute("torneos", Torneo.findAllTorneos());
        uiModel.addAttribute("equipoes", Equipo.findAllEquipoes());
        uiModel.addAttribute("equipoes", Equipo.findAllEquipoes());
        return "partidoes/findPartidoesByTorneoEquipoLocalOrTorneoEquipoVisitanteAndEquipoLocalOrEquipoVisitante";
    }

	@RequestMapping(params = "find=ByTorneoEquipoLocalOrTorneoEquipoVisitanteAndEquipoLocalOrEquipoVisitante", method = RequestMethod.GET)
    public String findPartidoesByTorneoEquipoLocalOrTorneoEquipoVisitanteAndEquipoLocalOrEquipoVisitante(@RequestParam("torneoEquipoLocal") Torneo torneoEquipoLocal, @RequestParam("torneoEquipoVisitante") Torneo torneoEquipoVisitante, @RequestParam("equipoLocal") Equipo equipoLocal, @RequestParam("equipoVisitante") Equipo equipoVisitante, @RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, @RequestParam(value = "sortFieldName", required = false) String sortFieldName, @RequestParam(value = "sortOrder", required = false) String sortOrder, Model uiModel) {
        if (page != null || size != null) {
            int sizeNo = size == null ? 10 : size.intValue();
            final int firstResult = page == null ? 0 : (page.intValue() - 1) * sizeNo;
            uiModel.addAttribute("partidoes", Partido.findPartidoesByTorneoEquipoLocalOrTorneoEquipoVisitanteAndEquipoLocalOrEquipoVisitante(torneoEquipoLocal, torneoEquipoVisitante, equipoLocal, equipoVisitante, sortFieldName, sortOrder).setFirstResult(firstResult).setMaxResults(sizeNo).getResultList());
            float nrOfPages = (float) Partido.countFindPartidoesByTorneoEquipoLocalOrTorneoEquipoVisitanteAndEquipoLocalOrEquipoVisitante(torneoEquipoLocal, torneoEquipoVisitante, equipoLocal, equipoVisitante) / sizeNo;
            uiModel.addAttribute("maxPages", (int) ((nrOfPages > (int) nrOfPages || nrOfPages == 0.0) ? nrOfPages + 1 : nrOfPages));
        } else {
            uiModel.addAttribute("partidoes", Partido.findPartidoesByTorneoEquipoLocalOrTorneoEquipoVisitanteAndEquipoLocalOrEquipoVisitante(torneoEquipoLocal, torneoEquipoVisitante, equipoLocal, equipoVisitante, sortFieldName, sortOrder).getResultList());
        }
        addDateTimeFormatPatterns(uiModel);
        return "partidoes/list";
    }

	@RequestMapping(params = { "find=ByTorneoEquipoLocalOrTorneoEquipoVisitanteAndEquipoLocalOrEquipoVisitanteAndStatus", "form" }, method = RequestMethod.GET)
    public String findPartidoesByTorneoEquipoLocalOrTorneoEquipoVisitanteAndEquipoLocalOrEquipoVisitanteAndStatusForm(Model uiModel) {
        uiModel.addAttribute("torneos", Torneo.findAllTorneos());
        uiModel.addAttribute("torneos", Torneo.findAllTorneos());
        uiModel.addAttribute("equipoes", Equipo.findAllEquipoes());
        uiModel.addAttribute("equipoes", Equipo.findAllEquipoes());
        uiModel.addAttribute("statuspartidoes", StatusPartido.findAllStatusPartidoes());
        return "partidoes/findPartidoesByTorneoEquipoLocalOrTorneoEquipoVisitanteAndEquipoLocalOrEquipoVisitanteAndStatus";
    }

	@RequestMapping(params = "find=ByTorneoEquipoLocalOrTorneoEquipoVisitanteAndEquipoLocalOrEquipoVisitanteAndStatus", method = RequestMethod.GET)
    public String findPartidoesByTorneoEquipoLocalOrTorneoEquipoVisitanteAndEquipoLocalOrEquipoVisitanteAndStatus(@RequestParam("torneoEquipoLocal") Torneo torneoEquipoLocal, @RequestParam("torneoEquipoVisitante") Torneo torneoEquipoVisitante, @RequestParam("equipoLocal") Equipo equipoLocal, @RequestParam("equipoVisitante") Equipo equipoVisitante, @RequestParam("status") StatusPartido status, @RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, @RequestParam(value = "sortFieldName", required = false) String sortFieldName, @RequestParam(value = "sortOrder", required = false) String sortOrder, Model uiModel) {
        if (page != null || size != null) {
            int sizeNo = size == null ? 10 : size.intValue();
            final int firstResult = page == null ? 0 : (page.intValue() - 1) * sizeNo;
            uiModel.addAttribute("partidoes", Partido.findPartidoesByTorneoEquipoLocalOrTorneoEquipoVisitanteAndEquipoLocalOrEquipoVisitanteAndStatus(torneoEquipoLocal, torneoEquipoVisitante, equipoLocal, equipoVisitante, status, sortFieldName, sortOrder).setFirstResult(firstResult).setMaxResults(sizeNo).getResultList());
            float nrOfPages = (float) Partido.countFindPartidoesByTorneoEquipoLocalOrTorneoEquipoVisitanteAndEquipoLocalOrEquipoVisitanteAndStatus(torneoEquipoLocal, torneoEquipoVisitante, equipoLocal, equipoVisitante, status) / sizeNo;
            uiModel.addAttribute("maxPages", (int) ((nrOfPages > (int) nrOfPages || nrOfPages == 0.0) ? nrOfPages + 1 : nrOfPages));
        } else {
            uiModel.addAttribute("partidoes", Partido.findPartidoesByTorneoEquipoLocalOrTorneoEquipoVisitanteAndEquipoLocalOrEquipoVisitanteAndStatus(torneoEquipoLocal, torneoEquipoVisitante, equipoLocal, equipoVisitante, status, sortFieldName, sortOrder).getResultList());
        }
        addDateTimeFormatPatterns(uiModel);
        return "partidoes/list";
    }

	@RequestMapping(params = { "find=ByTorneoEquipoLocalOrTorneoEquipoVisitanteAndStatus", "form" }, method = RequestMethod.GET)
    public String findPartidoesByTorneoEquipoLocalOrTorneoEquipoVisitanteAndStatusForm(Model uiModel) {
        uiModel.addAttribute("torneos", Torneo.findAllTorneos());
        uiModel.addAttribute("torneos", Torneo.findAllTorneos());
        uiModel.addAttribute("statuspartidoes", StatusPartido.findAllStatusPartidoes());
        return "partidoes/findPartidoesByTorneoEquipoLocalOrTorneoEquipoVisitanteAndStatus";
    }

	@RequestMapping(params = "find=ByTorneoEquipoLocalOrTorneoEquipoVisitanteAndStatus", method = RequestMethod.GET)
    public String findPartidoesByTorneoEquipoLocalOrTorneoEquipoVisitanteAndStatus(@RequestParam("torneoEquipoLocal") Torneo torneoEquipoLocal, @RequestParam("torneoEquipoVisitante") Torneo torneoEquipoVisitante, @RequestParam("status") StatusPartido status, @RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, @RequestParam(value = "sortFieldName", required = false) String sortFieldName, @RequestParam(value = "sortOrder", required = false) String sortOrder, Model uiModel) {
        if (page != null || size != null) {
            int sizeNo = size == null ? 10 : size.intValue();
            final int firstResult = page == null ? 0 : (page.intValue() - 1) * sizeNo;
            uiModel.addAttribute("partidoes", Partido.findPartidoesByTorneoEquipoLocalOrTorneoEquipoVisitanteAndStatus(torneoEquipoLocal, torneoEquipoVisitante, status, sortFieldName, sortOrder).setFirstResult(firstResult).setMaxResults(sizeNo).getResultList());
            float nrOfPages = (float) Partido.countFindPartidoesByTorneoEquipoLocalOrTorneoEquipoVisitanteAndStatus(torneoEquipoLocal, torneoEquipoVisitante, status) / sizeNo;
            uiModel.addAttribute("maxPages", (int) ((nrOfPages > (int) nrOfPages || nrOfPages == 0.0) ? nrOfPages + 1 : nrOfPages));
        } else {
            uiModel.addAttribute("partidoes", Partido.findPartidoesByTorneoEquipoLocalOrTorneoEquipoVisitanteAndStatus(torneoEquipoLocal, torneoEquipoVisitante, status, sortFieldName, sortOrder).getResultList());
        }
        addDateTimeFormatPatterns(uiModel);
        return "partidoes/list";
    }

	@RequestMapping(value = "/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
    @ResponseBody
    public ResponseEntity<String> showJson(@PathVariable("id") Long id) {
        Partido partido = Partido.findPartido(id);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json; charset=utf-8");
        if (partido == null) {
            return new ResponseEntity<String>(headers, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<String>(partido.toJson(), headers, HttpStatus.OK);
    }

	@RequestMapping(headers = "Accept=application/json")
    @ResponseBody
    public ResponseEntity<String> listJson() {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json; charset=utf-8");
        List<Partido> result = Partido.findAllPartidoes();
        return new ResponseEntity<String>(Partido.toJsonArray(result), headers, HttpStatus.OK);
    }

	@RequestMapping(method = RequestMethod.POST, headers = "Accept=application/json")
    public ResponseEntity<String> createFromJson(@RequestBody String json, UriComponentsBuilder uriBuilder) {
        Partido partido = Partido.fromJsonToPartido(json);
        partido.persist();
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        RequestMapping a = (RequestMapping) getClass().getAnnotation(RequestMapping.class);
        headers.add("Location",uriBuilder.path(a.value()[0]+"/"+partido.getId().toString()).build().toUriString());
        return new ResponseEntity<String>(headers, HttpStatus.CREATED);
    }

	@RequestMapping(value = "/jsonArray", method = RequestMethod.POST, headers = "Accept=application/json")
    public ResponseEntity<String> createFromJsonArray(@RequestBody String json) {
        for (Partido partido: Partido.fromJsonArrayToPartidoes(json)) {
            partido.persist();
        }
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        return new ResponseEntity<String>(headers, HttpStatus.CREATED);
    }

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, headers = "Accept=application/json")
    public ResponseEntity<String> updateFromJson(@RequestBody String json, @PathVariable("id") Long id) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        Partido partido = Partido.fromJsonToPartido(json);
        partido.setId(id);
        if (partido.merge() == null) {
            return new ResponseEntity<String>(headers, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<String>(headers, HttpStatus.OK);
    }

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
    public ResponseEntity<String> deleteFromJson(@PathVariable("id") Long id) {
        Partido partido = Partido.findPartido(id);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        if (partido == null) {
            return new ResponseEntity<String>(headers, HttpStatus.NOT_FOUND);
        }
        partido.remove();
        return new ResponseEntity<String>(headers, HttpStatus.OK);
    }

	@RequestMapping(params = "find=ByCancha", headers = "Accept=application/json")
    @ResponseBody
    public ResponseEntity<String> jsonFindPartidoesByCancha(@RequestParam("cancha") Cancha cancha) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json; charset=utf-8");
        return new ResponseEntity<String>(Partido.toJsonArray(Partido.findPartidoesByCancha(cancha).getResultList()), headers, HttpStatus.OK);
    }

	@RequestMapping(params = "find=ByCanchaAndStatus", headers = "Accept=application/json")
    @ResponseBody
    public ResponseEntity<String> jsonFindPartidoesByCanchaAndStatus(@RequestParam("cancha") Cancha cancha, @RequestParam("status") StatusPartido status) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json; charset=utf-8");
        return new ResponseEntity<String>(Partido.toJsonArray(Partido.findPartidoesByCanchaAndStatus(cancha, status).getResultList()), headers, HttpStatus.OK);
    }

	@RequestMapping(params = "find=ByCanchaAndStatusAndFechaJuegoBetween", headers = "Accept=application/json")
    @ResponseBody
    public ResponseEntity<String> jsonFindPartidoesByCanchaAndStatusAndFechaJuegoBetween(@RequestParam("cancha") Cancha cancha, @RequestParam("status") StatusPartido status, @RequestParam("minFechaJuego") @DateTimeFormat(style = "M-") Date minFechaJuego, @RequestParam("maxFechaJuego") @DateTimeFormat(style = "M-") Date maxFechaJuego) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json; charset=utf-8");
        return new ResponseEntity<String>(Partido.toJsonArray(Partido.findPartidoesByCanchaAndStatusAndFechaJuegoBetween(cancha, status, minFechaJuego, maxFechaJuego).getResultList()), headers, HttpStatus.OK);
    }

	@RequestMapping(params = "find=ByCanchaAndStatusAndFechaJuegoEquals", headers = "Accept=application/json")
    @ResponseBody
    public ResponseEntity<String> jsonFindPartidoesByCanchaAndStatusAndFechaJuegoEquals(@RequestParam("cancha") Cancha cancha, @RequestParam("status") StatusPartido status, @RequestParam("fechaJuego") @DateTimeFormat(style = "M-") Date fechaJuego) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json; charset=utf-8");
        return new ResponseEntity<String>(Partido.toJsonArray(Partido.findPartidoesByCanchaAndStatusAndFechaJuegoEquals(cancha, status, fechaJuego).getResultList()), headers, HttpStatus.OK);
    }

	@RequestMapping(params = "find=ByFechaJuegoBetweenAndStatus", headers = "Accept=application/json")
    @ResponseBody
    public ResponseEntity<String> jsonFindPartidoesByFechaJuegoBetweenAndStatus(@RequestParam("minFechaJuego") @DateTimeFormat(style = "M-") Date minFechaJuego, @RequestParam("maxFechaJuego") @DateTimeFormat(style = "M-") Date maxFechaJuego, @RequestParam("status") StatusPartido status) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json; charset=utf-8");
        return new ResponseEntity<String>(Partido.toJsonArray(Partido.findPartidoesByFechaJuegoBetweenAndStatus(minFechaJuego, maxFechaJuego, status).getResultList()), headers, HttpStatus.OK);
    }

	@RequestMapping(params = "find=ByFechaJuegoEqualsAndStatus", headers = "Accept=application/json")
    @ResponseBody
    public ResponseEntity<String> jsonFindPartidoesByFechaJuegoEqualsAndStatus(@RequestParam("fechaJuego") @DateTimeFormat(style = "M-") Date fechaJuego, @RequestParam("status") StatusPartido status) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json; charset=utf-8");
        return new ResponseEntity<String>(Partido.toJsonArray(Partido.findPartidoesByFechaJuegoEqualsAndStatus(fechaJuego, status).getResultList()), headers, HttpStatus.OK);
    }

	@RequestMapping(params = "find=ByTorneoEquipoLocalAndTorneoEquipoVisitanteAndEquipoLocalAndEquipoVisitante", headers = "Accept=application/json")
    @ResponseBody
    public ResponseEntity<String> jsonFindPartidoesByTorneoEquipoLocalAndTorneoEquipoVisitanteAndEquipoLocalAndEquipoVisitante(@RequestParam("torneoEquipoLocal") Torneo torneoEquipoLocal, @RequestParam("torneoEquipoVisitante") Torneo torneoEquipoVisitante, @RequestParam("equipoLocal") Equipo equipoLocal, @RequestParam("equipoVisitante") Equipo equipoVisitante) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json; charset=utf-8");
        return new ResponseEntity<String>(Partido.toJsonArray(Partido.findPartidoesByTorneoEquipoLocalAndTorneoEquipoVisitanteAndEquipoLocalAndEquipoVisitante(torneoEquipoLocal, torneoEquipoVisitante, equipoLocal, equipoVisitante).getResultList()), headers, HttpStatus.OK);
    }

	@RequestMapping(params = "find=ByTorneoEquipoLocalAndTorneoEquipoVisitanteAndEquipoLocalAndEquipoVisitanteAndStatus", headers = "Accept=application/json")
    @ResponseBody
    public ResponseEntity<String> jsonFindPartidoesByTorneoEquipoLocalAndTorneoEquipoVisitanteAndEquipoLocalAndEquipoVisitanteAndStatus(@RequestParam("torneoEquipoLocal") Torneo torneoEquipoLocal, @RequestParam("torneoEquipoVisitante") Torneo torneoEquipoVisitante, @RequestParam("equipoLocal") Equipo equipoLocal, @RequestParam("equipoVisitante") Equipo equipoVisitante, @RequestParam("status") StatusPartido status) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json; charset=utf-8");
        return new ResponseEntity<String>(Partido.toJsonArray(Partido.findPartidoesByTorneoEquipoLocalAndTorneoEquipoVisitanteAndEquipoLocalAndEquipoVisitanteAndStatus(torneoEquipoLocal, torneoEquipoVisitante, equipoLocal, equipoVisitante, status).getResultList()), headers, HttpStatus.OK);
    }

	@RequestMapping(params = "find=ByTorneoEquipoLocalOrTorneoEquipoVisitante", headers = "Accept=application/json")
    @ResponseBody
    public ResponseEntity<String> jsonFindPartidoesByTorneoEquipoLocalOrTorneoEquipoVisitante(@RequestParam("torneoEquipoLocal") Torneo torneoEquipoLocal, @RequestParam("torneoEquipoVisitante") Torneo torneoEquipoVisitante) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json; charset=utf-8");
        return new ResponseEntity<String>(Partido.toJsonArray(Partido.findPartidoesByTorneoEquipoLocalOrTorneoEquipoVisitante(torneoEquipoLocal, torneoEquipoVisitante).getResultList()), headers, HttpStatus.OK);
    }

	@RequestMapping(params = "find=ByTorneoEquipoLocalOrTorneoEquipoVisitanteAndEquipoLocalOrEquipoVisitante", headers = "Accept=application/json")
    @ResponseBody
    public ResponseEntity<String> jsonFindPartidoesByTorneoEquipoLocalOrTorneoEquipoVisitanteAndEquipoLocalOrEquipoVisitante(@RequestParam("torneoEquipoLocal") Torneo torneoEquipoLocal, @RequestParam("torneoEquipoVisitante") Torneo torneoEquipoVisitante, @RequestParam("equipoLocal") Equipo equipoLocal, @RequestParam("equipoVisitante") Equipo equipoVisitante) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json; charset=utf-8");
        return new ResponseEntity<String>(Partido.toJsonArray(Partido.findPartidoesByTorneoEquipoLocalOrTorneoEquipoVisitanteAndEquipoLocalOrEquipoVisitante(torneoEquipoLocal, torneoEquipoVisitante, equipoLocal, equipoVisitante).getResultList()), headers, HttpStatus.OK);
    }

	@RequestMapping(params = "find=ByTorneoEquipoLocalOrTorneoEquipoVisitanteAndEquipoLocalOrEquipoVisitanteAndStatus", headers = "Accept=application/json")
    @ResponseBody
    public ResponseEntity<String> jsonFindPartidoesByTorneoEquipoLocalOrTorneoEquipoVisitanteAndEquipoLocalOrEquipoVisitanteAndStatus(@RequestParam("torneoEquipoLocal") Torneo torneoEquipoLocal, @RequestParam("torneoEquipoVisitante") Torneo torneoEquipoVisitante, @RequestParam("equipoLocal") Equipo equipoLocal, @RequestParam("equipoVisitante") Equipo equipoVisitante, @RequestParam("status") StatusPartido status) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json; charset=utf-8");
        return new ResponseEntity<String>(Partido.toJsonArray(Partido.findPartidoesByTorneoEquipoLocalOrTorneoEquipoVisitanteAndEquipoLocalOrEquipoVisitanteAndStatus(torneoEquipoLocal, torneoEquipoVisitante, equipoLocal, equipoVisitante, status).getResultList()), headers, HttpStatus.OK);
    }

	@RequestMapping(params = "find=ByTorneoEquipoLocalOrTorneoEquipoVisitanteAndStatus", headers = "Accept=application/json")
    @ResponseBody
    public ResponseEntity<String> jsonFindPartidoesByTorneoEquipoLocalOrTorneoEquipoVisitanteAndStatus(@RequestParam("torneoEquipoLocal") Torneo torneoEquipoLocal, @RequestParam("torneoEquipoVisitante") Torneo torneoEquipoVisitante, @RequestParam("status") StatusPartido status) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json; charset=utf-8");
        return new ResponseEntity<String>(Partido.toJsonArray(Partido.findPartidoesByTorneoEquipoLocalOrTorneoEquipoVisitanteAndStatus(torneoEquipoLocal, torneoEquipoVisitante, status).getResultList()), headers, HttpStatus.OK);
    }
}
