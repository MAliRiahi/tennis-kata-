package com.sid.tennisgame.entities;

import com.sid.tennisgame.enums.Point;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;

@Data @AllArgsConstructor
@Entity
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long    gameId;
    private Point   p1GameScore;
    private Point   p2GameScore;
    private Boolean gameOver;
    private Boolean deuce;
    @ManyToOne()
    private Scor    scor;

    public Game() {
        this.p1GameScore = Point.ZERO;
        this.p2GameScore = Point.ZERO;
        this.gameOver = false;
        this.deuce = false;
    }
}
