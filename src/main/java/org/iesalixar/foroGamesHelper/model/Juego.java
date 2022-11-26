package org.iesalixar.foroGamesHelper.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

/**
 * The Class Juego.
 */
@Entity
@Table(name = "juegos")
public class Juego implements Serializable {

    /** serial. */
    private static final long serialVersionUID = 1L;

    /** The id. */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /** The nombre. */
    @Column(nullable = false, unique = true)
    private String nombre;

    /** The compania. */
    @Column(nullable = false)
    private String compania;

    /** The genero. */
    @Column(nullable = false)
    private String genero;

    /** The coop. */
    @Column(nullable = false)
    private boolean coop;

    /** The coop. */
    @Column(nullable = false, name = "anio_salida")
    @CreationTimestamp
    private LocalDate anioSalida;

    /** The posts. */
    @OneToMany(mappedBy = "juego", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Post> posts = new LinkedHashSet<>();

    /** The comentarios. */
    @OneToMany(mappedBy = "juego", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Comentario> comentarios;

    /**
     * Instantiates a new juego.
     */
    public Juego() {
    }

    /**
     * Instantiates a new juego.
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
     * @param posts
     *            the posts
     * @param comentarios
     *            the comentarios
     */
    public Juego(
        Long id,
        String nombre,
        String compania,
        String genero,
        boolean coop,
        LocalDate anioSalida,
        Set<Post> posts,
        Set<Comentario> comentarios) {
        super();
        this.id = id;
        this.nombre = nombre;
        this.compania = compania;
        this.genero = genero;
        this.coop = coop;
        this.anioSalida = anioSalida;
        this.posts = posts;
        this.comentarios = comentarios;
    }
    
    /**
     * Instantiates a new juego.
     *
     * @param nombre the nombre
     * @param compania the compania
     * @param genero the genero
     * @param coop the coop
     * @param anioSalida the anio salida
     */
    public Juego(
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
    // HELPERS

    /**
     * Hacer comentario.
     *
     * @param comentario
     *            the comentario
     */
    public void hacerComentario(Comentario comentario) {
        // El usuario tiene que estar en el comentario
        this.comentarios.add(comentario);
        comentario.setJuego(this);
    }

    /**
     * Eliminar comentario.
     *
     * @param comentario
     *            the comentario
     */
    public void eliminarComentario(Comentario comentario) {
        this.comentarios.remove(comentario);
        comentario.setJuego(null);
    }

    /**
     * Hacer post.
     *
     * @param post
     *            the post
     */
    public void hacerPost(Post post) {
        this.posts.add(post);
        post.setJuego(this);
    }

    /**
     * Eliminar post.
     *
     * @param post
     *            the post
     */
    public void eliminarPost(Post post) {
        this.posts.remove(post);
        post.setJuego(null);
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
     * Gets the posts.
     *
     * @return the posts
     */
    public Set<Post> getPosts() {
        return posts;
    }

    /**
     * Sets the posts.
     *
     * @param posts
     *            the new posts
     */
    public void setPosts(Set<Post> posts) {
        this.posts = posts;
    }

    /**
     * Gets the comentarios.
     *
     * @return the comentarios
     */
    public Set<Comentario> getComentarios() {
        return comentarios;
    }

    /**
     * Sets the comentarios.
     *
     * @param comentarios
     *            the new comentarios
     */
    public void setComentarios(Set<Comentario> comentarios) {
        this.comentarios = comentarios;
    }
}
