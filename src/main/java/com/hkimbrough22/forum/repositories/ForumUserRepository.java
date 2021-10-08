package com.hkimbrough22.forum.repositories;

import com.hkimbrough22.forum.models.ForumUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ForumUserRepository extends JpaRepository<ForumUser, Long> {
    ForumUser findByUsername(String username);
}
