package org.iesalixar.foroGamesHelper.services.implement;

import java.util.List;
import java.util.Optional;

import org.iesalixar.foroGamesHelper.model.Usuario;
import org.iesalixar.foroGamesHelper.repository.UsuarioRepository;
import org.iesalixar.foroGamesHelper.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * The Class UsuarioServiceImpl.
 */
@Service
public class UsuarioServiceImpl implements UsuarioService {

    /** The user repo. */
    @Autowired
    UsuarioRepository userRepo;

    /**
     * Insert usuario.
     *
     * @param usuario
     *            the usuario
     * @return the usuario
     */
    @Override
    public Usuario insertUsuario(Usuario usuario) {
        if (usuario != null && usuario.getId() == null) {
            return userRepo.save(usuario);
        }
        return null;
    }

    /**
     * Update usuario.
     *
     * @param usuario
     *            the usuario
     * @return the boolean
     */
    @Override
    public Boolean updateUsuario(Usuario usuario) {
        if (getUsuario(usuario.getUserName()) != null) {
            Usuario userUpdate = userRepo.save(usuario);
            if (userUpdate.getId() != null) {
                return true;
            }
            return false;
        }
        return false;
    }

    /**
     * Delete usuario.
     *
     * @param usuario
     *            the usuario
     * @return the boolean
     */
    @Override
    public Boolean deleteUsuario(String usuario) {
        Usuario user = getUsuario(usuario);
        if (user.getId() != null) {
            user.setActivo(false);
            return updateUsuario(user);
        }
        return false;
    }

    /**
     * Gets the usuario.
     *
     * @param usuario
     *            the usuario
     * @return the usuario
     */
    @Override
    public Usuario getUsuario(String usuario) {
        if (usuario != null) {
            return userRepo.findByUsuario(usuario);
        }
        return null;
    }

    /**
     * Gets the usuario by email.
     *
     * @param email
     *            the email
     * @return the usuario by email
     */
    @Override
    public Usuario getUsuarioByEmail(String email) {
        if (email != null) {
            return userRepo.findByEmail(email);
        }
        return null;
    }

    /**
     * Gets the all users.
     *
     * @return the all users
     */
    @Override
    public List<Usuario> getAllUsers() {
        return userRepo.findAll();
    }
    
    @Override
    public Boolean login(String usuario, String password) {
        Usuario user = getUsuario(usuario);
        if (usuario != null) {
            boolean match = new BCryptPasswordEncoder(15).matches(user.getPassword(), password);
            if (match) {
                return true;
            }
        }
        return false;
    }
    
    
}
