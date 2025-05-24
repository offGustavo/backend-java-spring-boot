package com.turboorder.model;

public class PedPedido {
   private Integer pedId;
   private Cliente cliCliente;
   private Endereco endEndereco;

    public PedPedido(Endereco endEndereco, Cliente cliCliente, Integer pedId) {
        this.endEndereco = endEndereco;
        this.cliCliente = cliCliente;
        this.pedId = pedId;
    }

    public Endereco getEndEndereco() {
        return endEndereco;
    }

    public void setEndEndereco(Endereco endEndereco) {
        this.endEndereco = endEndereco;
    }

    public Cliente getCliCliente() {
        return cliCliente;
    }

    public void setCliCliente(Cliente cliCliente) {
        this.cliCliente = cliCliente;
    }

    public Integer getPedId() {
        return pedId;
    }

    public void setPedId(Integer pedId) {
        this.pedId = pedId;
    }
}


