package com.raze.cancha.controller;
import com.raze.cancha.domain.Empresa;
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

@RooWebJson(jsonObject = Empresa.class)
@Controller
@RequestMapping("/empresas")
@RooWebScaffold(path = "empresas", formBackingObject = Empresa.class)
@RooWebFinder
public class EmpresaController {

	@RequestMapping(method = RequestMethod.POST, produces = "text/html")
    public String create(@Valid Empresa empresa, BindingResult bindingResult, Model uiModel, HttpServletRequest httpServletRequest) {
        if (bindingResult.hasErrors()) {
            populateEditForm(uiModel, empresa);
            return "empresas/create";
        }
        uiModel.asMap().clear();
        empresa.persist();
        return "redirect:/empresas/" + encodeUrlPathSegment(empresa.getId().toString(), httpServletRequest);
    }

	@RequestMapping(params = "form", produces = "text/html")
    public String createForm(Model uiModel) {
        populateEditForm(uiModel, new Empresa());
        return "empresas/create";
    }

	@RequestMapping(value = "/{id}", produces = "text/html")
    public String show(@PathVariable("id") Long id, Model uiModel) {
        addDateTimeFormatPatterns(uiModel);
        uiModel.addAttribute("empresa", Empresa.findEmpresa(id));
        uiModel.addAttribute("itemId", id);
        return "empresas/show";
    }

	@RequestMapping(produces = "text/html")
    public String list(@RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, @RequestParam(value = "sortFieldName", required = false) String sortFieldName, @RequestParam(value = "sortOrder", required = false) String sortOrder, Model uiModel) {
        if (page != null || size != null) {
            int sizeNo = size == null ? 10 : size.intValue();
            final int firstResult = page == null ? 0 : (page.intValue() - 1) * sizeNo;
            uiModel.addAttribute("empresas", Empresa.findEmpresaEntries(firstResult, sizeNo, sortFieldName, sortOrder));
            float nrOfPages = (float) Empresa.countEmpresas() / sizeNo;
            uiModel.addAttribute("maxPages", (int) ((nrOfPages > (int) nrOfPages || nrOfPages == 0.0) ? nrOfPages + 1 : nrOfPages));
        } else {
            uiModel.addAttribute("empresas", Empresa.findAllEmpresas(sortFieldName, sortOrder));
        }
        addDateTimeFormatPatterns(uiModel);
        return "empresas/list";
    }

	@RequestMapping(method = RequestMethod.PUT, produces = "text/html")
    public String update(@Valid Empresa empresa, BindingResult bindingResult, Model uiModel, HttpServletRequest httpServletRequest) {
        if (bindingResult.hasErrors()) {
            populateEditForm(uiModel, empresa);
            return "empresas/update";
        }
        uiModel.asMap().clear();
        empresa.merge();
        return "redirect:/empresas/" + encodeUrlPathSegment(empresa.getId().toString(), httpServletRequest);
    }

