package com.app.gest.immo.controller;

import com.app.gest.immo.config.AuthService;
import com.app.gest.immo.config.securities.Utilisateur;
import com.app.gest.immo.dto.LoginRequest;
import com.app.gest.immo.service.IUtilisateur;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.Map;


@RestController
@RequestMapping("api/auth")
public class SecurityController {
    private final AuthService service;
    private final IUtilisateur iUtilisateur;

    public SecurityController(AuthService service, IUtilisateur iUtilisateur ){
        this.service = service;
        this.iUtilisateur = iUtilisateur;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) throws Exception {
        HttpHeaders  httpHeaders = new HttpHeaders();
        Map<String, Object> data = new HashMap<>();
        String accessToken = "Bearer "+service.login(loginRequest);
        data.put("accessToken", accessToken);
        Utilisateur utilisateur = service.getUtilisateurByLogin(loginRequest.getLogin().trim());
        utilisateur.getRoles().clear();
        data.put("user", utilisateur);
        String refreshToken = "Bearer "+service.refreshToken(utilisateur.getId());
        data.put("refreshToken", refreshToken);
        return new ResponseEntity<>(data, httpHeaders, HttpStatus.OK);
    }

}