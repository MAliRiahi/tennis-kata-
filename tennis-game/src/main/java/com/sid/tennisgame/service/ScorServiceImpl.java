package com.sid.tennisgame.service;

import com.sid.tennisgame.entities.Game;
import com.sid.tennisgame.entities.GameSet;
import com.sid.tennisgame.entities.Scor;
import com.sid.tennisgame.enums.Point;
import com.sid.tennisgame.repository.GameDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ScorServiceImpl implements ScorService {

    @Autowired
    private GameService gameService;

    @Autowired
    private GameSetService gameSetService;

    @Autowired
    private GameDao gameDao;


    @Override
    public Scor addP1Point(Scor scor) {
        List<Game> games = scor.getGames();
        if (games!=null && !games.isEmpty()){
            Game currentGame = scor.getGames().get(games.size() - 1);
            GameSet gameSet  = scor.getGameSet();
            currentGame = gameService.addP1Point(currentGame);
            games.set(games.size() - 1,currentGame);
            if(currentGame.getP1GameScore()== Point.WIN){
                scor.setGameSet(gameSetService.addP1Game(gameSet));
                Game game = new Game();
                game.setScor(scor);
                games.add(gameDao.save(game));
            }
            scor.setGames(games);
        }else {
            games = new ArrayList<>();
            Game currentGame = new Game();
            currentGame = gameService.addP1Point(currentGame);
            games.add(currentGame);
            scor.setGames(games);
        }
        return scor;
    }

    @Override
    public Scor addP2Point(Scor scor) {
        List<Game> games = scor.getGames();
        if (games!=null && ! games.isEmpty()){
            Game currentGame = scor.getGames().get(games.size() - 1);
            GameSet gameSet  = scor.getGameSet();
            currentGame = gameService.addP2Point(currentGame);
            games.set(games.size() - 1,currentGame);
            if(currentGame.getP2GameScore()== Point.WIN){
                scor.setGameSet(gameSetService.addP2Game(gameSet));
                Game game = new Game();
                game.setScor(scor);
                games.add(gameDao.save(game));
            }
            scor.setGames(games);
        }else {
            games = new ArrayList<>();
            Game currentGame = new Game();
            currentGame = gameService.addP2Point(currentGame);
            games.add(currentGame);
            scor.setGames(games);
        }
        return scor;
    }
}
