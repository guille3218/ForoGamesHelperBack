package org.iesalixar.foroGamesHelper.repository;

import org.iesalixar.foroGamesHelper.model.Comentario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * The Interface ComentarioRepository.
 */
@Repository
public interface ComentarioRepository extends JpaRepository<Comentario, Long>{
}
