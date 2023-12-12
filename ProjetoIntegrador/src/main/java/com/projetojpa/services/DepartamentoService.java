package com.projetojpa.services; 

import java.util.List; 
import java.util.Optional; 
import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.stereotype.Service; 
import com.projetojpa.entities.Departamento; 
import com.projetojpa.repository.DepartamentoRepository; 


@Service 
public class DepartamentoService { 

	private final DepartamentoRepository departamentoRepository; 

	@Autowired 
	public DepartamentoService(DepartamentoRepository departamentoRepository) { 
		this.departamentoRepository = departamentoRepository; 
	} 
	public List<Departamento> buscaTodosDepartamentos(){ 
		return departamentoRepository.findAll(); 
	} 
	public Departamento buscaDepartamentoId(Long id) { 
		Optional <Departamento> Departamento = departamentoRepository.findById(id); 
		return Departamento.orElse(null); 
	} 
	public Departamento salvaDepartamento(Departamento Departamento) { 
		return departamentoRepository.save(Departamento); 
	} 
	public Departamento alterarDepartamento( Long id, Departamento alterarDepartamento) { 
		Optional<Departamento> existeDepartamento = departamentoRepository.findById(id); 
		if(existeDepartamento.isPresent()) { 
			alterarDepartamento.setId(id); 
			return departamentoRepository.save(alterarDepartamento); 
		} 
		return null; 
	} 
	public boolean apagarDepartamento(Long id) { 
		Optional<Departamento> existeDepartamento = departamentoRepository.findById(id); 
		if(existeDepartamento.isPresent()) { 
			departamentoRepository.deleteById(id); 
			return true; 
		} 
		return false; 
	} 



} 