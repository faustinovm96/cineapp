package net.itinajero.app.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import net.itinajero.app.model.Pelicula;
import net.itinajero.app.service.IDetallesService;
import net.itinajero.app.service.IPeliculasService;
import net.itinajero.app.utils.Utileria;

@Controller
@RequestMapping("/peliculas")
public class PeliculasController {

	@Autowired
	private IDetallesService detalleService;

	@Autowired
	private IPeliculasService peliculaService;

	@GetMapping(value = "/create")
	public String crear(@ModelAttribute Pelicula pelicula, Model model) {

		// model.addAttribute("generos", peliculaService.buscarGeneros());

		return "peliculas/formPeliculas";
	}

	// Añadido el ModelAttribute
	@PostMapping(value = "/save")
	public String guardar(@ModelAttribute Pelicula pelicula, BindingResult result,
			RedirectAttributes redirectAttributes, @RequestParam("archivoImagen") MultipartFile muFile,
			HttpServletRequest request) {

		if (!muFile.isEmpty()) {
			String nombreImagen = Utileria.guardarImagen(muFile, request);
			pelicula.setImagen(nombreImagen);
		}

		if (result.hasErrors()) {
			System.out.println("Existieron errores");
			//Imprime en laconsola los errores
			for (ObjectError error : result.getAllErrors()) {
				System.out.println(error.getDefaultMessage());
			}

			return "peliculas/formPeliculas";
		}

		// System.out.println("Detalle Antes: " + pelicula.getDetalle());

		detalleService.insertar(pelicula.getDetalle());

		// System.out.println("Detalle Después: " + pelicula.getDetalle());

		// System.out.println("Recibiendo Objeto Pelicula: " + pelicula);

		// System.out.println("Objetos antes de la insercion: " +
		// peliculaService.buscarTodas().size());

		peliculaService.guardar(pelicula);

		// System.out.println("Objetos antes de la insercion: " +
		// peliculaService.buscarTodas().size());

		redirectAttributes.addFlashAttribute("mensaje", "Registro Guardado");

//		return "peliculas/formPeliculas";
		return "redirect:/peliculas/indexPaginate";
	}

	@GetMapping(value = "/index")
	public String mostrarIndex(Model model) {

//		List<Pelicula> listaPeliculas = peliculaService.buscarTodas();
//
//		model.addAttribute("peliculas", listaPeliculas);
//
//		return "peliculas/listPeliculas";
		return "redirect:/peliculas/indexPaginate?page=0";
	}

	@GetMapping(value = "/edit/{id}")
	public String editar(@PathVariable("id") int idPelicula, Model model) {
		// model.addAttribute("generos", peliculaService.buscarGeneros());
		model.addAttribute("pelicula", peliculaService.buscarPorId(idPelicula));

		return "peliculas/formPeliculas";
	}

	@GetMapping(value = "/delete/{id}")
	public String eliminar(@PathVariable("id") int idPelicula, RedirectAttributes attributes) {

		Pelicula pelicula = peliculaService.buscarPorId(idPelicula);

		// Primero se elimina la pelicula
		peliculaService.eliminar(idPelicula);

		// Segundo se elimina el detalle
		detalleService.eliminar(pelicula.getDetalle().getId());

		attributes.addFlashAttribute("mensaje", "El registro se elimino correctamente");
		return "redirect:/peliculas/index";
	}

	@GetMapping(value = "/indexPaginate")
	public String mostrarIndexPaginado(Model model, Pageable page) {
		Page<Pelicula> lista = peliculaService.buscarTodas(page);
		model.addAttribute("peliculas", lista);
		return "peliculas/listPeliculas";
	}

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}

	/**
	 * Con la anotacion ModelAttribute a nivel de un metodo se añade al atributo
	 * especificado los valores que retorna el método, y éste metodo está disponible
	 * para cada método del controladpr
	 */
	@ModelAttribute("generos")
	public List<String> getGeneros() {
		return peliculaService.buscarGeneros();
	}

}
