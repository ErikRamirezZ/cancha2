package com.raze.cancha.controller;
import com.raze.cancha.domain.Alineacion;
import com.raze.cancha.domain.Jugador;
import com.raze.cancha.domain.Partido;
import com.raze.cancha.domain.Usuario;
import java.io.UnsupportedEncodingException;
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

@RooWebJson(jsonObject = Alineacion.class)
@Controller
@RequestMapping("/alineacions")
@RooWebScaffold(path = "alineacions", formBackingObject = Alineacion.class)
@RooWebFinder
public class AlineacionController {

	@RequestMapping(value = "/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
    @ResponseBody
    public ResponseEntity<String> showJson(@PathVariable("id") Long id) {
        Alineacion alineacion = Alineacion.findAlineacion(id);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json; charset=utf-8");
        if (alineacion == null) {
            return new ResponseEntity<String>(headers, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<String>(alineacion.toJson(), headers, HttpStatus.OK);
    }

	@RequestMapping(headers = "Accept=application/json")
    @ResponseBody
    public ResponseEntity<String> listJson() {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json; charset=utf-8");
        List<Alineacion> result = Alineacion.findAllAlineacions();
        return new ResponseEntity<String>(Alineacion.toJsonArray(result), headers, HttpStatus.OK);
    }

	@RequestMapping(method = RequestMethod.POST, headers = "Accept=application/json")
    public ResponseEntity<String> createFromJson(@RequestBody String json, UriComponentsBuilder uriBuilder) {
        Alineacion alineacion = Alineacion.fromJsonToAlineacion(json);
        alineacion.persist();
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        RequestMapping a = (RequestMapping) getClass().getAnnotation(RequestMapping.class);
        headers.add("Location",uriBuilder.path(a.value()[0]+"/"+alineacion.getId().toString()).build().toUriString());
        return new ResponseEntity<String>(headers, HttpStatus.CREATED);
    }

	@RequestMapping(value = "/jsonArray", method = RequestMethod.POST, headers = "Accept=application/json")
    public ResponseEntity<String> createFromJsonArray(@RequestBody String json) {
        for (Alineacion alineacion: Alineacion.fromJsonArrayToAlineacions(json)) {
            alineacion.persist();
        }
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        return new ResponseEntity<String>(headers, HttpStatus.CREATED);
    }

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, headers = "Accept=application/json")
    public ResponseEntity<String> updateFromJson(@RequestBody String json, @PathVariable("id") Long id) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        Alineacion alineacion = Alineacion.fromJsonToAlineacion(json);
        alineacion.setId(id);
        if (alineacion.merge() == null) {
            return new ResponseEntity<String>(headers, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<String>(headers, HttpStatus.OK);
    }

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
    public ResponseEntity<String> deleteFromJson(@PathVariable("id") Long id) {
        Alineacion alineacion = Alineacion.findAlineacion(id);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        if (alineacion == null) {
            return new ResponseEntity<String>(headers, HttpStatus.NOT_FOUND);
        }
        alineacion.remove();
        return new ResponseEntity<String>(headers, HttpStatus.OK);
    }

	@RequestMapping(params = "find=ByJugador", headers = "Accept=application/json")
    @ResponseBody
    public ResponseEntity<String> jsonFindAlineacionsByJugador(@RequestParam("jugador") Jugador jugador) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json; charset=utf-8");
        return new ResponseEntity<String>(Alineacion.toJsonArray(Alineacion.findAlineacionsByJugador(jugador).getResultList()), headers, HttpStatus.OK);
    }

	@RequestMapping(params = "find=ByJugadorAndFechaCreacionBetween", headers = "Accept=application/json")
    @ResponseBody
    public ResponseEntity<String> jsonFindAlineacionsByJugadorAndFechaCreacionBetween(@RequestParam("jugador") Jugador jugador, @RequestParam("minFechaCreacion") @DateTimeFormat(style = "M-") Date minFechaCreacion, @RequestParam("maxFechaCreacion") @DateTimeFormat(style = "M-") Date maxFechaCreacion) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json; charset=utf-8");
        return new ResponseEntity<String>(Alineacion.toJsonArray(Alineacion.findAlineacionsByJugadorAndFechaCreacionBetween(jugador, minFechaCreacion, maxFechaCreacion).getResultList()), headers, HttpStatus.OK);
    }

	@RequestMapping(params = "find=ByPartido", headers = "Accept=application/json")
    @ResponseBody
    public ResponseEntity<String> jsonFindAlineacionsByPartido(@RequestParam("partido") Partido partido) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json; charset=utf-8");
        return new ResponseEntity<String>(Alineacion.toJsonArray(Alineacion.findAlineacionsByPartido(partido).getResultList()), headers, HttpStatus.OK);
    }

