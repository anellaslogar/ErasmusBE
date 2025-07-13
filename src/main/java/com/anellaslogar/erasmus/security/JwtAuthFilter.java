package com.anellaslogar.erasmus.security;

import com.nimbusds.jose.JWSVerifier;
import com.nimbusds.jose.crypto.RSASSAVerifier;
import com.nimbusds.jose.jwk.JWK;
import com.nimbusds.jose.jwk.JWKSet;
import com.nimbusds.jose.jwk.RSAKey;
import com.nimbusds.jwt.SignedJWT;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.net.URL;

@Component
public class JwtAuthFilter extends OncePerRequestFilter {

    private final String jwksUrl = "https://your-project-id.supabase.co/auth/v1/keys";

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        String header = request.getHeader("Authorization");
        if (header != null && header.startsWith("Bearer ")) {
            try {
                String token = header.substring(7);
                SignedJWT signedJWT = SignedJWT.parse(token);

                JWKSet jwks = JWKSet.load(new URL(jwksUrl));
                JWK jwk = jwks.getKeyByKeyId(signedJWT.getHeader().getKeyID());

                JWSVerifier verifier = new RSASSAVerifier((RSAKey) jwk);
                if (!signedJWT.verify(verifier)) {
                    throw new RuntimeException("Invalid JWT signature");
                }

                String userId = signedJWT.getJWTClaimsSet().getSubject();
                request.setAttribute("userId", userId);

            } catch (Exception e) {
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                return;
            }
        }

        filterChain.doFilter(request, response);
    }
}
