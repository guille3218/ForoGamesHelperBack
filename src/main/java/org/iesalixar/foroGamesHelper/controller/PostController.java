package org.iesalixar.foroGamesHelper.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.iesalixar.foroGamesHelper.constant.RolEnum;
import org.iesalixar.foroGamesHelper.dto.PostDTO;
import org.iesalixar.foroGamesHelper.dto.PostInfo;
import org.iesalixar.foroGamesHelper.mapper.GameMapper;
import org.iesalixar.foroGamesHelper.model.Juego;
import org.iesalixar.foroGamesHelper.model.Post;
import org.iesalixar.foroGamesHelper.model.Usuario;
import org.iesalixar.foroGamesHelper.services.implement.JuegoServiceImpl;
import org.iesalixar.foroGamesHelper.services.implement.PostServiceImpl;
import org.iesalixar.foroGamesHelper.services.implement.UsuarioServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * The Class PostController.
 */
@RestController
@CrossOrigin(origins = "*")
public class PostController {

    /** The post service. */
    @Autowired
    PostServiceImpl postService;

    /** The juego service. */
    @Autowired
    JuegoServiceImpl juegoService;

    /** The user service. */
    @Autowired
    UsuarioServiceImpl userService;

    /**
     * Adds the post.
     *
     * @param post
     *            the post
     * @param usuario
     *            the usuario
     * @param idJuego
     *            the id juego
     * @return the response entity
     */
    @PostMapping("/Post/add")
    public ResponseEntity<?> addPost(@RequestBody PostDTO post, @RequestParam String usuario,
        @RequestParam Long idJuego) {
        Post postBD = new Post();
        postBD.setTitulo(post.getTitulo());
        postBD.setContenido(post.getContenido());
        postBD.setFechaCreacion(LocalDate.now());
        Juego juego = juegoService.getJuego(idJuego);
        if (juego != null) {
            postBD.setJuego(juego);
            Usuario user = userService.getUsuario(usuario);
            if (user != null) {
                user.realizarPost(postBD);
                return new ResponseEntity<String>(
                    "No ha iniciado sesion. Inicia Sesion para hacer un post sobre el juego '"
                        + juego.getNombre() + "'",
                    HttpStatus.INTERNAL_SERVER_ERROR);
            }
            return new ResponseEntity<String>(
                "Se ha publicado correctamente el post sobre el juego '" + juego.getNombre() + "'",
                HttpStatus.OK);
        } else {
            return new ResponseEntity<String>("El juego seleccionado no está en nuestro sistema",
                HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Delete post.
     *
     * @param idPost
     *            the id post
     * @param usuario
     *            the usuario
     * @return the response entity
     */
    @SuppressWarnings("unused")
    @DeleteMapping("/Post/{idPost}")
    public ResponseEntity<?> deletePost(@PathVariable Long idPost, @RequestParam String usuario) {
        Post postBD = postService.getPost(idPost);
        String tituloPost = postBD.getTitulo();
        String nombreJuego = postBD.getJuego().getNombre();
        Usuario user = userService.getUsuario(usuario);
        if (postBD != null) {
            if (user.getUsuario().equals(postBD.getUsuario().getUsuario())
                || user.getRole() != RolEnum.USER.name()) {
                Usuario userRemovePost = postBD.getUsuario();
                userRemovePost.eliminarPost(postBD);
                userService.updateUsuario(userRemovePost);
                return new ResponseEntity<String>("Se ha eliminado correctamente el post '" + tituloPost
                    + "' sobre el juego '" + nombreJuego + "'", HttpStatus.OK);
            } else {
                return new ResponseEntity<String>(
                    "El usuario no tiene los permisos necesarios para eliminar el post",
                    HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } else {
            return new ResponseEntity<String>("El juego seleccionado no está en nuestro sistema",
                HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Update post.
     *
     * @param postModified
     *            the post modified
     * @param usuario
     *            the usuario
     * @return the response entity
     */
    @PatchMapping("/Post")
    public ResponseEntity<?> updatePost(@RequestBody PostDTO postModified, @RequestParam String usuario) {
        Post post = postService.getPost(postModified.getId());
        Usuario user = userService.getUsuario(usuario);
        if (user.getUsuario().equals(post.getUsuario().getUsuario())) {
            post.setTitulo(postModified.getTitulo());
            post.setContenido(postModified.getContenido());
            if (postService.updatePost(post)) {
                return new ResponseEntity<String>("Se ha actualizado correctamente el post", HttpStatus.OK);
            } else {
                return new ResponseEntity<String>("No se ha encontrado el post seleccionado",
                    HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } else {
            return new ResponseEntity<String>(
                "El usuario no tiene los permisos necesarios para modificar el post",
                HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Gets the all posts.
     *
     * @param idJuego
     *            the id juego
     * @return the all posts
     */
    @GetMapping("/AllPost")
    public ResponseEntity<?> getAllPosts(@RequestParam Long idJuego) {
        List<Post> listaPost = postService.getAllPosts();
        if (idJuego == null) {
            listaPost = listaPost.stream().sorted(Comparator.comparing(Post::getFechaCreacion))
                .collect(Collectors.toList());
        } else {
            Juego juego = juegoService.getJuego(idJuego);
            listaPost = new ArrayList<Post>(juego.getPosts());
        }
        return new ResponseEntity<List<PostInfo>>(GameMapper.mapToListPostInfo(listaPost), HttpStatus.OK);
    }

    /**
     * Gets the post.
     *
     * @param idPost
     *            the id post
     * @return the post
     */
    @GetMapping("/Post/{idPost}")
    public ResponseEntity<?> getPost(@PathVariable Long idPost) {
        if (idPost != null) {
            Post post = postService.getPost(idPost);
            return new ResponseEntity<PostInfo>(GameMapper.mapToPostInfo(post), HttpStatus.OK);
        } else {
            return new ResponseEntity<String>("El post seleccinado no se encuentra en el sistema",
                HttpStatus.OK);
        }
    }
}
