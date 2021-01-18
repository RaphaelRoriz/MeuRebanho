package com.raphaelRoriz.meurebanho.controller;

import com.raphaelRoriz.meurebanho.Repository.AnimalRepository;
import com.raphaelRoriz.meurebanho.entity.AnimalEntity;
import com.raphaelRoriz.meurebanho.entity.UsuarioEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/animal")
public class AnimalController {

    @Autowired
    AnimalRepository animalRepository;

    @GetMapping("/index")
    public ResponseEntity<List<AnimalEntity>> listar(){
        List<AnimalEntity> animais = animalRepository.findAll();
        if(animais.isEmpty()){
            return ResponseEntity.notFound().build();
        }else{
            return ResponseEntity.ok().body(animais);
        }
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "/cadastrar")
    public AnimalEntity cadastrar(@Valid @RequestBody AnimalEntity animal){
        return animalRepository.save(animal);
    }
}
