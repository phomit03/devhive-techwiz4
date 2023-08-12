package com.example.devhive_backend.controller;

import com.example.devhive_backend.dto.MatchDTO;
import com.example.devhive_backend.service.MatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/match")
public class MatchController {
    @Autowired
    private MatchService matchService;
    @GetMapping("getAll")
    public ResponseEntity<List<MatchDTO>> getAllMatches() {
        List<MatchDTO> matches = matchService.getAllMatches();
        return new ResponseEntity<>(matches, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<MatchDTO> getMatchById(@PathVariable Long id) {
        MatchDTO matchById = matchService.getMatchById(id);
        return new ResponseEntity<>(matchById,HttpStatus.OK);
    }
    @PostMapping("/create")
    public ResponseEntity<String> createMatch(@RequestBody MatchDTO matchDTO) {
        matchService.createMatch(matchDTO);
        return new ResponseEntity<>("Match created successfully",HttpStatus.OK);
    }
    @PostMapping("/{id}")
    public ResponseEntity<String> updateMatch(@PathVariable("id") Long id, @RequestBody MatchDTO matchDTO) {
        matchDTO.setId(id);
        matchService.updateMatch(matchDTO);
        return new ResponseEntity<>("Match updated successfully",HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteMatch(@PathVariable("id") Long id) {
        matchService.deleteMatch(id);
        return new ResponseEntity<>("Match delete successfully",HttpStatus.OK);
    }

    @GetMapping("/latest-finished-match")
    public ResponseEntity<MatchDTO> getLatestFinishedMatch() {
        MatchDTO latestFinishedMatch = matchService.getLatestFinishedMatch();
        if (latestFinishedMatch != null) {
            return new ResponseEntity<>(latestFinishedMatch, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
