package com.app.gest.immo.init;

import java.util.HashSet;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.app.gest.immo.config.securities.Groupes;
import com.app.gest.immo.config.securities.Roles;
import com.app.gest.immo.config.securities.Status;
import com.app.gest.immo.config.securities.Utilisateur;
import com.app.gest.immo.repository.IGroupesRepository;
import com.app.gest.immo.repository.IRolesRepository;
import com.app.gest.immo.service.IUtilisateur;

@Component
public class Database implements CommandLineRunner {

    private final IGroupesRepository serviceGroupe;
    private final IRolesRepository serviceRole;
    private final IUtilisateur iUtilisateur;

    public Database(IGroupesRepository serviceGroupe, IRolesRepository serviceRole, IUtilisateur iUtilisateur) {
        this.serviceGroupe = serviceGroupe;
        this.serviceRole = serviceRole;
        this.iUtilisateur = iUtilisateur;
    }

    @Override
    public void run(String... args) throws Exception {
        try {

            Roles roles1 = serviceRole.save(new Roles(null,
                    RolesName.SUPERADMIN.toString(), "Super utilisateur", "all"));
            Roles roles2 = serviceRole.save(new Roles(null,
                    RolesName.ADMIN.toString(), "Admin", "all"));
            Roles roles3 = serviceRole.save(new Roles(null,
                    RolesName.ROOT.toString(), "Utilisateur Root", "all"));
            Roles roles4 = serviceRole.save(new Roles(null,
                    RolesName.USER.toString(), "Utilisateur", "all"));
            Roles roles5 = serviceRole.save(new Roles(null,
                    RolesName.VISITOR.toString(), "Visiteur", "all"));
            Groupes groupes2 = new Groupes(
                    null,
                    new HashSet<>(),
                    RolesName.USER.toString(),
                    "Groupe des Utilisateurs",
                    "Description",
                    new HashSet<>());
            groupes2.getRoles().add(serviceRole.findByNom(RolesName.USER.toString()).get());
            serviceGroupe.save(groupes2);

            Utilisateur dto = new Utilisateur();
            dto.setEmail("youthfp@youthfp.cm");
            dto.setNumero("@Youthfp75");
            dto.setNom("Youthfp");
            dto.setStatus(Status.ACTIF);
            Groupes groupes = new Groupes(
                    null,
                    new HashSet<>(),
                    RolesName.SUPERADMIN.toString(),
                    "Groupe des SUPERADMIN",
                    "Description",
                    new HashSet<>());
            groupes.getRoles().add(roles1);
            groupes.getRoles().add(roles2);
            groupes.getRoles().add(roles3);
            groupes.getRoles().add(roles4);
            groupes.getRoles().add(roles5);
            groupes = serviceGroupe.save(groupes);

            iUtilisateur.save(dto, 153L);

            Groupes groupes1 = new Groupes(
                    null,
                    new HashSet<>(),
                    RolesName.ADMIN.toString(),
                    "Groupe des administrateurs",
                    "Description",
                    new HashSet<>());
            groupes1.getRoles().add(roles2);
            serviceGroupe.save(groupes1);

        } catch (Exception e) {
            e.printStackTrace(); // Gestion de l'erreur
        }
    }
}