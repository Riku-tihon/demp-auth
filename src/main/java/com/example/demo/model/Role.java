package com.example.demo.model;

import lombok.*;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Role {
    private UUID id;
    private String name;

}
