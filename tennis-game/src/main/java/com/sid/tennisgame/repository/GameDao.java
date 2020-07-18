package com.sid.tennisgame.repository;

import com.sid.tennisgame.entities.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GameDao extends JpaRepository<Game,Long> {
}
