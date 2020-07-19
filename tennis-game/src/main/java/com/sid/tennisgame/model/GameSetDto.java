package com.sid.tennisgame.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.sid.tennisgame.entities.GameSet;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import java.io.Serializable;

@JsonInclude(value = JsonInclude.Include.ALWAYS)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GameSetDto implements Serializable {
    private Long    gameId;
    private int     p1GameSetScore;
    private int     p2GameSetScore;
    private Boolean setOver;
    private Boolean tieBreak;

    public static GameSetDto convertFromEntity(GameSet entity) {
        GameSetDto wrapper = new GameSetDto();
        BeanUtils.copyProperties(entity,wrapper);
        return wrapper;
    }
}
