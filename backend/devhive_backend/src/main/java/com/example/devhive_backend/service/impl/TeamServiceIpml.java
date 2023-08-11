package com.example.devhive_backend.service.impl;

import com.example.devhive_backend.dto.TeamDTO;
import com.example.devhive_backend.entity.Player;
import com.example.devhive_backend.entity.Team;
import com.example.devhive_backend.repository.PlayerRepository;
import com.example.devhive_backend.repository.TeamRepository;
import com.example.devhive_backend.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static com.example.devhive_backend.mapper.PlayerMapper.mapToPlayer;
import static com.example.devhive_backend.mapper.PlayerMapper.mapToPlayerDTO;
import static com.example.devhive_backend.mapper.TeamMapper.mapToTeam;
import static com.example.devhive_backend.mapper.TeamMapper.mapToTeamDTO;

@Service
public class TeamServiceIpml implements TeamService {
    @Autowired
    private TeamRepository teamRepository;
    @Override
    public List<TeamDTO> getAllTeams() {
        List<Team> teams = teamRepository.findAll();
        return teams.stream().map((team) -> mapToTeamDTO(team)).collect(Collectors.toList());
    }

    @Override
    public TeamDTO getTeamById(Long id) {
        Team team =  teamRepository.findById(id).get();
        return mapToTeamDTO(team);
    }

    @Override
    public Team createTeam(TeamDTO teamDTO) {
        Team team = mapToTeam(teamDTO);
        return teamRepository.save(team);
    }

    @Override
    public void updateTeam(TeamDTO teamDTO) {
        Team team = mapToTeam(teamDTO);
        teamRepository.save(team);
    }

    @Override
    public void deleteTeam(Long id) {
        teamRepository.deleteById(id);
    }
}
