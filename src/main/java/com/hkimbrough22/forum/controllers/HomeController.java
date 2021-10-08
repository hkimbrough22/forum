package com.hkimbrough22.forum.controllers;

import com.hkimbrough22.forum.models.Post;
import com.hkimbrough22.forum.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    PostRepository postRepository;

    @GetMapping("/")
    public String showHomepage(){
        return "index.html";
    }
}
