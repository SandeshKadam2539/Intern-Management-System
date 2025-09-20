package com.company.idms.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable())
            .authorizeHttpRequests(auth -> auth
                // springdoc endpoints
                .requestMatchers("/v3/api-docs/**", "/swagger-ui/**", "/swagger-ui.html").permitAll()
                // allow actuator if needed: .requestMatchers("/actuator/**").permitAll()
                .anyRequest().permitAll() // dev mode: allow all. production: lock down appropriately
            )
            .httpBasic(Customizer.withDefaults()); // optional: keep or remove

        return http.build();
    }
}
