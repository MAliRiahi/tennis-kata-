package com.sid.tennisgame.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data @AllArgsConstructor @NoArgsConstructor
@Entity
public class Scor {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long    scorId;
    @OneToOne
    private Game    game;


}
