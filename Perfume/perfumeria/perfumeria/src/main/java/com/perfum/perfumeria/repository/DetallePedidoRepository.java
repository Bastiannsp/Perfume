package com.perfum.perfumeria.repository;

import com.perfum.perfumeria.dto.TopPerfume;
import com.perfum.perfumeria.dto.VentasPorFecha;
import com.perfum.perfumeria.model.DetallePedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface DetallePedidoRepository extends JpaRepository<DetallePedido, Long> {

    // KPI 1: Ventas por perfume (más vendido) — unidades y monto
    @Query("""
      select pf.nombre as perfume,
             sum(d.cantidad) as unidades,
             sum(d.cantidad * d.precioUnit) as ventas
      from DetallePedido d
      join d.pedido p
      join d.perfume pf
      where (:desde is null or p.fecha >= :desde)
        and (:hasta is null or p.fecha < :hasta)
      group by pf.nombre
      order by sum(d.cantidad) desc, sum(d.cantidad * d.precioUnit) desc
    """)
    List<TopPerfume> kpiTopPerfume(@Param("desde") LocalDateTime desde,
                                   @Param("hasta") LocalDateTime hasta);

    // KPI 3: Ventas por período (día)
    @Query("""
      select function('date', p.fecha) as fecha,
             sum(d.cantidad * d.precioUnit) as ventas
      from DetallePedido d
      join d.pedido p
      where (:desde is null or p.fecha >= :desde)
        and (:hasta is null or p.fecha < :hasta)
      group by function('date', p.fecha)
      order by function('date', p.fecha)
    """)
    List<VentasPorFecha> kpiVentasPorFecha(@Param("desde") LocalDateTime desde,
                                           @Param("hasta") LocalDateTime hasta);
}
