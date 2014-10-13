package com.raze.cancha.controller;
import com.raze.cancha.domain.Equipo;
import com.raze.cancha.domain.Torneo;
import com.raze.cancha.domain.TorneoEquipo;
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

@RooWebJson(jsonObject = TorneoEquipo.class)
@Controller
@RequestMapping("/torneoequipoes")
@RooWebScaffold(path = "torneoequipoes", formBackingObject = TorneoEquipo.class)
@RooWebFinder
public class TorneoEquipoController {

	@RequestMapping(params = { "find=ByEquipo", "form" }, method = RequestMethod.GET)
    public String findTorneoEquipoesByEquipoForm(Model uiModel) {
        uiModel.addAttribute("equipoes", Equipo.findAllEquipoes());
        return "torneoequipoes/findTorneoEquipoesByEquipo";
    }

	@RequestMapping(params = "find=ByEquipo", method = RequestMethod.GET)
    public String findTorneoEquipoesByEquipo(@RequestParam("equipo") Equipo equipo, @RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, @RequestParam(value = "sortFieldName", required = false) String sortFieldName, @RequestParam(value = "sortOrder", required = false) String sortOrder, Model uiModel) {
        if (page != null || size != null) {
            int sizeNo = size == null ? 10 : size.intValue();
            final int firstResult = page == null ? 0 : (page.intValue() - 1) * sizeNo;
            uiModel.addAttribute("torneoequipoes", TorneoEquipo.findTorneoEquipoesByEquipo(equipo, sortFieldName, sortOrder).setFirstResult(firstResult).setMaxResults(sizeNo).getResultList());
            float nrOfPages = (float) TorneoEquipo.countFindTorneoEquipoesByEquipo(equipo) / sizeNo;
            uiModel.addAttribute("maxPages", (int) ((nrOfPages > (int) nrOfPages || nrOfPages == 0.0) ? nrOfPages + 1 : nrOfPages));
        } else {
            uiModel.addAttribute("torneoequipoes", TorneoEquipo.findTorneoEquipoesByEquipo(equipo, sortFieldName, sortOrder).getResultList());
        }
        addDateTimeFormatPatterns(uiModel);
        return "torneoequipoes/list";
    }

	@RequestMapping(params = { "find=ByTorneo", "form" }, method = RequestMethod.GET)
    public String findTorneoEquipoesByTorneoForm(Model uiModel) {
        uiModel.addAttribute("torneos", Torneo.findAllTorneos());
        return "torneoequipoes/findTorneoEquipoesByTorneo";
    }

	@RequestMapping(params = "find=ByTorneo", method = RequestMethod.GET)
    public String findTorneoEquipoesByTorneo(@RequestParam("torneo") Torneo torneo, @RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, @RequestParam(value = "sortFieldName", required = false) String sortFieldName, @RequestParam(value = "sortOrder", required = false) String sortOrder, Model uiModel) {
        if (page != null || size != null) {
            int sizeNo = size == null ? 10 : size.intValue();
            final int firstResult = page == null ? 0 : (page.intValue() - 1) * sizeNo;
            uiModel.addAttribute("torneoequipoes", TorneoEquipo.findTorneoEquipoesByTorneo(torneo, sortFieldName, sortOrder).setFirstResult(firstResult).setMaxResults(sizeNo).getResultList());
            float nrOfPages = (float) TorneoEquipo.countFindTorneoEquipoesByTorneo(torneo) / sizeNo;
            uiModel.addAttribute("maxPages", (int) ((nrOfPages > (int) nrOfPages || nrOfPages == 0.0) ? nrOfPages + 1 : nrOfPages));
        } else {
            uiModel.addAttribute("torneoequipoes", TorneoEquipo.findTorneoEquipoesByTorneo(torneo, sortFieldName, sortOrder).getResultList());
        }
        addDateTimeFormatPatterns(uiModel);
        return "torneoequipoes/list";
    }

