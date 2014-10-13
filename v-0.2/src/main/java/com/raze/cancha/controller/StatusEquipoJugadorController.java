package com.raze.cancha.controller;
import com.raze.cancha.catalog.StatusEquipoJugador;
import com.raze.cancha.domain.Usuario;
import java.io.UnsupportedEncodingException;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.joda.time.format.DateTimeFormat;
import org.springframework.context.i18n.LocaleContextHolder;
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

@RooWebJson(jsonObject = StatusEquipoJugador.class)
@Controller
@RequestMapping("/statusequipojugadors")
@RooWebScaffold(path = "statusequipojugadors", formBackingObject = StatusEquipoJugador.class)
@RooWebFinder
public class StatusEquipoJugadorController {

	@RequestMapping(method = RequestMethod.POST, produces = "text/html")
    public String create(@Valid StatusEquipoJugador statusEquipoJugador, BindingResult bindingResult, Model uiModel, HttpServletRequest httpServletRequest) {
        if (bindingResult.hasErrors()) {
            populateEditForm(uiModel, statusEquipoJugador);
            return "statusequipojugadors/create";
        }
        uiModel.asMap().clear();
        statusEquipoJugador.persist();
        return "redirect:/statusequipojugadors/" + encodeUrlPathSegment(statusEquipoJugador.getId().toString(), httpServletRequest);
    }

	@RequestMapping(params = "form", produces = "text/html")
    public String createForm(Model uiModel) {
        populateEditForm(uiModel, new StatusEquipoJugador());
        return "statusequipojugadors/create";
    }

	@RequestMapping(value = "/{id}", produces = "text/html")
    public String show(@PathVariable("id") Long id, Model uiModel) {
        addDateTimeFormatPatterns(uiModel);
        uiModel.addAttribute("statusequipojugador", StatusEquipoJugador.findStatusEquipoJugador(id));
        uiModel.addAttribute("itemId", id);
        return "statusequipojugadors/show";
    }

	@RequestMapping(produces = "text/html")
    public String list(@RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, @RequestParam(value = "sortFieldName", required = false) String sortFieldName, @RequestParam(value = "sortOrder", required = false) String sortOrder, Model uiModel) {
        if (page != null || size != null) {
            int sizeNo = size == null ? 10 : size.intValue();
            final int firstResult = page == null ? 0 : (page.intValue() - 1) * sizeNo;
            uiModel.addAttribute("statusequipojugadors", StatusEquipoJugador.findStatusEquipoJugadorEntries(firstResult, sizeNo, sortFieldName, sortOrder));
            float nrOfPages = (float) StatusEquipoJugador.countStatusEquipoJugadors() / sizeNo;
            uiModel.addAttribute("maxPages", (int) ((nrOfPages > (int) nrOfPages || nrOfPages == 0.0) ? nrOfPages + 1 : nrOfPages));
        } else {
            uiModel.addAttribute("statusequipojugadors", StatusEquipoJugador.findAllStatusEquipoJugadors(sortFieldName, sortOrder));
        }
        addDateTimeFormatPatterns(uiModel);
        return "statusequipojugadors/list";
    }

	@RequestMapping(method = RequestMethod.PUT, produces = "text/html")
    public String update(@Valid StatusEquipoJugador statusEquipoJugador, BindingResult bindingResult, Model uiModel, HttpServletRequest httpServletRequest) {
        if (bindingResult.hasErrors()) {
            populateEditForm(uiModel, statusEquipoJugador);
            return "statusequipojugadors/update";
        }
        uiModel.asMap().clear();
        statusEquipoJugador.merge();
        return "redirect:/statusequipojugadors/" + encodeUrlPathSegment(statusEquipoJugador.getId().toString(), httpServletRequest);
    }

