package org.iesalixar.foroGamesHelper.controller;

import java.util.List;

import org.iesalixar.foroGamesHelper.constant.RolEnum;
import org.iesalixar.foroGamesHelper.dto.UsuarioDTO;
import org.iesalixar.foroGamesHelper.mapper.GameMapper;
import org.iesalixar.foroGamesHelper.model.Usuario;
import org.iesalixar.foroGamesHelper.services.implement.UsuarioServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
public class UserController {

    @Autowired
    UsuarioServiceImpl usuarioService;

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody UsuarioDTO usuario) {
        Usuario userBD = new Usuario();
        userBD.setRole(RolEnum.USER.name());
        userBD.setNombre(usuario.getNombre());
        userBD.setApellidos(usuario.getApellidos());
        userBD.setUsuario(usuario.getUsuario());
        userBD.setEmail(usuario.getEmail());
        userBD.setActivo(true);
        userBD.setPassword(new BCryptPasswordEncoder(15).encode(usuario.getPassword()));
        Usuario user = usuarioService.getUsuario(usuario.getUsuario());
        Usuario user2 = usuarioService.getUsuarioByEmail(usuario.getEmail());
        if (user != null) {
            return new ResponseEntity<String>("Usuario ya existente.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        if (user2 != null) {
            return new ResponseEntity<String>("Email ya registrado.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        System.out.println(userBD);
        userBD = usuarioService.insertUsuario(userBD);
        return new ResponseEntity<Usuario>(userBD, HttpStatus.OK);
    }

    @GetMapping("/usuarios")
    public List<Usuario> obtenerUsuarios(@RequestParam(required = false) Boolean activo) {
        if (activo != null) {
            return usuarioService.getAllUsers(activo.booleanValue());
        }
        return usuarioService.getAllUsers();
    }

    @GetMapping("/login")
    public ResponseEntity<?> getUsuarioLogin(@RequestBody UsuarioDTO usuario) {
        if (usuario.getUsuario() != null && usuario.getPassword() != null) {
            Boolean isUserLogin = usuarioService.login(usuario.getUsuario(), usuario.getPassword());
            if (!isUserLogin) {
                return new ResponseEntity<String>("El usuario o las credenciales son incorrectas.",
                    HttpStatus.INTERNAL_SERVER_ERROR);
            } else {
                Usuario user = usuarioService.getUsuario(usuario.getUsuario());
                user.setPassword(null);
                return new ResponseEntity<Usuario>(user, HttpStatus.OK);
            }
        }
        return new ResponseEntity<String>("No se han informado de los datos de acceso",
            HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @DeleteMapping("/unsuscribe/{usuario}")
    public ResponseEntity<?> deleteUsuario(@PathVariable String usuario) {
        if (usuarioService.deleteUsuario(usuario)) {
            return new ResponseEntity<String>("Usuario bloqueado correctamente", HttpStatus.OK);
        }
        return new ResponseEntity<String>("No se ha encontrado al usuario que se desea eliminar",
            HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @PatchMapping("/suscribe/{usuario}")
    public ResponseEntity<?> activeUsuario(@PathVariable String usuario) {
        if (usuario != null) {
            if (usuarioService.activeUsuario(usuario)) {
                return new ResponseEntity<String>("Usuario activado correctamente", HttpStatus.OK);
            }
            return new ResponseEntity<String>("No se ha encontrado al usuario que se desea activar",
                HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<String>("No se ha encontrado al usuario que se desea activar",
            HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @PostMapping("/update/{usuario}")
    public ResponseEntity<?> updateUsuario(@RequestBody UsuarioDTO usuarioDTO, @PathVariable String usuario) {
        Usuario user = usuarioService.getUsuario(usuario);
        if (user != null) {
            return new ResponseEntity<String>(
                usuarioService.updateUsuario(GameMapper.mapToUsuario(usuarioDTO), usuario)
                    ? "Usuario actualizado correctamente"
                    : "Fallo al actualizar el usuario",
                HttpStatus.OK);
        }
        return new ResponseEntity<String>("No se ha encontrado al usuario que se desea actualizar",
            HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
