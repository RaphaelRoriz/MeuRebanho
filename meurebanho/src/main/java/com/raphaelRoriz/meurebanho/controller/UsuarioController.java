package com.raphaelRoriz.meurebanho.controller;


import com.raphaelRoriz.meurebanho.Repository.FazendaRepository;
import com.raphaelRoriz.meurebanho.Repository.UsuarioRepository;
import com.raphaelRoriz.meurebanho.entity.FazendaEntity;
import com.raphaelRoriz.meurebanho.entity.UsuarioEntity;
import com.raphaelRoriz.meurebanho.service.FazendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    FazendaService fazendaService;

    @GetMapping("/index")
    public ResponseEntity<List<UsuarioEntity>> listar(){
        List<UsuarioEntity> usuarios = usuarioRepository.findAll();
        if(usuarios.isEmpty()){
            return ResponseEntity.notFound().build();
        }else{
            return ResponseEntity.ok().body(usuarios);
        }
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "/cadastrar")
    public UsuarioEntity cadastrar(@Valid @RequestBody UsuarioEntity usuario){
        return usuarioRepository.save(usuario);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping(value = "/{idUsuario}/inserirFazenda")
    public ResponseEntity<Object> inserirFazenda(@PathVariable Long idUsuario, @Valid @RequestBody FazendaEntity fazenda){
        Optional<UsuarioEntity> usuario = usuarioRepository.findById(idUsuario);
        if(usuario.isPresent()){
            fazendaService.adicionarProprietario(fazenda,usuario);
            return ResponseEntity.ok().body(fazenda);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

}
