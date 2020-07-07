package ui;

import java.io.IOException;
import java.util.Scanner;

import negocio.Aluno;
import negocio.Curso;
import negocio.Disciplina;
import negocio.NotasAlunoDisciplina;

public class OpcoesUI {
	private Scanner teclado;
	private Curso curso;
	private int opcao;
	private int codigoAluno;
	private int codigoDisciplina;
	private String nome;
	private double nota;
	
	public OpcoesUI() {
		teclado = new Scanner(System.in);
		curso = new Curso();
	}
	
	public void menu() throws IOException {
		curso.leArquivos();
		while(opcao!=7) {
			imprimirOpcoes();
			leOpcao();
		}
		curso.gravaArquivos();
	}

	private void imprimirOpcoes() {
		System.out.println("[1] Inserir aluno\n" + 
				"[2] Inserir Disciplina\n" + 
				"[3] Vincular aluno e disciplina\n" +
				"[4] Adicionar nota na avalia��o\n" + 
				"[5] Calcular m�dias\n" + 
				"[6] Listar todos os alunos com as suas disciplinas e m�dias\n" + 
				"[7] Sair");
	}
	
	private void leOpcao() {
		try {
			System.out.println("\nDigite a op��o que deseja executar: ");
			opcao = teclado.nextInt();
			switch(opcao) {
			case 1:
				inserirAluno();
				break;
			case 2:
				inserirDisciplina();
				break;
			case 3:
				vincularAlunoDisciplina();
				break;
			case 4:
				adicionarNota();
				break;
			case 5:
				curso.calcularMedia();
				System.out.println("M�dias calculadas com sucesso! Escolher op��o [6] para visualiz�-las.");
				break;
			case 6:
				listarInfos();
				break;
			case 7:
				break;
			default:
				System.out.println("Op��o inv�lida!");
			}
		}
		catch(Exception e) {
			teclado.nextLine();
			System.out.println("Digita��o inv�lida!");
		}
		System.out.println();
	}

	private void inserirAluno() {
		System.out.println("Digite o c�digo do aluno: ");
		codigoAluno = teclado.nextInt();
		teclado.nextLine();
		System.out.println("Digite o nome do aluno: ");
		nome = teclado.nextLine();
		if(curso.inserirAluno(new Aluno(codigoAluno,nome)))
			System.out.println("Aluno inserido com sucesso!");
		else
			System.out.println("Aluno j� inserido!");
	}

	private void inserirDisciplina() {
		System.out.println("Digite o c�digo da disciplina: ");
		codigoDisciplina = teclado.nextInt();
		teclado.nextLine();
		System.out.println("Digite o nome da disciplina: ");
		nome = teclado.nextLine();
		if(curso.inserirDisciplina(new Disciplina(codigoDisciplina,nome)))
			System.out.println("Disciplina inserida com sucesso!");
		else
			System.out.println("Disciplina j� inserida!");		
	}
	
	private void vincularAlunoDisciplina() {
		System.out.println("Digite o c�digo do aluno que deseja vincular: ");
		codigoAluno = leCodigoAlunoExistente();
		System.out.println("Digite o c�digo da disciplina que deseja vincular: ");
		codigoDisciplina = leCodigoDisciplinaExistente();
		if(curso.vincularDisciplinaAluno(codigoAluno, codigoDisciplina))
			System.out.println("Disciplina " + codigoDisciplina + " vinculada com sucesso ao aluno " + codigoAluno + "!");
		else
			System.out.println("Disciplina " + codigoDisciplina + " j� est� vinculada ao aluno " + codigoAluno + "!");
	}
	
	private void adicionarNota() {
		System.out.println("Digite o c�digo do aluno que deseja adicionar nota: ");
		codigoAluno = leCodigoAlunoExistente();
		System.out.println("Digite o c�digo da disciplina que deseja adicionar nota: ");
		codigoDisciplina = leCodigoDisciplinaExistente();
		System.out.println("Qual avalia��o deseja adicionar nota? (1/2)");
		opcao = teclado.nextInt();
		if(opcao != 1 && opcao != 2)
			System.out.println("Op��o inv�lida!");
		else {
			System.out.println("Digite a nota: ");
			nota = teclado.nextDouble();
			while(nota<0 || nota>10) {
				if(nota<0)
					System.out.println("Nota � menor que 0, por favor digite novamente: ");
				else
					System.out.println("Nota � maior que 10, por favor digite novamente: ");
				nota = teclado.nextDouble();
			}
			if(opcao == 1)
				curso.getVinculo(codigoAluno, codigoDisciplina).setNota1(nota);
			else
				curso.getVinculo(codigoAluno, codigoDisciplina).setNota2(nota);
			System.out.println("Nota adicionada com sucesso!");
		}
		
	}
	
	private int leCodigoAlunoExistente() {
		codigoAluno = teclado.nextInt();
		while(curso.getAluno(codigoAluno) == null) {
			System.out.println("N�o existe aluno com este c�digo. Digite novamente: ");
			codigoAluno = teclado.nextInt();
		}
		return codigoAluno;
	}
	
	private int leCodigoDisciplinaExistente() {
		codigoDisciplina = teclado.nextInt();
		while(curso.getDisciplina(codigoDisciplina) == null) {
			System.out.println("N�o existe disciplina com este c�digo. Digite novamente: ");
			codigoDisciplina = teclado.nextInt();
		}
		return codigoDisciplina;
	}
	
	private void listarInfos() {
		
		for(Aluno a : curso.getAlunos()) {
			System.out.println(a);
			for(Disciplina d : curso.getDisciplinas()) {
				for(NotasAlunoDisciplina n : curso.getNotas()) {
					if(n.getCodigoAluno() == a.getCodigo() && n.getCodigoDisciplina() == d.getCodigo()) {
						System.out.print(d);
						System.out.println(n);
					}
				}
			}
		}
		
	}
	
}
