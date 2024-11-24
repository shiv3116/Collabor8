package com.collabor8.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

public class UserDto {

    @NotBlank(message = "user_name is required")
    @Size(min = 3, max = 50, message = "user_name must be between 3 and 50 characters")
    @JsonProperty("user_name")
    private String user_name;

    @Getter
    @Setter
    @NotBlank(message = "Email is required")
    @Email(message = "Invalid email address")
    private String email;

    @Getter
    @Setter
    @NotBlank(message = "Password is required")
    @Size(min = 8, message = "Password must be at least 8 characters long")
    private String password;

    // Constructors
    public UserDto() {}

    public UserDto(String user_name, String email, String password) {
        this.user_name = user_name;
        this.email = email;
        this.password = password;
    }

    // Getters and Setters
    public String getUsername() {
        return user_name;
    }

    public void setUsername(String user_name) {
        this.user_name = user_name;
    }
}
