package com.tornese.java.appConsole.entidades;

public class Pedido {
  private Cliente cliente;
  private int quantidadeDeCaixas;
  private double valorTotal;
  private int totalDeLaranjas = 0;
  private double valorTotalAlterado = 0;
  private int parcelas = 0;
  private int porcentagemAcrescimo = 0;
  private double lucroAReceber = 0;

  public Cliente getCliente() {
    return cliente;
  }

  public double getLucroAReceber() {
    return lucroAReceber;
  }

  public int getParcelas() {
    return parcelas;
  }

  public void setParcelas(int parcelas) {
    this.parcelas = parcelas;
  }

  public double getValorTotalAlterado() {
    return valorTotalAlterado;
  }

  public void setValorTotalAlterado(double valorTotalAlterado) {
    this.valorTotalAlterado = valorTotalAlterado;
  }

  public int getTotalDeLaranjas() {
    return totalDeLaranjas;
  }

  public void setTotalDeLaranjas(int quantidadeCaixas, double valorLaranja, int quantidadeDeLaranjaPorCaixa) {
    this.totalDeLaranjas = quantidadeCaixas * quantidadeDeLaranjaPorCaixa;
    this.setValorTotal(totalDeLaranjas * valorLaranja);
  }

  public void setCliente(Cliente cliente) {
    this.cliente = cliente;
  }

  public int getQuantidadeDeCaixas() {
    return quantidadeDeCaixas;
  }

  public void setQuantidadeDeCaixas(int quantidadeDeCaixas) {
    this.quantidadeDeCaixas = quantidadeDeCaixas;
  }

  public double getValorTotal() {
    return valorTotal;
  }

  public void setValorTotal(double valorTotal) {
    this.valorTotal = valorTotal;
    this.valorTotalAlterado = this.valorTotal;
  }

  public void alterarValorParaPagamentoAVista(double valorParaDesconto, int quantidadeCaixas,
      int quantidadeCaixasPromocao, int porcentagemDesconto) {
    if (this.valorTotal > valorParaDesconto || quantidadeCaixas == quantidadeCaixasPromocao) {
      this.valorTotalAlterado -= (valorTotal * porcentagemDesconto / 100);
    }
  }

  public void acrescentaJuros(int porcentagemAcrescimoPadrao) {
    this.porcentagemAcrescimo = porcentagemAcrescimoPadrao;
    if (this.parcelas <= 5) {
      switch (this.parcelas) {
        case 2:
          this.porcentagemAcrescimo = 5;
          break;
        case 3:
          this.porcentagemAcrescimo = 8;
          break;
        case 4:
          this.porcentagemAcrescimo = 10;
          break;
        case 5:
          this.porcentagemAcrescimo = 13;
          break;
      }
    }

    this.valorTotalAlterado += (this.valorTotal * this.porcentagemAcrescimo / 100);
  }

  public void calculaLucroReceber(int porcentagemLucro){
    this.lucroAReceber = this.valorTotalAlterado * porcentagemLucro / 100;
  }

  public double valorTotalComDesconto() {
    return this.valorTotal - this.valorTotalAlterado;
  }

  public double valorDoJuros() {
    return this.valorTotalAlterado - this.valorTotal;
  }

  public double valorParcela() {
    return this.valorTotalAlterado / this.parcelas;
  }
}
