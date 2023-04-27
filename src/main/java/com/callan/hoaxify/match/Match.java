package com.callan.hoaxify.match;

import com.callan.hoaxify.user.User;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name="matches")
public class Match {

    @Id
    @GeneratedValue
    private long id;



    @NotNull
   private String player1;

    @NotNull
   private String player2;


    private Boolean player1Voted = false;

    private Boolean player2Voted = false;

    private String player1Vote;

    private String player2Vote;

    private Boolean accepted = false;

    private String winner ;


}
