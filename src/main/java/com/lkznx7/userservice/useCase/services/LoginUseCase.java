package com.lkznx7.userservice.useCase.services;

import com.lkznx7.userservice.infrastructure.services.tools.TokenProvider;

public class LoginUseCase {
    TokenProvider tokenProvider;
    public LoginUseCase(TokenProvider tokenProvider) {
        this.tokenProvider = tokenProvider;
    }

}
