package com.app.gest.immo.service;

import java.util.Set;

import com.app.gest.immo.dto.TypeBienDTO;
import com.app.gest.immo.entities.TypeBien;

public interface ITypeBien {
	
	TypeBien save(TypeBienDTO typeBienDTO) throws Exception;
	TypeBien update (Long id, TypeBienDTO typeBienDTO) throws Exception;
	Set<TypeBienDTO> list() throws Exception;
	void delete (TypeBien typeBien) throws Exception;
	void deleteById(Long id) throws Exception;
	TypeBienDTO findByCode(String code) throws Exception;
	TypeBien updateByCode(String code, TypeBienDTO typeBienDTO) throws Exception;

}
