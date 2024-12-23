package com.app.gest.immo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.gest.immo.entities.Bien;
import com.app.gest.immo.entities.CategorieBien;
import com.app.gest.immo.enumeration.EEtatBien;

public interface IBienRepository extends JpaRepository<Bien, Long>{
	
	Bien findBienByCode(String code);
	Bien findBienByNom(String nom);
	List<Bien> findByEtatBien(EEtatBien etatBien);
	List<Bien> findByCategorieBien(CategorieBien categorieBien);

}
