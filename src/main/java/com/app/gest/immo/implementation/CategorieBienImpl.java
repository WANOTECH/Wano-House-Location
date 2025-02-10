package com.app.gest.immo.implementation;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.app.gest.immo.dto.CategorieBienDTO;
import com.app.gest.immo.entities.CategorieBien;
import com.app.gest.immo.entities.TypeBien;
import com.app.gest.immo.repository.ICategorieRepository;
import com.app.gest.immo.repository.ITypeBienRepository;
import com.app.gest.immo.service.ICategorieBien;

@Service
public class CategorieBienImpl implements ICategorieBien{
	
	private final ICategorieRepository iCategorieBien;
	private final ITypeBienRepository iTypeBien;
	
	public CategorieBienImpl(ICategorieRepository iCategorieBien, ITypeBienRepository iTypeBien) {
        this.iCategorieBien = iCategorieBien;
		this.iTypeBien = iTypeBien;
    }

	@Override
	public CategorieBien save(CategorieBienDTO categorieBienDTO) throws Exception {
		CategorieBien categorieBien = setCategorieBien(categorieBienDTO);
		return iCategorieBien.save(categorieBien);
	}

	@Override
	public CategorieBien update(Long id, CategorieBienDTO categorieBienDTO) throws Exception {
		Optional<CategorieBien> categorieBien = iCategorieBien.findById(id);
		if(categorieBien.get()==null) {
			throw new Exception("Pas de Categorie Bien correspondant à cet id" + " -" + id);
		}
		CategorieBien categorie = categorieBien.get();
		categorie = setCategorieBien(categorieBienDTO);
		return iCategorieBien.saveAndFlush(categorie);
	}

	@Override
	public Set<CategorieBienDTO> list() throws Exception {
		List<CategorieBien> list = iCategorieBien.findAll();
		Set<CategorieBienDTO> setCategorie = new HashSet<CategorieBienDTO>();
		if (list == null || list.isEmpty()) {
			throw new Exception("Aucun Element Trouve");
		}
		for (CategorieBien categorie : list){
			setCategorie.add(setCategorieBienDTO(categorie));		
		}
		return setCategorie;
	}

	@Override
	public void delete(CategorieBien categorieBien) throws Exception {
		iCategorieBien.delete(categorieBien);
		
	}

	@Override
	public void deleteById(Long id) throws Exception {
		Optional<CategorieBien> categorieBien = iCategorieBien.findById(id);
		if(categorieBien.get()==null) {
			throw new Exception("Pas de Categorie Bien correspondant à cet id" + " -" + id);
		}
		CategorieBien categorie = categorieBien.get();
		iCategorieBien.delete(categorie);
		
	}

	@Override
	public CategorieBienDTO findByCode(String code) throws Exception {
		CategorieBien categorie = iCategorieBien.findCategorieBienByCode(code).get(0);
		return setCategorieBienDTO(categorie);
	}

	@Override
	public CategorieBien updateByCode(String code, CategorieBienDTO categorieBienDTO) throws Exception {
		List<CategorieBien> listCategorieBiens = iCategorieBien.findCategorieBienByCode(code);
		if (listCategorieBiens==null || listCategorieBiens.isEmpty()){
			throw  new Exception("");
		}
		CategorieBien categorie = iCategorieBien.findCategorieBienByCode(code).get(0);
		return iCategorieBien.saveAndFlush(categorie);
	}
	
	CategorieBien setCategorieBien(CategorieBienDTO categorieBienDTO) throws Exception {
		CategorieBien categorieBien = new CategorieBien();
		List<TypeBien> listType = iTypeBien.findTypeBienByCode(categorieBienDTO.getTypeBien());
		if(listType==null || listType.isEmpty()) {
			throw new Exception();
		}
		TypeBien type = listType.get(0);
		categorieBien.setTypeBien(type);
		categorieBien.setDescription(categorieBienDTO.getDescription());
		categorieBien.setNom(categorieBienDTO.getNom());
		categorieBien.setDateCreation(categorieBienDTO.getDateCreation());
		return categorieBien;
	}
	
	CategorieBienDTO setCategorieBienDTO(CategorieBien categorieBien) {
		CategorieBienDTO categorieBienDTO = new CategorieBienDTO();
		categorieBienDTO.setDescription(categorieBien.getDescription());
		categorieBienDTO.setNom(categorieBien.getNom());
		categorieBienDTO.setDateCreation(categorieBien.getDateCreation());
		categorieBienDTO.setCode(categorieBien.getCode());
		return categorieBienDTO;
	}

}
