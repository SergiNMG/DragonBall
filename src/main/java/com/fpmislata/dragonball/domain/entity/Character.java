package com.fpmislata.dragonball.domain.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class Character {

    private Integer id;
    private String name;
    private String role;
    private Specie specie;
    private List<Technique> techniqueList;
}
