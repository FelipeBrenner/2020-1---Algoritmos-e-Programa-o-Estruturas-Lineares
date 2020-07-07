package pacientes;

public class Paciente implements Comparable<Paciente> {
	private String nome;
	private int idade;
	
	public Paciente (String nome, int idade) {
		this.nome = nome;
		this.idade = idade;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public int getIdade() {
		return idade;
	}
	
	public void setIdade(int idade) {
		this.idade = idade;
	}
	
	@Override
	public String toString() {
		return getNome() + ", " + getIdade();
	}
	
	@Override
	public int compareTo(Paciente outroPaciente) {
		if (this.idade > outroPaciente.getIdade()) 
			return -1;
		if (this.idade < outroPaciente.getIdade()) 
			return 1;
		return 0;
	}
}
