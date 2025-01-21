package com.app.gest.immo.service;

import com.app.gest.immo.dto.ParametreDTO;
import com.app.gest.immo.entities.Parametre;

import java.util.Set;

public interface IParametre {
	
	Parametre save(ParametreDTO parametreDTO) throws Exception;
	Parametre update (Long id, ParametreDTO parametreDTO) throws Exception;
	Set<ParametreDTO> list() throws Exception;
	void delete (Parametre parametre) throws Exception;
	void deleteById(Long id) throws Exception;
	ParametreDTO findByCode(String code) throws Exception;
	Parametre updateByCode(String code, ParametreDTO parametreDTO) throws Exception;

}