	@RequestMapping(method = RequestMethod.POST, produces = "text/html")
    public String create(@Valid TorneoEquipo torneoEquipo, BindingResult bindingResult, Model uiModel, HttpServletRequest httpServletRequest) {
        if (bindingResult.hasErrors()) {
            populateEditForm(uiModel, torneoEquipo);
            return "torneoequipoes/create";
        }
        uiModel.asMap().clear();
        torneoEquipo.persist();
        return "redirect:/torneoequipoes/" + encodeUrlPathSegment(torneoEquipo.getId().toString(), httpServletRequest);
    }

	@RequestMapping(params = "form", produces = "text/html")
    public String createForm(Model uiModel) {
        populateEditForm(uiModel, new TorneoEquipo());
        return "torneoequipoes/create";
    }

	@RequestMapping(value = "/{id}", produces = "text/html")
    public String show(@PathVariable("id") Long id, Model uiModel) {
        addDateTimeFormatPatterns(uiModel);
        uiModel.addAttribute("torneoequipo", TorneoEquipo.findTorneoEquipo(id));
        uiModel.addAttribute("itemId", id);
        return "torneoequipoes/show";
    }

	@RequestMapping(produces = "text/html")
    public String list(@RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, @RequestParam(value = "sortFieldName", required = false) String sortFieldName, @RequestParam(value = "sortOrder", required = false) String sortOrder, Model uiModel) {
        if (page != null || size != null) {
            int sizeNo = size == null ? 10 : size.intValue();
            final int firstResult = page == null ? 0 : (page.intValue() - 1) * sizeNo;
            uiModel.addAttribute("torneoequipoes", TorneoEquipo.findTorneoEquipoEntries(firstResult, sizeNo, sortFieldName, sortOrder));
            float nrOfPages = (float) TorneoEquipo.countTorneoEquipoes() / sizeNo;
            uiModel.addAttribute("maxPages", (int) ((nrOfPages > (int) nrOfPages || nrOfPages == 0.0) ? nrOfPages + 1 : nrOfPages));
        } else {
            uiModel.addAttribute("torneoequipoes", TorneoEquipo.findAllTorneoEquipoes(sortFieldName, sortOrder));
        }
        addDateTimeFormatPatterns(uiModel);
        return "torneoequipoes/list";
    }

	@RequestMapping(method = RequestMethod.PUT, produces = "text/html")
    public String update(@Valid TorneoEquipo torneoEquipo, BindingResult bindingResult, Model uiModel, HttpServletRequest httpServletRequest) {
        if (bindingResult.hasErrors()) {
            populateEditForm(uiModel, torneoEquipo);
            return "torneoequipoes/update";
        }
        uiModel.asMap().clear();
        torneoEquipo.merge();
        return "redirect:/torneoequipoes/" + encodeUrlPathSegment(torneoEquipo.getId().toString(), httpServletRequest);
    }

