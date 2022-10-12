package com.primus.ipldashboard.repository;

import com.primus.ipldashboard.model.Match;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MatchRepo extends JpaRepository<Match, Long> {

    List<Match> getByTeam1OrTeam2OrderByDateDesc(String teamName, String teamName2, Pageable pageable);

    default List<Match> findLatestMatchesByTeam(String teamName, int count ){
        return getByTeam1OrTeam2OrderByDateDesc(teamName,teamName, PageRequest.of(0,count));
    }


}
