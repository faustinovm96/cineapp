package net.itinajero.app.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import net.itinajero.app.model.Noticia;
import net.itinajero.app.service.INoticiasService;

@Controller
@RequestMapping("/noticias")
public class NoticiasController {
	
	@Autowired
	private INoticiasService noticiaService;
	
	@GetMapping(value="/create")//El problema era no agregar el ModelAttribute al metodo que /create
	public String crear(@ModelAttribute Noticia noticia) {
		return "noticias/formNoticias";
	}
	
	/**Funcion que regresa la vista de catelogo de noticias*/
	@GetMapping(value="/index")
	public String mostrarIndex(Model model) {
		
		model.addAttribute("noticias", noticiaService.buscarTodas());
		return "noticias/listNoticias";
	}
	
	@PostMapping(value="/save")
	public String guardar(@ModelAttribute Noticia noticia, BindingResult result, Model model, RedirectAttributes attributes) {
		
//		if (result.hasErrors()) { //No es necesaria porque son datos sin validaciones complejas
//			System.out.println("Existieron errores");
//
//			for (ObjectError error : result.getAllErrors()) {
//				System.out.println(error.getDefaultMessage());
//			}
//
//			return "peliculas/formNoticias";
//		}
		
		
//		Noticia noticia = new Noticia();
//		noticia.setTitulo(titulo);
//		noticia.setEstatus(estatus);
//		noticia.setDetalle(detalle);

//		System.out.println("Titulo: "+ titulo);
//		System.out.println("Estado: " + estatus);
//		System.out.println("Detalle: " + detalle);
		//System.out.println("Noticia: " + noticia);
		
		noticiaService.guardar(noticia);
		
		attributes.addFlashAttribute("mensaje", "El registro ha sido guardado");
		
		return "redirect:/noticias/index";
	}
	
	@GetMapping(value = "/edit/{id}")
	public String editar(@PathVariable("id") int idNoticia, Model model) {
		model.addAttribute("noticia", noticiaService.buscarPorId(idNoticia));
		return "noticias/formNoticias";
	}
	
	@GetMapping(value = "/delete/{id}")
	public String eliminar(@PathVariable("id") int idNoticia, RedirectAttributes attributes) {
		noticiaService.eliminar(idNoticia);
		attributes.addFlashAttribute("mensaje", "La noticia fue eliminada");
		
		return "redirect:/noticias/index";
	}
	
}
