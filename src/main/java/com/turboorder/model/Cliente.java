
package com.turboorder.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "cli_cliente")
public class Cliente {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer cliId;

  private String cliNome;
  private String cliSobrenome;
  private Integer cliNumero;
  private String cliComplemento;
  private Boolean cliAtivo = true;
  private Integer empresaFk;

  @ManyToOne
  @JoinColumn(name = "contato_fk")
  private Contato contato;

  @ManyToOne
  @JoinColumn(name = "endereco_fk")
  private Endereco endereco;
}
