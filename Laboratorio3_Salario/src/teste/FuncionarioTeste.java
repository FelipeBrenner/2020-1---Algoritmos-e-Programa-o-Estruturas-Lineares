package teste;

import funcionario.FuncionarioAssalariado;
import funcionario.FuncionarioComissionado;
import funcionario.FuncionarioComissionadoBaseSalario;
import funcionario.FuncionarioHorista;

public class FuncionarioTeste {

	public static void main(String[] args) {
		
		FuncionarioComissionado funcionario1 = new FuncionarioComissionado("Funcionario1","045200348");
		FuncionarioComissionadoBaseSalario funcionario2= new FuncionarioComissionadoBaseSalario("Funcionario2","23459521023");
		FuncionarioAssalariado funcionario3 = new FuncionarioAssalariado("Funcionario3","25683841054");
		FuncionarioHorista funcionario4 = new FuncionarioHorista("Funcionario4","39478742953");
		FuncionarioHorista funcionario5 = new FuncionarioHorista("Funcionario5","54678259462");
		
		funcionario1.setTaxaComissao(2800);
		funcionario1.setVendasBrutas(0.4);
		funcionario2.setSalario(1000);
		funcionario2.setTaxaComissao(600);
		funcionario2.setVendasBrutas(0.2);
		funcionario3.setSalarioSemanal(400);
		funcionario4.setHorasSemanais(33);
		funcionario4.setSalarioPorHora(15);
		funcionario5.setHorasSemanais(44);
		funcionario5.setSalarioPorHora(10);
		
		System.out.println("Folha de Pagamento (foi considerado que todo mês tem exatas 4 semanas)");
		System.out.println("Funcionario Comissionado\t\t" + funcionario1);
		System.out.println("Funcionario Comissionado Base Salario\t" + funcionario2);
		System.out.println("Funcionario Assalariado:\t\t" + funcionario3);
		System.out.println("Funcionario Horista < 40h:\t\t" + funcionario4);
		System.out.println("Funcionario Horista > 40h:\t\t" + funcionario5);
	}
	

}
