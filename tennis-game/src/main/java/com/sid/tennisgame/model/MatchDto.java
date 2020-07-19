package com.sid.tennisgame.model;

import com.sid.tennisgame.entities.Match;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MatchDto implements Serializable {
    private Long       matchID;
    private PlayerDto  p1;
    private PlayerDto  p2;
    private ScorDto    scor;
    private PlayerDto  winnerPlayer;


    public static MatchDto convertFromEntity(Match entity) {
        MatchDto wrapper = new MatchDto();
        wrapper.setMatchID(entity.getMatchID());
        wrapper.setP1(PlayerDto.convertFromEntity(entity.getP1()));
        wrapper.setP2(PlayerDto.convertFromEntity(entity.getP2()));
        if(entity.getWinnerplayer()!=null){
           wrapper.setWinnerPlayer(PlayerDto.convertFromEntity(entity.getWinnerplayer()));
        }
        wrapper.setScor(ScorDto.convertFromEntity(entity.getScor()));
        return wrapper;
    }
}
