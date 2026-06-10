package com.lkznx7.userservice.adapters.dto;

public record LoginResponse(
    String token,
    String tipo,
    long expiraEmMillis
) {}
