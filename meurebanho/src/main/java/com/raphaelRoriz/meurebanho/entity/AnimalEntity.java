package com.raphaelRoriz.meurebanho.entity;

import org.springframework.context.annotation.Lazy;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Table(schema = "gerenciador",name = "animal")
public class AnimalEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank
    @Size(min = 8,max = 8)
    @Digits(integer=8,fraction = 0, message = "São necessários 8 dígitos")
    @Column(name="registro")
    private String registro;


    @Size(max = 255)
    @Column(name="especie")
    @Pattern(regexp = "[A-Z a-z ]*\\s*", message = "Não é permitido caracteres especiais e números")
    private String especie;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_fazenda", referencedColumnName = "id")
    private FazendaEntity fazenda;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getRegistro() {
        return registro;
    }

    public void setRegistro(String registro) {
        this.registro = registro;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public FazendaEntity getFazenda() {
        return fazenda;
    }

    public Long getIdFazenda(){
        return this.getFazenda().getId();
    }

    public void setFazenda(FazendaEntity fazenda) {
        this.fazenda = fazenda;
    }
}
