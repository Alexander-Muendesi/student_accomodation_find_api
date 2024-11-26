package com.alex.studentAccommodation.restControllers;

import com.alex.studentAccommodation.dtos.AddReviewRequestDto;
import com.alex.studentAccommodation.dtos.ReviewResponseDto;
import com.alex.studentAccommodation.services.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ReviewController {
    @Autowired
    ReviewService reviewService;

    @PostMapping("/reviews")
    public ResponseEntity<ReviewResponseDto> addReview(@RequestBody AddReviewRequestDto request){
        return ResponseEntity.ok(reviewService.addReview(request));
    }

    @GetMapping("/reviews/{reviewId}")
    public ResponseEntity<ReviewResponseDto> getReview(@PathVariable String reviewId){
        return ResponseEntity.ok(reviewService.getReview(reviewId));
    }

    @DeleteMapping("/reviews/{reviewId}")
    public ResponseEntity<String> deleteReview(@PathVariable String reviewId){
        return ResponseEntity.ok(reviewService.deleteReview(reviewId));
    }
}
