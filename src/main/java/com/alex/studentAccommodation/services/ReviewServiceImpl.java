package com.alex.studentAccommodation.services;

import com.alex.studentAccommodation.daoRepositories.AccommodationRepository;
import com.alex.studentAccommodation.daoRepositories.ReviewRepository;
import com.alex.studentAccommodation.daoRepositories.SystemUserRepository;
import com.alex.studentAccommodation.dtos.AddReviewRequestDto;
import com.alex.studentAccommodation.dtos.ReviewResponseDto;
import com.alex.studentAccommodation.entities.Accommodation;
import com.alex.studentAccommodation.entities.Review;
import com.alex.studentAccommodation.entities.SystemUser;
import com.alex.studentAccommodation.exceptions.AccommodationNotFoundException;
import com.alex.studentAccommodation.exceptions.ReviewNotFoundException;
import com.alex.studentAccommodation.exceptions.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

@Service
public class ReviewServiceImpl implements ReviewService{
    @Autowired
    private SystemUserRepository systemUserRepository;

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private AccommodationRepository accommodationRepository;

    @Override
    @Transactional
    public ReviewResponseDto addReview(AddReviewRequestDto request) {
        UUID userId = validateUuid(request.getUserId(), "addReview User");
        UUID accommodationId = validateUuid(request.getAccommodationId(), "addReview Accommodation");

        Optional<SystemUser> userOptional = systemUserRepository.findById(userId);
        Optional<Accommodation> accommodationOptional = accommodationRepository.findById(accommodationId);

        if(userOptional.isPresent() && accommodationOptional.isPresent()){
            SystemUser user = userOptional.get();
            Accommodation accommodation = accommodationOptional.get();

            Review review = new Review(
                user,
                accommodation,
                request.getRating(),
                request.getDescription()
            );

            Review createdReview = reviewRepository.save(review);
            return new ReviewResponseDto(
                    createdReview.getId(),
                    createdReview.getUser().getId(),
                    createdReview.getAccommodation().getId(),
                    createdReview.getRating(),
                    createdReview.getDescription(),
                    createdReview.getCreatedAt()
            );
        }
        else if(userOptional.isEmpty())
            throw new UserNotFoundException("User with id {" + request.getUserId() + "} does not exist");
        else
            throw new AccommodationNotFoundException("Accommodation with id {" + request.getAccommodationId() + "} does not exist");
    }

    @Override
    public ReviewResponseDto getReview(String reviewId) {
        UUID reviewIdUuid = validateUuid(reviewId, "getReview");
        Optional<Review> reviewOptional = reviewRepository.findById(reviewIdUuid);

        if(reviewOptional.isPresent()){
            Review review = reviewOptional.get();
            return new ReviewResponseDto(
                review.getId(),
                review.getUser().getId(),
                review.getAccommodation().getId(),
                review.getRating(),
                review.getDescription(),
                review.getCreatedAt()
            );
        }
        else
            throw new ReviewNotFoundException("Review with id {" + reviewId + "} does not exist.");
    }

    @Override
    @Transactional
    public String deleteReview(String reviewId) {
        UUID reviewIdUuid = validateUuid(reviewId, "deleteReview");

        Optional<Review> reviewOptional = reviewRepository.findById(reviewIdUuid);
        if(reviewOptional.isPresent()){
            reviewRepository.deleteById(reviewIdUuid);
            return "Review with id " + reviewId + " was deleted successfully.";
        }
        else
            return "Delete failed. Review with id " + reviewId + " does not exist";

    }

    private UUID validateUuid(String id, String type){
        try{
            return UUID.fromString(id);
        }
        catch(Exception e){
            throw new IllegalArgumentException(type + " id {" + id + "} is not a valid UUID identifier.");
        }
    }
}
