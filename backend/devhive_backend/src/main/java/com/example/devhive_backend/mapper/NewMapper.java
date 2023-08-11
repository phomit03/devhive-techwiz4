package com.example.devhive_backend.mapper;

import com.example.devhive_backend.dto.NewDTO;
import com.example.devhive_backend.entity.New;

public class NewMapper {
    public static New mapToNew(NewDTO newDTO) {
        New anew = New.builder()
                .id(newDTO.getId())
                .title(newDTO.getTitle())
                .image(newDTO.getImage())
                .build();
        return anew;
    }

    public static NewDTO mapToNewDTO(New anew) {
        NewDTO newDTO = NewDTO.builder()
                .id(anew.getId())
                .title(anew.getTitle())
                .image(anew.getImage())
                .build();
        return newDTO;
    }
}
