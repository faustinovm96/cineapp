package net.itinajero.app.pruebas.relaciones;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import net.itinajero.app.model.Detalle;
import net.itinajero.app.model.Noticia;
import net.itinajero.app.model.Pelicula;
import net.itinajero.app.repository.DetallesRepository;
import net.itinajero.app.repository.NoticiasRepository;
import net.itinajero.app.repository.PeliculasRepository;

public class AppRepoDetalles {
	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext contxt = new ClassPathXmlApplicationContext("root-context.xml");
		DetallesRepository repo = contxt.getBean("detallesRepository", DetallesRepository.class);
				
		List<Detalle> iterable =  repo.findAll();
		
		for (Detalle detalle : iterable) {
			System.out.println(detalle);
		}
		
		
		//System.out.println("Cantidad de registros en la base de datos: "+ numeros);
		contxt.close();
	}
}
