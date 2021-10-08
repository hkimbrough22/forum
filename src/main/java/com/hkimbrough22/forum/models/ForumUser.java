package com.hkimbrough22.forum.models;

import javax.persistence.*;
import java.util.List;

@Entity
public class ForumUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    String username;
    String password;

    @OneToMany(mappedBy = "myUser")
    List<Post> myPosts;

    protected ForumUser(){}

    public ForumUser(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
