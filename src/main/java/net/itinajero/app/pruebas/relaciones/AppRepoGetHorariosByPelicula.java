package net.itinajero.app.pruebas.relaciones;

import java.util.List;
import java.util.Optional;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import net.itinajero.app.model.Horario;
import net.itinajero.app.model.Noticia;
import net.itinajero.app.model.Pelicula;
import net.itinajero.app.repository.HorariosRepository;
import net.itinajero.app.repository.NoticiasRepository;
import net.itinajero.app.repository.PeliculasRepository;

public class AppRepoGetHorariosByPelicula {
	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext contxt = new ClassPathXmlApplicationContext("root-context.xml");
		PeliculasRepository repo = contxt.getBean("peliculasRepository", PeliculasRepository.class);
				
		Optional<Pelicula> optional = repo.findById(7);
		
		System.out.println(optional.get().getHorarios().size());
		
		
		//System.out.println("Cantidad de registros en la base de datos: "+ numeros);
		contxt.close();
	}
}
