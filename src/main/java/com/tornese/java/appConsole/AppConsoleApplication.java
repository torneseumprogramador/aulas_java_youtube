package com.tornese.java.appConsole;

// import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.io.*;

@SpringBootApplication
public class AppConsoleApplication {

	public static void main(String[] args) {
		/*
			João é um comerciante que vende laranjas
			Ele precisa fazer uma entrega de algumas caixas
			cada laranja ele vende por 0,50 centavos, cada caixa tem 50 laranjas

			Faça um programa que peça a quantidade de caixas para o joão e de o total a receber
		*/

		System.out.println("===========================================");
		System.out.println("Seja muito bem vindo joão ao seu software");
		System.out.println("===========================================");
		Console cnsl = System.console();
		int quantidadeCaixas = Integer.parseInt(cnsl.readLine("Digite a quantidade de caixas que você pretende vender?\n"));

		System.out.println("[" + quantidadeCaixas + "]");

		double valorLaranja = 0.50;
		int quantidadeDeLaranjaPorCaixa = 50;
		int totalDeLaranjas = quantidadeCaixas * quantidadeDeLaranjaPorCaixa;
		double valorTotal = totalDeLaranjas * valorLaranja;

		System.out.println("===========================================");
		System.out.println("Muito bem seu João parabéns pela venda");
		System.out.println("O valor total a receber é de: R$ " + valorTotal);
		System.out.println("===========================================");


		//SpringApplication.run(AppConsoleApplication.class, args);
	}

}
