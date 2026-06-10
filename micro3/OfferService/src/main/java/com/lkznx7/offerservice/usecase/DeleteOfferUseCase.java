package com.lkznx7.offerservice.usecase;

import com.lkznx7.offerservice.entity.repository.OfferRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class DeleteOfferUseCase {
    private final OfferRepository offerRepository;

    public DeleteOfferUseCase(OfferRepository offerRepository) {
        this.offerRepository = offerRepository;
    }

    public void execute(UUID id) {
        offerRepository.deleteById(id);
    }
}
