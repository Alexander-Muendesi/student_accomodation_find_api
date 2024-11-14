package com.alex.studentAccommodation.restControllers;

import com.alex.studentAccommodation.dtos.AddAccommodationRequestDto;
import com.alex.studentAccommodation.dtos.AccommodationResponseDto;
import com.alex.studentAccommodation.dtos.GetAccommodationRequestDto;
import com.alex.studentAccommodation.services.AccommodationService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class AccommodationController {
    @Autowired
    AccommodationService accommodationService;

    @GetMapping("/accommodations/{accommodationId}")
    public ResponseEntity<AccommodationResponseDto> getAccommodation(@Valid @PathVariable("accommodationId") String accommodationId){
        return ResponseEntity.ok(accommodationService.getAccommodation(accommodationId));
    }

    @PostMapping("/accommodations")
    public ResponseEntity<AccommodationResponseDto> addAccommodation(@Valid @RequestBody AddAccommodationRequestDto request){
        return ResponseEntity.ok(accommodationService.addAccommodation(request));
    }
}
