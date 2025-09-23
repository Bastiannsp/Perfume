package com.perfum.perfumeria.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.perfum.perfumeria.model.Perfume;

public interface PerfumeRepository extends JpaRepository<Perfume, Long> {}
