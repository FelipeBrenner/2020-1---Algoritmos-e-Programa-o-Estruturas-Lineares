package teste;

import conta.Conta;

public class ContaTeste {

	public static void main(String[] args) {

		Conta conta = new Conta("Conta 364534");
		System.out.println(conta);
		conta.depositar(100);
		System.out.println(conta);
		conta.sacar(70);
		System.out.println(conta);
		conta.sacar(50);
		System.out.println(conta);
		conta.sacar(30);
		System.out.println(conta);
		conta.sacar(20);
		System.out.println(conta);
	}

}
