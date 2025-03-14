package com.app.gest.immo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/test")
@Tag(name = "Hello Controller", description = "Exemple d'API documentée")
public class TestController {
	
	@GetMapping("/hello")
	ResponseEntity<String> sayHelle(){
		return ResponseEntity.ok("hello");
	}

}
