package com.perfum.perfumeria.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.perfum.perfumeria.model.Cliente;
public interface ClienteRepository extends JpaRepository<Cliente, Long> {}