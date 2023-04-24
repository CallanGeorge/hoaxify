package com.callan.hoaxify;

import com.callan.hoaxify.user.User;
import com.callan.hoaxify.user.UserRepository;
import com.callan.hoaxify.user.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;

import java.util.stream.IntStream;

@SpringBootApplication
public class HoaxifyApplication {

    public static void main(String[] args) {
        SpringApplication.run(HoaxifyApplication.class, args);
    }



    // DO NOT NEED THIS AS IT NOW IS STORED IN DB

//    @Bean
//    CommandLineRunner run (UserService userService){
//        return (args) -> {
//            IntStream.rangeClosed(1,15).mapToObj(i -> {
//                User user = new User();
//                user.setUsername("user"+ i);
//                user.setPassword("password");
//                return user;
//            })
//                .forEach(userService::save);
//        };
//    }
}
