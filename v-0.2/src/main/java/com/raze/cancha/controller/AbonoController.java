package com.raze.cancha.controller;
import com.raze.cancha.catalog.Descuento;
import com.raze.cancha.catalog.MetodoPago;
import com.raze.cancha.catalog.StatusCargoAbono;
import com.raze.cancha.domain.Abono;
import com.raze.cancha.domain.Cargo;
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

@RooWebJson(jsonObject = Abono.class)
@Controller
@RequestMapping("/abonoes")
@RooWebScaffold(path = "abonoes", formBackingObject = Abono.class)
@RooWebFinder
public class AbonoController {

	@RequestMapping(method = RequestMethod.POST, produces = "text/html")
    public String create(@Valid Abono abono, BindingResult bindingResult, Model uiModel, HttpServletRequest httpServletRequest) {
        if (bindingResult.hasErrors()) {
            populateEditForm(uiModel, abono);
            return "abonoes/create";
        }
        uiModel.asMap().clear();
        abono.persist();
        return "redirect:/abonoes/" + encodeUrlPathSegment(abono.getId().toString(), httpServletRequest);
    }

	@RequestMapping(params = "form", produces = "text/html")
    public String createForm(Model uiModel) {
        populateEditForm(uiModel, new Abono());
        List<String[]> dependencies = new ArrayList<String[]>();
        if (Cargo.countCargoes() == 0) {
            dependencies.add(new String[] { "cargo", "cargoes" });
        }
        if (MetodoPago.countMetodoPagoes() == 0) {
            dependencies.add(new String[] { "metodopago", "metodopagoes" });
        }
        if (StatusCargoAbono.countStatusCargoAbonoes() == 0) {
            dependencies.add(new String[] { "statuscargoabono", "statuscargoabonoes" });
        }
        uiModel.addAttribute("dependencies", dependencies);
        return "abonoes/create";
    }

	@RequestMapping(value = "/{id}", produces = "text/html")
    public String show(@PathVariable("id") Long id, Model uiModel) {
        addDateTimeFormatPatterns(uiModel);
        uiModel.addAttribute("abono", Abono.findAbono(id));
        uiModel.addAttribute("itemId", id);
        return "abonoes/show";
    }

	@RequestMapping(produces = "text/html")
    public String list(@RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, @RequestParam(value = "sortFieldName", required = false) String sortFieldName, @RequestParam(value = "sortOrder", required = false) String sortOrder, Model uiModel) {
        if (page != null || size != null) {
            int sizeNo = size == null ? 10 : size.intValue();
            final int firstResult = page == null ? 0 : (page.intValue() - 1) * sizeNo;
            uiModel.addAttribute("abonoes", Abono.findAbonoEntries(firstResult, sizeNo, sortFieldName, sortOrder));
            float nrOfPages = (float) Abono.countAbonoes() / sizeNo;
            uiModel.addAttribute("maxPages", (int) ((nrOfPages > (int) nrOfPages || nrOfPages == 0.0) ? nrOfPages + 1 : nrOfPages));
        } else {
            uiModel.addAttribute("abonoes", Abono.findAllAbonoes(sortFieldName, sortOrder));
        }
        addDateTimeFormatPatterns(uiModel);
        return "abonoes/list";
    }

	@RequestMapping(method = RequestMethod.PUT, produces = "text/html")
    public String update(@Valid Abono abono, BindingResult bindingResult, Model uiModel, HttpServletRequest httpServletRequest) {
        if (bindingResult.hasErrors()) {
            populateEditForm(uiModel, abono);
            return "abonoes/update";
        }
        uiModel.asMap().clear();
        abono.merge();
        return "redirect:/abonoes/" + encodeUrlPathSegment(abono.getId().toString(), httpServletRequest);
    }

