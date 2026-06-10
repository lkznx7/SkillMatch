package com.lkznx7.userservice.infrastructure.entity;

import com.lkznx7.userservice.entities.enums.UserType;
import jakarta.persistence.*;
import org.jspecify.annotations.Nullable;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "tb_users")
public class UserJwt implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    UUID id;
    String nome;
    String email;
    String senha;
    UserType tipo;
    public UserJwt(){}
    public UserJwt(String nome, String email, String senha, UserType tipo) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.tipo = tipo;
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if (this.tipo != null) {
            List<GrantedAuthority> authorities = new ArrayList<>();
            String roleNome = "ROLE_" + this.tipo.name();
            authorities.add(new SimpleGrantedAuthority(roleNome));

            return authorities;
        }
        return List.of();
    }
    @Override
    public @Nullable String getPassword() {
        return this.senha;
    }
    @Override
    public String getUsername() {
        return this.email;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public UserType getTipo() {
        return tipo;
    }

    public void setTipo(UserType tipo) {
        this.tipo = tipo;
    }
}
