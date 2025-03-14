package com.app.gest.immo.config;

import com.app.gest.immo.config.securities.Utilisateur;
import com.app.gest.immo.dto.LoginRequest;
import com.app.gest.immo.implementation.UserDetailsServiceImpl;
import com.app.gest.immo.service.IUtilisateur;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final IUtilisateur repository;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    private final UserDetailsServiceImpl service;

    public AuthService(IUtilisateur repository, JwtService jwtService, AuthenticationManager authenticationManager,
            UserDetailsServiceImpl service) {
        this.repository = repository;
        this.jwtService = jwtService;
        this.authenticationManager = authenticationManager;
        this.service = service;
    }

    public Object login(LoginRequest loginRequest) throws Exception {
        // Vérifier si l'utilisateur existe
        Utilisateur utilisateur = repository.findByName(loginRequest.getLogin().trim());
        if (utilisateur == null) {
            throw new UsernameNotFoundException("Utilisateur non trouvé");
        }

        // Tenter d'authentifier l'utilisateur
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            loginRequest.getLogin().trim(),
                            loginRequest.getPassword().trim()));
        } catch (Exception e) {
            throw new RuntimeException("Échec de l'authentification : " + e.getMessage());
        }

        // Charger les détails de l'utilisateur et générer le token JWT
        UserDetails user = service.loadUserByUsername(loginRequest.getLogin().trim());
        return jwtService.generateToken(user);
    }

    public Object refreshToken(Long id) {
        return jwtService.generateRefreshToken(id);
    }

    public Utilisateur getUtilisateurByLogin(String login) throws Exception {
        return repository.findByName(login);
    }
}