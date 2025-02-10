package com.app.gest.immo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

import com.app.gest.immo.config.securities.Roles;
import com.app.gest.immo.config.securities.Utilisateur;
import com.app.gest.immo.implementation.RolesImpl;
import com.app.gest.immo.implementation.USerImpl;

public class InitUtilisateur implements CommandLineRunner {

    @Autowired
    private USerImpl utilisateurService;

    @Autowired
    private RolesImpl roleService;

    @Override
    public void run(String... args) throws Exception {
        // Créer le rôle SUPER_ADMIN s'il n'existe pas
        Roles superAdminRole = roleService.findByNom("SUPER_ADMIN").get(0);
        if (superAdminRole == null) {
            superAdminRole = new Roles();
            superAdminRole.setNom("SUPER_ADMIN");
            roleService.save(superAdminRole);
        }

        // Créer l'utilisateur super admin s'il n'existe pas
        Utilisateur superAdmin = utilisateurService.findByLogin("superadmin");
        if (superAdmin == null) {
            superAdmin = new Utilisateur();
            superAdmin.setNom("superadmin");
            superAdmin.setPassWord("superadmin123"); // Mot de passe par défaut
            superAdmin.getRoles().add(superAdminRole);
            utilisateurService.save(superAdmin);
        }
    }
}