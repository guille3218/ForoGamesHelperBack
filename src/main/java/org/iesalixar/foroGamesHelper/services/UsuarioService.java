package org.iesalixar.foroGamesHelper.services;

import java.util.List;

import org.iesalixar.foroGamesHelper.model.Usuario;

public interface UsuarioService {
	public Usuario insertUsuario(Usuario usuario);
	public Boolean updateUsuario(Usuario usuario);
	public Boolean deleteUsuario(String usuario);
	public Boolean activeUsuario(String usuario);
	public Usuario getUsuario(String username);
	public Usuario getUsuarioByEmail(String email);
	public Boolean login(String usuario, String password);
	public List<Usuario> getAllUsers();
}
