package org.iesalixar.foroGamesHelper.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

/**
 * The Class Post.
 */
@Entity
@Table(name = "posts")
public class Post implements Serializable {

    /** serial. */
    private static final long serialVersionUID = 1L;

    /** The id. */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /** The titulo. */
    @Column(nullable = false)
    private String titulo;

    /** The contenido. */
    @Column(nullable = false, columnDefinition = "TEXT")
    private String contenido;

    /** The fecha creacion. */
    @Column(nullable = false, name = "fecha_creacion")
    @CreationTimestamp
    private LocalDate fechaCreacion;

    /** The usuario. */
    @ManyToOne
    @JoinColumn(name = "usuarios_id")
    private Usuario usuario;

    /** The juego. */
    @ManyToOne
    @JoinColumn(name = "juegos_id", nullable = false)
    private Juego juego;

    /** The comentarios. */
    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Comentario> comentarios;

    /**
     * Instantiates a new post.
     */
    public Post() {
    }

    /**
     * Instantiates a new post.
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
     * @param comentarios
     *            the comentarios
     */
    public Post(
        Long id,
        String titulo,
        String contenido,
        LocalDate fechaCreacion,
        Usuario usuario,
        Juego juego,
        Set<Comentario> comentarios) {
        this.id = id;
        this.titulo = titulo;
        this.contenido = contenido;
        this.fechaCreacion = fechaCreacion;
        this.usuario = usuario;
        this.juego = juego;
        this.comentarios = comentarios;
    }
    // HELPERS

    /**
     * Hacer comentario.
     *
     * @param comentario
     *            the comentario
     */
    public void hacerComentario(Comentario comentario) {
        // El usuario tiene que estar en comentario
        this.comentarios.add(comentario);
        comentario.setPost(this);
    }

    /**
     * Eliminar comentario.
     *
     * @param comentario
     *            the comentario
     */
    public void eliminarComentario(Comentario comentario) {
        this.comentarios.remove(comentario);
        comentario.setPost(null);
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
    public Usuario getUsuario() {
        return usuario;
    }

    /**
     * Sets the usuario.
     *
     * @param usuario
     *            the new usuario
     */
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
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
     * @param juego
     *            the new juego
     */
    public void setJuego(Juego juego) {
        this.juego = juego;
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
