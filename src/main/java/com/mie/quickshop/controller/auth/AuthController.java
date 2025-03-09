package com.mie.quickshop.controller.auth;

import com.mie.quickshop.model.User;
import com.mie.quickshop.request.auth.AuthRequest;
import com.mie.quickshop.response.ApiResponse;
import com.mie.quickshop.service.auth.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("${api.prefix}/auth")
@RequiredArgsConstructor
public class AuthController {
    private  final AuthService authService;
    @Autowired
    private  AuthenticationManager authenticationManager;
    @PostMapping("/register")
    private ResponseEntity<ApiResponse> registerUser(@RequestBody AuthRequest authRequest){

       User user = authService.registerUser(authRequest);
       return  ResponseEntity.ok(new ApiResponse("Success", user));
    }

//    @PostMapping("/login")
//    private ResponseEntity<ApiResponse> loginUser(@RequestBody AuthRequest authRequest){
//        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = UsernamePasswordAuthenticationToken.unauthenticated(authRequest.getEmail(), authRequest.getPassword());
//        Authentication authentication = authenticationManager.authenticate(usernamePasswordAuthenticationToken);
//        Optional<User> user = authService.login(authRequest);
//        return  ResponseEntity.ok(new ApiResponse(user.isPresent() ? "Login Success":"Failed", user));
//    }
}
