package com.alex.studentAccommodation.entities;

import com.alex.studentAccommodation.constants.AvailabilityStatus;
import com.alex.studentAccommodation.constants.RoomType;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Entity
public class Accommodation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name= "owner_id", nullable = false)
    @NotNull(message = "Accommodation must have an owner.")
    @NotBlank(message = "Owner cannot be blank.")
    private SystemUser owner; //foreign key to the user entity for OWNER

    @NotNull(message = "Accommodation must have a title.")
    @NotBlank(message = "Accommodation title cannot be empty.")
    private String title;

    @Column(columnDefinition = "TEXT")
    @NotNull(message = "Accommodation must have a description.")
    @NotBlank(message = "Accommodation description cannot be empty.")
    private String description;

    @NotNull(message = "Accommodation must have a location.")
    @NotBlank(message = "Accommodation location cannot be empty.")
    private String location;

    @NotNull(message = "Accommodation must have a price per month")
    @NotBlank(message = "Accommodation price cannot be empty")
    private BigDecimal pricePerMonth;

    @Enumerated(EnumType.STRING)
    @NotNull(message = "Type of room must be specified. Options include SINGLE, DOUBLE, SHARED, STUDIO AND APARTMENT")
    private RoomType roomType;

    @ElementCollection
    private List<String> amenities;

    @Enumerated(EnumType.STRING)
    @NotNull(message="Accommodation must have an availability status of AVAILABLE OR BOOKED.")
    @NotBlank(message="Accommodation status cannot be blank.")
    private AvailabilityStatus availabilityStatus;

    @OneToMany(mappedBy = "accommodation", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Booking> bookings;

    @OneToMany(mappedBy = "accommodation", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Review> reviews;

}
