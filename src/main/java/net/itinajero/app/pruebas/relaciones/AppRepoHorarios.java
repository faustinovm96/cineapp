package net.itinajero.app.pruebas.relaciones;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import net.itinajero.app.model.Horario;
import net.itinajero.app.model.Noticia;
import net.itinajero.app.model.Pelicula;
import net.itinajero.app.repository.HorariosRepository;
import net.itinajero.app.repository.NoticiasRepository;
import net.itinajero.app.repository.PeliculasRepository;

public class AppRepoHorarios {
	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext contxt = new ClassPathXmlApplicationContext("root-context.xml");
		HorariosRepository repo = contxt.getBean("horariosRepository", HorariosRepository.class);
				
		List<Horario> iterable =  repo.findAll();
		
		for (Horario horario: iterable)
			System.out.println(horario);
		
		
		
		//System.out.println("Cantidad de registros en la base de datos: "+ numeros);
		contxt.close();
	}
}
