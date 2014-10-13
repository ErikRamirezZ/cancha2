package com.raze.cancha.controller;
import com.raze.cancha.catalog.DiasJuego;
import com.raze.cancha.catalog.TipoCobro;
import com.raze.cancha.domain.ConfiguracionTorneo;
import com.raze.cancha.domain.Torneo;
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

@RooWebJson(jsonObject = ConfiguracionTorneo.class)
@Controller
@RequestMapping("/configuraciontorneos")
@RooWebScaffold(path = "configuraciontorneos", formBackingObject = ConfiguracionTorneo.class)
@RooWebFinder
public class ConfiguracionTorneoController {

	@RequestMapping(params = { "find=ByInscripcionAndActivo", "form" }, method = RequestMethod.GET)
    public String findConfiguracionTorneosByInscripcionAndActivoForm(Model uiModel) {
        return "configuraciontorneos/findConfiguracionTorneosByInscripcionAndActivo";
    }

	@RequestMapping(params = "find=ByInscripcionAndActivo", method = RequestMethod.GET)
    public String findConfiguracionTorneosByInscripcionAndActivo(@RequestParam(value = "inscripcion", required = false) Boolean inscripcion, @RequestParam(value = "activo", required = false) Boolean activo, @RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, @RequestParam(value = "sortFieldName", required = false) String sortFieldName, @RequestParam(value = "sortOrder", required = false) String sortOrder, Model uiModel) {
        if (page != null || size != null) {
            int sizeNo = size == null ? 10 : size.intValue();
            final int firstResult = page == null ? 0 : (page.intValue() - 1) * sizeNo;
            uiModel.addAttribute("configuraciontorneos", ConfiguracionTorneo.findConfiguracionTorneosByInscripcionAndActivo(inscripcion == null ? Boolean.FALSE : inscripcion, activo == null ? Boolean.FALSE : activo, sortFieldName, sortOrder).setFirstResult(firstResult).setMaxResults(sizeNo).getResultList());
            float nrOfPages = (float) ConfiguracionTorneo.countFindConfiguracionTorneosByInscripcionAndActivo(inscripcion == null ? Boolean.FALSE : inscripcion, activo == null ? Boolean.FALSE : activo) / sizeNo;
            uiModel.addAttribute("maxPages", (int) ((nrOfPages > (int) nrOfPages || nrOfPages == 0.0) ? nrOfPages + 1 : nrOfPages));
        } else {
            uiModel.addAttribute("configuraciontorneos", ConfiguracionTorneo.findConfiguracionTorneosByInscripcionAndActivo(inscripcion == null ? Boolean.FALSE : inscripcion, activo == null ? Boolean.FALSE : activo, sortFieldName, sortOrder).getResultList());
        }
        addDateTimeFormatPatterns(uiModel);
        return "configuraciontorneos/list";
    }

	@RequestMapping(params = { "find=ByTipoCobroAndActivo", "form" }, method = RequestMethod.GET)
    public String findConfiguracionTorneosByTipoCobroAndActivoForm(Model uiModel) {
        uiModel.addAttribute("tipocobroes", TipoCobro.findAllTipoCobroes());
        return "configuraciontorneos/findConfiguracionTorneosByTipoCobroAndActivo";
    }

	@RequestMapping(params = "find=ByTipoCobroAndActivo", method = RequestMethod.GET)
    public String findConfiguracionTorneosByTipoCobroAndActivo(@RequestParam("tipoCobro") TipoCobro tipoCobro, @RequestParam(value = "activo", required = false) Boolean activo, @RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, @RequestParam(value = "sortFieldName", required = false) String sortFieldName, @RequestParam(value = "sortOrder", required = false) String sortOrder, Model uiModel) {
        if (page != null || size != null) {
            int sizeNo = size == null ? 10 : size.intValue();
            final int firstResult = page == null ? 0 : (page.intValue() - 1) * sizeNo;
            uiModel.addAttribute("configuraciontorneos", ConfiguracionTorneo.findConfiguracionTorneosByTipoCobroAndActivo(tipoCobro, activo == null ? Boolean.FALSE : activo, sortFieldName, sortOrder).setFirstResult(firstResult).setMaxResults(sizeNo).getResultList());
            float nrOfPages = (float) ConfiguracionTorneo.countFindConfiguracionTorneosByTipoCobroAndActivo(tipoCobro, activo == null ? Boolean.FALSE : activo) / sizeNo;
            uiModel.addAttribute("maxPages", (int) ((nrOfPages > (int) nrOfPages || nrOfPages == 0.0) ? nrOfPages + 1 : nrOfPages));
        } else {
            uiModel.addAttribute("configuraciontorneos", ConfiguracionTorneo.findConfiguracionTorneosByTipoCobroAndActivo(tipoCobro, activo == null ? Boolean.FALSE : activo, sortFieldName, sortOrder).getResultList());
        }
        addDateTimeFormatPatterns(uiModel);
        return "configuraciontorneos/list";
    }

