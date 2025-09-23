package com.perfum.perfumeria;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Getter; import lombok.Setter;

@Entity @Getter @Setter
public class Cliente {
  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotBlank private String nombre;
  @Email @NotBlank @Column(unique = true) private String email;
}
