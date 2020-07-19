package com.sid.tennisgame.repository;

import com.sid.tennisgame.entities.GameSet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameSetDao extends JpaRepository<GameSet,Long> {
}
