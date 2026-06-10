package com.lkznx7.userservice.entities;

import com.lkznx7.userservice.entities.enums.UserType;

import java.util.Objects;
import java.util.UUID;
public class User {
    UUID id;
    String nome;
    String email;
    String senha;
    UserType tipo;

    public User() {}
    public User(UUID id, String nome, String email, String senha, UserType tipo) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.tipo = tipo;
    }

    public UserType getTipo() {
        return tipo;
    }

    public void setTipo(UserType tipo) {
        this.tipo = tipo;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        User that = (User) o;
        return Objects.equals(id, that.id) && Objects.equals(nome, that.nome) && Objects.equals(email, that.email) && Objects.equals(senha, that.senha) && tipo == that.tipo;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, email, senha, tipo);
    }
}
