package com.app.gest.immo.implementation;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.app.gest.immo.dto.PersonneDTO;
import com.app.gest.immo.entities.Client;
import com.app.gest.immo.entities.Gestionnaire;
import com.app.gest.immo.entities.Personne;
import com.app.gest.immo.mapper.IPersonneMapper;
import com.app.gest.immo.repository.IPersonneRepository;
import com.app.gest.immo.service.IPersonne;

@Service
public class PersonneImpl implements IPersonne {

	private final IPersonneRepository iPersonne;
	private final IPersonneMapper iPersonneMapper;

	public PersonneImpl(IPersonneRepository iPersonne, IPersonneMapper iPersonneMapper) {
		this.iPersonne = iPersonne;
		this.iPersonneMapper = iPersonneMapper;
	}

	@Override
	public Personne save(PersonneDTO personneDTO) throws Exception {
		Personne personne = setPersonne(personneDTO);
		return iPersonne.save(personne);
	}

	@Override
	public Personne update(Long id, PersonneDTO personneDTO) throws Exception {
		Optional<Personne> personne = iPersonne.findById(id);
		if (personne.get() == null) {
			throw new Exception("Pas de Type Bien correspondant à cet id" + " -" + id);
		}
		Personne type = personne.get();
		type = setPersonne(personneDTO);
		return iPersonne.saveAndFlush(type);
	}

	@Override
	public Set<PersonneDTO> list() throws Exception {
		List<Personne> list = iPersonne.findAll();
		Set<PersonneDTO> setType = new HashSet<PersonneDTO>();
		if (list == null || list.isEmpty()) {
			return null;
		}
		for (Personne type : list) {
			setType.add(setPersonneDTO(type));
		}
		return setType;
	}

	@Override
	public void delete(Personne personne) throws Exception {
		iPersonne.delete(personne);

	}

	@Override
	public void deleteById(Long id) throws Exception {
		Optional<Personne> personne = iPersonne.findById(id);
		if (personne.get() == null) {
			throw new Exception("Pas de Type Bien correspondant à cet id" + " -" + id);
		}
		Personne type = personne.get();
		iPersonne.delete(type);

	}

	PersonneDTO setPersonneDTO(Personne personne) {
		return iPersonneMapper.toDTO(personne);
	}

	Personne setPersonne(PersonneDTO personneDTO) {
		return iPersonneMapper.toEntity(personneDTO);
	}

	@Override
	public PersonneDTO findByCode(String code) throws Exception {
		Personne type = iPersonne.findPersonneByCode(code).get(0);
		return setPersonneDTO(type);
	}

	@Override
	public Personne updateByCode(String code) throws Exception {
		Personne type = iPersonne.findPersonneByCode(code).get(0);
		return iPersonne.saveAndFlush(type);
	}

	@Override
	public Client savClient(PersonneDTO personneDTO) throws Exception {
		Client client = (Client) setPersonne(personneDTO);
		return iPersonne.save(client);
	}

	@Override
	public Gestionnaire savGestionnaire(PersonneDTO personneDTO) throws Exception {
		Gestionnaire client = (Gestionnaire) setPersonne(personneDTO);
		return iPersonne.save(client);
	}

	@Override
	public List<Client> listAllClient() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'listAllClient'");
	}

	@Override
	public List<Gestionnaire> listAllGestionnaire() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'listAllGestionnaire'");
	}

}
