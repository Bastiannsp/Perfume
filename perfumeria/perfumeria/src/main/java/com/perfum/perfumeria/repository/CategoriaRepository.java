package com.perfum.perfumeria.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.perfum.perfumeria.model.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {}