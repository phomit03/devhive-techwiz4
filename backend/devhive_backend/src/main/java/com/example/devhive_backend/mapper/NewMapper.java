package com.example.devhive_backend.mapper;

import com.example.devhive_backend.dto.NewDTO;
import com.example.devhive_backend.entity.NewEntity;

public class NewMapper {
    public static NewEntity mapToNew(NewDTO newDTO) {
        NewEntity anew = NewEntity.builder()
                .id(newDTO.getId())
                .title(newDTO.getTitle())
                .image(newDTO.getImage())
                .description(newDTO.getDescription())
                .createdAt(newDTO.getCreatedAt())
                .build();
        return anew;
    }

    public static NewDTO mapToNewDTO(NewEntity anew) {
        NewDTO newDTO = NewDTO.builder()
                .id(anew.getId())
                .title(anew.getTitle())
                .image(anew.getImage())
                .description(anew.getDescription())
                .createdAt(anew.getCreatedAt())
                .build();
        return newDTO;
    }
}
