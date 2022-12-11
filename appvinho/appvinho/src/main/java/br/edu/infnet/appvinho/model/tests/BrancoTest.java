package br.edu.infnet.appvinho.model.tests;

import br.edu.infnet.appvinho.model.domain.Branco;
import br.edu.infnet.appvinho.model.exceptions.TamanhoBrancoInvalidoException;
import br.edu.infnet.appvinho.model.exceptions.ValorZeradoException;

public class BrancoTest {

	public static void main(String[] args) {
				
		try {
			Branco b1 = new Branco("1254","Português",32,"Duorum");
			b1.setEspumante(false);
			b1.setPack(4);
			System.out.println(b1);
			System.out.println("Valor de Venda = R$" + b1.calcularValorVenda());
		} catch (ValorZeradoException | TamanhoBrancoInvalidoException e) {
			System.out.println("[ERRO] " + e.getMessage());
		}

		try {
			Branco b1 = new Branco("1254","Português",32,"Duorum");
			b1.setEspumante(false);
			b1.setPack(2);
			System.out.println(b1);
			System.out.println("Valor de Venda = R$" + b1.calcularValorVenda());
		} catch (ValorZeradoException | TamanhoBrancoInvalidoException e) {
			System.out.println("[ERRO] " + e.getMessage());
		}
		
		try {
			Branco b2 = new Branco("1255","Italiano",-30,"Castellani");
			b2.setEspumante(true);
			b2.setPack(3);
			System.out.println(b2);
			System.out.println("Valor de Venda = R$" + b2.calcularValorVenda());
		} catch (ValorZeradoException | TamanhoBrancoInvalidoException e) {
			System.out.println("[ERRO] " + e.getMessage());
		}
		
		try {
			Branco b3 = new Branco("1256", "Francês", 0, "Saint-Émilion");
			b3.setEspumante(true);
			b3.setPack(10);
			System.out.println(b3);
			System.out.println("Valor de Venda = R$" + b3.calcularValorVenda());
		} catch (ValorZeradoException | TamanhoBrancoInvalidoException e) {
			System.out.println("[ERRO] " + e.getMessage());
		}
	}
}