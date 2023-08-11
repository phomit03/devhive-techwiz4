package com.example.devhive_backend.mapper;

import com.example.devhive_backend.dto.MatchDTO;
import com.example.devhive_backend.entity.Match;

import java.util.stream.Collectors;

import static com.example.devhive_backend.mapper.TeamMapper.mapToTeamDTO;

public class MatchMapper {

    public static Match mapToMatch(MatchDTO matchDTO) {
        Match match = Match.builder()
                .id(matchDTO.getId())
                .date((matchDTO.getDate()))
                .time(matchDTO.getTime())
                .score(matchDTO.getScore())
                .soccerInfo(matchDTO.getSoccerInfo())
                .status(matchDTO.getStatus())
                .build();
        return match;
    }

    public static MatchDTO mapToMatchDTO(Match match) {
        MatchDTO matchDTO = MatchDTO.builder()
                .id(match.getId())
                .date((match.getDate()))
                .time(match.getTime())
                .score(match.getScore())
                .soccerInfo(match.getSoccerInfo())
                .status(match.getStatus())
                .teams(match.getTeams().stream().map((team) -> mapToTeamDTO(team)).collect(Collectors.toList()))
                .build();
        return matchDTO;
    }

}