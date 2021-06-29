package net.itinajero.app.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import net.itinajero.app.model.Horario;
import net.itinajero.app.repository.HorariosRepository;

@Service
public class HorariosServiceJpa implements IHorariosService{

	@Autowired
	private HorariosRepository horariosRepo;
	
	@Override
	public List<Horario> buscarPorIdPelicula(int idPelicula, Date fecha) {
		// TODO Auto-generated method stub
		return horariosRepo.findByPelicula_IdAndFechaOrderByHora(idPelicula, fecha);
	}

	@Override
	public void guardar(Horario horario) {
		horariosRepo.save(horario);
	}

	@Override
	public List<Horario> buscarTodos() {
		// TODO Auto-generated method stub
		return horariosRepo.findAll();
	}

	@Override
	public void eliminar(int idHorario) {
		horariosRepo.deleteById(idHorario);
	}

	@Override
	public Horario buscarPorId(int idHorario) {
		Optional<Horario> horario = horariosRepo.findById(idHorario);
		
		if (horario.isPresent()) {
			return horario.get();
		}
		
		return null;
	}

	@Override
	public Page<Horario> buscarTodos(Pageable page) {
		// TODO Auto-generated method stub
		return horariosRepo.findAll(page);
	}
	
}
