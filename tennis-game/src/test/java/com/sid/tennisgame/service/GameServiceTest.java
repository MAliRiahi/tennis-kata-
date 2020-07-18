package com.sid.tennisgame.service;

import com.sid.tennisgame.TennisGameApplication;
import com.sid.tennisgame.entities.Game;
import com.sid.tennisgame.enums.Point;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = TennisGameApplication.class)
public class GameServiceTest {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private GameService gameService;


    @Test
    public void addP1Point_basic() {
        Game game = new Game(null, Point.ZERO,Point.THIRTY,false,false);
        logger.info("p1 -> {}", game.getP1GameScore());
        logger.info("p2 -> {}", game.getP2GameScore());
        Assert.assertEquals(Point.FIFTEEN, gameService.addP1Point(game).getP1GameScore());
        logger.info("p1 -> {}", game.getP1GameScore());
        logger.info("p2 -> {}", game.getP2GameScore());
    }

    @Test
    public void addP2Point_basic() {
        Game game = new Game(null, Point.ZERO,Point.THIRTY,false,false);
        logger.info("p1 -> {}", game.getP1GameScore());
        logger.info("p2 -> {}", game.getP2GameScore());
        Assert.assertEquals(Point.FORTY, gameService.addP2Point(game).getP2GameScore());
        logger.info("p1 -> {}", game.getP1GameScore());
        logger.info("p2 -> {}", game.getP2GameScore());
    }

    @Test
    public void addP1Point_deuce1() {
        Game game = new Game(null, Point.THIRTY,Point.FORTY,false,false);
        logger.info("p1 -> {}", game.getP1GameScore());
        logger.info("p2 -> {}", game.getP2GameScore());
        logger.info("deuce -> {}", game.getDeuce());
        game = gameService.addP1Point(game);
        Assert.assertEquals(Point.FORTY, game.getP1GameScore());
        Assert.assertEquals(true, game.getDeuce());
        logger.info("p1 -> {}", game.getP1GameScore());
        logger.info("p2 -> {}", game.getP2GameScore());
        logger.info("deuce -> {}", game.getDeuce());

    }

    @Test
    public void addP1Point_deuce2() {
        Game game = new Game(null, Point.FORTY,Point.ADVANTAGE,false,true);
        logger.info("p1 -> {}", game.getP1GameScore());
        logger.info("p2 -> {}", game.getP2GameScore());
        logger.info("deuce -> {}", game.getDeuce());
        game = gameService.addP1Point(game);
        Assert.assertEquals(Point.FORTY, game.getP1GameScore());
        Assert.assertEquals(Point.FORTY, game.getP2GameScore());
        logger.info("p1 -> {}", game.getP1GameScore());
        logger.info("p2 -> {}", game.getP2GameScore());
        logger.info("deuce -> {}", game.getDeuce());

    }

    @Test
    public void addP2Point_deuce1() {
        Game game = new Game(null, Point.FORTY,Point.THIRTY,false,false);
        logger.info("p1 -> {}", game.getP1GameScore());
        logger.info("p2 -> {}", game.getP2GameScore());
        logger.info("deuce -> {}", game.getDeuce());
        game = gameService.addP2Point(game);
        Assert.assertEquals(Point.FORTY, game.getP2GameScore());
        Assert.assertEquals(true, game.getDeuce());
        logger.info("p1 -> {}", game.getP1GameScore());
        logger.info("p2 -> {}", game.getP2GameScore());
        logger.info("deuce -> {}", game.getDeuce());

    }

    @Test
    public void addP2Point_deuce2() {
        Game game = new Game(null, Point.ADVANTAGE,Point.FORTY,false,true);
        logger.info("p1 -> {}", game.getP1GameScore());
        logger.info("p2 -> {}", game.getP2GameScore());
        logger.info("deuce -> {}", game.getDeuce());
        game = gameService.addP2Point(game);
        Assert.assertEquals(Point.FORTY, game.getP1GameScore());
        Assert.assertEquals(Point.FORTY, game.getP2GameScore());
        logger.info("p1 -> {}", game.getP1GameScore());
        logger.info("p2 -> {}", game.getP2GameScore());
        logger.info("deuce -> {}", game.getDeuce());
    }

