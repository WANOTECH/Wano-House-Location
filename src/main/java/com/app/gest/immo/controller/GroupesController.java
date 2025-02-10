package com.app.gest.immo.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.gest.immo.config.securities.Groupes;
import com.app.gest.immo.service.IGoupes;

@RestController
@RequestMapping("api/groupes")
public class GroupesController {

    @Autowired
    private IGoupes groupesService;

    // Endpoint pour sauvegarder un groupe
    @PostMapping
    public Groupes saveGroupe(@RequestBody Groupes groupe) throws Exception {
        return groupesService.save(groupe);
    }

    // Endpoint pour récupérer la liste de tous les groupes
    @GetMapping("/list")
    public List<Groupes> getAllGroupes() throws Exception {
        return groupesService.list();
    }

    // Endpoint pour mettre à jour un groupe
    @PutMapping("/update")
    public Groupes updateGroupe(@RequestBody Groupes groupe) throws Exception {
        return groupesService.update(groupe);
    }

    // Endpoint pour supprimer un groupe
    @DeleteMapping("/delete")
    public void deleteGroupe(@RequestBody Groupes groupe) throws Exception {
        groupesService.delete(groupe);
    }

    // Endpoint pour supprimer un groupe par son ID
    @DeleteMapping("/{id}")
    public void deleteGroupeById(@PathVariable Long id) throws Exception {
        groupesService.deleteById(id);
    }

}


