package com.fpmislata.dragonball.domain.service.impl;

import com.fpmislata.dragonball.domain.entity.Technique;
import com.fpmislata.dragonball.domain.repository.TechniqueRepository;
import com.fpmislata.dragonball.domain.service.TechniqueService;
import com.fpmislata.dragonball.mapper.TechniqueMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TechniqueServiceImpl implements TechniqueService {
    @Autowired
    TechniqueRepository techniqueRepository;
    public Optional<Technique> getById(Integer id) {
        return techniqueRepository.getById(id);
    }
    public Technique create(Technique technique){
        return techniqueRepository.save(technique);
    }

    public Technique update(Technique techniqueUpdated){
        Technique technique = techniqueRepository.getById(techniqueUpdated.getId()).orElseThrow();
        technique.setName(techniqueUpdated.getName());
        technique.setType(techniqueUpdated.getType());
        technique.setEpisode(techniqueUpdated.getEpisode());
        return techniqueRepository.save(technique);
    }
}
