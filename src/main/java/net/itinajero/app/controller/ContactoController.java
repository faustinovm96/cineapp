package net.itinajero.app.controller;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import net.itinajero.app.model.Contacto;
import net.itinajero.app.service.IPeliculasService;

@Controller
public class ContactoController {
	
	@Autowired
	IPeliculasService peliculasService;
	
	@GetMapping("/contacto")
	public String crear(@ModelAttribute("instanciaContacto") Contacto contacto, Model model) {
		model.addAttribute("generos", peliculasService.buscarGeneros());
		model.addAttribute("tipos", tipoNotificaciones());
		
		return "formContacto";
	}
	
	@PostMapping("/contacto")
	public String guardar(@ModelAttribute("instanciaContacto") Contacto contacto) {
		
		//model.addAttribute("generos", peliculasService.buscarGeneros());
		
		System.out.println("Contacto: "+ contacto);
		
		return "redirect:/contacto";
	}
	
	private List<String> tipoNotificaciones(){
		List<String> tipoNotificaciones = new LinkedList<String>();
		
		tipoNotificaciones.add("Estreno");
		tipoNotificaciones.add("Promociones");
		tipoNotificaciones.add("Noticias");
		tipoNotificaciones.add("Preventas");
		
		return tipoNotificaciones;
	}
}
