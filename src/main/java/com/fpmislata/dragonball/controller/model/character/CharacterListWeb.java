package com.fpmislata.dragonball.controller.model.character;

import com.fpmislata.dragonball.controller.model.specie.SpecieDetailWeb;
import com.fpmislata.dragonball.controller.model.technique.TechniqueListWeb;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class CharacterListWeb {

    private Integer id;
    private String name;
    private String role;

}
