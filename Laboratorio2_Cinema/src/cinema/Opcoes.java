package cinema;

import java.util.Scanner;

import cinema.Assento;

public class Opcoes {
	Scanner le = new Scanner(System.in);
	String assento;
	
	public Opcoes() {
	}
	
	public void reservar(Assento cinema) {
		System.out.println("\nDigite o assento a reservar (ex: C4): ");
		assento = le.next();
		if(assentoValido(assento))
			cinema.reservar(assento.charAt(0), numeroAssento(assento));
	}
	
	public void cancelar(Assento cinema) {
		System.out.println("\nDigite o assento para cancelar a reserva: ");
		assento = le.next();
		if(assentoValido(assento))
			cinema.cancelar(assento.charAt(0), numeroAssento(assento));
	}
	
	private boolean assentoValido(String assento) {
		try {
			int x = assento.charAt(0);
			int y = numeroAssento(assento);
			
			if(x>=65 && x<=76 && y>0 && y<15)
				return true;
			else {
				System.out.println("Assento inválido!");
				return false;
			}
		}
		catch(Exception e) {
			System.out.println("Assento inválido!");
			return false;
		}
	}
	
	private int numeroAssento(String assento) {
		if(assento.length()>2)
			return Integer.parseInt(assento.substring(1, 3));
		else
			return Integer.parseInt(assento.substring(1, 2));
	}
	
}
