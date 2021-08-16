package com.example.core_sesa.Entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "PESSOA")
public class Pessoa {

    @Id
    @GeneratedValue
    @JsonProperty("id")
    private Long id;

    @JsonProperty("nome")
    @Column(name = "nome", nullable = false)
    private String nome;

    @JsonProperty("sobrenome")
    @Column(name = "sobrenome", nullable = false)
    private String sobrenome;

    @JsonProperty("cpf")
    @Column(name = "cpf", nullable = false)
    private String cpf;

    @JsonProperty("contatos")
    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "contato", joinColumns = @JoinColumn(name = "id_pessoa"))
    private Set<Contato> contatos = new HashSet<>();

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public Set<Contato> getContatos() {
        return contatos;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public void setContatos(Set<Contato> contatos) {
        this.contatos = contatos;
    }
}
