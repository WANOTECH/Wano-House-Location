package com.app.gest.immo.implementation;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.app.gest.immo.dto.BienDTO;
import com.app.gest.immo.dto.ContratDTO;
import com.app.gest.immo.dto.EcheancierDTO;
import com.app.gest.immo.dto.LoyerDTO;
import com.app.gest.immo.entities.Bien;
import com.app.gest.immo.entities.Contrat;
import com.app.gest.immo.entities.Gestionnaire;
import com.app.gest.immo.entities.Loyer;
import com.app.gest.immo.enumeration.EEtatLoyer;
import com.app.gest.immo.enumeration.EPeriodicite;
import com.app.gest.immo.repository.IContratRepository;
import com.app.gest.immo.repository.ILoyerRepository;
import com.app.gest.immo.repository.IPersonneRepository;
import com.app.gest.immo.service.IBien;
import com.app.gest.immo.service.IContrat;
import com.app.gest.immo.service.ILoyer;

@Service
public class ContratImpl implements IContrat, ILoyer{
	
	private final IContratRepository iContrat;
	private final IPersonneRepository iPersonne;
	private final IBien iBien;
	private final ILoyerRepository iLoyer;
	
	public ContratImpl(IContratRepository iContrat, IPersonneRepository iPersonne, IBien iBien, ILoyerRepository iLoyer) {
        this.iContrat = iContrat;
		this.iPersonne = iPersonne;
		this.iBien = iBien;
		this.iLoyer = iLoyer;
    }

	@Override
	public Contrat save(ContratDTO ContratDTO) throws Exception {
		Contrat contrat = new Contrat();
		contrat = toEntity(ContratDTO);
		return iContrat.save(contrat);
	}

	@Override
	public Contrat update(Long id, ContratDTO ContratDTO) throws Exception {
		Optional<Contrat> contrat = iContrat.findById(id);
		if(contrat.get()==null) {
			throw new Exception("Pas de  Contrat correspondant à cet id" + " -" + id);
		}
		Contrat ctrat = contrat.get();
		ctrat = toEntity(ContratDTO);
		return iContrat.saveAndFlush(ctrat);
	}

	@Override
	public Set<ContratDTO> list() throws Exception {
		List<Contrat> listContrat = iContrat.findAll();
		Set<ContratDTO> listDTO = new HashSet<ContratDTO>();
		for (Contrat contrat : listContrat) {
			listDTO.add(toDTO(contrat));
		}
		return listDTO;
	}

	@Override
	public void delete(Contrat Contrat) throws Exception {
		iContrat.delete(Contrat);
	}

	@Override
	public void deleteById(Long id) throws Exception {
		iContrat.deleteById(id);
	}

	@Override
	public ContratDTO findByCode(String code) throws Exception {
		List<Contrat> listContrat = iContrat.findContratByCode(code);
		if (listContrat==null || listContrat.isEmpty()) {
			throw new Exception("Pas de  Contrat correspondant à cet id" + " -" + code);
		}
		return toDTO(listContrat.get(0));
	}

	@Override
	public Contrat updateByCode(String code, ContratDTO contratDTO) throws Exception {
		List<Contrat> listContrat = iContrat.findContratByCode(code);
		if (listContrat==null || listContrat.isEmpty()) {
			throw new Exception("Pas de  Contrat correspondant à cet id" + " -" + code);
		}
		return iContrat.saveAndFlush(toEntity(contratDTO));
	}

	@Override
	public List<ContratDTO> listContratByBien(Bien categorie) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ContratDTO> findByDatePerception(Date datePerception) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ContratDTO> findByContrat(Contrat contrat) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<Loyer> generateLoyer(Contrat contrat) throws Exception {
		Set<Loyer> listLoyer = new HashSet<Loyer>();
		Integer duree = contrat.getDurée();
		Double montantLoyer = contrat.getMontant()/contrat.getDurée();
		if(duree==0 || duree.equals(null)) {
			throw new Exception("null");
		}
		if (contrat.isPeriodique()) {
			for(int i=1; i<contrat.getDurée();i++) {
				Loyer loyer=getLoyer(contrat);
				loyer.setMontant(montantLoyer);
				listLoyer.add(loyer);
			}
		}
		// TODO Auto-generated method stub
		return null;
	}
	
	Loyer getLoyer(Contrat contrat) {
		Loyer loyer = new Loyer();
		loyer.setContrat(contrat);
		loyer.setDateCreation(new Date());
		loyer.setDescription(contrat.getLibelle());
		loyer.setEtatLoyer(EEtatLoyer.Impayer);
		loyer.setUtiCreation(null);
		return null;
	}
	
	EcheancierDTO getEcheance(EPeriodicite periode, int duree) {
		return null;
	}
	
	Contrat toEntity(ContratDTO contratDTO) throws Exception {
		Contrat contrat = new Contrat();
		contrat.setCode(contratDTO.getCode());
		contrat.setDateCreate(contratDTO.getDateCreate());
		contrat.setDateMiseEnplace(contratDTO.getDateMiseEnplace());
		contrat.setDurée(contratDTO.getDurée());
		contrat.setGestionnaire(getGestionnaire(contratDTO.getGestionnaire()));
		contrat.setLibelle(contratDTO.getLibelle());
		contrat.setListBiens(listBien(contratDTO));
		contrat.setListClients(null);
		contrat.setPeriodicite(contratDTO.getPeriodicite());
		contrat.setProprietaire(getGestionnaire(contratDTO.getProprietaire()));
		contrat.setStatut(contratDTO.getStatut());
		contrat.setTva(contratDTO.getTva());
		return contrat;
	}
	
	
	ContratDTO toDTO(Contrat contrat) {
		ContratDTO contratDTO = new ContratDTO();
		contratDTO.setCode(contrat.getCode());
		contratDTO.setDateCreate(contrat.getDateCreate());
		contratDTO.setDateMiseEnplace(contrat.getDateMiseEnplace());
		contratDTO.setDurée(contrat.getDurée());
		contratDTO.setLibelle(contrat.getLibelle());
		contratDTO.setMontant(contrat.getMontant());
		return contratDTO;
	}
	
