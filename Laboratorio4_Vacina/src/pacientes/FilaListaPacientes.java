package pacientes;

import java.util.PriorityQueue;
import java.util.ArrayList;

public class FilaListaPacientes {
	PriorityQueue<Paciente> filaPacientes;
	ArrayList<Paciente> listaPacientes;
	
	public FilaListaPacientes() {
		filaPacientes = new PriorityQueue<Paciente>();
		listaPacientes = new ArrayList<Paciente>();
	}
	
	public void entrarNaFila(Paciente paciente) {
		filaPacientes.add(paciente);
	}

	public void entrarNaFila(Paciente... pacientes) {
		for (Paciente paciente : pacientes) {
			filaPacientes.add(paciente);
		}
	}
	
	public void vacinar() {
		if(filaPacientes.size()>0) {
			Paciente paciente = filaPacientes.remove();
			listaPacientes.add(paciente);
		}
	}
	
	public void vacinarTodos() {
		while (filaPacientes.size() > 0) {
			vacinar();
		}
	}
	
	public void apresentaDadosFila() {
		System.out.println("Pacientes na fila de vacinação: ");
		if(filaPacientes.size() == 0) {
			System.out.println("Nenhum");
		}
		else {
			PriorityQueue<Paciente> filaCopia = new PriorityQueue<Paciente>(filaPacientes);
			while (filaCopia.size() != 0) {
				Paciente paciente = filaCopia.remove();
				System.out.println(paciente.toString());
			}
		}
		System.out.println();
	}
	
	public void apresentaDadosLista() {
		System.out.println("Pacientes já vacinados: ");
		if(listaPacientes.size() == 0) {
			System.out.println("Nenhum");
		}
		else {
			for(Paciente paciente : listaPacientes) {
				System.out.println(paciente);
			}
		}
		System.out.println();
	}
	
}
