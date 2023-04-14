package com.callan.hoaxify.user.vm;

import com.callan.hoaxify.user.User;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Optional;

@Data
@NoArgsConstructor
public class UserVM {

    private long id;

    private String username;

    private int score;

    public UserVM(User user){
        this.setId(user.getId());
        this.setUsername(user.getUsername());
        this.setScore(user.getScore());
    }

}
