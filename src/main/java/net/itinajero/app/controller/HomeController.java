package net.itinajero.app.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import net.itinajero.app.model.Banner;
import net.itinajero.app.model.Horario;
import net.itinajero.app.model.Noticia;
import net.itinajero.app.model.Pelicula;
import net.itinajero.app.service.IBannerService;
import net.itinajero.app.service.IHorariosService;
import net.itinajero.app.service.INoticiasService;
import net.itinajero.app.service.IPeliculasService;
import net.itinajero.app.utils.Utileria;

/**
 * @author F996
 *
 */
@Controller
public class HomeController {

	private SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
	
	//Se inyecta una instancia de una clase IHorariosService
	@Autowired
	private IHorariosService horariosService;
	
	//Se inyecta una instancia de la interface IBannerService
	@Autowired
	private IBannerService serviceBanner;
	
	@Autowired
	private IPeliculasService servicePeliculas;
	
	@Autowired
	private INoticiasService serviceNoticias;
	
	//Retorna la vista home
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String goHome() {
		return "home";
	}
	
	/**Realiza una busqueda en cuanto a las fechas*/
	/**Se origina una excepcion al pasar la fecha como String a la hora de parsear*/
	@RequestMapping(value = "search", method=RequestMethod.POST)
	public String buscar(@RequestParam("fecha") Date fecha, Model model) {
		try {			
			Date fechaSinHora = dateFormat.parse(dateFormat.format(fecha));
			List<String> listaFechas = Utileria.getNextDays(4);
			List<Pelicula> peliculas  = servicePeliculas.buscarPorFecha(fechaSinHora);
			model.addAttribute("fechas", listaFechas);			
			// Regresamos la fecha que selecciono el usuario con el mismo formato
			model.addAttribute("fechaBusqueda",dateFormat.format(fecha));			
			model.addAttribute("peliculas", peliculas);			
			return "home";
		} catch (ParseException e) {
			System.out.println("Error: HomeController.buscar" + e.getMessage());
		}
		return "home";
	}

	/**Muestra la página principal*/
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String mostrarPrincipal(Model model) {
		
		try {
			Date fechaSinHora = dateFormat.parse(dateFormat.format(new Date()));
			List<String> listaFechas = Utileria.getNextDays(4);		
			List<Pelicula> peliculas = servicePeliculas.buscarPorFecha(fechaSinHora);			
			model.addAttribute("fechas", listaFechas);
			model.addAttribute("fechaBusqueda", dateFormat.format(new Date()));
			model.addAttribute("peliculas", peliculas);
		} catch (ParseException e) {
			System.out.println("Error: HomeController.mostrarPrincipal" + e.getMessage());
		}
		return "home";
	}
	
	@RequestMapping(value="/about", method = RequestMethod.GET)
	public String getAcerca() {
		return "acerca";
	}

//	@RequestMapping(value = "/detail/{id}/{fecha}", method=RequestMethod.GET)
	@RequestMapping(value = "/detail", method=RequestMethod.GET)
	public String mostrarDetalle(Model model, @RequestParam("idMovie") int idPelicula, @RequestParam("fecha") Date fecha) {
		
		List<Horario> horarios = horariosService.buscarPorIdPelicula(idPelicula, fecha);
		model.addAttribute("horarios", horarios);
		model.addAttribute("fechaBusqueda", dateFormat.format(fecha));
		//System.out.println("IdPelicula: " + idPelicula);
		//System.out.println("Fecha Busqueda: "+ fecha);
		
		model.addAttribute("pelicula", servicePeliculas.buscarPorId(idPelicula));
		
//		String tituloPelicula = "Rapidos y furiosos";
//		int duracion = 136;
//		double precioEntrada = 50;
//
//		model.addAttribute("titulo", tituloPelicula);
//		model.addAttribute("duracion", duracion);
//		model.addAttribute("precio", precioEntrada);
		return "detalle";
	}
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}
	
	@ModelAttribute("banners")
	public List<Banner> getBanners(){
		return serviceBanner.buscarActivos();
	}
	
	@ModelAttribute("noticias")
	public List<Noticia> getNoticias(){
		return serviceNoticias.buscarUltimas();
	}
	
	@RequestMapping(value = "/formLogin")
	public String mostrarLogin() {
		return "formLogin";
	}
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpServletRequest request) {
		SecurityContextLogoutHandler logoutHandler = new SecurityContextLogoutHandler();
		logoutHandler.logout(request, null, null);
		return "redirect:/formLogin";
	}

}
