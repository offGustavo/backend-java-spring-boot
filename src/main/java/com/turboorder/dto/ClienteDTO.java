package com.turboorder.dto;

import lombok.Data;

@Data
public class ClienteDTO {
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

  public Integer getCliId() {
    return cliId;
  }

  public void setCliId(Integer cliId) {
    this.cliId = cliId;
  }

  public String getCliNome() {
    return cliNome;
  }

  public void setCliNome(String cliNome) {
    this.cliNome = cliNome;
  }

  public String getCliSobrenome() {
    return cliSobrenome;
  }

  public void setCliSobrenome(String cliSobrenome) {
    this.cliSobrenome = cliSobrenome;
  }

  public String getConTelefone() {
    return conTelefone;
  }

  public void setConTelefone(String conTelefone) {
    this.conTelefone = conTelefone;
  }

  public String getCliCep() {
    return cliCep;
  }

  public void setCliCep(String cliCep) {
    this.cliCep = cliCep;
  }

  public String getCliEndereco() {
    return cliEndereco;
  }

  public void setCliEndereco(String cliEndereco) {
    this.cliEndereco = cliEndereco;
  }

  public String getCliBairro() {
    return cliBairro;
  }

  public void setCliBairro(String cliBairro) {
    this.cliBairro = cliBairro;
  }

  public String getCliCidade() {
    return cliCidade;
  }

  public void setCliCidade(String cliCidade) {
    this.cliCidade = cliCidade;
  }

  public Integer getCliNumero() {
    return cliNumero;
  }

  public void setCliNumero(Integer cliNumero) {
    this.cliNumero = cliNumero;
  }

  public String getCliComplemento() {
    return cliComplemento;
  }

  public void setCliComplemento(String cliComplemento) {
    this.cliComplemento = cliComplemento;
  }
}
