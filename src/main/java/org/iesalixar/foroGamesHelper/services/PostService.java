package org.iesalixar.foroGamesHelper.services;

import java.util.List;

import org.iesalixar.foroGamesHelper.model.Post;

public interface PostService {
	public Post addPost(Post post);
	public Post getPostByTitle(String title);
	public List<Post> getAllPosts();
}
