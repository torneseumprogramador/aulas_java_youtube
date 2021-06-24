package com.tornese.java.appConsole.servicos;

public class Configuracao {
  private double valorLaranja = 0.50;
  private int quantidadeCaixasPromocao = 3;
  private int quantidadeDeLaranjaPorCaixa = 50;
  private int porcentagemLucro = 40;
  private int porcentagemDesconto = 10;
  private int porcentagemAcrescimo = 15;
  private int maximoParcelas = 12;
  private double valorParaDesconto = 100;

  public double getValorLaranja() {
    return valorLaranja;
  }
  public double getValorParaDesconto() {
    return valorParaDesconto;
  }
  public int getMaximoParcelas() {
    return maximoParcelas;
  }
  public int getPorcentagemDesconto() {
    return porcentagemDesconto;
  }
  public int getPorcentagemAcrescimo() {
    return porcentagemAcrescimo;
  }
  public int getPorcentagemLucro() {
    return porcentagemLucro;
  }
  public int getQuantidadeCaixasPromocao() {
    return quantidadeCaixasPromocao;
  }
  public int getQuantidadeDeLaranjaPorCaixa() {
    return quantidadeDeLaranjaPorCaixa;
  }
}
