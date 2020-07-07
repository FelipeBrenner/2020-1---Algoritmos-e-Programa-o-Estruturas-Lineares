package ui;

import java.util.Scanner;

import negocio.Celular;
import negocio.Contato;

public class OpcoesUI {
	private Scanner teclado;
	private Celular celular;
	private int opcao;
	
	public OpcoesUI() {
		teclado = new Scanner(System.in);
		celular = new Celular();
	}
	
	public void menu() {
		imprimirOpcoes();
		while(opcao!=6) {
			leOpcao();
		}
	}

	private void imprimirOpcoes() {
		System.out.println("[1] Cadastrar contato\n" + 
				"[2] Remover contato\n" + 
				"[3] Cadastrar chamada não atendida\n" + 
				"[4] Mostrar lista de chamadas não atendidas\n" + 
				"[5] Excluir todas chamadas não atendidas\n" + 
				"[6] Sair");
	}
	
	private void leOpcao() {
		System.out.println("\nDigite a opção que deseja executar: ");
		opcao = teclado.nextInt();
		switch(opcao) {
		case 1:
			cadastrarContato();
			break;
		case 2:
			removerContato();
			break;
		case 3:
			cadastrarChamada();
			break;
		case 4:
			mostrarChamadas();
			break;
		case 5:
			excluirChamadas();
			break;
		case 6:
			break;
		default:
			System.out.println("Opção inválida!");
		}
	}
	
	private Contato leContato() {
		String numero;
		String nome;
		
		System.out.println("Digite o número do telefone do contato: ");
		numero = teclado.next();
		System.out.println("Digite o nome do contato: ");
		nome = teclado.next();
		
		Contato telefone = new Contato(numero, nome);
		return telefone;
	}

	private void cadastrarContato() {
		System.out.println("\n[1] Cadastrar contato");
		if(celular.cadastrarContato(leContato()))
			System.out.println("Contato cadastrado com sucesso!");
		else
			System.out.println("Contato já cadastrado!");
	}

	private void removerContato() {
		System.out.println("\n[2] Remover contato");
		if(celular.removerContato(leContato()))
			System.out.println("Contato removido com sucesso!");
		else
			System.out.println("Contato não está cadastrado!");
	}

	private void cadastrarChamada() {
		System.out.println("\n[3] Cadastrar chamada não atendida\n" +
				"Digite o número do telefone: ");
		celular.cadastrarChamada(teclado.next());
		System.out.println("Chamada não atendida cadastrada com sucesso!");
	}

	private void mostrarChamadas() {
		System.out.println("\n[4] Mostrar lista de chamadas não atendidas" + celular.mostraChamadas());
	}

	private void excluirChamadas() {
		System.out.println("\n[5] Excluir todas chamadas não atendidas");
		celular.excluirChamadas();
		System.out.println("Chamadas não atendidas excluídas com sucesso!");
	}
	
}
