package com.fpmislata.dragonball.domain.service.impl;

import com.fpmislata.dragonball.domain.entity.Technique;
import com.fpmislata.dragonball.domain.repository.TechniqueRepository;
import com.fpmislata.dragonball.domain.service.TechniqueService;
import com.fpmislata.dragonball.mapper.TechniqueMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TechniqueServiceImpl implements TechniqueService {
    @Autowired
    TechniqueRepository techniqueRepository;

    @Override
    public List<Technique> getByCharacter_Id(Integer characterId) {
        return techniqueRepository.getByCharacters_Id(characterId);
    }
}
