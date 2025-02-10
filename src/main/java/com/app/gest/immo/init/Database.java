package com.app.gest.immo.init;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

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



    public Database(IGroupesRepository serviceGroupe, IRolesRepository serviceRole, IUtilisateur iUtilisateur ) {
        this.serviceGroupe = serviceGroupe;
        this.serviceRole = serviceRole;
        this.iUtilisateur = iUtilisateur;

   }

   
    @Override
    public void run(String... args) throws Exception {
           
        try{
          
            Utilisateur dto = new Utilisateur();
            dto.setEmail("youthfp@youthfp.cm");
            dto.setNumero("@Youthfp75");
            dto.setNom("Youthfp");
            dto.setLogin("Inc");
            dto.setStatus(Status.ACTIF);

        }catch (Exception e){}

    }
}