package com.callan.hoaxify.user;

import com.callan.hoaxify.shared.GenericResponse;
import com.callan.hoaxify.user.vm.UserVM;
import com.fasterxml.jackson.annotation.JsonView;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
    GenericResponse createUser ( @RequestBody User user){
        Optional<User> currentUser = userRepository.findByUsername(user.getUsername());

        if(user.getUsername() == null || user.getPassword() == null || currentUser.isPresent()){
            throw new UserNotValidException();
        }else {

            userService.save(user);
            return new GenericResponse("New User Created.");
        }
    }

    @GetMapping("/users")
    Page<UserVM> getUsers( Pageable
        page){
        return userService.getUsers(page).map(user -> new UserVM(user));
    }

    @GetMapping("/users/{username}")
    UserVM getByUsername(@PathVariable String username) throws Exception{
        Optional<User> user = userService.getByUsername(username);

        if(user.isEmpty()){
            throw new Exception("No user found with that username");
        } else{
            return new UserVM(user);

        }

    }

    }


