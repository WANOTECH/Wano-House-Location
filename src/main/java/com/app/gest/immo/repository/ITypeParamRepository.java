package com.app.gest.immo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.gest.immo.entities.TypeParametre;

public interface ITypeParamRepository extends JpaRepository<TypeParametre, String>{
	
	TypeParametre findTypeParametreByCode(String code);

}
