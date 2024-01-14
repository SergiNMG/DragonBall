package com.fpmislata.dragonball.domain.service.impl;

import com.fpmislata.dragonball.domain.entity.Character;
import com.fpmislata.dragonball.domain.repository.CharacterRepository;
import com.fpmislata.dragonball.domain.service.CharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CharacterServiceImpl implements CharacterService {
    @Autowired
    CharacterRepository characterRepository;

    @Override
    public long getTotalNumberOfRecords() {
        return characterRepository.getTotalNumberOfRecords();
    }

    @Override
    public List<Character> getAll(Integer page, Integer page_size) {
        return characterRepository.getAll(page, page_size);
    }
}
