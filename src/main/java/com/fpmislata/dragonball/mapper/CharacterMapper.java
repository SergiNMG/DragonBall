package com.fpmislata.dragonball.mapper;

import com.fpmislata.dragonball.controller.model.character.CharacterCreateWeb;
import com.fpmislata.dragonball.controller.model.character.CharacterDetailWeb;
import com.fpmislata.dragonball.controller.model.character.CharacterListWeb;
import com.fpmislata.dragonball.domain.entity.Character;
import com.fpmislata.dragonball.persistence.model.CharacterEntity;
import com.fpmislata.dragonball.persistence.model.TechniqueEntity;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CharacterMapper {

    CharacterMapper mapper = Mappers.getMapper(CharacterMapper.class);

    @Mapping(target = "specie", ignore = true)
    @Mapping(target = "techniqueList", ignore = true)
    @Named("toCharacter")
    Character toCharacter(CharacterEntity characterEntity);

    @Mapping(target = "specie", ignore = true)
    @Mapping(target = "techniqueList", ignore = true)
    @IterableMapping(qualifiedByName = "toCharacter")
    @Named("toCharacterList")
    List<Character> toCharacterList(List<CharacterEntity> characterEntityList);

    @IterableMapping(qualifiedByName = "toCharacterList")
    CharacterListWeb toCharacterListWeb(Character character);

    @Mapping(target = "specie", expression = "java(SpecieMapper.mapper.toSpecie(characterEntity.getSpecieEntity()))")
    @Mapping(target = "techniqueList", expression = "java(TechniqueMapper.mapper.toTechniqueList(characterEntity.getTechniqueEntityList()))")
    @Named("toCharacterWithSpeciesAndTechniques")
    Character toCharacterWithSpeciesAndTechniques(CharacterEntity characterEntity);

    @Mapping(target = "specieDetailWeb", expression = "java(SpecieMapper.mapper.toSpecieDetailWeb(character.getSpecie()))")
    @Mapping(target = "techniqueListWebList", expression = "java(TechniqueMapper.mapper.toTechniqueListWebList(character.getTechniqueList()))")
    @IterableMapping(qualifiedByName = "toCharacterWithSpeciesAndTechniques")
    CharacterDetailWeb toCharacterDetailWeb(Character character);

//    @Mapping(target = "specie", expression = "java(SpecieMapper.mapper.toSpecie(characterDetailWeb.getSpecieDetailWeb()))")
//    @Mapping(target = "techniqueList", expression = "java(TechniqueMapper.mapper.toTechniqueListSavingCharacter(characterDetailWeb.getTechniqueListWebList()))")
//    Character toCharacterSavingSpeciesAndTechniques(CharacterDetailWeb characterDetailWeb);

    @Mapping(target = "specieEntity", expression = "java(SpecieMapper.mapper.toSpecieEntity(character.getSpecie()))")
    @Mapping(target = "techniqueEntityList", expression = "java(TechniqueMapper.mapper.toTechniqueEntityList(character.getTechniqueList()))")
    CharacterEntity toCharacterEntityWithSpeciesAndTechniques(Character character);

    @Mapping(target = "specie", ignore = true)
    @Mapping(target = "techniqueList", ignore = true)
    Character toCharacter(CharacterCreateWeb characterCreateWeb);

    CharacterEntity toCharacterEntity(Character character);

    @Mapping(target = "techniqueEntityList", ignore = true)
    CharacterEntity toCharacterEntity(CharacterEntity characterEntity);

}
