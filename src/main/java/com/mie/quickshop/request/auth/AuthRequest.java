package com.mie.quickshop.request.auth;

import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AuthRequest {
    private String email;
    private String password;
//    private String name;
//    private String phone;
//    private String address;


}
