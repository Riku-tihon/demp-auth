package com.example.demo.controller;


import com.example.demo.converter.UserConverter;
import com.example.demo.dto.LoginUser;
import com.example.demo.dto.UserDTO;
import com.example.demo.service.UsersService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;


@RestController()
@AllArgsConstructor
public class AuthController {
    private final UsersService service;
    private final UserConverter converter;

    @PostMapping("/login")
    public UserDTO postLogin(@RequestBody @Valid LoginUser loginUser) {
        return converter.toDTO(service.login(loginUser.getEmail(),loginUser.getPassword()));
    }

    @GetMapping("/login")
    public UserDTO getLogin(@RequestParam("email") @Email String email, @RequestParam("password") @NotEmpty String password) {
        return converter.toDTO(service.login(email, password));
    }
}
