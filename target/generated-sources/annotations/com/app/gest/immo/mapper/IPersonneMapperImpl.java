package com.app.gest.immo.mapper;

import com.app.gest.immo.dto.PersonneDTO;
import com.app.gest.immo.entities.Personne;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-01-21T22:50:40+0100",
    comments = "version: 1.5.3.Final, compiler: Eclipse JDT (IDE) 3.41.0.v20241217-1506, environment: Java 17.0.13 (Eclipse Adoptium)"
)
@Component
public class IPersonneMapperImpl implements IPersonneMapper {

    @Override
    public Personne toEntity(PersonneDTO personneDTO) {
        if ( personneDTO == null ) {
            return null;
        }

        Personne personne = new Personne();

        personne.setId( personneDTO.getId() );
        personne.setCode( personneDTO.getCode() );
        personne.setNom( personneDTO.getNom() );
        personne.setPrenom( personneDTO.getPrenom() );
        personne.setDateNaissance( personneDTO.getDateNaissance() );
        personne.setLieuNaissance( personneDTO.getLieuNaissance() );
        personne.setTelephone1( personneDTO.getTelephone1() );
        personne.setTelephone2( personneDTO.getTelephone2() );
        personne.setProfession( personneDTO.getProfession() );
        personne.setEmail( personneDTO.getEmail() );
        personne.setSexe( personneDTO.getSexe() );
        personne.setDateCreation( personneDTO.getDateCreation() );
        personne.setDateModif( personneDTO.getDateModif() );
        personne.setUtiCreation( personneDTO.getUtiCreation() );

        return personne;
    }

    @Override
    public PersonneDTO toDTO(Personne personne) {
        if ( personne == null ) {
            return null;
        }

        PersonneDTO personneDTO = new PersonneDTO();

        personneDTO.setId( personne.getId() );
        personneDTO.setCode( personne.getCode() );
        personneDTO.setNom( personne.getNom() );
        personneDTO.setPrenom( personne.getPrenom() );
        personneDTO.setDateNaissance( personne.getDateNaissance() );
        personneDTO.setLieuNaissance( personne.getLieuNaissance() );
        personneDTO.setTelephone1( personne.getTelephone1() );
        personneDTO.setTelephone2( personne.getTelephone2() );
        personneDTO.setProfession( personne.getProfession() );
        personneDTO.setEmail( personne.getEmail() );
        personneDTO.setSexe( personne.getSexe() );
        personneDTO.setDateCreation( personne.getDateCreation() );
        personneDTO.setDateModif( personne.getDateModif() );
        personneDTO.setUtiCreation( personne.getUtiCreation() );

        return personneDTO;
    }
}
