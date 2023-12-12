package com.projetojpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projetojpa.entities.Projeto;

public interface ProjetoRepository extends JpaRepository<Projeto, Long> {

}
