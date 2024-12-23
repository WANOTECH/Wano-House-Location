package com.app.gest.immo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.gest.immo.entities.TypeBien;

public interface ITypeBienRepository extends JpaRepository<TypeBien, Long>{
	
	TypeBien findTypeBienByCode(String code);

}
