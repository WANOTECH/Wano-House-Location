package com.app.gest.immo.implementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.gest.immo.config.securities.Roles;
import com.app.gest.immo.repository.IRolesRepository;
import com.app.gest.immo.service.IRoles;

@Service
public class RolesImpl implements IRoles{
	
	@Autowired
	private IRolesRepository iRolesRepository;

	@Override
	public Roles save(Roles roles) throws Exception {
		Roles role = iRolesRepository.save(roles);
		return role;
	}

	@Override
	public List<Roles> list() throws Exception {
		List<Roles> listRoles = iRolesRepository.findAll();
		return listRoles;
	}

	@Override
	public Roles update(Roles roles) throws Exception {
		Roles role = iRolesRepository.saveAndFlush(roles);
		return role;
	}

	@Override
	public void delete(Roles roles) throws Exception {
		iRolesRepository.delete(roles);
		
	}

	@Override
	public void deleteById(Long id) throws Exception {
		Optional<Roles> roles = iRolesRepository.findById(id);
		if (roles==null || roles.isEmpty()) {
			
		}
		Roles role = roles.get();
		iRolesRepository.delete(role);		
		
	}

	@Override
	public List<Roles> findByNom(String nom) throws Exception {
		List<Roles> listRoles = iRolesRepository.findByNom(nom);
		return listRoles;
	}
}
