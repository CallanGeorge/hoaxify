package com.callan.hoaxify.user;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    UserRepository userRepository;

    PasswordEncoder passwordEncoder;




    //constructor injection - better for unit tests as it means we can create instances of this class ourselves
    public UserService (UserRepository userRepository, PasswordEncoder passwordEncoder){
        super();
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User save(User user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    public Page<User> getUsers(Pageable page){

        return userRepository.findAll(page);
    }

    public Optional<User> getByUsername(String username){
        return userRepository.findByUsername(username);
    }
}
