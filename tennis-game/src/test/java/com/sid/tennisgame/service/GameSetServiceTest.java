package com.sid.tennisgame.service;

import com.sid.tennisgame.TennisGameApplication;
import com.sid.tennisgame.entities.GameSet;
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
public class GameSetServiceTest {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private GameSetService gameSetService;

    @Test
    public void addP1Game_basic1() {
        GameSet gameSet = new GameSet(null, 0,0,false,false);
        logger.info("gameSet-> {}", gameSet);
        Assert.assertEquals(1, gameSetService.addP1Game(gameSet).getP1GameSetScore());
        logger.info("gameSet-> {}", gameSet);
    }

    @Test
    public void addP2Game_basic1() {
        GameSet gameSet = new GameSet(null, 0,0,false,false);
        logger.info("gameSet-> {}", gameSet);
        Assert.assertEquals(1, gameSetService.addP2Game(gameSet).getP2GameSetScore());
        logger.info("gameSet-> {}", gameSet);
    }

    @Test
    public void addP1Game_basic2() {
        GameSet gameSet = new GameSet(null, 5,4,false,false);
        logger.info("gameSet-> {}", gameSet);
        gameSet = gameSetService.addP1Game(gameSet);
        Assert.assertEquals(6, gameSet.getP1GameSetScore());
        Assert.assertEquals(true, gameSet.getSetOver());
        logger.info("gameSet-> {}", gameSet);
    }

    @Test
    public void addP2Game_basic2() {
        GameSet gameSet = new GameSet(null, 4,5,false,false);
        logger.info("gameSet-> {}", gameSet);
        Assert.assertEquals(6, gameSetService.addP2Game(gameSet).getP2GameSetScore());
        Assert.assertEquals(true, gameSet.getSetOver());
        logger.info("gameSet-> {}", gameSet);
    }

    public void addP1Game_tieBreak() {
        GameSet gameSet = new GameSet(null, 5,6,false,false);
        logger.info("gameSet-> {}", gameSet);
        gameSet = gameSetService.addP1Game(gameSet);
        Assert.assertEquals(6, gameSet.getP1GameSetScore());
        Assert.assertEquals(true, gameSet.getTieBreak());
        logger.info("gameSet-> {}", gameSet);
    }

    @Test
    public void addP2Game_tieBreak() {
        GameSet gameSet = new GameSet(null, 6,5,false,false);
        logger.info("gameSet-> {}", gameSet);
        Assert.assertEquals(6, gameSetService.addP2Game(gameSet).getP2GameSetScore());
        Assert.assertEquals(true, gameSet.getTieBreak());
        logger.info("gameSet-> {}", gameSet);
    }

    public void addP1Game_SuptieBreak() {
        GameSet gameSet = new GameSet(null, 6,6,false,true);
        logger.info("gameSet-> {}", gameSet);
        gameSet = gameSetService.addP1Game(gameSet);
        Assert.assertEquals(7, gameSet.getP1GameSetScore());
        Assert.assertEquals(false, gameSet.getSetOver());
        logger.info("gameSet-> {}", gameSet);
    }

    @Test
    public void addP2Game_SuptieBreak() {
        GameSet gameSet = new GameSet(null, 6,6,false,true);
        logger.info("gameSet-> {}", gameSet);
        Assert.assertEquals(7, gameSetService.addP2Game(gameSet).getP2GameSetScore());
        Assert.assertEquals(false, gameSet.getSetOver());
        logger.info("gameSet-> {}", gameSet);
    }

    public void addP1Game_OverGame() {
        GameSet gameSet = new GameSet(null, 8,7,false,true);
        logger.info("gameSet-> {}", gameSet);
        gameSet = gameSetService.addP1Game(gameSet);
        Assert.assertEquals(9, gameSet.getP1GameSetScore());
        Assert.assertEquals(true, gameSet.getSetOver());
        logger.info("gameSet-> {}", gameSet);
    }

    @Test
    public void addP2Game_OverGame() {
        GameSet gameSet = new GameSet(null, 7,8,false,true);
        logger.info("gameSet-> {}", gameSet);
        Assert.assertEquals(9, gameSetService.addP2Game(gameSet).getP2GameSetScore());
        Assert.assertEquals(true, gameSet.getSetOver());
        logger.info("gameSet-> {}", gameSet);
    }
}
