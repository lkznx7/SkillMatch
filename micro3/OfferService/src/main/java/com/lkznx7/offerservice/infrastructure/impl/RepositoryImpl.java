package com.lkznx7.offerservice.infrastructure.impl;

import com.lkznx7.offerservice.adapters.mapper.OfferMapper;
import com.lkznx7.offerservice.entity.Offer;
import com.lkznx7.offerservice.entity.repository.OfferRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Repository
public class RepositoryImpl implements OfferRepository {

    private final SpringDataOfferRepository springDataOfferRepository;

    public RepositoryImpl(SpringDataOfferRepository springDataOfferRepository) {
        this.springDataOfferRepository = springDataOfferRepository;
    }

    @Override
    public Offer findById(UUID id) {
        return springDataOfferRepository.findById(id)
                .map(OfferMapper::toDomain)
                .orElseThrow(() -> new RuntimeException("Offer not found"));
    }

    @Override
    public List<Offer> findAll() {
        return springDataOfferRepository.findAll().stream()
                .map(OfferMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public List<Offer> buscarPorProfissional(UUID profissionalId) {
        return springDataOfferRepository.findByProfissionalId(profissionalId).stream()
                .map(OfferMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public Offer save(Offer offer) {
        com.lkznx7.offerservice.infrastructure.entidade.Offer entity = OfferMapper.toInfrastructure(offer);
        com.lkznx7.offerservice.infrastructure.entidade.Offer savedEntity = springDataOfferRepository.save(entity);
        return OfferMapper.toDomain(savedEntity);
    }

    @Override
    public void deleteById(UUID id) {
        springDataOfferRepository.deleteById(id);
    }
}
