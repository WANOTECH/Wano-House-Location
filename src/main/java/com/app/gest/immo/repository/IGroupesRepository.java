package com.app.gest.immo.repository;

import com.app.gest.immo.config.securities.Groupes;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;


public interface IGroupesRepository extends JpaRepository<Groupes, Long> {
	
	List<Groupes> findGroupeByNom(String nom);
	List<Groupes> findByUtiCreation(String utiCreation);
}
