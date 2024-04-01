package org.invoice.auth;

import lombok.RequiredArgsConstructor;
import org.invoice.auth.dto.AuthRequest;
import org.invoice.auth.dto.AuthResponse;
import org.invoice.auth.exception.ProviderException;
import org.invoice.exception.NotFoundException;
import org.invoice.user.exception.UserInvalidException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("auth/")
@RequiredArgsConstructor
public class AuthController {

    private final AuthFacade authFacade;

    @PostMapping("/login")
    public AuthResponse getToken(@RequestBody AuthRequest authRequest) throws NotFoundException, UserInvalidException, ProviderException {
        return new AuthResponse(authFacade.getToken(authRequest));
    }

}
