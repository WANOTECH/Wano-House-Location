package com.app.gest.immo.service;

import java.util.Set;

import com.app.gest.immo.dto.CategorieBienDTO;
import com.app.gest.immo.entities.CategorieBien;

public interface ICategorieBien {
	
	CategorieBien save(CategorieBienDTO categorieBienDTO) throws Exception;
	CategorieBien update (Long id, CategorieBienDTO categorieBienDTO) throws Exception;
	Set<CategorieBienDTO> list() throws Exception;
	void delete (CategorieBien categorieBien) throws Exception;
	void deleteById(Long id) throws Exception;
	CategorieBienDTO findByCode(String code) throws Exception;
	CategorieBien updateByCode(String code, CategorieBienDTO categorieBienDTO) throws Exception;

}
