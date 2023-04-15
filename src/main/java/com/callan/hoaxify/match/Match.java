package com.callan.hoaxify.match;

import com.callan.hoaxify.user.User;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Match {

    @Id
    @GeneratedValue
    private long id;


    // Errors here as confusion about how I will link the matches to 2 different users
    // google FK for users annotation
    @NotNull
   private String player1;

    @NotNull
   private String player2;

   // create a winner column null at first - would hold player id

    private Boolean player1Voted = false;

    private Boolean player2Voted = false;

    private String player1Vote;

    private String player2Vote;



    private String dateTime;

    private Boolean accepted = false;

    private String winner ;


}
