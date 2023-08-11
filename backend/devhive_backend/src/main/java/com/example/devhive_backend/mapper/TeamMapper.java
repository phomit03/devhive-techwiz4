package com.example.devhive_backend.mapper;

import com.example.devhive_backend.dto.TeamDTO;
import com.example.devhive_backend.entity.Team;

import java.util.stream.Collectors;

import static com.example.devhive_backend.mapper.MatchMapper.mapToMatchDTO;

public class TeamMapper {
    public static Team mapToTeam(TeamDTO teamDTO) {
        Team team = Team.builder()
                .id(teamDTO.getId())
                .name(teamDTO.getName())
                .country(teamDTO.getCountry())
                .logoImage(teamDTO.getLogoImage())
                .status(teamDTO.getStatus())
                .build();
        return team;
    }
    public static TeamDTO mapToTeamDTO(Team team) {
        TeamDTO teamDTO = TeamDTO.builder()
                .id(team.getId())
                .name(team.getName())
                .country(team.getCountry())
                .logoImage(team.getLogoImage())
                .status(team.getStatus())
                .matches(team.getMatches().stream().map((match) -> mapToMatchDTO(match)).collect(Collectors.toList()))
                .build();
        return teamDTO;
    }
}
