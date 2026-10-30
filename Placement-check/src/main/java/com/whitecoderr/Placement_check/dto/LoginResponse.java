package com.whitecoderr.Placement_check.dto;

public class LoginResponse {
    private String token;
    private String role;
    private String username;
    private Long userId;
    private String userMail;

    public LoginResponse() {
    }

    public LoginResponse(String token, String role, String username, Long userId, String userMail) {
        this.token = token;
        this.role = role;
        this.username = username;
        this.userId = userId;
        this.userMail = userMail;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserMail() {
        return userMail;
    }

    public void setUserMail(String userMail) {
        this.userMail = userMail;
    }
}
