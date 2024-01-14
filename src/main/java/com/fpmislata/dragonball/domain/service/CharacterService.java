package com.fpmislata.dragonball.domain.service;

import com.fpmislata.dragonball.domain.entity.Character;

import java.util.List;

public interface CharacterService {
    long getTotalNumberOfRecords();
    List<Character> getAll(Integer page, Integer page_size);
}
