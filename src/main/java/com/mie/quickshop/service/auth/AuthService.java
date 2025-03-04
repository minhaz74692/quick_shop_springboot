package com.mie.quickshop.service.auth;

import com.mie.quickshop.model.User;
import com.mie.quickshop.request.auth.AuthRequest;

public interface AuthService {
    User registerUser(AuthRequest authRequest);
    User login(AuthRequest authRequest);

}
