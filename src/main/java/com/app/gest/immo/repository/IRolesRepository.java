package com.app.gest.immo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.gest.immo.config.securities.Roles;

public interface IRolesRepository extends JpaRepository<Roles, Long>{
	List<Roles> findByNom(String nom);

}
