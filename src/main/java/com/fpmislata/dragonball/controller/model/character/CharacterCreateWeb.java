package com.fpmislata.dragonball.controller.model.character;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class CharacterCreateWeb {

    public Integer id;
    public String name;
    public String role;
    public Integer id_specie;
    public List<Integer> id_techniques;

}
