package com.sid.tennisgame.model;

import com.sid.tennisgame.entities.Scor;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ScorDto {
    private Long       scorId;
    private GameDto    game;

    public static ScorDto convertFromEntity(Scor entity) {
        ScorDto wrapper = new ScorDto();
        wrapper.setScorId(entity.getScorId());
        wrapper.setGame(GameDto.convertFromEntity(entity.getGame()));
        return wrapper;
    }
}
