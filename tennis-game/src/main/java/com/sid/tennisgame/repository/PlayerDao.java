package com.sid.tennisgame.repository;

import com.sid.tennisgame.entities.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerDao extends JpaRepository<Player,Long> {
}
