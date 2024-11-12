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
    private SystemUser owner; //foreign key to the user entity for OWNER

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

    public Accommodation(){};

    public Accommodation(SystemUser owner, String title, String description, String location, BigDecimal pricePerMonth, RoomType roomType, List<String> amenities, AvailabilityStatus availabilityStatus, List<Booking> bookings, List<Review> reviews) {
        this.owner = owner;
        this.title = title;
        this.description = description;
        this.location = location;
        this.pricePerMonth = pricePerMonth;
        this.roomType = roomType;
        this.amenities = amenities;
        this.availabilityStatus = availabilityStatus;
        this.bookings = bookings;
        this.reviews = reviews;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public @NotNull(message = "Accommodation must have an owner.") SystemUser getOwner() {
        return owner;
    }

    public void setOwner(@NotNull(message = "Accommodation must have an owner.") SystemUser owner) {
        this.owner = owner;
    }

    public @NotNull(message = "Accommodation must have a title.") @NotBlank(message = "Accommodation title cannot be empty.") String getTitle() {
        return title;
    }

    public void setTitle(@NotNull(message = "Accommodation must have a title.") @NotBlank(message = "Accommodation title cannot be empty.") String title) {
        this.title = title;
    }

    public @NotNull(message = "Accommodation must have a description.") @NotBlank(message = "Accommodation description cannot be empty.") String getDescription() {
        return description;
    }

    public void setDescription(@NotNull(message = "Accommodation must have a description.") @NotBlank(message = "Accommodation description cannot be empty.") String description) {
        this.description = description;
    }

    public @NotNull(message = "Accommodation must have a location.") @NotBlank(message = "Accommodation location cannot be empty.") String getLocation() {
        return location;
    }

    public void setLocation(@NotNull(message = "Accommodation must have a location.") @NotBlank(message = "Accommodation location cannot be empty.") String location) {
        this.location = location;
    }

    public @NotNull(message = "Accommodation must have a price per month") BigDecimal getPricePerMonth() {
        return pricePerMonth;
    }

    public void setPricePerMonth(@NotNull(message = "Accommodation must have a price per month") BigDecimal pricePerMonth) {
        this.pricePerMonth = pricePerMonth;
    }

    public @NotNull(message = "Type of room must be specified. Options include SINGLE, DOUBLE, SHARED, STUDIO AND APARTMENT") RoomType getRoomType() {
        return roomType;
    }

    public void setRoomType(@NotNull(message = "Type of room must be specified. Options include SINGLE, DOUBLE, SHARED, STUDIO AND APARTMENT") RoomType roomType) {
        this.roomType = roomType;
    }

    public List<String> getAmenities() {
        return amenities;
    }

    public void setAmenities(List<String> amenities) {
        this.amenities = amenities;
    }

    public @NotNull(message = "Accommodation must have an availability status of AVAILABLE OR BOOKED.") AvailabilityStatus getAvailabilityStatus() {
        return availabilityStatus;
    }

    public void setAvailabilityStatus(@NotNull(message = "Accommodation must have an availability status of AVAILABLE OR BOOKED.") AvailabilityStatus availabilityStatus) {
        this.availabilityStatus = availabilityStatus;
    }

    public List<Booking> getBookings() {
        return bookings;
    }

    public void setBookings(List<Booking> bookings) {
        this.bookings = bookings;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }
}
