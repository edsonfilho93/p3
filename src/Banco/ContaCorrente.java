package Banco;
import BancoExcepetions.EntradaInvalidaException;
import BancoExcepetions.ExcedeValorLimiteException;
import BancoExcepetions.SaldoInsuficienteException;

public class ContaCorrente {

	private float limite;
	private float saldo;
	private float valorLimite;

	public ContaCorrente(float saldo, float valorLimite) {
		this.limite = valorLimite - saldo;
		this.saldo = saldo;
		this.valorLimite = valorLimite;
	}

	public void sacar(float valor) throws SaldoInsuficienteException, EntradaInvalidaException {
		if (valor < 0)
			throw new EntradaInvalidaException("Entrada Inválida");
		else if (valor > saldo)
			throw new SaldoInsuficienteException("Saldo insulficiente");

		this.saldo -= valor;
	}

	public void depositar(float valor) throws EntradaInvalidaException, ExcedeValorLimiteException {
		if (valor < 0)
			throw new EntradaInvalidaException("Entrada Inválida");
		else if (valor > valorLimite)
			throw new ExcedeValorLimiteException("Deposito excede o valor limite para a conta");

		this.saldo += valor;
	}

	public void setValorLimite(float valor) throws EntradaInvalidaException {
		if (valor < 0)
			throw new EntradaInvalidaException("Entrada Inválida");

		this.valorLimite = valor;
	}

	public float getLimite() {
		return limite;
	}

	public float getSaldo() {
		return saldo;
	}

	public float getValorLimite() {
		return valorLimite;
	}
}
