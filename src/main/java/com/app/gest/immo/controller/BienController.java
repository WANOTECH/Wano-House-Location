package com.app.gest.immo.controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.app.gest.immo.dto.BienDTO;
import com.app.gest.immo.entities.Bien;
import com.app.gest.immo.entities.CategorieBien;
import com.app.gest.immo.enumeration.EEtatBien;
import com.app.gest.immo.service.IBien;
import com.app.gest.immo.service.ICategorieBien;

import io.swagger.v3.oas.annotations.tags.Tag;

@Controller
@RequestMapping("/api/bien")
@Tag(name = "Bien Controller", description = "Exemple d'API documentée")
@CrossOrigin
public class BienController {
	
	@Autowired
	IBien iBien;
	
	@Autowired
	ICategorieBien iCategorie;
	
	@PostMapping("/save")
	ResponseEntity<Bien> save (@RequestBody BienDTO bienDTO) throws Exception{
		Bien type = iBien.save(bienDTO);
		return ResponseEntity.ok(type);
	}
	
	@GetMapping("/list")
	ResponseEntity<Set<BienDTO>> list () throws Exception{
		Set<BienDTO> list = iBien.list();
		return ResponseEntity.ok(list);
	}
	
	@PutMapping("/update")
	ResponseEntity<Bien> update(@PathVariable Long id,@RequestBody BienDTO typeDTO) throws Exception{
		Bien type = iBien.update(id, typeDTO);
		return ResponseEntity.ok(type);
	}
	
	@DeleteMapping("/delete")
	ResponseEntity<String> delete(@RequestBody Bien type) throws Exception{
		iBien.delete(type);
		return ResponseEntity.ok("success");
	}
	
	@DeleteMapping("delete/{id}")
	ResponseEntity<String> deleteById(@PathVariable Long id) throws Exception{
		iBien.deleteById(id);
		return ResponseEntity.ok("success");
	}
	
	@GetMapping("/findByCode/{code}")
	ResponseEntity<BienDTO> findByCode(@PathVariable String code) throws Exception{
		BienDTO type = iBien.findByCode(code);
		return ResponseEntity.ok(type);
	}
	
	@PutMapping("/updateByCode/{code}")
	ResponseEntity<Bien> updateByCode(@PathVariable String code, @RequestBody BienDTO bienDTO) throws Exception{
		Bien type = iBien.updateByCode(code, bienDTO);
		return ResponseEntity.ok(type);
	}
	
	@GetMapping("/listBienByCategorie/{codeCategorie}")
	ResponseEntity<List<BienDTO>> listBienByCategorie(@RequestBody CategorieBien categorie) throws Exception{
		List<BienDTO> list = iBien.listBienByCategorie(categorie);
		return ResponseEntity.ok(list);
	}
	
	@GetMapping("/listBienByCategorie/{etat}")
	ResponseEntity<List<BienDTO>> listBienByEtat(@PathVariable EEtatBien etat) throws Exception{
		List<BienDTO> list = iBien.listBienByEtat(etat);
		return ResponseEntity.ok(list);
	} 

}