	@RequestMapping(value = "/{id}", params = "form", produces = "text/html")
    public String updateForm(@PathVariable("id") Long id, Model uiModel) {
        populateEditForm(uiModel, TorneoEquipo.findTorneoEquipo(id));
        return "torneoequipoes/update";
    }

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = "text/html")
    public String delete(@PathVariable("id") Long id, @RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, Model uiModel) {
        TorneoEquipo torneoEquipo = TorneoEquipo.findTorneoEquipo(id);
        torneoEquipo.remove();
        uiModel.asMap().clear();
        uiModel.addAttribute("page", (page == null) ? "1" : page.toString());
        uiModel.addAttribute("size", (size == null) ? "10" : size.toString());
        return "redirect:/torneoequipoes";
    }

	void addDateTimeFormatPatterns(Model uiModel) {
        uiModel.addAttribute("torneoEquipo_fechacreacion_date_format", DateTimeFormat.patternForStyle("M-", LocaleContextHolder.getLocale()));
        uiModel.addAttribute("torneoEquipo_fechamodificacion_date_format", DateTimeFormat.patternForStyle("M-", LocaleContextHolder.getLocale()));
    }

	void populateEditForm(Model uiModel, TorneoEquipo torneoEquipo) {
        uiModel.addAttribute("torneoEquipo", torneoEquipo);
        addDateTimeFormatPatterns(uiModel);
        uiModel.addAttribute("equipoes", Equipo.findAllEquipoes());
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

	@RequestMapping(value = "/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
    @ResponseBody
    public ResponseEntity<String> showJson(@PathVariable("id") Long id) {
        TorneoEquipo torneoEquipo = TorneoEquipo.findTorneoEquipo(id);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json; charset=utf-8");
        if (torneoEquipo == null) {
            return new ResponseEntity<String>(headers, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<String>(torneoEquipo.toJson(), headers, HttpStatus.OK);
    }

	@RequestMapping(headers = "Accept=application/json")
    @ResponseBody
    public ResponseEntity<String> listJson() {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json; charset=utf-8");
        List<TorneoEquipo> result = TorneoEquipo.findAllTorneoEquipoes();
        return new ResponseEntity<String>(TorneoEquipo.toJsonArray(result), headers, HttpStatus.OK);
    }

	@RequestMapping(method = RequestMethod.POST, headers = "Accept=application/json")
    public ResponseEntity<String> createFromJson(@RequestBody String json, UriComponentsBuilder uriBuilder) {
        TorneoEquipo torneoEquipo = TorneoEquipo.fromJsonToTorneoEquipo(json);
        torneoEquipo.persist();
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        RequestMapping a = (RequestMapping) getClass().getAnnotation(RequestMapping.class);
        headers.add("Location",uriBuilder.path(a.value()[0]+"/"+torneoEquipo.getId().toString()).build().toUriString());
        return new ResponseEntity<String>(headers, HttpStatus.CREATED);
    }

	@RequestMapping(value = "/jsonArray", method = RequestMethod.POST, headers = "Accept=application/json")
    public ResponseEntity<String> createFromJsonArray(@RequestBody String json) {
        for (TorneoEquipo torneoEquipo: TorneoEquipo.fromJsonArrayToTorneoEquipoes(json)) {
            torneoEquipo.persist();
        }
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        return new ResponseEntity<String>(headers, HttpStatus.CREATED);
    }

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, headers = "Accept=application/json")
    public ResponseEntity<String> updateFromJson(@RequestBody String json, @PathVariable("id") Long id) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        TorneoEquipo torneoEquipo = TorneoEquipo.fromJsonToTorneoEquipo(json);
        torneoEquipo.setId(id);
        if (torneoEquipo.merge() == null) {
            return new ResponseEntity<String>(headers, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<String>(headers, HttpStatus.OK);
    }

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
    public ResponseEntity<String> deleteFromJson(@PathVariable("id") Long id) {
        TorneoEquipo torneoEquipo = TorneoEquipo.findTorneoEquipo(id);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        if (torneoEquipo == null) {
            return new ResponseEntity<String>(headers, HttpStatus.NOT_FOUND);
        }
        torneoEquipo.remove();
        return new ResponseEntity<String>(headers, HttpStatus.OK);
    }

	@RequestMapping(params = "find=ByEquipo", headers = "Accept=application/json")
    @ResponseBody
    public ResponseEntity<String> jsonFindTorneoEquipoesByEquipo(@RequestParam("equipo") Equipo equipo) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json; charset=utf-8");
        return new ResponseEntity<String>(TorneoEquipo.toJsonArray(TorneoEquipo.findTorneoEquipoesByEquipo(equipo).getResultList()), headers, HttpStatus.OK);
    }

	@RequestMapping(params = "find=ByTorneo", headers = "Accept=application/json")
    @ResponseBody
    public ResponseEntity<String> jsonFindTorneoEquipoesByTorneo(@RequestParam("torneo") Torneo torneo) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json; charset=utf-8");
        return new ResponseEntity<String>(TorneoEquipo.toJsonArray(TorneoEquipo.findTorneoEquipoesByTorneo(torneo).getResultList()), headers, HttpStatus.OK);
    }
}
