
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
    if(!(cliNome.isEmpty()) && cliNome.length() < 256){
      this.cliNome = cliNome;
    }
    throw new IllegalArgumentException("O nome do cliente não pode ser vazio ou exceder 256 caracteres");
 }

  public String getCliSobrenome() {
    return cliSobrenome;
  }

  public void setCliSobrenome(String cliSobrenome) {
    this.cliSobrenome = cliSobrenome;
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

  public Boolean getCliAtivo() {
    return cliAtivo;
  }

  public void setCliAtivo(Boolean cliAtivo) {
    this.cliAtivo = cliAtivo;
  }

  public Integer getEmpresaFk() {
    return empresaFk;
  }

  public void setEmpresaFk(Integer empresaFk) {
    this.empresaFk = empresaFk;
  }

  public Contato getContato() {
    return contato;
  }

  public void setContato(Contato contato) {
    this.contato = contato;
  }

  public Endereco getEndereco() {
    return endereco;
  }

  public void setEndereco(Endereco endereco) {
    this.endereco = endereco;
  }

}
