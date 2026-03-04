package com.example.demo.model;

import lombok.*;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class User {
    private UUID id;
    private String email;
    private String firstname;
    private String lastname;
    private String password;

    //@ManyToOne
    private Role role;
}
