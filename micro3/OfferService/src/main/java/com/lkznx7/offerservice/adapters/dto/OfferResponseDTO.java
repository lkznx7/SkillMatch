package com.lkznx7.offerservice.adapters.dto;

import java.math.BigDecimal;
import java.util.UUID;

public record OfferResponseDTO(
    UUID id,
    String titulo,
    String descricao,
    BigDecimal preco,
    UUID profissionalId
) {}
