package com.callan.hoaxify.match;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MatchRepository extends JpaRepository<Match, Long> {

    Match getMatchById(long id);

    List<Match>findAllByPlayer1AndWinnerIsNullAndAcceptedIsTrue(String username);

    List<Match>findAllByPlayer2AndWinnerIsNullAndAcceptedIsTrue(String username);


    List<Match>findAllByPlayer1AndAcceptedIsFalse(String username);

    List<Match>findAllByPlayer2AndAcceptedIsFalse(String username);


}
