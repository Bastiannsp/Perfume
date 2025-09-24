package com.perfum.perfumeria.repository;

import com.perfum.perfumeria.dto.ClienteFrecuencia;
import com.perfum.perfumeria.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {

    // KPI 2: Clientes con mayor frecuencia de compra (n° de pedidos)
    @Query("""
      select p.cliente.nombre as cliente,
             count(p) as pedidos
      from Pedido p
      where (:desde is null or p.fecha >= :desde)
        and (:hasta is null or p.fecha < :hasta)
      group by p.cliente.nombre
      order by count(p) desc
    """)
    List<ClienteFrecuencia> kpiClientesFrecuentes(@Param("desde") LocalDateTime desde,
                                                  @Param("hasta") LocalDateTime hasta);
}

