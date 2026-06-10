package com.lkznx7.offerservice.adapters.mapper;

import com.lkznx7.offerservice.adapters.dto.OfferRequestDTO;
import com.lkznx7.offerservice.adapters.dto.OfferResponseDTO;
import com.lkznx7.offerservice.entity.Offer;

public class OfferMapper {

    // Domain <-> Infrastructure (Database)
    public static Offer toDomain(com.lkznx7.offerservice.infrastructure.entidade.Offer infraEntity) {
        if (infraEntity == null) {
            return null;
        }

        return new Offer(
                infraEntity.getId(),
                infraEntity.getTitulo(),
                infraEntity.getDescricao(),
                infraEntity.getPreco(),
                infraEntity.getProfissionalId()
        );
    }

    public static com.lkznx7.offerservice.infrastructure.entidade.Offer toInfrastructure(Offer domainModel) {
        if (domainModel == null) {
            return null;
        }

        com.lkznx7.offerservice.infrastructure.entidade.Offer infraEntity = new com.lkznx7.offerservice.infrastructure.entidade.Offer();
        infraEntity.setId(domainModel.getId());
        infraEntity.setTitulo(domainModel.getTitulo());
        infraEntity.setDescricao(domainModel.getDescricao());
        infraEntity.setPreco(domainModel.getPreco());
        infraEntity.setProfissionalId(domainModel.getProfissionalId());

        return infraEntity;
    }

    // Domain <-> DTO (Web)
    public static OfferResponseDTO toResponseDTO(Offer domainModel) {
        if (domainModel == null) {
            return null;
        }

        return new OfferResponseDTO(
                domainModel.getId(),
                domainModel.getTitulo(),
                domainModel.getDescricao(),
                domainModel.getPreco(),
                domainModel.getProfissionalId()
        );
    }

    public static Offer toDomain(OfferRequestDTO requestDTO) {
        if (requestDTO == null) {
            return null;
        }

        return new Offer(
                requestDTO.titulo(),
                requestDTO.descricao(),
                requestDTO.preco(),
                requestDTO.profissionalId()
        );
    }
}
