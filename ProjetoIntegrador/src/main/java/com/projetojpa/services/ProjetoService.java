package com.projetojpa.services; 

import java.util.List; 
import java.util.Optional; 
import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.stereotype.Service; 
import com.projetojpa.entities.Projeto; 
import com.projetojpa.repository.ProjetoRepository; 

@Service 
public class ProjetoService { 

	private final ProjetoRepository projetoRepository; 

	@Autowired 
	public ProjetoService(ProjetoRepository projetoRepository) { 
		this.projetoRepository = projetoRepository; 
	} 
	public List<Projeto> buscaTodosProjetos(){ 
		return projetoRepository.findAll(); 
	} 
	public Projeto buscaProjetoId(Long id) { 
		Optional <Projeto> Projeto = projetoRepository.findById(id); 
		return Projeto.orElse(null); 
	} 
	public Projeto salvaProjeto(Projeto Projeto) { 
		return projetoRepository.save(Projeto); 
	} 
	public Projeto alterarProjeto( Long id, Projeto alterarProjeto) { 
		Optional<Projeto> existeProjeto = projetoRepository.findById(id); 
		if(existeProjeto.isPresent()) { 
			alterarProjeto.setId(id); 
			return projetoRepository.save(alterarProjeto); 
		} 
		return null; 
	} 
	public boolean apagarProjeto(Long id) { 
		Optional<Projeto> existeProjeto = projetoRepository.findById(id); 
		if(existeProjeto.isPresent()) { 
			projetoRepository.deleteById(id); 
			return true; 
		} 
		return false; 
	} 



} 
