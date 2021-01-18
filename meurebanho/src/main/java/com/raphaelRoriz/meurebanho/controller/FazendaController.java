package com.raphaelRoriz.meurebanho.controller;

import com.raphaelRoriz.meurebanho.Repository.FazendaRepository;
import com.raphaelRoriz.meurebanho.entity.AnimalEntity;
import com.raphaelRoriz.meurebanho.entity.FazendaEntity;
import com.raphaelRoriz.meurebanho.entity.UsuarioEntity;
import com.raphaelRoriz.meurebanho.service.AnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/fazenda")
public class FazendaController {

    @Autowired
    FazendaRepository fazendaRepository;

    @Autowired
    AnimalService animalService;

    @GetMapping("/index")
    public ResponseEntity<List<FazendaEntity>> listar(){
        List<FazendaEntity> fazendas = fazendaRepository.findAll();
        if(fazendas.isEmpty()){
            return ResponseEntity.notFound().build();
        }else{
            return ResponseEntity.ok().body(fazendas);
        }
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "/inserir")
    public FazendaEntity inserir(@Valid @RequestBody FazendaEntity fazenda){
        return fazendaRepository.save(fazenda);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/inserirAnimal/{idFazenda}")
    public ResponseEntity<Object> inserirAnimal(@PathVariable Long idFazenda, @Valid @RequestBody AnimalEntity animal){
        Optional<FazendaEntity> fazenda = fazendaRepository.findById(idFazenda);
        if(fazenda.isPresent()){
            animalService.adicionarFazenda(animal,fazenda);
            return ResponseEntity.ok().body(animal);
        }else{
            return ResponseEntity.notFound().build();
        }
    }



}
