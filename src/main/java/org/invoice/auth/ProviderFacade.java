package org.invoice.auth;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.invoice.auth.dto.ProviderUser;
import org.invoice.auth.exception.ProviderException;
import org.invoice.jwt.GoogleApiService;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class ProviderFacade {

    private final GoogleApiService googleApiService;

    public ProviderUser verifyToken(String token, String provider) throws ProviderException {

        ObjectMapper objectMapper = new ObjectMapper();

        try {
            if (Provider.GOOGLE.name().equalsIgnoreCase(provider))
                return objectMapper.readValue(googleApiService.verifyToken(token), ProviderUser.class);
        } catch (Exception e) {
            throw new ProviderException(String.format("Invalid token: %s, msg: %s", provider, e.getMessage()));
        }

        return null;
    }

}
