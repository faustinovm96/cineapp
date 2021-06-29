package net.itinajero.app.service;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import net.itinajero.app.model.Genero;
import net.itinajero.app.model.Horario;
import net.itinajero.app.model.Pelicula;
import net.itinajero.app.repository.HorariosRepository;
import net.itinajero.app.repository.PeliculasRepository;

@Service
public class PeliculasServiceJpa implements IPeliculasService {

	@Autowired
	private PeliculasRepository peliculasRepo;

	@Autowired
	private HorariosRepository horariosRepo;
	
	@Autowired
	private GenerosServiceJp generosService;
	
	@Override
	public List<Pelicula> buscarActivas() {
		List<Pelicula> peliculas = null;
		peliculas = peliculasRepo.findByEstatus_OrderByTitulo("Activa");
		return peliculas;
	}
	
	@Override
	public List<Pelicula> buscarTodas() {
		// TODO Auto-generated method stub
		return peliculasRepo.findAll();
	}

	@Override
	public Pelicula buscarPorId(int idPelicula) {

		Optional<Pelicula> pelicula = peliculasRepo.findById(idPelicula);

		if (pelicula.isPresent()) {
			return pelicula.get();
		}

		return null;
	}

	@Override
	public void guardar(Pelicula pelicula) {
		peliculasRepo.save(pelicula);
	}

	@Override
	public List<String> buscarGeneros() {
		List<String> generos = new LinkedList<>();
		
		generosService.buscrTodos()
		.stream().forEach((genero)->generos.add(genero.getGenero()));
//		
//		generos.add("Accion");
//		generos.add("Aventuras");
//		generos.add("Clásicos");
//		generos.add("Comedia Romantica");
//		generos.add("Drama");
//		generos.add("Terror");
//		generos.add("Infantil");
//		generos.add("Accion y Aventura");
//		generos.add("Ciencia Ficcion");
//		generos.add("Romantica");

		return generos;
	}

	@Override
	public void eliminar(int idPelicula) {
		peliculasRepo.deleteById(idPelicula);
	}

	@Override
	public Page<Pelicula> buscarTodas(Pageable page) {
		return peliculasRepo.findAll(page);
	}
	
	@Override
	public List<Pelicula> buscarPorFecha(Date fecha) {		
		List<Pelicula> peliculas = null;
		// Buscamos en la tabla de horarios, [agrupando por idPelicula]
		List<Horario> horarios = horariosRepo.findByFecha(fecha);
		peliculas = new LinkedList<>();

		// Formamos la lista final de Peliculas que regresaremos.
		for (Horario h : horarios) {
			// Solo nos interesa de cada registro de horario, el registro de pelicula.
			peliculas.add(h.getPelicula());
		}		
		return peliculas;
	}

}
