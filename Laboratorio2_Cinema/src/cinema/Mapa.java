package cinema;

import cinema.Assento;

public class Mapa{
	
	public Mapa() {
	}
	
	public void exibeMapa(Assento assento) {
		for(int x=0; x<12; x++)	{
			System.out.print("\n" + assento.codigoAssentoNumeroParaLetra(x));
			for(int y=0; y<7; y++) {
				if(assento.assentoLivre(assento.codigoAssentoNumeroParaLetra(x), y+1))
					System.out.print("  L"); 
				else 
					System.out.print("  O");
			}
			System.out.print("  ");
			for(int y=7; y<14; y++) {
				if(assento.assentoLivre(assento.codigoAssentoNumeroParaLetra(x), y+1))
					System.out.print("  L"); 
				else 
					System.out.print("  O");
			}
			System.out.print("  " + assento.codigoAssentoNumeroParaLetra(x));	
		}
		System.out.println("\n   1  2  3  4  5  6  7    8  9  10 11 12 13 14");
	}
	
}
