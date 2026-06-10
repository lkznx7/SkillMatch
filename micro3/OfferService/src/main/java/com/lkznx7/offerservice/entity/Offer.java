package com.lkznx7.offerservice.entity;

import java.math.BigDecimal;
import java.util.UUID;

public class Offer {
    private UUID id;
    private String titulo;
    private String descricao;
    private BigDecimal preco;
    private UUID profissionalId;

    public Offer() {
    }

    public Offer(UUID id, String titulo, String descricao, BigDecimal preco, UUID profissionalId) {
        this.id = id;
        this.titulo = titulo;
        this.descricao = descricao;
        this.preco = preco;
        this.profissionalId = profissionalId;
    }

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
