package net.itinajero.app.repository;


import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import net.itinajero.app.model.Pelicula;

@Repository
public interface PeliculasRepository extends JpaRepository<Pelicula, Integer> {

	//Page<Pelicula> findAll(Pageable page);
	public List<Pelicula> findByEstatus_OrderByTitulo(String estatus);
}