	@RequestMapping(params = { "find=ByTorneoAndActivo", "form" }, method = RequestMethod.GET)
    public String findConfiguracionTorneosByTorneoAndActivoForm(Model uiModel) {
        uiModel.addAttribute("torneos", Torneo.findAllTorneos());
        return "configuraciontorneos/findConfiguracionTorneosByTorneoAndActivo";
    }

	@RequestMapping(params = "find=ByTorneoAndActivo", method = RequestMethod.GET)
    public String findConfiguracionTorneosByTorneoAndActivo(@RequestParam("torneo") Torneo torneo, @RequestParam(value = "activo", required = false) Boolean activo, @RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, @RequestParam(value = "sortFieldName", required = false) String sortFieldName, @RequestParam(value = "sortOrder", required = false) String sortOrder, Model uiModel) {
        if (page != null || size != null) {
            int sizeNo = size == null ? 10 : size.intValue();
            final int firstResult = page == null ? 0 : (page.intValue() - 1) * sizeNo;
            uiModel.addAttribute("configuraciontorneos", ConfiguracionTorneo.findConfiguracionTorneosByTorneoAndActivo(torneo, activo == null ? Boolean.FALSE : activo, sortFieldName, sortOrder).setFirstResult(firstResult).setMaxResults(sizeNo).getResultList());
            float nrOfPages = (float) ConfiguracionTorneo.countFindConfiguracionTorneosByTorneoAndActivo(torneo, activo == null ? Boolean.FALSE : activo) / sizeNo;
            uiModel.addAttribute("maxPages", (int) ((nrOfPages > (int) nrOfPages || nrOfPages == 0.0) ? nrOfPages + 1 : nrOfPages));
        } else {
            uiModel.addAttribute("configuraciontorneos", ConfiguracionTorneo.findConfiguracionTorneosByTorneoAndActivo(torneo, activo == null ? Boolean.FALSE : activo, sortFieldName, sortOrder).getResultList());
        }
        addDateTimeFormatPatterns(uiModel);
        return "configuraciontorneos/list";
    }

	@RequestMapping(method = RequestMethod.POST, produces = "text/html")
    public String create(@Valid ConfiguracionTorneo configuracionTorneo, BindingResult bindingResult, Model uiModel, HttpServletRequest httpServletRequest) {
        if (bindingResult.hasErrors()) {
            populateEditForm(uiModel, configuracionTorneo);
            return "configuraciontorneos/create";
        }
        uiModel.asMap().clear();
        configuracionTorneo.persist();
        return "redirect:/configuraciontorneos/" + encodeUrlPathSegment(configuracionTorneo.getId().toString(), httpServletRequest);
    }

	@RequestMapping(params = "form", produces = "text/html")
    public String createForm(Model uiModel) {
        populateEditForm(uiModel, new ConfiguracionTorneo());
        List<String[]> dependencies = new ArrayList<String[]>();
        if (Torneo.countTorneos() == 0) {
            dependencies.add(new String[] { "torneo", "torneos" });
        }
        uiModel.addAttribute("dependencies", dependencies);
        return "configuraciontorneos/create";
    }

	@RequestMapping(value = "/{id}", produces = "text/html")
    public String show(@PathVariable("id") Long id, Model uiModel) {
        addDateTimeFormatPatterns(uiModel);
        uiModel.addAttribute("configuraciontorneo", ConfiguracionTorneo.findConfiguracionTorneo(id));
        uiModel.addAttribute("itemId", id);
        return "configuraciontorneos/show";
    }

