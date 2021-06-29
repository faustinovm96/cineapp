package net.itinajero.app.service;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import net.itinajero.app.model.Pelicula;

public interface IPeliculasService {
	public List<Pelicula> buscarTodas();
	
	Page<Pelicula> buscarTodas(Pageable page);
	
	public Pelicula buscarPorId(int idPelicula);
	
	public void guardar(Pelicula pelicula);
	
	List<String> buscarGeneros();
	
	void eliminar(int idPelicula);
	
	List<Pelicula> buscarActivas();
	
	List<Pelicula> buscarPorFecha(Date fecha);
}
