package com.alex.studentAccomodation.rest_controllers;

import com.alex.studentAccomodation.entities.SystemUser;
import com.alex.studentAccomodation.services.SystemUserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
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
    public SystemUser registerSystemUsers(@Valid @RequestBody SystemUser systemUser){
        systemUser.setPassword(passwordEncoder.encode(systemUser.getPassword()));
        return systemUserService.registerUser(systemUser);
    }

    @GetMapping("/test")
    public String test(){
        return "Hello world";
    }

}
