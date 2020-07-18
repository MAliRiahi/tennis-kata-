package com.sid.tennisgame.service;


import com.sid.tennisgame.model.MatchDto;
import com.sid.tennisgame.model.PlayerDto;

public interface MatchService {
    MatchDto newMatch (PlayerDto p1, PlayerDto p2);
    MatchDto  addP1Point (Long matchId);
    MatchDto  addP2Point (Long matchId);


}
