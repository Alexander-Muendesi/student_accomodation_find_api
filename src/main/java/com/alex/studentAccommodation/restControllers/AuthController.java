package com.alex.studentAccommodation.restControllers;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class AuthController {

    @PostMapping("/login")
    public ResponseEntity<String> login(HttpServletRequest request){
        String sessionId = request.getSession().getId(); // Extract the JSESSIONID
        return ResponseEntity.ok("Login successful. Your session ID is: " + sessionId);
    }

    @GetMapping("/logout")
    public ResponseEntity<String> logout(HttpServletRequest request){
        request.getSession().invalidate();
        return ResponseEntity.ok("Logged out successfully");
    }
}
