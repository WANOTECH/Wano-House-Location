package com.app.gest.immo.implementation;

import com.app.gest.immo.dto.ParametreDTO;
import com.app.gest.immo.entities.Parametre;
import com.app.gest.immo.entities.TypeParametre;
import com.app.gest.immo.repository.IParametreRepository;
import com.app.gest.immo.repository.ITypeParamRepository;
import com.app.gest.immo.service.IParametre;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class ParametreImpl implements IParametre {

	private final IParametreRepository iParam;
	private final ITypeParamRepository iTyepeParam;

	public ParametreImpl(IParametreRepository iParam, ITypeParamRepository iTyepeParam) {
        this.iParam = iParam;
		//this.typeMapper = typeMapper;
        this.iTyepeParam = iTyepeParam;
    }

	@Override
	public Parametre save(ParametreDTO typeParamDTO) throws Exception {
		Parametre typeParam = toEntity(typeParamDTO);
		return iParam.save(typeParam);
	}

	@Override
	public Parametre update(Long id, ParametreDTO typeParamDTO) throws Exception {
		Optional<Parametre> typeParam = iParam.findById(id);
		if(typeParam.get()==null) {
			throw new Exception("Pas de Type Param correspondant à cet id" + " -" + id);
		}
		Parametre type = typeParam.get();
		type = toEntity(typeParamDTO);
		return iParam.saveAndFlush(type);
	}

	@Override
	public Set<ParametreDTO> list() throws Exception {
		List<Parametre> list = iParam.findAll();
		Set<ParametreDTO> setType = new HashSet<ParametreDTO>();
		if (list == null || list.isEmpty()) {
			return null;
		}
		for (Parametre type : list){
			setType.add(toDTO(type));
		}
		return setType;
	}

	@Override
	public void delete(Parametre typeParam) throws Exception {
		iParam.delete(typeParam);
		
	}

	@Override
	public void deleteById(Long id) throws Exception {
		Optional<Parametre> typeParam = iParam.findById(id);
		if(typeParam.get()==null) {
			throw new Exception("Pas de Type Param correspondant à cet id" + " -" + id);
		}
		Parametre type = typeParam.get();
		iParam.delete(type);
		
	}

	@Override
	public ParametreDTO findByCode(String code) throws Exception {
		List<Parametre> listTypeParam = iParam.findParametreByCode(code);
		if (listTypeParam==null || listTypeParam.isEmpty()) {
			throw new Exception("Liste vide");
		}
		Parametre type = listTypeParam.get(0);
		return toDTO(type);
	}

	@Override
	public Parametre updateByCode(String code, ParametreDTO tyParamDTO) throws Exception {
		Parametre type = iParam.findParametreByCode(code).get(0);
		if(type==null) {
			throw new Exception("Pas de Type Param correspondant à cet id" + " -" + code);
		}
		Parametre typ = toEntity(tyParamDTO);
		return iParam.saveAndFlush(typ);
	}

	Parametre toEntity(ParametreDTO parametreDTO){
		Parametre param = new Parametre();
		TypeParametre typeParametre = iTyepeParam.findTypeParametreByCode(parametreDTO.getTypeParam()).get(0);
		param.setCode(parametreDTO.getCode());
		param.setTypeParam(typeParametre);
		param.setChampLibre1(parametreDTO.getChampLibre1());
		param.setChampLibre2(parametreDTO.getChampLibre2());
		param.setChampLibre3(parametreDTO.getChampLibre3());
		param.setLibelle(parametreDTO.getLibelle());
		return param;
	}

	ParametreDTO toDTO(Parametre parametre){
		ParametreDTO param = new ParametreDTO();
		param.setCode(parametre.getCode());
		param.setTypeParam(parametre.getCode());
		param.setChampLibre1(parametre.getChampLibre1());
		param.setChampLibre2(parametre.getChampLibre2());
		param.setChampLibre3(parametre.getChampLibre3());
		param.setLibelle(parametre.getLibelle());
		return param;
	}

}
