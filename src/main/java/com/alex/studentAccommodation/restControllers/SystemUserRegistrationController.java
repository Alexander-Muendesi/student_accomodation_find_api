package com.alex.studentAccommodation.restControllers;

import com.alex.studentAccommodation.entities.SystemUser;
import com.alex.studentAccommodation.services.SystemUserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class SystemUserRegistrationController {
    @Autowired
    private SystemUserService systemUserService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/system_users")
    public ResponseEntity<SystemUser> registerSystemUsers(@Valid @RequestBody SystemUser systemUser){
        systemUser.setPassword(passwordEncoder.encode(systemUser.getPassword()));
        return ResponseEntity.ok(systemUserService.registerUser(systemUser));
    }
}
