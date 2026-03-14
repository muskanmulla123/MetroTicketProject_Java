package com.metro.Metro_ticket_backend.controller;

import com.metro.Metro_ticket_backend.DTO.*;
import com.metro.Metro_ticket_backend.Service.AuthService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService authService;
//this is register api
    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterRequest dto)
    {
        authService.register(dto);
        return ResponseEntity.ok("user registered");
    }

    //this is login api
    @PostMapping("/login")
     public ResponseEntity<?>login(@RequestBody LoginRequest request)
     {
          return ResponseEntity.ok(authService.login(request));
     }
//this is fot geting current user
    @GetMapping("/current-user")
    @PreAuthorize("hasAnyRole('USER','ADMIN')")
    public ResponseEntity<UserResponse> getCurrentUser(Authentication authentication) {
        return ResponseEntity.ok(authService.getCurrentUser(authentication));
    }

    //this is for updating

    @PutMapping("/profile/{id}")
    @PreAuthorize("hasAnyRole('USER','ADMIN')")
    public ResponseEntity<UserResponse> updateProfile(
            @PathVariable Long id,
            @RequestBody UpdateUserRequest request,
            Authentication authentication
    ) {
        return ResponseEntity.ok(authService.updateProfile(id, request, authentication));
    }


    @GetMapping("/users")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> getAllUsers() {
        return ResponseEntity.ok(authService.getAllUsers());
    }


}
