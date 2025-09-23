package com.perfum.perfumeria.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.perfum.perfumeria.repository.PedidoRepository;

@Controller
public class PedidoController {

  private final PedidoRepository repo;

  public PedidoController(PedidoRepository repo) { this.repo = repo; }

  @GetMapping("/pedidos")
  public String listar(Model model) {
    model.addAttribute("pedidos", repo.findAll());
    return "pedidos";
  }
}
