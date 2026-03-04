package com.example.demo.repository;

import com.example.demo.model.Role;
import com.example.demo.model.User;
import org.springframework.stereotype.Component;

import java.util.*;

//should be interface, but without interface
@Component
public class UsersRepository {
    private final static List<User> USERS = new ArrayList<>(List.of(
            new User(UUID.randomUUID(), "admin@gmail.com", "Admin", "Adminov", "passwordadmin", new Role(UUID.randomUUID(), "ADMIN")),
            new User(UUID.randomUUID(), "reader@gmail.com", "Reader", "Readerov", "passwordreader", new Role(UUID.randomUUID(), "READER"))
    ));

    public Optional<User> findByEmail(String email) {
        return USERS.stream().filter(u-> Objects.equals(Optional.ofNullable(u.getEmail()).orElse(""), email)).findFirst();
    }
}
