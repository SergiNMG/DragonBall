package com.fpmislata.dragonball.controller;

import com.fpmislata.dragonball.controller.model.character.CharacterDetailWeb;
import com.fpmislata.dragonball.controller.model.character.CharacterListWeb;
import com.fpmislata.dragonball.domain.service.CharacterService;
import com.fpmislata.dragonball.http_response.Response;
import com.fpmislata.dragonball.mapper.CharacterMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
}
