package com.perfum.perfumeria.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.perfum.perfumeria.model.Pedido;
public interface PedidoRepository extends JpaRepository<Pedido, Long> {}
