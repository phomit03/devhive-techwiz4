package com.example.devhive_backend.entity;

import lombok.*;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
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

    private LocalDate date;

    private LocalTime time;

    private @Nullable String score;

    @Column(name = "soccer_info", columnDefinition = "TEXT")
    private String soccerInfo;

    private Integer status;

    @ManyToMany(mappedBy = "matches")
    private List<Team> teams;
}