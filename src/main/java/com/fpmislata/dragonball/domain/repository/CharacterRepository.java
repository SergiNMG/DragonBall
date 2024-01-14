package com.fpmislata.dragonball.domain.repository;

import com.fpmislata.dragonball.domain.entity.Character;

import java.util.List;

public interface CharacterRepository {
    List<Character> getAll(Integer page, Integer page_size);
}
