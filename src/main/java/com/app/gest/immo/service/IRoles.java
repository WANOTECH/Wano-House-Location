package com.app.gest.immo.service;

import java.util.List;

import com.app.gest.immo.config.securities.Roles;

public interface IRoles {
	
	Roles save(Roles roles) throws Exception;
	List<Roles> list()throws Exception;
	Roles update(Roles roles)throws Exception;
	void delete(Roles roles)throws Exception;
	void deleteById(Long id)throws Exception;
	List<Roles> findByNom(String nom)throws Exception;

}

