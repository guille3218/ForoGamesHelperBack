package org.iesalixar.foroGamesHelper.dto;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * The Class JuegoDTO.
 */
public class JuegoDTO implements Serializable {

    /** serial. */
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

    /**
     * Instantiates a new juego DTO.
     */
    public JuegoDTO() {
    }

    /**
     * Instantiates a new juego DTO.
     *
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
}
