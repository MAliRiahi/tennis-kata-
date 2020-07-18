package com.sid.tennisgame.controller;

import com.sid.tennisgame.model.MatchDto;
import com.sid.tennisgame.model.PlayerDto;
import com.sid.tennisgame.repository.PlayerDao;
import com.sid.tennisgame.service.MatchService;
import com.sid.tennisgame.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "tennis")
@CrossOrigin(origins = "*", maxAge = 3600)
public class PlayerController {

    @Autowired
    private MatchService matchService;


    @PostMapping(value = "/newMatch")
    public ResponseEntity<MatchDto> newMatch (@RequestBody List<PlayerDto> playersDto) {
        MatchDto result = matchService.newMatch(playersDto.get(0),playersDto.get(1));
        return new ResponseEntity<MatchDto>(result, HttpStatus.ACCEPTED);
    }

    @PostMapping(value = "/addP1Point")
    public ResponseEntity<MatchDto> addP1Point (@RequestBody Long matchId) {
        MatchDto result = matchService.addP1Point(matchId);
        return new ResponseEntity<MatchDto>(result, HttpStatus.ACCEPTED);
    }

    @PostMapping(value = "/addP2Point")
    public ResponseEntity<MatchDto> addP2Point (@RequestBody Long matchId) {
        MatchDto result = matchService.addP2Point(matchId);
        return new ResponseEntity<MatchDto>(result, HttpStatus.ACCEPTED);
    }


}
