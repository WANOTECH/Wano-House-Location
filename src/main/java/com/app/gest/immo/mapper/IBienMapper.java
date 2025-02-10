package com.app.gest.immo.mapper;

import org.mapstruct.Mapper;

import com.app.gest.immo.dto.BienDTO;
import com.app.gest.immo.entities.Bien;

@Mapper(componentModel = "spring")
public interface IBienMapper {	
	BienDTO toDTO(Bien bien);
	Bien toEntity(BienDTO bienDTO);

}
