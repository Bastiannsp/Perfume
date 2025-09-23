package com.perfum.perfumeria.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.perfum.perfumeria.dto.VentasPorCategoria;
import com.perfum.perfumeria.dto.VentasPorMarca;
import com.perfum.perfumeria.model.DetallePedido;

public interface DetallePedidoRepository extends JpaRepository<DetallePedido, Long> {

    @Query("""
      select pf.marca.nombre as marca,
             sum(d.cantidad * d.precioUnit) as ventas
      from DetallePedido d
      join d.perfume pf
      group by pf.marca.nombre
      order by sum(d.cantidad * d.precioUnit) desc
    """)
    List<VentasPorMarca> kpiVentasPorMarca();

    @Query("""
    select pf.categoria.nombre as categoria,
           sum(d.cantidad * d.precioUnit) as ventas
    from DetallePedido d
    join d.perfume pf
    group by pf.categoria.nombre
    order by sum(d.cantidad * d.precioUnit) desc
    """)
    List<VentasPorCategoria> kpiVentasPorCategoria();

}