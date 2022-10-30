package org.iesalixar.foroGamesHelper.repository;

import java.util.Optional;

import org.iesalixar.foroGamesHelper.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * The Interface UsuarioRepository.
 */
@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
	public Usuario findByUsuario(String usuario);
	public Usuario findByEmail(String email);
	public Optional<Usuario> getUsuarioByUsuarioAndPassword(String usuario, String password);
}
