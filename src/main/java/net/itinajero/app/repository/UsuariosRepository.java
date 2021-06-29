/**
 * 
 */
package net.itinajero.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.itinajero.app.model.Usuario;

/**
 * @author F996
 *
 */
public interface UsuariosRepository extends JpaRepository<Usuario, Integer> {

}
