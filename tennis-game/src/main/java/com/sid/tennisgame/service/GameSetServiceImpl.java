package com.sid.tennisgame.service;

import com.sid.tennisgame.entities.GameSet;
import org.springframework.stereotype.Service;

@Service
public class GameSetServiceImpl implements GameSetService {
    @Override
    public GameSet addP1Game(GameSet gameSet) {
        int gameSetScore1= gameSet.getP1GameSetScore();
        int gameSetScore2= gameSet.getP2GameSetScore();
        gameSetScore1 +=1;
        gameSet.setP1GameSetScore(gameSetScore1);
        if(gameSetScore1>=6 && (gameSetScore1 - gameSetScore2) >1 ){
            gameSet.setSetOver(true);
        }
        if(gameSetScore1==6&& gameSetScore2==6 ){
            gameSet.setTieBreak(true);
        }
        return gameSet;
    }

    @Override
    public GameSet addP2Game(GameSet gameSet) {

        int gameSetScore1= gameSet.getP1GameSetScore();
        int gameSetScore2= gameSet.getP2GameSetScore();
        gameSetScore2 +=1;
        gameSet.setP2GameSetScore(gameSetScore2);
        if(gameSetScore2>=6 && (gameSetScore2 - gameSetScore1) >1 ){
            gameSet.setSetOver(true);
        }
        if(gameSetScore1==6&& gameSetScore2==6 ){
            gameSet.setTieBreak(true);
        }
        return gameSet;
    }
}
