package com.lkznx7.offerservice.usecase;

import com.lkznx7.offerservice.entity.Offer;
import com.lkznx7.offerservice.entity.repository.OfferRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FindAllOffersUseCase {
    private final OfferRepository offerRepository;

    public FindAllOffersUseCase(OfferRepository offerRepository) {
        this.offerRepository = offerRepository;
    }

    public List<Offer> execute() {
        return offerRepository.findAll();
    }
}
