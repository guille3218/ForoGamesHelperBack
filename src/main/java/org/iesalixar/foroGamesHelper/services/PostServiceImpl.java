package org.iesalixar.foroGamesHelper.services;

import java.util.List;

import org.iesalixar.foroGamesHelper.model.Post;
import org.iesalixar.foroGamesHelper.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostServiceImpl implements PostService {

	@Autowired
	PostRepository postRepo;

	@Override
	public Post addPost(Post post) {
		if (post != null) {
			return postRepo.save(post);
		}
		return null;
	}

	@Override
	public Post getPostByTitle(String title) {
		if(title != null) {
			return postRepo.findByTitulo(title);
		}
		return null;
	}

	@Override
	public List<Post> getAllPosts() {
		return postRepo.findAll();
	}

}
