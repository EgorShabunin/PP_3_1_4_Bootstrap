package ru.kata.spring.boot_security.demo.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.kata.spring.boot_security.demo.entity.User;
import ru.kata.spring.boot_security.demo.service.RoleService;
import ru.kata.spring.boot_security.demo.service.UserService;


@Controller
@RequestMapping("/admin")
public class AdminController {
    private final UserService userService;
    private final RoleService roleService;

    @Autowired()
    public AdminController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @GetMapping()
    public String allUsers(@AuthenticationPrincipal User users, Model model) {
        model.addAttribute("userList", userService.allUsers());
        model.addAttribute("roleList", roleService.AllRoles());
        model.addAttribute("user_head", userService.findByUsername(users.getEmail()));

        return "users";
    }

    @PatchMapping("/{id}/edit")
    public String editUser(@PathVariable(value = "id", required = false) Long id, @ModelAttribute("user") User user,
                           @RequestParam(value = "roles", required = false) String role) {
        user.setRoles(roleService.getRole(role));
        userService.edit(user);
        return "redirect:/admin";
    }


    @GetMapping("/add")
    public String addPage(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("roleAdd", roleService.AllRoles());
        return "users";
    }

    @PostMapping("/add")
    public String addUser(@ModelAttribute("user") User user,
                          @RequestParam(value = "roles", required = false) String role) {
        user.setRoles(roleService.getRole(role));
        userService.add(user);
        return "redirect:/admin";
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable("id") Long id) {
        userService.delete(id);
        return "redirect:/admin";
    }
}










