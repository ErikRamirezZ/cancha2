package com.raze.cancha.controller;
import com.raze.cancha.catalog.FechaVencimientoTC;
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

@RooWebJson(jsonObject = FechaVencimientoTC.class)
@Controller
@RequestMapping("/fechavencimientotcs")
@RooWebScaffold(path = "fechavencimientotcs", formBackingObject = FechaVencimientoTC.class)
@RooWebFinder
public class FechaVencimientoTCController {

	@RequestMapping(params = { "find=ByActivo", "form" }, method = RequestMethod.GET)
    public String findFechaVencimientoTCsByActivoForm(Model uiModel) {
        return "fechavencimientotcs/findFechaVencimientoTCsByActivo";
    }

	@RequestMapping(params = "find=ByActivo", method = RequestMethod.GET)
    public String findFechaVencimientoTCsByActivo(@RequestParam(value = "activo", required = false) Boolean activo, @RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, @RequestParam(value = "sortFieldName", required = false) String sortFieldName, @RequestParam(value = "sortOrder", required = false) String sortOrder, Model uiModel) {
        if (page != null || size != null) {
            int sizeNo = size == null ? 10 : size.intValue();
            final int firstResult = page == null ? 0 : (page.intValue() - 1) * sizeNo;
            uiModel.addAttribute("fechavencimientotcs", FechaVencimientoTC.findFechaVencimientoTCsByActivo(activo == null ? Boolean.FALSE : activo, sortFieldName, sortOrder).setFirstResult(firstResult).setMaxResults(sizeNo).getResultList());
            float nrOfPages = (float) FechaVencimientoTC.countFindFechaVencimientoTCsByActivo(activo == null ? Boolean.FALSE : activo) / sizeNo;
            uiModel.addAttribute("maxPages", (int) ((nrOfPages > (int) nrOfPages || nrOfPages == 0.0) ? nrOfPages + 1 : nrOfPages));
        } else {
            uiModel.addAttribute("fechavencimientotcs", FechaVencimientoTC.findFechaVencimientoTCsByActivo(activo == null ? Boolean.FALSE : activo, sortFieldName, sortOrder).getResultList());
        }
        addDateTimeFormatPatterns(uiModel);
        return "fechavencimientotcs/list";
    }

	@RequestMapping(method = RequestMethod.POST, produces = "text/html")
    public String create(@Valid FechaVencimientoTC fechaVencimientoTC, BindingResult bindingResult, Model uiModel, HttpServletRequest httpServletRequest) {
        if (bindingResult.hasErrors()) {
            populateEditForm(uiModel, fechaVencimientoTC);
            return "fechavencimientotcs/create";
        }
        uiModel.asMap().clear();
        fechaVencimientoTC.persist();
        return "redirect:/fechavencimientotcs/" + encodeUrlPathSegment(fechaVencimientoTC.getId().toString(), httpServletRequest);
    }

	@RequestMapping(params = "form", produces = "text/html")
    public String createForm(Model uiModel) {
        populateEditForm(uiModel, new FechaVencimientoTC());
        return "fechavencimientotcs/create";
    }

	@RequestMapping(value = "/{id}", produces = "text/html")
    public String show(@PathVariable("id") Long id, Model uiModel) {
        addDateTimeFormatPatterns(uiModel);
        uiModel.addAttribute("fechavencimientotc", FechaVencimientoTC.findFechaVencimientoTC(id));
        uiModel.addAttribute("itemId", id);
        return "fechavencimientotcs/show";
    }

	@RequestMapping(produces = "text/html")
    public String list(@RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, @RequestParam(value = "sortFieldName", required = false) String sortFieldName, @RequestParam(value = "sortOrder", required = false) String sortOrder, Model uiModel) {
        if (page != null || size != null) {
            int sizeNo = size == null ? 10 : size.intValue();
            final int firstResult = page == null ? 0 : (page.intValue() - 1) * sizeNo;
            uiModel.addAttribute("fechavencimientotcs", FechaVencimientoTC.findFechaVencimientoTCEntries(firstResult, sizeNo, sortFieldName, sortOrder));
            float nrOfPages = (float) FechaVencimientoTC.countFechaVencimientoTCs() / sizeNo;
            uiModel.addAttribute("maxPages", (int) ((nrOfPages > (int) nrOfPages || nrOfPages == 0.0) ? nrOfPages + 1 : nrOfPages));
        } else {
            uiModel.addAttribute("fechavencimientotcs", FechaVencimientoTC.findAllFechaVencimientoTCs(sortFieldName, sortOrder));
        }
        addDateTimeFormatPatterns(uiModel);
        return "fechavencimientotcs/list";
    }

	@RequestMapping(method = RequestMethod.PUT, produces = "text/html")
    public String update(@Valid FechaVencimientoTC fechaVencimientoTC, BindingResult bindingResult, Model uiModel, HttpServletRequest httpServletRequest) {
        if (bindingResult.hasErrors()) {
            populateEditForm(uiModel, fechaVencimientoTC);
            return "fechavencimientotcs/update";
        }
        uiModel.asMap().clear();
        fechaVencimientoTC.merge();
        return "redirect:/fechavencimientotcs/" + encodeUrlPathSegment(fechaVencimientoTC.getId().toString(), httpServletRequest);
    }

