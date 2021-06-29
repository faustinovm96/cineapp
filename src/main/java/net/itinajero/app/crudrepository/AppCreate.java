package net.itinajero.app.crudrepository;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import net.itinajero.app.model.Noticia;
import net.itinajero.app.repository.NoticiasRepository;

public class AppCreate {
	public static void main(String[] args) {
		
		Noticia noticia = new Noticia();
		noticia.setTitulo("Nueva Noticia");
		noticia.setDetalle("Prueba de Titulo");
		
		ClassPathXmlApplicationContext contxt = new ClassPathXmlApplicationContext("root-context.xml");
		NoticiasRepository repo = contxt.getBean("noticiasRepository", NoticiasRepository.class);
		
		repo.save(noticia);
		
		
		contxt.close();
	}
}
