package com.callan.hoaxify.user;


import com.callan.hoaxify.shared.CurrentUser;


import com.callan.hoaxify.shared.GenericResponse;
import com.callan.hoaxify.user.vm.UserVM;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@CrossOrigin
@RequestMapping("/api/v1")
public class LoginController {

    @PreAuthorize("hasRole('ROLE_USER')")
    @PostMapping("/login")

    UserVM handleLogin(@CurrentUser User loggedInUser){
        return new UserVM(loggedInUser);
    }


}
