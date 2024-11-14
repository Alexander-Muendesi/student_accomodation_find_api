package com.alex.studentAccommodation.dtos;

import jakarta.validation.constraints.NotNull;

public class GetAccommodationRequestDto {
    @NotNull(message = "Valid UUID is required.")
    private String accommodationId;

    public GetAccommodationRequestDto(){};

    public GetAccommodationRequestDto(String accommodationId) {
        this.accommodationId = accommodationId;
    }

    public String getAccommodationId() {
        return accommodationId;
    }

    public void setAccommodationId(String accommodationId) {
        this.accommodationId = accommodationId;
    }
}
