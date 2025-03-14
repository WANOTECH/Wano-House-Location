package com.app.gest.immo.service;

import java.util.List;

import com.app.gest.immo.config.securities.Groupes;

public interface IGoupes {
	
	Groupes save(Groupes groupes) throws Exception;
	List<Groupes> list()throws Exception;
	Groupes update(Groupes groupes)throws Exception;
	Groupes finById(Long id);
	void delete(Groupes groupes)throws Exception;
	void deleteById(Long id)throws Exception;
	List<Groupes> findByNom(String nom)throws Exception;

}

