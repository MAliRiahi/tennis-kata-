package com.sid.tennisgame.service;

import com.sid.tennisgame.entities.Game;
import com.sid.tennisgame.entities.GameSet;
import com.sid.tennisgame.entities.Match;
import com.sid.tennisgame.entities.Scor;
import com.sid.tennisgame.model.MatchDto;
import com.sid.tennisgame.model.PlayerDto;
import com.sid.tennisgame.repository.GameDao;
import com.sid.tennisgame.repository.GameSetDao;
import com.sid.tennisgame.repository.MatchDao;
import com.sid.tennisgame.repository.ScorDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class MatchServiceImp implements MatchService {

    @Autowired
    private MatchDao matchDao;

    @Autowired
    private ScorDao scorDao;

    @Autowired
    private GameDao gameDao;

    @Autowired
    private PlayerService playerService;

    @Autowired
    private ScorService scorService;

    @Autowired
    private GameSetDao gameSetDao;



    @Override
    public MatchDto newMatch(PlayerDto p1, PlayerDto p2) {
        Match match =new Match();
        Scor scor =new Scor();
        Game game = new Game();
        GameSet gameSet = new GameSet();
        scor.addGames(game);
        scor.setGameSet(gameSet);
        match.setScor(scorDao.save(scor));
        game.setScor(scor);
        gameDao.save(game);
        gameSetDao.save(gameSet);
        match.setP1(playerService.addPlayer(p1));
        match.setP2(playerService.addPlayer(p2));
        return MatchDto.convertFromEntity(matchDao.save(match));
    }

    @Override
    public MatchDto addP1Point(Long matchId) {
        Match match = matchDao.getOne(matchId);
        if(match.getScor().getGameSet().getSetOver().equals(false)) {
            match.setScor(scorService.addP1Point(match.getScor()));
            if(match.getScor().getGameSet().getSetOver().equals(true)){
                match.setWinnerplayer(match.getP1());
            }
        }
        return MatchDto.convertFromEntity(matchDao.save(match));
    }

    @Override
    public MatchDto addP2Point(Long matchId) {
        Match match = matchDao.getMatchByMatchID(matchId);
        if(match.getScor().getGameSet().getSetOver().equals(false)) {
            match.setScor(scorService.addP2Point(match.getScor()));
            if(match.getScor().getGameSet().getSetOver().equals(true)){
                match.setWinnerplayer(match.getP2());
            }
        }
        return MatchDto.convertFromEntity(matchDao.save(match));
    }


}
