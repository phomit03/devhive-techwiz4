package com.example.devhive_backend.service;

import com.example.devhive_backend.dto.PlayerDTO;
import com.example.devhive_backend.entity.Player;

import java.util.List;

public interface PlayerService {
    PlayerDTO getPlayerById(Long id);

    List<PlayerDTO> getAllMultiplayer();

    Player createPlayer(PlayerDTO playerDTO);

    void updatePlayer(PlayerDTO playerDTO);

    void deletePlayer(Long id);
}
