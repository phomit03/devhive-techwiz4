package com.example.devhive_backend.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MatchDTO {
    private Long id;

    private LocalDate date;

    private LocalTime time;

    private String score;

    private String soccerInfo;

    private Integer status;

    private List<TeamDTO> teams;
}



