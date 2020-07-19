package com.sid.tennisgame.model;

import com.sid.tennisgame.entities.Game;
import com.sid.tennisgame.enums.Point;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import java.io.Serializable;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class GameDto implements Serializable {
    private Long    gameId;
    private Point   p1GameScore;
    private Point   p2GameScore;
    private Boolean gameOver;
    private Boolean deuce;

    public static GameDto convertFromEntity(Game entity) {
        GameDto wrapper = new GameDto();
        BeanUtils.copyProperties(entity,wrapper);
        return wrapper;
    }
}
