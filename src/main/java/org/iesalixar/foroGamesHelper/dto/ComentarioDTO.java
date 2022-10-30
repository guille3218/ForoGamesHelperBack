/*
 * 
 */
package org.iesalixar.foroGamesHelper.dto;

import java.io.Serializable;

import org.iesalixar.foroGamesHelper.model.Juego;
import org.iesalixar.foroGamesHelper.model.Post;
import org.iesalixar.foroGamesHelper.model.Usuario;

/**
 * The Class ComentarioDTO.
 */
public class ComentarioDTO implements Serializable {

    /** serial */
    private static final long serialVersionUID = 1L;

    /** The id. */
    private Long id;

    /** The comentario. */
    private String comentario;

    /** The usuario. */
    private Usuario usuario;

    /** The post. */
    private Post post;

    /** The juego. */
    private Juego juego;

    /**
     * Instantiates a new comentario DTO.
     */
    public ComentarioDTO() {
    }

    /**
     * Instantiates a new comentario DTO.
     *
     * @param id
     *            the id
     * @param comentario
     *            the comentario
     * @param usuario
     *            the usuario
     * @param post
     *            the post
     * @param juego
     *            the juego
     */
    public ComentarioDTO(
        String comentario,
        Usuario usuario,
        Post post,
        Juego juego) {
        this.comentario = comentario;
        this.usuario = usuario;
        this.post = post;
        this.juego = juego;
    }
    
    
}
