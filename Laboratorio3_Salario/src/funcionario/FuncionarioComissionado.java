package funcionario;

public class FuncionarioComissionado extends Funcionario{
	private double taxaComissao;
	private double vendasBrutas;
	
	public FuncionarioComissionado(String nome, String CPF) {
		super.setNome(nome);
		super.setCpf(CPF);
	}
	
	public double getTaxaComissao() {
		return taxaComissao;
	}
	
	public void setTaxaComissao(double taxaComissao) {
		this.taxaComissao = taxaComissao;
	}
	
	public double getVendasBrutas() {
		return vendasBrutas;
	}
	
	public void setVendasBrutas(double vendasBrutas) {
		this.vendasBrutas = vendasBrutas;
	}
	
	@Override
	public double getRendimentos() {
		return getTaxaComissao() * getVendasBrutas();
	}
	
	@Override
	public String toString() {
		return super.toString() + "\tComissão: R$" + getTaxaComissao() + "\tPercentual de Vendas: " + getVendasBrutas()*100 + "%";
	}

}
