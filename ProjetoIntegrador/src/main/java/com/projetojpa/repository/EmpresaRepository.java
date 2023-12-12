package com.projetojpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projetojpa.entities.Empresa;

public interface EmpresaRepository extends JpaRepository<Empresa, Long> {

}
