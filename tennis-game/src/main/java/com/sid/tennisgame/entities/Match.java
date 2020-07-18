package com.sid.tennisgame.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Match {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long    matchID;
    @OneToOne()
    private Player  p1;
    @OneToOne()
    private Player  p2;
    @OneToOne()
    private Scor    scor;

}
