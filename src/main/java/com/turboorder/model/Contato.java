package com.turboorder.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "con_contato")
public class Contato {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer conId;

  private String conTelefone;

  public Integer getConId() {
    return conId;
  }

  public void setConId(Integer conId) {
    this.conId = conId;
  }

  public String getConTelefone() {
    return conTelefone;
  }

  public void setConTelefone(String conTelefone) {
    this.conTelefone = conTelefone;
  }
}
