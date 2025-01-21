package com.app.gest.immo.service;

import java.util.Date;
import java.util.List;
import java.util.Set;

import com.app.gest.immo.dto.ContratDTO;
import com.app.gest.immo.entities.Bien;
import com.app.gest.immo.entities.Contrat;
import com.app.gest.immo.entities.Loyer;
import com.app.gest.immo.enumeration.EStatutContrat;

public interface IContrat {
	
	Contrat save(ContratDTO ContratDTO) throws Exception;
	Contrat update (Long id, ContratDTO ContratDTO) throws Exception;
	Set<ContratDTO> list() throws Exception;
	void delete (Contrat Contrat) throws Exception;
	void deleteById(Long id) throws Exception;
	ContratDTO findByCode(String code) throws Exception;
	Contrat updateByCode(String code, ContratDTO contratDTO) throws Exception;
 	List<ContratDTO> listContratByBien(Bien categorie)throws Exception;
	List<ContratDTO> findByDatePerception(Date datePerception)throws Exception;
	List<ContratDTO> findByContrat(Contrat contrat)throws Exception;
	Set<Loyer> generateLoyer(Contrat contrat)throws Exception;

}
