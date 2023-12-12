package com.projetojpa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projetojpa.entities.Cliente;
import com.projetojpa.entities.Departamento;
import com.projetojpa.entities.Empresa;
import com.projetojpa.entities.Fornecedor;
import com.projetojpa.entities.Funcionario;
import com.projetojpa.entities.Projeto;
import com.projetojpa.services.ClienteService;
import com.projetojpa.services.DepartamentoService;
import com.projetojpa.services.EmpresaService;
import com.projetojpa.services.FornecedorService;
import com.projetojpa.services.FuncionarioService;
import com.projetojpa.services.ProjetoService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Api Externa", description = "API REST EXTERNA")
@RestController
@RequestMapping("/apiExterna")
public class ApiExternaController {
	
	private final ClienteService clienteService;
	private final DepartamentoService departamentoService;
	private final EmpresaService empresaService;
	private final FornecedorService fornecedorService;
	private final FuncionarioService funcionarioService;
	private final ProjetoService projetoService;
	
	@Autowired
	public ApiExternaController(ClienteService clienteService,DepartamentoService departamentoService,EmpresaService empresaService,FornecedorService fornecedorService,FuncionarioService funcionarioService,ProjetoService projetoService) {
		this.clienteService = clienteService;
		this.departamentoService = departamentoService;
		this.empresaService = empresaService;
		this.fornecedorService = fornecedorService;
		this.funcionarioService = funcionarioService;
		this.projetoService = projetoService;
	}
	
	
	@GetMapping("/clientes")
	@Operation(summary = "Apresenta todos os clientes")
	public ResponseEntity<List<Cliente>> buscaTodosClientesControl(){
		List<Cliente>Cliente = clienteService.buscaTodosClientes();
		return ResponseEntity.ok(Cliente);
	}
	
	@GetMapping("/departamentos") 
	@Operation(summary = "Apresenta todos os departamentos") 
	public ResponseEntity<List<Departamento>> buscaTodosDepartamentosControl(){ 
		List<Departamento>Departamento = departamentoService.buscaTodosDepartamentos(); 
		return ResponseEntity.ok(Departamento); 
	} 
	
	@GetMapping("/empresas") 
	@Operation(summary = "Apresenta todos os empresas") 
	public ResponseEntity<List<Empresa>> buscaTodosEmpresasControl(){ 
		List<Empresa>Empresa = empresaService.buscaTodosEmpresas(); 
		return ResponseEntity.ok(Empresa); 
	} 
	
	@GetMapping("/fornecedores")
	@Operation(summary = "Apresenta todos os fornecedores")
	public ResponseEntity<List<Fornecedor>> buscaTodosFornecedoresControl(){
		List<Fornecedor>Fornecedor = fornecedorService.buscaTodosFornecedores();
		return ResponseEntity.ok(Fornecedor);
	}
	
	@GetMapping("/funcionarios") 
	@Operation(summary = "Apresenta todos os funcionarios") 
	public ResponseEntity<List<Funcionario>> buscaTodosFuncionariosControl(){ 
		List<Funcionario>Funcionario = funcionarioService.buscaTodosFuncionarios(); 
		return ResponseEntity.ok(Funcionario); 
	} 
	
	@GetMapping("/projetos") 
	@Operation(summary = "Apresenta todos os projetos") 
	public ResponseEntity<List<Projeto>> buscaTodosProjetosControl(){ 
		List<Projeto>Projeto = projetoService.buscaTodosProjetos(); 
		return ResponseEntity.ok(Projeto); 
	} 

}
