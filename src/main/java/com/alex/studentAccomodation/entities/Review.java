package com.alex.studentAccomodation.entities;

import jakarta.persistence.*;
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
    private Accomodation accommodation; // foreign key to Accommodation entity

    private int rating;

    @Column(columnDefinition = "TEXT")
    private String description;

    @CreationTimestamp
    private Timestamp createdAt;
}