	@RequestMapping(value = "/{id}", params = "form", produces = "text/html")
    public String updateForm(@PathVariable("id") Long id, Model uiModel) {
        populateEditForm(uiModel, Abono.findAbono(id));
        return "abonoes/update";
    }

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = "text/html")
    public String delete(@PathVariable("id") Long id, @RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, Model uiModel) {
        Abono abono = Abono.findAbono(id);
        abono.remove();
        uiModel.asMap().clear();
        uiModel.addAttribute("page", (page == null) ? "1" : page.toString());
        uiModel.addAttribute("size", (size == null) ? "10" : size.toString());
        return "redirect:/abonoes";
    }

	void addDateTimeFormatPatterns(Model uiModel) {
        uiModel.addAttribute("abono_fechacreacion_date_format", org.joda.time.format.DateTimeFormat.patternForStyle("M-", LocaleContextHolder.getLocale()));
        uiModel.addAttribute("abono_fechamodificacion_date_format", org.joda.time.format.DateTimeFormat.patternForStyle("M-", LocaleContextHolder.getLocale()));
    }

	void populateEditForm(Model uiModel, Abono abono) {
        uiModel.addAttribute("abono", abono);
        addDateTimeFormatPatterns(uiModel);
        uiModel.addAttribute("descuentoes", Descuento.findAllDescuentoes());
        uiModel.addAttribute("metodopagoes", MetodoPago.findAllMetodoPagoes());
        uiModel.addAttribute("statuscargoabonoes", StatusCargoAbono.findAllStatusCargoAbonoes());
        uiModel.addAttribute("cargoes", Cargo.findAllCargoes());
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
        Abono abono = Abono.findAbono(id);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json; charset=utf-8");
        if (abono == null) {
            return new ResponseEntity<String>(headers, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<String>(abono.toJson(), headers, HttpStatus.OK);
    }

	@RequestMapping(headers = "Accept=application/json")
    @ResponseBody
    public ResponseEntity<String> listJson() {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json; charset=utf-8");
        List<Abono> result = Abono.findAllAbonoes();
        return new ResponseEntity<String>(Abono.toJsonArray(result), headers, HttpStatus.OK);
    }

	@RequestMapping(method = RequestMethod.POST, headers = "Accept=application/json")
    public ResponseEntity<String> createFromJson(@RequestBody String json, UriComponentsBuilder uriBuilder) {
        Abono abono = Abono.fromJsonToAbono(json);
        abono.persist();
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        RequestMapping a = (RequestMapping) getClass().getAnnotation(RequestMapping.class);
        headers.add("Location",uriBuilder.path(a.value()[0]+"/"+abono.getId().toString()).build().toUriString());
        return new ResponseEntity<String>(headers, HttpStatus.CREATED);
    }

	@RequestMapping(value = "/jsonArray", method = RequestMethod.POST, headers = "Accept=application/json")
    public ResponseEntity<String> createFromJsonArray(@RequestBody String json) {
        for (Abono abono: Abono.fromJsonArrayToAbonoes(json)) {
            abono.persist();
        }
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        return new ResponseEntity<String>(headers, HttpStatus.CREATED);
    }

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, headers = "Accept=application/json")
    public ResponseEntity<String> updateFromJson(@RequestBody String json, @PathVariable("id") Long id) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        Abono abono = Abono.fromJsonToAbono(json);
        abono.setId(id);
        if (abono.merge() == null) {
            return new ResponseEntity<String>(headers, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<String>(headers, HttpStatus.OK);
    }

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
    public ResponseEntity<String> deleteFromJson(@PathVariable("id") Long id) {
        Abono abono = Abono.findAbono(id);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        if (abono == null) {
            return new ResponseEntity<String>(headers, HttpStatus.NOT_FOUND);
        }
        abono.remove();
        return new ResponseEntity<String>(headers, HttpStatus.OK);
    }

	@RequestMapping(params = "find=ByCargoAndFechaCreacionBetween", headers = "Accept=application/json")
    @ResponseBody
    public ResponseEntity<String> jsonFindAbonoesByCargoAndFechaCreacionBetween(@RequestParam("cargo") Cargo cargo, @RequestParam("minFechaCreacion") @DateTimeFormat(style = "M-") Date minFechaCreacion, @RequestParam("maxFechaCreacion") @DateTimeFormat(style = "M-") Date maxFechaCreacion) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json; charset=utf-8");
        return new ResponseEntity<String>(Abono.toJsonArray(Abono.findAbonoesByCargoAndFechaCreacionBetween(cargo, minFechaCreacion, maxFechaCreacion).getResultList()), headers, HttpStatus.OK);
    }

	@RequestMapping(params = "find=ByDescuentoAndFechaCreacionBetween", headers = "Accept=application/json")
    @ResponseBody
    public ResponseEntity<String> jsonFindAbonoesByDescuentoAndFechaCreacionBetween(@RequestParam("descuento") Descuento descuento, @RequestParam("minFechaCreacion") @DateTimeFormat(style = "M-") Date minFechaCreacion, @RequestParam("maxFechaCreacion") @DateTimeFormat(style = "M-") Date maxFechaCreacion) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json; charset=utf-8");
        return new ResponseEntity<String>(Abono.toJsonArray(Abono.findAbonoesByDescuentoAndFechaCreacionBetween(descuento, minFechaCreacion, maxFechaCreacion).getResultList()), headers, HttpStatus.OK);
    }

	@RequestMapping(params = "find=ByMetodoPagoAndFechaCreacionBetween", headers = "Accept=application/json")
    @ResponseBody
    public ResponseEntity<String> jsonFindAbonoesByMetodoPagoAndFechaCreacionBetween(@RequestParam("metodoPago") MetodoPago metodoPago, @RequestParam("minFechaCreacion") @DateTimeFormat(style = "M-") Date minFechaCreacion, @RequestParam("maxFechaCreacion") @DateTimeFormat(style = "M-") Date maxFechaCreacion) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json; charset=utf-8");
        return new ResponseEntity<String>(Abono.toJsonArray(Abono.findAbonoesByMetodoPagoAndFechaCreacionBetween(metodoPago, minFechaCreacion, maxFechaCreacion).getResultList()), headers, HttpStatus.OK);
    }

	@RequestMapping(params = "find=ByStatusAndFechaCreacionBetween", headers = "Accept=application/json")
    @ResponseBody
    public ResponseEntity<String> jsonFindAbonoesByStatusAndFechaCreacionBetween(@RequestParam("status") StatusCargoAbono status, @RequestParam("minFechaCreacion") @DateTimeFormat(style = "M-") Date minFechaCreacion, @RequestParam("maxFechaCreacion") @DateTimeFormat(style = "M-") Date maxFechaCreacion) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json; charset=utf-8");
        return new ResponseEntity<String>(Abono.toJsonArray(Abono.findAbonoesByStatusAndFechaCreacionBetween(status, minFechaCreacion, maxFechaCreacion).getResultList()), headers, HttpStatus.OK);
    }

	@RequestMapping(params = { "find=ByCargoAndFechaCreacionBetween", "form" }, method = RequestMethod.GET)
    public String findAbonoesByCargoAndFechaCreacionBetweenForm(Model uiModel) {
        uiModel.addAttribute("cargoes", Cargo.findAllCargoes());
        addDateTimeFormatPatterns(uiModel);
        return "abonoes/findAbonoesByCargoAndFechaCreacionBetween";
    }

	@RequestMapping(params = "find=ByCargoAndFechaCreacionBetween", method = RequestMethod.GET)
    public String findAbonoesByCargoAndFechaCreacionBetween(@RequestParam("cargo") Cargo cargo, @RequestParam("minFechaCreacion") @DateTimeFormat(style = "M-") Date minFechaCreacion, @RequestParam("maxFechaCreacion") @DateTimeFormat(style = "M-") Date maxFechaCreacion, @RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, @RequestParam(value = "sortFieldName", required = false) String sortFieldName, @RequestParam(value = "sortOrder", required = false) String sortOrder, Model uiModel) {
        if (page != null || size != null) {
            int sizeNo = size == null ? 10 : size.intValue();
            final int firstResult = page == null ? 0 : (page.intValue() - 1) * sizeNo;
            uiModel.addAttribute("abonoes", Abono.findAbonoesByCargoAndFechaCreacionBetween(cargo, minFechaCreacion, maxFechaCreacion, sortFieldName, sortOrder).setFirstResult(firstResult).setMaxResults(sizeNo).getResultList());
            float nrOfPages = (float) Abono.countFindAbonoesByCargoAndFechaCreacionBetween(cargo, minFechaCreacion, maxFechaCreacion) / sizeNo;
            uiModel.addAttribute("maxPages", (int) ((nrOfPages > (int) nrOfPages || nrOfPages == 0.0) ? nrOfPages + 1 : nrOfPages));
        } else {
            uiModel.addAttribute("abonoes", Abono.findAbonoesByCargoAndFechaCreacionBetween(cargo, minFechaCreacion, maxFechaCreacion, sortFieldName, sortOrder).getResultList());
        }
        addDateTimeFormatPatterns(uiModel);
        return "abonoes/list";
    }

	@RequestMapping(params = { "find=ByDescuentoAndFechaCreacionBetween", "form" }, method = RequestMethod.GET)
    public String findAbonoesByDescuentoAndFechaCreacionBetweenForm(Model uiModel) {
        uiModel.addAttribute("descuentoes", Descuento.findAllDescuentoes());
        addDateTimeFormatPatterns(uiModel);
        return "abonoes/findAbonoesByDescuentoAndFechaCreacionBetween";
    }

	@RequestMapping(params = "find=ByDescuentoAndFechaCreacionBetween", method = RequestMethod.GET)
    public String findAbonoesByDescuentoAndFechaCreacionBetween(@RequestParam("descuento") Descuento descuento, @RequestParam("minFechaCreacion") @DateTimeFormat(style = "M-") Date minFechaCreacion, @RequestParam("maxFechaCreacion") @DateTimeFormat(style = "M-") Date maxFechaCreacion, @RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, @RequestParam(value = "sortFieldName", required = false) String sortFieldName, @RequestParam(value = "sortOrder", required = false) String sortOrder, Model uiModel) {
        if (page != null || size != null) {
            int sizeNo = size == null ? 10 : size.intValue();
            final int firstResult = page == null ? 0 : (page.intValue() - 1) * sizeNo;
            uiModel.addAttribute("abonoes", Abono.findAbonoesByDescuentoAndFechaCreacionBetween(descuento, minFechaCreacion, maxFechaCreacion, sortFieldName, sortOrder).setFirstResult(firstResult).setMaxResults(sizeNo).getResultList());
            float nrOfPages = (float) Abono.countFindAbonoesByDescuentoAndFechaCreacionBetween(descuento, minFechaCreacion, maxFechaCreacion) / sizeNo;
            uiModel.addAttribute("maxPages", (int) ((nrOfPages > (int) nrOfPages || nrOfPages == 0.0) ? nrOfPages + 1 : nrOfPages));
        } else {
            uiModel.addAttribute("abonoes", Abono.findAbonoesByDescuentoAndFechaCreacionBetween(descuento, minFechaCreacion, maxFechaCreacion, sortFieldName, sortOrder).getResultList());
        }
        addDateTimeFormatPatterns(uiModel);
        return "abonoes/list";
    }

	@RequestMapping(params = { "find=ByMetodoPagoAndFechaCreacionBetween", "form" }, method = RequestMethod.GET)
    public String findAbonoesByMetodoPagoAndFechaCreacionBetweenForm(Model uiModel) {
        uiModel.addAttribute("metodopagoes", MetodoPago.findAllMetodoPagoes());
        addDateTimeFormatPatterns(uiModel);
        return "abonoes/findAbonoesByMetodoPagoAndFechaCreacionBetween";
    }

	@RequestMapping(params = "find=ByMetodoPagoAndFechaCreacionBetween", method = RequestMethod.GET)
    public String findAbonoesByMetodoPagoAndFechaCreacionBetween(@RequestParam("metodoPago") MetodoPago metodoPago, @RequestParam("minFechaCreacion") @DateTimeFormat(style = "M-") Date minFechaCreacion, @RequestParam("maxFechaCreacion") @DateTimeFormat(style = "M-") Date maxFechaCreacion, @RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, @RequestParam(value = "sortFieldName", required = false) String sortFieldName, @RequestParam(value = "sortOrder", required = false) String sortOrder, Model uiModel) {
        if (page != null || size != null) {
            int sizeNo = size == null ? 10 : size.intValue();
            final int firstResult = page == null ? 0 : (page.intValue() - 1) * sizeNo;
            uiModel.addAttribute("abonoes", Abono.findAbonoesByMetodoPagoAndFechaCreacionBetween(metodoPago, minFechaCreacion, maxFechaCreacion, sortFieldName, sortOrder).setFirstResult(firstResult).setMaxResults(sizeNo).getResultList());
            float nrOfPages = (float) Abono.countFindAbonoesByMetodoPagoAndFechaCreacionBetween(metodoPago, minFechaCreacion, maxFechaCreacion) / sizeNo;
            uiModel.addAttribute("maxPages", (int) ((nrOfPages > (int) nrOfPages || nrOfPages == 0.0) ? nrOfPages + 1 : nrOfPages));
        } else {
            uiModel.addAttribute("abonoes", Abono.findAbonoesByMetodoPagoAndFechaCreacionBetween(metodoPago, minFechaCreacion, maxFechaCreacion, sortFieldName, sortOrder).getResultList());
        }
        addDateTimeFormatPatterns(uiModel);
        return "abonoes/list";
    }

	@RequestMapping(params = { "find=ByStatusAndFechaCreacionBetween", "form" }, method = RequestMethod.GET)
    public String findAbonoesByStatusAndFechaCreacionBetweenForm(Model uiModel) {
        uiModel.addAttribute("statuscargoabonoes", StatusCargoAbono.findAllStatusCargoAbonoes());
        addDateTimeFormatPatterns(uiModel);
        return "abonoes/findAbonoesByStatusAndFechaCreacionBetween";
    }

	@RequestMapping(params = "find=ByStatusAndFechaCreacionBetween", method = RequestMethod.GET)
    public String findAbonoesByStatusAndFechaCreacionBetween(@RequestParam("status") StatusCargoAbono status, @RequestParam("minFechaCreacion") @DateTimeFormat(style = "M-") Date minFechaCreacion, @RequestParam("maxFechaCreacion") @DateTimeFormat(style = "M-") Date maxFechaCreacion, @RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, @RequestParam(value = "sortFieldName", required = false) String sortFieldName, @RequestParam(value = "sortOrder", required = false) String sortOrder, Model uiModel) {
        if (page != null || size != null) {
            int sizeNo = size == null ? 10 : size.intValue();
            final int firstResult = page == null ? 0 : (page.intValue() - 1) * sizeNo;
            uiModel.addAttribute("abonoes", Abono.findAbonoesByStatusAndFechaCreacionBetween(status, minFechaCreacion, maxFechaCreacion, sortFieldName, sortOrder).setFirstResult(firstResult).setMaxResults(sizeNo).getResultList());
            float nrOfPages = (float) Abono.countFindAbonoesByStatusAndFechaCreacionBetween(status, minFechaCreacion, maxFechaCreacion) / sizeNo;
            uiModel.addAttribute("maxPages", (int) ((nrOfPages > (int) nrOfPages || nrOfPages == 0.0) ? nrOfPages + 1 : nrOfPages));
        } else {
            uiModel.addAttribute("abonoes", Abono.findAbonoesByStatusAndFechaCreacionBetween(status, minFechaCreacion, maxFechaCreacion, sortFieldName, sortOrder).getResultList());
        }
        addDateTimeFormatPatterns(uiModel);
        return "abonoes/list";
    }
}
