package net.itinajero.app.crudrepository;

import java.util.Optional;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import net.itinajero.app.model.Noticia;
import net.itinajero.app.repository.NoticiasRepository;

public class AppSelect {
	public static void main(String[] args) {
		
		Noticia noticia = new Noticia();
		noticia.setTitulo("Nueva Noticia");
		noticia.setDetalle("Prueba de Titulo");
		
		ClassPathXmlApplicationContext contxt = new ClassPathXmlApplicationContext("root-context.xml");
		NoticiasRepository repo = contxt.getBean("noticiasRepository", NoticiasRepository.class);
		
		Optional<Noticia> recuperado =  repo.findById(1);
		
		System.out.println(recuperado);
		
		contxt.close();
	}
}
