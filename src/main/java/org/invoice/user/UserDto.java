package org.invoice.user;


import org.invoice.company.Company;
import org.invoice.company.CompanyDto;

import java.time.LocalDate;
import java.util.UUID;


public record UserDto(
        UUID id,
        String name,
        String email,
        String phone,
        String instantMessaging,
        LocalDate birthDate,
        String picture,
        String providerId,
        String provider,
        boolean accountNonExpired,
        boolean accountNonLocked,
        boolean credentialsNonExpired,
        boolean enabled,
        boolean emailVerified
) {
}
