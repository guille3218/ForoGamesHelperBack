package org.iesalixar.foroGamesHelper.mapper;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.iesalixar.foroGamesHelper.dto.ComentarioDTO;
import org.iesalixar.foroGamesHelper.dto.JuegoDTO;
import org.iesalixar.foroGamesHelper.dto.JuegoInfo;
import org.iesalixar.foroGamesHelper.dto.PostDTO;
import org.iesalixar.foroGamesHelper.dto.PostInfo;
import org.iesalixar.foroGamesHelper.model.Comentario;
import org.iesalixar.foroGamesHelper.model.Juego;
import org.iesalixar.foroGamesHelper.model.Post;

/**
 * The Class GameMapper.
 */
public class GameMapper {

    /**
     * Map to list post info.
     *
     * @param posts
     *            the posts
     * @return the list
     */
    public static List<PostInfo> mapToListPostInfo(List<Post> posts) {
        return posts.stream().map(GameMapper::mapToPostInfo).collect(Collectors.toList());
    }

    /**
     * Map to post info.
     *
     * @param post
     *            the post
     * @return the post info
     */
    public static PostInfo mapToPostInfo(Post post) {
        String contenidoReducido = post.getContenido().length() >= 100
            ? post.getContenido().substring(0, 100).concat("...")
            : post.getContenido().concat("...");
        return new PostInfo(post.getId(), post.getTitulo(), contenidoReducido,
            post.getFechaCreacion().toString(), post.getUsuario().getNombre(), post.getJuego().getNombre(),
            post.getComentarios().size());
    }

    /**
     * Map to post DTO.
     *
     * @param post
     *            the post
     * @return the post DTO
     */
    public static PostDTO mapToPostDTO(Post post) {
        List<ComentarioDTO> listComentarios = post.getComentarios().stream().map(GameMapper::mapToComentarioDTO)
            .collect(Collectors.toList());
        return new PostDTO(post.getId(), post.getTitulo(), post.getContenido(), post.getFechaCreacion(),
            post.getUsuario().getUsuario(), post.getJuego().getId(), listComentarios);
    }

    /**
     * Map to comentario DTO.
     *
     * @param comentario
     *            the comentario
     * @return the comentario DTO
     */
    public static ComentarioDTO mapToComentarioDTO(Comentario comentario) {
        Post post = comentario.getPost();
        Long postId = post != null ? post.getId() : null;
        Juego juego = comentario.getJuego();
        Long juegoId = juego != null ? juego.getId() : null;
        return new ComentarioDTO(comentario.getId(), comentario.getComentario(),
            comentario.getUsuario().getUsuario(), postId, juegoId);
    }

    /**
     * Map to list comentario DTO.
     *
     * @param comentarios
     *            the comentarios
     * @return the list
     */
    public static List<ComentarioDTO> mapToListComentarioDTO(List<Comentario> comentarios) {
        return comentarios.stream().map(GameMapper::mapToComentarioDTO).collect(Collectors.toList());
    }

    /**
     * Map to juego info.
     *
     * @param juego
     *            the juego
     * @return the juego info
     */
    public static JuegoInfo mapToJuegoInfo(Juego juego) {
        return new JuegoInfo(juego.getId(), juego.getNombre(), juego.getCompania(), juego.getGenero(),
            juego.isCoop(), juego.getAnioSalida(), juego.getPosts().size(), juego.getComentarios().size());
    }

    /**
     * Map to list juego info.
     *
     * @param juegos
     *            the juegos
     * @return the list
     */
    public static List<JuegoInfo> mapToListJuegoInfo(List<Juego> juegos) {
        return juegos.stream().map(GameMapper::mapToJuegoInfo).collect(Collectors.toList());
    }

    /**
     * Map to juego DTO.
     *
     * @param juego
     *            the juego
     * @return the juego DTO
     */
    public static JuegoDTO mapToJuegoDTO(Juego juego) {
        return new JuegoDTO(juego.getId(), juego.getNombre(), juego.getCompania(), juego.getGenero(),
            juego.isCoop(), juego.getAnioSalida(), mapToListPostInfo(new ArrayList<>(juego.getPosts())),
            mapToListComentarioDTO(new ArrayList<>(juego.getComentarios())));
    }
}
