package com.app.gest.immo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.gest.immo.entities.Parametre;
import com.app.gest.immo.entities.TypeParametre;

import java.util.List;


public interface IParametreRepository extends JpaRepository<Parametre, Long>{
	
	List<Parametre> findParametreByCode(String code);
	List<Parametre> findByTypeParam(TypeParametre typeParam);

}
