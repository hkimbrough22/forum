package com.hkimbrough22.forum.controllers;

import com.hkimbrough22.forum.models.Post;
import com.hkimbrough22.forum.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
public class PostController {

    @Autowired
    PostRepository postRepository;

    @GetMapping("/posts")
    public String showPosts(Model m){
        List<Post> allPosts = postRepository.findAll();
        m.addAttribute("allPosts", allPosts);

        return "posts.html";
    }

    @GetMapping("/add-post")
    public String addPostHome(){
        return "add-post.html";
    }

//    @PostMapping("/add-post")
//    public RedirectView addPost(){
//
//    }

}
