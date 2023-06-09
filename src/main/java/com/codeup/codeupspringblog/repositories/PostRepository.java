package com.codeup.codeupspringblog.repositories;

import com.codeup.codeupspringblog.controllers.models.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {
    Post findByTitle(String title);

    @Query("FROM Post p WHERE p.title LIKE %:term%")
    List<Post> searchByTitleLike(@Param("term") String term);
}
