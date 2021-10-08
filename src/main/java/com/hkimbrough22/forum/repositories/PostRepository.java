package com.hkimbrough22.forum.repositories;

import com.hkimbrough22.forum.models.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}
