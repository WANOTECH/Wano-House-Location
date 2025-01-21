package com.app.gest.immo.implementation;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.app.gest.immo.dto.BienDTO;
import com.app.gest.immo.entities.Bien;
import com.app.gest.immo.entities.CategorieBien;
import com.app.gest.immo.entities.Gestionnaire;
import com.app.gest.immo.entities.Parametre;
import com.app.gest.immo.entities.Personne;
import com.app.gest.immo.entities.Quartier;
import com.app.gest.immo.entities.Region;
import com.app.gest.immo.entities.Ville;
import com.app.gest.immo.enumeration.EEtatBien;
import com.app.gest.immo.repository.IBienRepository;
import com.app.gest.immo.repository.ICategorieRepository;
import com.app.gest.immo.repository.IParametreRepository;
import com.app.gest.immo.repository.IPersonneRepository;
import com.app.gest.immo.service.IBien;

@Service
public class BienImpl implements IBien{
	
	private final IBienRepository iBien;
	private final IParametreRepository iParam;
	private final IPersonneRepository personneRepos;
	private final ICategorieRepository iCategorieRepository;
	
	public BienImpl(IBienRepository iBien, IParametreRepository iParam,
			IPersonneRepository personneRepos, ICategorieRepository iCategorieRepository) {
        this.iBien = iBien;
		this.iParam = iParam;
		this.personneRepos = personneRepos;
		this.iCategorieRepository = iCategorieRepository;
    }

	@Override
	public Bien save(BienDTO bienDTO) throws Exception {
		Bien bien = setBien(bienDTO);
		return iBien.save(bien);
	}

	@Override
	public Bien update(Long id, BienDTO bienDTO) throws Exception {
		Optional<Bien> bien = iBien.findById(id);
		if(bien.get()==null) {
			throw new Exception("Pas de  Bien correspondant à cet id" + " -" + id);
		}
		Bien bie = bien.get();
		bie = setBien(bienDTO);
		return iBien.saveAndFlush(bie);
	}

	@Override
	public Set<BienDTO> list() throws Exception {
		List<Bien> list = iBien.findAll();
		Set<BienDTO> set = new HashSet<BienDTO>();
		if (list == null || list.isEmpty()) {
			throw new Exception("Aucun Element Trouve");
		}
		for (Bien  bien: list){
			set.add(setBienDTO(bien));		
		}
		return set;
	}

	@Override
	public void delete(Bien Bien) throws Exception {
		iBien.delete(Bien);
		
	}

	@Override
	public void deleteById(Long id) throws Exception {
		Optional<Bien> Bien = iBien.findById(id);
		if(Bien.get()==null) {
			throw new Exception("Pas de  Bien correspondant à cet id" + " -" + id);
		}
		Bien  bien= Bien.get();
		iBien.delete(bien);
		
	}

	@Override
	public BienDTO findByCode(String code) throws Exception {
		Bien  bien= iBien.findBienByCode(code).get(0);
		return setBienDTO(bien);
	}

	@Override
	public Bien updateByCode(String code) throws Exception {
		Bien  bien= iBien.findBienByCode(code).get(0);
		return iBien.saveAndFlush(bien);
	}
	
	

	@Override
	public List<BienDTO> listBienByEtat(EEtatBien etat) throws Exception {
		
		List<Bien> list = iBien.findByEtatBien(etat);
		List<BienDTO> lsitDTO = new ArrayList<BienDTO>();
		if (list == null || list.isEmpty()) {
			throw new Exception("Aucun Element Trouve");
		}
		for (Bien  bien: list){
			lsitDTO.add(setBienDTO(bien));		
		}
		return lsitDTO;
	}

	@Override
	public List<BienDTO> listBienByCategorie(CategorieBien categorie) throws Exception {
		List<Bien> list = iBien.findByCategorieBien(categorie);
		List<BienDTO> lsitDTO = new ArrayList<BienDTO>();
		if (list == null || list.isEmpty()) {
			throw new Exception("Aucun Element Trouve");
		}
		for (Bien  bien: list){
			lsitDTO.add(setBienDTO(bien));		
		}
		return lsitDTO;
	}
	
