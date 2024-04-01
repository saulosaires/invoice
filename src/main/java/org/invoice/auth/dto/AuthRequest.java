package org.invoice.auth.dto;

import jakarta.validation.constraints.NotNull;
import org.apache.commons.lang3.StringUtils;

public record AuthRequest(@NotNull String email,
                          String password,
                          String providerToken,
                          String provider) {

    public boolean hasProvider() {
        return StringUtils.isNotEmpty(providerToken) && StringUtils.isNotEmpty(provider);
    }

}



