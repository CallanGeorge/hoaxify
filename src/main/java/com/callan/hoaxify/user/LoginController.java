package com.callan.hoaxify.user;


import com.callan.hoaxify.shared.CurrentUser;


import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@CrossOrigin
@RequestMapping("/api/v1")
public class LoginController {

    @PostMapping("/login")
    User handleLogin(@CurrentUser User loggedInUser){
        return loggedInUser;
    }


}
