package com.app.gest.immo.service;

import java.util.Set;

import com.app.gest.immo.dto.PersonneDTO;
import com.app.gest.immo.entities.Personne;

public interface IPersonne {
	
	Personne save(PersonneDTO personneDTO) throws Exception;
	Personne update (Long id, PersonneDTO personneDTO) throws Exception;
	Set<PersonneDTO> list() throws Exception;
	void delete (Personne personne) throws Exception;
	void deleteById(Long id) throws Exception;
	PersonneDTO findByCode(String code) throws Exception;
	Personne updateByCode(String code) throws Exception;

}
