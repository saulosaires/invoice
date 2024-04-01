package org.invoice.jwt;

import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdTokenVerifier;
import lombok.RequiredArgsConstructor;
import org.invoice.jwt.exception.JwtException;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class GoogleApiService {


    private final GoogleIdTokenVerifier googleIdTokenVerifier;

    public String verifyToken(String token) throws JwtException {

        try {
            GoogleIdToken googleIdToken = googleIdTokenVerifier.verify(token);

            if (Objects.isNull(googleIdToken))
                throw new Exception("Failed to verify token");

            return googleIdToken.getPayload().toString();

        } catch (Exception e) {
            throw new JwtException("JWT token validation error:" + e.getMessage());
        }
    }

}
