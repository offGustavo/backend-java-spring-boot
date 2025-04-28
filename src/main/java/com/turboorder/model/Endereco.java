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

  public Integer getEndId() {
    return endId;
  }

  public void setEndId(Integer endId) {
    this.endId = endId;
  }

  public String getEndCep() {
    return endCep;
  }

  public void setEndCep(String endCep) {
    this.endCep = endCep;
  }

  public String getEndRua() {
    return endRua;
  }

  public void setEndRua(String endRua) {
    this.endRua = endRua;
  }

  public String getEndBairro() {
    return endBairro;
  }

  public void setEndBairro(String endBairro) {
    this.endBairro = endBairro;
  }

  public String getEndCidade() {
    return endCidade;
  }

  public void setEndCidade(String endCidade) {
    this.endCidade = endCidade;
  }
}
