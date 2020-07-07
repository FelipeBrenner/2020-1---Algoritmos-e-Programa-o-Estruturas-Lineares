package funcionario;

public abstract class Funcionario {
	private String nome;
	private String CPF;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return CPF;
	}
	public void setCpf(String CPF) {
		this.CPF = CPF;
	}
	
	@Override
	public String toString() {
		return "Salário Mensal: R$" + getRendimentos();
	}
	
	public abstract double getRendimentos();
}
