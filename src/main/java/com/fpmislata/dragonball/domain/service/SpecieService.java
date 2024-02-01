package com.fpmislata.dragonball.domain.service;

import com.fpmislata.dragonball.domain.entity.Specie;

import java.util.Optional;

public interface SpecieService {
//    Optional<Specie> getByCharacter_Id(Integer characterId);
    Optional<Specie> getById(Integer id);
    Specie create(Specie specie);
    Specie update(Specie specieUpdated);
    void delete(Specie specie);
}
