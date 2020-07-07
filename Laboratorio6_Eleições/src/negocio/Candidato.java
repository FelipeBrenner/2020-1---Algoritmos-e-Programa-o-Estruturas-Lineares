package negocio;

public class Candidato implements Comparable<Candidato> {
	private String nome;
	private String partido;
	private int idade;
	private int votos;
	
	public Candidato(String nome, String partido, int idade, int votos) {
		this.nome = nome;
		this.partido = partido;
		this.idade = idade;
		this.votos = votos;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getPartido() {
		return partido;
	}
	
	public void setPartido(String partido) {
		this.partido = partido;
	}
	
	public int getIdade() {
		return idade;
	}
	
	public void setIdade(int idade) {
		this.idade = idade;
	}
	
	public int getVotos() {
		return votos;
	}
	
	public void setVotos(int votos) {
		this.votos = votos;
	}
	
	@Override
	public String toString() {
		return nome + ", " + partido + ", " + idade + " anos, " + votos + " votos";
	}
	
	@Override
	public int compareTo(Candidato c) {
		return this.nome.compareTo(c.nome);
	}
	
}
