package org.iesalixar.foroGamesHelper.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.iesalixar.foroGamesHelper.model.Comentario;
import org.iesalixar.foroGamesHelper.model.Juego;
import org.iesalixar.foroGamesHelper.model.Usuario;

/**
 * The Class PostDTO.
 */
public class PostDTO implements Serializable {

    /** serial */
    private static final long serialVersionUID = 1L;

    /** The id. */
    private Long id;

    /** The titulo. */
    private String titulo;

    /** The contenido. */
    private String contenido;

    /** The fecha creacion. */
    private LocalDate fechaCreacion;

    /** The usuario. */
    private Usuario usuario;

    /** The juego. */
    private Juego juego;

    /** The comentarios. */
    private List<Comentario> comentarios;

    /**
     * Instantiates a new post DTO.
     */
    public PostDTO() {
    }

    public PostDTO(
        String titulo,
        String contenido,
        LocalDate fechaCreacion,
        Usuario usuario,
        Juego juego) {
        this.titulo = titulo;
        this.contenido = contenido;
        this.fechaCreacion = fechaCreacion;
        this.usuario = usuario;
        this.juego = juego;
        this.comentarios = new ArrayList<>();
    }
    
    
}
