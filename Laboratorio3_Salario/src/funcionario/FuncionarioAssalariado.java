package funcionario;

public class FuncionarioAssalariado extends Funcionario{
	private double salarioSemanal;
	
	public FuncionarioAssalariado(String nome, String CPF) {
		super.setNome(nome);
		super.setCpf(CPF);
	}
	
	public double getSalarioSemanal() {
		return salarioSemanal;
	}
	
	public void setSalarioSemanal(double salarioSemanal) {
		this.salarioSemanal = salarioSemanal;
	}
	
	@Override
	public double getRendimentos() {
		// Considerando que o m�s tenha sempre 4 semanas cheias
		return getSalarioSemanal()*4;
	}
	
	@Override
	public String toString() {
		return super.toString() + "\tSal�rio Semanal: R$" + getSalarioSemanal();
	}
}


