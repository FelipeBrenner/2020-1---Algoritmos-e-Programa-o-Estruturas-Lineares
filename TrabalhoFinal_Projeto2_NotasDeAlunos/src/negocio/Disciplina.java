package negocio;

public class Disciplina implements Comparable<Disciplina> {
	private int codigo;
	private String nome;
	
	public Disciplina(int codigo, String nome) {
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
		return "Disciplina: " + nome + "\tCódigo: " + codigo;
	}
	
	@Override
	public int compareTo(Disciplina d) {
		if(codigo > d.codigo)
			return 1;
		if(codigo < d.codigo)
			return -1;
		return 0;
	}
	
}
