package com.condadofx.condado.model.entities;

import java.time.LocalDate;

public class Cliente {
    private String id;
    private String nome;
    private LocalDate dataNascimento;
    private String email;
    private String contato;
    
    public String getId() {
        return this.id;
    }
    public void setId(String id) {
        this.id = id;
    }
    
    public String getNome() {
        return this.nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataNascimento() {
        return this.dataNascimento;
    }
    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
    
    public String getEmail() {
        return this.email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getContato() {
        return this.contato;
    }
    public void setContato(String contato) {
        this.contato = contato;
    }
}
