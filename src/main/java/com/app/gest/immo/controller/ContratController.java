package com.app.gest.immo.controller;

import java.util.Date;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import com.app.gest.immo.dto.ContratDTO;
import com.app.gest.immo.dto.LoyerDTO;
import com.app.gest.immo.entities.Contrat;
import com.app.gest.immo.enumeration.EEtatLoyer;
import com.app.gest.immo.service.IContrat;
import com.app.gest.immo.service.ILoyer;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/contrat")
@Tag(name = "Contrat Controller", description = "Exemple d'API documentée")
@CrossOrigin
public class ContratController {

	@Autowired
	IContrat iContrat;

	@Autowired
	ILoyer iLoyer;

	@PostMapping("/save")
	ResponseEntity<Contrat> save(@RequestBody ContratDTO ContratDTO) throws Exception {
		Contrat type = iContrat.save(ContratDTO);
		return ResponseEntity.ok(type);
	}

	@GetMapping("/list")
	ResponseEntity<Set<ContratDTO>> list() throws Exception {
		Set<ContratDTO> list = iContrat.list();
		return ResponseEntity.ok(list);
	}

	@PutMapping("/update")
	ResponseEntity<Contrat> update(@PathVariable Long id, @RequestBody ContratDTO typeDTO) throws Exception {
		Contrat type = iContrat.update(id, typeDTO);
		return ResponseEntity.ok(type);
	}

	@DeleteMapping("/delete")
	ResponseEntity<String> delete(@RequestBody Contrat type) throws Exception {
		iContrat.delete(type);
		return ResponseEntity.ok("success");
	}

	@DeleteMapping("delete/{id}")
	ResponseEntity<String> deleteById(@PathVariable Long id) throws Exception {
		iContrat.deleteById(id);
		return ResponseEntity.ok("success");
	}

	@GetMapping("/findByCode/{code}")
	ResponseEntity<ContratDTO> findByCode(@PathVariable String code) throws Exception {
		ContratDTO type = iContrat.findByCode(code);
		return ResponseEntity.ok(type);
	}

	@GetMapping("/findLoyerByDate/{date}")
	ResponseEntity<List<LoyerDTO>> findByCode(@PathVariable Date date) throws Exception {
		List<LoyerDTO> type = iLoyer.findLoyerByDatePerception(date);
		return ResponseEntity.ok(type);
	}

	@GetMapping("/findLoyerByContrat/{contrat}")
	ResponseEntity<List<LoyerDTO>> listLoyerByContrat(@PathVariable Contrat contrat) throws Exception {
		List<LoyerDTO> type = iLoyer.findLoyerByContrat(contrat);
		return ResponseEntity.ok(type);
	}

	@GetMapping("/findLoyerByEtat/{contrat}")
	ResponseEntity<List<LoyerDTO>> listLoyerByEtat(@PathVariable EEtatLoyer etat) throws Exception {
		List<LoyerDTO> type = iLoyer.listLoyerByEtat(etat);
		return ResponseEntity.ok(type);
	}

	@PutMapping("/updateByCode/{code}")
	ResponseEntity<Contrat> updateByCode(@PathVariable String code, @RequestBody ContratDTO contratDTO)
			throws Exception {
		Contrat type = iContrat.updateByCode(code, contratDTO);
		return ResponseEntity.ok(type);
	}

}
