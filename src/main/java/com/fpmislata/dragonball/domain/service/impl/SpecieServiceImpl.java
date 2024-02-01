package com.fpmislata.dragonball.domain.service.impl;

import com.fpmislata.dragonball.domain.entity.Specie;
import com.fpmislata.dragonball.domain.entity.Technique;
import com.fpmislata.dragonball.domain.repository.SpecieRepository;
import com.fpmislata.dragonball.domain.service.SpecieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SpecieServiceImpl implements SpecieService {
    @Autowired
    SpecieRepository specieRepository;
    @Override
    public Optional<Specie> getById(Integer id) {
        return specieRepository.getById(id);
    }
    @Override
    public Specie create(Specie specie) {
        return specieRepository.save(specie);
    }
    @Override
    public Specie update(Specie specieUpdated){
        Specie specie = specieRepository.getById(specieUpdated.getId()).orElseThrow();
        specie.setName(specieUpdated.getName());
        specie.setOrigin(specieUpdated.getOrigin());
        return specieRepository.save(specie);
    }
    @Override
    public void delete(Specie specie) {
        specieRepository.delete(specie);
    }

//    @Override
//    public Optional<Specie> getByCharacter_Id(Integer characterId) {
//        return specieRepository.getByCharacters_Id(characterId);
//    }
}
