package com.fpmislata.dragonball.persistence.repositoryImpl;

import com.fpmislata.dragonball.domain.entity.Character;
import com.fpmislata.dragonball.domain.repository.CharacterRepository;
import com.fpmislata.dragonball.persistence.model.CharacterEntity;

import java.util.List;

public class CharacterRepositoryImpl implements CharacterRepository {

    @Override
    public List<Character> getAll(Integer page, Integer page_size) {
        List<CharacterEntity> characterEntityList;

    }
}
