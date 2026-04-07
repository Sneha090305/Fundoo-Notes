package com.fundoonotes.dto.response;

public class LoginResponseDto {

    private String token;
    private String message;

    public LoginResponseDto(String token, String message) {
        this.token = token;
        this.message = message;
    }

    // GETTERS (IMPORTANT)
    public String getToken() {
        return token;
    }

    public String getMessage() {
        return message;
    }

    // SETTERS (optional but good)
    public void setToken(String token) {
        this.token = token;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}