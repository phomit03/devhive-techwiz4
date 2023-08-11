package com.example.devhive_backend.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class NewDTO {
    private Long id;
    private String title;
    private String image;
    private String description;
}
