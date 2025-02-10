package com.app.gest.immo.implementation;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.app.gest.immo.dto.TypeParametreDTO;
import com.app.gest.immo.entities.TypeParametre;
import com.app.gest.immo.repository.ITypeParamRepository;
import com.app.gest.immo.service.ITypeParam;

@Service
public class TypeParamImpl implements ITypeParam{
	
	private final ITypeParamRepository iTypeParam;
	//private final ITypeParametreMapper typeMapper;
	
	public TypeParamImpl(ITypeParamRepository iTypeParam) {
        this.iTypeParam = iTypeParam;
		//this.typeMapper = typeMapper;
    }

	@Override
	public TypeParametre save(TypeParametreDTO typeParamDTO) throws Exception {
		TypeParametre typeParam = toEntity(typeParamDTO);
		return iTypeParam.save(typeParam);
	}

	@Override
	public TypeParametre update(String id, TypeParametreDTO typeParamDTO) throws Exception {
		Optional<TypeParametre> typeParam = iTypeParam.findById(id);
		if(typeParam.get()==null) {
			throw new Exception("Pas de Type Param correspondant à cet id" + " -" + id);
		}
		TypeParametre type = typeParam.get();
		type = toEntity(typeParamDTO);
		return iTypeParam.saveAndFlush(type);
	}

	@Override
	public Set<TypeParametreDTO> list() throws Exception {
		List<TypeParametre> list = iTypeParam.findAll();
		Set<TypeParametreDTO> setType = new HashSet<TypeParametreDTO>();
		if (list == null || list.isEmpty()) {
			return null;
		}
		for (TypeParametre type : list){
			setType.add(toDTO(type));
		}
		return setType;
	}

	@Override
	public void delete(TypeParametre typeParam) throws Exception {
		iTypeParam.delete(typeParam);
		
	}

	@Override
	public void deleteById(String id) throws Exception {
		Optional<TypeParametre> typeParam = iTypeParam.findById(id);
		if(typeParam.get()==null) {
			throw new Exception("Pas de Type Param correspondant à cet id" + " -" + id);
		}
		TypeParametre type = typeParam.get();
		iTypeParam.delete(type);
		
	}

	@Override
	public TypeParametreDTO findByCode(String code) throws Exception {
		List<TypeParametre> listTypeParam = iTypeParam.findTypeParametreByCode(code);
		if (listTypeParam==null || listTypeParam.isEmpty()) {
			throw new Exception("Liste vide");
		}
		TypeParametre type = listTypeParam.get(0);
		return toDTO(type);
	}

	@Override
	public TypeParametre updateByCode(String code, TypeParametreDTO tyParamDTO) throws Exception {
		TypeParametre type = iTypeParam.findTypeParametreByCode(code).get(0);
		if(type==null) {
			throw new Exception("Pas de Type Param correspondant à cet id" + " -" + code);
		}
		TypeParametre typ = toEntity(tyParamDTO);
		return iTypeParam.saveAndFlush(typ);
	}

	TypeParametre toEntity(TypeParametreDTO typeParametreDTO){
		TypeParametre type = new TypeParametre();
		type.setCode(typeParametreDTO.getCode());
		type.setTypeParam(typeParametreDTO.getTypeParam());
		type.setDateCreation(typeParametreDTO.getDateCreation());
		type.setLibelle(typeParametreDTO.getLibelle());
		return type;
	}

	TypeParametreDTO toDTO(TypeParametre typeParametre){
		TypeParametreDTO type = new TypeParametreDTO();
		type.setCode(typeParametre.getCode());
		type.setTypeParam(typeParametre.getTypeParam());
		type.setDateCreation(typeParametre.getDateCreation());
		type.setLibelle(typeParametre.getLibelle());
		return type;
	}

}
