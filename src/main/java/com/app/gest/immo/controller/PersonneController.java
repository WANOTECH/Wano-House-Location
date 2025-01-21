package com.app.gest.immo.controller;

import com.app.gest.immo.dto.PersonneDTO;
import com.app.gest.immo.entities.Personne;
import com.app.gest.immo.service.IPersonne;
import com.app.gest.immo.service.IPersonne;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/api/personne")
@Tag(name = "Personne Bien Controller", description = "Exemple d'API documentée")
@CrossOrigin
public class PersonneController {
	
	@Autowired
	IPersonne iPersonne;
	
	@PostMapping("/save")
	ResponseEntity<Personne> save (@RequestBody PersonneDTO personneDTO) throws Exception{
		Personne categorie = iPersonne.save(personneDTO);
		return ResponseEntity.ok(categorie);
	}
	
	@GetMapping("/list")
	ResponseEntity<Set<PersonneDTO>> list () throws Exception{
		Set<PersonneDTO> list = iPersonne.list();
		return ResponseEntity.ok(list);
	}
	
	@PutMapping("/update")
	ResponseEntity<Personne> update(@PathVariable Long id,@RequestBody PersonneDTO categorieDTO) throws Exception{
		Personne categorie = iPersonne.update(id, categorieDTO);
		return ResponseEntity.ok(categorie);
	}
	
	@DeleteMapping("/delete")
	ResponseEntity<String> delete(@RequestBody Personne categorie) throws Exception{
		iPersonne.delete(categorie);
		return ResponseEntity.ok("success");
	}
	
	@DeleteMapping("delete/{id}")
	ResponseEntity<String> deleteById(@PathVariable Long id) throws Exception{
		iPersonne.deleteById(id);
		return ResponseEntity.ok("success");
	}
	
	@GetMapping("/findByCode/{code}")
	ResponseEntity<PersonneDTO> findByCode(@PathVariable String code) throws Exception{
		PersonneDTO categorie = iPersonne.findByCode(code);
		return ResponseEntity.ok(categorie);
	}
	
	@PutMapping("/updateByCode/{code}")
	ResponseEntity<Personne> updateByCode(@PathVariable String code) throws Exception{
		Personne categorie = iPersonne.updateByCode(code);
		return ResponseEntity.ok(categorie);
	}
	
	

}
