package com.app.gest.immo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.gest.immo.entities.CategorieBien;


public interface ICategorieRepository extends JpaRepository<CategorieBien, Long>{
	
	List<CategorieBien> findCategorieBienByCode(String code);
	List<CategorieBien> findCategorieBienByNom(String nom);
	

}
