package net.itinajero.app.crudrepository;

import java.util.LinkedList;
import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import net.itinajero.app.model.Noticia;
import net.itinajero.app.repository.NoticiasRepository;

public class AppFindAllByIds {
	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext contxt = new ClassPathXmlApplicationContext("root-context.xml");
		NoticiasRepository repo = contxt.getBean("noticiasRepository", NoticiasRepository.class);
		
		List<Integer> ids = new LinkedList<Integer>();
		ids.add(1);
		ids.add(2);
		ids.add(3);
		
		Iterable<Noticia> noti = repo.findAllById(ids);
		
		for (Noticia noticia : noti) {
			System.out.println(noticia);
		}
		
		//System.out.println("Cantidad de registros en la base de datos: "+ numeros);
		contxt.close();
	}
}
