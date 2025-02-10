package com.app.gest.immo.service;

import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.web.multipart.MultipartFile;

import com.app.gest.immo.config.securities.Utilisateur;
import com.app.gest.immo.entities.ChangePwd;

public interface IUtilisateur {
	
	Utilisateur findById(Long id) throws Exception ;
    Utilisateur save(Utilisateur utilisateur, Long idGroupe) throws Exception ;
    Utilisateur saveAdmin(Utilisateur utilisateur, Long idGroupe) throws Exception ;
    Utilisateur register(Utilisateur utilisateur) throws Exception ;
    Page<Utilisateur> list(int page) throws Exception ;
    List<Utilisateur> list() throws Exception ;
    List<Utilisateur> list(String role) throws Exception ;
    Utilisateur update(Utilisateur utilisateur, Long id) throws Exception ;
    String update(MultipartFile file, Long id) throws Exception;
    void disableUtilisateur(Long id) throws Exception ;
    Utilisateur findByName(String nom) throws Exception;
    Utilisateur findByLogin(String login) throws Exception;
    Utilisateur login(String login) throws Exception;
    void changePassword(ChangePwd changePwd) throws Exception;
    Map<String, Integer> statusListSave() throws Exception;
    void activeOrDesactive(Long id) throws Exception;
	

}
