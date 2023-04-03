package com.codeup.codeupspringblog.repositories;

import com.codeup.codeupspringblog.controllers.models.Post;
import com.codeup.codeupspringblog.controllers.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);

    @Query("FROM User p WHERE p.username LIKE %:term%")
    List<User> searchByUsernameLike(@Param("term") String term);
}
