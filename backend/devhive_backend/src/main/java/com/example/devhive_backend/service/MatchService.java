package com.example.devhive_backend.service;

import com.example.devhive_backend.dto.MatchDTO;
import com.example.devhive_backend.entity.Match;

import java.util.List;

public interface MatchService {
    List<MatchDTO> getAllMatches();

    MatchDTO getMatchById(Long id);

    Match createMatch(MatchDTO matchDTO);

    void updateMatch(MatchDTO matchDTO);

    void deleteMatch(Long id);
}
