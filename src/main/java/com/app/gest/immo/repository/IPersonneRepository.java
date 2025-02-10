package com.app.gest.immo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.gest.immo.entities.Personne;
import java.util.List;


public interface IPersonneRepository extends JpaRepository<Personne, Long>{
	
	List<Personne> findPersonneByCode(String code);
	List<Personne> findByNom(String nom);

}
