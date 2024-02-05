package org.invoice.security;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.invoice.exception.NotFoundException;
import org.invoice.user.User;
import org.invoice.user.UserService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserService userService;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        log.info("UserDetailsService.loadUserByEmail {}",email);
        User user = findByEmail(email);

        return new AppUserDetails(user);
    }

    private User findByEmail(String email) {

        try {
            return userService.findByEmail(email);
        } catch (NotFoundException notFoundException) {
            log.error("UserDetailsService.findByEmail {}", notFoundException.getMessage());
            throw new UsernameNotFoundException(notFoundException.getMessage());
        }
    }
}
