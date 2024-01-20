package com.fpmislata.dragonball.controller.model.character;

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

    private SpecieDetailWeb specie;
    private List<TechniqueListWeb> techniques;
}
