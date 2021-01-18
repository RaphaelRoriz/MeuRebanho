package com.raphaelRoriz.meurebanho.entity;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Table(schema = "gerenciador",name = "fazenda")
public class FazendaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank
    @Size(max = 255)
    @Column(name="nome")
    @Pattern(regexp = "[A-Z a-z 0-9]*\\s*", message = "Não é permitido caracteres especiais")
    private String nome;

    @ManyToOne
    @JoinColumn(name = "id_proprietario", referencedColumnName = "id")
    private UsuarioEntity proprietario;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public UsuarioEntity getProprietario() {
        return proprietario;
    }

    public void setProprietario(UsuarioEntity proprietario) {
        this.proprietario = proprietario;
    }
}
