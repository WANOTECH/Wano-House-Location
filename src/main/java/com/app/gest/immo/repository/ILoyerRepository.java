package com.app.gest.immo.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.gest.immo.entities.Loyer;
import com.app.gest.immo.enumeration.EEtatLoyer;
import com.app.gest.immo.entities.Contrat;


public interface ILoyerRepository extends JpaRepository<Loyer, Long>{
	
	Loyer findLoyerByCode(String code);
	List<Loyer> findByEtatLoyer(EEtatLoyer etatLoyer);
	List<Loyer> findByDatePerception(Date datePerception);
	List<Loyer> findByContrat(Contrat contrat);

}
