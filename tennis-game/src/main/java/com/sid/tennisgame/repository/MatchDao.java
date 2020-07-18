package com.sid.tennisgame.repository;

import com.sid.tennisgame.entities.Match;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MatchDao extends JpaRepository<Match,Long> {
    Match getMatchByMatchID (Long id);
}
