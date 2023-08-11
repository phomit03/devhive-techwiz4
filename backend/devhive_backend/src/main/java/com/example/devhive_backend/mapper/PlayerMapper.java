package com.example.devhive_backend.mapper;

import com.example.devhive_backend.dto.PlayerDTO;
import com.example.devhive_backend.dto.ProductDTO;
import com.example.devhive_backend.entity.Player;
import com.example.devhive_backend.entity.Product;

public class PlayerMapper {
    public static Player mapToPlayer(PlayerDTO playerDTO) {
        return Player.builder()
                .id(playerDTO.getId())
                .name(playerDTO.getName())
                .dateOfBirth(playerDTO.getDateOfBirth())
                .nationality(playerDTO.getNationality())
                .position(playerDTO.getPosition())
                .achievements(playerDTO.getAchievements())
                .status(playerDTO.getStatus())
                .team(playerDTO.getTeam())
                .build();
    }
    public static PlayerDTO mapToPlayerDTO(Player player) {
        return PlayerDTO.builder()
                .id(player.getId())
                .name(player.getName())
                .dateOfBirth(player.getDateOfBirth())
                .nationality(player.getNationality())
                .position(player.getPosition())
                .achievements(player.getAchievements())
                .status(player.getStatus())
                .team(player.getTeam())
                .build();
    }
}