    @Test
    public void addP2Point_advantage() {
        Game game = new Game(null, Point.FORTY,Point.FORTY,false,true);
        logger.info("p1 -> {}", game.getP1GameScore());
        logger.info("p2 -> {}", game.getP2GameScore());
        logger.info("deuce -> {}", game.getDeuce());
        logger.info("gameOver -> {}", game.getGameOver());
        game = gameService.addP2Point(game);
        Assert.assertEquals(Point.ADVANTAGE, game.getP2GameScore());
        logger.info("p1 -> {}", game.getP1GameScore());
        logger.info("p2 -> {}", game.getP2GameScore());
        logger.info("deuce -> {}", game.getDeuce());
        logger.info("gameOver -> {}", game.getGameOver());

    }

    @Test
    public void addP1Point_advantage() {
        Game game = new Game(null, Point.FORTY,Point.FORTY,false,true);
        logger.info("p1 -> {}", game.getP1GameScore());
        logger.info("p2 -> {}", game.getP2GameScore());
        logger.info("deuce -> {}", game.getDeuce());
        logger.info("gameOver -> {}", game.getGameOver());
        game = gameService.addP1Point(game);
        Assert.assertEquals(Point.ADVANTAGE, game.getP1GameScore());
        logger.info("p1 -> {}", game.getP1GameScore());
        logger.info("p2 -> {}", game.getP2GameScore());
        logger.info("deuce -> {}", game.getDeuce());
        logger.info("gameOver -> {}", game.getGameOver());
    }

    @Test
    public void addP1Point_win1() {
        Game game = new Game(null, Point.FORTY,Point.ZERO,false,true);
        logger.info("p1 -> {}", game.getP1GameScore());
        logger.info("p2 -> {}", game.getP2GameScore());
        logger.info("deuce -> {}", game.getDeuce());
        logger.info("gameOver -> {}", game.getGameOver());
        game = gameService.addP1Point(game);
        Assert.assertEquals(Point.WIN, game.getP1GameScore());
        Assert.assertEquals(true, game.getGameOver());
        logger.info("p1 -> {}", game.getP1GameScore());
        logger.info("p2 -> {}", game.getP2GameScore());
        logger.info("deuce -> {}", game.getDeuce());
        logger.info("gameOver -> {}", game.getGameOver());
    }

    @Test
    public void addP1Point_win2() {
        Game game = new Game(null, Point.ADVANTAGE,Point.FORTY,false,true);
        logger.info("p1 -> {}", game.getP1GameScore());
        logger.info("p2 -> {}", game.getP2GameScore());
        logger.info("deuce -> {}", game.getDeuce());
        logger.info("gameOver -> {}", game.getGameOver());
        game = gameService.addP1Point(game);
        Assert.assertEquals(Point.WIN, game.getP1GameScore());
        Assert.assertEquals(true, game.getGameOver());
        logger.info("p1 -> {}", game.getP1GameScore());
        logger.info("p2 -> {}", game.getP2GameScore());
        logger.info("deuce -> {}", game.getDeuce());
        logger.info("gameOver -> {}", game.getGameOver());
    }

    @Test
    public void addP2Point_win1() {
        Game game = new Game(null, Point.ZERO,Point.FORTY,false,true);
        logger.info("p1 -> {}", game.getP1GameScore());
        logger.info("p2 -> {}", game.getP2GameScore());
        logger.info("deuce -> {}", game.getDeuce());
        logger.info("gameOver -> {}", game.getGameOver());
        game = gameService.addP2Point(game);
        Assert.assertEquals(Point.WIN, game.getP2GameScore());
        Assert.assertEquals(true, game.getGameOver());
        logger.info("p1 -> {}", game.getP1GameScore());
        logger.info("p2 -> {}", game.getP2GameScore());
        logger.info("deuce -> {}", game.getDeuce());
        logger.info("gameOver -> {}", game.getGameOver());
    }

    @Test
    public void addP2Point_win2() {
        Game game = new Game(null, Point.FORTY,Point.ADVANTAGE,false,true);
        logger.info("p1 -> {}", game.getP1GameScore());
        logger.info("p2 -> {}", game.getP2GameScore());
        logger.info("deuce -> {}", game.getDeuce());
        logger.info("gameOver -> {}", game.getGameOver());
        game = gameService.addP2Point(game);
        Assert.assertEquals(Point.WIN, game.getP2GameScore());
        Assert.assertEquals(true, game.getGameOver());
        logger.info("p1 -> {}", game.getP1GameScore());
        logger.info("p2 -> {}", game.getP2GameScore());
        logger.info("deuce -> {}", game.getDeuce());
        logger.info("gameOver -> {}", game.getGameOver());
    }



}
