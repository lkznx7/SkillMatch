package com.lkznx7.userservice.adapters.dto;

import java.util.UUID;

public record UserResponse(
    UUID id,
    String nome,
    String email,
    String tipo
) {}
