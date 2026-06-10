package com.lkznx7.userservice.adapters.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record LoginRequest(
    @NotBlank(message = "O email não pode estar em branco")
    @Email(message = "O email deve ser válido")
    String email,

    @NotBlank(message = "A senha não pode estar em branco")
    String senha
) {}
