package com.raze.cancha.controller;
import com.raze.cancha.catalog.Accion;
import com.raze.cancha.domain.Alineacion;
import com.raze.cancha.domain.Estadisticas;
import com.raze.cancha.domain.Usuario;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
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

@RooWebJson(jsonObject = Estadisticas.class)
@Controller
@RequestMapping("/estadisticases")
@RooWebScaffold(path = "estadisticases", formBackingObject = Estadisticas.class)
@RooWebFinder
public class EstadisticasController {

	@RequestMapping(params = { "find=ByAccion", "form" }, method = RequestMethod.GET)
    public String findEstadisticasesByAccionForm(Model uiModel) {
        uiModel.addAttribute("accions", Accion.findAllAccions());
        return "estadisticases/findEstadisticasesByAccion";
    }

	@RequestMapping(params = "find=ByAccion", method = RequestMethod.GET)
    public String findEstadisticasesByAccion(@RequestParam("accion") Accion accion, @RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, @RequestParam(value = "sortFieldName", required = false) String sortFieldName, @RequestParam(value = "sortOrder", required = false) String sortOrder, Model uiModel) {
        if (page != null || size != null) {
            int sizeNo = size == null ? 10 : size.intValue();
            final int firstResult = page == null ? 0 : (page.intValue() - 1) * sizeNo;
            uiModel.addAttribute("estadisticases", Estadisticas.findEstadisticasesByAccion(accion, sortFieldName, sortOrder).setFirstResult(firstResult).setMaxResults(sizeNo).getResultList());
            float nrOfPages = (float) Estadisticas.countFindEstadisticasesByAccion(accion) / sizeNo;
            uiModel.addAttribute("maxPages", (int) ((nrOfPages > (int) nrOfPages || nrOfPages == 0.0) ? nrOfPages + 1 : nrOfPages));
        } else {
            uiModel.addAttribute("estadisticases", Estadisticas.findEstadisticasesByAccion(accion, sortFieldName, sortOrder).getResultList());
        }
        addDateTimeFormatPatterns(uiModel);
        return "estadisticases/list";
    }

	@RequestMapping(params = { "find=ByAlineacion", "form" }, method = RequestMethod.GET)
    public String findEstadisticasesByAlineacionForm(Model uiModel) {
        uiModel.addAttribute("alineacions", Alineacion.findAllAlineacions());
        return "estadisticases/findEstadisticasesByAlineacion";
    }

	@RequestMapping(params = "find=ByAlineacion", method = RequestMethod.GET)
    public String findEstadisticasesByAlineacion(@RequestParam("alineacion") Alineacion alineacion, @RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, @RequestParam(value = "sortFieldName", required = false) String sortFieldName, @RequestParam(value = "sortOrder", required = false) String sortOrder, Model uiModel) {
        if (page != null || size != null) {
            int sizeNo = size == null ? 10 : size.intValue();
            final int firstResult = page == null ? 0 : (page.intValue() - 1) * sizeNo;
            uiModel.addAttribute("estadisticases", Estadisticas.findEstadisticasesByAlineacion(alineacion, sortFieldName, sortOrder).setFirstResult(firstResult).setMaxResults(sizeNo).getResultList());
            float nrOfPages = (float) Estadisticas.countFindEstadisticasesByAlineacion(alineacion) / sizeNo;
            uiModel.addAttribute("maxPages", (int) ((nrOfPages > (int) nrOfPages || nrOfPages == 0.0) ? nrOfPages + 1 : nrOfPages));
        } else {
            uiModel.addAttribute("estadisticases", Estadisticas.findEstadisticasesByAlineacion(alineacion, sortFieldName, sortOrder).getResultList());
        }
        addDateTimeFormatPatterns(uiModel);
        return "estadisticases/list";
    }

