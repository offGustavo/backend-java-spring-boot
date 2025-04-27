package com.turboorder.dto;

import lombok.Data;

@Data
public class ClientDTO {
  private Integer cliId;
  private String cliNome;
  private String cliSobrenome;
  private String conTelefone;
  private String cliCep;
  private String cliEndereco;
  private String cliBairro;
  private String cliCidade;
  private Integer cliNumero;
  private String cliComplemento;
}
