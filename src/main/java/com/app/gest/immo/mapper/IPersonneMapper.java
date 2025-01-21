package com.app.gest.immo.mapper;


import com.app.gest.immo.dto.PersonneDTO;
import com.app.gest.immo.entities.Personne;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface IPersonneMapper {
	Personne toEntity(PersonneDTO personneDTO);
	PersonneDTO toDTO(Personne personne);
}

