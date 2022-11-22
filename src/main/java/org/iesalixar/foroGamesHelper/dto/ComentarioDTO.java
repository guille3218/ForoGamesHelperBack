package org.iesalixar.foroGamesHelper.dto;

import java.io.Serializable;

/**
 * The Class ComentarioDTO.
 */
public class ComentarioDTO implements Serializable {

    /**  serial. */
    private static final long serialVersionUID = 1L;

    /** The id. */
    private Long id;

    /** The comentario. */
    private String comentario;

    /** The usuario. */
    private String usuario;

    /** The post. */
    private Long post;

    /** The juego. */
    private Long juego;

    /**
     * Instantiates a new comentario DTO.
     */
    public ComentarioDTO() {
    }

    /**
     * Instantiates a new comentario DTO.
     *
     * @param comentario            the comentario
     * @param usuario            the usuario
     * @param post            the post
     * @param juego            the juego
     */
    public ComentarioDTO(
        Long id,
        String comentario,
        String usuario,
        Long post,
        Long juego) {
        this.id = id;
        this.comentario = comentario;
        this.usuario = usuario;
        this.post = post;
        this.juego = juego;
    }

    
    /**
     * Gets the id.
     *
     * @return the id
     */
    public Long getId() {
        return id;
    }

    
    /**
     * Sets the id.
     *
     * @param id the new id
     */
    public void setId(Long id) {
        this.id = id;
    }

    
    /**
     * Gets the comentario.
     *
     * @return the comentario
     */
    public String getComentario() {
        return comentario;
    }

    
    /**
     * Sets the comentario.
     *
     * @param comentario the new comentario
     */
    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    
    /**
     * Gets the usuario.
     *
     * @return the usuario
     */
    public String getUsuario() {
        return usuario;
    }

    
    /**
     * Sets the usuario.
     *
     * @param usuario the new usuario
     */
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    
    /**
     * Gets the post.
     *
     * @return the post
     */
    public Long getPost() {
        return post;
    }

    
    /**
     * Sets the post.
     *
     * @param post the new post
     */
    public void setPost(Long post) {
        this.post = post;
    }

    
    /**
     * Gets the juego.
     *
     * @return the juego
     */
    public Long getJuego() {
        return juego;
    }

    
    /**
     * Sets the juego.
     *
     * @param juego the new juego
     */
    public void setJuego(Long juego) {
        this.juego = juego;
    }
    
    
}
