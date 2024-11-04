package ru.lada.nauJava.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.lada.nauJava.objects.User;
import ru.lada.nauJava.services.UserServiceImpl;

import javax.swing.text.html.HTMLDocument;

@Controller
public class RegistrationController {
    @Autowired
    private UserServiceImpl users;

    @GetMapping("/registration")
    public String  registration(){
        return "registration";
    }

    @PostMapping("/registration")
    public String adduser(User user, Model model)
    {
        try
        {
            users.createUser(user);
            return "registration";
        }
        catch (Exception ex)
        {
            model.addAttribute("message", "User exists");
            return "registration";
        }
    }
}
