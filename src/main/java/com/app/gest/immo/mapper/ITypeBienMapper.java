package com.app.gest.immo.mapper;


import com.app.gest.immo.dto.TypeBienDTO;
import com.app.gest.immo.entities.TypeBien;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ITypeBienMapper {
	TypeBien toEntity(TypeBienDTO typeBienDTO);
	TypeBienDTO toDTO(TypeBien typeBien);

}
