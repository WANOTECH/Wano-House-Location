package com.app.gest.immo.implementation;

import com.app.gest.immo.config.securities.Status;
import com.app.gest.immo.config.securities.Utilisateur;
import com.app.gest.immo.controller.UserDetailsImpl;
import com.app.gest.immo.repository.IGroupesRepository;
import com.app.gest.immo.repository.IUtilisateurRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Optional;

public class UserDetailsServiceImpl implements UserDetailsService {
    private final IUtilisateurRepository repository;
    private final IGroupesRepository groupesRepository;

    public UserDetailsServiceImpl(IUtilisateurRepository repository, IGroupesRepository groupesRepository) {
        this.repository = repository;
        this.groupesRepository = groupesRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        username = username.trim();
        Optional<Utilisateur> user = repository.findByEmail(username);
        if (user.isEmpty()) {
            user = repository.findByNom(username);
            if(user.isEmpty()){
                user = repository.findByNom(username);
                new UsernameNotFoundException("User with username " + username + " don't exist");
            }

        }
        if(user.get().getStatus().equals(Status.INNATIF))
            throw new UsernameNotFoundException("User with username "+username+" is disable please contact administrator");
        return UserDetailsImpl.build(user.get(),user.get().getRoles());
    }
}