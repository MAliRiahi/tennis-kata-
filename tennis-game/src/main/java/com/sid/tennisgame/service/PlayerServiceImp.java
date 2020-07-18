package com.sid.tennisgame.service;

import com.sid.tennisgame.entities.Player;
import com.sid.tennisgame.model.PlayerDto;
import com.sid.tennisgame.repository.PlayerDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlayerServiceImp implements PlayerService {

    @Autowired
    private PlayerDao playerDao;

    @Override
    public Player addPlayer(PlayerDto player) {
        Player p = new Player();
        p.setPlayerName(player.getPlayerName());
        return playerDao.save(p);
    }
}
