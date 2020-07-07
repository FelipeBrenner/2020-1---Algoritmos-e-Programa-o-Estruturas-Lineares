package testes.ui;

import pacientes.FilaListaPacientes;
import pacientes.Paciente;

public class FilaListaPacientesTeste {

	public static void main(String[] args) {
		FilaListaPacientes fila = new FilaListaPacientes();
		
		Paciente p1 = new Paciente("Joana",25);
		Paciente p2 = new Paciente("Beatriz",60);
		Paciente p3 = new Paciente("Paulo",76);
		Paciente p4 = new Paciente("Joao",40);
		Paciente p5 = new Paciente("Isabella",9);
		
		fila.entrarNaFila(p1);
		fila.entrarNaFila(p2);
		fila.entrarNaFila(p3,p4,p5);
		
		fila.apresentaDadosFila();
		fila.apresentaDadosLista();
		
		System.out.println("Vacinando paciente ...");
		fila.vacinar();
		System.out.println("Vacinando paciente ...");
		fila.vacinar();
		System.out.println();
		
		fila.apresentaDadosFila();
		fila.apresentaDadosLista();
		
		System.out.println("Vacinando todos os pacientes ...");
		fila.vacinarTodos();
		System.out.println();
		
		fila.apresentaDadosFila();
		fila.apresentaDadosLista();
	}

}
