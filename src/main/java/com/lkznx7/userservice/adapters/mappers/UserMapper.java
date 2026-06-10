package com.lkznx7.userservice.adapters.mappers;

import com.lkznx7.userservice.adapters.dto.UserResponse;
import com.lkznx7.userservice.entities.User;
import com.lkznx7.userservice.infrastructure.entity.UserJwt;

public class UserMapper {

    public static UserResponse toResponse(User domain) {
        if (domain == null) return null;
        return new UserResponse(
            domain.getId(),
            domain.getNome(),
            domain.getEmail(),
            domain.getTipo() != null ? domain.getTipo().name() : null
        );
    }

    public static UserResponse toResponseFromJwt(UserJwt infraEntity) {
        if (infraEntity == null) return null;
        // Nota: Assumindo que UserServiceJwt terá métodos similares ou será mapeado conforme evolução
        // Como UserServiceJwt está vazio no momento, deixarei a estrutura pronta para quando os campos forem adicionados
        return new UserResponse(
            null, // Implementar conforme campos de UserServiceJwt
            null,
            null,
            null
        );
    }
}
