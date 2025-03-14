package com.app.gest.immo.config.securities;

import com.app.gest.immo.config.JwtService;
import com.app.gest.immo.controller.UserDetailsImpl;
import com.app.gest.immo.repository.IUtilisateurRepository;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.constraints.NotNull;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {
    private final JwtService jwtService;
    private final IUtilisateurRepository repository;

    public JwtAuthenticationFilter(JwtService jwtService, IUtilisateurRepository repository) {
        this.jwtService = jwtService;
        this.repository = repository;
    }

    @Override
    protected void doFilterInternal(
            @NotNull HttpServletRequest request,
            @NotNull HttpServletResponse response,
            @NotNull FilterChain filterChain) throws ServletException, IOException {

        final String authHeader = request.getHeader("Authorization");
        final String jwt;
        final String userName;

        // Vérifier si l'en-tête Authorization est présent et commence par "Bearer "
        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            filterChain.doFilter(request, response);
            return;
        }

        jwt = authHeader.substring(7); // Extraire le token après "Bearer "
        userName = jwtService.extractUserName(jwt);

        if (userName != null && SecurityContextHolder.getContext().getAuthentication() == null) {
            Utilisateur utilisateur = repository.findByEmail(userName).orElse(null);

            if (utilisateur == null) {
                throw new ServletException("Utilisateur non trouvé");
            }

            // Vérifier si l'utilisateur a un groupe avec des rôles pour éviter
            // NullPointerException
            if (utilisateur.getGroupes() == null || utilisateur.getGroupes().getRoles() == null) {
                throw new ServletException("L'utilisateur n'a pas de rôles assignés");
            }

            UserDetails userDetails = UserDetailsImpl.build(utilisateur, utilisateur.getGroupes().getRoles());

            if (jwtService.isTokenValid(jwt, userDetails)) {
                UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
                        userDetails,
                        null,
                        userDetails.getAuthorities());
                authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(authToken);
            }
        }

        filterChain.doFilter(request, response);
    }
}
