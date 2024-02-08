package com.fpmislata.dragonball.domain.service;

import com.fpmislata.dragonball.domain.entity.Specie;
import com.fpmislata.dragonball.domain.entity.Technique;

import java.util.List;
import java.util.Optional;

public interface SpecieService {
//    Optional<Specie> getByCharacter_Id(Integer characterId);
    Optional<Specie> getById(Integer id);
    Specie create(Specie specie);
    Specie update(Specie specieUpdated);
    void delete(Specie specie);
    List<Specie> getByName(String name);
}
