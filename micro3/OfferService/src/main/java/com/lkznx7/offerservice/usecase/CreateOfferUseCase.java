package com.lkznx7.offerservice.usecase;

import com.lkznx7.offerservice.entity.Offer;
import com.lkznx7.offerservice.entity.repository.OfferRepository;
import org.springframework.stereotype.Service;

@Service
public class CreateOfferUseCase {
    private final OfferRepository offerRepository;

    public CreateOfferUseCase(OfferRepository offerRepository) {
        this.offerRepository = offerRepository;
    }

    public Offer execute(Offer offer) {
        return offerRepository.save(offer);
    }
}
