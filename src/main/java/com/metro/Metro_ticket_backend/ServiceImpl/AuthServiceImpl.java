package com.metro.Metro_ticket_backend.ServiceImpl;

import com.metro.Metro_ticket_backend.DTO.*;
import com.metro.Metro_ticket_backend.Service.AuthService;
import com.metro.Metro_ticket_backend.entity.User;
import com.metro.Metro_ticket_backend.repository.UserRepository;
import com.metro.Metro_ticket_backend.security.JwtService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.security.core.Authentication;


import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;



@AllArgsConstructor
@Service
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    public void register(RegisterRequest dto) {

        if (userRepository.findByEmail(dto.getEmail()).isPresent()) {
            throw new RuntimeException("Email already exists");
        }

        User user = new User();
        user.setName(dto.getName());
        user.setEmail(dto.getEmail());
        user.setPassword(passwordEncoder.encode(dto.getPassword()));

        // 🌟 Role can be USER or ADMIN
        user.setRole(
                dto.getRole() != null
                        ? dto.getRole().trim().toUpperCase()
                        : "USER"
        );

        userRepository.save(user);
    }



    @Override
    public  AuthResponse login(LoginRequest request) {

        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new RuntimeException("Invalid credentials"));

        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new RuntimeException("Invalid credentials");
        }

        String token = jwtService.generateToken(user);

        return new AuthResponse(
                user.getId(),
                user.getEmail(),
                user.getRole(),
                token
        );
    }

    @Override
    public  UserResponse getCurrentUser(Authentication authentication) {

        String email = authentication.getName(); // ✔️ This gets logged-in email

        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));

        return new UserResponse(
                user.getId(),
                user.getName(),
                user.getEmail(),
                user.getRole()
        );
    }


    @Override
    public  UserResponse updateProfile(Long id, UpdateUserRequest request, Authentication authentication) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));

        user.setName(request.getName());
        user.setEmail(request.getEmail());

        userRepository.save(user);

        return new UserResponse(
                user.getId(),
                user.getName(),
                user.getEmail(),
                user.getRole()
        );



    }

    @Override
    public  Object getAllUsers() {
        return userRepository.findAll()
                .stream()
                .map(u -> new UserResponse(u.getId(), u.getName(), u.getEmail(), u.getRole()))
                .toList();
    }


}
