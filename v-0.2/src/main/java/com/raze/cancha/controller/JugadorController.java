package com.raze.cancha.controller;
import com.raze.cancha.catalog.Posicion;
import com.raze.cancha.catalog.StatusEquipoJugador;
import com.raze.cancha.domain.Equipo;
import com.raze.cancha.domain.Jugador;
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

@RooWebJson(jsonObject = Jugador.class)
@Controller
@RequestMapping("/jugadors")
@RooWebScaffold(path = "jugadors", formBackingObject = Jugador.class)
@RooWebFinder
public class JugadorController {

	@RequestMapping(value = "/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
    @ResponseBody
    public ResponseEntity<String> showJson(@PathVariable("id") Long id) {
        Jugador jugador = Jugador.findJugador(id);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json; charset=utf-8");
        if (jugador == null) {
            return new ResponseEntity<String>(headers, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<String>(jugador.toJson(), headers, HttpStatus.OK);
    }

	@RequestMapping(headers = "Accept=application/json")
    @ResponseBody
    public ResponseEntity<String> listJson() {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json; charset=utf-8");
        List<Jugador> result = Jugador.findAllJugadors();
        return new ResponseEntity<String>(Jugador.toJsonArray(result), headers, HttpStatus.OK);
    }

	@RequestMapping(method = RequestMethod.POST, headers = "Accept=application/json")
    public ResponseEntity<String> createFromJson(@RequestBody String json, UriComponentsBuilder uriBuilder) {
        Jugador jugador = Jugador.fromJsonToJugador(json);
        jugador.persist();
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        RequestMapping a = (RequestMapping) getClass().getAnnotation(RequestMapping.class);
        headers.add("Location",uriBuilder.path(a.value()[0]+"/"+jugador.getId().toString()).build().toUriString());
        return new ResponseEntity<String>(headers, HttpStatus.CREATED);
    }

	@RequestMapping(value = "/jsonArray", method = RequestMethod.POST, headers = "Accept=application/json")
    public ResponseEntity<String> createFromJsonArray(@RequestBody String json) {
        for (Jugador jugador: Jugador.fromJsonArrayToJugadors(json)) {
            jugador.persist();
        }
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        return new ResponseEntity<String>(headers, HttpStatus.CREATED);
    }

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, headers = "Accept=application/json")
    public ResponseEntity<String> updateFromJson(@RequestBody String json, @PathVariable("id") Long id) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        Jugador jugador = Jugador.fromJsonToJugador(json);
        jugador.setId(id);
        if (jugador.merge() == null) {
            return new ResponseEntity<String>(headers, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<String>(headers, HttpStatus.OK);
    }

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
    public ResponseEntity<String> deleteFromJson(@PathVariable("id") Long id) {
        Jugador jugador = Jugador.findJugador(id);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        if (jugador == null) {
            return new ResponseEntity<String>(headers, HttpStatus.NOT_FOUND);
        }
        jugador.remove();
        return new ResponseEntity<String>(headers, HttpStatus.OK);
    }

	@RequestMapping(params = "find=ByEquipoAndActivo", headers = "Accept=application/json")
    @ResponseBody
    public ResponseEntity<String> jsonFindJugadorsByEquipoAndActivo(@RequestParam("equipo") Equipo equipo, @RequestParam(value = "activo", required = false) Boolean activo) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json; charset=utf-8");
        return new ResponseEntity<String>(Jugador.toJsonArray(Jugador.findJugadorsByEquipoAndActivo(equipo, activo == null ? Boolean.FALSE : activo).getResultList()), headers, HttpStatus.OK);
    }

	@RequestMapping(params = "find=ByEquipoAndEsDelegadoAndActivo", headers = "Accept=application/json")
    @ResponseBody
    public ResponseEntity<String> jsonFindJugadorsByEquipoAndEsDelegadoAndActivo(@RequestParam("equipo") Equipo equipo, @RequestParam(value = "esDelegado", required = false) Boolean esDelegado, @RequestParam(value = "activo", required = false) Boolean activo) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json; charset=utf-8");
        return new ResponseEntity<String>(Jugador.toJsonArray(Jugador.findJugadorsByEquipoAndEsDelegadoAndActivo(equipo, esDelegado == null ? Boolean.FALSE : esDelegado, activo == null ? Boolean.FALSE : activo).getResultList()), headers, HttpStatus.OK);
    }

	@RequestMapping(params = "find=ByEquipoAndNombreLikeAndActivo", headers = "Accept=application/json")
    @ResponseBody
    public ResponseEntity<String> jsonFindJugadorsByEquipoAndNombreLikeAndActivo(@RequestParam("equipo") Equipo equipo, @RequestParam("nombre") String nombre, @RequestParam(value = "activo", required = false) Boolean activo) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json; charset=utf-8");
        return new ResponseEntity<String>(Jugador.toJsonArray(Jugador.findJugadorsByEquipoAndNombreLikeAndActivo(equipo, nombre, activo == null ? Boolean.FALSE : activo).getResultList()), headers, HttpStatus.OK);
    }

