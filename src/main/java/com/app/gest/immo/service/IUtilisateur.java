package com.app.gest.immo.service;

import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import com.app.gest.immo.config.securities.Utilisateur;

public interface IUtilisateur {

    Utilisateur findById(Long id) throws Exception;

    Utilisateur save(Utilisateur utilisateur, Long idGroupe) throws Exception;

    Utilisateur saveAdmin(Utilisateur utilisateur, Long idGroupe) throws Exception;

    void disableUtilisateur(Long id) throws Exception;

    Utilisateur findByName(String nom) throws Exception;

    String update(MultipartFile file, Long id) throws Exception;

    Map<String, Integer> statusListSave() throws Exception;
}