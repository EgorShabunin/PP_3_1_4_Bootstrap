package ru.kata.spring.boot_security.demo.repository;

import org.springframework.stereotype.Repository;
import ru.kata.spring.boot_security.demo.entity.User;

import java.util.List;


@Repository
public interface UserDAO {
    User findByUsername(String username);
    List<User> allUsers();
    void add(User user);
    void delete(Long id);
    void edit(User user);
    User getById(Long id);
}
