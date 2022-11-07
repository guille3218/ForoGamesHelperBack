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
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

/**
 * The Class Usuario.
 */
@Entity
@Table(name = "usuarios")
public class Usuario implements Serializable {

    /** serial. */
    private static final long serialVersionUID = 1L;

    /** The id. */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /** The user name. */
    @Column(name = "usuario", unique = true, nullable = false)
    private String usuario;

    /** The password. */
    @Column(nullable = false)
    private String password;

    /** The email. */
    @Column(unique = true, nullable = false)
    private String email;

    /** The nombre. */
    @Column(nullable = false)
    private String nombre;

    /** The apellidos. */
    @Column(nullable = false)
    private String apellidos;

    /** The role. */
    @Column(nullable = false)
    private String role;

    /** The activo. */
    @Column(nullable = false, columnDefinition = "BOOLEAN default true")
    private boolean activo;

    /** The fecha registro. */
    @Column(nullable = false, name = "fecha_registro")
    @CreationTimestamp
    private LocalDate fechaRegistro;

    /** The posts. */
    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Post> posts;

    /** The comentarios. */
    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Comentario> comentarios;

    /**
     * Instantiates a new usuario.
     */
    public Usuario() {
    }

    /**
     * Instantiates a new usuario.
     *
     * @param id
     *            the id
     * @param usuario
     *            the usuario
     * @param password
     *            the password
     * @param email
     *            the email
     * @param nombre
     *            the nombre
     * @param apellidos
     *            the apellidos
     * @param role
     *            the role
     * @param activo
     *            the activo
     * @param fechaRegistro
     *            the fecha registro
     * @param posts
     *            the posts
     * @param comentarios
     *            the comentarios
     */
    public Usuario(
        Long id,
        String usuario,
        String password,
        String email,
        String nombre,
        String apellidos,
        String role,
        boolean activo,
        LocalDate fechaRegistro,
        Set<Post> posts,
        Set<Comentario> comentarios) {
        this.id = id;
        this.usuario = usuario;
        this.password = password;
        this.email = email;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.role = role;
        this.activo = activo;
        this.fechaRegistro = fechaRegistro;
        this.posts = posts;
        this.comentarios = comentarios;
    }

    // HELPERS
    /**
     * Adds the post.
     *
     * @param post
     *            the post
     */
    public void realizarPost(Post post) {
        this.posts.add(post);
        post.setUsuario(this);
    }

    /**
     * Eliminar post.
     *
     * @param post
     *            the post
     */
    public void eliminarPost(Post post) {
        this.posts.remove(post);
        post.setUsuario(null);
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
     * Gets the password.
     *
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the password.
     *
     * @param password
     *            the new password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Gets the email.
     *
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the email.
     *
     * @param email
     *            the new email
     */
    public void setEmail(String email) {
        this.email = email;
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
     * Gets the apellidos.
     *
     * @return the apellidos
     */
    public String getApellidos() {
        return apellidos;
    }

    /**
     * Sets the apellidos.
     *
     * @param apellidos
     *            the new apellidos
     */
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    /**
     * Gets the role.
     *
     * @return the role
     */
    public String getRole() {
        return role;
    }

    /**
     * Sets the role.
     *
     * @param role
     *            the new role
     */
    public void setRole(String role) {
        this.role = role;
    }

    /**
     * Checks if is activo.
     *
     * @return true, if is activo
     */
    public boolean isActivo() {
        return activo;
    }

    /**
     * Sets the activo.
     *
     * @param activo
     *            the new activo
     */
    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    /**
     * Gets the posts.
     *
     * @return the posts
     */
    public Set<Post> getPosts() {
        return posts;
    }
}
