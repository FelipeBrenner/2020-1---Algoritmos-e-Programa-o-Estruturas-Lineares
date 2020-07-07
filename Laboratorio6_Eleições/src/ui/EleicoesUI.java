package ui;

import java.util.Scanner;

import negocio.Eleicoes;

public class EleicoesUI {
	private Scanner teclado;
	private Eleicoes eleicoes;
	private int opcao;
	
	public EleicoesUI() {
		teclado = new Scanner(System.in);
		eleicoes =  new Eleicoes();
	}
	
	public void menu() {
		imprimirOpcoes();
		while(opcao!=7) {
			leOpcao();
		}
	}

	private void imprimirOpcoes() {
		System.out.println("[1] Exibir candidato mais jovem\n" + 
				"[2] Exibir candidato mais velho\n" + 
				"[3] Exibir candidato mais votado\n" + 
				"[4] Exibir candidato menos votado\n" + 
				"[5] Exibir total de votos recebidos por todos os canditados\n" + 
				"[6] Exibir Média de votação recebida pelos candidatos\n" + 
				"[7] Sair");
	}
	
	private void leOpcao() {
		System.out.println("\nDigite a opção que deseja executar: ");
		opcao = teclado.nextInt();
		switch(opcao) {
		case 1:
			System.out.println("Candidato mais jovem: " + eleicoes.retornaMaisJovem());
			break;
		case 2:
			System.out.println("Candidato mais velho: " + eleicoes.retornaMaisVelho());
			break;
		case 3:
			System.out.println("Candidato mais votado: " + eleicoes.retornaMaisVotado());
			break;
		case 4:
			System.out.println("Candidato menos votado: " + eleicoes.retornaMenosVotado());
			break;
		case 5:
			System.out.println("Total de votos: " + eleicoes.retornaTotalVotos());
			break;
		case 6:
			System.out.println("Média de votos por candidato: " + eleicoes.retornaMediaVotacao());
			break;
		case 7:
			break;
		default:
			System.out.println("Opção inválida!");
		}
	}
	
}
