package com.raphaelRoriz.meurebanho.service;

import com.raphaelRoriz.meurebanho.Repository.AnimalRepository;
import com.raphaelRoriz.meurebanho.entity.AnimalEntity;
import com.raphaelRoriz.meurebanho.entity.FazendaEntity;
import com.raphaelRoriz.meurebanho.entity.UsuarioEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.Optional;

@Service
public class AnimalService {

    @Autowired
    AnimalRepository animalRepository;

    public void adicionarFazenda(@Valid AnimalEntity animal, Optional<FazendaEntity> fazenda) {
        animal.setFazenda(fazenda.get());
        animalRepository.save(animal);
    }


}