	@RequestMapping(method = RequestMethod.POST, produces = "text/html")
    public String create(@Valid Estadisticas estadisticas, BindingResult bindingResult, Model uiModel, HttpServletRequest httpServletRequest) {
        if (bindingResult.hasErrors()) {
            populateEditForm(uiModel, estadisticas);
            return "estadisticases/create";
        }
        uiModel.asMap().clear();
        estadisticas.persist();
        return "redirect:/estadisticases/" + encodeUrlPathSegment(estadisticas.getId().toString(), httpServletRequest);
    }

	@RequestMapping(params = "form", produces = "text/html")
    public String createForm(Model uiModel) {
        populateEditForm(uiModel, new Estadisticas());
        List<String[]> dependencies = new ArrayList<String[]>();
        if (Alineacion.countAlineacions() == 0) {
            dependencies.add(new String[] { "alineacion", "alineacions" });
        }
        if (Accion.countAccions() == 0) {
            dependencies.add(new String[] { "accion", "accions" });
        }
        uiModel.addAttribute("dependencies", dependencies);
        return "estadisticases/create";
    }

	@RequestMapping(value = "/{id}", produces = "text/html")
    public String show(@PathVariable("id") Long id, Model uiModel) {
        addDateTimeFormatPatterns(uiModel);
        uiModel.addAttribute("estadisticas", Estadisticas.findEstadisticas(id));
        uiModel.addAttribute("itemId", id);
        return "estadisticases/show";
    }

	@RequestMapping(produces = "text/html")
    public String list(@RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, @RequestParam(value = "sortFieldName", required = false) String sortFieldName, @RequestParam(value = "sortOrder", required = false) String sortOrder, Model uiModel) {
        if (page != null || size != null) {
            int sizeNo = size == null ? 10 : size.intValue();
            final int firstResult = page == null ? 0 : (page.intValue() - 1) * sizeNo;
            uiModel.addAttribute("estadisticases", Estadisticas.findEstadisticasEntries(firstResult, sizeNo, sortFieldName, sortOrder));
            float nrOfPages = (float) Estadisticas.countEstadisticases() / sizeNo;
            uiModel.addAttribute("maxPages", (int) ((nrOfPages > (int) nrOfPages || nrOfPages == 0.0) ? nrOfPages + 1 : nrOfPages));
        } else {
            uiModel.addAttribute("estadisticases", Estadisticas.findAllEstadisticases(sortFieldName, sortOrder));
        }
        addDateTimeFormatPatterns(uiModel);
        return "estadisticases/list";
    }

	@RequestMapping(method = RequestMethod.PUT, produces = "text/html")
    public String update(@Valid Estadisticas estadisticas, BindingResult bindingResult, Model uiModel, HttpServletRequest httpServletRequest) {
        if (bindingResult.hasErrors()) {
            populateEditForm(uiModel, estadisticas);
            return "estadisticases/update";
        }
        uiModel.asMap().clear();
        estadisticas.merge();
        return "redirect:/estadisticases/" + encodeUrlPathSegment(estadisticas.getId().toString(), httpServletRequest);
    }

