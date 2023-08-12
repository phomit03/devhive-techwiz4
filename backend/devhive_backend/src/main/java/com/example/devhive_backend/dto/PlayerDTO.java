package com.example.devhive_backend.dto;

import com.example.devhive_backend.entity.Team;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PlayerDTO {
    private Long id;
    private String name;
    private Date dateOfBirth;
    private String nationality;
    private String position;
    private String achievements;
    private Integer status;
    private Team team;

}
