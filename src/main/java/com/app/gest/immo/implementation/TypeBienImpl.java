package com.app.gest.immo.implementation;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.app.gest.immo.dto.TypeBienDTO;
import com.app.gest.immo.entities.TypeBien;
import com.app.gest.immo.entities.UtilsAPP;
import com.app.gest.immo.repository.ITypeBienRepository;
import com.app.gest.immo.service.ITypeBien;

@Service
public class TypeBienImpl implements ITypeBien{
	
	private final ITypeBienRepository iTypeBien;
	//private final ITypeBienMapper typeMapper;
	UtilsAPP utils = new UtilsAPP();
	public TypeBienImpl(ITypeBienRepository iTypeBien) {
        this.iTypeBien = iTypeBien;
		//this.typeMapper = typeMapper;
    }

	@Override
	public TypeBien save(TypeBienDTO typeBienDTO) throws Exception {
		TypeBien typeBien = toEntity(typeBienDTO);
		if(typeBien.getCode()==null) {
			throw new Exception("Imposible d'enregistrer un element avec un code null");
		}
		return iTypeBien.save(typeBien);
	}

	@Override
	public TypeBien update(Long id, TypeBienDTO typeBienDTO) throws Exception {
		Optional<TypeBien> typeBien = iTypeBien.findById(id);
		/*if(null == typeBien.get()) {
			throw new Exception("Pas de Type Bien correspondant à cet id" + " -" + id);
		}*/
		TypeBien type = typeBien.get();
		type = toEntity(typeBienDTO);
		return iTypeBien.saveAndFlush(type);
	}

	@Override
	public Set<TypeBienDTO> list() throws Exception {
		List<TypeBien> list = iTypeBien.findAll();
		Set<TypeBienDTO> setType = new HashSet<TypeBienDTO>();
		if (list == null || list.isEmpty()) {
			return null;
		}
		for (TypeBien type : list){
			setType.add(toDTO(type));
		}
		return setType;
	}

	@Override
	public void delete(TypeBien typeBien) throws Exception {
		iTypeBien.delete(typeBien);
		
	}

	@Override
	public void deleteById(Long id) throws Exception {
		Optional<TypeBien> typeBien = iTypeBien.findById(id);
		if(typeBien.get()==null) {
			throw new Exception("Pas de Type Bien correspondant à cet id" + " -" + id);
		}
		TypeBien type = typeBien.get();
		iTypeBien.delete(type);
		
	}

	@Override
	public TypeBienDTO findByCode(String code) throws Exception {
		List<TypeBien> listTypeBien = iTypeBien.findTypeBienByCode(code);
		if (listTypeBien==null || listTypeBien.isEmpty()) {
			throw new Exception("Liste vide");
		}
		TypeBien type = listTypeBien.get(0);
		return toDTO(type);
	}

	@Override
	public TypeBien updateByCode(String code, TypeBienDTO tyBienDTO) throws Exception {
		TypeBien type = iTypeBien.findTypeBienByCode(code).get(0);
		if(type==null) {
			throw new Exception("Pas de Type Bien correspondant à cet id" + " -" + code);
		}
		TypeBien typ = toEntity(tyBienDTO);
		return iTypeBien.saveAndFlush(typ);
	}

	TypeBien toEntity (TypeBienDTO  typeBienDTO){
		TypeBien typeBien = new TypeBien();
		typeBien.setDateCreation(typeBienDTO.getDateCreation());
		typeBien.setCode(typeBienDTO.getCode());
		typeBien.setNom(typeBienDTO.getNom());
		typeBien.setDescription(typeBienDTO.getDescription());
		typeBien.setDateModif(typeBienDTO.getDateModif());
		typeBien.setUtiCreation(typeBienDTO.getUtiCreation());
		return typeBien;
	}

	TypeBienDTO toDTO(TypeBien typeBien){
		TypeBienDTO typeBienDTO = new TypeBienDTO();
		typeBienDTO.setCode(typeBien.getCode());
		typeBienDTO.setDateCreation(typeBien.getDateCreation());
		typeBienDTO.setNom(typeBien.getNom());
		typeBienDTO.setDescription(typeBien.getDescription());
		typeBienDTO.setDateModif(typeBien.getDateModif());
		typeBienDTO.setUtiCreation(typeBien.getUtiCreation());
		return typeBienDTO;
	}
	

}
