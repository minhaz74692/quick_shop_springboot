package com.mie.quickshop.controller.product;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
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

    @GetMapping("/csrf-token")
    public CsrfToken getCSRF(HttpServletRequest httpServletRequest){
        return (CsrfToken) httpServletRequest.getAttribute("_csrf");
    }
}
