package com.sid.tennisgame.repository;

import com.sid.tennisgame.entities.Scor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScorDao extends JpaRepository<Scor,Long> {
}
