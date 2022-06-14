package org.iesalixar.foroGamesHelper.services;

import java.util.List;

import org.iesalixar.foroGamesHelper.model.Usuario;

public interface UsuarioService {
	public Usuario insertUsuario(Usuario usuario);
	public Usuario getUsuario(String username);
	public Usuario getUsuarioByEmail(String email);
	public List<Usuario> getAllUsers();
}
