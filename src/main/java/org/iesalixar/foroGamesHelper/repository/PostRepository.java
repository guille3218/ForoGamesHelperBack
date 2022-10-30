package org.iesalixar.foroGamesHelper.repository;

import org.iesalixar.foroGamesHelper.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * The Interface PostRepository.
 */
@Repository
public interface PostRepository extends JpaRepository<Post, Long>{
	public Post findByTitulo(String title);
}
