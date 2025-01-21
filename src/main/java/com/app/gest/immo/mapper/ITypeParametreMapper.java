package com.app.gest.immo.mapper;

import com.app.gest.immo.dto.TypeParametreDTO;
import com.app.gest.immo.entities.TypeParametre;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ITypeParametreMapper {
	
	TypeParametre toEntity(TypeParametreDTO typeParametreDTO);
	TypeParametreDTO toDTO(TypeParametre typeParametre);

}
