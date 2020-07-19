package com.sid.tennisgame.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@AllArgsConstructor @ToString
@Entity
public class GameSet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long    gameId;
    private int     p1GameSetScore;
    private int     p2GameSetScore;
    private Boolean setOver;
    private Boolean tieBreak;

    public GameSet() {
        this.p1GameSetScore = 0;
        this.p2GameSetScore = 0;
        this.setOver = false;
        this.tieBreak = false;
    }
}
