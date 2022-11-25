package org.iesalixar.foroGamesHelper.dto;

import java.time.LocalDate;
import java.util.Objects;

/**
 * The Class JuegoInfo.
 */
public class JuegoInfo {

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

    /** The num post. */
    private int numPost;

    /** The num comentarios. */
    private int numComentarios;

    /**
     * Instantiates a new juego info.
     */
    public JuegoInfo() {
        super();
    };

    /**
     * Instantiates a new juego info.
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
     * @param numPost
     *            the num post
     * @param numComentarios
     *            the num comentarios
     */
    public JuegoInfo(
        Long id,
        String nombre,
        String compania,
        String genero,
        boolean coop,
        LocalDate anioSalida,
        int numPost,
        int numComentarios) {
        super();
        this.id = id;
        this.nombre = nombre;
        this.compania = compania;
        this.genero = genero;
        this.coop = coop;
        this.anioSalida = anioSalida;
        this.numPost = numPost;
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
     * Gets the nombre.
     *
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Sets the nombre.
     *
     * @param nombre
     *            the new nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Gets the compania.
     *
     * @return the compania
     */
    public String getCompania() {
        return compania;
    }

    /**
     * Sets the compania.
     *
     * @param compania
     *            the new compania
     */
    public void setCompania(String compania) {
        this.compania = compania;
    }

    /**
     * Gets the genero.
     *
     * @return the genero
     */
    public String getGenero() {
        return genero;
    }

    /**
     * Sets the genero.
     *
     * @param genero
     *            the new genero
     */
    public void setGenero(String genero) {
        this.genero = genero;
    }

    /**
     * Checks if is coop.
     *
     * @return true, if is coop
     */
    public boolean isCoop() {
        return coop;
    }

    /**
     * Sets the coop.
     *
     * @param coop
     *            the new coop
     */
    public void setCoop(boolean coop) {
        this.coop = coop;
    }

    /**
     * Gets the anio salida.
     *
     * @return the anio salida
     */
    public LocalDate getAnioSalida() {
        return anioSalida;
    }

    /**
     * Sets the anio salida.
     *
     * @param anioSalida
     *            the new anio salida
     */
    public void setAnioSalida(LocalDate anioSalida) {
        this.anioSalida = anioSalida;
    }

    /**
     * Gets the num post.
     *
     * @return the num post
     */
    public int getNumPost() {
        return numPost;
    }

    /**
     * Sets the num post.
     *
     * @param numPost
     *            the new num post
     */
    public void setNumPost(int numPost) {
        this.numPost = numPost;
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
        JuegoInfo other = (JuegoInfo) obj;
        return Objects.equals(id, other.id);
    }
}
