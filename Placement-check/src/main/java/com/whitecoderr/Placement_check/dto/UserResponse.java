package com.whitecoderr.Placement_check.dto;

public class UserResponse {
    private Long userId;
    private String username;
    private String userMail;
    private String role;

    public UserResponse() {}

    public UserResponse(Long userId, String username, String userMail, String role) {
        this.userId = userId;
        this.username = username;
        this.userMail = userMail;
        this.role = role;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserMail() {
        return userMail;
    }

    public void setUserMail(String userMail) {
        this.userMail = userMail;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
