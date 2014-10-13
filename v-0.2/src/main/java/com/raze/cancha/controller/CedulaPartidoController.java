package com.raze.cancha.controller;
import com.raze.cancha.catalog.StatusCedula;
import com.raze.cancha.domain.CedulaPartido;
import com.raze.cancha.domain.Partido;
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

@RooWebJson(jsonObject = CedulaPartido.class)
@Controller
@RequestMapping("/cedulapartidoes")
@RooWebScaffold(path = "cedulapartidoes", formBackingObject = CedulaPartido.class)
@RooWebFinder
public class CedulaPartidoController {

	@RequestMapping(params = { "find=ByPartido", "form" }, method = RequestMethod.GET)
    public String findCedulaPartidoesByPartidoForm(Model uiModel) {
        uiModel.addAttribute("partidoes", Partido.findAllPartidoes());
        return "cedulapartidoes/findCedulaPartidoesByPartido";
    }

	@RequestMapping(params = "find=ByPartido", method = RequestMethod.GET)
    public String findCedulaPartidoesByPartido(@RequestParam("partido") Partido partido, @RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, @RequestParam(value = "sortFieldName", required = false) String sortFieldName, @RequestParam(value = "sortOrder", required = false) String sortOrder, Model uiModel) {
        if (page != null || size != null) {
            int sizeNo = size == null ? 10 : size.intValue();
            final int firstResult = page == null ? 0 : (page.intValue() - 1) * sizeNo;
            uiModel.addAttribute("cedulapartidoes", CedulaPartido.findCedulaPartidoesByPartido(partido, sortFieldName, sortOrder).setFirstResult(firstResult).setMaxResults(sizeNo).getResultList());
            float nrOfPages = (float) CedulaPartido.countFindCedulaPartidoesByPartido(partido) / sizeNo;
            uiModel.addAttribute("maxPages", (int) ((nrOfPages > (int) nrOfPages || nrOfPages == 0.0) ? nrOfPages + 1 : nrOfPages));
        } else {
            uiModel.addAttribute("cedulapartidoes", CedulaPartido.findCedulaPartidoesByPartido(partido, sortFieldName, sortOrder).getResultList());
        }
        addDateTimeFormatPatterns(uiModel);
        return "cedulapartidoes/list";
    }

	@RequestMapping(params = { "find=ByPartidoAndStatus", "form" }, method = RequestMethod.GET)
    public String findCedulaPartidoesByPartidoAndStatusForm(Model uiModel) {
        uiModel.addAttribute("partidoes", Partido.findAllPartidoes());
        uiModel.addAttribute("statuscedulas", StatusCedula.findAllStatusCedulas());
        return "cedulapartidoes/findCedulaPartidoesByPartidoAndStatus";
    }

	@RequestMapping(params = "find=ByPartidoAndStatus", method = RequestMethod.GET)
    public String findCedulaPartidoesByPartidoAndStatus(@RequestParam("partido") Partido partido, @RequestParam("status") StatusCedula status, @RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, @RequestParam(value = "sortFieldName", required = false) String sortFieldName, @RequestParam(value = "sortOrder", required = false) String sortOrder, Model uiModel) {
        if (page != null || size != null) {
            int sizeNo = size == null ? 10 : size.intValue();
            final int firstResult = page == null ? 0 : (page.intValue() - 1) * sizeNo;
            uiModel.addAttribute("cedulapartidoes", CedulaPartido.findCedulaPartidoesByPartidoAndStatus(partido, status, sortFieldName, sortOrder).setFirstResult(firstResult).setMaxResults(sizeNo).getResultList());
            float nrOfPages = (float) CedulaPartido.countFindCedulaPartidoesByPartidoAndStatus(partido, status) / sizeNo;
            uiModel.addAttribute("maxPages", (int) ((nrOfPages > (int) nrOfPages || nrOfPages == 0.0) ? nrOfPages + 1 : nrOfPages));
        } else {
            uiModel.addAttribute("cedulapartidoes", CedulaPartido.findCedulaPartidoesByPartidoAndStatus(partido, status, sortFieldName, sortOrder).getResultList());
        }
        addDateTimeFormatPatterns(uiModel);
        return "cedulapartidoes/list";
    }

