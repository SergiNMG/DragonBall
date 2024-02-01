package com.fpmislata.dragonball.domain.service.impl;

import com.fpmislata.dragonball.domain.entity.Character;
import com.fpmislata.dragonball.domain.entity.Specie;
import com.fpmislata.dragonball.domain.entity.Technique;
import com.fpmislata.dragonball.domain.repository.CharacterRepository;
import com.fpmislata.dragonball.domain.repository.SpecieRepository;
import com.fpmislata.dragonball.domain.repository.TechniqueRepository;
import com.fpmislata.dragonball.domain.service.CharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CharacterServiceImpl implements CharacterService {
    @Autowired
    CharacterRepository characterRepository;

    @Autowired
    SpecieRepository specieRepository;

    @Autowired
    TechniqueRepository techniqueRepository;

    @Override
    public long getTotalNumberOfRecords() {
        return characterRepository.getTotalNumberOfRecords();
    }

    @Override
    public List<Character> getAll(Integer page, Integer page_size) {
        return characterRepository.getAll(page, page_size);
    }

    @Override
    public Optional<Character> getById(Integer id) {
        //System.out.println(characterRepository.getById(id));
        return characterRepository.getById(id);
    }

    @Override
    public Character create(Character character, Integer id_specie, List<Integer> id_techniques) {

        Specie specie = specieRepository.getById(id_specie).orElseThrow();
//        id_techniques.forEach(
//                id -> character.setTechnique(techniqueRepository.getById(id).orElse(null))
//        );
        List<Technique> techniqueList = id_techniques.stream()
                .map(id_technique -> techniqueRepository.getById(id_technique)
                        .orElseThrow())
                .toList();

        character.setSpecie(specie);
        character.setTechniqueList(techniqueList);

        //System.out.println(character);
        return characterRepository.save(character);
    }

    public Character update(Character characterUpdated){
        Specie specieUpdated = specieRepository.save(characterUpdated.getSpecie());
        List<Technique> techniqueUpdatedList = characterUpdated.getTechniqueList().stream()
                .map(technique -> techniqueRepository.save(technique))
                .toList();

        characterUpdated.setSpecie(specieUpdated);
        characterUpdated.setTechniqueList(techniqueUpdatedList);

        return characterRepository.save(characterUpdated);
    }

    public void delete(Character character){
        characterRepository.delete(character);
    }

}
