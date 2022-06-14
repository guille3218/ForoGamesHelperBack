package org.iesalixar.foroGamesHelper.services;

import java.util.List;

import org.iesalixar.foroGamesHelper.model.Usuario;
import org.iesalixar.foroGamesHelper.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServiceImpl implements UsuarioService {

	@Autowired
	UsuarioRepository userRepo;

	@Override
	public Usuario insertUsuario(Usuario usuario) {

		if (usuario != null) {

			return userRepo.save(usuario);
		}

		return null;

	}

	@Override
	public Usuario getUsuario(String username) {

		if (username != null) {

			return userRepo.findByUserName(username);
		}

		return null;
	}
	
	@Override
	public Usuario getUsuarioByEmail(String email) {

		if (email != null) {

			return userRepo.findByEmail(email);
		}

		return null;
	}
	
	@Override
	public List<Usuario> getAllUsers(){
		return userRepo.findAll();
	}
}
