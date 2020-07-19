package com.sid.tennisgame.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data @AllArgsConstructor @NoArgsConstructor
@Entity
public class Scor {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long    scorId;
    @OneToOne(cascade=CascadeType.ALL)
    private GameSet gameSet;
    @OneToMany(mappedBy = "scor")
    private List<Game> games = new ArrayList<>();

    public void addGames(Game game) {
        this.games.add(game);
    }
}
