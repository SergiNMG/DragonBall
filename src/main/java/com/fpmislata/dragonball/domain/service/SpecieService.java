package com.fpmislata.dragonball.domain.service;

import com.fpmislata.dragonball.domain.entity.Specie;

import java.util.Optional;

public interface SpecieService {
//    Optional<Specie> getById(Integer id);
//    Optional<Specie> getByCharacter_Id(Integer characterId);
    Specie create(Specie specie);
}
