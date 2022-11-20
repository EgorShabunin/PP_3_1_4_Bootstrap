package ru.kata.spring.boot_security.demo.repository;

import org.springframework.stereotype.Repository;
import ru.kata.spring.boot_security.demo.entity.Role;

import java.util.List;
import java.util.Set;

@Repository
public interface RoleDAO {
    List<Role> AllRoles();
    void addRole(Role role);
    Set<Role> getRole(String name);
}
