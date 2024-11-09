package com.alex.studentAccommodation.entities;

import com.alex.studentAccommodation.constants.Role;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.sql.Timestamp;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

@Entity
public class SystemUser implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(unique = true, nullable = false)
    @NotNull(message = "Username is required.")
    @NotBlank(message = "Non blank username is required.")
    private String username;

    @Column(nullable = false)
    @NotNull(message = "Password is required.")
    @NotBlank(message = "Non blank password is required.")
    private String password;

    @Column(unique = true, nullable = false)
    @Email(message="Valid email address is required.")
    @NotNull(message="Email is required.")
    @NotBlank(message="Non blank email is required.")
    private String email;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    @NotNull(message="Role is required.")
    private Role role; // Enum for STUDENT or Owner

    @CreationTimestamp
    private Timestamp createdAt;

    @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Accommodation> accommodations;

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Booking> bookings;

    public SystemUser(){}

    public SystemUser(String username, String password, String email, Role role, Timestamp createdAt, List<Accommodation> accommodations, List<Booking> bookings) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.role = role;
        this.createdAt = createdAt;
        this.accommodations = accommodations;
        this.bookings = bookings;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities(){
        return Collections.singletonList(new SimpleGrantedAuthority("ROLE_" + this.role.name()));
    }

    @Override
    public boolean isAccountNonExpired(){
        return true; // TODO: determine how to customize this based on account expiration logic
    }

    @Override
    public boolean isAccountNonLocked(){
        return true; // TODO: Customize based on credential expiration logic.
    }

    @Override
    public boolean isEnabled(){
        return true; // Customize based on account enable/disable logic.
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public List<Accommodation> getAccomodations() {
        return accommodations;
    }

    public void setAccomodations(List<Accommodation> accommodations) {
        this.accommodations = accommodations;
    }

    public List<Booking> getBookings() {
        return bookings;
    }

    public void setBookings(List<Booking> bookings) {
        this.bookings = bookings;
    }

    @Override
    public String toString() {
        return "SystemUser{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", role=" + role +
                ", createdAt=" + createdAt +
                ", accomodations=" + accommodations +
                ", bookings=" + bookings +
                '}';
    }
}
