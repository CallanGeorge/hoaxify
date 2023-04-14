package com.callan.hoaxify.match;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MatchService {

    MatchRepository matchRepository;

    public MatchService (MatchRepository matchRepository){
        super();
        this.matchRepository = matchRepository;
    }

    public void save( Match match){
        matchRepository.save(match);
    }

    public List<Match> getUserMatches(String username){
        List<Match> matches = matchRepository.findAllByPlayer1(username);

        return matches;
    }
}

