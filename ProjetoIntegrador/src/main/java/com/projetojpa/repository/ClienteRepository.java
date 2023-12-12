package com.projetojpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projetojpa.entities.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}