	@RequestMapping(params = "find=ByEquipoAndNombreLikeAndApellidoPaternoLikeAndActivo", headers = "Accept=application/json")
    @ResponseBody
    public ResponseEntity<String> jsonFindJugadorsByEquipoAndNombreLikeAndApellidoPaternoLikeAndActivo(@RequestParam("equipo") Equipo equipo, @RequestParam("nombre") String nombre, @RequestParam("apellidoPaterno") String apellidoPaterno, @RequestParam(value = "activo", required = false) Boolean activo) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json; charset=utf-8");
        return new ResponseEntity<String>(Jugador.toJsonArray(Jugador.findJugadorsByEquipoAndNombreLikeAndApellidoPaternoLikeAndActivo(equipo, nombre, apellidoPaterno, activo == null ? Boolean.FALSE : activo).getResultList()), headers, HttpStatus.OK);
    }

	@RequestMapping(params = "find=ByEquipoAndPosicionAndActivo", headers = "Accept=application/json")
    @ResponseBody
    public ResponseEntity<String> jsonFindJugadorsByEquipoAndPosicionAndActivo(@RequestParam("equipo") Equipo equipo, @RequestParam("posicion") Posicion posicion, @RequestParam(value = "activo", required = false) Boolean activo) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json; charset=utf-8");
        return new ResponseEntity<String>(Jugador.toJsonArray(Jugador.findJugadorsByEquipoAndPosicionAndActivo(equipo, posicion, activo == null ? Boolean.FALSE : activo).getResultList()), headers, HttpStatus.OK);
    }

	@RequestMapping(params = "find=ByEquipoAndStatusAndActivo", headers = "Accept=application/json")
    @ResponseBody
    public ResponseEntity<String> jsonFindJugadorsByEquipoAndStatusAndActivo(@RequestParam("equipo") Equipo equipo, @RequestParam("status") StatusEquipoJugador status, @RequestParam(value = "activo", required = false) Boolean activo) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json; charset=utf-8");
        return new ResponseEntity<String>(Jugador.toJsonArray(Jugador.findJugadorsByEquipoAndStatusAndActivo(equipo, status, activo == null ? Boolean.FALSE : activo).getResultList()), headers, HttpStatus.OK);
    }

	@RequestMapping(method = RequestMethod.POST, produces = "text/html")
    public String create(@Valid Jugador jugador, BindingResult bindingResult, Model uiModel, HttpServletRequest httpServletRequest) {
        if (bindingResult.hasErrors()) {
            populateEditForm(uiModel, jugador);
            return "jugadors/create";
        }
        uiModel.asMap().clear();
        jugador.persist();
        return "redirect:/jugadors/" + encodeUrlPathSegment(jugador.getId().toString(), httpServletRequest);
    }

	@RequestMapping(params = "form", produces = "text/html")
    public String createForm(Model uiModel) {
        populateEditForm(uiModel, new Jugador());
        List<String[]> dependencies = new ArrayList<String[]>();
        if (Equipo.countEquipoes() == 0) {
            dependencies.add(new String[] { "equipo", "equipoes" });
        }
        uiModel.addAttribute("dependencies", dependencies);
        return "jugadors/create";
    }

	@RequestMapping(value = "/{id}", produces = "text/html")
    public String show(@PathVariable("id") Long id, Model uiModel) {
        addDateTimeFormatPatterns(uiModel);
        uiModel.addAttribute("jugador", Jugador.findJugador(id));
        uiModel.addAttribute("itemId", id);
        return "jugadors/show";
    }

	@RequestMapping(produces = "text/html")
    public String list(@RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, @RequestParam(value = "sortFieldName", required = false) String sortFieldName, @RequestParam(value = "sortOrder", required = false) String sortOrder, Model uiModel) {
        if (page != null || size != null) {
            int sizeNo = size == null ? 10 : size.intValue();
            final int firstResult = page == null ? 0 : (page.intValue() - 1) * sizeNo;
            uiModel.addAttribute("jugadors", Jugador.findJugadorEntries(firstResult, sizeNo, sortFieldName, sortOrder));
            float nrOfPages = (float) Jugador.countJugadors() / sizeNo;
            uiModel.addAttribute("maxPages", (int) ((nrOfPages > (int) nrOfPages || nrOfPages == 0.0) ? nrOfPages + 1 : nrOfPages));
        } else {
            uiModel.addAttribute("jugadors", Jugador.findAllJugadors(sortFieldName, sortOrder));
        }
        addDateTimeFormatPatterns(uiModel);
        return "jugadors/list";
    }

	@RequestMapping(method = RequestMethod.PUT, produces = "text/html")
    public String update(@Valid Jugador jugador, BindingResult bindingResult, Model uiModel, HttpServletRequest httpServletRequest) {
        if (bindingResult.hasErrors()) {
            populateEditForm(uiModel, jugador);
            return "jugadors/update";
        }
        uiModel.asMap().clear();
        jugador.merge();
        return "redirect:/jugadors/" + encodeUrlPathSegment(jugador.getId().toString(), httpServletRequest);
    }

	@RequestMapping(value = "/{id}", params = "form", produces = "text/html")
    public String updateForm(@PathVariable("id") Long id, Model uiModel) {
        populateEditForm(uiModel, Jugador.findJugador(id));
        return "jugadors/update";
    }

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = "text/html")
    public String delete(@PathVariable("id") Long id, @RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, Model uiModel) {
        Jugador jugador = Jugador.findJugador(id);
        jugador.remove();
        uiModel.asMap().clear();
        uiModel.addAttribute("page", (page == null) ? "1" : page.toString());
        uiModel.addAttribute("size", (size == null) ? "10" : size.toString());
        return "redirect:/jugadors";
    }

	void addDateTimeFormatPatterns(Model uiModel) {
        uiModel.addAttribute("jugador_fechanacimiento_date_format", DateTimeFormat.patternForStyle("M-", LocaleContextHolder.getLocale()));
        uiModel.addAttribute("jugador_fechacreacion_date_format", DateTimeFormat.patternForStyle("M-", LocaleContextHolder.getLocale()));
        uiModel.addAttribute("jugador_fechamodificacion_date_format", DateTimeFormat.patternForStyle("M-", LocaleContextHolder.getLocale()));
    }

	void populateEditForm(Model uiModel, Jugador jugador) {
        uiModel.addAttribute("jugador", jugador);
        addDateTimeFormatPatterns(uiModel);
        uiModel.addAttribute("posicions", Posicion.findAllPosicions());
        uiModel.addAttribute("statusequipojugadors", StatusEquipoJugador.findAllStatusEquipoJugadors());
        uiModel.addAttribute("equipoes", Equipo.findAllEquipoes());
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

	@RequestMapping(params = { "find=ByEquipoAndActivo", "form" }, method = RequestMethod.GET)
    public String findJugadorsByEquipoAndActivoForm(Model uiModel) {
        uiModel.addAttribute("equipoes", Equipo.findAllEquipoes());
        return "jugadors/findJugadorsByEquipoAndActivo";
    }

	@RequestMapping(params = "find=ByEquipoAndActivo", method = RequestMethod.GET)
    public String findJugadorsByEquipoAndActivo(@RequestParam("equipo") Equipo equipo, @RequestParam(value = "activo", required = false) Boolean activo, @RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, @RequestParam(value = "sortFieldName", required = false) String sortFieldName, @RequestParam(value = "sortOrder", required = false) String sortOrder, Model uiModel) {
        if (page != null || size != null) {
            int sizeNo = size == null ? 10 : size.intValue();
            final int firstResult = page == null ? 0 : (page.intValue() - 1) * sizeNo;
            uiModel.addAttribute("jugadors", Jugador.findJugadorsByEquipoAndActivo(equipo, activo == null ? Boolean.FALSE : activo, sortFieldName, sortOrder).setFirstResult(firstResult).setMaxResults(sizeNo).getResultList());
            float nrOfPages = (float) Jugador.countFindJugadorsByEquipoAndActivo(equipo, activo == null ? Boolean.FALSE : activo) / sizeNo;
            uiModel.addAttribute("maxPages", (int) ((nrOfPages > (int) nrOfPages || nrOfPages == 0.0) ? nrOfPages + 1 : nrOfPages));
        } else {
            uiModel.addAttribute("jugadors", Jugador.findJugadorsByEquipoAndActivo(equipo, activo == null ? Boolean.FALSE : activo, sortFieldName, sortOrder).getResultList());
        }
        addDateTimeFormatPatterns(uiModel);
        return "jugadors/list";
    }

	@RequestMapping(params = { "find=ByEquipoAndEsDelegadoAndActivo", "form" }, method = RequestMethod.GET)
    public String findJugadorsByEquipoAndEsDelegadoAndActivoForm(Model uiModel) {
        uiModel.addAttribute("equipoes", Equipo.findAllEquipoes());
        return "jugadors/findJugadorsByEquipoAndEsDelegadoAndActivo";
    }

	@RequestMapping(params = "find=ByEquipoAndEsDelegadoAndActivo", method = RequestMethod.GET)
    public String findJugadorsByEquipoAndEsDelegadoAndActivo(@RequestParam("equipo") Equipo equipo, @RequestParam(value = "esDelegado", required = false) Boolean esDelegado, @RequestParam(value = "activo", required = false) Boolean activo, @RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, @RequestParam(value = "sortFieldName", required = false) String sortFieldName, @RequestParam(value = "sortOrder", required = false) String sortOrder, Model uiModel) {
        if (page != null || size != null) {
            int sizeNo = size == null ? 10 : size.intValue();
            final int firstResult = page == null ? 0 : (page.intValue() - 1) * sizeNo;
            uiModel.addAttribute("jugadors", Jugador.findJugadorsByEquipoAndEsDelegadoAndActivo(equipo, esDelegado == null ? Boolean.FALSE : esDelegado, activo == null ? Boolean.FALSE : activo, sortFieldName, sortOrder).setFirstResult(firstResult).setMaxResults(sizeNo).getResultList());
            float nrOfPages = (float) Jugador.countFindJugadorsByEquipoAndEsDelegadoAndActivo(equipo, esDelegado == null ? Boolean.FALSE : esDelegado, activo == null ? Boolean.FALSE : activo) / sizeNo;
            uiModel.addAttribute("maxPages", (int) ((nrOfPages > (int) nrOfPages || nrOfPages == 0.0) ? nrOfPages + 1 : nrOfPages));
        } else {
            uiModel.addAttribute("jugadors", Jugador.findJugadorsByEquipoAndEsDelegadoAndActivo(equipo, esDelegado == null ? Boolean.FALSE : esDelegado, activo == null ? Boolean.FALSE : activo, sortFieldName, sortOrder).getResultList());
        }
        addDateTimeFormatPatterns(uiModel);
        return "jugadors/list";
    }

	@RequestMapping(params = { "find=ByEquipoAndNombreLikeAndActivo", "form" }, method = RequestMethod.GET)
    public String findJugadorsByEquipoAndNombreLikeAndActivoForm(Model uiModel) {
        uiModel.addAttribute("equipoes", Equipo.findAllEquipoes());
        return "jugadors/findJugadorsByEquipoAndNombreLikeAndActivo";
    }

	@RequestMapping(params = "find=ByEquipoAndNombreLikeAndActivo", method = RequestMethod.GET)
    public String findJugadorsByEquipoAndNombreLikeAndActivo(@RequestParam("equipo") Equipo equipo, @RequestParam("nombre") String nombre, @RequestParam(value = "activo", required = false) Boolean activo, @RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, @RequestParam(value = "sortFieldName", required = false) String sortFieldName, @RequestParam(value = "sortOrder", required = false) String sortOrder, Model uiModel) {
        if (page != null || size != null) {
            int sizeNo = size == null ? 10 : size.intValue();
            final int firstResult = page == null ? 0 : (page.intValue() - 1) * sizeNo;
            uiModel.addAttribute("jugadors", Jugador.findJugadorsByEquipoAndNombreLikeAndActivo(equipo, nombre, activo == null ? Boolean.FALSE : activo, sortFieldName, sortOrder).setFirstResult(firstResult).setMaxResults(sizeNo).getResultList());
            float nrOfPages = (float) Jugador.countFindJugadorsByEquipoAndNombreLikeAndActivo(equipo, nombre, activo == null ? Boolean.FALSE : activo) / sizeNo;
            uiModel.addAttribute("maxPages", (int) ((nrOfPages > (int) nrOfPages || nrOfPages == 0.0) ? nrOfPages + 1 : nrOfPages));
        } else {
            uiModel.addAttribute("jugadors", Jugador.findJugadorsByEquipoAndNombreLikeAndActivo(equipo, nombre, activo == null ? Boolean.FALSE : activo, sortFieldName, sortOrder).getResultList());
        }
        addDateTimeFormatPatterns(uiModel);
        return "jugadors/list";
    }

	@RequestMapping(params = { "find=ByEquipoAndNombreLikeAndApellidoPaternoLikeAndActivo", "form" }, method = RequestMethod.GET)
    public String findJugadorsByEquipoAndNombreLikeAndApellidoPaternoLikeAndActivoForm(Model uiModel) {
        uiModel.addAttribute("equipoes", Equipo.findAllEquipoes());
        return "jugadors/findJugadorsByEquipoAndNombreLikeAndApellidoPaternoLikeAndActivo";
    }

	@RequestMapping(params = "find=ByEquipoAndNombreLikeAndApellidoPaternoLikeAndActivo", method = RequestMethod.GET)
    public String findJugadorsByEquipoAndNombreLikeAndApellidoPaternoLikeAndActivo(@RequestParam("equipo") Equipo equipo, @RequestParam("nombre") String nombre, @RequestParam("apellidoPaterno") String apellidoPaterno, @RequestParam(value = "activo", required = false) Boolean activo, @RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, @RequestParam(value = "sortFieldName", required = false) String sortFieldName, @RequestParam(value = "sortOrder", required = false) String sortOrder, Model uiModel) {
        if (page != null || size != null) {
            int sizeNo = size == null ? 10 : size.intValue();
            final int firstResult = page == null ? 0 : (page.intValue() - 1) * sizeNo;
            uiModel.addAttribute("jugadors", Jugador.findJugadorsByEquipoAndNombreLikeAndApellidoPaternoLikeAndActivo(equipo, nombre, apellidoPaterno, activo == null ? Boolean.FALSE : activo, sortFieldName, sortOrder).setFirstResult(firstResult).setMaxResults(sizeNo).getResultList());
            float nrOfPages = (float) Jugador.countFindJugadorsByEquipoAndNombreLikeAndApellidoPaternoLikeAndActivo(equipo, nombre, apellidoPaterno, activo == null ? Boolean.FALSE : activo) / sizeNo;
            uiModel.addAttribute("maxPages", (int) ((nrOfPages > (int) nrOfPages || nrOfPages == 0.0) ? nrOfPages + 1 : nrOfPages));
        } else {
            uiModel.addAttribute("jugadors", Jugador.findJugadorsByEquipoAndNombreLikeAndApellidoPaternoLikeAndActivo(equipo, nombre, apellidoPaterno, activo == null ? Boolean.FALSE : activo, sortFieldName, sortOrder).getResultList());
        }
        addDateTimeFormatPatterns(uiModel);
        return "jugadors/list";
    }

	@RequestMapping(params = { "find=ByEquipoAndPosicionAndActivo", "form" }, method = RequestMethod.GET)
    public String findJugadorsByEquipoAndPosicionAndActivoForm(Model uiModel) {
        uiModel.addAttribute("equipoes", Equipo.findAllEquipoes());
        uiModel.addAttribute("posicions", Posicion.findAllPosicions());
        return "jugadors/findJugadorsByEquipoAndPosicionAndActivo";
    }

	@RequestMapping(params = "find=ByEquipoAndPosicionAndActivo", method = RequestMethod.GET)
    public String findJugadorsByEquipoAndPosicionAndActivo(@RequestParam("equipo") Equipo equipo, @RequestParam("posicion") Posicion posicion, @RequestParam(value = "activo", required = false) Boolean activo, @RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, @RequestParam(value = "sortFieldName", required = false) String sortFieldName, @RequestParam(value = "sortOrder", required = false) String sortOrder, Model uiModel) {
        if (page != null || size != null) {
            int sizeNo = size == null ? 10 : size.intValue();
            final int firstResult = page == null ? 0 : (page.intValue() - 1) * sizeNo;
            uiModel.addAttribute("jugadors", Jugador.findJugadorsByEquipoAndPosicionAndActivo(equipo, posicion, activo == null ? Boolean.FALSE : activo, sortFieldName, sortOrder).setFirstResult(firstResult).setMaxResults(sizeNo).getResultList());
            float nrOfPages = (float) Jugador.countFindJugadorsByEquipoAndPosicionAndActivo(equipo, posicion, activo == null ? Boolean.FALSE : activo) / sizeNo;
            uiModel.addAttribute("maxPages", (int) ((nrOfPages > (int) nrOfPages || nrOfPages == 0.0) ? nrOfPages + 1 : nrOfPages));
        } else {
            uiModel.addAttribute("jugadors", Jugador.findJugadorsByEquipoAndPosicionAndActivo(equipo, posicion, activo == null ? Boolean.FALSE : activo, sortFieldName, sortOrder).getResultList());
        }
        addDateTimeFormatPatterns(uiModel);
        return "jugadors/list";
    }

	@RequestMapping(params = { "find=ByEquipoAndStatusAndActivo", "form" }, method = RequestMethod.GET)
    public String findJugadorsByEquipoAndStatusAndActivoForm(Model uiModel) {
        uiModel.addAttribute("equipoes", Equipo.findAllEquipoes());
        uiModel.addAttribute("statusequipojugadors", StatusEquipoJugador.findAllStatusEquipoJugadors());
        return "jugadors/findJugadorsByEquipoAndStatusAndActivo";
    }

	@RequestMapping(params = "find=ByEquipoAndStatusAndActivo", method = RequestMethod.GET)
    public String findJugadorsByEquipoAndStatusAndActivo(@RequestParam("equipo") Equipo equipo, @RequestParam("status") StatusEquipoJugador status, @RequestParam(value = "activo", required = false) Boolean activo, @RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, @RequestParam(value = "sortFieldName", required = false) String sortFieldName, @RequestParam(value = "sortOrder", required = false) String sortOrder, Model uiModel) {
        if (page != null || size != null) {
            int sizeNo = size == null ? 10 : size.intValue();
            final int firstResult = page == null ? 0 : (page.intValue() - 1) * sizeNo;
            uiModel.addAttribute("jugadors", Jugador.findJugadorsByEquipoAndStatusAndActivo(equipo, status, activo == null ? Boolean.FALSE : activo, sortFieldName, sortOrder).setFirstResult(firstResult).setMaxResults(sizeNo).getResultList());
            float nrOfPages = (float) Jugador.countFindJugadorsByEquipoAndStatusAndActivo(equipo, status, activo == null ? Boolean.FALSE : activo) / sizeNo;
            uiModel.addAttribute("maxPages", (int) ((nrOfPages > (int) nrOfPages || nrOfPages == 0.0) ? nrOfPages + 1 : nrOfPages));
        } else {
            uiModel.addAttribute("jugadors", Jugador.findJugadorsByEquipoAndStatusAndActivo(equipo, status, activo == null ? Boolean.FALSE : activo, sortFieldName, sortOrder).getResultList());
        }
        addDateTimeFormatPatterns(uiModel);
        return "jugadors/list";
    }
}
