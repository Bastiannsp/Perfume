package com.perfum.perfumeria.controller;

import com.perfum.perfumeria.repository.DetallePedidoRepository;
import com.perfum.perfumeria.repository.PedidoRepository;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Controller
public class KpiController {

  private final DetallePedidoRepository detalleRepo;
  private final PedidoRepository pedidoRepo;

  public KpiController(DetallePedidoRepository detalleRepo, PedidoRepository pedidoRepo) {
    this.detalleRepo = detalleRepo;
    this.pedidoRepo = pedidoRepo;
  }

  @GetMapping("/kpi")
  public String kpi(
      @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate desde,
      @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate hasta,
      Model model) {

    // Convertimos LocalDate -> LocalDateTime (rango [desde, hasta))
    LocalDateTime from = (desde != null) ? desde.atStartOfDay() : null;
    LocalDateTime to   = (hasta != null) ? hasta.plusDays(1).atStartOfDay() : null;

    model.addAttribute("desde", desde);
    model.addAttribute("hasta", hasta);

    // KPI 1: Top perfumes (unidades y ventas)
    model.addAttribute("topPerfumes", detalleRepo.kpiTopPerfume(from, to));

    // KPI 2: Clientes más frecuentes (n° de pedidos)
    model.addAttribute("clientesFrecuentes", pedidoRepo.kpiClientesFrecuentes(from, to));

    // KPI 3: Ventas por periodo (día)
    model.addAttribute("ventasPorFecha", detalleRepo.kpiVentasPorFecha(from, to));

    return "kpi";
  }
}
