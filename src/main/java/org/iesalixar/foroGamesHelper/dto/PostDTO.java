package org.iesalixar.foroGamesHelper.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

/**
 * The Class PostDTO.
 */
public class PostDTO implements Serializable {

    /** serial. */
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
    private String usuario;

    /** The juego. */
    private Long juego;

    /**
     * Instantiates a new post DTO.
     */
    public PostDTO() {
    }

    /**
     * Instantiates a new post DTO.
     *
     * @param id
     *            the id
     * @param titulo
     *            the titulo
     * @param contenido
     *            the contenido
     * @param fechaCreacion
     *            the fecha creacion
     * @param usuario
     *            the usuario
     * @param juego
     *            the juego
     */
    public PostDTO(
        Long id,
        String titulo,
        String contenido,
        LocalDate fechaCreacion,
        String usuario,
        Long juego) {
        this.id = id;
        this.titulo = titulo;
        this.contenido = contenido;
        this.fechaCreacion = fechaCreacion;
        this.usuario = usuario;
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
     * @param id
     *            the new id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Gets the titulo.
     *
     * @return the titulo
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * Sets the titulo.
     *
     * @param titulo
     *            the new titulo
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * Gets the contenido.
     *
     * @return the contenido
     */
    public String getContenido() {
        return contenido;
    }

    /**
     * Sets the contenido.
     *
     * @param contenido
     *            the new contenido
     */
    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    /**
     * Gets the fecha creacion.
     *
     * @return the fecha creacion
     */
    public LocalDate getFechaCreacion() {
        return fechaCreacion;
    }

    /**
     * Sets the fecha creacion.
     *
     * @param fechaCreacion
     *            the new fecha creacion
     */
    public void setFechaCreacion(LocalDate fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
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
     * @param usuario
     *            the new usuario
     */
    public void setUsuario(String usuario) {
        this.usuario = usuario;
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
     * @param juego
     *            the new juego
     */
    public void setJuego(Long juego) {
        this.juego = juego;
    }

    /**
     * Hash code.
     *
     * @return the int
     */
    @Override
    public int hashCode() {
        return Objects.hash(id, juego, usuario);
    }

    /**
     * Equals.
     *
     * @param obj
     *            the obj
     * @return true, if successful
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        PostDTO other = (PostDTO) obj;
        return Objects.equals(id, other.id) && Objects.equals(juego, other.juego)
            && Objects.equals(usuario, other.usuario);
    }
}
