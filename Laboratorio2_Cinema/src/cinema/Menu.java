package cinema;

import java.util.Scanner;

import cinema.Mapa;
import cinema.Opcoes;
import cinema.Assento;

public class Menu {
	Scanner le = new Scanner(System.in);
	private Assento cinema = new Assento();
	private Opcoes opcoes = new Opcoes();
	private Mapa mapa = new Mapa();
	
	public Menu() {		
	}
	
	public void exibeMenu() {
		while(true) {
			System.out.println("Menu\n"
					+ "1. Mostrar assentos\n"
					+ "2. Realizar uma reserva\n"
					+ "3. Cancelar uma reserva\n"
					+ "4. Total de lugares livres/ocupados");
			switch(le.nextInt()) {
				case 1:
					mapa.exibeMapa(cinema);
					break;
				case 2:
					opcoes.reservar(cinema);
					break;
				case 3:
					opcoes.cancelar(cinema);
					break;
				case 4:
					System.out.println("\nLugares Livres: " + cinema.getLugaresLivres() + "\nLugares Ocupados: " + cinema.getLugaresOcupados());
					break;
				default:
					System.out.println("Opção inválida!");
			}
		System.out.println();
		}
	}
	
}
