package com.example.demo.service;

import com.example.demo.exception.BadRequestException;
import com.example.demo.exception.UnauthorizedException;
import com.example.demo.model.User;
import com.example.demo.repository.UsersRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@AllArgsConstructor
public class UsersService {
    private final UsersRepository repository;

    public User login(String email, String password) {
        return repository.findByEmail(email).filter(u-> Objects.equals(u.getPassword(), password))
                .orElseThrow(UnauthorizedException::new);

    }

}
