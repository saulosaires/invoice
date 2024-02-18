package org.invoice.user;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.invoice.auth.dto.ProviderUser;
import org.invoice.exception.NotFoundException;
import org.invoice.user.exception.UserInvalidException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import static org.invoice.exception.ErrorType.USER_NOT_FOUND;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserService {

    private final UserRepository repository;
    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public User save(ProviderUser providerUser) {

        User user = repository.findByEmail(providerUser.email()).orElse(new User());
        user.setEmail(providerUser.email());
        user.setProvider(providerUser.iss());
        user.setProviderId(providerUser.sub());
        user.setName(providerUser.name());
        user.setPicture(providerUser.picture());
        user.setEmailVerified(providerUser.email_verified());
        return repository.save(user);
    }

    public User create(ProviderUser providerUser) {
        log.info("UserService.create:{} ", providerUser);

        User user = new User();
        user.setEmail(providerUser.email());
        user.setProvider(providerUser.iss());
        user.setName(providerUser.name());
        user.setPicture(providerUser.picture());
        user.setEmailVerified(providerUser.email_verified());

        user.setAccountNonExpired(true);
        user.setAccountNonLocked(true);
        user.setCredentialsNonExpired(true);
        user.setEnabled(true);

        return repository.save(user);
    }

    public boolean existsByEmail(String email) {
        boolean exists = repository.existsByEmail(email);
        log.info("UserService.existsByEmail:{} {}", email, exists);
        return exists;
    }

    public User findByEmail(String email) throws NotFoundException {
        return repository.findByEmail(email)
                .orElseThrow(() -> new NotFoundException(USER_NOT_FOUND, email));

    }

    public void checkPassword(User user, String password) throws UserInvalidException {
        if (!encoder.matches(password, user.getPassword())) {
            throw new UserInvalidException(user.getEmail());
        }
    }
}
