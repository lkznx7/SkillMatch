package com.lkznx7.offerservice.adapters.controller;

import com.lkznx7.offerservice.adapters.dto.OfferRequestDTO;
import com.lkznx7.offerservice.adapters.dto.OfferResponseDTO;
import com.lkznx7.offerservice.adapters.mapper.OfferMapper;
import com.lkznx7.offerservice.entity.Offer;
import com.lkznx7.offerservice.usecase.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/offers")
public class OfferController {

    private final CreateOfferUseCase createOfferUseCase;
    private final FindOfferByIdUseCase findOfferByIdUseCase;
    private final FindAllOffersUseCase findAllOffersUseCase;
    private final FindByProfessionalUseCase findByProfessionalUseCase;
    private final DeleteOfferUseCase deleteOfferUseCase;

    public OfferController(
            CreateOfferUseCase createOfferUseCase,
            FindOfferByIdUseCase findOfferByIdUseCase,
            FindAllOffersUseCase findAllOffersUseCase,
            FindByProfessionalUseCase findByProfessionalUseCase,
            DeleteOfferUseCase deleteOfferUseCase) {
        this.createOfferUseCase = createOfferUseCase;
        this.findOfferByIdUseCase = findOfferByIdUseCase;
        this.findAllOffersUseCase = findAllOffersUseCase;
        this.findByProfessionalUseCase = findByProfessionalUseCase;
        this.deleteOfferUseCase = deleteOfferUseCase;
    }

    @PostMapping
    public ResponseEntity<OfferResponseDTO> create(@RequestBody OfferRequestDTO requestDTO) {
        Offer offer = OfferMapper.toDomain(requestDTO);
        Offer savedOffer = createOfferUseCase.execute(offer);
        return ResponseEntity.status(HttpStatus.CREATED).body(OfferMapper.toResponseDTO(savedOffer));
    }

    @GetMapping("/{id}")
    public ResponseEntity<OfferResponseDTO> findById(@PathVariable UUID id) {
        Offer offer = findOfferByIdUseCase.execute(id);
        return ResponseEntity.ok(OfferMapper.toResponseDTO(offer));
    }

    @GetMapping
    public ResponseEntity<List<OfferResponseDTO>> findAll() {
        List<OfferResponseDTO> offers = findAllOffersUseCase.execute().stream()
                .map(OfferMapper::toResponseDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(offers);
    }

    @GetMapping("/professional/{professionalId}")
    public ResponseEntity<List<OfferResponseDTO>> findByProfessional(@PathVariable UUID professionalId) {
        List<OfferResponseDTO> offers = findByProfessionalUseCase.execute(professionalId).stream()
                .map(OfferMapper::toResponseDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(offers);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        deleteOfferUseCase.execute(id);
        return ResponseEntity.noContent().build();
    }
}
