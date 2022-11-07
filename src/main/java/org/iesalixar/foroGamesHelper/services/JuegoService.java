package org.iesalixar.foroGamesHelper.services;

import java.util.List;

import org.iesalixar.foroGamesHelper.model.Juego;

public interface JuegoService {
    
    public Juego getJuego(Long idJuego);
    public List<Juego> getJuegos();
}
