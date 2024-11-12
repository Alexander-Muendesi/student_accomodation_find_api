package com.alex.studentAccommodation.dtos;

import com.alex.studentAccommodation.constants.AvailabilityStatus;
import com.alex.studentAccommodation.constants.RoomType;
import com.alex.studentAccommodation.entities.Booking;
import com.alex.studentAccommodation.entities.Review;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.util.List;

public class AccommodationRequestDto {
    @NotBlank(message = "Owner Id is required.")
    private String owner_id;

    @NotBlank(message = "Title is required.")
    private String title;

    @NotBlank(message = "Description is required.")
    private String description;

    @NotBlank(message = "Location is required.")
    private String location;

    @NotNull(message = "Price per month is required.")
    private BigDecimal pricePerMonth;

    @NotNull(message = "Room Type is required.")
    private RoomType roomType;

    @NotNull(message = "List of amenities is required.")
    private List<String> amenities;

    @NotNull(message = "Availability status is required.")
    private AvailabilityStatus availabilityStatus;

    private List<Booking> bookings;
    private List<Review> reviews;

    public AccommodationRequestDto(String owner_id, String title, String description, String location, BigDecimal pricePerMonth, RoomType roomType, List<String> amenities, AvailabilityStatus availabilityStatus, List<Booking> bookings, List<Review> reviews) {
        this.owner_id = owner_id;
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

    public @NotBlank(message = "Owner Id is required.") String getOwner_id() {
        return owner_id;
    }

    public void setOwner_id(@NotBlank(message = "Owner Id is required.") String owner_id) {
        this.owner_id = owner_id;
    }

    public @NotBlank(message = "Title is required.") String getTitle() {
        return title;
    }

    public void setTitle(@NotBlank(message = "Title is required.") String title) {
        this.title = title;
    }

    public @NotBlank(message = "Description is required.") String getDescription() {
        return description;
    }

    public void setDescription(@NotBlank(message = "Description is required.") String description) {
        this.description = description;
    }

    public @NotBlank(message = "Location is required.") String getLocation() {
        return location;
    }

    public void setLocation(@NotBlank(message = "Location is required.") String location) {
        this.location = location;
    }

    public @NotNull(message = "Price per month is required.") BigDecimal getPricePerMonth() {
        return pricePerMonth;
    }

    public void setPricePerMonth(@NotNull(message = "Price per month is required.") BigDecimal pricePerMonth) {
        this.pricePerMonth = pricePerMonth;
    }

    public @NotNull(message = "Room Type is required.") RoomType getRoomType() {
        return roomType;
    }

    public void setRoomType(@NotNull(message = "Room Type is required.") RoomType roomType) {
        this.roomType = roomType;
    }

    public @NotNull(message = "List of amenities is required.") List<String> getAmenities() {
        return amenities;
    }

    public void setAmenities(@NotNull(message = "List of amenities is required.") List<String> amenities) {
        this.amenities = amenities;
    }

    public @NotNull(message = "Availability status is required.") AvailabilityStatus getAvailabilityStatus() {
        return availabilityStatus;
    }

    public void setAvailabilityStatus(@NotNull(message = "Availability status is required.") AvailabilityStatus availabilityStatus) {
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

    @Override
    public String toString() {
        return "AccommodationRequestDto{" +
                "owner_id='" + owner_id + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", location='" + location + '\'' +
                ", pricePerMonth=" + pricePerMonth +
                ", roomType=" + roomType +
                ", amenities=" + amenities +
                ", availabilityStatus=" + availabilityStatus +
                ", bookings=" + bookings +
                ", reviews=" + reviews +
                '}';
    }
}
