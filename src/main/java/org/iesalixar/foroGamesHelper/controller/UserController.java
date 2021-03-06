package org.iesalixar.foroGamesHelper.controller;

import java.util.List;

import org.iesalixar.foroGamesHelper.dto.UsuarioDTO;
import org.iesalixar.foroGamesHelper.model.Usuario;
import org.iesalixar.foroGamesHelper.services.UsuarioServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
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

		userBD.setActivo(false);
		userBD.setRole("USER");
		userBD.setNombre(usuario.getNombre());
		userBD.setApellidos(usuario.getApellidos());
		userBD.setUserName(usuario.getUsuario());
		userBD.setEmail(usuario.getEmail());
		userBD.setPassword(new BCryptPasswordEncoder(15).encode(usuario.getPassword()));

		Usuario user = usuarioService.getUsuario(usuario.getUsuario());
		Usuario user2 = usuarioService.getUsuarioByEmail(usuario.getEmail());
		if (user != null) {
			return new ResponseEntity("Usuario ya existente.", HttpStatus.INTERNAL_SERVER_ERROR);
		}

		if (user2 != null) {
			return new ResponseEntity("Email ya registrado.", HttpStatus.INTERNAL_SERVER_ERROR);
		}

		
		userBD = usuarioService.insertUsuario(userBD);

		return new ResponseEntity(userBD, HttpStatus.OK);
	}

	@GetMapping("/usuarios")
	public List<Usuario> obtenerUsuarios() {
		return usuarioService.getAllUsers();
	}
	
	@GetMapping("/login")
	public ResponseEntity<?> getUsuarioLogin(@RequestParam String username, @RequestParam String password) {
		Usuario user = usuarioService.getUsuario(username);
		
		if(user == null) {
			return new ResponseEntity("El usuario "+ username +" no existe.", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		boolean match = new BCryptPasswordEncoder(15).matches(password, user.getPassword());
		
		if(!match) {
			return new ResponseEntity("Las credenciales son incorrectas.", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return new ResponseEntity(user, HttpStatus.OK);
		
	}
}
