package com.example.devhive_backend.service;

import com.example.devhive_backend.dto.NewDTO;
import com.example.devhive_backend.entity.New;

import java.util.List;

public interface NewService {
    List<NewDTO> getAllNews();

    NewDTO getNewById(Long id);

    New createNew(NewDTO newDTO);

    void updateNew(NewDTO newDTO);

    void deleteNew(Long id);
}
