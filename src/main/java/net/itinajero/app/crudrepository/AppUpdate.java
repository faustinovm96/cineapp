package net.itinajero.app.crudrepository;

import java.util.Optional;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import net.itinajero.app.model.Noticia;
import net.itinajero.app.repository.NoticiasRepository;

public class AppUpdate {
	public static void main(String[] args) {
		
		Noticia noticia = new Noticia();
		noticia.setTitulo("Nueva Noticia");
		noticia.setDetalle("Prueba de Titulo");
		
		ClassPathXmlApplicationContext contxt = new ClassPathXmlApplicationContext("root-context.xml");
		NoticiasRepository repo = contxt.getBean("noticiasRepository", NoticiasRepository.class);
		
		Optional<Noticia> optional =  repo.findById(1);
		
		if (optional.isPresent()) {
			Noticia n = optional.get();
			n.setTitulo("Titulo 2");
			repo.save(n);
		}
		
		
		contxt.close();
	}
}
