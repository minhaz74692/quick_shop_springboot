package com.mie.quickshop.service.auth;

import com.mie.quickshop.exception.global.ResourceNotFoundException;
import com.mie.quickshop.model.Role;
import com.mie.quickshop.model.User;
import com.mie.quickshop.repository.auth.AuthRepository;
import com.mie.quickshop.request.auth.AuthRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class IAuthService implements AuthService{
    private  final AuthRepository authRepository;
    private  final BCryptPasswordEncoder passwordEncoder;

    @Override
    public User registerUser(AuthRequest authRequest) {
//        User user = authRepository.findById(authRequest.getEmail());
        User user = User.builder()
                .email(authRequest.getEmail())
                .password(passwordEncoder.encode(authRequest.getPassword()))
                .role(Role.USER)
                .build();
        return authRepository.save(user);
    }

    @Override
    public Optional<User> login(AuthRequest authRequest) {

        return Optional.ofNullable(authRepository.findByEmailAndPassword(authRequest.getEmail(), passwordEncoder.encode(authRequest.getPassword())).orElseThrow(() -> new ResourceNotFoundException("user not found")));
    }
}
