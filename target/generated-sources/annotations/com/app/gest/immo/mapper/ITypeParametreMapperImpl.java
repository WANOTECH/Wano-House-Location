package com.app.gest.immo.mapper;

import com.app.gest.immo.dto.TypeParametreDTO;
import com.app.gest.immo.entities.TypeParametre;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-01-21T22:50:40+0100",
    comments = "version: 1.5.3.Final, compiler: Eclipse JDT (IDE) 3.41.0.v20241217-1506, environment: Java 17.0.13 (Eclipse Adoptium)"
)
@Component
public class ITypeParametreMapperImpl implements ITypeParametreMapper {

    @Override
    public TypeParametre toEntity(TypeParametreDTO typeParametreDTO) {
        if ( typeParametreDTO == null ) {
            return null;
        }

        TypeParametre typeParametre = new TypeParametre();

        typeParametre.setCode( typeParametreDTO.getCode() );
        typeParametre.setLibelle( typeParametreDTO.getLibelle() );
        typeParametre.setDescription( typeParametreDTO.getDescription() );
        typeParametre.setTypeParam( typeParametreDTO.getTypeParam() );
        typeParametre.setDateCreation( typeParametreDTO.getDateCreation() );
        typeParametre.setUtiCreation( typeParametreDTO.getUtiCreation() );

        return typeParametre;
    }

    @Override
    public TypeParametreDTO toDTO(TypeParametre typeParametre) {
        if ( typeParametre == null ) {
            return null;
        }

        TypeParametreDTO typeParametreDTO = new TypeParametreDTO();

        typeParametreDTO.setCode( typeParametre.getCode() );
        typeParametreDTO.setLibelle( typeParametre.getLibelle() );
        typeParametreDTO.setDescription( typeParametre.getDescription() );
        typeParametreDTO.setTypeParam( typeParametre.getTypeParam() );
        typeParametreDTO.setUtiCreation( typeParametre.getUtiCreation() );
        typeParametreDTO.setDateCreation( typeParametre.getDateCreation() );

        return typeParametreDTO;
    }
}
