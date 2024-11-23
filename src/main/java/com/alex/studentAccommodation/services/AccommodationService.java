package com.alex.studentAccommodation.services;

import com.alex.studentAccommodation.dtos.AddAccommodationRequestDto;
import com.alex.studentAccommodation.dtos.AccommodationResponseDto;
import com.alex.studentAccommodation.dtos.GetAccommodationRequestDto;
import jakarta.validation.Valid;

public interface AccommodationService {
    AccommodationResponseDto addAccommodation(AddAccommodationRequestDto request);

    AccommodationResponseDto getAccommodation(String accommodationId);

    String deleteAccommodation(@Valid String accommodationId);
}
