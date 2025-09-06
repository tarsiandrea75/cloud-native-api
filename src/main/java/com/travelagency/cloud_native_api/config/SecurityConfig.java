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
            // Definiamo le regole di autorizzazione per le richieste HTTP
            .authorizeHttpRequests(authorizeRequests ->
                authorizeRequests
                    // Permetti a CHIUNQUE (permitAll) di accedere all'endpoint "/greeting"
                    .requestMatchers("/greeting").permitAll()
                    // Per QUALSIASI ALTRA richiesta (anyRequest), l'utente deve essere autenticato
                    .anyRequest().authenticated()
            )
            // Abilita il form di login di default per le pagine protette
            .formLogin(withDefaults());
        return http.build();
    }
}
