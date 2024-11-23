package com.alex.studentAccommodation.dtos;

import com.alex.studentAccommodation.constants.BookingStatus;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public class AddBookingRequestDto {
    @NotBlank(message = "User Id cannot be blank")
    private String userId;

    @NotBlank(message = "Accommodation Id cannot be blank")
    private String accommodationId;

    @NotBlank(message = "Booking must have a start date")
    @Pattern(regexp = "^\\d{4}-\\d{2}-\\d{2}$", message = "Date must be in the format yyyy-MM-dd.")
    private String startDate;

    @NotBlank(message = "Booking must have an end date")
    private String endDate;

    @Enumerated(EnumType.STRING)
    @NotNull(message = "Booking status is required. Choose one of the following: PENDING, CONFIRMED, REJECTED")
    @NotBlank(message = "Booking cannot be empty. Choose one of the following: PENDING, CONFIRMED, REJECTED.")
    private BookingStatus status;

    public AddBookingRequestDto(){};

    public AddBookingRequestDto(String userId, String accommodationId, String startDate, String endDate, BookingStatus status) {
        this.userId = userId;
        this.accommodationId = accommodationId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.status = status;
    }

    public @NotBlank(message = "User Id cannot be blank") String getUserId() {
        return userId;
    }

    public void setUserId(@NotBlank(message = "User Id cannot be blank") String userId) {
        this.userId = userId;
    }

    public @NotBlank(message = "Accommodation Id cannot be blank") String getAccommodationId() {
        return accommodationId;
    }

    public void setAccommodationId(@NotBlank(message = "Accommodation Id cannot be blank") String accommodationId) {
        this.accommodationId = accommodationId;
    }

    public @NotBlank(message = "Booking must have a start date") String getStartDate() {
        return startDate;
    }

    public void setStartDate(@NotBlank(message = "Booking must have a start date") String startDate) {
        this.startDate = startDate;
    }

    public @NotBlank(message = "Booking must have an end date") String getEndDate() {
        return endDate;
    }

    public void setEndDate(@NotBlank(message = "Booking must have an end date") String endDate) {
        this.endDate = endDate;
    }

    public @NotNull(message = "Booking status is required. Choose one of the following: PENDING, CONFIRMED, REJECTED") @NotBlank(message = "Booking cannot be empty. Choose one of the following: PENDING, CONFIRMED, REJECTED.") BookingStatus getStatus() {
        return status;
    }

    public void setStatus(@NotNull(message = "Booking status is required. Choose one of the following: PENDING, CONFIRMED, REJECTED") @NotBlank(message = "Booking cannot be empty. Choose one of the following: PENDING, CONFIRMED, REJECTED.") BookingStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "AddBookingRequestDto{" +
                "userId='" + userId + '\'' +
                ", accommodationId='" + accommodationId + '\'' +
                ", startDate='" + startDate + '\'' +
                ", endDate='" + endDate + '\'' +
                ", status=" + status +
                '}';
    }
}
