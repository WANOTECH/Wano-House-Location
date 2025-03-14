package com.app.gest.immo.service;

import java.util.List;
import java.util.Set;

import com.app.gest.immo.dto.PersonneDTO;
import com.app.gest.immo.entities.Client;
import com.app.gest.immo.entities.Gestionnaire;
import com.app.gest.immo.entities.Personne;

public interface IPersonne {

	Personne save(PersonneDTO personneDTO) throws Exception;

	Personne update(Long id, PersonneDTO personneDTO) throws Exception;

	Set<PersonneDTO> list() throws Exception;

	void delete(Personne personne) throws Exception;

	void deleteById(Long id) throws Exception;

	PersonneDTO findByCode(String code) throws Exception;

	Personne updateByCode(String code) throws Exception;

	Client savClient(PersonneDTO personneDTO) throws Exception;

	Gestionnaire savGestionnaire(PersonneDTO personneDTO) throws Exception;

	List<Client> listAllClient();

	List<Gestionnaire> listAllGestionnaire();

}
