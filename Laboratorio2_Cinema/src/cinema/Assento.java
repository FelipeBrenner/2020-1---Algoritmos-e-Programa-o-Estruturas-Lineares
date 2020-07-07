package cinema;

public class Assento {
	private boolean assento[][] = new boolean[12][14];
	private int lugaresLivres, lugaresOcupados;
	
	public Assento() {
		lugaresLivres = 84;
		lugaresOcupados = 0;
	}
	
	public boolean assentoLivre(char x, int y) {
		return !assento[codigoAssentoLetraParaNumero(x)][y-1];
	}
	
	public void reservar(char x, int y) {
		if(assentoLivre(x,y)) {
			assento[codigoAssentoLetraParaNumero(x)][y-1] = true;
			lugaresLivres--;
			lugaresOcupados++;
			System.out.println("Assento reservado com sucesso!");
		}
		else
			System.out.println("Assento já está reservado!");
	}
	
	public void cancelar(char x, int y) {
		if(assentoLivre(x,y))
			System.out.println("Assento não está reservado!");
		else {
			assento[codigoAssentoLetraParaNumero(x)][y-1] = false;
			lugaresLivres++;
			lugaresOcupados--;
			System.out.println("Reserva do assento cancelada com sucesso!");
		}
	}
	
	public int getLugaresLivres() {
		return lugaresLivres;
	}
	
	public int getLugaresOcupados() {
		return lugaresOcupados;
	}
	
	private int codigoAssentoLetraParaNumero(char x) {
		return (int) x - 65;
	}
	
	public char codigoAssentoNumeroParaLetra(int x) {
		return (char) (x + 65);
	}
}
