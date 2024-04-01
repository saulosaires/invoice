package org.invoice.auth.dto;

public record ProviderUser(String iss,
                           String azp,
                           String aud,
                           String sub,
                           String email,
                           Boolean email_verified,
                           Long nbf,
                           String name,
                           String picture,
                           String given_name,
                           String family_name,
                           String locale,
                           Long iat,
                           Long exp,
                           String jti) {
}
