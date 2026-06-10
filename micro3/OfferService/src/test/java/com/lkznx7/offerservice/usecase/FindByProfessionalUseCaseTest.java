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
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class FindByProfessionalUseCaseTest {

    @Mock
    private OfferRepository offerRepository;

    @InjectMocks
    private FindByProfessionalUseCase findByProfessionalUseCase;

    @Test
    @DisplayName("Deve buscar ofertas por profissional com sucesso")
    void deveBuscarPorProfissionalComSucesso() {
        // Arrange
        UUID professionalId = UUID.randomUUID();
        List<Offer> offers = List.of(
            new Offer(UUID.randomUUID(), "Oferta 1", "Desc 1", new BigDecimal("50.0"), professionalId),
            new Offer(UUID.randomUUID(), "Oferta 2", "Desc 2", new BigDecimal("75.0"), professionalId)
        );
        
        when(offerRepository.buscarPorProfissional(professionalId)).thenReturn(offers);

        // Act
        List<Offer> result = findByProfessionalUseCase.execute(professionalId);

        // Assert
        assertFalse(result.isEmpty());
        assertEquals(2, result.size());
        assertEquals(professionalId, result.get(0).getProfissionalId());
        verify(offerRepository, times(1)).buscarPorProfissional(professionalId);
    }
}
