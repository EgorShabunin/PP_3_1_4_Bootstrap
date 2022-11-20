package ru.kata.spring.boot_security.demo.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kata.spring.boot_security.demo.entity.Role;
import ru.kata.spring.boot_security.demo.repository.RoleDAO;

import java.util.List;
import java.util.Set;

@Service
public class RoleServiceImp implements RoleService {
    private final RoleDAO roleDAO;

    public RoleServiceImp(RoleDAO roleDAO) {
        this.roleDAO = roleDAO;
    }

    @Override
    public List<Role> AllRoles() {
        return roleDAO.AllRoles();
    }

    @Override
    @Transactional
    public void addRole(Role role) {
        roleDAO.addRole(role);
    }

    @Override
    public Set<Role> getRole(String name) {
        return roleDAO.getRole(name);
    }
}
