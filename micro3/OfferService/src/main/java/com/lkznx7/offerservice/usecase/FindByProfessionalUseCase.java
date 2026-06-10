package com.lkznx7.offerservice.usecase;

import com.lkznx7.offerservice.entity.Offer;
import com.lkznx7.offerservice.entity.repository.OfferRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class FindByProfessionalUseCase {
    private final OfferRepository offerRepository;

    public FindByProfessionalUseCase(OfferRepository offerRepository) {
        this.offerRepository = offerRepository;
    }

    public List<Offer> execute(UUID professionalId) {
        return offerRepository.buscarPorProfissional(professionalId);
    }
}
