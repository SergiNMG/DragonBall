package com.fpmislata.dragonball.controller;

import com.fpmislata.dragonball.controller.model.technique.TechniqueDetailWeb;
import com.fpmislata.dragonball.domain.entity.Technique;
import com.fpmislata.dragonball.domain.service.TechniqueService;
import com.fpmislata.dragonball.mapper.TechniqueMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/techniques")
public class TechniqueController {
    @Autowired
    TechniqueService techniqueService;
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    public Technique create(@RequestBody TechniqueDetailWeb techniqueDetailWeb){
        return techniqueService.create(TechniqueMapper.mapper.toTechnique(techniqueDetailWeb));
    }
}
