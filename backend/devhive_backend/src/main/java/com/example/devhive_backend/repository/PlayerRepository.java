package com.example.devhive_backend.repository;

import com.example.devhive_backend.entity.Player;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepository extends JpaRepository<Player , Long> {
}
