package com.alex.studentAccommodation.services;


import com.alex.studentAccommodation.dtos.AddReviewRequestDto;
import com.alex.studentAccommodation.dtos.ReviewResponseDto;

public interface ReviewService {
    public ReviewResponseDto addReview(AddReviewRequestDto request);
    public ReviewResponseDto getReview(String reviewId);
    public String deleteReview(String reviewId);
}
