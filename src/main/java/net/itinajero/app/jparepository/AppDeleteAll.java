package net.itinajero.app.jparepository;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import net.itinajero.app.model.Noticia;
import net.itinajero.app.repository.NoticiasRepository;

public class AppDeleteAll {
	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext contxt = new ClassPathXmlApplicationContext("root-context.xml");
		NoticiasRepository repo = contxt.getBean("noticiasRepository", NoticiasRepository.class);
		
		repo.deleteAllInBatch();//Este metodo es mas eficiente
		
		contxt.close();
	}
}
