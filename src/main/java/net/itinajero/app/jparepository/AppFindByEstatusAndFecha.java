package net.itinajero.app.jparepository;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import net.itinajero.app.model.Noticia;
import net.itinajero.app.repository.NoticiasRepository;

public class AppFindByEstatusAndFecha {
	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext contxt = new ClassPathXmlApplicationContext("root-context.xml");
		NoticiasRepository repo = contxt.getBean("noticiasRepository", NoticiasRepository.class);
		
		SimpleDateFormat sm = new SimpleDateFormat("yyyy-MM-dd");
		
		
		
		//long numeros = repo.count();
		
		List<Noticia> iterable = null;
		try {
			iterable = repo.findByEstatusAndFecha("Activa", sm.parse("2017-09-02"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for (Noticia noticia : iterable) {
			System.out.println(noticia);
		}
		
		
		//System.out.println("Cantidad de registros en la base de datos: "+ numeros);
		contxt.close();
	}
}
