package org.iesalixar.foroGamesHelper.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import org.iesalixar.foroGamesHelper.model.Comentario;
import org.iesalixar.foroGamesHelper.model.Post;

/**
 * The Class JuegoDTO.
 */
public class JuegoDTO implements Serializable {

    /** serial */
    private static final long serialVersionUID = 1L;

    /** The id. */
    private Long id;

    /** The nombre. */
    private String nombre;

    /** The compania. */
    private String compania;

    /** The genero. */
    private String genero;

    /** The coop. */
    private boolean coop;

    /** The anio salida. */
    private LocalDate anioSalida;

    /** The posts. */
    private List<Post> posts;

    /** The comentarios. */
    private List<Comentario> comentarios;

    /**
     * Instantiates a new juego DTO.
     */
    public JuegoDTO() {
    }

    /**
     * Instantiates a new juego DTO.
     *
     * @param id
     *            the id
     * @param nombre
     *            the nombre
     * @param compania
     *            the compania
     * @param genero
     *            the genero
     * @param coop
     *            the coop
     * @param anioSalida
     *            the anio salida
     */
    public JuegoDTO(
        String nombre,
        String compania,
        String genero,
        boolean coop,
        LocalDate anioSalida) {
        this.nombre = nombre;
        this.compania = compania;
        this.genero = genero;
        this.coop = coop;
        this.anioSalida = anioSalida;
        this.posts = new ArrayList<>();
        this.comentarios = new ArrayList<>();
    }

    
    public Long getId() {
        return id;
    }

    
    public void setId(Long id) {
        this.id = id;
    }

    
    public String getNombre() {
        return nombre;
    }

    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    
    public String getCompania() {
        return compania;
    }

    
    public void setCompania(String compania) {
        this.compania = compania;
    }

    
    public String getGenero() {
        return genero;
    }

    
    public void setGenero(String genero) {
        this.genero = genero;
    }

    
    public boolean isCoop() {
        return coop;
    }

    
    public void setCoop(boolean coop) {
        this.coop = coop;
    }

    
    public LocalDate getAnioSalida() {
        return anioSalida;
    }

    
    public void setAnioSalida(LocalDate anioSalida) {
        this.anioSalida = anioSalida;
    }

    
    public List<Post> getPosts() {
        return posts;
    }

    
    public void setPosts(Set<Post> posts) {
        this.posts = new ArrayList<>(posts);
    }

    
    public List<Comentario> getComentarios() {
        return comentarios;
    }

    
    public void setComentarios(Set<Comentario> comentarios) {
        this.comentarios = new ArrayList<>(comentarios);
    }
    
    
}
