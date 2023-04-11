package com.callan.hoaxify.user;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class UniqueUsernameValidator implements ConstraintValidator<UniqueUsername, String>{

    @Autowired
    UserRepository userRepository;

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {

        if(this.userRepository == null){
            return true;
        }
        Optional<User> inDB = userRepository.findByUsername(value);

        if(inDB == null) {
            return true;
        }

        return false;
    }

}