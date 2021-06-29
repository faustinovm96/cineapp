package net.itinajero.app.jparepository;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import net.itinajero.app.model.Noticia;
import net.itinajero.app.repository.NoticiasRepository;

public class AppSorting {
	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext contxt = new ClassPathXmlApplicationContext("root-context.xml");
		NoticiasRepository repo = contxt.getBean("noticiasRepository", NoticiasRepository.class);
		
		;
		List<Noticia> lista = repo.findAll(Sort.by("titulo").descending().and(Sort.by("fecha")));
		for (Noticia noticia : lista) {
			System.out.println(noticia);
		}
		
		contxt.close();
	}
}
