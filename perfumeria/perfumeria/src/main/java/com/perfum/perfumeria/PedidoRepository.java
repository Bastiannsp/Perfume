package com.perfum.perfumeria;

import com.perfum.perfumeria.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
public interface PedidoRepository extends JpaRepository<Pedido, Long> {}
