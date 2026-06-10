package com.lkznx7.offerservice.infrastructure.entidade;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
public class Offer {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    UUID id;
    String titulo;
    String descricao;
    BigDecimal preco;
    UUID profissionalId;

    public Offer (){}

    public Offer(String titulo, String descricao, BigDecimal preco, UUID profissionalId) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.preco = preco;
        this.profissionalId = profissionalId;

    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public UUID getProfissionalId() {
        return profissionalId;
    }

    public void setProfissionalId(UUID profissionalId) {
        this.profissionalId = profissionalId;
    }
}
