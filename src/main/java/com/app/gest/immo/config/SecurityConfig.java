package com.app.gest.immo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.oauth2.server.resource.OAuth2ResourceServerConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.List;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable()) // Désactivation de CSRF pour API stateless
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers("/api/public/**").permitAll() // Routes publiques
                        .requestMatchers("/api/admin/**").hasRole("ADMIN") // Accessible aux ADMINs
                        .requestMatchers("/api/user/**").hasAnyRole("USER", "ADMIN") // Accessible aux USERS et ADMINs
                        .anyRequest().authenticated()
                )
                .sessionManagement(sess -> sess.sessionCreationPolicy(SessionCreationPolicy.STATELESS)) // Pas de session
                .oauth2ResourceServer(OAuth2ResourceServerConfigurer::jwt) // Gestion des tokens JWT OAuth2
                .httpBasic(Customizer.withDefaults()); // Authentification basique activée

        return http.build();
    }
    
    private void JwtEncoder() {
		// TODO Auto-generated method stub

	}

    
    private void JwtDecoder() {
		// TODO Auto-generated method stub

	}

    @Bean
    public InMemoryUserDetailsManager inMemoryUserDetailsManager() {
        return new InMemoryUserDetailsManager(
                User.withUsername("ROOT")
                        .password(passwordEncoder().encode("123456987"))
                        .roles("ADMIN")
                        .build()
        );
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", corsConfigurationSource());
        return new CorsFilter(source);
    }

    @Bean
    public CorsConfiguration corsConfigurationSource() {
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true);
        config.setAllowedOrigins(List.of("*")); // Modifier si besoin pour des domaines spécifiques
        config.setAllowedHeaders(List.of("*"));
        config.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE", "OPTIONS"));
        return config;
    }
}
