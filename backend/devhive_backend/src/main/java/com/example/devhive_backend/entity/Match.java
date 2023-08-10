package com.example.devhive_backend.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "matches")
public class Match {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String date;

    private String time;

    private String score;

    @Column(name = "soccer_info", columnDefinition = "TEXT")
    private String soccerInfo;

    private Integer status;

    @ManyToMany(mappedBy = "matches")
    private List<Team> teams;
}