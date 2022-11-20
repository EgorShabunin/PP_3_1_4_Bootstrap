package ru.kata.spring.boot_security.demo.util;

import org.springframework.stereotype.Component;
import ru.kata.spring.boot_security.demo.entity.Role;
import ru.kata.spring.boot_security.demo.entity.User;
import ru.kata.spring.boot_security.demo.service.RoleService;
import ru.kata.spring.boot_security.demo.service.UserService;

import javax.annotation.PostConstruct;
import java.util.HashSet;
import java.util.Set;

@Component
public class Init {
    private UserService userService;
    private RoleService roleService;

    public Init(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @PostConstruct
    private void initUser() {
        Role roleAdmin = new Role("ROLE_ADMIN");
        Role roleUser = new Role("ROLE_USER");
        roleService.addRole(roleAdmin);
        roleService.addRole(roleUser);

        Set<Role> adminSet = new HashSet<>();
        Set<Role> userSet = new HashSet<>();
        adminSet.add(roleAdmin);
        userSet.add(roleUser);

        User admin = new User("admin", "admin", "Sergey", "Sergeev", "admin@mail.ru", (byte) 25,  adminSet);
        User user = new User("user", "user", "Ivan", "Ivanov","user@mail.ru", (byte) 22, userSet);

        userService.add(admin);
        userService.add(user);
    }
}
