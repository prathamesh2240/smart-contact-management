package com.scm.scm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PageController {
    // home page
    @RequestMapping("/home")
    public String home(Model model) {
        System.out.println("home controller called");
        model.addAttribute("name", "Substring Technologies");
        return "home";
    }
    // About page
    @RequestMapping("/about")
    public String about() {
        System.out.println("about controller called");
        return "about";
    }

    // services page
    @RequestMapping("/services")   
    public String services() {
        System.out.println("services controller called");
        return "services";
    }

    // contact page
    @GetMapping("/contact")
    public String contact() {
        System.out.println("contact controller called");
        return new String("contact");
    }

    // login page
    @GetMapping("/login")
    public String login() {
        System.out.println("login controller called");
        return new String("login");
    }

    // register page
    @GetMapping("/register")
    public String register() {
        System.out.println("register controller called");
        return "register";
    }

}
