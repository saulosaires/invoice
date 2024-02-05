package org.invoice.user;

import lombok.RequiredArgsConstructor;
import org.invoice.auth.dto.AuthRequest;
import org.invoice.user.exception.UserAlreadyExistException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("users/")
@RequiredArgsConstructor
public class UserController {

    private final UserFacade userFacade;


    @PostMapping()
    public UserDto create(@RequestBody AuthRequest authRequest) throws UserAlreadyExistException {
        return userFacade.create(authRequest);
    }

}