	@RequestMapping(produces = "text/html")
    public String list(@RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, @RequestParam(value = "sortFieldName", required = false) String sortFieldName, @RequestParam(value = "sortOrder", required = false) String sortOrder, Model uiModel) {
        if (page != null || size != null) {
            int sizeNo = size == null ? 10 : size.intValue();
            final int firstResult = page == null ? 0 : (page.intValue() - 1) * sizeNo;
            uiModel.addAttribute("configuraciontorneos", ConfiguracionTorneo.findConfiguracionTorneoEntries(firstResult, sizeNo, sortFieldName, sortOrder));
            float nrOfPages = (float) ConfiguracionTorneo.countConfiguracionTorneos() / sizeNo;
            uiModel.addAttribute("maxPages", (int) ((nrOfPages > (int) nrOfPages || nrOfPages == 0.0) ? nrOfPages + 1 : nrOfPages));
        } else {
            uiModel.addAttribute("configuraciontorneos", ConfiguracionTorneo.findAllConfiguracionTorneos(sortFieldName, sortOrder));
        }
        addDateTimeFormatPatterns(uiModel);
        return "configuraciontorneos/list";
    }

	@RequestMapping(method = RequestMethod.PUT, produces = "text/html")
    public String update(@Valid ConfiguracionTorneo configuracionTorneo, BindingResult bindingResult, Model uiModel, HttpServletRequest httpServletRequest) {
        if (bindingResult.hasErrors()) {
            populateEditForm(uiModel, configuracionTorneo);
            return "configuraciontorneos/update";
        }
        uiModel.asMap().clear();
        configuracionTorneo.merge();
        return "redirect:/configuraciontorneos/" + encodeUrlPathSegment(configuracionTorneo.getId().toString(), httpServletRequest);
    }

