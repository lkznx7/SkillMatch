package com.lkznx7.offerservice.usecase;

import com.lkznx7.offerservice.entity.Offer;
import com.lkznx7.offerservice.entity.repository.OfferRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CreateOfferUseCaseTest {

    @Mock
    private OfferRepository offerRepository;

    @InjectMocks
    private CreateOfferUseCase createOfferUseCase;

    @Test
    @DisplayName("Deve criar uma oferta com sucesso")
    void deveCriarOfertaComSucesso() {
        // Arrange
        UUID profissionalId = UUID.randomUUID();
        Offer inputOffer = new Offer("Título", "Descrição", new BigDecimal("100.00"), profissionalId);
        Offer savedOffer = new Offer(UUID.randomUUID(), "Título", "Descrição", new BigDecimal("100.00"), profissionalId);
        
        when(offerRepository.save(any(Offer.class))).thenReturn(savedOffer);

        // Act
        Offer result = createOfferUseCase.execute(inputOffer);

        // Assert
        assertNotNull(result.getId());
        assertEquals(inputOffer.getTitulo(), result.getTitulo());
        verify(offerRepository, times(1)).save(inputOffer);
    }
}
