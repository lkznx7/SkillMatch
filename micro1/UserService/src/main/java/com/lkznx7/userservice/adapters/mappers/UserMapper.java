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
        return new UserResponse(
            infraEntity.getId(),
            infraEntity.getNome(),
            infraEntity.getEmail(),
            infraEntity.getTipo() != null ? infraEntity.getTipo().name() : null
        );
    }

    public static User toDomain(UserJwt entity) {
        if (entity == null) return null;
        return new User(
            entity.getId(),
            entity.getNome(),
            entity.getEmail(),
            entity.getSenha(),
            entity.getTipo()
        );
    }

    public static UserJwt toJpaEntity(User domain) {
        if (domain == null) return null;
        UserJwt entity = new UserJwt(
            domain.getNome(),
            domain.getEmail(),
            domain.getSenha(),
            domain.getTipo()
        );
        entity.setId(domain.getId());
        return entity;
    }
}
