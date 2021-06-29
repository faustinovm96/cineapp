package net.itinajero.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.itinajero.app.model.Genero;
import net.itinajero.app.repository.GenerosRepository;

@Service
public class GenerosServiceJp implements GenerosService{
	
	@Autowired
	private GenerosRepository gRepo;
	
	@Override
	public List<Genero> buscrTodos() {
		// TODO Auto-generated method stub
		return gRepo.findAll();
	}

}
