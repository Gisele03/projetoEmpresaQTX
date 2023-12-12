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

import com.projetojpa.entities.Projeto; 
import com.projetojpa.services.ProjetoService; 

import io.swagger.v3.oas.annotations.Operation; 
import io.swagger.v3.oas.annotations.tags.Tag; 
import jakarta.validation.Valid; 

@Tag(name = "Projeto", description = "API REST DE GERENCIAMENTO DE PROJETO") 
@RestController 
@RequestMapping("/projeto") 
@CrossOrigin(origins= "*")
public class ProjetoController { 
	private final ProjetoService projetoService; 

	@Autowired 
	public ProjetoController(ProjetoService projetoService) { 
		this.projetoService = projetoService; 
	} 
	@GetMapping("/{id}") 
	@Operation(summary = "Localiza o projeto por ID") 
	public ResponseEntity<Projeto> buscaProjetoControlId(@PathVariable Long id){ 
		Projeto projeto = projetoService.buscaProjetoId(id); 
		if(projeto != null) { 
			return ResponseEntity.ok(projeto); 
		} 
		else { 
			return ResponseEntity.notFound().build(); 
		} 
	} 
	@GetMapping
	@Operation(summary = "Apresenta todos os projetos") 
	public ResponseEntity<List<Projeto>> buscaTodosProjetosControl(){ 
		List<Projeto>Projeto = projetoService.buscaTodosProjetos(); 
		return ResponseEntity.ok(Projeto); 
	} 
	@PostMapping
	@Operation(summary	= "Cadastra um projeto") 
	public ResponseEntity<Projeto> salvaProjetosControl(@RequestBody @Valid Projeto projeto){ 
		Projeto salvaProjeto = projetoService.salvaProjeto(projeto); 
		return ResponseEntity.status(HttpStatus.CREATED).body(salvaProjeto); 
	} 
	@PutMapping("/{id}") 
	@Operation(summary = "Altera um projeto") 
	public ResponseEntity<Projeto> alteraProjetoControl(@PathVariable Long id, @RequestBody @Valid Projeto projeto){ 
		Projeto alteraProjeto = projetoService.alterarProjeto(id, projeto); 
		if(alteraProjeto != null) { 
			return ResponseEntity.ok(projeto); 
		} 
		else { 
			return ResponseEntity.notFound().build(); 
		} 
	} 
	@DeleteMapping("/{id}") 
	@Operation(summary = "Deleta um projeto") 
	public ResponseEntity<Projeto> apagaProjetoControl(@PathVariable Long id){ 
		boolean apagar = projetoService.apagarProjeto(id); 
		if (apagar) { 
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build(); 
		} 
		else { 
			return ResponseEntity.notFound().build(); 
		} 
	} 
} 
