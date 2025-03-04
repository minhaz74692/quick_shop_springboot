package com.mie.quickshop.service.auth;

import com.mie.quickshop.model.User;
import com.mie.quickshop.request.auth.AuthRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class IAuthService implements AuthService{
    @Override
    public User registerUser(AuthRequest authRequest) {
        return null;
    }

    @Override
    public User login(AuthRequest authRequest) {
        return null;
    }
}
