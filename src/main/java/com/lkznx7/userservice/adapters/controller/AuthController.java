package com.lkznx7.userservice.adapters.controller;

import com.lkznx7.userservice.adapters.dto.LoginRequest;
import com.lkznx7.userservice.adapters.dto.LoginResponse;
import com.lkznx7.userservice.useCase.services.LoginUseCase;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final LoginUseCase loginUseCase;

    public AuthController(LoginUseCase loginUseCase) {
        this.loginUseCase = loginUseCase;
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@Valid @RequestBody LoginRequest request) {
        String token = loginUseCase.executar(request.email(), request.senha());
        
        LoginResponse response = new LoginResponse(
            token,
            "Bearer",
            43200000L
        );
        
        return ResponseEntity.ok(response);
    }
}
