package com.turboorder.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "end_endereco")
public class Endereco {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer endId;

  private String endCep;
  private String endRua;
  private String endBairro;
  private String endCidade;
}
