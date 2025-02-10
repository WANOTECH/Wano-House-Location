package com.app.gest.immo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.app.gest.immo.config.securities.Utilisateur;
import com.app.gest.immo.entities.ChangePwd;
import com.app.gest.immo.service.IUtilisateur;

import jakarta.annotation.security.RolesAllowed;
import jakarta.validation.Valid;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/utilisateurs")
public class UtilisateurController {

    private final IUtilisateur service;

    public UtilisateurController(IUtilisateur service) {
        this.service = service;
    }

    @PostMapping("register")
    public Utilisateur register(@Valid @RequestBody Utilisateur utilisateurDTO) throws Exception {
        return service.register(utilisateurDTO);
    }

    @PostMapping("admin")
    @RolesAllowed(value = {"SUPERADMIN","ADMIN","ROOT"})
    public Utilisateur create(@Valid @RequestBody Utilisateur utilisateurDTO) throws Exception {
        return service.save(utilisateurDTO, null);
    }

    @PostMapping("admin/save")
    @RolesAllowed(value = {"SUPERADMIN","ROOT"})
    public Utilisateur createAdmin(@Valid @RequestBody Utilisateur utilisateurDTO) throws Exception {
        return service.saveAdmin(utilisateurDTO, utilisateurDTO.getGroupes().getId());
    }

    @GetMapping("admin/get/cp")
    @RolesAllowed(value = {"SUPERADMIN","ROOT","ADMIN"})
    public List<Utilisateur> getUserCP() throws Exception {
        return service.getUserCP();
    }

    @GetMapping
    @RolesAllowed(value = {"SUPERADMIN","ROOT","ADMIN","GESTIONNAIRECENTRE"})
    public List<Utilisateur> list() throws Exception {
        return service.list();
    }

    @GetMapping("list-page/{id}")
    @RolesAllowed(value = {"SUPERADMIN","ROOT","ADMIN"})
    public Page<Utilisateur> listAll(@PathVariable int id) throws Exception {
        return service.list(id);
    }

    @DeleteMapping("/{id}")
    @RolesAllowed(value = {"SUPERADMIN","ROOT"})
    public void delete(@PathVariable Long id) throws Exception {
        service.disableUtilisateur(id);
    }

    @GetMapping("find-by-id/{id}")
    @RolesAllowed(value = {"SUPERADMIN","ROOT","ADMIN"})
    public Utilisateur findById(@PathVariable Long id) throws Exception {
        return service.findById(id);
    }

    @PutMapping("/{id}")
    @RolesAllowed(value = {"SUPERADMIN","ROOT","ADMIN","USER","GESTIONNAIRE"})
    public void update(@PathVariable Long id, @RequestBody Utilisateur utilisateurDTO) throws Exception {
        service.update(utilisateurDTO, id);
    }
    @PutMapping()
    @RolesAllowed(value = {"SUPERADMIN","ROOT","ADMIN","USER","GESTIONNAIRE"})
    public String addImage(
            @RequestParam(name = "file",required = false) MultipartFile file,
            @RequestParam( "id") Long idFormat) throws Exception {
        return service.update(file, idFormat);
    }
    @PostMapping("admin/file")
    @RolesAllowed(value = {"SUPERADMIN","ROOT","ADMIN"})
    public void addUserInFile(
            @RequestParam(name = "file",required = false) MultipartFile file) throws Exception {
        service.saveUserFile(file);
    }

    @PutMapping("active/{id}")
    @RolesAllowed(value = {"SUPERADMIN","ROOT"})
    public void activeOrDesactive(@PathVariable Long id) throws Exception {
        service.activeOrDesactive(id);
    }

    @PutMapping("change-password")
    @RolesAllowed(value = {"SUPERADMIN","ROOT","ADMIN","USER","GESTIONNAIRECENTRE"})
    public void changePassword(@RequestBody ChangePwd  changePwd) throws Exception {
        service.changePassword(changePwd);
    }

    @PutMapping("reset-password/{id}")
    @RolesAllowed(value = {"SUPERADMIN","ADMIN","ROOT"})
    public void resetPassword(@PathVariable Long id) throws Exception {
        service.resetPassword(id);
    }


    @GetMapping("dashboard")
    @RolesAllowed(value = {"SUPERADMIN","ROOT"})
    public Map<String, Object> dashboard() throws Exception {
        return service.dashboard();
    }

    @GetMapping("admin/user/save/status")
    @RolesAllowed(value = {"SUPERADMIN","ROOT","ADMIN"})
    public Map<String, Integer> statusFile() throws Exception {
        return service.statusListSave();
    }

}