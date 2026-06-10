package com.lkznx7.offerservice.infrastructure.impl;

import com.lkznx7.offerservice.infrastructure.entidade.Offer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface SpringDataOfferRepository extends JpaRepository<Offer, UUID> {
    List<Offer> findByProfissionalId(UUID profissionalId);
}
