package com.sid.tennisgame.service;

import com.sid.tennisgame.entities.Game;
import com.sid.tennisgame.enums.Point;
import org.springframework.stereotype.Service;

@Service
public class GameServiceImpl implements GameService {
    @Override
    public Game addP1Point(Game game) {
        if (game.getGameOver()!=true){
            switch (game.getP1GameScore()) {
                case ZERO:
                    game.setP1GameScore(Point.FIFTEEN);
                    break;
                case FIFTEEN:
                    game.setP1GameScore(Point.THIRTY);
                    break;
                case THIRTY:
                    game.setP1GameScore(Point.FORTY);
                    if(game.getP2GameScore()==Point.FORTY){
                        game.setDeuce(true);
                    }
                    break;
                case FORTY:
                    if(game.getP2GameScore()!=Point.FORTY && game.getP2GameScore()!=Point.ADVANTAGE){
                        game.setP1GameScore(Point.WIN);
                        game.setGameOver(true);
                    }else if(game.getP2GameScore()==Point.FORTY){
                        game.setP1GameScore(Point.ADVANTAGE);
                        game.setDeuce(false);
                    }else if(game.getP2GameScore()==Point.ADVANTAGE){
                        game.setP2GameScore(Point.FORTY);
                        game.setDeuce(true);
                    }
                    break;
                case ADVANTAGE:
                    game.setP1GameScore(Point.WIN);
                    game.setGameOver(true);
                    break;
                default:
                    break;
            }
        }

        return game;
    }

    @Override
    public Game addP2Point(Game game) {
        if (game.getGameOver()!=true){
            switch (game.getP2GameScore()) {
                case ZERO:
                    game.setP2GameScore(Point.FIFTEEN);
                    break;
                case FIFTEEN:
                    game.setP2GameScore(Point.THIRTY);
                    break;
                case THIRTY:
                    game.setP2GameScore(Point.FORTY);
                    if(game.getP1GameScore()==Point.FORTY){
                        game.setDeuce(true);
                    }
                    break;
                case FORTY:
                    if(game.getP1GameScore()!=Point.FORTY && game.getP1GameScore()!=Point.ADVANTAGE){
                        game.setP2GameScore(Point.WIN);
                        game.setGameOver(true);
                    }else if(game.getP1GameScore()==Point.FORTY){
                        game.setP2GameScore(Point.ADVANTAGE);
                        game.setDeuce(false);
                    }else if(game.getP1GameScore()==Point.ADVANTAGE){
                        game.setP1GameScore(Point.FORTY);
                        game.setDeuce(true);
                    }
                    break;
                case ADVANTAGE:
                    game.setP2GameScore(Point.WIN);
                    game.setGameOver(true);
                    break;
                default:
                    break;
            }
        }

        return game;
    }
}
