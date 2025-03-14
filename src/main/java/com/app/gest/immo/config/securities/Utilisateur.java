package com.app.gest.immo.config.securities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Utilisateur")
public class Utilisateur implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    private long id;
    private String nom;
    private String login;
    private String passWord;
    private String iP;
    private int maxSession;
    private String email;
    private String numero;
    private Status status;
    protected boolean isFirstConnexion;
    @Column(name = "DATE_CREATION")
    private LocalDate dateCreation;
    @Column(name = "DATE_MODIIF")
    private LocalDate dateModif;
    @Column(name = "USER_CREATION")
    private String utiCreation;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "utilisateur_roles", joinColumns = @JoinColumn(name = "utilisateur_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Roles> roles = new HashSet<>();
    @ManyToOne
    private Groupes groupes;

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

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getiP() {
        return iP;
    }

    public void setiP(String iP) {
        this.iP = iP;
    }

    public int getMaxSession() {
        return maxSession;
    }

    public void setMaxSession(int maxSession) {
        this.maxSession = maxSession;
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

    public Groupes getGroupes() {
        return groupes;
    }

    public void setGroupes(Groupes groupes) {
        this.groupes = groupes;
    }

    public Set<Roles> getRoles() {
        return roles;
    }

    public void setRoles(Set<Roles> roles) {
        this.roles = roles;
    }

    public String getEmail() {
        return email;
    }

    public String getNumero() {
        return numero;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public boolean isFirstConnexion() {
        return isFirstConnexion;
    }

    public void setFirstConnexion(boolean isFirstConnexion) {
        this.isFirstConnexion = isFirstConnexion;
    }

    @Override
    public String toString() {
        return "Utilisateur [id=" + id + ", nom=" + nom + ", login=" + login + ", passWord=" + passWord + ", iP=" + iP
                + ", maxSession=" + maxSession + ", email=" + email + ", numero=" + numero + ", status=" + status
                + ", isFirstConnexion=" + isFirstConnexion + ", dateCreation=" + dateCreation + ", dateModif="
                + dateModif + ", utiCreation=" + utiCreation + ", roles=" + roles + ", groupes=" + groupes + "]";
    }

    public Utilisateur(long id, String nom, String login, String passWord, String iP, int maxSession,
            LocalDate dateCreation, LocalDate dateModif, String utiCreation) {
        this.id = id;
        this.nom = nom;
        this.login = login;
        this.passWord = passWord;
        this.iP = iP;
        this.maxSession = maxSession;
        this.dateCreation = dateCreation;
        this.dateModif = dateModif;
        this.utiCreation = utiCreation;
    }

    public Utilisateur() {
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }
}
