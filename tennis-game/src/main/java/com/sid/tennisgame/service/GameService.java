package com.sid.tennisgame.service;

import com.sid.tennisgame.entities.Game;

public interface GameService{

    Game addP1Point(Game game);
    Game addP2Point(Game game);

}
