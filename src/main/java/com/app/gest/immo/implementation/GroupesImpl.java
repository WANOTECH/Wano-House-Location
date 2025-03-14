package com.app.gest.immo.implementation;

import com.app.gest.immo.config.securities.Groupes;
import com.app.gest.immo.repository.IGroupesRepository;
import com.app.gest.immo.service.IGoupes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GroupesImpl implements IGoupes {

    @Autowired
    private IGroupesRepository iGroupesRepository;

    @Override
    public Groupes save(Groupes groupes) throws Exception {
        return iGroupesRepository.save(groupes);
    }

    @Override
    public List<Groupes> list() throws Exception {
        // Récupère la liste de tous les groupes
        return iGroupesRepository.findAll();
    }

    @Override
    public Groupes update(Groupes groupes) throws Exception {
        // Met à jour le groupe dans la base de données
        return iGroupesRepository.saveAndFlush(groupes);
    }

    @Override
    public void delete(Groupes groupes) throws Exception {
        // Supprime le groupe de la base de données
        iGroupesRepository.delete(groupes);
    }

    @Override
    public void deleteById(Long id) throws Exception {
        // Supprime un groupe par son ID
        Optional<Groupes> groupeOptional = iGroupesRepository.findById(id);
        if (groupeOptional.isPresent()) {
            iGroupesRepository.delete(groupeOptional.get());
        } else {
            throw new Exception("Groupe non trouvé avec l'ID : " + id);
        }
    }

    @Override
    public List<Groupes> findByNom(String nom) throws Exception {
        // Trouve des groupes par leur nom
        return iGroupesRepository.findGroupeByNom(nom);
    }

    @Override
    public Groupes finById(Long id) {
        Optional<Groupes> grpes = iGroupesRepository.findById(id);
        if (grpes == null || grpes.isEmpty()) {
            return null;
        }
        Groupes groupes = grpes.get();
        return groupes;
    }
}