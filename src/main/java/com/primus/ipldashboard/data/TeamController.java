package com.primus.ipldashboard.data;

import com.primus.ipldashboard.model.Team;
import com.primus.ipldashboard.repository.MatchRepo;
import com.primus.ipldashboard.repository.TeamRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TeamController {

    @Autowired
    private TeamRepo teamRepo;

    @Autowired
    private MatchRepo matchRepo;

    @GetMapping("/team/{teamName}")
    public Team getTeam(@PathVariable String teamName){
        Team team =  teamRepo.findByTeamName(teamName);

        team.setMatches(matchRepo.findLatestMatchesByTeam(teamName, 4));

        return team;
    }
}
