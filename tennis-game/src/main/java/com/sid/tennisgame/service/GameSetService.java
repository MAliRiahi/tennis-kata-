package com.sid.tennisgame.service;

import com.sid.tennisgame.entities.GameSet;

public interface GameSetService {
    GameSet addP1Game(GameSet gameSet);
    GameSet addP2Game(GameSet gameSet);
}
