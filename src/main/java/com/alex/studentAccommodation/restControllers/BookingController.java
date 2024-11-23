package com.alex.studentAccommodation.restControllers;

import com.alex.studentAccommodation.dtos.AddBookingRequestDto;
import com.alex.studentAccommodation.dtos.BookingResponseDto;
import com.alex.studentAccommodation.services.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class BookingController {
    @Autowired
    private BookingService bookingService;

    @PostMapping("/bookings")
    public ResponseEntity<BookingResponseDto> addBooking(@RequestBody AddBookingRequestDto request){
        return ResponseEntity.ok(bookingService.addBooking(request));
    }

    @GetMapping("/bookings/{bookingId}")
    public ResponseEntity<BookingResponseDto> getBooking(@PathVariable  String bookingId){
        return ResponseEntity.ok(bookingService.getBooking(bookingId));
    }
}
