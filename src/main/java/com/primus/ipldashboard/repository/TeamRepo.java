package com.primus.ipldashboard.repository;

import com.primus.ipldashboard.model.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamRepo extends JpaRepository<Team,Long> {
    Team findByTeamName(String teamName);
}
