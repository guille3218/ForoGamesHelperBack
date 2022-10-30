package org.iesalixar.foroGamesHelper.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.iesalixar.foroGamesHelper.model.Comentario;
import org.iesalixar.foroGamesHelper.model.Post;

/**
 * The Class UsuarioDTO.
 */
public class UsuarioDTO implements Serializable {

    /** serial. */
    private static final long serialVersionUID = 1L;

    /** The id. */
    private Long id;

    /** The usuario. */
    private String usuario;

    /** The password. */
    private String password;

    /** The email. */
    private String email;

    /** The nombre. */
    private String nombre;

    /** The apellidos. */
    private String apellidos;

    /** The role. */
    private String role;

    /** The activo. */
    private boolean activo;

    /** The fecha registro. */
    private LocalDate fechaRegistro;

    /** The posts. */
    private List<Post> posts;

    /** The comentarios. */
    private List<Comentario> comentarios;

    /**
     * Instantiates a new usuario DTO.
     */
    public UsuarioDTO() {
    }

    /**
     * Instantiates a new usuario DTO.
     *
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
     */
    public UsuarioDTO(
        String usuario,
        String password,
        String email,
        String nombre,
        String apellidos,
        String role,
        boolean activo,
        LocalDate fechaRegistro) {
        this.usuario = usuario;
        this.password = password;
        this.email = email;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.role = role;
        this.activo = activo;
        this.fechaRegistro = fechaRegistro;
        this.posts = new ArrayList<>();
        this.comentarios = new ArrayList<>();
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
     * Gets the fecha registro.
     *
     * @return the fecha registro
     */
    public LocalDate getFechaRegistro() {
        return fechaRegistro;
    }

    /**
     * Sets the fecha registro.
     *
     * @param fechaRegistro
     *            the new fecha registro
     */
    public void setFechaRegistro(LocalDate fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    /**
     * Gets the posts.
     *
     * @return the posts
     */
    public List<Post> getPosts() {
        return posts;
    }

    /**
     * Sets the posts.
     *
     * @param posts
     *            the new posts
     */
    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    /**
     * Gets the comentarios.
     *
     * @return the comentarios
     */
    public List<Comentario> getComentarios() {
        return comentarios;
    }

    /**
     * Sets the comentarios.
     *
     * @param comentarios
     *            the new comentarios
     */
    public void setComentarios(List<Comentario> comentarios) {
        this.comentarios = comentarios;
    }
}
