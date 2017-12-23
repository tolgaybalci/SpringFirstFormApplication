package com.springformapllication.tolgay.balci.springformapplication.controller;

import com.springformapllication.tolgay.balci.springformapplication.domain.User;
import com.springformapllication.tolgay.balci.springformapplication.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("")
    public String getUserList(Model model){

        model.addAttribute("users", userRepository.findAll());
        return "user/userList";
    }

    @GetMapping("/new")
    public String getNewUser(Model model){

        model.addAttribute("user", new User());
        return "user/newUser";
    }

    @PostMapping("/new")
    public String postNewUser(@ModelAttribute User user){

        userRepository.save(user);
        return "redirect:/new/";
    }

}
