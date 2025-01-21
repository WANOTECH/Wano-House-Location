package com.app.gest.immo.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.app.gest.immo.dto.TypeBienDTO;
import com.app.gest.immo.entities.TypeBien;
import com.app.gest.immo.service.ITypeBien;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/typeBien")
@Tag(name = "Type Bien Controller", description = "Exemple d'API documentée")
@CrossOrigin
public class TypeBienController {
	
	@Autowired
	ITypeBien typeBien;

	@PostMapping("/save")
	ResponseEntity<TypeBien> save (@RequestBody TypeBienDTO typeBienDTO) throws Exception{
		TypeBien type = typeBien.save(typeBienDTO);
		return ResponseEntity.ok(type);
	}
	
	@GetMapping("/list")
	ResponseEntity<Set<TypeBienDTO>> list () throws Exception{
		Set<TypeBienDTO> list = typeBien.list();
		return ResponseEntity.ok(list);
	}
	
	@PutMapping("/update")
	ResponseEntity<TypeBien> update(@PathVariable Long id,@RequestBody TypeBienDTO typeDTO) throws Exception{
		TypeBien type = typeBien.update(id, typeDTO);
		return ResponseEntity.ok(type);
	}
	
	@DeleteMapping("/delete")
	ResponseEntity<String> delete(@RequestBody TypeBien type) throws Exception{
		typeBien.delete(type);
		return ResponseEntity.ok("success");
	}
	
	@DeleteMapping("delete/{id}")
	ResponseEntity<String> deleteById(@PathVariable Long id) throws Exception{
		typeBien.deleteById(id);
		return ResponseEntity.ok("success");
	}
	
	@GetMapping("/findByCode/{code}")
	ResponseEntity<TypeBienDTO> findByCode(@PathVariable String code) throws Exception{
		TypeBienDTO type = typeBien.findByCode(code);
		return ResponseEntity.ok(type);
	}
	
	@PutMapping("/updateByCode/{code}")
	ResponseEntity<TypeBien> updateByCode(@PathVariable String code, @RequestBody TypeBienDTO typeBienDTO) throws Exception{
		TypeBien type = typeBien.updateByCode(code, typeBienDTO);
		return ResponseEntity.ok(type);
	}
	
	

}
