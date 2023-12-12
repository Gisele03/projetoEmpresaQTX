package com.projetojpa.services; 

import java.util.List; 
import java.util.Optional; 
import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.stereotype.Service; 
import com.projetojpa.entities.Empresa; 
import com.projetojpa.repository.EmpresaRepository; 

@Service 
public class EmpresaService { 
	private final EmpresaRepository empresaRepository; 

	@Autowired 
	public EmpresaService(EmpresaRepository empresaRepository) { 
		this.empresaRepository = empresaRepository; 
	} 
	public List<Empresa> buscaTodosEmpresas(){ 
		return empresaRepository.findAll(); 
	} 
	public Empresa buscaEmpresaId(Long id) { 
		Optional <Empresa> Empresa = empresaRepository.findById(id); 
		return Empresa.orElse(null); 
	} 
	public Empresa salvaEmpresa(Empresa Empresa) { 
		return empresaRepository.save(Empresa); 
	} 
	public Empresa alterarEmpresa( Long id, Empresa alterarEmpresa) { 
		Optional<Empresa> existeEmpresa = empresaRepository.findById(id); 
		if(existeEmpresa.isPresent()) { 
			alterarEmpresa.setId(id); 
			return empresaRepository.save(alterarEmpresa); 
		} 
		return null; 
	} 
	public boolean apagarEmpresa(Long id) { 
		Optional<Empresa> existeEmpresa = empresaRepository.findById(id); 
		if(existeEmpresa.isPresent()) { 
			empresaRepository.deleteById(id); 
			return true; 
		} 
		return false; 
	} 
 

} 