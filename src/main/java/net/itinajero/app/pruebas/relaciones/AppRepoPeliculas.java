package net.itinajero.app.pruebas.relaciones;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import net.itinajero.app.model.Noticia;
import net.itinajero.app.model.Pelicula;
import net.itinajero.app.repository.NoticiasRepository;
import net.itinajero.app.repository.PeliculasRepository;

public class AppRepoPeliculas {
	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext contxt = new ClassPathXmlApplicationContext("root-context.xml");
		PeliculasRepository repo = contxt.getBean("peliculasRepository", PeliculasRepository.class);
				
		List<Pelicula> iterable =  repo.findAll();
		
		for (Pelicula pelicula : iterable) {
			System.out.println(pelicula);
		}
		
		
		//System.out.println("Cantidad de registros en la base de datos: "+ numeros);
		contxt.close();
	}
}
