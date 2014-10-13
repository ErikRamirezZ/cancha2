package com.raze.cancha.controller;
import com.raze.cancha.catalog.ConceptoCobro;
import com.raze.cancha.catalog.StatusCargoAbono;
import com.raze.cancha.domain.Abono;
import com.raze.cancha.domain.Cargo;
import com.raze.cancha.domain.Equipo;
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

@RooWebJson(jsonObject = Cargo.class)
@Controller
@RequestMapping("/cargoes")
@RooWebScaffold(path = "cargoes", formBackingObject = Cargo.class)
@RooWebFinder
public class CargoController {

	@RequestMapping(method = RequestMethod.POST, produces = "text/html")
    public String create(@Valid Cargo cargo, BindingResult bindingResult, Model uiModel, HttpServletRequest httpServletRequest) {
        if (bindingResult.hasErrors()) {
            populateEditForm(uiModel, cargo);
            return "cargoes/create";
        }
        uiModel.asMap().clear();
        cargo.persist();
        return "redirect:/cargoes/" + encodeUrlPathSegment(cargo.getId().toString(), httpServletRequest);
    }

	@RequestMapping(params = "form", produces = "text/html")
    public String createForm(Model uiModel) {
        populateEditForm(uiModel, new Cargo());
        List<String[]> dependencies = new ArrayList<String[]>();
        if (ConceptoCobro.countConceptoCobroes() == 0) {
            dependencies.add(new String[] { "conceptocobro", "conceptocobroes" });
        }
        if (Torneo.countTorneos() == 0) {
            dependencies.add(new String[] { "torneo", "torneos" });
        }
        if (Equipo.countEquipoes() == 0) {
            dependencies.add(new String[] { "equipo", "equipoes" });
        }
        uiModel.addAttribute("dependencies", dependencies);
        return "cargoes/create";
    }

	@RequestMapping(value = "/{id}", produces = "text/html")
    public String show(@PathVariable("id") Long id, Model uiModel) {
        addDateTimeFormatPatterns(uiModel);
        uiModel.addAttribute("cargo", Cargo.findCargo(id));
        uiModel.addAttribute("itemId", id);
        return "cargoes/show";
    }

	@RequestMapping(produces = "text/html")
    public String list(@RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, @RequestParam(value = "sortFieldName", required = false) String sortFieldName, @RequestParam(value = "sortOrder", required = false) String sortOrder, Model uiModel) {
        if (page != null || size != null) {
            int sizeNo = size == null ? 10 : size.intValue();
            final int firstResult = page == null ? 0 : (page.intValue() - 1) * sizeNo;
            uiModel.addAttribute("cargoes", Cargo.findCargoEntries(firstResult, sizeNo, sortFieldName, sortOrder));
            float nrOfPages = (float) Cargo.countCargoes() / sizeNo;
            uiModel.addAttribute("maxPages", (int) ((nrOfPages > (int) nrOfPages || nrOfPages == 0.0) ? nrOfPages + 1 : nrOfPages));
        } else {
            uiModel.addAttribute("cargoes", Cargo.findAllCargoes(sortFieldName, sortOrder));
        }
        addDateTimeFormatPatterns(uiModel);
        return "cargoes/list";
    }

	@RequestMapping(method = RequestMethod.PUT, produces = "text/html")
    public String update(@Valid Cargo cargo, BindingResult bindingResult, Model uiModel, HttpServletRequest httpServletRequest) {
        if (bindingResult.hasErrors()) {
            populateEditForm(uiModel, cargo);
            return "cargoes/update";
        }
        uiModel.asMap().clear();
        cargo.merge();
        return "redirect:/cargoes/" + encodeUrlPathSegment(cargo.getId().toString(), httpServletRequest);
    }

