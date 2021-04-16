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

			Perguntar se o pagamento é a vista, caso seja a vista e valor for maior que R$ 100 reais dar um desconto de 10%
			temos promoção levou 10 ganhou 10%, ou seja se for 10 caixas dar 10% de desconto

			Caso o pagamento seja parcelado acrescentar 15% sobre o valor total segundo a tebela
			2x = 5%
			3x = 8%
			4x = 10%
			5x = 13%
			maior que 5x = 15%

			Obs: aceitar parcelas no máximo até 12 meses, e mostrar o valor de cada parcela já com acrescimo 


			O lucro do comerciante será de 45% em suas vendas

			Dar um relatório final sobre a operação acima

		*/

		System.out.println("===========================================");
		System.out.println("Seja muito bem vindo joão ao seu software");
		System.out.println("===========================================");
		Console cnsl = System.console();
		int quantidadeCaixas = Integer.parseInt(cnsl.readLine("Digite a quantidade de caixas que você pretende vender?\n"));

		System.out.println("[" + quantidadeCaixas + "]");

		double valorLaranja = 0.50;
		int quantidadeCaixasPromocao = 3;
		int quantidadeDeLaranjaPorCaixa = 50;
		int porcentagemLucro = 40;
		int porcentagemDesconto = 10;
		int porcentagemAcrescimo = 15;
		int maximoParcelas = 12;
		double valorParaDesconto = 100;
		int totalDeLaranjas = quantidadeCaixas * quantidadeDeLaranjaPorCaixa;
		double valorTotal = totalDeLaranjas * valorLaranja;
		double valorTotalAlterado = valorTotal;
		int parcelas = 0;

		String tipoPagamento = cnsl.readLine("Você deseja pagar a vista ou parcelado ?\n A - À vista\n P - Parcelado\n");

		boolean aVista = tipoPagamento.toUpperCase().equals("A");
		if(aVista){
			System.out.println("Você selecionou o pagamento a vista");
			if(valorTotal > valorParaDesconto || quantidadeCaixas == quantidadeCaixasPromocao){
				valorTotalAlterado -= (valorTotal * porcentagemDesconto / 100);
			}
		}
		else{
			parcelas = Integer.parseInt(cnsl.readLine("Você selecionou o pagamento a parcelado, Digite a quantidade de parcelas\n"));
			if(parcelas > maximoParcelas){
				System.out.println("Quantidade de parcelas inválida, iremos assumir em " + maximoParcelas + " vezes");
				parcelas = maximoParcelas;
			}

			if(parcelas == 1){
				System.out.println("Você selecionou o pagamento a vista");
				if(valorTotal > valorParaDesconto || quantidadeCaixas == quantidadeCaixasPromocao){
					valorTotalAlterado -= (valorTotal * porcentagemDesconto / 100);
				}
			}
			else if(parcelas > 5) 
				valorTotalAlterado += (valorTotal * porcentagemAcrescimo / 100);
			else{
				switch(parcelas) {
					case 2:
						porcentagemAcrescimo = 5;
						break;
					case 3:
						porcentagemAcrescimo = 8;
						break;
					case 4:
						porcentagemAcrescimo = 10;
						break;
					case 5:
						porcentagemAcrescimo = 13;
						break;
				}
				valorTotalAlterado += (valorTotal * porcentagemAcrescimo / 100);
			}

		}

		double lucroAReceber = (valorTotalAlterado * porcentagemLucro / 100);

		System.out.println("===========================================");
		System.out.println("Muito bem seu João parabéns pela venda");
		System.out.println("O seu lucro é de: R$ " + lucroAReceber);
		System.out.println("O valor total a cobrar do cliente é de: R$ " + valorTotalAlterado);
		System.out.println("O cliente escolheu o tipo de pagamento: " + (aVista ? "À vista" : "Parcelado em " + parcelas + " vezes")  );
		if(aVista){
			System.out.println("Para o pagamento a vista demos o desconto dê: R$ " + (valorTotal - valorTotalAlterado));
		}
		else{
			System.out.println("Para o pagamento a parcelado colocamos um acrescimo dê: R$ " + (valorTotalAlterado - valorTotal));
			System.out.println("O valor da parcela será de: R$ " + (valorTotalAlterado / parcelas) );
		}
		System.out.println("===========================================");


		//SpringApplication.run(AppConsoleApplication.class, args);
	}

}
