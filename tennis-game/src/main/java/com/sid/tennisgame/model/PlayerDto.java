package com.sid.tennisgame.model;

import com.sid.tennisgame.entities.Player;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlayerDto implements Serializable {
    private Long        playerId;
    private String      playerName;

    public static PlayerDto convertFromEntity(Player entity) {
        PlayerDto wrapper = new PlayerDto();
        BeanUtils.copyProperties(entity,wrapper);
        return wrapper;
    }
}
