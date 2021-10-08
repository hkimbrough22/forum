package com.hkimbrough22.forum.controllers;

import com.hkimbrough22.forum.models.ForumUser;
import com.hkimbrough22.forum.repositories.ForumUserRepository;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class AuthenticationController {

    @Autowired
    ForumUserRepository forumUserRepository;

    @GetMapping("/signup")
    public String showSignUp(){
        return "signup.html";
    }

    @GetMapping("/login")
    public String showLogin(){
        return "login.html";
    }

    @PostMapping("/signup")
    public RedirectView signUpUser(String username, String password){
        if(username == "" || password == "") {
            return new RedirectView("/signup");
        }
        String hashedPassword = BCrypt.hashpw(password, BCrypt.gensalt(12));
        ForumUser newUser = new ForumUser(username, hashedPassword);

        forumUserRepository.save(newUser);
        return new RedirectView("/login");
    }

    @PostMapping("/login")
    public RedirectView loginUser(String username, String password){
        ForumUser userFromDB = forumUserRepository.findByUsername(username);
        if(userFromDB.equals(null) || !BCrypt.checkpw(password, userFromDB.getPassword())){
            return new RedirectView("/signup");
        }
        return new RedirectView("/posts");
    }
}
