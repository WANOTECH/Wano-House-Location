package com.app.gest.immo.mapper;

import com.app.gest.immo.dto.TypeBienDTO;
import com.app.gest.immo.entities.TypeBien;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-03-14T19:16:49+0100",
    comments = "version: 1.5.3.Final, compiler: Eclipse JDT (IDE) 3.41.0.z20250213-2037, environment: Java 21.0.6 (Eclipse Adoptium)"
)
@Component
public class ITypeBienMapperImpl implements ITypeBienMapper {

    @Override
    public TypeBien toEntity(TypeBienDTO typeBienDTO) {
        if ( typeBienDTO == null ) {
            return null;
        }

        TypeBien typeBien = new TypeBien();

        typeBien.setCode( typeBienDTO.getCode() );
        typeBien.setNom( typeBienDTO.getNom() );
        typeBien.setDescription( typeBienDTO.getDescription() );
        typeBien.setDateCreation( typeBienDTO.getDateCreation() );
        typeBien.setDateModif( typeBienDTO.getDateModif() );
        typeBien.setUtiCreation( typeBienDTO.getUtiCreation() );

        return typeBien;
    }

    @Override
    public TypeBienDTO toDTO(TypeBien typeBien) {
        if ( typeBien == null ) {
            return null;
        }

        TypeBienDTO typeBienDTO = new TypeBienDTO();

        typeBienDTO.setCode( typeBien.getCode() );
        typeBienDTO.setNom( typeBien.getNom() );
        typeBienDTO.setDescription( typeBien.getDescription() );
        typeBienDTO.setDateCreation( typeBien.getDateCreation() );
        typeBienDTO.setDateModif( typeBien.getDateModif() );
        typeBienDTO.setUtiCreation( typeBien.getUtiCreation() );

        return typeBienDTO;
    }
}
