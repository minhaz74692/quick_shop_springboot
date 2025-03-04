package com.mie.quickshop.controller.auth;

import com.mie.quickshop.model.User;
import com.mie.quickshop.request.auth.AuthRequest;
import com.mie.quickshop.response.ApiResponse;
import com.mie.quickshop.service.auth.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("${api.prefix}/auth")
@RequiredArgsConstructor
public class AuthController {
    private  final AuthService authService;

    @PostMapping("/register")
    private ResponseEntity<ApiResponse> registerUser(@RequestBody AuthRequest authRequest){
        User user = authService.registerUser(authRequest);
        return  ResponseEntity.ok(new ApiResponse("Success", user));
    }

    @PostMapping("/login")
    private ResponseEntity<ApiResponse> loginUser(@RequestBody AuthRequest authRequest){
        Optional<User> user = authService.login(authRequest);
        return  ResponseEntity.ok(new ApiResponse(user!= null? "Login Success":"Failed", user));
    }
}
