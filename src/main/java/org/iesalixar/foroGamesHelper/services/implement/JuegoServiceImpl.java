package org.iesalixar.foroGamesHelper.services.implement;

import java.util.List;
import java.util.Optional;

import org.iesalixar.foroGamesHelper.dto.JuegoInfo;
import org.iesalixar.foroGamesHelper.mapper.GameMapper;
import org.iesalixar.foroGamesHelper.model.Juego;
import org.iesalixar.foroGamesHelper.repository.JuegoRepository;
import org.iesalixar.foroGamesHelper.services.JuegoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JuegoServiceImpl implements JuegoService {

    @Autowired
    JuegoRepository gameRepo;

    @Override
    public Juego getJuego(Long idJuego) {
        Optional<Juego> juego = gameRepo.findById(idJuego);
        if(juego.isPresent()) {
            return juego.get();
        }else {
            return null;
        }
    }

    @Override
    public List<Juego> getJuegos() {
        return gameRepo.findAll();
    }

    @Override
    public boolean createJuego(Juego juego) {
        if(juego != null && juego.getId() == null) {
            gameRepo.save(juego);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteJuego(Juego juego) {
        if(juego!=null && juego.getId() != null) {
            gameRepo.delete(juego);
            return true;
        }
        return false;
    }

    @Override
    public List<JuegoInfo> getJuegosInfo() {
        List<Juego> listJuegos = gameRepo.findAll();
        return GameMapper.mapToListJuegoInfo(listJuegos);
    }
    
    
}
