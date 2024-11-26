package com.alex.studentAccommodation.dtos;

import java.sql.Timestamp;
import java.util.UUID;

public class ReviewResponseDto {
    private UUID reviewId;
    private UUID userId;
    private UUID accommodationId;
    private int rating;
    private String description;
    private Timestamp createdAt;

    public ReviewResponseDto(){}

    public ReviewResponseDto(UUID reviewId, UUID userId, UUID accommodationId, int rating, String description, Timestamp createdAt) {
        this.reviewId = reviewId;
        this.userId = userId;
        this.accommodationId = accommodationId;
        this.rating = rating;
        this.description = description;
        this.createdAt = createdAt;
    }

    public UUID getReviewId() {
        return reviewId;
    }

    public void setReviewId(UUID reviewId) {
        this.reviewId = reviewId;
    }

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public UUID getAccommodationId() {
        return accommodationId;
    }

    public void setAccommodationId(UUID accommodationId) {
        this.accommodationId = accommodationId;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "ReviewResponseDto{" +
                "reviewId=" + reviewId +
                ", userId=" + userId +
                ", accommodationId=" + accommodationId +
                ", rating=" + rating +
                ", description='" + description + '\'' +
                ", createdAt=" + createdAt +
                '}';
    }
}
