package com.callan.hoaxify.user.vm;

import com.callan.hoaxify.user.User;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserVM {

    private long id;

    private String username;

    public UserVM(User user){
        this.setId(user.getId());
        this.setUsername(user.getUsername());
    }
}
