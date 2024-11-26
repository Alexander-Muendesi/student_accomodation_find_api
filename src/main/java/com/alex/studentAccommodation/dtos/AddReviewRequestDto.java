package com.alex.studentAccommodation.dtos;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public class AddReviewRequestDto {
    @NotBlank(message = "The user id cannot be blank when adding a review")
    private String userId;

    @NotBlank(message = "The accommodation id cannot be ")
    private String accommodationId;

    @Min(value = 0, message = "Rating must be at least 0.")
    @Max(value = 5, message = "Rating must be at most 10")
    private int rating;

    @NotBlank(message = "The description for the review cannot be blank.")
    private String description;

    public AddReviewRequestDto(){}

    public AddReviewRequestDto(String userId, String accommodationId, int rating, String description) {
        this.userId = userId;
        this.accommodationId = accommodationId;
        this.rating = rating;
        this.description = description;
    }

    public @NotBlank(message = "The user id cannot be blank when adding a review") String getUserId() {
        return userId;
    }

    public void setUserId(@NotBlank(message = "The user id cannot be blank when adding a review") String userId) {
        this.userId = userId;
    }

    public @NotBlank(message = "The accommodation id cannot be ") String getAccommodationId() {
        return accommodationId;
    }

    public void setAccommodationId(@NotBlank(message = "The accommodation id cannot be ") String accommodationId) {
        this.accommodationId = accommodationId;
    }

    @Min(value = 0, message = "Rating must be at least 0.")
    @Max(value = 5, message = "Rating must be at most 10")
    public int getRating() {
        return rating;
    }

    public void setRating(@Min(value = 0, message = "Rating must be at least 0.") @Max(value = 5, message = "Rating must be at most 10") int rating) {
        this.rating = rating;
    }

    public @NotBlank(message = "The description for the review cannot be blank.") String getDescription() {
        return description;
    }

    public void setDescription(@NotBlank(message = "The description for the review cannot be blank.") String description) {
        this.description = description;
    }
}