	@RequestMapping(value = "/{id}", params = "form", produces = "text/html")
    public String updateForm(@PathVariable("id") Long id, Model uiModel) {
        populateEditForm(uiModel, StatusEquipoJugador.findStatusEquipoJugador(id));
        return "statusequipojugadors/update";
    }

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = "text/html")
    public String delete(@PathVariable("id") Long id, @RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, Model uiModel) {
        StatusEquipoJugador statusEquipoJugador = StatusEquipoJugador.findStatusEquipoJugador(id);
        statusEquipoJugador.remove();
        uiModel.asMap().clear();
        uiModel.addAttribute("page", (page == null) ? "1" : page.toString());
        uiModel.addAttribute("size", (size == null) ? "10" : size.toString());
        return "redirect:/statusequipojugadors";
    }

	void addDateTimeFormatPatterns(Model uiModel) {
        uiModel.addAttribute("statusEquipoJugador_fechacreacion_date_format", DateTimeFormat.patternForStyle("M-", LocaleContextHolder.getLocale()));
        uiModel.addAttribute("statusEquipoJugador_fechamodificacion_date_format", DateTimeFormat.patternForStyle("M-", LocaleContextHolder.getLocale()));
    }

	void populateEditForm(Model uiModel, StatusEquipoJugador statusEquipoJugador) {
        uiModel.addAttribute("statusEquipoJugador", statusEquipoJugador);
        addDateTimeFormatPatterns(uiModel);
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

	@RequestMapping(params = { "find=ByActivo", "form" }, method = RequestMethod.GET)
    public String findStatusEquipoJugadorsByActivoForm(Model uiModel) {
        return "statusequipojugadors/findStatusEquipoJugadorsByActivo";
    }

	@RequestMapping(params = "find=ByActivo", method = RequestMethod.GET)
    public String findStatusEquipoJugadorsByActivo(@RequestParam(value = "activo", required = false) Boolean activo, @RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, @RequestParam(value = "sortFieldName", required = false) String sortFieldName, @RequestParam(value = "sortOrder", required = false) String sortOrder, Model uiModel) {
        if (page != null || size != null) {
            int sizeNo = size == null ? 10 : size.intValue();
            final int firstResult = page == null ? 0 : (page.intValue() - 1) * sizeNo;
            uiModel.addAttribute("statusequipojugadors", StatusEquipoJugador.findStatusEquipoJugadorsByActivo(activo == null ? Boolean.FALSE : activo, sortFieldName, sortOrder).setFirstResult(firstResult).setMaxResults(sizeNo).getResultList());
            float nrOfPages = (float) StatusEquipoJugador.countFindStatusEquipoJugadorsByActivo(activo == null ? Boolean.FALSE : activo) / sizeNo;
            uiModel.addAttribute("maxPages", (int) ((nrOfPages > (int) nrOfPages || nrOfPages == 0.0) ? nrOfPages + 1 : nrOfPages));
        } else {
            uiModel.addAttribute("statusequipojugadors", StatusEquipoJugador.findStatusEquipoJugadorsByActivo(activo == null ? Boolean.FALSE : activo, sortFieldName, sortOrder).getResultList());
        }
        addDateTimeFormatPatterns(uiModel);
        return "statusequipojugadors/list";
    }

	@RequestMapping(value = "/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
    @ResponseBody
    public ResponseEntity<String> showJson(@PathVariable("id") Long id) {
        StatusEquipoJugador statusEquipoJugador = StatusEquipoJugador.findStatusEquipoJugador(id);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json; charset=utf-8");
        if (statusEquipoJugador == null) {
            return new ResponseEntity<String>(headers, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<String>(statusEquipoJugador.toJson(), headers, HttpStatus.OK);
    }

	@RequestMapping(headers = "Accept=application/json")
    @ResponseBody
    public ResponseEntity<String> listJson() {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json; charset=utf-8");
        List<StatusEquipoJugador> result = StatusEquipoJugador.findAllStatusEquipoJugadors();
        return new ResponseEntity<String>(StatusEquipoJugador.toJsonArray(result), headers, HttpStatus.OK);
    }

	@RequestMapping(method = RequestMethod.POST, headers = "Accept=application/json")
    public ResponseEntity<String> createFromJson(@RequestBody String json, UriComponentsBuilder uriBuilder) {
        StatusEquipoJugador statusEquipoJugador = StatusEquipoJugador.fromJsonToStatusEquipoJugador(json);
        statusEquipoJugador.persist();
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        RequestMapping a = (RequestMapping) getClass().getAnnotation(RequestMapping.class);
        headers.add("Location",uriBuilder.path(a.value()[0]+"/"+statusEquipoJugador.getId().toString()).build().toUriString());
        return new ResponseEntity<String>(headers, HttpStatus.CREATED);
    }

	@RequestMapping(value = "/jsonArray", method = RequestMethod.POST, headers = "Accept=application/json")
    public ResponseEntity<String> createFromJsonArray(@RequestBody String json) {
        for (StatusEquipoJugador statusEquipoJugador: StatusEquipoJugador.fromJsonArrayToStatusEquipoJugadors(json)) {
            statusEquipoJugador.persist();
        }
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        return new ResponseEntity<String>(headers, HttpStatus.CREATED);
    }

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, headers = "Accept=application/json")
    public ResponseEntity<String> updateFromJson(@RequestBody String json, @PathVariable("id") Long id) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        StatusEquipoJugador statusEquipoJugador = StatusEquipoJugador.fromJsonToStatusEquipoJugador(json);
        statusEquipoJugador.setId(id);
        if (statusEquipoJugador.merge() == null) {
            return new ResponseEntity<String>(headers, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<String>(headers, HttpStatus.OK);
    }

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
    public ResponseEntity<String> deleteFromJson(@PathVariable("id") Long id) {
        StatusEquipoJugador statusEquipoJugador = StatusEquipoJugador.findStatusEquipoJugador(id);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        if (statusEquipoJugador == null) {
            return new ResponseEntity<String>(headers, HttpStatus.NOT_FOUND);
        }
        statusEquipoJugador.remove();
        return new ResponseEntity<String>(headers, HttpStatus.OK);
    }

	@RequestMapping(params = "find=ByActivo", headers = "Accept=application/json")
    @ResponseBody
    public ResponseEntity<String> jsonFindStatusEquipoJugadorsByActivo(@RequestParam(value = "activo", required = false) Boolean activo) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json; charset=utf-8");
        return new ResponseEntity<String>(StatusEquipoJugador.toJsonArray(StatusEquipoJugador.findStatusEquipoJugadorsByActivo(activo == null ? Boolean.FALSE : activo).getResultList()), headers, HttpStatus.OK);
    }
}