	private Bien setBien(BienDTO BienDTO) throws Exception {
		Bien Bien = toEntity(BienDTO);
		return Bien;
	}
	
	private BienDTO setBienDTO(Bien Bien) {
		BienDTO bienDTO = toDTO(Bien);
		return bienDTO;
	}
	
	private BienDTO toDTO(Bien bien) {
		BienDTO bienDTO = new BienDTO();
		bienDTO.setAdresse(bien.getLocation());
		bienDTO.setCode(bien.getCode());
		bienDTO.setEtatBien(bien.getEtatBien());
		bienDTO.setRegion(bien.getRegion().getCode());
		bienDTO.setLongitude(bien.getLongitude());
		bienDTO.setLatittude(bien.getLatittude());
		bienDTO.setSuperficie(bien.getSuperficie());
		bienDTO.setQuartier(bien.getQuartier().getCode());
		bienDTO.setGestionnaire(bien.getGestionnaire().getCode());
		bienDTO.setMontantLoyer(bien.getMontantLoyer());
		bienDTO.setNom(bien.getNom());
		bienDTO.setNombrePieces(bien.getNombrePieces());
		return bienDTO;
	}
	
	@Override
	public Bien toEntity(BienDTO bienDTO) throws Exception {
		Bien bien = new Bien();
		Parametre ville = iParam.findParametreByCode(bienDTO.getAdresse()).get(0);
		Parametre region = iParam.findParametreByCode(bienDTO.getRegion()).get(0);
		Parametre quartier = iParam.findParametreByCode(bienDTO.getQuartier()).get(0);
		Personne proprietaire = personneRepos.findPersonneByCode(bienDTO.getProprietaire()).get(0);
		Personne gestionnaire = personneRepos.findPersonneByCode(bienDTO.getGestionnaire()).get(0);
		List<CategorieBien> listCategorie = iCategorieRepository.findCategorieBienByCode(bienDTO.getCategorie());
		
		if(listCategorie==null || listCategorie.isEmpty()) {
			throw new Exception();
		}
		CategorieBien categorie = listCategorie.get(0);

		if (ville!=null) {
			bien.setAdresse((Ville) ville);
		}
		
		if (proprietaire!=null) {
			bien.setProprietaire(proprietaire);
		}
		
		if (gestionnaire!=null) {
			bien.setGestionnaire((Gestionnaire) gestionnaire);
		}
		
		if (region!=null) {
			bien.setRegion((Region) region);
		}
		if (quartier!=null) {
			bien.setQuartier((Quartier) quartier);
		}
		bien.setCode(bienDTO.getCode());
		bien.setEtatBien(bienDTO.getEtatBien());
		bien.setLongitude(bienDTO.getLongitude());
		bien.setLatittude(bienDTO.getLatittude());
		bien.setSuperficie(bienDTO.getSuperficie());
		bien.setMontantLoyer(bienDTO.getMontantLoyer());
		bien.setNom(bienDTO.getNom());
		bien.setNombrePieces(bienDTO.getNombrePieces());
		bien.setCategorieBien(categorie);
		return bien;
	}

	@Override
	public BienDTO miseLOyer(String code, BienDTO bienDTO) throws Exception {
		List<Bien> listBien= iBien.findBienByCode(code);
		if(listBien==null || listBien.isEmpty()){
			return null;
		}
		Bien bien = listBien.get(0);
		if(bien.getEtatBien().equals(EEtatBien.Occupe) || bien.getEtatBien().equals(EEtatBien.EnReparation)){
			throw new Exception("");
		}
		bien.setEtatBien(EEtatBien.Occupe);
		return toDTO(iBien.saveAndFlush(bien));
	}

}
