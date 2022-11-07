package org.iesalixar.foroGamesHelper.mapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.iesalixar.foroGamesHelper.dto.ComentarioDTO;
import org.iesalixar.foroGamesHelper.dto.PostDTO;
import org.iesalixar.foroGamesHelper.model.Comentario;
import org.iesalixar.foroGamesHelper.model.Post;

public class GameMapper {
    
    public static List<PostDTO> mapToListPostDTO(List<Post> posts){
        List<PostDTO> listaReturn = new ArrayList<>();
        
        PostDTO postReturn = new PostDTO();
        for(Post post : posts) {
            postReturn.setComentarios(mapToListComentarioDTO(post.getComentarios()));
            
        }
        
        
        
        return null;
    }

    public static List<ComentarioDTO> mapToListComentarioDTO(Set<Comentario> comentarios) {
        List<Comentario> listaReturn = new ArrayList<>();
        
        for(Comentario comentario : comentarios) {
            ComentarioDTO comentarioReturn = new ComentarioDTO(comentario.getId(), );
            comentarioReturn.setComentario(comentario.getComentario());
            comentarioReturn.setId(comentario.getId());
            comentarioReturn.setJuego(null);
        }
        
        return null;
    }
}
