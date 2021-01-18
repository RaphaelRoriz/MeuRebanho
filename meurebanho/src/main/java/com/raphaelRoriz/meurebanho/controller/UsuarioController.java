package com.raphaelRoriz.meurebanho.controller;


import com.raphaelRoriz.meurebanho.Repository.UsuarioRepository;
import com.raphaelRoriz.meurebanho.entity.UsuarioEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    UsuarioRepository usuarioRepository;

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
    @PostMapping(value = "/inserir")
    public UsuarioEntity inserir(@Valid @RequestBody UsuarioEntity usuario){
        return usuarioRepository.save(usuario);
    }
    

}
