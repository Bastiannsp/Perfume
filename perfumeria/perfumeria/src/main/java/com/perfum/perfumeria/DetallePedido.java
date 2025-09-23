package com.perfum.perfumeria;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Getter; import lombok.Setter;

@Entity @Getter @Setter
public class DetallePedido {
  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne(optional = false) @JoinColumn(name = "pedido_id")
  private Pedido pedido;

  @ManyToOne(optional = false) @JoinColumn(name = "perfume_id")
  private Perfume perfume;

  @Min(1) private int cantidad;

  // Guardamos el precio al momento de la venta
  @DecimalMin("0.0") private double precioUnit;
}
