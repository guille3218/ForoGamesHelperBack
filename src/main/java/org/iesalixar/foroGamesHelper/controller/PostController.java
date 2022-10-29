package org.iesalixar.foroGamesHelper.controller;

import org.iesalixar.foroGamesHelper.dto.PostDTO;
import org.iesalixar.foroGamesHelper.dto.UsuarioDTO;
import org.iesalixar.foroGamesHelper.model.Post;
import org.iesalixar.foroGamesHelper.services.PostServiceImpl;
import org.iesalixar.foroGamesHelper.services.UsuarioServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
public class PostController {

	@Autowired
	PostServiceImpl postService;
	
	@Autowired
	UsuarioServiceImpl userService;
	
	@PostMapping("/addPost")
	public ResponseEntity<?> addPost(PostDTO post, UsuarioDTO usuario){
		Post postBD = new Post();
		
		postBD.setTitulo(post.getTitulo());
		postBD.setDescripcion(post.getDescripcion());
		postBD.setUsuario(userService.getUsuario(usuario.getUsuario()));
		
		return new ResponseEntity(postBD, HttpStatus.OK);
		
		
	}
}
