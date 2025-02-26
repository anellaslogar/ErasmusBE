/*package com.anellaslogar.erasmus.controller;

import com.anellaslogar.erasmus.entity.Korisnik;
import com.anellaslogar.erasmus.entityDTO.KorisnikDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@RestController
@RequestMapping("/api")
public class ApiController {

    @Value("${auth0.domain}")
    private String auth0Domain;

    @Value("${auth0.managementApiToken}")
    private String managementApiToken;

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody KorisnikDTO korisnikDTO) {
        // Save user details to your database
        // ...

        // Create user in Auth0
        try {
            RestTemplate restTemplate = new RestTemplate();
            String url = "https://" + auth0Domain + "/api/v2/users";

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            headers.setBearerAuth(managementApiToken);

            ObjectMapper mapper = new ObjectMapper();
            String requestBody = mapper.writeValueAsString(new Korisnik(
                    korisnikDTO.getIdKorisnik().toString(),
                    korisnikDTO.getPass(),
                    "Username-Password-Authentication"
            ));

            HttpEntity<String> entity = new HttpEntity<>(requestBody, headers);
            restTemplate.exchange(url, HttpMethod.POST, entity, String.class);

            // Optionally, trigger a password reset email
            // ...

            return ResponseEntity.ok("Registration successful");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body("Registration failed");
        }
    }
}*/