	@RequestMapping(value = "/{id}", params = "form", produces = "text/html")
    public String updateForm(@PathVariable("id") Long id, Model uiModel) {
        populateEditForm(uiModel, FechaVencimientoTC.findFechaVencimientoTC(id));
        return "fechavencimientotcs/update";
    }

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = "text/html")
    public String delete(@PathVariable("id") Long id, @RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, Model uiModel) {
        FechaVencimientoTC fechaVencimientoTC = FechaVencimientoTC.findFechaVencimientoTC(id);
        fechaVencimientoTC.remove();
        uiModel.asMap().clear();
        uiModel.addAttribute("page", (page == null) ? "1" : page.toString());
        uiModel.addAttribute("size", (size == null) ? "10" : size.toString());
        return "redirect:/fechavencimientotcs";
    }

	void addDateTimeFormatPatterns(Model uiModel) {
        uiModel.addAttribute("fechaVencimientoTC_fechacreacion_date_format", DateTimeFormat.patternForStyle("M-", LocaleContextHolder.getLocale()));
        uiModel.addAttribute("fechaVencimientoTC_fechamodificacion_date_format", DateTimeFormat.patternForStyle("M-", LocaleContextHolder.getLocale()));
    }

	void populateEditForm(Model uiModel, FechaVencimientoTC fechaVencimientoTC) {
        uiModel.addAttribute("fechaVencimientoTC", fechaVencimientoTC);
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

	@RequestMapping(value = "/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
    @ResponseBody
    public ResponseEntity<String> showJson(@PathVariable("id") Long id) {
        FechaVencimientoTC fechaVencimientoTC = FechaVencimientoTC.findFechaVencimientoTC(id);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json; charset=utf-8");
        if (fechaVencimientoTC == null) {
            return new ResponseEntity<String>(headers, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<String>(fechaVencimientoTC.toJson(), headers, HttpStatus.OK);
    }

	@RequestMapping(headers = "Accept=application/json")
    @ResponseBody
    public ResponseEntity<String> listJson() {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json; charset=utf-8");
        List<FechaVencimientoTC> result = FechaVencimientoTC.findAllFechaVencimientoTCs();
        return new ResponseEntity<String>(FechaVencimientoTC.toJsonArray(result), headers, HttpStatus.OK);
    }

	@RequestMapping(method = RequestMethod.POST, headers = "Accept=application/json")
    public ResponseEntity<String> createFromJson(@RequestBody String json, UriComponentsBuilder uriBuilder) {
        FechaVencimientoTC fechaVencimientoTC = FechaVencimientoTC.fromJsonToFechaVencimientoTC(json);
        fechaVencimientoTC.persist();
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        RequestMapping a = (RequestMapping) getClass().getAnnotation(RequestMapping.class);
        headers.add("Location",uriBuilder.path(a.value()[0]+"/"+fechaVencimientoTC.getId().toString()).build().toUriString());
        return new ResponseEntity<String>(headers, HttpStatus.CREATED);
    }

	@RequestMapping(value = "/jsonArray", method = RequestMethod.POST, headers = "Accept=application/json")
    public ResponseEntity<String> createFromJsonArray(@RequestBody String json) {
        for (FechaVencimientoTC fechaVencimientoTC: FechaVencimientoTC.fromJsonArrayToFechaVencimientoTCs(json)) {
            fechaVencimientoTC.persist();
        }
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        return new ResponseEntity<String>(headers, HttpStatus.CREATED);
    }

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, headers = "Accept=application/json")
    public ResponseEntity<String> updateFromJson(@RequestBody String json, @PathVariable("id") Long id) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        FechaVencimientoTC fechaVencimientoTC = FechaVencimientoTC.fromJsonToFechaVencimientoTC(json);
        fechaVencimientoTC.setId(id);
        if (fechaVencimientoTC.merge() == null) {
            return new ResponseEntity<String>(headers, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<String>(headers, HttpStatus.OK);
    }

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
    public ResponseEntity<String> deleteFromJson(@PathVariable("id") Long id) {
        FechaVencimientoTC fechaVencimientoTC = FechaVencimientoTC.findFechaVencimientoTC(id);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        if (fechaVencimientoTC == null) {
            return new ResponseEntity<String>(headers, HttpStatus.NOT_FOUND);
        }
        fechaVencimientoTC.remove();
        return new ResponseEntity<String>(headers, HttpStatus.OK);
    }

	@RequestMapping(params = "find=ByActivo", headers = "Accept=application/json")
    @ResponseBody
    public ResponseEntity<String> jsonFindFechaVencimientoTCsByActivo(@RequestParam(value = "activo", required = false) Boolean activo) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json; charset=utf-8");
        return new ResponseEntity<String>(FechaVencimientoTC.toJsonArray(FechaVencimientoTC.findFechaVencimientoTCsByActivo(activo == null ? Boolean.FALSE : activo).getResultList()), headers, HttpStatus.OK);
    }
}
