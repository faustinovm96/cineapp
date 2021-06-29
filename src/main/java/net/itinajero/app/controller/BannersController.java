package net.itinajero.app.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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

import net.itinajero.app.model.Banner;
import net.itinajero.app.service.IBannerService;
import net.itinajero.app.utils.Utileria;

@Controller
@RequestMapping("/banners/")
public class BannersController {
	
	@Autowired
	private IBannerService bannerService;
	
	@GetMapping("/index")
	public String mostrarIndex(Model model) {
		List<Banner> lista = bannerService.buscarTodos();
		model.addAttribute("banners", lista);
		return "banners/listBanners";
	}
	
	@GetMapping("/create")
	public String crear(@ModelAttribute Banner banner, Model model) {
		return "banners/formBanners";
	}
	
	@PostMapping("/save")
	public String guardar(@ModelAttribute Banner banner, BindingResult result, RedirectAttributes attributes,
			@RequestParam("archivoImagen") MultipartFile muFile, HttpServletRequest request) {
		
		if (result.hasErrors()) {
			System.out.println("Existieron errores");
			return "banners/formBanner";
		}
		
		if (!muFile.isEmpty()) {
			String nombreImagen = Utileria.guardarImagen(muFile, request);
			banner.setArchivo(nombreImagen);
		}
		
		System.out.println("Recibiendo objeto banner: " + banner);
		
		System.out.println("Objeto antes de la insercion: " + bannerService.buscarTodos().size());
		
		bannerService.guardar(banner);
		
		System.out.println("Objeto despues de la insercion: " + bannerService.buscarTodos().size());
		
		attributes.addFlashAttribute("mensaje", "El banner se ha guardado correctamente");
		
		return "redirect:/banners/index";
	}
	
	@GetMapping(value="/edit/{id}")
	public String editar(@PathVariable("id") int idBanner, Model model) {
		model.addAttribute("banner", bannerService.buscarPorId(idBanner));
		return "banners/formBanners";
	}
	
	public String eliminar(@PathVariable("id") int idBanner, RedirectAttributes attributes) {
		
		bannerService.eliminar(idBanner);
		attributes.addFlashAttribute("mensaje", "El registro fue eliminado");
		
		return "redirect:/banners/index";
	}
	
}
