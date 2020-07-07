package negocio;

import java.util.ArrayList;
import java.util.Collections;

public class Eleicoes {
	private ArrayList<Candidato> lista;
	
	public Eleicoes() {
		lista = new ArrayList<Candidato>();
		lista.add(new Candidato("Lucas","PT",30,1532));
		lista.add(new Candidato("Pedro","PSOL",40,342));
		lista.add(new Candidato("Ana","NOVO",29,1234));
		lista.add(new Candidato("Gustavo","PMDB",35,250));
	}
	
	private void sortIdade() {
		IdadeCompare idadeCompare = new IdadeCompare();
		Collections.sort(lista,idadeCompare);
	}
	
	private void sortVotos() {
		VotosCompare votosCompare = new VotosCompare();
		Collections.sort(lista,votosCompare);
	}

	public Candidato retornaMaisJovem() {
		sortIdade();
		return lista.get(0);
	}
	
	public Candidato retornaMaisVelho() {
		sortIdade();
		return lista.get(lista.size()-1);
	}
	
	public Candidato retornaMaisVotado() {
		sortVotos();
		return lista.get(lista.size()-1);
	}
	
	public Candidato retornaMenosVotado() {
		sortVotos();
		return lista.get(0);
	}
	
	public int retornaTotalVotos() {
		int t = 0;
		for(Candidato c : lista) {
			t += c.getVotos();
		}
		return t;
	}
	
	public double retornaMediaVotacao() {
		return retornaTotalVotos() / Double.valueOf(lista.size());
	}
}
