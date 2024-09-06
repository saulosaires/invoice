package org.invoice.auth;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.invoice.auth.dto.AuthRequest;
import org.invoice.auth.dto.ProviderUser;
import org.invoice.auth.exception.ProviderException;
import org.invoice.exception.NotFoundException;
import org.invoice.jwt.JwtService;
import org.invoice.user.User;
import org.invoice.user.UserService;
import org.invoice.user.exception.UserInvalidException;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class AuthFacade {

  private final UserService userService;
  private final ProviderFacade providerFacade;
  private final JwtService jwtService;

  private String generateToken(User user) {
    log.info("AuthFacade.generateToken token for: {}", user);
    return jwtService.generateToken(user);
  }

  public String getToken(AuthRequest authRequest) throws NotFoundException, UserInvalidException, ProviderException {

    if (authRequest.hasProvider()) {
      ProviderUser providerUser = providerFacade.verifyToken(authRequest.providerToken(), authRequest.provider());
      return generateToken(userService.save(providerUser));
    }

    User user = userService.findByEmail(authRequest.email());
    userService.checkPassword(user, authRequest.password());

    return generateToken(user);
  }

}
