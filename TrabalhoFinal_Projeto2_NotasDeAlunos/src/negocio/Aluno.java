package negocio;

public class Aluno implements Comparable<Aluno>{
	private int codigo;
	private String nome;
	
	public Aluno(int codigo, String nome) {
		this.codigo = codigo;
		this.nome = nome;
	}
	
	public int getCodigo() {
		return codigo;
	}
	
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String toStringFile() {
		return codigo + ";" + nome;
	}
	
	@Override
	public String toString() {
		return "Aluno: " + nome + "\tCódigo: " + codigo;
	}

	@Override
	public int compareTo(Aluno a) {
		if(codigo > a.codigo)
			return 1;
		if(codigo < a.codigo)
			return -1;
		return 0;
	}
	
}
