package com.alex.studentAccommodation.daoRepositories;

import com.alex.studentAccommodation.entities.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ReviewRepository extends JpaRepository<Review, UUID> {
}
