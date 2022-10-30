package org.iesalixar.foroGamesHelper.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * The Class Comentario.
 */
@Entity
@Table(name="comentarios")
public class Comentario implements Serializable{
    
    
    /** serial. */
    private static final long serialVersionUID = 1L;

    /** The id. */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    /** The comentario. */
    @Column(nullable=false)
    private String comentario;
    
    /** The usuario. */
    @ManyToOne
    @JoinColumn(name = "usuarios_id")
    private Usuario usuario;
    
    /** The post. */
    @ManyToOne
    @JoinColumn(name = "posts_id")
    private Post post;
    
    /** The juego. */
    @ManyToOne
    @JoinColumn(name = "juegos_id")
    private Juego juego;

    
    /**
     * Instantiates a new comentario.
     */
    public Comentario() {
    }


    /**
     * Instantiates a new comentario.
     *
     * @param id the id
     * @param comentario the comentario
     * @param usuario the usuario
     * @param post the post
     * @param juego the juego
     */
    public Comentario(
        Long id,
        String comentario,
        Usuario usuario,
        Post post,
        Juego juego) {
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
    public Usuario getUsuario() {
        return usuario;
    }

    
    /**
     * Sets the usuario.
     *
     * @param usuario the new usuario
     */
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    
    /**
     * Gets the post.
     *
     * @return the post
     */
    public Post getPost() {
        return post;
    }

    
    /**
     * Sets the post.
     *
     * @param post the new post
     */
    public void setPost(Post post) {
        this.post = post;
    }

    
    /**
     * Gets the juego.
     *
     * @return the juego
     */
    public Juego getJuego() {
        return juego;
    }

    
    /**
     * Sets the juego.
     *
     * @param juego the new juego
     */
    public void setJuego(Juego juego) {
        this.juego = juego;
    }
    
    
}
