package com.example.devhive_backend.controller;

import com.example.devhive_backend.dto.PlayerDTO;
import com.example.devhive_backend.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/player")
public class PlayerController {
    @Autowired
    private PlayerService playerService;
    @GetMapping("getAll")
    public ResponseEntity<List<PlayerDTO>> getAllMultiplayer() {
        List<PlayerDTO> multiplayer = playerService.getAllMultiplayer();
        return new ResponseEntity<>(multiplayer, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<PlayerDTO> getPlayerById(@PathVariable Long id) {
        PlayerDTO playerById = playerService.getPlayerById(id);
        return new ResponseEntity<>(playerById,HttpStatus.OK);
    }
    @PostMapping("/create")
    public ResponseEntity<String> createPlayer(@RequestBody PlayerDTO playerDTO) {
        playerService.createPlayer(playerDTO);
        return new ResponseEntity<>("Player created successfully",HttpStatus.CREATED);
    }
    @PostMapping("/{id}")
    public ResponseEntity<String> updatePlayer(@PathVariable("id") Long id, @RequestBody PlayerDTO playerDTO) {
        playerDTO.setId(id);
        playerService.updatePlayer(playerDTO);
        return new ResponseEntity<>("Player updated successfully",HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePlayer(@PathVariable("id") Long id) {
        playerService.deletePlayer(id);
        return new ResponseEntity<>("Player delete successfully",HttpStatus.OK);
    }

}