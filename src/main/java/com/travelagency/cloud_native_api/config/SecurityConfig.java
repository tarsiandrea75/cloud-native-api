package com.travelagency.cloud_native_api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            // Disabilitiamo CSRF per le API stateless. Useremo altri meccanismi di sicurezza in futuro (es. JWT).
            .csrf(csrf -> csrf.disable())
            .authorizeHttpRequests(authorizeRequests ->
                authorizeRequests
                    // Permetti l'accesso pubblico a /greeting E a QUALSIASI cosa sotto /api/
                    .requestMatchers("/greeting", "/api/**").permitAll()
                    .anyRequest().authenticated()
            )
            .formLogin(withDefaults());
        return http.build();
    }
}