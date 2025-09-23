package com.perfum.perfumeria.model;
import jakarta.persistence.*;
import lombok.Getter; import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity @Getter @Setter
public class Pedido {
  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne(optional = false) @JoinColumn(name = "cliente_id")
  private Cliente cliente;

  private LocalDateTime fecha = LocalDateTime.now();

  @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL, orphanRemoval = true)
  private List<DetallePedido> detalles = new ArrayList<>();

  // Helper para KPI/total
  public double getTotal() {
    return detalles.stream()
      .mapToDouble(d -> d.getPrecioUnit() * d.getCantidad())
      .sum();
  }
}