	@RequestMapping(value = "/{id}", params = "form", produces = "text/html")
    public String updateForm(@PathVariable("id") Long id, Model uiModel) {
        populateEditForm(uiModel, Estadisticas.findEstadisticas(id));
        return "estadisticases/update";
    }

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = "text/html")
    public String delete(@PathVariable("id") Long id, @RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, Model uiModel) {
        Estadisticas estadisticas = Estadisticas.findEstadisticas(id);
        estadisticas.remove();
        uiModel.asMap().clear();
        uiModel.addAttribute("page", (page == null) ? "1" : page.toString());
        uiModel.addAttribute("size", (size == null) ? "10" : size.toString());
        return "redirect:/estadisticases";
    }

	void addDateTimeFormatPatterns(Model uiModel) {
        uiModel.addAttribute("estadisticas_fechacreacion_date_format", DateTimeFormat.patternForStyle("M-", LocaleContextHolder.getLocale()));
        uiModel.addAttribute("estadisticas_fechamodificacion_date_format", DateTimeFormat.patternForStyle("M-", LocaleContextHolder.getLocale()));
    }

	void populateEditForm(Model uiModel, Estadisticas estadisticas) {
        uiModel.addAttribute("estadisticas", estadisticas);
        addDateTimeFormatPatterns(uiModel);
        uiModel.addAttribute("accions", Accion.findAllAccions());
        uiModel.addAttribute("alineacions", Alineacion.findAllAlineacions());
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

	@RequestMapping(value = "/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
    @ResponseBody
    public ResponseEntity<String> showJson(@PathVariable("id") Long id) {
        Estadisticas estadisticas = Estadisticas.findEstadisticas(id);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json; charset=utf-8");
        if (estadisticas == null) {
            return new ResponseEntity<String>(headers, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<String>(estadisticas.toJson(), headers, HttpStatus.OK);
    }

	@RequestMapping(headers = "Accept=application/json")
    @ResponseBody
    public ResponseEntity<String> listJson() {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json; charset=utf-8");
        List<Estadisticas> result = Estadisticas.findAllEstadisticases();
        return new ResponseEntity<String>(Estadisticas.toJsonArray(result), headers, HttpStatus.OK);
    }

	@RequestMapping(method = RequestMethod.POST, headers = "Accept=application/json")
    public ResponseEntity<String> createFromJson(@RequestBody String json, UriComponentsBuilder uriBuilder) {
        Estadisticas estadisticas = Estadisticas.fromJsonToEstadisticas(json);
        estadisticas.persist();
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        RequestMapping a = (RequestMapping) getClass().getAnnotation(RequestMapping.class);
        headers.add("Location",uriBuilder.path(a.value()[0]+"/"+estadisticas.getId().toString()).build().toUriString());
        return new ResponseEntity<String>(headers, HttpStatus.CREATED);
    }

	@RequestMapping(value = "/jsonArray", method = RequestMethod.POST, headers = "Accept=application/json")
    public ResponseEntity<String> createFromJsonArray(@RequestBody String json) {
        for (Estadisticas estadisticas: Estadisticas.fromJsonArrayToEstadisticases(json)) {
            estadisticas.persist();
        }
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        return new ResponseEntity<String>(headers, HttpStatus.CREATED);
    }

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, headers = "Accept=application/json")
    public ResponseEntity<String> updateFromJson(@RequestBody String json, @PathVariable("id") Long id) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        Estadisticas estadisticas = Estadisticas.fromJsonToEstadisticas(json);
        estadisticas.setId(id);
        if (estadisticas.merge() == null) {
            return new ResponseEntity<String>(headers, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<String>(headers, HttpStatus.OK);
    }

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
    public ResponseEntity<String> deleteFromJson(@PathVariable("id") Long id) {
        Estadisticas estadisticas = Estadisticas.findEstadisticas(id);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        if (estadisticas == null) {
            return new ResponseEntity<String>(headers, HttpStatus.NOT_FOUND);
        }
        estadisticas.remove();
        return new ResponseEntity<String>(headers, HttpStatus.OK);
    }

	@RequestMapping(params = "find=ByAccion", headers = "Accept=application/json")
    @ResponseBody
    public ResponseEntity<String> jsonFindEstadisticasesByAccion(@RequestParam("accion") Accion accion) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json; charset=utf-8");
        return new ResponseEntity<String>(Estadisticas.toJsonArray(Estadisticas.findEstadisticasesByAccion(accion).getResultList()), headers, HttpStatus.OK);
    }

	@RequestMapping(params = "find=ByAlineacion", headers = "Accept=application/json")
    @ResponseBody
    public ResponseEntity<String> jsonFindEstadisticasesByAlineacion(@RequestParam("alineacion") Alineacion alineacion) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json; charset=utf-8");
        return new ResponseEntity<String>(Estadisticas.toJsonArray(Estadisticas.findEstadisticasesByAlineacion(alineacion).getResultList()), headers, HttpStatus.OK);
    }
}
