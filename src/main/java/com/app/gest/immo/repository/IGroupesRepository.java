package com.app.gest.immo.repository;

import com.app.gest.immo.config.securities.Groupes;
import com.app.gest.immo.config.securities.Roles;
import com.app.gest.immo.config.securities.Utilisateur;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public interface IGroupesRepository extends JpaRepository<Groupes, Long> {

	Optional<Groupes> findByName(String name);

	Groupes findByUtilisateursContains(Utilisateur users);

	List<Groupes> findByRolesContaining(Roles roles);
}
