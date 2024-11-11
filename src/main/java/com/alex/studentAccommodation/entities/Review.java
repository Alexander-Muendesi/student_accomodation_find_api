package com.alex.studentAccommodation.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;
import java.util.UUID;

@Entity
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id; //foreign key to User entity for STUDENT

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "student_id", nullable = false)
    private Accommodation accommodation; // foreign key to Accommodation entity

    @NotNull(message = "Value for rating is required.")
    @NotBlank(message = "Value for rating is required.")
    @Min(value = 0, message = "Rating must be at least 0.")
    @Max(value = 5, message = "Rating must be at most 10")
    private int rating;

    @Column(columnDefinition = "TEXT")
    @NotBlank(message = "A review requires a description.")
    @NotNull(message = "A review requires a description.")
    private String description;

    @CreationTimestamp
    private Timestamp createdAt;
}
