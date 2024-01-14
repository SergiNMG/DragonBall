package com.fpmislata.dragonball.domain.repository;

import com.fpmislata.dragonball.domain.entity.Character;

import java.util.List;

public interface CharacterRepository {
    long getTotalNumberOfRecords();
    List<Character> getAll(Integer page, Integer page_size);
}
