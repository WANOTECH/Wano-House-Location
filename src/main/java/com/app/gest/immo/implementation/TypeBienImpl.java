package com.app.gest.immo.implementation;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.aop.ThrowsAdvice;
import org.springframework.stereotype.Service;

import com.app.gest.immo.dto.TypeBienDTO;
import com.app.gest.immo.entities.TypeBien;
import com.app.gest.immo.repository.ITypeBienRepository;
import com.app.gest.immo.service.ITypeBien;

@Service
public class TypeBienImpl implements ITypeBien{
	
	private final ITypeBienRepository iTypeBien;
	
	public TypeBienImpl(ITypeBienRepository iTypeBien) {
        this.iTypeBien = iTypeBien;
    }

	@Override
	public TypeBien save(TypeBienDTO typeBienDTO) throws Exception {
		TypeBien typeBien = setTypeBien(typeBienDTO);
		return iTypeBien.save(typeBien);
	}

	@Override
	public TypeBien update(Long id, TypeBienDTO typeBienDTO) throws Exception {
		Optional<TypeBien> typeBien = iTypeBien.findById(id);
		if(typeBien.get()==null) {
			throw new Exception("Pas de Type Bien correspondant à cet id" + " -" + id);
		}
		TypeBien type = typeBien.get();
		type = setTypeBien(typeBienDTO);
		return iTypeBien.saveAndFlush(type);
	}

	@Override
	public Set<TypeBienDTO> list() throws Exception {
		List<TypeBien> list = iTypeBien.findAll();
		Set<TypeBienDTO> setType = new HashSet<TypeBienDTO>();
		if (list == null || list.isEmpty()) {
			throw new Exception("Aucun Element Trouve");
		}
		for (TypeBien type : list){
			setType.add(setTypeBienDTO(type));		
		}
		return setType;
	}

	@Override
	public void delete(TypeBien typeBien) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteById(Long id) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public TypeBienDTO findByCode(String code) throws Exception {
		TypeBien type = findByCode(code);
		return setTypeBienDTO(type);
	}

	@Override
	public TypeBien updateByCode(String code) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
	TypeBien setTypeBien(TypeBienDTO typeBienDTO) {
		TypeBien typeBien = new TypeBien();
		typeBien.setDescription(typeBienDTO.getDescription());
		typeBien.setNom(typeBienDTO.getNom());
		typeBien.setDateCreation(typeBienDTO.getDateCreation());
		return typeBien;
	}
	
	TypeBienDTO setTypeBienDTO(TypeBien typeBien) {
		TypeBienDTO typeBienDTO = new TypeBienDTO();
		typeBienDTO.setDescription(typeBien.getDescription());
		typeBienDTO.setNom(typeBien.getNom());
		typeBienDTO.setDateCreation(typeBien.getDateCreation());
		typeBienDTO.setCode(typeBien.getCode());
		return typeBienDTO;
	}

}
