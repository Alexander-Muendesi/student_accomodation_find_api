package com.alex.studentAccommodation.restControllers;

import com.alex.studentAccommodation.dtos.AccommodationRequestDto;
import com.alex.studentAccommodation.entities.Accommodation;
import com.alex.studentAccommodation.entities.SystemUser;
import com.alex.studentAccommodation.services.AccommodationService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class AccommodationController {
    @Autowired
    AccommodationService accommodationService;

    @PostMapping("/accommodations")
    public ResponseEntity<Accommodation> addAccommodation(@Valid @RequestBody AccommodationRequestDto request){
        return ResponseEntity.ok(accommodationService.addAccommodation(request));
    }
}
