package org.iesalixar.foroGamesHelper.repository;

import org.iesalixar.foroGamesHelper.model.Usuario;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
	public Usuario findByUserName(String userName);
	public Usuario findByEmail(String email);
}
