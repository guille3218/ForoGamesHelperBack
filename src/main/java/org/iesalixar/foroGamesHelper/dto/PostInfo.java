package org.iesalixar.foroGamesHelper.dto;

import java.util.Objects;

// TODO: Auto-generated Javadoc
/**
 * The Class PostInfo.
 */
public class PostInfo {

    /** The id. */
    private Long id;

    /** The titulo. */
    private String titulo;

    /** The contenido reducido. */
    private String contenidoReducido;

    /** The fecha creacion. */
    private String fechaCreacion;

    /** The usuario. */
    private String usuario;

    /** The juego. */
    private String juego;

    /** The num comentarios. */
    private int numComentarios;

    /**
     * Instantiates a new post info.
     *
     * @param id
     *            the id
     * @param titulo
     *            the titulo
     * @param contenidoReducido
     *            the contenido reducido
     * @param fechaCreacion
     *            the fecha creacion
     * @param usuario
     *            the usuario
     * @param juego
     *            the juego
     * @param numComentarios
     *            the num comentarios
     */
    public PostInfo(
        Long id,
        String titulo,
        String contenidoReducido,
        String fechaCreacion,
        String usuario,
        String juego,
        int numComentarios) {
        super();
        this.id = id;
        this.titulo = titulo;
        this.contenidoReducido = contenidoReducido;
        this.fechaCreacion = fechaCreacion;
        this.usuario = usuario;
        this.juego = juego;
        this.numComentarios = numComentarios;
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
     * Gets the contenido reducido.
     *
     * @return the contenido reducido
     */
    public String getContenidoReducido() {
        return contenidoReducido;
    }

    /**
     * Sets the contenido reducido.
     *
     * @param contenidoReducido
     *            the new contenido reducido
     */
    public void setContenidoReducido(String contenidoReducido) {
        this.contenidoReducido = contenidoReducido;
    }

    /**
     * Gets the fecha creacion.
     *
     * @return the fecha creacion
     */
    public String getFechaCreacion() {
        return fechaCreacion;
    }

    /**
     * Sets the fecha creacion.
     *
     * @param fechaCreacion
     *            the new fecha creacion
     */
    public void setFechaCreacion(String fechaCreacion) {
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
    public String getJuego() {
        return juego;
    }

    /**
     * Sets the juego.
     *
     * @param juego
     *            the new juego
     */
    public void setJuego(String juego) {
        this.juego = juego;
    }

    /**
     * Gets the num comentarios.
     *
     * @return the num comentarios
     */
    public int getNumComentarios() {
        return numComentarios;
    }

    /**
     * Sets the num comentarios.
     *
     * @param numComentarios
     *            the new num comentarios
     */
    public void setNumComentarios(int numComentarios) {
        this.numComentarios = numComentarios;
    }

    /**
     * Hash code.
     *
     * @return the int
     */
    @Override
    public int hashCode() {
        return Objects.hash(id);
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
        PostInfo other = (PostInfo) obj;
        return Objects.equals(id, other.id);
    }
}
