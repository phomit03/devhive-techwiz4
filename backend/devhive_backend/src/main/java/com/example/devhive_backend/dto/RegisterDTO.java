package com.example.devhive_backend.dto;

import lombok.Data;

@Data
public class RegisterDTO {
    private String username;
    private String email;
    private String password;
    private String address;
    private Integer status;
}

