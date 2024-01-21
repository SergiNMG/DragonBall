package com.fpmislata.dragonball.controller.model.character;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fpmislata.dragonball.controller.model.specie.SpecieDetailWeb;
import com.fpmislata.dragonball.controller.model.technique.TechniqueListWeb;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.mapstruct.Named;

import java.util.List;
@Data
@NoArgsConstructor
public class CharacterDetailWeb {
    private Integer id;
    private String name;
    private String role;

    @JsonProperty("specie")
    private SpecieDetailWeb specieDetailWeb;
    @JsonProperty("techniques")
    private List<TechniqueListWeb> techniqueListWebList;
}
