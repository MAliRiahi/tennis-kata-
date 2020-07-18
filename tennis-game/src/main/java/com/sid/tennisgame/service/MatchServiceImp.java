package com.sid.tennisgame.service;

import com.sid.tennisgame.entities.Game;
import com.sid.tennisgame.entities.Match;
import com.sid.tennisgame.entities.Scor;
import com.sid.tennisgame.model.MatchDto;
import com.sid.tennisgame.model.PlayerDto;
import com.sid.tennisgame.repository.GameDao;
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



    @Override
    public MatchDto newMatch(PlayerDto p1, PlayerDto p2) {
        Match match =new Match();
        Scor scor =new Scor();
        Game game=new Game();
        scor.setGame(gameDao.save(game));
        match.setScor(scorDao.save(scor));
        match.setP1(playerService.addPlayer(p1));
        match.setP2(playerService.addPlayer(p2));
        return MatchDto.convertFromEntity(matchDao.save(match));
    }

    @Override
    public MatchDto addP1Point(Long matchId) {
        Match match = matchDao.getOne(matchId);
        match.setScor(scorService.addP1Point(match.getScor()));
        return MatchDto.convertFromEntity(matchDao.save(match));
    }

    @Override
    public MatchDto addP2Point(Long matchId) {
        Match match = matchDao.getMatchByMatchID(matchId);
        match.setScor(scorService.addP2Point(match.getScor()));
        return MatchDto.convertFromEntity(matchDao.save(match));
    }


}
