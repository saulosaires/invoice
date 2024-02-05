package org.invoice.user;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.invoice.auth.dto.AuthRequest;
import org.invoice.user.exception.UserAlreadyExistException;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserFacade {

    private final UserService userService;
    private final UserMapper userMapper;

    public UserDto create(AuthRequest authRequest) throws UserAlreadyExistException {

        if (userService.existsByEmail(authRequest.email())) {
            throw new UserAlreadyExistException(authRequest.email());
        }
        
        return userMapper.toDto(userService.create(null));
    }

}
