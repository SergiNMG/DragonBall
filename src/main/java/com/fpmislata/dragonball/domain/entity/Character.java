package com.fpmislata.dragonball.domain.entity;

import com.fpmislata.dragonball.domain.validations.ValidTechniqueListSize;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class Character {

    private Integer id;
    private String name;
    private String role;
    @NotNull
    private Specie specie;
    @NotNull
    private List<Technique> techniqueList;

    public void setTechnique(Technique technique) {
        if(techniqueList == null) {
            techniqueList = new ArrayList<>();
        }
        techniqueList.add(technique);
    }
}
