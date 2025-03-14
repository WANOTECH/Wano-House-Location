package com.app.gest.immo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.gest.immo.config.securities.Roles;

public interface IRolesRepository extends JpaRepository<Roles, Long> {
	Optional<Roles> findByNom(String nom);

}
