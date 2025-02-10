package com.app.gest.immo.service;

import java.util.Set;

import com.app.gest.immo.dto.TypeParametreDTO;
import com.app.gest.immo.entities.TypeParametre;

public interface ITypeParam {
	
	TypeParametre save(TypeParametreDTO typeParametreDTO) throws Exception;
	TypeParametre update (String id, TypeParametreDTO typeParametreDTO) throws Exception;
	Set<TypeParametreDTO> list() throws Exception;
	void delete (TypeParametre typeParametre) throws Exception;
	void deleteById(String id) throws Exception;
	TypeParametreDTO findByCode(String code) throws Exception;
	TypeParametre updateByCode(String code, TypeParametreDTO typeParametreDTO) throws Exception;

}
