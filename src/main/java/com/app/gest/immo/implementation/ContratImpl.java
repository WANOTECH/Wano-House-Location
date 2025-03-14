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
import com.app.gest.immo.entities.UtilsAPP;
import com.app.gest.immo.enumeration.EEtatLoyer;
import com.app.gest.immo.enumeration.EPeriodicite;
import com.app.gest.immo.repository.IContratRepository;
import com.app.gest.immo.repository.ILoyerRepository;
import com.app.gest.immo.repository.IPersonneRepository;
import com.app.gest.immo.service.IBien;
import com.app.gest.immo.service.IContrat;
import com.app.gest.immo.service.ILoyer;

@Service
public class ContratImpl implements IContrat, ILoyer {

	private final IContratRepository contratRepository;
	private final IPersonneRepository personneRepository;
	private final IBien bienService;
	private final ILoyerRepository loyerRepository;

	public ContratImpl(IContratRepository contratRepository, IPersonneRepository personneRepository, IBien bienService,
			ILoyerRepository loyerRepository) {
		this.contratRepository = contratRepository;
		this.personneRepository = personneRepository;
		this.bienService = bienService;
		this.loyerRepository = loyerRepository;
	}

	@Override
	public Contrat save(ContratDTO contratDTO) throws Exception {
		Contrat contrat = toEntity(contratDTO);
		return contratRepository.save(contrat);
	}

	@Override
	public Contrat update(Long id, ContratDTO contratDTO) throws Exception {
		Optional<Contrat> optionalContrat = contratRepository.findById(id);
		if (!optionalContrat.isPresent()) {
			throw new Exception("Pas de Contrat correspondant à cet id: " + id);
		}
		Contrat contrat = optionalContrat.get();
		updateEntity(contrat, contratDTO);
		return contratRepository.saveAndFlush(contrat);
	}

	@Override
	public Set<ContratDTO> list() throws Exception {
		List<Contrat> contrats = contratRepository.findAll();
		Set<ContratDTO> contratDTOs = new HashSet<>();
		for (Contrat contrat : contrats) {
			contratDTOs.add(toDTO(contrat));
		}
		return contratDTOs;
	}

	@Override
	public void delete(Contrat contrat) throws Exception {
		contratRepository.delete(contrat);
	}

	@Override
	public void deleteById(Long id) throws Exception {
		contratRepository.deleteById(id);
	}

	@Override
	public ContratDTO findByCode(String code) throws Exception {
		List<Contrat> contrats = contratRepository.findContratByCode(code);
		if (contrats.isEmpty()) {
			throw new Exception("Pas de Contrat correspondant à ce code: " + code);
		}
		return toDTO(contrats.get(0));
	}

	@Override
	public Contrat updateByCode(String code, ContratDTO contratDTO) throws Exception {
		List<Contrat> contrats = contratRepository.findContratByCode(code);
		if (contrats.isEmpty()) {
			throw new Exception("Pas de Contrat correspondant à ce code: " + code);
		}
		Contrat contrat = contrats.get(0);
		updateEntity(contrat, contratDTO);
		return contratRepository.saveAndFlush(contrat);
	}

	@Override
	public List<ContratDTO> listContratByBien(Bien bien) throws Exception {
		// List<Contrat> contrats = contratRepository.findContratByBien(bien);
		List<ContratDTO> contratDTOs = new ArrayList<>();
		/*
		 * for (Contrat contrat : contrats) {
		 * contratDTOs.add(toDTO(contrat));
		 * }
		 */
		return null;
	}

	@Override
	public List<ContratDTO> findByDateMiseEnLoyer(Date dateMiseEnPlace) throws Exception {
		List<Contrat> contrats = contratRepository.findContratByDateMiseEnplace(dateMiseEnPlace);
		List<ContratDTO> contratDTOs = new ArrayList<>();
		for (Contrat contrat : contrats) {
			contratDTOs.add(toDTO(contrat));
		}
		return contratDTOs;
	}

