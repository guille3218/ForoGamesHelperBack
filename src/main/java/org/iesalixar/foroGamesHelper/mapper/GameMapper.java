package org.iesalixar.foroGamesHelper.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.iesalixar.foroGamesHelper.dto.ComentarioDTO;
import org.iesalixar.foroGamesHelper.dto.PostDTO;
import org.iesalixar.foroGamesHelper.dto.PostInfo;
import org.iesalixar.foroGamesHelper.model.Comentario;
import org.iesalixar.foroGamesHelper.model.Post;

public class GameMapper {

    public static List<PostInfo> mapToListPostInfo(List<Post> posts) {
        return posts.stream().map(GameMapper::mapToPostInfo).collect(Collectors.toList());
    }

    public static PostInfo mapToPostInfo(Post post) {
        String contenidoReducido = post.getContenido().length() >= 100
            ? post.getContenido().substring(0, 100).concat("...")
            : post.getContenido().concat("...");
        return new PostInfo(post.getId(), post.getTitulo(), contenidoReducido,
            post.getFechaCreacion().toString(), post.getUsuario().getNombre(), post.getJuego().getNombre(),
            post.getComentarios().size());
    }

    public static PostDTO mapToPostDTO(Post post) {
        
        List<ComentarioDTO> listComentarios = post.getComentarios().stream().map(GameMapper::mapToComentarioDTO).collect(Collectors.toList());
        
        return new PostDTO(post.getId(), post.getTitulo(), post.getContenido(), post.getFechaCreacion(),
            post.getUsuario().getUsuario(), post.getJuego().getId(), listComentarios);
    }

    public static ComentarioDTO mapToComentarioDTO(Comentario comentario) {
        return new ComentarioDTO(comentario.getId(), comentario.getComentario(),
            comentario.getUsuario().getUsuario(), comentario.getPost().getId(), comentario.getJuego().getId());
    }
}
