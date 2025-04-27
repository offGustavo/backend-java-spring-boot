// src/main/java/com/turboorder/model/Produto.java
package com.turboorder.model;

import jakarta.persistence.*;

@Entity
@Table(name = "pro_produto")
public class Produto {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "pro_id")
  private Integer id;

  @Column(name = "pro_nome", length = 20)
  private String nome;

  @Column(name = "pro_tipo", length = 20)
  private String tipo;

  @Column(name = "pro_ativo")
  private Boolean ativo;

  // Construtores
  public Produto() {
  }

  public Produto(Integer id, String nome, String tipo, Boolean ativo) {
    this.id = id;
    this.nome = nome;
    this.tipo = tipo;
    this.ativo = ativo;
  }

  // Getters e Setters
  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getTipo() {
    return tipo;
  }

  public void setTipo(String tipo) {
    this.tipo = tipo;
  }

  public Boolean getAtivo() {
    return ativo;
  }

  public void setAtivo(Boolean ativo) {
    this.ativo = ativo;
  }
}
