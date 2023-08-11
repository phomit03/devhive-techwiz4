package com.example.devhive_backend.service.impl;

import com.example.devhive_backend.dto.PlayerDTO;
import com.example.devhive_backend.entity.Player;
import com.example.devhive_backend.repository.PlayerRepository;
import com.example.devhive_backend.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import static com.example.devhive_backend.mapper.PlayerMapper.mapToPlayer;
import static com.example.devhive_backend.mapper.PlayerMapper.mapToPlayerDTO;

@Service
public class PlayerServiceImpl implements PlayerService {
    @Autowired
    private PlayerRepository playerRepository;

    @Override
    public List<PlayerDTO> getAllMultiplayer() {
        List<Player> multiPlayer = playerRepository.findAll();
        return multiPlayer.stream().map((player) -> mapToPlayerDTO(player)).collect(Collectors.toList());
    }

    @Override
    public PlayerDTO getPlayerById(Long id) {
        Player player =  playerRepository.findById(id).get();
        return mapToPlayerDTO(player);
    }
    @Override
    public Player createPlayer(PlayerDTO playerDTO) {
        Player player = mapToPlayer(playerDTO);
        return playerRepository.save(player);
    }

    @Override
    public void updatePlayer(PlayerDTO playerDTO) {
        Player player = mapToPlayer(playerDTO);
        playerRepository.save(player);
    }

    @Override
    public void deletePlayer(Long id) {
        playerRepository.deleteById(id);
    }
}
