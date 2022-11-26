package com.example.demo.config;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Optional;

@Configuration
public class JpaAuditingConfig {
    private final UserRepository userRepository;

    public JpaAuditingConfig(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Bean
    public AuditorAware<User> userAuditorAware() {
        return () -> {
            SecurityContext context = SecurityContextHolder.getContext();
            //har bir foydlanuvchi uchun alohida alohida ochiladi
            // va tugashi bilan yo'q bo'lib ketadi
            if (context != null && context.getAuthentication() != null) {

                return userRepository.findByEmail(context.getAuthentication().getName());
            }
            return Optional.empty();
        };
    }
}