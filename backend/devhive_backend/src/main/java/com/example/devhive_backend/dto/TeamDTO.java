package com.example.devhive_backend.dto;

import com.example.devhive_backend.entity.Match;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TeamDTO {
    private Long id;

    private String name;

    private String country;

    private String logoImage;

    private Integer status;

    private List<MatchDTO> matches;
}
