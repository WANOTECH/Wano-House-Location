package com.app.gest.immo.config;

import com.app.gest.immo.config.securities.Utilisateur;
import com.app.gest.immo.dto.LoginRequest;
import com.app.gest.immo.implementation.UserDetailsServiceImpl;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.app.gest.immo.service.IUtilisateur;

@Service
public class AuthService {
    private final IUtilisateur repository;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    private final UserDetailsServiceImpl service;

    public AuthService(IUtilisateur repository, JwtService jwtService, AuthenticationManager authenticationManager, UserDetailsServiceImpl service) {
        this.repository = repository;
        this.jwtService = jwtService;
        this.authenticationManager = authenticationManager;
        this.service = service;
    }

    public Object login(LoginRequest loginRequest) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getLogin().trim(),
                        loginRequest.getPassword().trim()
                )
        );
        UserDetails use = service.loadUserByUsername(loginRequest.getLogin().trim());
        return jwtService.generateToken(use);
    }

    public Object refreshToken(Long id){
        return jwtService.generateRefreshToken(id);
    }

    public Utilisateur getUtilisateurByLogin(String login) throws Exception {
        return repository.findByLogin(login);
    }
}