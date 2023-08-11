package com.example.devhive_backend.dto;

import com.example.devhive_backend.entity.Team;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PlayerDTO {
    private Long id;
    private String name;
    private LocalDateTime dateOfBirth;
    private String nationality;
    private String position;
    private String achievements;
    private Integer status;
    private Team team;

}