	@RequestMapping(value = "/{id}", params = "form", produces = "text/html")
    public String updateForm(@PathVariable("id") Long id, Model uiModel) {
        populateEditForm(uiModel, ConfiguracionTorneo.findConfiguracionTorneo(id));
        return "configuraciontorneos/update";
    }

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = "text/html")
    public String delete(@PathVariable("id") Long id, @RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, Model uiModel) {
        ConfiguracionTorneo configuracionTorneo = ConfiguracionTorneo.findConfiguracionTorneo(id);
        configuracionTorneo.remove();
        uiModel.asMap().clear();
        uiModel.addAttribute("page", (page == null) ? "1" : page.toString());
        uiModel.addAttribute("size", (size == null) ? "10" : size.toString());
        return "redirect:/configuraciontorneos";
    }

	void addDateTimeFormatPatterns(Model uiModel) {
        uiModel.addAttribute("configuracionTorneo_fechacreacion_date_format", DateTimeFormat.patternForStyle("M-", LocaleContextHolder.getLocale()));
        uiModel.addAttribute("configuracionTorneo_fechamodificacion_date_format", DateTimeFormat.patternForStyle("M-", LocaleContextHolder.getLocale()));
    }

	void populateEditForm(Model uiModel, ConfiguracionTorneo configuracionTorneo) {
        uiModel.addAttribute("configuracionTorneo", configuracionTorneo);
        addDateTimeFormatPatterns(uiModel);
        uiModel.addAttribute("diasjuegoes", DiasJuego.findAllDiasJuegoes());
        uiModel.addAttribute("tipocobroes", TipoCobro.findAllTipoCobroes());
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
        ConfiguracionTorneo configuracionTorneo = ConfiguracionTorneo.findConfiguracionTorneo(id);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json; charset=utf-8");
        if (configuracionTorneo == null) {
            return new ResponseEntity<String>(headers, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<String>(configuracionTorneo.toJson(), headers, HttpStatus.OK);
    }

	@RequestMapping(headers = "Accept=application/json")
    @ResponseBody
    public ResponseEntity<String> listJson() {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json; charset=utf-8");
        List<ConfiguracionTorneo> result = ConfiguracionTorneo.findAllConfiguracionTorneos();
        return new ResponseEntity<String>(ConfiguracionTorneo.toJsonArray(result), headers, HttpStatus.OK);
    }

	@RequestMapping(method = RequestMethod.POST, headers = "Accept=application/json")
    public ResponseEntity<String> createFromJson(@RequestBody String json, UriComponentsBuilder uriBuilder) {
        ConfiguracionTorneo configuracionTorneo = ConfiguracionTorneo.fromJsonToConfiguracionTorneo(json);
        configuracionTorneo.persist();
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        RequestMapping a = (RequestMapping) getClass().getAnnotation(RequestMapping.class);
        headers.add("Location",uriBuilder.path(a.value()[0]+"/"+configuracionTorneo.getId().toString()).build().toUriString());
        return new ResponseEntity<String>(headers, HttpStatus.CREATED);
    }

	@RequestMapping(value = "/jsonArray", method = RequestMethod.POST, headers = "Accept=application/json")
    public ResponseEntity<String> createFromJsonArray(@RequestBody String json) {
        for (ConfiguracionTorneo configuracionTorneo: ConfiguracionTorneo.fromJsonArrayToConfiguracionTorneos(json)) {
            configuracionTorneo.persist();
        }
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        return new ResponseEntity<String>(headers, HttpStatus.CREATED);
    }

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, headers = "Accept=application/json")
    public ResponseEntity<String> updateFromJson(@RequestBody String json, @PathVariable("id") Long id) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        ConfiguracionTorneo configuracionTorneo = ConfiguracionTorneo.fromJsonToConfiguracionTorneo(json);
        configuracionTorneo.setId(id);
        if (configuracionTorneo.merge() == null) {
            return new ResponseEntity<String>(headers, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<String>(headers, HttpStatus.OK);
    }

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
    public ResponseEntity<String> deleteFromJson(@PathVariable("id") Long id) {
        ConfiguracionTorneo configuracionTorneo = ConfiguracionTorneo.findConfiguracionTorneo(id);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        if (configuracionTorneo == null) {
            return new ResponseEntity<String>(headers, HttpStatus.NOT_FOUND);
        }
        configuracionTorneo.remove();
        return new ResponseEntity<String>(headers, HttpStatus.OK);
    }

	@RequestMapping(params = "find=ByInscripcionAndActivo", headers = "Accept=application/json")
    @ResponseBody
    public ResponseEntity<String> jsonFindConfiguracionTorneosByInscripcionAndActivo(@RequestParam(value = "inscripcion", required = false) Boolean inscripcion, @RequestParam(value = "activo", required = false) Boolean activo) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json; charset=utf-8");
        return new ResponseEntity<String>(ConfiguracionTorneo.toJsonArray(ConfiguracionTorneo.findConfiguracionTorneosByInscripcionAndActivo(inscripcion == null ? Boolean.FALSE : inscripcion, activo == null ? Boolean.FALSE : activo).getResultList()), headers, HttpStatus.OK);
    }

	@RequestMapping(params = "find=ByTipoCobroAndActivo", headers = "Accept=application/json")
    @ResponseBody
    public ResponseEntity<String> jsonFindConfiguracionTorneosByTipoCobroAndActivo(@RequestParam("tipoCobro") TipoCobro tipoCobro, @RequestParam(value = "activo", required = false) Boolean activo) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json; charset=utf-8");
        return new ResponseEntity<String>(ConfiguracionTorneo.toJsonArray(ConfiguracionTorneo.findConfiguracionTorneosByTipoCobroAndActivo(tipoCobro, activo == null ? Boolean.FALSE : activo).getResultList()), headers, HttpStatus.OK);
    }

	@RequestMapping(params = "find=ByTorneoAndActivo", headers = "Accept=application/json")
    @ResponseBody
    public ResponseEntity<String> jsonFindConfiguracionTorneosByTorneoAndActivo(@RequestParam("torneo") Torneo torneo, @RequestParam(value = "activo", required = false) Boolean activo) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json; charset=utf-8");
        return new ResponseEntity<String>(ConfiguracionTorneo.toJsonArray(ConfiguracionTorneo.findConfiguracionTorneosByTorneoAndActivo(torneo, activo == null ? Boolean.FALSE : activo).getResultList()), headers, HttpStatus.OK);
    }
}
