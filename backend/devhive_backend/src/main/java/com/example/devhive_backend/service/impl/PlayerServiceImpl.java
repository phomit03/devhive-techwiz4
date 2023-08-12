package com.example.devhive_backend.service.impl;

import com.example.devhive_backend.dto.PlayerDTO;
import com.example.devhive_backend.entity.Player;
import com.example.devhive_backend.repository.PlayerRepository;
import com.example.devhive_backend.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
        List<PlayerDTO> playerDTOList = this.transfer(multiPlayer);
        return playerDTOList;
    }

    private List<PlayerDTO> transfer(List<Player> players) {
        List<PlayerDTO> playerDTOList = new ArrayList<>();
        for (Player player : players) {
            PlayerDTO playerDTO = new PlayerDTO();
            playerDTO.setId(player.getId());
            playerDTO.setName(player.getName());
            playerDTO.setNationality(player.getNationality());
            playerDTO.setDateOfBirth(player.getDateOfBirth());
            playerDTO.setPosition(player.getPosition());
            playerDTO.setAchievements(player.getAchievements());
            playerDTO.setStatus(player.getStatus());
            playerDTO.setTeam(player.getTeam());
            playerDTOList.add(playerDTO);
        }
        return playerDTOList;
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
