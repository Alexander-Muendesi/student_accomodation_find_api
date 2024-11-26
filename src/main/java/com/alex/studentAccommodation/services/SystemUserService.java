package com.alex.studentAccommodation.services;

import com.alex.studentAccommodation.dtos.AddSystemUserRequestDto;
import com.alex.studentAccommodation.dtos.SystemUserResponseDto;
import com.alex.studentAccommodation.entities.SystemUser;

public interface SystemUserService {
    SystemUserResponseDto registerUser(AddSystemUserRequestDto user);
}
