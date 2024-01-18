package com.fpmislata.dragonball.mapper;

import com.fpmislata.dragonball.controller.model.character.CharacterDetailWeb;
import com.fpmislata.dragonball.controller.model.character.CharacterListWeb;
import com.fpmislata.dragonball.domain.entity.Character;
import com.fpmislata.dragonball.persistence.model.CharacterEntity;
import com.fpmislata.dragonball.persistence.model.TechniqueEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CharacterMapper {

    CharacterMapper mapper = Mappers.getMapper(CharacterMapper.class);

    @Mapping(target = "specie", ignore = true)
    @Mapping(target = "techniqueList", ignore = true)
    Character toCharacter(CharacterEntity characterEntity);

    @Mapping(target = "specie", ignore = true)
    @Mapping(target = "techniqueList", ignore = true)
    List<Character> toCharacterList(List<CharacterEntity> characterEntityList);

    CharacterListWeb toCharacterListWeb(Character character);

    @Mapping(target = "specie", expression = "java(SpecieMapper.mapper.toSpecie(characterEntity.getSpecieEntity()))")
    @Mapping(target = "techniqueList", expression = "java(TechniqueMapper.mapper.toTechniqueList(characterEntity.getTechniqueEntityList()))")
    Character toCharacterWithSpeciesAndTechniques(CharacterEntity characterEntity);

    @Mapping(target = "specieDetailWeb", expression = "java(SpecieMapper.mapper.toSpecieDetailWeb(character.getSpecie()))")
    @Mapping(target = "techniqueListWebList", expression = "java(TechniqueMapper.mapper.toTechniqueListWebList(character.getTechniqueList()))")
    CharacterDetailWeb toCharacterDetailWeb(Character character);
}
