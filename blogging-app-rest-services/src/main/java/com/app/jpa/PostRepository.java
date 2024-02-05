package com.app.jpa;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import com.app.entity.PostEntity;

public interface PostRepository extends JpaRepository<PostEntity, Long>{

	Page<PostEntity> findAllByOrderByDateDescTimeDesc(Pageable pageable);

}



//@Query("SELECT p FROM PostEntity p")
//List<PostEntity> findAllPosts();

//@Query("SELECT new com.example.Post(p) FROM PostEntity p")
//List<PostEntity> findAllPost();

// @Query("SELECT new com.app.model.Post(p.id, p.title, p.description, p.paragraph, p.imageUrl, p.date, p.time, new com.app.model.Author(u.name, u.id, u.userProfileImageUrl)) FROM PostEntity p JOIN p.userDetails u")
// List<Post> findAllPost();