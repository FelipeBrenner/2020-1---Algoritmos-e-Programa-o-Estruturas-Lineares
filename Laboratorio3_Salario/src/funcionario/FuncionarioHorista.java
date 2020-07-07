package funcionario;

public class FuncionarioHorista extends Funcionario{
	private int horasSemanais;
	private double salarioPorHora;
	
	public FuncionarioHorista(String nome, String CPF) {
		super.setNome(nome);
		super.setCpf(CPF);
	}
	
	public int getHorasSemanais() {
		return horasSemanais;
	}
	
	public void setHorasSemanais(int horasSemanais) {
		this.horasSemanais = horasSemanais;
	}
	
	public double getSalarioPorHora() {
		return salarioPorHora;
	}
	
	public void setSalarioPorHora(double salarioPorHora) {
		this.salarioPorHora = salarioPorHora;
	}
	
	@Override
	public double getRendimentos() {
		// Considerando que o mês tenha sempre 4 semanas cheias
		if(getHorasSemanais()<40)
			return 4 * getSalarioPorHora() * getHorasSemanais();
		else
			return 4 * (40 * getSalarioPorHora() + (getHorasSemanais() - 40) * getSalarioPorHora() * 1.5);
	}
	
	@Override
	public String toString() {
		return super.toString() + "\tHoras Semanais: " + getHorasSemanais() + "h\tSalário por Hora: R$ " + getSalarioPorHora();
	}
}
