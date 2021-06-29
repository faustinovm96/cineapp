package net.itinajero.app.crudrepository;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import net.itinajero.app.model.Noticia;
import net.itinajero.app.repository.NoticiasRepository;

public class AppFindAll {
	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext contxt = new ClassPathXmlApplicationContext("root-context.xml");
		NoticiasRepository repo = contxt.getBean("noticiasRepository", NoticiasRepository.class);
		
		//long numeros = repo.count();
		
		Iterable<Noticia> iterable =  repo.findAll();
		
		for (Noticia noticia : iterable) {
			System.out.println(noticia);
		}
		
		
		//System.out.println("Cantidad de registros en la base de datos: "+ numeros);
		contxt.close();
	}
}
