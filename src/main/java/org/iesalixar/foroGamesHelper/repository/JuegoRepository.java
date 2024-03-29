package org.iesalixar.foroGamesHelper.repository;

import java.util.Optional;

import org.iesalixar.foroGamesHelper.model.Juego;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JuegoRepository extends JpaRepository<Juego, Long>{
    
    Optional<Juego> findByNombre(String nombre);
}
