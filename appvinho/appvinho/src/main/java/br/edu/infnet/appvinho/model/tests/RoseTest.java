package br.edu.infnet.appvinho.model.tests;

import br.edu.infnet.appvinho.model.domain.Rose;
import br.edu.infnet.appvinho.model.exceptions.TamanhoRoseInvalidoException;
import br.edu.infnet.appvinho.model.exceptions.ValorZeradoException;

public class RoseTest {

	public static void main(String[] args) {
		
		
		try {
			Rose r1 = new Rose("1134","Português",25,"Biscardo");
			r1.setBest_seller(false);
			r1.setPremios(5);
			System.out.println(r1);
			System.out.println("Valor de Venda = R$" + r1.calcularValorVenda());
		} catch (ValorZeradoException | TamanhoRoseInvalidoException e) {
			System.out.println("[ERRO] " + e.getMessage());
		}

		try {
			Rose r1 = new Rose("1134","Português",25,"Biscardo");
			r1.setBest_seller(false);
			r1.setPremios(7);
			System.out.println(r1);
			System.out.println("Valor de Venda = R$" + r1.calcularValorVenda());
		} catch (ValorZeradoException | TamanhoRoseInvalidoException e) {
			System.out.println("[ERRO] " + e.getMessage());
		}
		
		try {
			Rose r2 = new Rose("1135","Italiano",-35,"Tormaresca");
			r2.setBest_seller(true);
			r2.setPremios(3);
			System.out.println(r2);
			System.out.println("Valor de Venda = R$" + r2.calcularValorVenda());
		} catch (ValorZeradoException | TamanhoRoseInvalidoException e) {
			System.out.println("[ERRO] " + e.getMessage());
		}
		
		try {
			Rose r3 = new Rose("1136", "Francês", 0, "Villa Riviera");
			r3.setBest_seller(true);
			r3.setPremios(1);
			System.out.println(r3);
			System.out.println("Valor de Venda = R$" + r3.calcularValorVenda());
		} catch (ValorZeradoException | TamanhoRoseInvalidoException e) {
			System.out.println("[ERRO] " + e.getMessage());
		}
	}
}