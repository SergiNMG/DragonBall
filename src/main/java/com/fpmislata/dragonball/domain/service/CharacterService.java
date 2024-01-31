package com.fpmislata.dragonball.domain.service;

import com.fpmislata.dragonball.domain.entity.Character;

import java.util.List;
import java.util.Optional;

public interface CharacterService {
    long getTotalNumberOfRecords();
    List<Character> getAll(Integer page, Integer page_size);
    Optional<Character> getById(Integer id);
    Character create(Character character, Integer idSpecie, List<Integer> idTechniques);
    void delete(Character character);
}
