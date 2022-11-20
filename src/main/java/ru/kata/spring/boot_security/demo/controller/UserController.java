package ru.kata.spring.boot_security.demo.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.kata.spring.boot_security.demo.entity.User;
import ru.kata.spring.boot_security.demo.repository.UserDAO;
import ru.kata.spring.boot_security.demo.service.UserServiceImp;


@Controller
@RequestMapping("/user")
public class UserController {
    private final UserServiceImp userService;
    private final UserDAO userDAO;

    public UserController(UserServiceImp userService, UserDAO userDAO) {
        this.userService = userService;
        this.userDAO = userDAO;
    }

    @GetMapping()
    public String getProfile(@AuthenticationPrincipal User users, Model model) {
        User user = userService.findByUsername(users.getEmail());
        model.addAttribute("user", user);
        return "user";
    }
}