	@RequestMapping(params = "find=ByPartidoAndFechaCreacionBetween", headers = "Accept=application/json")
    @ResponseBody
    public ResponseEntity<String> jsonFindAlineacionsByPartidoAndFechaCreacionBetween(@RequestParam("partido") Partido partido, @RequestParam("minFechaCreacion") @DateTimeFormat(style = "M-") Date minFechaCreacion, @RequestParam("maxFechaCreacion") @DateTimeFormat(style = "M-") Date maxFechaCreacion) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json; charset=utf-8");
        return new ResponseEntity<String>(Alineacion.toJsonArray(Alineacion.findAlineacionsByPartidoAndFechaCreacionBetween(partido, minFechaCreacion, maxFechaCreacion).getResultList()), headers, HttpStatus.OK);
    }

	@RequestMapping(params = { "find=ByJugador", "form" }, method = RequestMethod.GET)
    public String findAlineacionsByJugadorForm(Model uiModel) {
        uiModel.addAttribute("jugadors", Jugador.findAllJugadors());
        return "alineacions/findAlineacionsByJugador";
    }

	@RequestMapping(params = "find=ByJugador", method = RequestMethod.GET)
    public String findAlineacionsByJugador(@RequestParam("jugador") Jugador jugador, @RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, @RequestParam(value = "sortFieldName", required = false) String sortFieldName, @RequestParam(value = "sortOrder", required = false) String sortOrder, Model uiModel) {
        if (page != null || size != null) {
            int sizeNo = size == null ? 10 : size.intValue();
            final int firstResult = page == null ? 0 : (page.intValue() - 1) * sizeNo;
            uiModel.addAttribute("alineacions", Alineacion.findAlineacionsByJugador(jugador, sortFieldName, sortOrder).setFirstResult(firstResult).setMaxResults(sizeNo).getResultList());
            float nrOfPages = (float) Alineacion.countFindAlineacionsByJugador(jugador) / sizeNo;
            uiModel.addAttribute("maxPages", (int) ((nrOfPages > (int) nrOfPages || nrOfPages == 0.0) ? nrOfPages + 1 : nrOfPages));
        } else {
            uiModel.addAttribute("alineacions", Alineacion.findAlineacionsByJugador(jugador, sortFieldName, sortOrder).getResultList());
        }
        addDateTimeFormatPatterns(uiModel);
        return "alineacions/list";
    }

	@RequestMapping(params = { "find=ByJugadorAndFechaCreacionBetween", "form" }, method = RequestMethod.GET)
    public String findAlineacionsByJugadorAndFechaCreacionBetweenForm(Model uiModel) {
        uiModel.addAttribute("jugadors", Jugador.findAllJugadors());
        addDateTimeFormatPatterns(uiModel);
        return "alineacions/findAlineacionsByJugadorAndFechaCreacionBetween";
    }

	@RequestMapping(params = "find=ByJugadorAndFechaCreacionBetween", method = RequestMethod.GET)
    public String findAlineacionsByJugadorAndFechaCreacionBetween(@RequestParam("jugador") Jugador jugador, @RequestParam("minFechaCreacion") @DateTimeFormat(style = "M-") Date minFechaCreacion, @RequestParam("maxFechaCreacion") @DateTimeFormat(style = "M-") Date maxFechaCreacion, @RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, @RequestParam(value = "sortFieldName", required = false) String sortFieldName, @RequestParam(value = "sortOrder", required = false) String sortOrder, Model uiModel) {
        if (page != null || size != null) {
            int sizeNo = size == null ? 10 : size.intValue();
            final int firstResult = page == null ? 0 : (page.intValue() - 1) * sizeNo;
            uiModel.addAttribute("alineacions", Alineacion.findAlineacionsByJugadorAndFechaCreacionBetween(jugador, minFechaCreacion, maxFechaCreacion, sortFieldName, sortOrder).setFirstResult(firstResult).setMaxResults(sizeNo).getResultList());
            float nrOfPages = (float) Alineacion.countFindAlineacionsByJugadorAndFechaCreacionBetween(jugador, minFechaCreacion, maxFechaCreacion) / sizeNo;
            uiModel.addAttribute("maxPages", (int) ((nrOfPages > (int) nrOfPages || nrOfPages == 0.0) ? nrOfPages + 1 : nrOfPages));
        } else {
            uiModel.addAttribute("alineacions", Alineacion.findAlineacionsByJugadorAndFechaCreacionBetween(jugador, minFechaCreacion, maxFechaCreacion, sortFieldName, sortOrder).getResultList());
        }
        addDateTimeFormatPatterns(uiModel);
        return "alineacions/list";
    }

	@RequestMapping(params = { "find=ByPartido", "form" }, method = RequestMethod.GET)
    public String findAlineacionsByPartidoForm(Model uiModel) {
        uiModel.addAttribute("partidoes", Partido.findAllPartidoes());
        return "alineacions/findAlineacionsByPartido";
    }

	@RequestMapping(params = "find=ByPartido", method = RequestMethod.GET)
    public String findAlineacionsByPartido(@RequestParam("partido") Partido partido, @RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, @RequestParam(value = "sortFieldName", required = false) String sortFieldName, @RequestParam(value = "sortOrder", required = false) String sortOrder, Model uiModel) {
        if (page != null || size != null) {
            int sizeNo = size == null ? 10 : size.intValue();
            final int firstResult = page == null ? 0 : (page.intValue() - 1) * sizeNo;
            uiModel.addAttribute("alineacions", Alineacion.findAlineacionsByPartido(partido, sortFieldName, sortOrder).setFirstResult(firstResult).setMaxResults(sizeNo).getResultList());
            float nrOfPages = (float) Alineacion.countFindAlineacionsByPartido(partido) / sizeNo;
            uiModel.addAttribute("maxPages", (int) ((nrOfPages > (int) nrOfPages || nrOfPages == 0.0) ? nrOfPages + 1 : nrOfPages));
        } else {
            uiModel.addAttribute("alineacions", Alineacion.findAlineacionsByPartido(partido, sortFieldName, sortOrder).getResultList());
        }
        addDateTimeFormatPatterns(uiModel);
        return "alineacions/list";
    }

	@RequestMapping(params = { "find=ByPartidoAndFechaCreacionBetween", "form" }, method = RequestMethod.GET)
    public String findAlineacionsByPartidoAndFechaCreacionBetweenForm(Model uiModel) {
        uiModel.addAttribute("partidoes", Partido.findAllPartidoes());
        addDateTimeFormatPatterns(uiModel);
        return "alineacions/findAlineacionsByPartidoAndFechaCreacionBetween";
    }

	@RequestMapping(params = "find=ByPartidoAndFechaCreacionBetween", method = RequestMethod.GET)
    public String findAlineacionsByPartidoAndFechaCreacionBetween(@RequestParam("partido") Partido partido, @RequestParam("minFechaCreacion") @DateTimeFormat(style = "M-") Date minFechaCreacion, @RequestParam("maxFechaCreacion") @DateTimeFormat(style = "M-") Date maxFechaCreacion, @RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, @RequestParam(value = "sortFieldName", required = false) String sortFieldName, @RequestParam(value = "sortOrder", required = false) String sortOrder, Model uiModel) {
        if (page != null || size != null) {
            int sizeNo = size == null ? 10 : size.intValue();
            final int firstResult = page == null ? 0 : (page.intValue() - 1) * sizeNo;
            uiModel.addAttribute("alineacions", Alineacion.findAlineacionsByPartidoAndFechaCreacionBetween(partido, minFechaCreacion, maxFechaCreacion, sortFieldName, sortOrder).setFirstResult(firstResult).setMaxResults(sizeNo).getResultList());
            float nrOfPages = (float) Alineacion.countFindAlineacionsByPartidoAndFechaCreacionBetween(partido, minFechaCreacion, maxFechaCreacion) / sizeNo;
            uiModel.addAttribute("maxPages", (int) ((nrOfPages > (int) nrOfPages || nrOfPages == 0.0) ? nrOfPages + 1 : nrOfPages));
        } else {
            uiModel.addAttribute("alineacions", Alineacion.findAlineacionsByPartidoAndFechaCreacionBetween(partido, minFechaCreacion, maxFechaCreacion, sortFieldName, sortOrder).getResultList());
        }
        addDateTimeFormatPatterns(uiModel);
        return "alineacions/list";
    }

	@RequestMapping(method = RequestMethod.POST, produces = "text/html")
    public String create(@Valid Alineacion alineacion, BindingResult bindingResult, Model uiModel, HttpServletRequest httpServletRequest) {
        if (bindingResult.hasErrors()) {
            populateEditForm(uiModel, alineacion);
            return "alineacions/create";
        }
        uiModel.asMap().clear();
        alineacion.persist();
        return "redirect:/alineacions/" + encodeUrlPathSegment(alineacion.getId().toString(), httpServletRequest);
    }

	@RequestMapping(params = "form", produces = "text/html")
    public String createForm(Model uiModel) {
        populateEditForm(uiModel, new Alineacion());
        return "alineacions/create";
    }

	@RequestMapping(value = "/{id}", produces = "text/html")
    public String show(@PathVariable("id") Long id, Model uiModel) {
        addDateTimeFormatPatterns(uiModel);
        uiModel.addAttribute("alineacion", Alineacion.findAlineacion(id));
        uiModel.addAttribute("itemId", id);
        return "alineacions/show";
    }

	@RequestMapping(produces = "text/html")
    public String list(@RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, @RequestParam(value = "sortFieldName", required = false) String sortFieldName, @RequestParam(value = "sortOrder", required = false) String sortOrder, Model uiModel) {
        if (page != null || size != null) {
            int sizeNo = size == null ? 10 : size.intValue();
            final int firstResult = page == null ? 0 : (page.intValue() - 1) * sizeNo;
            uiModel.addAttribute("alineacions", Alineacion.findAlineacionEntries(firstResult, sizeNo, sortFieldName, sortOrder));
            float nrOfPages = (float) Alineacion.countAlineacions() / sizeNo;
            uiModel.addAttribute("maxPages", (int) ((nrOfPages > (int) nrOfPages || nrOfPages == 0.0) ? nrOfPages + 1 : nrOfPages));
        } else {
            uiModel.addAttribute("alineacions", Alineacion.findAllAlineacions(sortFieldName, sortOrder));
        }
        addDateTimeFormatPatterns(uiModel);
        return "alineacions/list";
    }

	@RequestMapping(method = RequestMethod.PUT, produces = "text/html")
    public String update(@Valid Alineacion alineacion, BindingResult bindingResult, Model uiModel, HttpServletRequest httpServletRequest) {
        if (bindingResult.hasErrors()) {
            populateEditForm(uiModel, alineacion);
            return "alineacions/update";
        }
        uiModel.asMap().clear();
        alineacion.merge();
        return "redirect:/alineacions/" + encodeUrlPathSegment(alineacion.getId().toString(), httpServletRequest);
    }

	@RequestMapping(value = "/{id}", params = "form", produces = "text/html")
    public String updateForm(@PathVariable("id") Long id, Model uiModel) {
        populateEditForm(uiModel, Alineacion.findAlineacion(id));
        return "alineacions/update";
    }

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = "text/html")
    public String delete(@PathVariable("id") Long id, @RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, Model uiModel) {
        Alineacion alineacion = Alineacion.findAlineacion(id);
        alineacion.remove();
        uiModel.asMap().clear();
        uiModel.addAttribute("page", (page == null) ? "1" : page.toString());
        uiModel.addAttribute("size", (size == null) ? "10" : size.toString());
        return "redirect:/alineacions";
    }

	void addDateTimeFormatPatterns(Model uiModel) {
        uiModel.addAttribute("alineacion_fechacreacion_date_format", org.joda.time.format.DateTimeFormat.patternForStyle("M-", LocaleContextHolder.getLocale()));
        uiModel.addAttribute("alineacion_fechamodificacion_date_format", org.joda.time.format.DateTimeFormat.patternForStyle("M-", LocaleContextHolder.getLocale()));
    }

	void populateEditForm(Model uiModel, Alineacion alineacion) {
        uiModel.addAttribute("alineacion", alineacion);
        addDateTimeFormatPatterns(uiModel);
        uiModel.addAttribute("jugadors", Jugador.findAllJugadors());
        uiModel.addAttribute("partidoes", Partido.findAllPartidoes());
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
}
