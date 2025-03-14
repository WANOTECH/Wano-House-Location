package com.app.gest.immo.implementation;

import java.util.Map;
import java.util.concurrent.ExecutorService;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.app.gest.immo.config.securities.Groupes;
import com.app.gest.immo.config.securities.Status;
import com.app.gest.immo.config.securities.Utilisateur;
import com.app.gest.immo.repository.IUtilisateurRepository;
import com.app.gest.immo.service.IGoupes;
import com.app.gest.immo.service.IUtilisateur;

@Service
public class USerImpl implements IUtilisateur {

    private final IUtilisateurRepository repository;
    private final IGoupes groupesService;
    private final PasswordEncoder passwordEncoder;
    private final ExecutorService executorService;

    public USerImpl(IUtilisateurRepository repository, IGoupes groupesService,
            @Qualifier("passwordEncoder") PasswordEncoder passwordEncoder, ExecutorService executorService) {
        this.repository = repository;
        this.groupesService = groupesService;
        this.passwordEncoder = passwordEncoder;
        this.executorService = executorService;
    }

    @Override
    public Utilisateur findById(Long id) throws Exception {
        return repository.findById(id).orElseThrow(() -> new Exception("User with id = " + id + " doesn't exist"));
    }

    @Override
    @Transactional
    public Utilisateur save(Utilisateur utilisateur, Long idGroupe) throws Exception {
        String pwd = generateRandomPassword();
        Groupes groupe = groupesService.finById(idGroupe);

        utilisateur.setGroupes(groupe);
        utilisateur.setPassWord(passwordEncoder.encode(pwd));
        utilisateur.setStatus(Status.ACTIF);
        try {
            saveIt(utilisateur);
            executorService.execute(() -> {
                String message = "Félicitations pour votre inscription. Login: "
                        + (utilisateur.getEmail() != null ? utilisateur.getEmail() : utilisateur.getLogin())
                        + " \n Password: " + pwd;
                // Envoyer l'email ou le message ici avec les informations de connexion
                System.out.println(message); // Exemple : remplacer par un envoi d'email/SMS
            });
            return utilisateur;
        } catch (Exception ex) {
            ex.printStackTrace();
            throw ex;
        }
    }

    @Override
    @Transactional
    public Utilisateur saveAdmin(Utilisateur utilisateur, Long idGroupe) throws Exception {
        String pwd = generateRandomPassword();
        Groupes groupe = groupesService.finById(idGroupe);

        utilisateur.setGroupes(groupe);
        utilisateur.setPassWord(passwordEncoder.encode(pwd));
        utilisateur.setStatus(Status.ACTIF);
        utilisateur.setFirstConnexion(true);
        try {
            saveIt(utilisateur);
            // Envoyer le mot de passe à l'administrateur de manière sécurisée
            System.out.println("Mot de passe temporaire pour " + utilisateur.getEmail() + ": " + pwd);
            return utilisateur;
        } catch (Exception ex) {
            ex.printStackTrace();
            throw ex;
        }
    }

    private Utilisateur saveIt(Utilisateur utilisateur) throws Exception {
        // checkIfUserExist(utilisateur);
        return repository.save(utilisateur);
    }

    private Utilisateur save(Utilisateur utilisateur) throws Exception {
        // checkIfUserExist(utilisateur);
        return repository.save(utilisateur);
    }

    private void checkIfUserExist(Utilisateur utilisateur) throws Exception {
        if (repository.findByEmail(utilisateur.getEmail()).isPresent()) {
            throw new Exception("Email déjà utilisé");
        }
        if (repository.findByNumero(utilisateur.getNumero()) != null) {
            throw new Exception("Numéro de téléphone déjà utilisé");
        }
    }

    private Utilisateur getUser() throws Exception {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        return findByName(username);
    }

    @Override
    public void disableUtilisateur(Long id) throws Exception {
        Utilisateur utilisateur = findById(id);
        utilisateur.setStatus(utilisateur.getStatus() == Status.ACTIF ? Status.INNATIF : Status.ACTIF);
        repository.save(utilisateur);
    }

    @Override
    public Utilisateur findByName(String name) {
        return repository.findByLogin(name)
                .orElseThrow(() -> new UsernameNotFoundException("User with name = " + name + " doesn't exist"));
    }

    public void activeOrDesactive(Long id) throws Exception {
        disableUtilisateur(id); // Réutilise la méthode disableUtilisateur pour la logique
                                // d'activation/désactivation
    }

    @Override
    public String update(MultipartFile file, Long id) throws Exception {
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public Map<String, Integer> statusListSave() throws Exception {
        throw new UnsupportedOperationException("Unimplemented method 'statusListSave'");
    }

    private String generateRandomPassword() {
        return RandomStringUtils.randomAlphanumeric(12);
    }
}