package com.lkznx7.userservice.infrastructure.repository;

import com.lkznx7.userservice.infrastructure.entity.UserJwt;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
import java.util.UUID;

public interface UserJpaRepository extends JpaRepository<UserJwt, UUID> {
    Optional<UserJwt> findByEmail(String email);
}
