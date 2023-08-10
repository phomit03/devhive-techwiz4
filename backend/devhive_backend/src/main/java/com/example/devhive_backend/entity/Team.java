package com.example.devhive_backend.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "teams")
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String country;

    @Column(name = "logo_image")
    private String logoImage;

    private Integer status;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "teams_matches",
            joinColumns = @JoinColumn(name = "team_id"),
            inverseJoinColumns = @JoinColumn(name = "match_id")
    )
    private List<Match> matches;
}