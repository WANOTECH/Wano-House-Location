package com.app.gest.immo.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.app.gest.immo.dto.TypeParametreDTO;
import com.app.gest.immo.entities.TypeParametre;
import com.app.gest.immo.service.ITypeParam;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/typeParam")
@CrossOrigin
@Tag(name = "Type Param Controller", description = "Exemple d'API documentée")
public class TypeParamController {
	
	@Autowired
	ITypeParam typeParam;
	
	@PostMapping("/save")
	ResponseEntity<TypeParametre> save (@RequestBody TypeParametreDTO tyParametreDTO) throws Exception{
		TypeParametre type = typeParam.save(tyParametreDTO);
		return ResponseEntity.ok(type);
	}
	
	@GetMapping("/list")
	ResponseEntity<Set<TypeParametreDTO>> list () throws Exception{
		Set<TypeParametreDTO> list = typeParam.list();
		return ResponseEntity.ok(list);
	}
	@PutMapping("/update")
	ResponseEntity<TypeParametre> update(@PathVariable String id,@RequestBody TypeParametreDTO typeDTO) throws Exception{
		TypeParametre type = typeParam.update(id, typeDTO);
		return ResponseEntity.ok(type);
	}
	
	@DeleteMapping("/delete")
	ResponseEntity<String> delete(@RequestBody TypeParametre type) throws Exception{
		typeParam.delete(type);
		return ResponseEntity.ok("success");
	}
	
	@DeleteMapping("delete/{id}")
	ResponseEntity<String> deleteById(@PathVariable String id) throws Exception{
		typeParam.deleteById(id);
		return ResponseEntity.ok("success");
	}
	
	@GetMapping("/findByCode/{code}")
	ResponseEntity<TypeParametreDTO> findByCode(@PathVariable String code) throws Exception{
		TypeParametreDTO type = typeParam.findByCode(code);
		return ResponseEntity.ok(type);
	}
	
	@PutMapping("/updateByCode/{code}")
	ResponseEntity<TypeParametre> updateByCode(@PathVariable String code, @RequestBody TypeParametreDTO typeParamDTO) throws Exception{
		TypeParametre type = typeParam.updateByCode(code, typeParamDTO);
		return ResponseEntity.ok(type);
	}
	
	

}
