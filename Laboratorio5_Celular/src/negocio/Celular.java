package negocio;

import java.util.ArrayList;
import java.util.List;

public class Celular {
	private List<String> chamadas;
	private List<Contato> contatos;
	
	public Celular() {
		chamadas = new ArrayList<>();
		contatos = new ArrayList<>();
	}
	
	public List<String> getChamadas() {
		return chamadas;
	}
	
	public List<Contato> getContatos() {
		return contatos;
	}
	
	public boolean cadastrarContato(Contato contato) {
		return contatos.add(contato);
	}
	
	public boolean removerContato(Contato contato) {
		return contatos.remove(contato);
	}
	
	public void cadastrarChamada(String chamada) {
		chamadas.add(chamada);
	}
	
	public String mostraChamadas() {
		String str = "";
		boolean chamadaComContato;
		
		for(String chamada : chamadas) {
			chamadaComContato = false;
			for(Contato contato : contatos) {
				if(contato.getNumero().equalsIgnoreCase(chamada))
				{
					chamadaComContato = true;
					str = str + "\n" + contato.getNome() + " " + chamada;
					break;
				}
			}
			if(!chamadaComContato)
				str = str + "\n" + chamada;
		}
		return str;
	}
	
	public void excluirChamadas() {
		while(chamadas.size()>0) {
			chamadas.remove(0);
		}
	}
	
}
