package com.alex.studentAccommodation.services;

import com.alex.studentAccommodation.dtos.AddBookingRequestDto;
import com.alex.studentAccommodation.dtos.BookingResponseDto;

public interface BookingService {
    public BookingResponseDto addBooking(AddBookingRequestDto request);
    public BookingResponseDto getBooking(String bookingId);
    public String removeBooking(String bookingId);
}
