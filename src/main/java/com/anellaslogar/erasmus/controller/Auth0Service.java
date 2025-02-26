package com.anellaslogar.erasmus.controller;

import com.anellaslogar.erasmus.entityDTO.RegistrationRequestDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.HashMap;
import java.util.Map;

@Service
public class Auth0Service {

    @Value("${auth0.domain}")
    private String domain;

    @Value("${auth0.clientId}")
    private String clientId;

    @Value("${auth0.clientSecret}")
    private String clientSecret;

    @Value("${auth0.audience}")
    private String audience;

    private String getManagementApiToken() {
        String url = "https://" + domain + "/oauth/token";
        RestTemplate restTemplate = new RestTemplate();

        Map<String, String> requestBody = new HashMap<>();
        requestBody.put("client_id", clientId);
        requestBody.put("client_secret", clientSecret);
        requestBody.put("audience", audience);
        requestBody.put("grant_type", "client_credentials");

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<Map<String, String>> entity = new HttpEntity<>(requestBody, headers);

        ResponseEntity<Map> response = restTemplate.postForEntity(url, entity, Map.class);
        return (String) response.getBody().get("access_token");
    }

    public ResponseEntity<String> createUser(RegistrationRequestDTO request) {
        String url = "https://" + domain + "/api/v2/users";
        RestTemplate restTemplate = new RestTemplate();

        String token = getManagementApiToken();

        Map<String, Object> user = new HashMap<>();
        user.put("email", request.getEmail());
        user.put("lozinka", request.getLozinka());
        user.put("connection", "Username-Password-Authentication");

        Map<String, String> metadata = new HashMap<>();
        metadata.put("ime", request.getIme());
        metadata.put("prezime", request.getPrezime());
        metadata.put("fakultet", request.getFakultet());
        user.put("user_metadata", metadata);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBearerAuth(token);

        HttpEntity<Map<String, Object>> entity = new HttpEntity<>(user, headers);

        try {
            restTemplate.postForEntity(url, entity, String.class);
            return ResponseEntity.status(HttpStatus.CREATED).body("User registered successfully.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Registration failed: " + e.getMessage());
        }
    }
}
