package funcionario;

public class FuncionarioComissionadoBaseSalario extends FuncionarioComissionado{
	private double salario;
	
	public FuncionarioComissionadoBaseSalario(String nome, String CPF) {
		super(nome, CPF);
	}
	
	public double getSalario() {
		return salario;
	}
	
	public void setSalario(double salario) {
		this.salario = salario;
	}
	
	@Override
	public double getRendimentos() {
		return getSalario() + getTaxaComissao() * getVendasBrutas();
	}
	
	@Override
	public String toString() {
		return super.toString() + "\tSalário Base: R$" + getSalario();
	}

}
