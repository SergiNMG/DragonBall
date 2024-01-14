package com.fpmislata.dragonball.domain.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Technique {

    private Integer id;
    private String name;
    private String type;
    private int episode;
}
