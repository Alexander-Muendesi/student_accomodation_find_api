package com.alex.studentAccommodation.services;

import com.alex.studentAccommodation.daoRepositories.AccommodationRepository;
import com.alex.studentAccommodation.daoRepositories.BookingRepository;
import com.alex.studentAccommodation.daoRepositories.SystemUserRepository;
import com.alex.studentAccommodation.dtos.AddBookingRequestDto;
import com.alex.studentAccommodation.dtos.BookingResponseDto;
import com.alex.studentAccommodation.entities.Accommodation;
import com.alex.studentAccommodation.entities.Booking;
import com.alex.studentAccommodation.entities.SystemUser;
import com.alex.studentAccommodation.exceptions.AccommodationNotFoundException;
import com.alex.studentAccommodation.exceptions.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Optional;
import java.util.UUID;

@Service
public class BookingServiceImpl implements  BookingService{
    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private SystemUserRepository systemUserRepository;

    @Autowired
    private AccommodationRepository accommodationRepository;

    @Override
    public BookingResponseDto addBooking(AddBookingRequestDto request) {
        System.out.println(request);
        UUID userId = validateUUIDString(request.getUserId(),"user");
        UUID accommodationId = validateUUIDString(request.getAccommodationId(), "accommodation");

        SystemUser user;
        Accommodation accommodation;

        LocalDate startDate = validateDateString(request.getStartDate(),"start date");
        LocalDate endDate = validateDateString(request.getEndDate(), "end date");

        Optional<SystemUser> userOptional = systemUserRepository.findById(userId);

        if(userOptional.isPresent())
            user = userOptional.get();
        else
            throw new UserNotFoundException("User with id {" + request.getUserId() + "} does not exist.");

        Optional<Accommodation> accommodationOptional = accommodationRepository.findById(accommodationId);

        if(accommodationOptional.isPresent()){
            accommodation = accommodationOptional.get();
        }
        else{
            throw new AccommodationNotFoundException("Accommodation with id {" + request.getAccommodationId() + "} does not exist");
        }

        Booking booking = bookingRepository.save(new Booking(
            user,
            accommodation,
            startDate,
            endDate,
            request.getStatus()
        )) ;

        return new BookingResponseDto(
                booking.getId(),
                booking.getStudent().getId(),
                booking.getAccommodation().getId(),
                booking.getStartDate(),
                booking.getEndDate(),
                booking.getStatus(),
                booking.getCreatedAt()
        );
    }

    private UUID validateUUIDString(String uuid, String type){
        try{
            return UUID.fromString(uuid);
        }
        catch(Exception e){
            throw new IllegalArgumentException("The provided " + type + " id is not a valid UUID: " + uuid);
        }
    }

    private LocalDate validateDateString(String date, String type){
        try{
            return LocalDate.parse(date);
        }
        catch(DateTimeParseException e){
            throw new IllegalArgumentException("Invalid date format for " + type + ". Expected yyyy-MM-dd.");
        }
    }

}
