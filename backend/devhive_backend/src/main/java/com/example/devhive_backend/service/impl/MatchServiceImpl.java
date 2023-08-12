package com.example.devhive_backend.service.impl;

import com.example.devhive_backend.dto.MatchDTO;
import com.example.devhive_backend.entity.Match;
import com.example.devhive_backend.repository.MatchRepository;
import com.example.devhive_backend.service.MatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import static com.example.devhive_backend.mapper.MatchMapper.mapToMatch;
import static com.example.devhive_backend.mapper.MatchMapper.mapToMatchDTO;

@Service
public class MatchServiceImpl implements MatchService {
    @Autowired
    private MatchRepository matchRepository;

    @Override
    public List<MatchDTO> getAllMatches() {
        List<Match> matches = matchRepository.findAll();
        return matches.stream().map((match) -> mapToMatchDTO(match)).collect(Collectors.toList());
    }

    @Override
    public MatchDTO getMatchById(Long id) {
        Match match =  matchRepository.findById(id).get();
        return mapToMatchDTO(match);
    }

    @Override
    public Match createMatch(MatchDTO matchDTO) {
        Match match = mapToMatch(matchDTO);
        return matchRepository.save(match);
    }

    @Override
    public void updateMatch(MatchDTO matchDTO) {
        Match match = mapToMatch(matchDTO);
        matchRepository.save(match);
    }

    @Override
    public void deleteMatch(Long id) {
        matchRepository.deleteById(id);
    }

    @Override
    public MatchDTO getLatestFinishedMatch() {
        Match match = matchRepository.findLatestFinishedMatch();
        if (match != null) {
            return mapToMatchDTO(match);
        }
        return null;
    }
}
