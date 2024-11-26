package com.alex.studentAccommodation.dtos;

import com.alex.studentAccommodation.constants.Role;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class AddSystemUserRequestDto {
    @NotBlank(message = "Username cannot be empty.")
    String username;

    @NotBlank(message = "Password cannot be empty.")
    String password;

    @Email(message="Valid email address is required.")
    @NotBlank(message = "Email address cannot be empty.")
    String email;

    @Enumerated(EnumType.STRING)
    @NotNull(message="Role is required.")
    Role role;

    public AddSystemUserRequestDto(){};

    public AddSystemUserRequestDto(String username, String password, String email, Role role) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.role = role;
    }

    public @NotBlank(message = "Username cannot be empty.") String getUsername() {
        return username;
    }

    public void setUsername(@NotBlank(message = "Username cannot be empty.") String username) {
        this.username = username;
    }

    public @NotBlank(message = "Password cannot be empty.") String getPassword() {
        return password;
    }

    public void setPassword(@NotBlank(message = "Password cannot be empty.") String password) {
        this.password = password;
    }

    public @Email(message = "Valid email address is required.") @NotBlank(message = "Email address cannot be empty.") String getEmail() {
        return email;
    }

    public void setEmail(@Email(message = "Valid email address is required.") @NotBlank(message = "Email address cannot be empty.") String email) {
        this.email = email;
    }

    public @NotNull(message = "Role is required.") Role getRole() {
        return role;
    }

    public void setRole(@NotNull(message = "Role is required.") Role role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "AddSystemUserRequestDto{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}
