package com.fundoonotes.dto.request;

import jakarta.validation.constraints.NotBlank;

public class LoginRequestDto {

    public String getEmail() { return email; }
    public String getPassword() { return password; }

    @NotBlank(message = "Email is required")
    private String email;

    @NotBlank(message = "Password is required")
    private String password;

    // getters and setters
}