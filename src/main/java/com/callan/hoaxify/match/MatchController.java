package com.callan.hoaxify.match;

import com.callan.hoaxify.shared.GenericResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/v1")
public class MatchController {

    @Autowired
    MatchService matchService;

    @GetMapping("/matches/{username}")
    List<Match> getMatches ( @PathVariable String username){
        List<Match> matches = matchService.getUserMatches(username);
        return matches;

    }

    @PostMapping("/matches")
    GenericResponse createMatch (@Valid @RequestBody Match match){
        matchService.save(match);
        return new GenericResponse("Match created!");
    }
}
