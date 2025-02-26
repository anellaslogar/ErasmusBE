package com.anellaslogar.erasmus.security;

import com.auth0.client.mgmt.ManagementAPI;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Auth0Config {

    @Bean
    public ManagementAPI managementAPI() {
        String domain = "dev-lpjm7tiz0tyfg3q4.eu.auth0.com";
        String token = "eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCIsImtpZCI6IlpGZjZaczIySVlxbVF2dDZsdEtNeiJ9.eyJpc3MiOiJodHRwczovL2Rldi1scGptN3RpejB0eWZnM3E0LmV1LmF1dGgwLmNvbS8iLCJzdWIiOiJKUG5qb3lGTjZzR3lGS3VxbGx3endVbWJubVZSNnNteEBjbGllbnRzIiwiYXVkIjoiaHR0cDovL2VyYXNtdXMiLCJpYXQiOjE3NDA1MDcyNjMsImV4cCI6MTc0MDU5MzY2MywiZ3R5IjoiY2xpZW50LWNyZWRlbnRpYWxzIiwiYXpwIjoiSlBuam95Rk42c0d5Rkt1cWxsd3p3VW1ibm1WUjZzbXgifQ.APGMm5LQk7uaqKfO_aj6Zi25Mgpak17oTlUv3seao4t5bNmif8L4MUVA_dhka71zrUFhOYzywtas63V9qKSoU2k6j7HNEyY7P7h5zmXlYr2ra7hLkYgZDyZJOriDq3_HHuQHiT-ik_GCOHhQr2z6Q3CAQFuvDsHtOu99e1Jiey23AuZQi0gkO1Fg7T0y1gk-oTIP61piIitxXiDrQMFl9Z_lPdpcEoxEKFGc_RksQr7dB1-5Eo9Od6ijgjOO6T0fBcqcYqM7DWpUhkbHLVx3n7o5YZMK0Pp2vENAB-SYp9oIM21YA2XorIT0rJTOeKX7O-0TA3GPg_0ohVYmX0RNGA";
        return ManagementAPI.newBuilder(domain, token).build();
    }
}