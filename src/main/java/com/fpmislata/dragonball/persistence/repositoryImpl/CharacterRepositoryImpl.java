package com.fpmislata.dragonball.persistence.repositoryImpl;

import com.fpmislata.dragonball.domain.entity.Character;
import com.fpmislata.dragonball.domain.repository.CharacterRepository;
import com.fpmislata.dragonball.mapper.CharacterMapper;
import com.fpmislata.dragonball.persistence.dao.CharacterDAO;
import com.fpmislata.dragonball.persistence.model.CharacterEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CharacterRepositoryImpl implements CharacterRepository {
    @Autowired
    CharacterDAO characterDAO;
    @Override
    public long getTotalNumberOfRecords(){
        return characterDAO.count();
    }
    @Override
    public List<Character> getAll(Integer page, Integer page_size) {
        List<CharacterEntity> characterEntityList;
        if(page != null){
            Pageable pageable = PageRequest.of(page - 1, page_size);
            characterEntityList = characterDAO.findAll(pageable).stream().toList();
        } else {
            characterEntityList = characterDAO.findAll();
        }
        return CharacterMapper.mapper.toCharacterList(characterEntityList);
    }

    public Optional<Character> getById(Integer id){
        CharacterEntity characterEntity = characterDAO.findById(id).orElse(null);
        return characterEntity == null ? Optional.empty() : Optional.of(CharacterMapper.mapper.toCharacterWithSpeciesAndTechniques(characterEntity));
    }

    public Character create(Character character){
        CharacterEntity characterEntity = characterDAO.save(CharacterMapper.mapper.toCharacterEntity(character));
        return CharacterMapper.mapper.toCharacterWithSpeciesAndTechniques(characterEntity);
    }
}
