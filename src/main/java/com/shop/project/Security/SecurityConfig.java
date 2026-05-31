package com.shop.project.Security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            // Disable CSRF for REST APIs since we are using stateless requests/Postman
            .csrf(csrf -> csrf.disable())
            
            // Define path authorization permissions
            .authorizeHttpRequests(auth -> auth
                // Allow anyone to register a new account without logging in
                .requestMatchers(HttpMethod.POST, "/api/customers/register").permitAll()
                
                // Any other request (like fetching customer info or placing orders) requires login
                .anyRequest().authenticated()
            )
            
            // Enable HTTP Basic authentication for testing via Postman
            .httpBasic(Customizer.withDefaults());

        return http.build();
    }
}