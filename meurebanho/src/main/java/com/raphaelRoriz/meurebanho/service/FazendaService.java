package com.raphaelRoriz.meurebanho.service;

import com.raphaelRoriz.meurebanho.Repository.FazendaRepository;
import com.raphaelRoriz.meurebanho.entity.FazendaEntity;
import com.raphaelRoriz.meurebanho.entity.UsuarioEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FazendaService {

    @Autowired
    FazendaRepository fazendaRepository;


    public void adicionarProprietario(FazendaEntity fazenda, Optional<UsuarioEntity> usuario) {
        fazenda.setProprietario(usuario.get());
        fazendaRepository.save(fazenda);
    }
}
