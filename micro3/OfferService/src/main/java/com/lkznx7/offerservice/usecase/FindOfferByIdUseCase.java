package com.lkznx7.offerservice.usecase;

import com.lkznx7.offerservice.entity.Offer;
import com.lkznx7.offerservice.entity.repository.OfferRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class FindOfferByIdUseCase {
    private final OfferRepository offerRepository;

    public FindOfferByIdUseCase(OfferRepository offerRepository) {
        this.offerRepository = offerRepository;
    }

    public Offer execute(UUID id) {
        return offerRepository.findById(id);
    }
}