	@Override
	public Set<Loyer> generateLoyer(Contrat contrat) throws Exception {
		Set<Loyer> loyers = new HashSet<>();
		if (contrat.getDurée() == 0) {
			throw new Exception("La durée du contrat ne peut pas être zéro.");
		}
		double montantLoyer = contrat.getMontant() / contrat.getDurée();
		if (contrat.isPeriodique()) {
			for (int i = 1; i <= contrat.getDurée(); i++) {
				Loyer loyer = createLoyer(contrat, montantLoyer);
				loyers.add(loyer);
			}
		}
		return loyers;
	}

	private Loyer createLoyer(Contrat contrat, double montantLoyer) {
		Loyer loyer = new Loyer();
		loyer.setContrat(contrat);
		loyer.setDateCreation(new Date());
		loyer.setDescription(contrat.getLibelle());
		loyer.setEtatLoyer(EEtatLoyer.Impayer);
		loyer.setMontant(montantLoyer);
		return loyer;
	}

	private Contrat toEntity(ContratDTO contratDTO) throws Exception {
		Contrat contrat = new Contrat();
		contrat.setCode(contratDTO.getCode());
		contrat.setDateCreate(contratDTO.getDateCreate());
		contrat.setDateMiseEnplace(contratDTO.getDateMiseEnplace());
		contrat.setDurée(contratDTO.getDurée());
		contrat.setGestionnaire(getGestionnaire(contratDTO.getGestionnaire()));
		contrat.setLibelle(contratDTO.getLibelle());
		contrat.setListBiens(listBien(contratDTO));
		contrat.setPeriodicite(contratDTO.getPeriodicite());
		contrat.setProprietaire(getGestionnaire(contratDTO.getProprietaire()));
		contrat.setStatut(contratDTO.getStatut());
		contrat.setTva(contratDTO.getTva());
		return contrat;
	}

	private void updateEntity(Contrat contrat, ContratDTO contratDTO) throws Exception {
		contrat.setCode(contratDTO.getCode());
		contrat.setDateCreate(contratDTO.getDateCreate());
		contrat.setDateMiseEnplace(contratDTO.getDateMiseEnplace());
		contrat.setDurée(contratDTO.getDurée());
		contrat.setGestionnaire(getGestionnaire(contratDTO.getGestionnaire()));
		contrat.setLibelle(contratDTO.getLibelle());
		contrat.setListBiens(listBien(contratDTO));
		contrat.setPeriodicite(contratDTO.getPeriodicite());
		contrat.setProprietaire(getGestionnaire(contratDTO.getProprietaire()));
		contrat.setStatut(contratDTO.getStatut());
		contrat.setTva(contratDTO.getTva());
	}

	private ContratDTO toDTO(Contrat contrat) {
		ContratDTO contratDTO = new ContratDTO();
		contratDTO.setCode(contrat.getCode());
		contratDTO.setDateCreate(contrat.getDateCreate());
		contratDTO.setDateMiseEnplace(contrat.getDateMiseEnplace());
		contratDTO.setDurée(contrat.getDurée());
		contratDTO.setLibelle(contrat.getLibelle());
		contratDTO.setMontant(contrat.getMontant());
		return contratDTO;
	}

	private Gestionnaire getGestionnaire(String code) {
		return (Gestionnaire) personneRepository.findPersonneByCode(code).get(0);
	}

	private Set<Bien> listBien(ContratDTO contratDTO) throws Exception {
		Set<BienDTO> bienDTOs = contratDTO.getListBiensDTP();
		Set<Bien> biens = new HashSet<>();
		for (BienDTO bienDTO : bienDTOs) {
			biens.add(bienService.toEntity(bienDTO));
		}
		return biens;
	}

	@Override
	public Loyer saveLoyer(LoyerDTO loyerDTO) throws Exception {
		Loyer loyer = toEntityLoyer(loyerDTO);
		return loyerRepository.save(loyer);
	}

	@Override
	public Loyer updateLoyer(Long id, LoyerDTO loyerDTO) throws Exception {
		Optional<Loyer> optionalLoyer = loyerRepository.findById(id);
		if (!optionalLoyer.isPresent()) {
			throw new Exception("Pas de Loyer correspondant à cet id: " + id);
		}
		Loyer loyer = optionalLoyer.get();
		updateLoyerEntity(loyer, loyerDTO);
		return loyerRepository.saveAndFlush(loyer);
	}

