package com.alex.studentAccommodation.services;

import com.alex.studentAccommodation.daoRepositories.AccommodationRepository;
import com.alex.studentAccommodation.daoRepositories.SystemUserRepository;
import com.alex.studentAccommodation.dtos.AddAccommodationRequestDto;
import com.alex.studentAccommodation.dtos.AccommodationResponseDto;
import com.alex.studentAccommodation.dtos.GetAccommodationRequestDto;
import com.alex.studentAccommodation.entities.Accommodation;
import com.alex.studentAccommodation.entities.SystemUser;
import com.alex.studentAccommodation.exceptions.AccommodationNotFoundException;
import com.alex.studentAccommodation.exceptions.InvalidUUIDException;
import com.alex.studentAccommodation.exceptions.UserNotFoundException;
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
    public AccommodationResponseDto addAccommodation(AddAccommodationRequestDto request) {
        UUID owner_id = null;
        try{
            owner_id = UUID.fromString(request.getOwnerId());
        }
        catch(IllegalArgumentException ex){
            throw new InvalidUUIDException("Invalid UUID format: " + request.getOwnerId());
        }
        Optional<SystemUser> optional_user = systemUserRepository.findById(owner_id);
        SystemUser user = null;

        if(optional_user.isPresent())
            user = optional_user.get();
        else
            throw new UserNotFoundException("User: " + request.getOwnerId() + " not found.");

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

        Accommodation savedAccommodation = accommodationRepository.save(accommodation);

        return extractInfoFromAccommodationEntity(savedAccommodation);
    }

    @Override
    public AccommodationResponseDto getAccommodation(String accommodationId) {
        UUID uuidAccommodationId = null;

        try{
            uuidAccommodationId = UUID.fromString(accommodationId);
        }
        catch(IllegalArgumentException ex){
            throw new InvalidUUIDException("Invalid UUID format: " + accommodationId);
        }

        Optional<Accommodation> accommodation = accommodationRepository.findById(uuidAccommodationId);

        if(accommodation.isPresent()){
            return extractInfoFromAccommodationEntity(accommodation.get());
        }
        else{
            throw new AccommodationNotFoundException("The accommodation with the following id was not found: " + accommodationId);
        }
    }

    @Override
    public String deleteAccommodation(String accommodationId) {
        UUID uuudAccommodationId = null;
        try{
            uuudAccommodationId = UUID.fromString(accommodationId);
        }
        catch(IllegalArgumentException ex){
            throw new InvalidUUIDException("Accomodation Id provided is not a valid UUID string: " + accommodationId);
        }

        Optional<Accommodation> accommodation = accommodationRepository.findById(uuudAccommodationId);

        if(accommodation.isPresent()){
            accommodationRepository.deleteById(uuudAccommodationId);
            return "Accommodation ID: " + accommodationId + ". Deleted successfully";
        }
        else
            throw new AccommodationNotFoundException("Accommodation with id " + accommodationId + " does not exist.");
    }

    private AccommodationResponseDto extractInfoFromAccommodationEntity(Accommodation accommodation){
        return new AccommodationResponseDto(
                accommodation.getId(),
                accommodation.getOwner().getId(),
                accommodation.getTitle(),
                accommodation.getDescription(),
                accommodation.getLocation(),
                accommodation.getPricePerMonth(),
                accommodation.getRoomType(),
                accommodation.getAmenities(),
                accommodation.getAvailabilityStatus(),
                accommodation.getBookings(),
                accommodation.getReviews()
        );
    }
}
