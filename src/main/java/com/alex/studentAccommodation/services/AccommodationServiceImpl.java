package com.alex.studentAccommodation.services;

import com.alex.studentAccommodation.daoRepositories.AccommodationRepository;
import com.alex.studentAccommodation.daoRepositories.SystemUserRepository;
import com.alex.studentAccommodation.dtos.AccommodationRequestDto;
import com.alex.studentAccommodation.entities.Accommodation;
import com.alex.studentAccommodation.entities.SystemUser;
import com.alex.studentAccommodation.exceptions.UserNotFoundException;
import jakarta.validation.constraints.Null;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class AccommodationServiceImpl implements AccommodationService{
    @Autowired
    private AccommodationRepository accommodationRepository;

    @Autowired
    SystemUserRepository systemUserRepository;

    @Override
    public Accommodation addAccommodation(AccommodationRequestDto request) {
        UUID owner_id = UUID.fromString(request.getOwner_id());
        Optional<SystemUser> optional_user = systemUserRepository.findById(owner_id);
        SystemUser user = null;

        if(optional_user.isPresent())
            user = optional_user.get();
        else
            throw new UserNotFoundException("User: " + request.getOwner_id() + " not found.");

        Accommodation accommodation = new Accommodation(
                user,
                request.getTitle(),
                request.getDescription(),
                request.getLocation(),
                request.getPricePerMonth(),
                request.getRoomType(),
                request.getAmenities(),
                request.getAvailabilityStatus(),
                request.getBookings(),
                request.getReviews()
        );
        return accommodationRepository.save(accommodation);
    }
}
