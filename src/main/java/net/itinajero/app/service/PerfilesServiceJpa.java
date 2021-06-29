/**
 * 
 */
package net.itinajero.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.itinajero.app.model.Perfil;
import net.itinajero.app.repository.PerfilesRepository;

/**
 * @author F996
 *
 */
@Service
public class PerfilesServiceJpa implements PerfilesService {

	@Autowired
	private PerfilesRepository perfilRepo;

	@Override
	public void guardar(Perfil perfil) {
		perfilRepo.save(perfil);
	}
	

}
