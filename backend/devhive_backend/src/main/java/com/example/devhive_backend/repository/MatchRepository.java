package com.example.devhive_backend.repository;

import com.example.devhive_backend.entity.Match;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface MatchRepository extends JpaRepository<Match,Long> {
    @Query(value = "SELECT * FROM matches WHERE score IS NOT NULL ORDER BY date DESC, time DESC LIMIT 1", nativeQuery = true)
    Match findLatestFinishedMatch();
}