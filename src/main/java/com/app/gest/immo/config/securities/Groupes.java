package com.app.gest.immo.config.securities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Groupes")
public class Groupes implements Serializable {

    private static final long serialVersionUID = 1L;
	@Id
    private long id;
    private String nom;
    private String description;
    @Column(name="DATE_CREATION")
    private LocalDate dateCreation;
    @Column(name="DATE_MODIIF")
    private LocalDate dateModif;
    @Column(name="USER_CREATION")
    private String utiCreation;

    @ManyToMany
    @JoinTable(
        name = "groupe_roles",
        joinColumns = @JoinColumn(name = "groupe_id"),
        inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<Utilisateur> utilisateurs = new HashSet<>();

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

    public Set<Utilisateur> getUtilisateurs() {
        return utilisateurs;
    }

    public void setUtilisateurs(Set<Utilisateur> utilisateurs) {
        this.utilisateurs = utilisateurs;
    }

    public Groupes(long id, String nom, String description, LocalDate dateCreation, LocalDate dateModif, String utiCreation, Set<Utilisateur> utilisateurs) {
        this.id = id;
        this.nom = nom;
        this.description = description;
        this.dateCreation = dateCreation;
        this.dateModif = dateModif;
        this.utiCreation = utiCreation;
        this.utilisateurs = utilisateurs;
    }

    public Groupes() {
    }
}
