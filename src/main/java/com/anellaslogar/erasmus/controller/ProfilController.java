package com.anellaslogar.erasmus.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/**/")
public class ProfilController {

    @GetMapping("/profil")
    public ResponseEntity<String> getProfile(@AuthenticationPrincipal Jwt jwt) {
        String userId = jwt.getSubject();
        String email = jwt.getClaimAsString("email");
        String name = jwt.getClaim("name");

        return ResponseEntity.ok("Hello " + email + "! Your ID is " + userId);
    }
}

