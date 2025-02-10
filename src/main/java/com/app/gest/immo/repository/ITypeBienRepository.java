package com.app.gest.immo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.gest.immo.entities.TypeBien;

@Repository
public interface ITypeBienRepository extends JpaRepository<TypeBien, Long>{
	
	List<TypeBien> findTypeBienByCode(String code);

}
