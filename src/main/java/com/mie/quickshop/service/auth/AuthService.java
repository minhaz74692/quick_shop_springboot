package com.mie.quickshop.service.auth;

import com.mie.quickshop.model.User;
import com.mie.quickshop.request.auth.AuthRequest;

import java.util.Optional;

public interface AuthService {
    User registerUser(AuthRequest authRequest);
    Optional<User> login(AuthRequest authRequest);

}
