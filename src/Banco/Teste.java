package Banco;
import java.util.Scanner;

import BancoExcepetions.EntradaInvalidaException;
import BancoExcepetions.ExcedeValorLimiteException;
import BancoExcepetions.SaldoInsuficienteException;

public class Teste {

	static Scanner teclado = new Scanner(System.in);
	static ContaCorrente conta;

	public static void main(String[] args) {

		conta = new ContaCorrente(0, 1000);

		int opcao = 0;
		do {
			exibiMenu();
			opcao = teclado.nextInt();

			if (opcao == 0)
				break;

			opcoesBancarias(opcao);
		} while (true);

	}

	private static void opcoesBancarias(int opcao) {
		switch (opcao) {
		case 1:
			sacar();
			break;

		case 2:
			depositar();
			break;

		case 3:
			alteraValorLimite();
			break;
		}
	}

	private static void alteraValorLimite() {
		try {
			System.out.print("Informe o novo limite para a conta corrente: ");
			conta.setValorLimite(teclado.nextFloat());
			System.out.println("Limite alterado com sucesso");
		} catch (EntradaInvalidaException e) {
			System.out.println(e.getMessage());
		}
	}

	private static void sacar() {
		try {
			System.out.print("informe o valor para o saque: ");
			conta.sacar(teclado.nextFloat());
			System.out.println("Saque realizado com sucesso");
			System.out.println("Saldo em conta: " + conta.getSaldo());
		} catch (SaldoInsuficienteException e) {
			System.out.println(e.getMessage());

		} catch (EntradaInvalidaException e) {
			System.out.println(e.getMessage());
		}
	}

	private static void depositar() {
		try {
			System.out.print("Informe o valor para o depósito: ");
			conta.depositar(teclado.nextFloat());
			System.out.print("Deposito realizado com sucesso");
		} catch (EntradaInvalidaException e) {
			System.out.println(e.getMessage());
		} catch (ExcedeValorLimiteException e) {
			System.out.println(e.getMessage());
		}
	}

	private static void exibiMenu() {
		System.out.println("###### Banco ######");
		System.out.println("Informe uma opção: \n" );
		System.out.println(" 1 - Saque");
		System.out.println(" 2 - Depósito");
		System.out.println(" 3 - Alterar valor limite para a conta");
		System.out.println(" 0 - Sair \n");
		System.out.print("Opção: ");
	}

}
