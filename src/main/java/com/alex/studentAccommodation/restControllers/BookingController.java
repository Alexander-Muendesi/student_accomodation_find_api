package com.alex.studentAccommodation.restControllers;

import com.alex.studentAccommodation.dtos.AddBookingRequestDto;
import com.alex.studentAccommodation.dtos.BookingResponseDto;
import com.alex.studentAccommodation.services.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class BookingController {
    @Autowired
    private BookingService bookingService;

    @PostMapping("/bookings")
    public ResponseEntity<BookingResponseDto> addBooking(@RequestBody AddBookingRequestDto request){
        return ResponseEntity.ok(bookingService.addBooking(request));
    }
}
