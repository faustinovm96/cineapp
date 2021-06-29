package net.itinajero.app.service;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import net.itinajero.app.model.Horario;

public interface IHorariosService {
	List<Horario> buscarPorIdPelicula(int idPelicula, Date fecha);
	
	void guardar(Horario horario);
	
	List<Horario> buscarTodos();
	
	void eliminar(int idHorario);
	
	Horario buscarPorId(int idHorario);
	
	Page<Horario> buscarTodos(Pageable page);
}
