package conta;

public class Conta {
	private double saldo;
	private String numero;
	
	public Conta(String nome) {
		this.numero = nome;
		saldo = 0;
	}
	
	public void depositar(double valor) {
		this.saldo += valor;
	}
	
	public void sacar(double valor) {
		if (valor>saldo)
			System.out.println("Não é possível realizar este saque!");
		else
			this.saldo -= valor;
	}
	
	@Override
	public String toString() {
		return "Conta: " + numero + " Saldo atual: " + saldo;
	}
	
}
