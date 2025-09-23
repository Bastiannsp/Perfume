package com.perfum.perfumeria.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.perfum.perfumeria.repository.DetallePedidoRepository;

import org.springframework.ui.Model;

@Controller
public class KpiController {
  private final DetallePedidoRepository detalleRepo;

  public KpiController(DetallePedidoRepository detalleRepo) {
    this.detalleRepo = detalleRepo;
  }

  @GetMapping("/kpi")
  public String kpi(Model model) {
  model.addAttribute("ventasPorMarca", detalleRepo.kpiVentasPorMarca());
  model.addAttribute("ventasPorCategoria", detalleRepo.kpiVentasPorCategoria());
  return "kpi";
}
}