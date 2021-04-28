package com.tornese.java.appConsole;

// import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import com.tornese.java.appConsole.entidades.Cliente;

@SpringBootApplication
public class AppConsoleApplication {

	public static void main(String[] args) {

		// int[] array = new int[3];
		// array[0] = 1;
		// array[1] = 55;
		// array[2] = 63;

		// int[] valores = {1,3,4,9,8};

		// for(int valor : valores){
		// 	System.out.println(valor);
		// }

		// int[][] array2 = new int[3][2];
		// array2[0][0] = 1;
		// array2[0][1] = 2;

		// array2[1][0] = 1;
		// array2[1][1] = 2;

		// array2[2][0] = 1;
		// array2[2][1] = 2;

		// for(int valor : valores){
		// 	System.out.println(valor);
		// }


		// List<String> nomes = new ArrayList<String>();
		// nomes.add("Danilo");
		// nomes.add("Lana");

		// for(String nome : nomes){
		// 	System.out.println(nome);
		// }

		// List<List<String>> nomes2 = new ArrayList<List<String>>();
		// List<String> dados = new ArrayList<String>();
		// dados.add("Danilo");
		// dados.add("3");
		// nomes2.add(dados);

		// List<String> dados2 = new ArrayList<String>();
		// dados2.add("Denilson");
		// dados2.add("6");
		// nomes2.add(dados2);
		
		// for(List<String> nome : nomes2){
		// 	System.out.println(nome.get(0));
		// 	System.out.println(nome.get(1));
		// }

		// List<Integer> itens = Arrays.asList( 1, 2, 3, 5 );
    // itens.forEach(item->System.out.println(item));
		
		/*
		 * João é um comerciante que vende laranjas Ele precisa fazer uma entrega de
		 * algumas caixas cada laranja ele vende por 0,50 centavos, cada caixa tem 50
		 * laranjas
		 * 
		 * Faça um programa que peça a quantidade de caixas para o joão e de o total a
		 * receber
		 * 
		 * Perguntar se o pagamento é a vista, caso seja a vista e valor for maior que
		 * R$ 100 reais dar um desconto de 10% temos promoção levou 10 ganhou 10%, ou
		 * seja se for 10 caixas dar 10% de desconto
		 * 
		 * Caso o pagamento seja parcelado acrescentar 15% sobre o valor total segundo a
		 * tebela 2x = 5% 3x = 8% 4x = 10% 5x = 13% maior que 5x = 15%
		 * 
		 * Obs: aceitar parcelas no máximo até 12 meses, e mostrar o valor de cada
		 * parcela já com acrescimo
		 * 
		 * 
		 * O lucro do comerciante será de 45% em suas vendas
		 * 
		 * Dar um relatório final sobre a operação acima
		 * 
		 * armazene o nome e o valor do cliente para que o final da operação você possa mostrar
		 * o nome e a quantidade de caixas
		 * 
		 */

		List<Cliente> clientes = new ArrayList<Cliente>();

		while (true) {
			Console cnsl = System.console();
			System.out.println("===========================================");
			System.out.println("Seja muito bem vindo joão ao seu software");
			System.out.println("===========================================");
			int sair = Integer.parseInt(cnsl.readLine("Digite: \n1 para continuar \n0 para sair\n"));
			if(sair == 0) break;

			Cliente cliente = new Cliente();

			cliente.setNome(cnsl.readLine("Digite o nome do cliente que quer comprar as caixas:\n"));
			int quantidadeCaixas = Integer.parseInt(cnsl.readLine("Digite a quantidade de caixas que o " + cliente.getNome() + " deseja?\n"));
			cliente.setQuantidadeDeCaixas(quantidadeCaixas);

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
			if (aVista) {
				System.out.println("Você selecionou o pagamento a vista");
				if (valorTotal > valorParaDesconto || quantidadeCaixas == quantidadeCaixasPromocao) {
					valorTotalAlterado -= (valorTotal * porcentagemDesconto / 100);
				}
			} else {
				parcelas = Integer
						.parseInt(cnsl.readLine("Você selecionou o pagamento a parcelado, Digite a quantidade de parcelas\n"));
				if (parcelas > maximoParcelas) {
					System.out.println("Quantidade de parcelas inválida, iremos assumir em " + maximoParcelas + " vezes");
					parcelas = maximoParcelas;
				}

				if (parcelas == 1) {
					System.out.println("Você selecionou o pagamento a vista");
					if (valorTotal > valorParaDesconto || quantidadeCaixas == quantidadeCaixasPromocao) {
						valorTotalAlterado -= (valorTotal * porcentagemDesconto / 100);
					}
				} else if (parcelas > 5)
					valorTotalAlterado += (valorTotal * porcentagemAcrescimo / 100);
				else {
					switch (parcelas) {
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

			cliente.setValorTotal(valorTotalAlterado);

			clientes.add(cliente);

			System.out.println("===========================================");
			System.out.println("Muito bem seu João parabéns pela venda");
			System.out.println("O seu lucro é de: R$ " + lucroAReceber);
			System.out.println("O valor total a cobrar do cliente é de: R$ " + valorTotalAlterado);
			System.out.println(
					"O cliente escolheu o tipo de pagamento: " + (aVista ? "À vista" : "Parcelado em " + parcelas + " vezes"));
			if (aVista) {
				System.out.println("Para o pagamento a vista demos o desconto dê: R$ " + (valorTotal - valorTotalAlterado));
			} else {
				System.out
						.println("Para o pagamento a parcelado colocamos um acrescimo dê: R$ " + (valorTotalAlterado - valorTotal));
				System.out.println("O valor da parcela será de: R$ " + (valorTotalAlterado / parcelas));
			}
			System.out.println("===========================================");
		}

		for(int i=0; i<clientes.size(); i++){
			Cliente cliente = clientes.get(i);
			System.out.println("===========================================");
			System.out.println("Cliente: " + cliente.getNome());
			System.out.println("Quantidade de caixas: " + cliente.getQuantidadeDeCaixas());
			System.out.println("Valor total a pagar: " + cliente.getValorTotal());
			System.out.println("===========================================");
		}

		// SpringApplication.run(AppConsoleApplication.class, args);
	}

}
