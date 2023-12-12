package com.projetojpa.controller; 

import java.util.List; 
import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.http.HttpStatus; 
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping; 
import org.springframework.web.bind.annotation.GetMapping; 
import org.springframework.web.bind.annotation.PathVariable; 
import org.springframework.web.bind.annotation.PostMapping; 
import org.springframework.web.bind.annotation.PutMapping; 
import org.springframework.web.bind.annotation.RequestBody; 
import org.springframework.web.bind.annotation.RequestMapping; 
import org.springframework.web.bind.annotation.RestController; 

import com.projetojpa.entities.Departamento; 
import com.projetojpa.services.DepartamentoService;

import io.swagger.v3.oas.annotations.Operation; 
import io.swagger.v3.oas.annotations.tags.Tag; 
import jakarta.validation.Valid; 

@Tag(name = "Departamento", description = "API REST DE GERENCIAMENTO DE DEPARTAMENTO") 
@RestController 
@RequestMapping("/departamento") 
@CrossOrigin(origins= "*")
public class DepartamentoController { 

	private final DepartamentoService departamentoService; 

	@Autowired 
	public DepartamentoController(DepartamentoService departamentoService) { 
		this.departamentoService = departamentoService; 
	} 
	@GetMapping("/{id}") 
	@Operation(summary = "Localiza o departamento por ID") 
	public ResponseEntity<Departamento> buscaDepartamentoControlId(@PathVariable Long id){ 
		Departamento departamento = departamentoService.buscaDepartamentoId(id); 
		if(departamento != null) { 
			return ResponseEntity.ok(departamento); 
		} 
		else { 
			return ResponseEntity.notFound().build(); 
		} 
	} 
	@GetMapping
	@Operation(summary = "Apresenta todos os departamentos") 
	public ResponseEntity<List<Departamento>> buscaTodosDepartamentosControl(){ 
		List<Departamento>Departamento = departamentoService.buscaTodosDepartamentos(); 
		return ResponseEntity.ok(Departamento); 
	} 
	@PostMapping
	@Operation(summary	= "Cadastra um departamento") 
	public ResponseEntity<Departamento> salvaDepartamentosControl(@RequestBody @Valid Departamento departamento){ 
		Departamento salvaDepartamento = departamentoService.salvaDepartamento(departamento); 
		return ResponseEntity.status(HttpStatus.CREATED).body(salvaDepartamento); 
	} 
	@PutMapping("/{id}") 
	@Operation(summary = "Altera um departamento") 
	public ResponseEntity<Departamento> alteraDepartamentoControl(@PathVariable Long id, @RequestBody @Valid Departamento departamento){ 
		Departamento alteraDepartamento = departamentoService.alterarDepartamento(id, departamento); 
		if(alteraDepartamento != null) { 
			return ResponseEntity.ok(departamento); 
		} 
		else { 
			return ResponseEntity.notFound().build(); 
		} 
	} 
	@DeleteMapping("/{id}") 
	@Operation(summary = "Deleta um departamento") 
	public ResponseEntity<Departamento> apagaDepartamentoControl(@PathVariable Long id){ 
		boolean apagar = departamentoService.apagarDepartamento(id); 
		if (apagar) { 
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build(); 
		} 
		else { 
			return ResponseEntity.notFound().build(); 
		} 
	} 
} 