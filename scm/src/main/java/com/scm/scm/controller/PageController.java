package com.scm.scm.controller;

import com.scm.scm.entity.User;
import com.scm.scm.forms.UserForm;

import com.scm.scm.forms.UserForm;
import com.scm.scm.services.UserService;
import org.apache.logging.log4j.message.Message;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

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

    // processing register page
    @RequestMapping(value = "/do-register", method = RequestMethod.POST)
    public String processRegister(@Valid @ModelAttribute UserForm userForm, BindingResult rBindingResult,
                                  HttpSession session) {
        System.out.println("Processing registration");
        // fetch form data
        // UserForm
        System.out.println(userForm);

        // validate form data
        if (rBindingResult.hasErrors()) {
            return "register";
        }


        User user = new User();
        user.setName(userForm.getName());
        user.setEmail(userForm.getEmail());
        user.setPassword(userForm.getPassword());
        user.setAbout(userForm.getAbout());
        user.setPhoneNumber(userForm.getPhoneNumber());
        user.setEnabled(false);
        user.setProfilePic(
                "https://www.learncodewithdurgesh.com/_next/image?url=%2F_next%2Fstatic%2Fmedia%2Fdurgesh_sir.35c6cb78.webp&w=1920&q=75");

//        User savedUser = UserService.saveUser(user);

        System.out.println("user saved :");

        // message = "Registration Successful"

        // add the message:

//        Message message = Message.builder().content("Registration Successful").type(MessageType.green).build();

//        session.setAttribute("message", message);

        // redirectto login page
        return "redirect:/register";
    }
}
