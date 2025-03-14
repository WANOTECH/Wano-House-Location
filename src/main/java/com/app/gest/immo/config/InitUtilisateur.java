package com.app.gest.immo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import com.app.gest.immo.config.securities.Groupes;
import com.app.gest.immo.config.securities.Roles;
import com.app.gest.immo.config.securities.Status;
import com.app.gest.immo.config.securities.Utilisateur;
import com.app.gest.immo.implementation.GroupesImpl;
import com.app.gest.immo.implementation.RolesImpl;
import com.app.gest.immo.implementation.USerImpl;

public class InitUtilisateur implements CommandLineRunner {

    @Autowired
    private USerImpl iUtilisateur;

    @Autowired
    private RolesImpl serviceRole;

    @Autowired
    private GroupesImpl serviceGroupe;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Démarrage de l'initialisation des utilisateurs...");

        // Créer le rôle SUPER_ADMIN s'il n'existe pas
        if (serviceRole.findByNom("SUPER_ADMIN").isEmpty()) {
            Roles superAdminRole = new Roles();
            superAdminRole.setNom("SUPER_ADMIN");
            serviceRole.save(superAdminRole);
            System.out.println("Rôle SUPER_ADMIN créé.");
        }

        // Créer le groupe SUPER_ADMIN s'il n'existe pas
        if (serviceGroupe.findByNom("SUPER_ADMIN").isEmpty()) {
            Groupes superAdminGroup = new Groupes();
            superAdminGroup.setName("SUPER_ADMIN");
            serviceGroupe.save(superAdminGroup);
            System.out.println("Groupe SUPER_ADMIN créé.");
        }

        // Créer l'utilisateur super admin s'il n'existe pas
        if (iUtilisateur.findByName("superadmin") == null) {
            Utilisateur superAdmin = new Utilisateur();
            superAdmin.setNom("superadmin");
            superAdmin.setEmail("superadmin@example.com");
            superAdmin.setNumero("@SuperAdmin123");
            superAdmin.setLogin("superadmin");
            superAdmin.setPassWord("superadmin123");
            superAdmin.setStatus(Status.ACTIF);
            superAdmin.getRoles().add(serviceRole.findByNom("SUPER_ADMIN").get(0));
            Groupes group = serviceGroupe.findByNom("SUPER_ADMIN").get(0);
            iUtilisateur.save(superAdmin, group.getId()); // Assurez-vous que cette méthode est correcte
            System.out.println("Utilisateur superadmin créé.");
        } else {
            System.out.println("L'utilisateur superadmin existe déjà.");
        }
    }
}