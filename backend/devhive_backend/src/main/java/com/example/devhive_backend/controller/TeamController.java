package com.example.devhive_backend.controller;

import com.example.devhive_backend.dto.TeamDTO;
import com.example.devhive_backend.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/team")
public class TeamController {
    @Autowired
    private TeamService teamService;
    @GetMapping("getAll")
    public ResponseEntity<List<TeamDTO>> getAllTeams() {
        List<TeamDTO> teams = teamService.getAllTeams();
        return new ResponseEntity<>(teams, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<TeamDTO> getTeamById(@PathVariable Long id) {
        TeamDTO teamById = teamService.getTeamById(id);
        return new ResponseEntity<>(teamById,HttpStatus.OK);
    }
    @PostMapping("/create")
    public ResponseEntity<String> createTeam(@RequestBody TeamDTO teamDTO) {
        teamService.createTeam(teamDTO);
        return new ResponseEntity<>("Team created successfully",HttpStatus.CREATED);
    }
    @PostMapping("/{id}")
    public ResponseEntity<String> updateTeam(@PathVariable("id") Long id, @RequestBody TeamDTO teamDTO) {
        teamDTO.setId(id);
        teamService.updateTeam(teamDTO);
        return new ResponseEntity<>("Team updated successfully",HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTeam(@PathVariable("id") Long id) {
        teamService.deleteTeam(id);
        return new ResponseEntity<>("Team delete successfully",HttpStatus.OK);
    }
}