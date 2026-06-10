package com.lkznx7.userservice.useCase.services;

import com.lkznx7.userservice.adapters.dto.LoginRequest;
import com.lkznx7.userservice.adapters.dto.LoginResponse;
import com.lkznx7.userservice.entities.repository.UserRepository;
import com.lkznx7.userservice.infrastructure.services.tools.TokenProvider;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class LoginUseCase {
    private final UserRepository userRepository;
    private final TokenProvider tokenProvider;
    private final PasswordEncoder passwordEncoder;

    public LoginUseCase(UserRepository userRepository, TokenProvider tokenProvider, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.tokenProvider = tokenProvider;
        this.passwordEncoder = passwordEncoder;
    }

    public String executar(String email, String senha) {
        var user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Credenciais inválidas"));

        if (!passwordEncoder.matches(senha, user.getSenha())) {
            throw new RuntimeException("Credenciais inválidas");
        }

        return tokenProvider.getToken(user.getEmail());
    }
}
