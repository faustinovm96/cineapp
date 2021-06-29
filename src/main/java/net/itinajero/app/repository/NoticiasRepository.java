package net.itinajero.app.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import net.itinajero.app.model.Noticia;

@Repository
public interface NoticiasRepository extends JpaRepository<Noticia, Integer> {
	List<Noticia> findByEstatus(String estatus);
	
	List<Noticia> findByEstatusAndFecha(String estatus, Date fecha);
	
	List<Noticia> findByEstatusOrFecha(String estatus, Date fecha);
	
	List<Noticia> findByFechaBetween(Date fecha1, Date fecha2);
	
	List<Noticia> findByIdBetween(int n1, int n2);
	
	List<Noticia> findTop3ByEstatusOrderByIdDesc(String estatus);
	
}
