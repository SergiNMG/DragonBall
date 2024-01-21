package com.fpmislata.dragonball.domain.repository;

import com.fpmislata.dragonball.domain.entity.Character;
import com.fpmislata.dragonball.persistence.model.CharacterEntity;

import java.util.List;
import java.util.Optional;

public interface CharacterRepository {
    long getTotalNumberOfRecords();
    List<Character> getAll(Integer page, Integer page_size);
    Optional<Character> getById(Integer id);
    Character create(Character character);
}
