package com.example.devhive_backend.service;

import com.example.devhive_backend.dto.TeamDTO;
import com.example.devhive_backend.entity.Team;

import java.util.List;

public interface TeamService {
    List<TeamDTO> getAllTeams();

    TeamDTO getTeamById(Long id);

    Team createTeam(TeamDTO teamDTO);

    void updateTeam(TeamDTO teamDTO);

    void deleteTeam(Long id);
}
