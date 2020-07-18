package com.sid.tennisgame.service;

import com.sid.tennisgame.entities.Player;
import com.sid.tennisgame.model.PlayerDto;

public interface PlayerService {
    Player addPlayer(PlayerDto player);
}
