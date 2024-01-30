package com.fpmislata.dragonball.controller;

import com.fpmislata.dragonball.controller.model.character.CharacterCreateWeb;
import com.fpmislata.dragonball.controller.model.character.CharacterDetailWeb;
import com.fpmislata.dragonball.controller.model.character.CharacterListWeb;
import com.fpmislata.dragonball.controller.model.specie.SpecieDetailWeb;
import com.fpmislata.dragonball.controller.model.technique.TechniqueDetailWeb;
import com.fpmislata.dragonball.controller.model.technique.TechniqueListWeb;
import com.fpmislata.dragonball.domain.entity.Character;
import com.fpmislata.dragonball.domain.entity.Specie;
import com.fpmislata.dragonball.domain.entity.Technique;
import com.fpmislata.dragonball.domain.service.CharacterService;
import com.fpmislata.dragonball.domain.service.SpecieService;
import com.fpmislata.dragonball.domain.service.TechniqueService;
import com.fpmislata.dragonball.http_response.Response;
import com.fpmislata.dragonball.mapper.CharacterMapper;
import com.fpmislata.dragonball.mapper.SpecieMapper;
import com.fpmislata.dragonball.mapper.TechniqueMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/characters")
public class CharacterController {
    @Value("${buildPagination.defaultPageSize}")
    private Integer page_size_default;
    @Value("${app.url}")
    private String url;

    @Autowired
    CharacterService characterService;
    @Autowired
    SpecieService specieService;
    @Autowired
    TechniqueService techniqueService;
    @Autowired
    CharacterMapper characterMapper;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("")
    public Response getAll(@RequestParam(required = false)Integer page, @RequestParam(required = false) Integer page_size){
        long total_records = characterService.getTotalNumberOfRecords();
        if(page_size == null){
            page_size = page_size_default;
        }

        List<CharacterListWeb> characterListWeb = characterService.getAll(page, page_size)
                .stream()
                .map(characterMapper::toCharacterListWeb)
                .toList();

        return new Response(characterListWeb, total_records, page, page_size, url);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    public CharacterDetailWeb getById(@PathVariable("id")Integer id){
        return CharacterMapper.mapper.toCharacterDetailWeb(characterService.getById(id).orElseThrow());
    }

//    @ResponseStatus(HttpStatus.OK)
//    @GetMapping("/{id}")
//    public Response getById(@PathVariable("id")Integer id){
//        CharacterDetailWeb characterDetailWeb = CharacterMapper.mapper.toCharacterDetailWeb(characterService.getById(id).orElseThrow());
//        return new Response(characterDetailWeb);
//    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public CharacterDetailWeb create(@RequestBody CharacterCreateWeb characterCreateWeb){
        //characterService.create(CharacterMapper.mapper.toCharacter(characterCreateWeb));
        /*Specie specie = specieService.getById(characterCreateWeb.getId_specie()).orElseThrow();
        SpecieDetailWeb specieDetailWeb = SpecieMapper.mapper.toSpecieDetailWeb(specie);


        List<Technique> techniqueList = characterCreateWeb.getId_techniques().stream()
                .map(id_technique -> techniqueService.getById(id_technique)
                        .orElseThrow(() -> new RuntimeException("Técnica no encontrada: " + id_technique)))
                .toList();
        List<TechniqueListWeb> techniqueListWebList = TechniqueMapper.mapper.toTechniqueListWebList(techniqueList);

        CharacterDetailWeb characterCreated = new CharacterDetailWeb();
        characterCreated.setName(characterCreateWeb.getName());
        characterCreated.setRole(characterCreateWeb.getRole());
        characterCreated.setSpecieDetailWeb(specieDetailWeb);
        characterCreated.setTechniqueListWebList(techniqueListWebList);

        characterService.create(CharacterMapper.mapper.toCharacterSavingSpeciesAndTechniques(characterCreated));
        return characterCreated;*/
        Character character = CharacterMapper.mapper.toCharacter(characterCreateWeb);
        Character newCharacter = characterService.create(character, characterCreateWeb.getId_specie(), characterCreateWeb.getId_techniques());
        return CharacterMapper.mapper.toCharacterDetailWeb(newCharacter);
    }
}
