package com.app.gest.immo.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import com.app.gest.immo.dto.CategorieBienDTO;
import com.app.gest.immo.entities.CategorieBien;
import com.app.gest.immo.service.ICategorieBien;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/categorieBien")
@Tag(name = "Categorie Bien Controller", description = "Exemple d'API documentée")
@CrossOrigin
public class CategorieBienController {
	
	@Autowired
	ICategorieBien categorieBien;
	
	@PostMapping("/save")
	ResponseEntity<CategorieBien> save (@RequestBody CategorieBienDTO categorieBienDTO) throws Exception{
		CategorieBien categorie = categorieBien.save(categorieBienDTO);
		return ResponseEntity.ok(categorie);
	}
	
	@GetMapping("/list")
	ResponseEntity<Set<CategorieBienDTO>> list () throws Exception{
		Set<CategorieBienDTO> list = categorieBien.list();
		return ResponseEntity.ok(list);
	}
	
	@PutMapping("/update")
	ResponseEntity<CategorieBien> update(@PathVariable Long id,@RequestBody CategorieBienDTO categorieDTO) throws Exception{
		CategorieBien categorie = categorieBien.update(id, categorieDTO);
		return ResponseEntity.ok(categorie);
	}
	
	@DeleteMapping("/delete")
	ResponseEntity<String> delete(@RequestBody CategorieBien categorie) throws Exception{
		categorieBien.delete(categorie);
		return ResponseEntity.ok("success");
	}
	
	@DeleteMapping("delete/{id}")
	ResponseEntity<String> deleteById(@PathVariable Long id) throws Exception{
		categorieBien.deleteById(id);
		return ResponseEntity.ok("success");
	}
	
	@GetMapping("/findByCode/{code}")
	ResponseEntity<CategorieBienDTO> findByCode(@PathVariable String code) throws Exception{
		CategorieBienDTO categorie = categorieBien.findByCode(code);
		return ResponseEntity.ok(categorie);
	}
	
	@PutMapping("/updateByCode/{code}")
	ResponseEntity<CategorieBien> updateByCode(@PathVariable String code) throws Exception{
		CategorieBien categorie = categorieBien.updateByCode(code);
		return ResponseEntity.ok(categorie);
	}
	
	

}
