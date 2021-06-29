/**
 * 
 */
package net.itinajero.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import net.itinajero.app.model.Usuario;
import net.itinajero.app.repository.UsuariosRepository;

/**
 * @author F996
 *
 */
@Service
public class UsuariosServiceJpa implements UsuariosService {

	@Autowired
	private UsuariosRepository usuariosRepo;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * net.itinajero.app.service.UsuariosService#guardar(net.itinajero.app.model.
	 * Usuario)
	 */
	@Override
	public void guardar(Usuario usuario) {
		usuariosRepo.save(usuario);
	}

	@Override
	public List<Usuario> buscarTodos() {
		// TODO Auto-generated method stub
		return usuariosRepo.findAll();
	}

	@Override
	public Page<Usuario> buscarTodos(Pageable page) {
		// TODO Auto-generated method stub
		return usuariosRepo.findAll(page);
	}

	@Override
	public void eliminar(int idUsuario) {
		usuariosRepo.deleteById(idUsuario);
	}

	@Override
	public Usuario buscarPorId(int idUsuario) {
		// TODO Auto-generated method stub
		Optional<Usuario> usuario = usuariosRepo.findById(idUsuario);
		
		if(usuario.isPresent()) {
			return usuario.get();
		}
		
		return null;
	}

}
