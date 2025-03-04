package com.mie.quickshop.service.auth;

import com.mie.quickshop.exception.global.ResourceNotFoundException;
import com.mie.quickshop.model.User;
import com.mie.quickshop.repository.auth.AuthRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service

public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private  AuthRepository authRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return authRepository.findByEmail(username).orElseThrow(() -> new ResourceNotFoundException("User Not Found"));
    }
}
