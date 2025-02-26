package com.anellaslogar.erasmus.controller;

import com.anellaslogar.erasmus.entityDTO.RegistrationRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import javax.validation.Valid;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000") // Allow only this origin
public class RegistrationController {

    @Autowired
    private Auth0Service auth0Service;

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody @Valid RegistrationRequestDTO request) {
        try {
            auth0Service.createUser(request);

            // Call Auth0's Authentication API to create a new user
            // Include additional fields in user_metadata
            // For example:
            // auth0Service.createUser(request);

            // If successful, return a 201 Created response
            return ResponseEntity.status(HttpStatus.CREATED).body("User registered successfully.");
        } catch (Exception e) {
            // Log the exception (optional)
            // logger.error("Registration failed", e);

            // If there's an error, return a 400 Bad Request response
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Registration failed: " + e.getMessage());
        }
    }
}