	@RequestMapping(value = "/{id}", params = "form", produces = "text/html")
    public String updateForm(@PathVariable("id") Long id, Model uiModel) {
        populateEditForm(uiModel, Empresa.findEmpresa(id));
        return "empresas/update";
    }

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = "text/html")
    public String delete(@PathVariable("id") Long id, @RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, Model uiModel) {
        Empresa empresa = Empresa.findEmpresa(id);
        empresa.remove();
        uiModel.asMap().clear();
        uiModel.addAttribute("page", (page == null) ? "1" : page.toString());
        uiModel.addAttribute("size", (size == null) ? "10" : size.toString());
        return "redirect:/empresas";
    }

	void addDateTimeFormatPatterns(Model uiModel) {
        uiModel.addAttribute("empresa_fechacreacion_date_format", DateTimeFormat.patternForStyle("M-", LocaleContextHolder.getLocale()));
        uiModel.addAttribute("empresa_fechamodificacion_date_format", DateTimeFormat.patternForStyle("M-", LocaleContextHolder.getLocale()));
    }

	void populateEditForm(Model uiModel, Empresa empresa) {
        uiModel.addAttribute("empresa", empresa);
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
    public String findEmpresasByActivoForm(Model uiModel) {
        return "empresas/findEmpresasByActivo";
    }

	@RequestMapping(params = "find=ByActivo", method = RequestMethod.GET)
    public String findEmpresasByActivo(@RequestParam(value = "activo", required = false) Boolean activo, @RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, @RequestParam(value = "sortFieldName", required = false) String sortFieldName, @RequestParam(value = "sortOrder", required = false) String sortOrder, Model uiModel) {
        if (page != null || size != null) {
            int sizeNo = size == null ? 10 : size.intValue();
            final int firstResult = page == null ? 0 : (page.intValue() - 1) * sizeNo;
            uiModel.addAttribute("empresas", Empresa.findEmpresasByActivo(activo == null ? Boolean.FALSE : activo, sortFieldName, sortOrder).setFirstResult(firstResult).setMaxResults(sizeNo).getResultList());
            float nrOfPages = (float) Empresa.countFindEmpresasByActivo(activo == null ? Boolean.FALSE : activo) / sizeNo;
            uiModel.addAttribute("maxPages", (int) ((nrOfPages > (int) nrOfPages || nrOfPages == 0.0) ? nrOfPages + 1 : nrOfPages));
        } else {
            uiModel.addAttribute("empresas", Empresa.findEmpresasByActivo(activo == null ? Boolean.FALSE : activo, sortFieldName, sortOrder).getResultList());
        }
        addDateTimeFormatPatterns(uiModel);
        return "empresas/list";
    }

	@RequestMapping(params = { "find=ByNombreComercialLikeAndActivo", "form" }, method = RequestMethod.GET)
    public String findEmpresasByNombreComercialLikeAndActivoForm(Model uiModel) {
        return "empresas/findEmpresasByNombreComercialLikeAndActivo";
    }

	@RequestMapping(params = "find=ByNombreComercialLikeAndActivo", method = RequestMethod.GET)
    public String findEmpresasByNombreComercialLikeAndActivo(@RequestParam("nombreComercial") String nombreComercial, @RequestParam(value = "activo", required = false) Boolean activo, @RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, @RequestParam(value = "sortFieldName", required = false) String sortFieldName, @RequestParam(value = "sortOrder", required = false) String sortOrder, Model uiModel) {
        if (page != null || size != null) {
            int sizeNo = size == null ? 10 : size.intValue();
            final int firstResult = page == null ? 0 : (page.intValue() - 1) * sizeNo;
            uiModel.addAttribute("empresas", Empresa.findEmpresasByNombreComercialLikeAndActivo(nombreComercial, activo == null ? Boolean.FALSE : activo, sortFieldName, sortOrder).setFirstResult(firstResult).setMaxResults(sizeNo).getResultList());
            float nrOfPages = (float) Empresa.countFindEmpresasByNombreComercialLikeAndActivo(nombreComercial, activo == null ? Boolean.FALSE : activo) / sizeNo;
            uiModel.addAttribute("maxPages", (int) ((nrOfPages > (int) nrOfPages || nrOfPages == 0.0) ? nrOfPages + 1 : nrOfPages));
        } else {
            uiModel.addAttribute("empresas", Empresa.findEmpresasByNombreComercialLikeAndActivo(nombreComercial, activo == null ? Boolean.FALSE : activo, sortFieldName, sortOrder).getResultList());
        }
        addDateTimeFormatPatterns(uiModel);
        return "empresas/list";
    }

	@RequestMapping(params = { "find=ByNombreLikeAndActivo", "form" }, method = RequestMethod.GET)
    public String findEmpresasByNombreLikeAndActivoForm(Model uiModel) {
        return "empresas/findEmpresasByNombreLikeAndActivo";
    }

	@RequestMapping(params = "find=ByNombreLikeAndActivo", method = RequestMethod.GET)
    public String findEmpresasByNombreLikeAndActivo(@RequestParam("nombre") String nombre, @RequestParam(value = "activo", required = false) Boolean activo, @RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, @RequestParam(value = "sortFieldName", required = false) String sortFieldName, @RequestParam(value = "sortOrder", required = false) String sortOrder, Model uiModel) {
        if (page != null || size != null) {
            int sizeNo = size == null ? 10 : size.intValue();
            final int firstResult = page == null ? 0 : (page.intValue() - 1) * sizeNo;
            uiModel.addAttribute("empresas", Empresa.findEmpresasByNombreLikeAndActivo(nombre, activo == null ? Boolean.FALSE : activo, sortFieldName, sortOrder).setFirstResult(firstResult).setMaxResults(sizeNo).getResultList());
            float nrOfPages = (float) Empresa.countFindEmpresasByNombreLikeAndActivo(nombre, activo == null ? Boolean.FALSE : activo) / sizeNo;
            uiModel.addAttribute("maxPages", (int) ((nrOfPages > (int) nrOfPages || nrOfPages == 0.0) ? nrOfPages + 1 : nrOfPages));
        } else {
            uiModel.addAttribute("empresas", Empresa.findEmpresasByNombreLikeAndActivo(nombre, activo == null ? Boolean.FALSE : activo, sortFieldName, sortOrder).getResultList());
        }
        addDateTimeFormatPatterns(uiModel);
        return "empresas/list";
    }

	@RequestMapping(value = "/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
    @ResponseBody
    public ResponseEntity<String> showJson(@PathVariable("id") Long id) {
        Empresa empresa = Empresa.findEmpresa(id);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json; charset=utf-8");
        if (empresa == null) {
            return new ResponseEntity<String>(headers, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<String>(empresa.toJson(), headers, HttpStatus.OK);
    }

	@RequestMapping(headers = "Accept=application/json")
    @ResponseBody
    public ResponseEntity<String> listJson() {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json; charset=utf-8");
        List<Empresa> result = Empresa.findAllEmpresas();
        return new ResponseEntity<String>(Empresa.toJsonArray(result), headers, HttpStatus.OK);
    }

	@RequestMapping(method = RequestMethod.POST, headers = "Accept=application/json")
    public ResponseEntity<String> createFromJson(@RequestBody String json, UriComponentsBuilder uriBuilder) {
        Empresa empresa = Empresa.fromJsonToEmpresa(json);
        empresa.persist();
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        RequestMapping a = (RequestMapping) getClass().getAnnotation(RequestMapping.class);
        headers.add("Location",uriBuilder.path(a.value()[0]+"/"+empresa.getId().toString()).build().toUriString());
        return new ResponseEntity<String>(headers, HttpStatus.CREATED);
    }

	@RequestMapping(value = "/jsonArray", method = RequestMethod.POST, headers = "Accept=application/json")
    public ResponseEntity<String> createFromJsonArray(@RequestBody String json) {
        for (Empresa empresa: Empresa.fromJsonArrayToEmpresas(json)) {
            empresa.persist();
        }
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        return new ResponseEntity<String>(headers, HttpStatus.CREATED);
    }

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, headers = "Accept=application/json")
    public ResponseEntity<String> updateFromJson(@RequestBody String json, @PathVariable("id") Long id) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        Empresa empresa = Empresa.fromJsonToEmpresa(json);
        empresa.setId(id);
        if (empresa.merge() == null) {
            return new ResponseEntity<String>(headers, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<String>(headers, HttpStatus.OK);
    }

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
    public ResponseEntity<String> deleteFromJson(@PathVariable("id") Long id) {
        Empresa empresa = Empresa.findEmpresa(id);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        if (empresa == null) {
            return new ResponseEntity<String>(headers, HttpStatus.NOT_FOUND);
        }
        empresa.remove();
        return new ResponseEntity<String>(headers, HttpStatus.OK);
    }

	@RequestMapping(params = "find=ByActivo", headers = "Accept=application/json")
    @ResponseBody
    public ResponseEntity<String> jsonFindEmpresasByActivo(@RequestParam(value = "activo", required = false) Boolean activo) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json; charset=utf-8");
        return new ResponseEntity<String>(Empresa.toJsonArray(Empresa.findEmpresasByActivo(activo == null ? Boolean.FALSE : activo).getResultList()), headers, HttpStatus.OK);
    }

	@RequestMapping(params = "find=ByNombreComercialLikeAndActivo", headers = "Accept=application/json")
    @ResponseBody
    public ResponseEntity<String> jsonFindEmpresasByNombreComercialLikeAndActivo(@RequestParam("nombreComercial") String nombreComercial, @RequestParam(value = "activo", required = false) Boolean activo) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json; charset=utf-8");
        return new ResponseEntity<String>(Empresa.toJsonArray(Empresa.findEmpresasByNombreComercialLikeAndActivo(nombreComercial, activo == null ? Boolean.FALSE : activo).getResultList()), headers, HttpStatus.OK);
    }

	@RequestMapping(params = "find=ByNombreLikeAndActivo", headers = "Accept=application/json")
    @ResponseBody
    public ResponseEntity<String> jsonFindEmpresasByNombreLikeAndActivo(@RequestParam("nombre") String nombre, @RequestParam(value = "activo", required = false) Boolean activo) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json; charset=utf-8");
        return new ResponseEntity<String>(Empresa.toJsonArray(Empresa.findEmpresasByNombreLikeAndActivo(nombre, activo == null ? Boolean.FALSE : activo).getResultList()), headers, HttpStatus.OK);
    }
}
