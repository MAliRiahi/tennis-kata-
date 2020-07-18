package com.sid.tennisgame.service;

import com.sid.tennisgame.entities.Scor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ScorServiceImpl implements ScorService {

    @Autowired
    private GameService gameService;


    @Override
    public Scor addP1Point(Scor scor) {
        if (scor.getGame()!=null){
            scor.setGame(gameService.addP1Point(scor.getGame()));
        }
        return scor;
    }

    @Override
    public Scor addP2Point(Scor scor) {
        if (scor.getGame()!=null){
            scor.setGame(gameService.addP2Point(scor.getGame()));
        }
        return scor;
    }
}
