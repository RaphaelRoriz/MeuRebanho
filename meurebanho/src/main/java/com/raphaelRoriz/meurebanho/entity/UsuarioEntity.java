package com.raphaelRoriz.meurebanho.entity;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Table(schema = "gerenciador",name = "usuario")
public class UsuarioEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank
    @Size(min = 11)
    @Digits(integer=11,fraction = 0, message = "É permitido apenas 11 numeros")
    @Column(name="cpf")
    private String cpf;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}
