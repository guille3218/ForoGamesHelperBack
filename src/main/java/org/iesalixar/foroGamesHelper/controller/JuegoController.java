package org.iesalixar.foroGamesHelper.controller;

import org.iesalixar.foroGamesHelper.dto.JuegoDTO;
import org.iesalixar.foroGamesHelper.mapper.GameMapper;
import org.iesalixar.foroGamesHelper.model.Juego;
import org.iesalixar.foroGamesHelper.model.Usuario;
import org.iesalixar.foroGamesHelper.services.implement.JuegoServiceImpl;
import org.iesalixar.foroGamesHelper.services.implement.UsuarioServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
public class JuegoController {

    /** The juego service. */
    @Autowired
    JuegoServiceImpl juegoService;

    /** The user service. */
    @Autowired
    UsuarioServiceImpl userService;

    @PostMapping("/juego/add")
    public ResponseEntity<?> addJuego(@RequestBody JuegoDTO juegoDTO, @RequestParam String usuario) {
        if (usuario != null) {
            Usuario user = userService.getUsuario(usuario);
            Juego juegoDB = juegoService.getJuego(juegoDTO.getNombre());
            if (juegoDB == null) {
                if (user != null) {
                    Juego juego = new Juego(juegoDTO.getNombre(), juegoDTO.getCompania(), juegoDTO.getGenero(),
                        juegoDTO.isCoop(), juegoDTO.getAnioSalida());
                    if (juegoService.createJuego(juego)) {
                        return new ResponseEntity<String>("Juego creado correctamente", HttpStatus.OK);
                    }
                    return new ResponseEntity<String>("Hubo un problema al crear el juego",
                        HttpStatus.INTERNAL_SERVER_ERROR);
                }
            }else {
                return new ResponseEntity<String>("Ya estaba registrado este juego",
                    HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } else {
            return new ResponseEntity<String>("No ha iniciado sesion. Inicia Sesion para añadir un juego",
                HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<String>("La solicitud no la realiza un usuario", HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/juego/{idJuego}")
    public ResponseEntity<?> getJuego(@PathVariable Long idJuego) {
        if (idJuego != null) {
            Juego juego = juegoService.getJuego(idJuego);
            if (juego != null) {
                return new ResponseEntity<JuegoDTO>(GameMapper.mapToJuegoDTO(juego), HttpStatus.OK);
            } else {
                return new ResponseEntity<String>("No se ha encontrado el juego que busca",
                    HttpStatus.BAD_REQUEST);
            }
        }
        return new ResponseEntity<String>("No se ha informado del juego que desea buscar",
            HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("/juego/{idJuego}")
    public ResponseEntity<?> deleteJuego(@PathVariable Long idJuego) {
        if (idJuego != null) {
            Juego juego = juegoService.getJuego(idJuego);
            if (juego != null) {
                juegoService.deleteJuego(juego);
                return new ResponseEntity<String>("Juego borrado correctamente", HttpStatus.OK);
            } else {
                return new ResponseEntity<String>("No se ha encontrado el juego que busca",
                    HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
        return new ResponseEntity<String>("No se ha informado del juego que desea eliminar",
            HttpStatus.BAD_REQUEST);
    }
}
