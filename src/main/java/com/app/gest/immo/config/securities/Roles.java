package com.app.gest.immo.config.securities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Roles")
public class Roles implements Serializable {

    private static final long serialVersionUID = 1L;
	@Id
    private long id;
    private String nom;
    private String path;
    private String description;
    @Column(name="DATE_CREATION")
    private LocalDate dateCreation;
    @Column(name="DATE_MODIIF")
    private LocalDate dateModif;
    @Column(name="USER_CREATION")
    private String utiCreation;
    @ManyToMany
    private  Set<Groupes> listGroupes;
    
    @ManyToMany(mappedBy = "roles")
    private Set<Utilisateur> listUtilisateurSet = new HashSet<>();

    public Set<Groupes> getListGroupes() {
        return listGroupes;
    }

    public void setListGroupes(Set<Groupes> listGroupes) {
        this.listGroupes = listGroupes;
    }

    public Set<Utilisateur> getListUtilisateurSet() {
        return listUtilisateurSet;
    }

    public void setListUtilisateurSet(Set<Utilisateur> listUtilisateurSet) {
        this.listUtilisateurSet = listUtilisateurSet;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(LocalDate dateCreation) {
        this.dateCreation = dateCreation;
    }

    public LocalDate getDateModif() {
        return dateModif;
    }

    public void setDateModif(LocalDate dateModif) {
        this.dateModif = dateModif;
    }

    public String getUtiCreation() {
        return utiCreation;
    }

    public void setUtiCreation(String utiCreation) {
        this.utiCreation = utiCreation;
    }

    public Roles(long id, String nom, String path, String description, LocalDate dateCreation, LocalDate dateModif, String utiCreation) {
        this.id = id;
        this.nom = nom;
        this.path = path;
        this.description = description;
        this.dateCreation = dateCreation;
        this.dateModif = dateModif;
        this.utiCreation = utiCreation;
    }

    public Roles() {
    }
}