	@RequestMapping(value = "/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
    @ResponseBody
    public ResponseEntity<String> showJson(@PathVariable("id") Long id) {
        CedulaPartido cedulaPartido = CedulaPartido.findCedulaPartido(id);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json; charset=utf-8");
        if (cedulaPartido == null) {
            return new ResponseEntity<String>(headers, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<String>(cedulaPartido.toJson(), headers, HttpStatus.OK);
    }

	@RequestMapping(headers = "Accept=application/json")
    @ResponseBody
    public ResponseEntity<String> listJson() {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json; charset=utf-8");
        List<CedulaPartido> result = CedulaPartido.findAllCedulaPartidoes();
        return new ResponseEntity<String>(CedulaPartido.toJsonArray(result), headers, HttpStatus.OK);
    }

	@RequestMapping(method = RequestMethod.POST, headers = "Accept=application/json")
    public ResponseEntity<String> createFromJson(@RequestBody String json, UriComponentsBuilder uriBuilder) {
        CedulaPartido cedulaPartido = CedulaPartido.fromJsonToCedulaPartido(json);
        cedulaPartido.persist();
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        RequestMapping a = (RequestMapping) getClass().getAnnotation(RequestMapping.class);
        headers.add("Location",uriBuilder.path(a.value()[0]+"/"+cedulaPartido.getId().toString()).build().toUriString());
        return new ResponseEntity<String>(headers, HttpStatus.CREATED);
    }

	@RequestMapping(value = "/jsonArray", method = RequestMethod.POST, headers = "Accept=application/json")
    public ResponseEntity<String> createFromJsonArray(@RequestBody String json) {
        for (CedulaPartido cedulaPartido: CedulaPartido.fromJsonArrayToCedulaPartidoes(json)) {
            cedulaPartido.persist();
        }
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        return new ResponseEntity<String>(headers, HttpStatus.CREATED);
    }

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, headers = "Accept=application/json")
    public ResponseEntity<String> updateFromJson(@RequestBody String json, @PathVariable("id") Long id) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        CedulaPartido cedulaPartido = CedulaPartido.fromJsonToCedulaPartido(json);
        cedulaPartido.setId(id);
        if (cedulaPartido.merge() == null) {
            return new ResponseEntity<String>(headers, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<String>(headers, HttpStatus.OK);
    }

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
    public ResponseEntity<String> deleteFromJson(@PathVariable("id") Long id) {
        CedulaPartido cedulaPartido = CedulaPartido.findCedulaPartido(id);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        if (cedulaPartido == null) {
            return new ResponseEntity<String>(headers, HttpStatus.NOT_FOUND);
        }
        cedulaPartido.remove();
        return new ResponseEntity<String>(headers, HttpStatus.OK);
    }

	@RequestMapping(params = "find=ByPartido", headers = "Accept=application/json")
    @ResponseBody
    public ResponseEntity<String> jsonFindCedulaPartidoesByPartido(@RequestParam("partido") Partido partido) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json; charset=utf-8");
        return new ResponseEntity<String>(CedulaPartido.toJsonArray(CedulaPartido.findCedulaPartidoesByPartido(partido).getResultList()), headers, HttpStatus.OK);
    }

	@RequestMapping(params = "find=ByPartidoAndStatus", headers = "Accept=application/json")
    @ResponseBody
    public ResponseEntity<String> jsonFindCedulaPartidoesByPartidoAndStatus(@RequestParam("partido") Partido partido, @RequestParam("status") StatusCedula status) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json; charset=utf-8");
        return new ResponseEntity<String>(CedulaPartido.toJsonArray(CedulaPartido.findCedulaPartidoesByPartidoAndStatus(partido, status).getResultList()), headers, HttpStatus.OK);
    }

	@RequestMapping(method = RequestMethod.POST, produces = "text/html")
    public String create(@Valid CedulaPartido cedulaPartido, BindingResult bindingResult, Model uiModel, HttpServletRequest httpServletRequest) {
        if (bindingResult.hasErrors()) {
            populateEditForm(uiModel, cedulaPartido);
            return "cedulapartidoes/create";
        }
        uiModel.asMap().clear();
        cedulaPartido.persist();
        return "redirect:/cedulapartidoes/" + encodeUrlPathSegment(cedulaPartido.getId().toString(), httpServletRequest);
    }

	@RequestMapping(params = "form", produces = "text/html")
    public String createForm(Model uiModel) {
        populateEditForm(uiModel, new CedulaPartido());
        List<String[]> dependencies = new ArrayList<String[]>();
        if (Partido.countPartidoes() == 0) {
            dependencies.add(new String[] { "partido", "partidoes" });
        }
        if (StatusCedula.countStatusCedulas() == 0) {
            dependencies.add(new String[] { "statuscedula", "statuscedulas" });
        }
        uiModel.addAttribute("dependencies", dependencies);
        return "cedulapartidoes/create";
    }

	@RequestMapping(value = "/{id}", produces = "text/html")
    public String show(@PathVariable("id") Long id, Model uiModel) {
        addDateTimeFormatPatterns(uiModel);
        uiModel.addAttribute("cedulapartido", CedulaPartido.findCedulaPartido(id));
        uiModel.addAttribute("itemId", id);
        return "cedulapartidoes/show";
    }

	@RequestMapping(produces = "text/html")
    public String list(@RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, @RequestParam(value = "sortFieldName", required = false) String sortFieldName, @RequestParam(value = "sortOrder", required = false) String sortOrder, Model uiModel) {
        if (page != null || size != null) {
            int sizeNo = size == null ? 10 : size.intValue();
            final int firstResult = page == null ? 0 : (page.intValue() - 1) * sizeNo;
            uiModel.addAttribute("cedulapartidoes", CedulaPartido.findCedulaPartidoEntries(firstResult, sizeNo, sortFieldName, sortOrder));
            float nrOfPages = (float) CedulaPartido.countCedulaPartidoes() / sizeNo;
            uiModel.addAttribute("maxPages", (int) ((nrOfPages > (int) nrOfPages || nrOfPages == 0.0) ? nrOfPages + 1 : nrOfPages));
        } else {
            uiModel.addAttribute("cedulapartidoes", CedulaPartido.findAllCedulaPartidoes(sortFieldName, sortOrder));
        }
        addDateTimeFormatPatterns(uiModel);
        return "cedulapartidoes/list";
    }

	@RequestMapping(method = RequestMethod.PUT, produces = "text/html")
    public String update(@Valid CedulaPartido cedulaPartido, BindingResult bindingResult, Model uiModel, HttpServletRequest httpServletRequest) {
        if (bindingResult.hasErrors()) {
            populateEditForm(uiModel, cedulaPartido);
            return "cedulapartidoes/update";
        }
        uiModel.asMap().clear();
        cedulaPartido.merge();
        return "redirect:/cedulapartidoes/" + encodeUrlPathSegment(cedulaPartido.getId().toString(), httpServletRequest);
    }

	@RequestMapping(value = "/{id}", params = "form", produces = "text/html")
    public String updateForm(@PathVariable("id") Long id, Model uiModel) {
        populateEditForm(uiModel, CedulaPartido.findCedulaPartido(id));
        return "cedulapartidoes/update";
    }

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = "text/html")
    public String delete(@PathVariable("id") Long id, @RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, Model uiModel) {
        CedulaPartido cedulaPartido = CedulaPartido.findCedulaPartido(id);
        cedulaPartido.remove();
        uiModel.asMap().clear();
        uiModel.addAttribute("page", (page == null) ? "1" : page.toString());
        uiModel.addAttribute("size", (size == null) ? "10" : size.toString());
        return "redirect:/cedulapartidoes";
    }

	void addDateTimeFormatPatterns(Model uiModel) {
        uiModel.addAttribute("cedulaPartido_fechacreacion_date_format", DateTimeFormat.patternForStyle("M-", LocaleContextHolder.getLocale()));
        uiModel.addAttribute("cedulaPartido_fechamodificacion_date_format", DateTimeFormat.patternForStyle("M-", LocaleContextHolder.getLocale()));
    }

	void populateEditForm(Model uiModel, CedulaPartido cedulaPartido) {
        uiModel.addAttribute("cedulaPartido", cedulaPartido);
        addDateTimeFormatPatterns(uiModel);
        uiModel.addAttribute("statuscedulas", StatusCedula.findAllStatusCedulas());
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
