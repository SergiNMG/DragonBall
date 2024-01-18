package com.fpmislata.dragonball.controller.model.character;

import com.fpmislata.dragonball.controller.model.specie.SpecieDetailWeb;
import com.fpmislata.dragonball.controller.model.technique.TechniqueListWeb;

import java.util.List;

public class CharacterDetailWeb {
    private Integer id;
    private String name;
    private String role;

    private SpecieDetailWeb specieDetailWeb;
    private List<TechniqueListWeb> techniqueListWebList;
}
