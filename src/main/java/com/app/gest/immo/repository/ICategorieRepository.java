package com.app.gest.immo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.gest.immo.entities.CategorieBien;


public interface ICategorieRepository extends JpaRepository<CategorieBien, Long>{
	
	CategorieBien findCategorieBienByCode(String code);
	CategorieBien findCategorieBienByNom(String nom);
	

}
