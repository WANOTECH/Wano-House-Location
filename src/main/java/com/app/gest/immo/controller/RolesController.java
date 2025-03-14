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

import com.app.gest.immo.config.securities.Roles;
import com.app.gest.immo.service.IRoles;

@RestController
@RequestMapping("/api/roles")
public class RolesController {

    @Autowired
    private IRoles rolesService;

    // Endpoint pour sauvegarder un rôle
    @PostMapping
    public Roles saveRole(@RequestBody Roles role) throws Exception {
        return rolesService.save(role);
    }

    // Endpoint pour récupérer la liste de tous les rôles
    @GetMapping
    public List<Roles> getAllRoles() throws Exception {
        return rolesService.list();
    }

    // Endpoint pour mettre à jour un rôle
    @PutMapping
    public Roles updateRole(@RequestBody Roles role) throws Exception {
        return rolesService.update(role);
    }

    // Endpoint pour supprimer un rôle
    @DeleteMapping
    public void deleteRole(@RequestBody Roles role) throws Exception {
        rolesService.delete(role);
    }

    // Endpoint pour supprimer un rôle par son ID
    @DeleteMapping("/{id}")
    public void deleteRoleById(@PathVariable Long id) throws Exception {
        rolesService.deleteById(id);
    }

    // Endpoint pour trouver des rôles par nom
    @GetMapping("/nom/{nom}")
    public Roles getRolesByNom(@PathVariable String nom) throws Exception {
        return rolesService.findByNom(nom);
    }
}