package com.app.gest.immo.service;

import java.util.Date;
import java.util.List;
import java.util.Set;

import com.app.gest.immo.dto.LoyerDTO;
import com.app.gest.immo.entities.Contrat;
import com.app.gest.immo.entities.Loyer;
import com.app.gest.immo.enumeration.EEtatLoyer;

public interface ILoyer {
	
	Loyer saveLoyer(LoyerDTO LoyerDTO) throws Exception;
	Loyer updateLoyer (Long id, LoyerDTO LoyerDTO) throws Exception;
	Set<LoyerDTO> listLoyer() throws Exception;
	void deleteLoyer (Loyer Loyer) throws Exception;
	void deleteLoyerById(Long id) throws Exception;
	LoyerDTO findLoyerByCode(String code) throws Exception;
	Loyer updateLoyerByCode(String code, LoyerDTO loyerDTO) throws Exception;
	List<LoyerDTO> listLoyerByEtat(EEtatLoyer etat) throws Exception;
	List<LoyerDTO> findLoyerByDatePerception(Date datePerception)throws Exception;
	List<LoyerDTO> findLoyerByContrat(Contrat contrat)throws Exception;

}
