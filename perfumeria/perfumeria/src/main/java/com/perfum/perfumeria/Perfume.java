package com.perfum.perfumeria;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Getter; import lombok.Setter;

@Entity @Getter @Setter
public class Perfume {
  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotBlank
  private String nombre;

  @NotNull @DecimalMin("0.0")
  private Double precio;

  @NotNull @Min(0)
  private Integer stock;

  @ManyToOne(optional = false) @JoinColumn(name = "marca_id")
  private Marca marca;

  @ManyToOne(optional = false) @JoinColumn(name = "categoria_id")
  private Categoria categoria;
}
