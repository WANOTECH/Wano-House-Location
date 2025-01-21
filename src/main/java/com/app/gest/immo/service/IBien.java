package com.app.gest.immo.service;

import java.util.List;
import java.util.Set;

import com.app.gest.immo.dto.BienDTO;
import com.app.gest.immo.entities.Bien;
import com.app.gest.immo.entities.CategorieBien;
import com.app.gest.immo.enumeration.EEtatBien;

public interface IBien {
	
	Bien save(BienDTO BienDTO) throws Exception;
	Bien update (Long id, BienDTO BienDTO) throws Exception;
	Set<BienDTO> list() throws Exception;
	void delete (Bien Bien) throws Exception;
	void deleteById(Long id) throws Exception;
	BienDTO findByCode(String code) throws Exception;
	Bien updateByCode(String code) throws Exception;
	List<BienDTO> listBienByEtat(EEtatBien etat) throws Exception;
	List<BienDTO> listBienByCategorie(CategorieBien categorie)throws Exception;
	Bien toEntity(BienDTO bienDTO) throws Exception;
	BienDTO miseLOyer(String code, BienDTO bienDTO) throws Exception;

}