	Gestionnaire getGestionnaire(String code) {
		return (Gestionnaire) iPersonne.findPersonneByCode(code).get(0);
	}
	
	
	Set<Bien> listBien(ContratDTO contratDTO) throws Exception{
		Set<BienDTO> listbienDTO = contratDTO.getListBiensDTP();
		Set<Bien> listBien = new HashSet<Bien>();
		for (BienDTO bientDTO : listbienDTO) {
			listBien.add(iBien.toEntity(bientDTO));
		}
		return listBien;
	}

	@Override
	public Loyer saveLoyer(LoyerDTO LoyerDTO) throws Exception {
		Loyer Loyer = setLoyer(LoyerDTO);
		return iLoyer.save(Loyer);
	}

	@Override
	public Loyer updateLoyer(Long id, LoyerDTO LoyerDTO) throws Exception {
		Optional<Loyer> Loyer = iLoyer.findById(id);
		if(Loyer.get()==null) {
			throw new Exception("Pas de  Loyer correspondant à cet id" + " -" + id);
		}
		Loyer bie = Loyer.get();
		bie = setLoyer(LoyerDTO);
		return iLoyer.saveAndFlush(bie);
	}

	@Override
	public Set<LoyerDTO> listLoyer() throws Exception {
		List<Loyer> list = iLoyer.findAll();
		Set<LoyerDTO> set = new HashSet<LoyerDTO>();
		if (list == null || list.isEmpty()) {
			throw new Exception("Aucun Element Trouve");
		}
		for (Loyer  Loyer: list){
			set.add(setLoyerDTO(Loyer));		
		}
		return set;
	}

	@Override
	public void deleteLoyer(Loyer Loyer) throws Exception {
		iLoyer.delete(Loyer);
		
	}

	@Override
	public void deleteLoyerById(Long id) throws Exception {
		Optional<Loyer> loyer = iLoyer.findById(id);
		if(loyer.get()==null) {
			throw new Exception("Pas de  Loyer correspondant à cet id" + " -" + id);
		}
		Loyer  lo= loyer.get();
		iLoyer.delete(lo);
		
	}

	@Override
	public Loyer updateLoyerByCode(String code, LoyerDTO loyerDTO) throws Exception {
		Loyer  Loyer= iLoyer.findLoyerByCode(code).get(0);
		return iLoyer.saveAndFlush(Loyer);
	}
	
	

	@Override
	public List<LoyerDTO> listLoyerByEtat(EEtatLoyer etat) throws Exception {
		
		List<Loyer> list = iLoyer.findByEtatLoyer(etat);
		List<LoyerDTO> lsitDTO = new ArrayList<LoyerDTO>();
		if (list == null || list.isEmpty()) {
			throw new Exception("Aucun Element Trouve");
		}
		for (Loyer  Loyer: list){
			lsitDTO.add(setLoyerDTO(Loyer));		
		}
		return lsitDTO;
	}
	
	private Loyer setLoyer(LoyerDTO LoyerDTO) {
		Loyer Loyer = toEntityLoyer(LoyerDTO);
		return Loyer;
	}
	
	private LoyerDTO setLoyerDTO(Loyer Loyer) {
		LoyerDTO LoyerDTO = toDTOLoyer(Loyer);
		return LoyerDTO;
	}
	
	LoyerDTO toDTOLoyer(Loyer loyer) {
		LoyerDTO dto = new LoyerDTO();
		dto.setCode(loyer.getCode());
		dto.setDateCreation(loyer.getDateCreation());
		dto.setDateModif(loyer.getDateModif());
		dto.setDatePerception(loyer.getDatePerception());
		dto.setEtatLoyer(loyer.getEtatLoyer());
		dto.setMontant(loyer.getMontant());	
		return dto;
	}
	
	Loyer toEntityLoyer(LoyerDTO loyerDTO) {
		Loyer loyer = new Loyer();
		loyer.setCode(loyerDTO.getCode());
		loyer.setContrat(null);
		loyer.setDateCreation(loyerDTO.getDateCreation());
		loyer.setDescription(loyerDTO.getDescription());
		loyer.setMontant(loyerDTO.getMontant());
		return loyer;
	}
	
	Contrat setContrat(ContratDTO contratDTO) {
		Contrat contrat = new Contrat();
		contrat.setCode(contratDTO.getCode());
		contrat.setDateCreate(contratDTO.getDateCreate());
		contrat.setLibelle(contratDTO.getLibelle());
		contrat.setDurée(contratDTO.getDurée());
		contrat.setStatut(contratDTO.getStatut());
		contrat.setTva(contratDTO.getTva());
		contrat.setDateMiseEnplace(contratDTO.getDateMiseEnplace());
		return contrat;
	}

	@Override
	public LoyerDTO findLoyerByCode(String code) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<LoyerDTO> findLoyerByDatePerception(Date datePerception) throws Exception {
		List<Loyer> listLoyer = iLoyer.findByDatePerception(datePerception);
		List<LoyerDTO> listLoyerDTO = new ArrayList<>();
		if(listLoyer==null || listLoyer.isEmpty()) {
			throw  new Exception("");
		}
		for(Loyer loyer : listLoyer) {
			listLoyerDTO.add(toDTOLoyer(loyer));
		}
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<LoyerDTO> findLoyerByContrat(Contrat contrat) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
