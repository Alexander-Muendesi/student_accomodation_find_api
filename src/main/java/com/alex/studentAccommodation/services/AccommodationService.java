package com.alex.studentAccommodation.services;

import com.alex.studentAccommodation.dtos.AccommodationRequestDto;
import com.alex.studentAccommodation.entities.Accommodation;

public interface AccommodationService {
    Accommodation addAccommodation(AccommodationRequestDto request);
}
