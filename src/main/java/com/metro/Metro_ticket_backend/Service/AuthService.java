package com.metro.Metro_ticket_backend.Service;

import com.metro.Metro_ticket_backend.DTO.*;
import org.springframework.security.core.Authentication;

import org.jspecify.annotations.Nullable;

public interface AuthService {

    void register(RegisterRequest dto);

     AuthResponse login(LoginRequest request);

     UserResponse getCurrentUser(Authentication authentication);

     UserResponse updateProfile(Long id, UpdateUserRequest request, Authentication authentication);

     Object getAllUsers();
}
