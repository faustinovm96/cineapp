package net.itinajero.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import net.itinajero.app.model.Perfil;
import net.itinajero.app.model.Usuario;
import net.itinajero.app.service.PerfilesService;
import net.itinajero.app.service.UsuariosService;

@Controller
@RequestMapping("/usuarios")
public class UsuariosController {
	
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	@Autowired
	private UsuariosService usuariosService;
	
	@Autowired
	private PerfilesService perfilesService;
	
	@GetMapping("/demo-bcrypt")
	public String codificar() {
		String password = "luis123";
		String encode = encoder.encode(password);
		System.out.println(encode);
		return "usuarios/demo";
	}
	
	@GetMapping("/create")
	public String crear(@ModelAttribute Usuario usuario) {
		return "usuarios/formUsuarios";
	}
	
	@GetMapping("/index")
	public String index(Model model) {
		model.addAttribute("usuarios", usuariosService.buscarTodos());
		return "usuarios/listUsuarios";
	}
	
	@PostMapping("/save")
	public String guardarUsuario(@ModelAttribute Usuario usuario, @RequestParam("perfil") String perfil) {
		System.out.println("Usuario: " + usuario);
		System.out.println("Perfil: " + perfil);
		
		String tmpPassword = usuario.getPwd();
		String encriptado = encoder.encode(tmpPassword);
		
		usuario.setPwd(encriptado);
		usuario.setActivo(1);
		usuariosService.guardar(usuario);
		
		Perfil tmpPerfil = new Perfil();
		tmpPerfil.setPerfil(perfil);
		tmpPerfil.setCuenta(usuario.getCuenta());
		perfilesService.guardar(tmpPerfil);
		
		return "redirect:/usuarios/index";
	}
	
	@GetMapping("/edit/{id}")
	public String editar(@PathVariable("id") int idUsuario, Model model) {
		model.addAttribute("usuario", usuariosService.buscarPorId(idUsuario));
		return "usuarios/formUsuarios";
	}
	
	@GetMapping("/delete/{id}")
	public String eliminar(@PathVariable("id") int idUsuario, RedirectAttributes attributes) {
		usuariosService.eliminar(idUsuario);
		attributes.addFlashAttribute("mensaje", "Registro Eliminado");
		return "redirect:/usuarios/index";
	}
}
