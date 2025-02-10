package com.app.gest.immo.controller;

import com.app.gest.immo.dto.ParametreDTO;
import com.app.gest.immo.entities.Parametre;
import com.app.gest.immo.service.IParametre;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/api/parametre")
@CrossOrigin
@Tag(name = "Type Param Controller", description = "Exemple d'API documentée")
public class ParametreController {
	
	@Autowired
	IParametre parametre;
	
	@PostMapping("/save")
	ResponseEntity<Parametre> save (@RequestBody ParametreDTO tyParametreDTO) throws Exception{
		Parametre type = parametre.save(tyParametreDTO);
		return ResponseEntity.ok(type);
	}
	
	@GetMapping("/list")
	ResponseEntity<Set<ParametreDTO>> list () throws Exception{
		Set<ParametreDTO> list = parametre.list();
		return ResponseEntity.ok(list);
	}
	@PutMapping("/update")
	ResponseEntity<Parametre> update(@PathVariable Long id,@RequestBody ParametreDTO typeDTO) throws Exception{
		Parametre type = parametre.update(id, typeDTO);
		return ResponseEntity.ok(type);
	}
	
	@DeleteMapping("/delete")
	ResponseEntity<String> delete(@RequestBody Parametre type) throws Exception{
		parametre.delete(type);
		return ResponseEntity.ok("success");
	}
	
	@DeleteMapping("delete/{id}")
	ResponseEntity<String> deleteById(@PathVariable Long id) throws Exception{
		parametre.deleteById(id);
		return ResponseEntity.ok("success");
	}
	
	@GetMapping("/findByCode/{code}")
	ResponseEntity<ParametreDTO> findByCode(@PathVariable String code) throws Exception{
		ParametreDTO type = parametre.findByCode(code);
		return ResponseEntity.ok(type);
	}
	
	@PutMapping("/updateByCode/{code}")
	ResponseEntity<Parametre> updateByCode(@PathVariable String code, @RequestBody ParametreDTO parametreDTO) throws Exception{
		Parametre type = parametre.updateByCode(code, parametreDTO);
		return ResponseEntity.ok(type);
	}
	
	

}
