package com.alex.studentAccommodation.dtos;

import com.alex.studentAccommodation.constants.AvailabilityStatus;
import com.alex.studentAccommodation.constants.RoomType;
import com.alex.studentAccommodation.entities.Booking;
import com.alex.studentAccommodation.entities.Review;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

public class AccommodationResponseDto {
    private UUID id;
    private UUID ownerId;
    private String title;
    private String description;
    private String location;
    private BigDecimal pricePerMonth;
    private RoomType roomType;
    private List<String> amenities;
    private AvailabilityStatus availabilityStatus;
    private List<Booking> bookings;
    private List<Review> reviews;

    public AccommodationResponseDto(){}

    public AccommodationResponseDto(UUID id, UUID ownerId, String title, String description, String location, BigDecimal pricePerMonth, RoomType roomType, List<String> amenities, AvailabilityStatus availabilityStatus, List<Booking> bookings, List<Review> reviews) {
        this.id = id;
        this.ownerId = ownerId;
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

    public UUID getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(UUID ownerId) {
        this.ownerId = ownerId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public BigDecimal getPricePerMonth() {
        return pricePerMonth;
    }

    public void setPricePerMonth(BigDecimal pricePerMonth) {
        this.pricePerMonth = pricePerMonth;
    }

    public RoomType getRoomType() {
        return roomType;
    }

    public void setRoomType(RoomType roomType) {
        this.roomType = roomType;
    }

    public List<String> getAmenities() {
        return amenities;
    }

    public void setAmenities(List<String> amenities) {
        this.amenities = amenities;
    }

    public AvailabilityStatus getAvailabilityStatus() {
        return availabilityStatus;
    }

    public void setAvailabilityStatus(AvailabilityStatus availabilityStatus) {
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
