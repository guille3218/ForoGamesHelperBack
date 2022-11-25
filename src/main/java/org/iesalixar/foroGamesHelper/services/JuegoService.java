package org.iesalixar.foroGamesHelper.services;

import java.util.List;

import org.iesalixar.foroGamesHelper.dto.JuegoInfo;
import org.iesalixar.foroGamesHelper.model.Juego;

/**
 * The Interface JuegoService.
 */
public interface JuegoService {
    
    public Juego getJuego(Long idJuego);
    public List<Juego> getJuegos();
    public boolean createJuego(Juego juego);
    public boolean deleteJuego(Juego juego);
    public List<JuegoInfo> getJuegosInfo();
    
}
