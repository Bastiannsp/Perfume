package com.perfum.perfumeria;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter; import lombok.Setter;

@Entity @Getter @Setter
public class Marca {
  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotBlank @Column(unique = true, nullable = false)
  private String nombre;
}
