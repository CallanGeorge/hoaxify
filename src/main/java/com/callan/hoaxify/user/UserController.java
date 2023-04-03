package com.callan.hoaxify.user;

import com.callan.hoaxify.shared.GenericResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/api/v1")
public class UserController {

    @Autowired
     UserService userService;


    @Autowired
    UserRepository userRepository;

    @PostMapping("/users")
    GenericResponse createUser (@Valid @RequestBody User user){
        if(user.getUsername() == null || user.getPassword() == null){
            throw new UserNotValidException();
        }else{
            userService.save(user);
            return new GenericResponse("New User Created.");
        }
    }

    }


