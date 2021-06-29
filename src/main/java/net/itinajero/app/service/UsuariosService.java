/**
 * 
 */
package net.itinajero.app.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import net.itinajero.app.model.Usuario;

/**
 * @author F996
 *
 */
public interface UsuariosService {
	void guardar(Usuario usuario);
	List<Usuario> buscarTodos();
	Page<Usuario> buscarTodos(Pageable page);
	void eliminar(int idUsuario);
	Usuario buscarPorId(int idUsuario);
}
