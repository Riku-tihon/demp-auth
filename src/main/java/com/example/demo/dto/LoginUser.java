package com.example.demo.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class LoginUser {
    @Email()
    private String email;
    @NotEmpty()
    private String password;
}