	@RequestMapping(value = "/{id}", params = "form", produces = "text/html")
    public String updateForm(@PathVariable("id") Long id, Model uiModel) {
        populateEditForm(uiModel, Cargo.findCargo(id));
        return "cargoes/update";
    }

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = "text/html")
    public String delete(@PathVariable("id") Long id, @RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, Model uiModel) {
        Cargo cargo = Cargo.findCargo(id);
        cargo.remove();
        uiModel.asMap().clear();
        uiModel.addAttribute("page", (page == null) ? "1" : page.toString());
        uiModel.addAttribute("size", (size == null) ? "10" : size.toString());
        return "redirect:/cargoes";
    }

	void addDateTimeFormatPatterns(Model uiModel) {
        uiModel.addAttribute("cargo_fechacreacion_date_format", org.joda.time.format.DateTimeFormat.patternForStyle("M-", LocaleContextHolder.getLocale()));
        uiModel.addAttribute("cargo_fechamodificacion_date_format", org.joda.time.format.DateTimeFormat.patternForStyle("M-", LocaleContextHolder.getLocale()));
    }

	void populateEditForm(Model uiModel, Cargo cargo) {
        uiModel.addAttribute("cargo", cargo);
        addDateTimeFormatPatterns(uiModel);
        uiModel.addAttribute("conceptocobroes", ConceptoCobro.findAllConceptoCobroes());
        uiModel.addAttribute("statuscargoabonoes", StatusCargoAbono.findAllStatusCargoAbonoes());
        uiModel.addAttribute("abonoes", Abono.findAllAbonoes());
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
        Cargo cargo = Cargo.findCargo(id);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json; charset=utf-8");
        if (cargo == null) {
            return new ResponseEntity<String>(headers, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<String>(cargo.toJson(), headers, HttpStatus.OK);
    }

	@RequestMapping(headers = "Accept=application/json")
    @ResponseBody
    public ResponseEntity<String> listJson() {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json; charset=utf-8");
        List<Cargo> result = Cargo.findAllCargoes();
        return new ResponseEntity<String>(Cargo.toJsonArray(result), headers, HttpStatus.OK);
    }

	@RequestMapping(method = RequestMethod.POST, headers = "Accept=application/json")
    public ResponseEntity<String> createFromJson(@RequestBody String json, UriComponentsBuilder uriBuilder) {
        Cargo cargo = Cargo.fromJsonToCargo(json);
        cargo.persist();
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        RequestMapping a = (RequestMapping) getClass().getAnnotation(RequestMapping.class);
        headers.add("Location",uriBuilder.path(a.value()[0]+"/"+cargo.getId().toString()).build().toUriString());
        return new ResponseEntity<String>(headers, HttpStatus.CREATED);
    }

	@RequestMapping(value = "/jsonArray", method = RequestMethod.POST, headers = "Accept=application/json")
    public ResponseEntity<String> createFromJsonArray(@RequestBody String json) {
        for (Cargo cargo: Cargo.fromJsonArrayToCargoes(json)) {
            cargo.persist();
        }
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        return new ResponseEntity<String>(headers, HttpStatus.CREATED);
    }

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, headers = "Accept=application/json")
    public ResponseEntity<String> updateFromJson(@RequestBody String json, @PathVariable("id") Long id) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        Cargo cargo = Cargo.fromJsonToCargo(json);
        cargo.setId(id);
        if (cargo.merge() == null) {
            return new ResponseEntity<String>(headers, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<String>(headers, HttpStatus.OK);
    }

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
    public ResponseEntity<String> deleteFromJson(@PathVariable("id") Long id) {
        Cargo cargo = Cargo.findCargo(id);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        if (cargo == null) {
            return new ResponseEntity<String>(headers, HttpStatus.NOT_FOUND);
        }
        cargo.remove();
        return new ResponseEntity<String>(headers, HttpStatus.OK);
    }

	@RequestMapping(params = "find=ByConceptoCobroAndFechaCreacionBetween", headers = "Accept=application/json")
    @ResponseBody
    public ResponseEntity<String> jsonFindCargoesByConceptoCobroAndFechaCreacionBetween(@RequestParam("conceptoCobro") ConceptoCobro conceptoCobro, @RequestParam("minFechaCreacion") @DateTimeFormat(style = "M-") Date minFechaCreacion, @RequestParam("maxFechaCreacion") @DateTimeFormat(style = "M-") Date maxFechaCreacion) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json; charset=utf-8");
        return new ResponseEntity<String>(Cargo.toJsonArray(Cargo.findCargoesByConceptoCobroAndFechaCreacionBetween(conceptoCobro, minFechaCreacion, maxFechaCreacion).getResultList()), headers, HttpStatus.OK);
    }

	@RequestMapping(params = "find=ByConceptoCobroAndStatus", headers = "Accept=application/json")
    @ResponseBody
    public ResponseEntity<String> jsonFindCargoesByConceptoCobroAndStatus(@RequestParam("conceptoCobro") ConceptoCobro conceptoCobro, @RequestParam("status") StatusCargoAbono status) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json; charset=utf-8");
        return new ResponseEntity<String>(Cargo.toJsonArray(Cargo.findCargoesByConceptoCobroAndStatus(conceptoCobro, status).getResultList()), headers, HttpStatus.OK);
    }

	@RequestMapping(params = "find=ByConceptoCobroAndTorneo", headers = "Accept=application/json")
    @ResponseBody
    public ResponseEntity<String> jsonFindCargoesByConceptoCobroAndTorneo(@RequestParam("conceptoCobro") ConceptoCobro conceptoCobro, @RequestParam("torneo") Torneo torneo) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json; charset=utf-8");
        return new ResponseEntity<String>(Cargo.toJsonArray(Cargo.findCargoesByConceptoCobroAndTorneo(conceptoCobro, torneo).getResultList()), headers, HttpStatus.OK);
    }

	@RequestMapping(params = "find=ByConceptoCobroAndTorneoAndEquipo", headers = "Accept=application/json")
    @ResponseBody
    public ResponseEntity<String> jsonFindCargoesByConceptoCobroAndTorneoAndEquipo(@RequestParam("conceptoCobro") ConceptoCobro conceptoCobro, @RequestParam("torneo") Torneo torneo, @RequestParam("equipo") Equipo equipo) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json; charset=utf-8");
        return new ResponseEntity<String>(Cargo.toJsonArray(Cargo.findCargoesByConceptoCobroAndTorneoAndEquipo(conceptoCobro, torneo, equipo).getResultList()), headers, HttpStatus.OK);
    }

	@RequestMapping(params = "find=ByConceptoCobroAndTorneoAndEquipoAndFechaModificacionBetween", headers = "Accept=application/json")
    @ResponseBody
    public ResponseEntity<String> jsonFindCargoesByConceptoCobroAndTorneoAndEquipoAndFechaModificacionBetween(@RequestParam("conceptoCobro") ConceptoCobro conceptoCobro, @RequestParam("torneo") Torneo torneo, @RequestParam("equipo") Equipo equipo, @RequestParam("minFechaModificacion") @DateTimeFormat(style = "M-") Date minFechaModificacion, @RequestParam("maxFechaModificacion") @DateTimeFormat(style = "M-") Date maxFechaModificacion) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json; charset=utf-8");
        return new ResponseEntity<String>(Cargo.toJsonArray(Cargo.findCargoesByConceptoCobroAndTorneoAndEquipoAndFechaModificacionBetween(conceptoCobro, torneo, equipo, minFechaModificacion, maxFechaModificacion).getResultList()), headers, HttpStatus.OK);
    }

	@RequestMapping(params = "find=ByConceptoCobroAndTorneoAndFechaModificacionBetween", headers = "Accept=application/json")
    @ResponseBody
    public ResponseEntity<String> jsonFindCargoesByConceptoCobroAndTorneoAndFechaModificacionBetween(@RequestParam("conceptoCobro") ConceptoCobro conceptoCobro, @RequestParam("torneo") Torneo torneo, @RequestParam("minFechaModificacion") @DateTimeFormat(style = "M-") Date minFechaModificacion, @RequestParam("maxFechaModificacion") @DateTimeFormat(style = "M-") Date maxFechaModificacion) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json; charset=utf-8");
        return new ResponseEntity<String>(Cargo.toJsonArray(Cargo.findCargoesByConceptoCobroAndTorneoAndFechaModificacionBetween(conceptoCobro, torneo, minFechaModificacion, maxFechaModificacion).getResultList()), headers, HttpStatus.OK);
    }

	@RequestMapping(params = { "find=ByConceptoCobroAndFechaCreacionBetween", "form" }, method = RequestMethod.GET)
    public String findCargoesByConceptoCobroAndFechaCreacionBetweenForm(Model uiModel) {
        uiModel.addAttribute("conceptocobroes", ConceptoCobro.findAllConceptoCobroes());
        addDateTimeFormatPatterns(uiModel);
        return "cargoes/findCargoesByConceptoCobroAndFechaCreacionBetween";
    }

	@RequestMapping(params = "find=ByConceptoCobroAndFechaCreacionBetween", method = RequestMethod.GET)
    public String findCargoesByConceptoCobroAndFechaCreacionBetween(@RequestParam("conceptoCobro") ConceptoCobro conceptoCobro, @RequestParam("minFechaCreacion") @DateTimeFormat(style = "M-") Date minFechaCreacion, @RequestParam("maxFechaCreacion") @DateTimeFormat(style = "M-") Date maxFechaCreacion, @RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, @RequestParam(value = "sortFieldName", required = false) String sortFieldName, @RequestParam(value = "sortOrder", required = false) String sortOrder, Model uiModel) {
        if (page != null || size != null) {
            int sizeNo = size == null ? 10 : size.intValue();
            final int firstResult = page == null ? 0 : (page.intValue() - 1) * sizeNo;
            uiModel.addAttribute("cargoes", Cargo.findCargoesByConceptoCobroAndFechaCreacionBetween(conceptoCobro, minFechaCreacion, maxFechaCreacion, sortFieldName, sortOrder).setFirstResult(firstResult).setMaxResults(sizeNo).getResultList());
            float nrOfPages = (float) Cargo.countFindCargoesByConceptoCobroAndFechaCreacionBetween(conceptoCobro, minFechaCreacion, maxFechaCreacion) / sizeNo;
            uiModel.addAttribute("maxPages", (int) ((nrOfPages > (int) nrOfPages || nrOfPages == 0.0) ? nrOfPages + 1 : nrOfPages));
        } else {
            uiModel.addAttribute("cargoes", Cargo.findCargoesByConceptoCobroAndFechaCreacionBetween(conceptoCobro, minFechaCreacion, maxFechaCreacion, sortFieldName, sortOrder).getResultList());
        }
        addDateTimeFormatPatterns(uiModel);
        return "cargoes/list";
    }

	@RequestMapping(params = { "find=ByConceptoCobroAndStatus", "form" }, method = RequestMethod.GET)
    public String findCargoesByConceptoCobroAndStatusForm(Model uiModel) {
        uiModel.addAttribute("conceptocobroes", ConceptoCobro.findAllConceptoCobroes());
        uiModel.addAttribute("statuscargoabonoes", StatusCargoAbono.findAllStatusCargoAbonoes());
        return "cargoes/findCargoesByConceptoCobroAndStatus";
    }

	@RequestMapping(params = "find=ByConceptoCobroAndStatus", method = RequestMethod.GET)
    public String findCargoesByConceptoCobroAndStatus(@RequestParam("conceptoCobro") ConceptoCobro conceptoCobro, @RequestParam("status") StatusCargoAbono status, @RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, @RequestParam(value = "sortFieldName", required = false) String sortFieldName, @RequestParam(value = "sortOrder", required = false) String sortOrder, Model uiModel) {
        if (page != null || size != null) {
            int sizeNo = size == null ? 10 : size.intValue();
            final int firstResult = page == null ? 0 : (page.intValue() - 1) * sizeNo;
            uiModel.addAttribute("cargoes", Cargo.findCargoesByConceptoCobroAndStatus(conceptoCobro, status, sortFieldName, sortOrder).setFirstResult(firstResult).setMaxResults(sizeNo).getResultList());
            float nrOfPages = (float) Cargo.countFindCargoesByConceptoCobroAndStatus(conceptoCobro, status) / sizeNo;
            uiModel.addAttribute("maxPages", (int) ((nrOfPages > (int) nrOfPages || nrOfPages == 0.0) ? nrOfPages + 1 : nrOfPages));
        } else {
            uiModel.addAttribute("cargoes", Cargo.findCargoesByConceptoCobroAndStatus(conceptoCobro, status, sortFieldName, sortOrder).getResultList());
        }
        addDateTimeFormatPatterns(uiModel);
        return "cargoes/list";
    }

	@RequestMapping(params = { "find=ByConceptoCobroAndTorneo", "form" }, method = RequestMethod.GET)
    public String findCargoesByConceptoCobroAndTorneoForm(Model uiModel) {
        uiModel.addAttribute("conceptocobroes", ConceptoCobro.findAllConceptoCobroes());
        uiModel.addAttribute("torneos", Torneo.findAllTorneos());
        return "cargoes/findCargoesByConceptoCobroAndTorneo";
    }

	@RequestMapping(params = "find=ByConceptoCobroAndTorneo", method = RequestMethod.GET)
    public String findCargoesByConceptoCobroAndTorneo(@RequestParam("conceptoCobro") ConceptoCobro conceptoCobro, @RequestParam("torneo") Torneo torneo, @RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, @RequestParam(value = "sortFieldName", required = false) String sortFieldName, @RequestParam(value = "sortOrder", required = false) String sortOrder, Model uiModel) {
        if (page != null || size != null) {
            int sizeNo = size == null ? 10 : size.intValue();
            final int firstResult = page == null ? 0 : (page.intValue() - 1) * sizeNo;
            uiModel.addAttribute("cargoes", Cargo.findCargoesByConceptoCobroAndTorneo(conceptoCobro, torneo, sortFieldName, sortOrder).setFirstResult(firstResult).setMaxResults(sizeNo).getResultList());
            float nrOfPages = (float) Cargo.countFindCargoesByConceptoCobroAndTorneo(conceptoCobro, torneo) / sizeNo;
            uiModel.addAttribute("maxPages", (int) ((nrOfPages > (int) nrOfPages || nrOfPages == 0.0) ? nrOfPages + 1 : nrOfPages));
        } else {
            uiModel.addAttribute("cargoes", Cargo.findCargoesByConceptoCobroAndTorneo(conceptoCobro, torneo, sortFieldName, sortOrder).getResultList());
        }
        addDateTimeFormatPatterns(uiModel);
        return "cargoes/list";
    }

	@RequestMapping(params = { "find=ByConceptoCobroAndTorneoAndEquipo", "form" }, method = RequestMethod.GET)
    public String findCargoesByConceptoCobroAndTorneoAndEquipoForm(Model uiModel) {
        uiModel.addAttribute("conceptocobroes", ConceptoCobro.findAllConceptoCobroes());
        uiModel.addAttribute("torneos", Torneo.findAllTorneos());
        uiModel.addAttribute("equipoes", Equipo.findAllEquipoes());
        return "cargoes/findCargoesByConceptoCobroAndTorneoAndEquipo";
    }

	@RequestMapping(params = "find=ByConceptoCobroAndTorneoAndEquipo", method = RequestMethod.GET)
    public String findCargoesByConceptoCobroAndTorneoAndEquipo(@RequestParam("conceptoCobro") ConceptoCobro conceptoCobro, @RequestParam("torneo") Torneo torneo, @RequestParam("equipo") Equipo equipo, @RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, @RequestParam(value = "sortFieldName", required = false) String sortFieldName, @RequestParam(value = "sortOrder", required = false) String sortOrder, Model uiModel) {
        if (page != null || size != null) {
            int sizeNo = size == null ? 10 : size.intValue();
            final int firstResult = page == null ? 0 : (page.intValue() - 1) * sizeNo;
            uiModel.addAttribute("cargoes", Cargo.findCargoesByConceptoCobroAndTorneoAndEquipo(conceptoCobro, torneo, equipo, sortFieldName, sortOrder).setFirstResult(firstResult).setMaxResults(sizeNo).getResultList());
            float nrOfPages = (float) Cargo.countFindCargoesByConceptoCobroAndTorneoAndEquipo(conceptoCobro, torneo, equipo) / sizeNo;
            uiModel.addAttribute("maxPages", (int) ((nrOfPages > (int) nrOfPages || nrOfPages == 0.0) ? nrOfPages + 1 : nrOfPages));
        } else {
            uiModel.addAttribute("cargoes", Cargo.findCargoesByConceptoCobroAndTorneoAndEquipo(conceptoCobro, torneo, equipo, sortFieldName, sortOrder).getResultList());
        }
        addDateTimeFormatPatterns(uiModel);
        return "cargoes/list";
    }

	@RequestMapping(params = { "find=ByConceptoCobroAndTorneoAndEquipoAndFechaModificacionBetween", "form" }, method = RequestMethod.GET)
    public String findCargoesByConceptoCobroAndTorneoAndEquipoAndFechaModificacionBetweenForm(Model uiModel) {
        uiModel.addAttribute("conceptocobroes", ConceptoCobro.findAllConceptoCobroes());
        uiModel.addAttribute("torneos", Torneo.findAllTorneos());
        uiModel.addAttribute("equipoes", Equipo.findAllEquipoes());
        addDateTimeFormatPatterns(uiModel);
        return "cargoes/findCargoesByConceptoCobroAndTorneoAndEquipoAndFechaModificacionBetween";
    }

	@RequestMapping(params = "find=ByConceptoCobroAndTorneoAndEquipoAndFechaModificacionBetween", method = RequestMethod.GET)
    public String findCargoesByConceptoCobroAndTorneoAndEquipoAndFechaModificacionBetween(@RequestParam("conceptoCobro") ConceptoCobro conceptoCobro, @RequestParam("torneo") Torneo torneo, @RequestParam("equipo") Equipo equipo, @RequestParam("minFechaModificacion") @DateTimeFormat(style = "M-") Date minFechaModificacion, @RequestParam("maxFechaModificacion") @DateTimeFormat(style = "M-") Date maxFechaModificacion, @RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, @RequestParam(value = "sortFieldName", required = false) String sortFieldName, @RequestParam(value = "sortOrder", required = false) String sortOrder, Model uiModel) {
        if (page != null || size != null) {
            int sizeNo = size == null ? 10 : size.intValue();
            final int firstResult = page == null ? 0 : (page.intValue() - 1) * sizeNo;
            uiModel.addAttribute("cargoes", Cargo.findCargoesByConceptoCobroAndTorneoAndEquipoAndFechaModificacionBetween(conceptoCobro, torneo, equipo, minFechaModificacion, maxFechaModificacion, sortFieldName, sortOrder).setFirstResult(firstResult).setMaxResults(sizeNo).getResultList());
            float nrOfPages = (float) Cargo.countFindCargoesByConceptoCobroAndTorneoAndEquipoAndFechaModificacionBetween(conceptoCobro, torneo, equipo, minFechaModificacion, maxFechaModificacion) / sizeNo;
            uiModel.addAttribute("maxPages", (int) ((nrOfPages > (int) nrOfPages || nrOfPages == 0.0) ? nrOfPages + 1 : nrOfPages));
        } else {
            uiModel.addAttribute("cargoes", Cargo.findCargoesByConceptoCobroAndTorneoAndEquipoAndFechaModificacionBetween(conceptoCobro, torneo, equipo, minFechaModificacion, maxFechaModificacion, sortFieldName, sortOrder).getResultList());
        }
        addDateTimeFormatPatterns(uiModel);
        return "cargoes/list";
    }

	@RequestMapping(params = { "find=ByConceptoCobroAndTorneoAndFechaModificacionBetween", "form" }, method = RequestMethod.GET)
    public String findCargoesByConceptoCobroAndTorneoAndFechaModificacionBetweenForm(Model uiModel) {
        uiModel.addAttribute("conceptocobroes", ConceptoCobro.findAllConceptoCobroes());
        uiModel.addAttribute("torneos", Torneo.findAllTorneos());
        addDateTimeFormatPatterns(uiModel);
        return "cargoes/findCargoesByConceptoCobroAndTorneoAndFechaModificacionBetween";
    }

	@RequestMapping(params = "find=ByConceptoCobroAndTorneoAndFechaModificacionBetween", method = RequestMethod.GET)
    public String findCargoesByConceptoCobroAndTorneoAndFechaModificacionBetween(@RequestParam("conceptoCobro") ConceptoCobro conceptoCobro, @RequestParam("torneo") Torneo torneo, @RequestParam("minFechaModificacion") @DateTimeFormat(style = "M-") Date minFechaModificacion, @RequestParam("maxFechaModificacion") @DateTimeFormat(style = "M-") Date maxFechaModificacion, @RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, @RequestParam(value = "sortFieldName", required = false) String sortFieldName, @RequestParam(value = "sortOrder", required = false) String sortOrder, Model uiModel) {
        if (page != null || size != null) {
            int sizeNo = size == null ? 10 : size.intValue();
            final int firstResult = page == null ? 0 : (page.intValue() - 1) * sizeNo;
            uiModel.addAttribute("cargoes", Cargo.findCargoesByConceptoCobroAndTorneoAndFechaModificacionBetween(conceptoCobro, torneo, minFechaModificacion, maxFechaModificacion, sortFieldName, sortOrder).setFirstResult(firstResult).setMaxResults(sizeNo).getResultList());
            float nrOfPages = (float) Cargo.countFindCargoesByConceptoCobroAndTorneoAndFechaModificacionBetween(conceptoCobro, torneo, minFechaModificacion, maxFechaModificacion) / sizeNo;
            uiModel.addAttribute("maxPages", (int) ((nrOfPages > (int) nrOfPages || nrOfPages == 0.0) ? nrOfPages + 1 : nrOfPages));
        } else {
            uiModel.addAttribute("cargoes", Cargo.findCargoesByConceptoCobroAndTorneoAndFechaModificacionBetween(conceptoCobro, torneo, minFechaModificacion, maxFechaModificacion, sortFieldName, sortOrder).getResultList());
        }
        addDateTimeFormatPatterns(uiModel);
        return "cargoes/list";
    }
}
