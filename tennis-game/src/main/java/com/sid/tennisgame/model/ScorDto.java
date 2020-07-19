package com.sid.tennisgame.model;

import com.sid.tennisgame.entities.Scor;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ScorDto implements Serializable {
    private Long             scorId;
    private List<GameDto>    games;
    private GameSetDto       gameSet;

    public static ScorDto convertFromEntity(Scor entity) {
        ScorDto wrapper = new ScorDto();
        wrapper.setScorId(entity.getScorId());
        wrapper.setGames(entity.getGames().stream().map(GameDto::convertFromEntity).collect(Collectors.toList()));
        wrapper.setGameSet(GameSetDto.convertFromEntity(entity.getGameSet()));
        return wrapper;
    }
}
