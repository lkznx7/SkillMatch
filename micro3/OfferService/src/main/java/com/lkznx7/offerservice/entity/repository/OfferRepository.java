package com.lkznx7.offerservice.entity.repository;

import com.lkznx7.offerservice.entity.Offer;
import java.util.List;
import java.util.UUID;

public interface OfferRepository {
    Offer findById(UUID id);
    List<Offer> findAll();
    List<Offer> buscarPorProfissional(UUID profissionalId);
    Offer save(Offer offer);
    void deleteById(UUID id);
}
