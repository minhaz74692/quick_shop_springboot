package com.mie.quickshop.controller.product;

import com.mie.quickshop.response.ApiResponse;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("${api.prefix}/security")
@RequiredArgsConstructor
public class SecurityController {

    @GetMapping("/")
    public String getSessionID(HttpServletRequest httpServletRequest){
        return  httpServletRequest.getSession().getId();
    }

    // if you want to check the csrf-token then disable the  httpSecurity.csrf(AbstractHttpConfigurer::disable) code from SecurityConfiguration.java file
    @GetMapping("/csrf-token")
    public ResponseEntity<ApiResponse> getCSRF(HttpServletRequest httpServletRequest){
        CsrfToken token = (CsrfToken) httpServletRequest.getAttribute("_csrf");
        return ResponseEntity.ok(new ApiResponse("Token", token));
    }
}
