package com.alex.studentAccommodation.entities;

import com.alex.studentAccommodation.constants.BookingStatus;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.UUID;

@Entity
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "student_id",nullable = false)//foreign key to User entity for STUDENT
    private SystemUser student;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "accommodation_id", nullable = false)
    private Accommodation accommodation; // Foreign key to Accommodation entity

    @NotNull(message = "Booking must have a start date.")
    @Temporal(TemporalType.DATE)
    @NotBlank(message = "Booking start date cannot be empty.")
    private LocalDate startDate;

    @NotBlank(message = "Booking end data cannot be empty.")
    @NotNull(message = "Booking must have an end date")
    @Temporal(TemporalType.DATE)
    private LocalDate endDate;

    @Enumerated(EnumType.STRING)
    @NotNull(message = "Booking status is required. Choose one of the following: PENDING, CONFIRMED, REJECTED")
    @NotBlank(message = "Booking cannot be empty. Choose one of the following: PENDING, CONFIRMED, REJECTED.")
    private BookingStatus status;

    @CreationTimestamp
    private Timestamp createdAt;

    public Booking(){}
}
