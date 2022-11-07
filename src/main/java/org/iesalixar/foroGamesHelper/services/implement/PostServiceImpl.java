package org.iesalixar.foroGamesHelper.services.implement;

import java.util.List;
import java.util.Optional;

import org.iesalixar.foroGamesHelper.model.Post;
import org.iesalixar.foroGamesHelper.repository.PostRepository;
import org.iesalixar.foroGamesHelper.services.PostService;
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

    @Override
    public Post getPost(Long idPost) {
        Optional<Post> post = postRepo.findById(idPost);
        if(post.isPresent()) {
            return post.get();
        }else {
            return null;
        }
    }

    @Override
    public boolean updatePost(Post post) {
        if(post.getId() != null) {
            postRepo.save(post);
            return true;
        }
        return false;
    }
	
	

}
