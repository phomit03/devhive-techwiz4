package com.example.devhive_backend.controller;

import com.example.devhive_backend.dto.NewDTO;
import com.example.devhive_backend.service.NewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/new")
public class NewController {
    @Autowired
    private NewService newService;

    @GetMapping("getAll")
    public ResponseEntity<List<NewDTO>> getAllNews() {
        List<NewDTO> news = newService.getAllNews();
        return new ResponseEntity<>(news, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<NewDTO> getNewById(@PathVariable Long id) {
        NewDTO newById = newService.getNewById(id);
        return new ResponseEntity<>(newById,HttpStatus.OK);
    }
    @PostMapping("/create")
    public ResponseEntity<String> createNew(@RequestBody NewDTO newDTO) {
        newService.createNew(newDTO);
        return new ResponseEntity<>("New created successfully",HttpStatus.OK);
    }
    @PostMapping("/{id}")
    public ResponseEntity<String> updateNew(@PathVariable("id") Long id, @RequestBody NewDTO newDTO) {
        newDTO.setId(id);
        newService.updateNew(newDTO);
        return new ResponseEntity<>("New updated successfully",HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteNew(@PathVariable("id") Long id) {
        newService.deleteNew(id);
        return new ResponseEntity<>("New delete successfully",HttpStatus.OK);
    }

}
