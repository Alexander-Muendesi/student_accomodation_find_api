package com.alex.studentAccomodation.entity;

import com.alex.studentAccomodation.constants.AvailabilityStatus;
import com.alex.studentAccomodation.constants.RoomType;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Entity
public class Accomodation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name= "owner_id", nullable = false)
    private User owner; //foreign key to the user entity for OWNER

    private String title;

    @Column(columnDefinition = "TEXT")
    private String description;

    private String location;

    private BigDecimal pricePerMonth;

    @Enumerated(EnumType.STRING)
    private RoomType roomType;

    @ElementCollection
    private List<String> amenities;

    @Enumerated(EnumType.STRING)
    private AvailabilityStatus availabilityStatus;

    @OneToMany(mappedBy = "accommodation", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Booking> bookings;

    @OneToMany(mappedBy = "accommodation", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Review> reviews;

}
