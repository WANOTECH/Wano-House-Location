package com.app.gest.immo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.gest.immo.entities.Bien;
import com.app.gest.immo.entities.Contrat;
import com.app.gest.immo.entities.Personne;

import java.util.Date;
import java.util.List;

import com.app.gest.immo.enumeration.EPeriodicite;
import com.app.gest.immo.enumeration.EStatutContrat;

public interface IContratRepository extends JpaRepository<Contrat, Long> {

	List<Contrat> findContratByCode(String code);

	List<Contrat> findByStatut(EStatutContrat statut);

	List<Contrat> findByPeriodicite(EPeriodicite periodicite);

	List<Contrat> findByProprietaire(Personne proprietaire);

	List<Contrat> findContratByDateMiseEnplace(Date dateMiseEnplace);

	//List<Contrat> findContratByBien(Bien bien);

}
