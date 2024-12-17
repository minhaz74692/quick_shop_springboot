package com.mie.quickshop.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class QuickShopConfig {
    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }
}
