// src/main/java/com/turboorder/model/Produto.java
package com.turboorder.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * Produto
 */
@Entity
@Table(name = "pro_produto")
public class Produto {

  // TODO: change this
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "pro_id")
  private Integer proId;

  @Column(name = "pro_nome", length = 20)
  private String proNome;

  @Column(name = "pro_tipo", length = 20)
  private String proTipo;

  @Column(name = "pro_ativo")
  private Boolean proAtivo;

  public Produto() {
  }

  public Produto(Integer proId, String proNome, String proTipo, Boolean proAtivo) {
    this.proId = proId;
    this.proNome = proNome;
    this.proTipo = proTipo;
    this.proAtivo = proAtivo;
  }

  public Integer getProId() {
    return proId;
  }

  public void setProId(Integer proId) {
    this.proId = proId;
  }

  public String getProNome() {
    return proNome;
  }

  public void setProNome(String proNome) {
    if (proNome.isEmpty() && proNome.length() > 20) {
      throw new IllegalArgumentException("Nome do produto não pode ser vazio ou maior que 20 caracteres");
    }
    this.proNome = proNome;
  }

  public String getProTipo() {
    return proTipo;
  }

  public void setProTipo(String proTipo) {
    this.proTipo = proTipo;
  }

  public Boolean getProAtivo() {
    return proAtivo;
  }

  public void setProAtivo(Boolean proAtivo) {
    this.proAtivo = proAtivo;
  }

}