	@Override
	public Set<LoyerDTO> listLoyer() throws Exception {
		List<Loyer> loyers = loyerRepository.findAll();
		Set<LoyerDTO> loyerDTOs = new HashSet<>();
		for (Loyer loyer : loyers) {
			loyerDTOs.add(toDTOLoyer(loyer));
		}
		return loyerDTOs;
	}

	@Override
	public void deleteLoyer(Loyer loyer) throws Exception {
		loyerRepository.delete(loyer);
	}

	@Override
	public void deleteLoyerById(Long id) throws Exception {
		loyerRepository.deleteById(id);
	}

	@Override
	public Loyer updateLoyerByCode(String code, LoyerDTO loyerDTO) throws Exception {
		List<Loyer> loyers = loyerRepository.findLoyerByCode(code);
		if (loyers.isEmpty()) {
			throw new Exception("Pas de Loyer correspondant à ce code: " + code);
		}
		Loyer loyer = loyers.get(0);
		updateLoyerEntity(loyer, loyerDTO);
		return loyerRepository.saveAndFlush(loyer);
	}

	@Override
	public List<LoyerDTO> listLoyerByEtat(EEtatLoyer etat) throws Exception {
		List<Loyer> loyers = loyerRepository.findByEtatLoyer(etat);
		List<LoyerDTO> loyerDTOs = new ArrayList<>();
		for (Loyer loyer : loyers) {
			loyerDTOs.add(toDTOLoyer(loyer));
		}
		return loyerDTOs;
	}

	@Override
	public LoyerDTO findLoyerByCode(String code) throws Exception {
		List<Loyer> loyers = loyerRepository.findLoyerByCode(code);
		if (loyers.isEmpty()) {
			return null;
		}
		return toDTOLoyer(loyers.get(0));
	}

	@Override
	public List<LoyerDTO> findLoyerByDatePerception(Date datePerception) throws Exception {
		List<Loyer> loyers = loyerRepository.findByDatePerception(datePerception);
		List<LoyerDTO> loyerDTOs = new ArrayList<>();
		for (Loyer loyer : loyers) {
			loyerDTOs.add(toDTOLoyer(loyer));
		}
		return loyerDTOs;
	}

	@Override
	public List<LoyerDTO> findLoyerByContrat(Contrat contrat) throws Exception {
		List<Loyer> loyers = loyerRepository.findByContrat(contrat);
		List<LoyerDTO> loyerDTOs = new ArrayList<>();
		for (Loyer loyer : loyers) {
			loyerDTOs.add(toDTOLoyer(loyer));
		}
		return loyerDTOs;
	}

	private Loyer toEntityLoyer(LoyerDTO loyerDTO) throws Exception {
		ContratDTO contratDTO = findByCode(loyerDTO.getContrat());
		Contrat contrat = toEntity(contratDTO);
		Loyer loyer = new Loyer();
		loyer.setCode(UtilsAPP.genCode());
		loyer.setContrat(contrat); // À corriger si nécessaire
		loyer.setDateCreation(loyerDTO.getDateCreation());
		loyer.setDescription(loyerDTO.getDescription());
		loyer.setMontant(loyerDTO.getMontant());
		return loyer;
	}

	private void updateLoyerEntity(Loyer loyer, LoyerDTO loyerDTO) {
		loyer.setCode(loyerDTO.getCode());
		loyer.setDateCreation(loyerDTO.getDateCreation());
		loyer.setDescription(loyerDTO.getDescription());
		loyer.setMontant(loyerDTO.getMontant());
	}

	private LoyerDTO toDTOLoyer(Loyer loyer) {
		LoyerDTO dto = new LoyerDTO();
		dto.setCode(loyer.getCode());
		dto.setDateCreation(loyer.getDateCreation());
		dto.setDateModif(loyer.getDateModif());
		dto.setDatePerception(loyer.getDatePerception());
		dto.setEtatLoyer(loyer.getEtatLoyer());
		dto.setMontant(loyer.getMontant());
		return dto;
	}
}