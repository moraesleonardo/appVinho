package br.edu.infnet.appvinho.model.tests;

import br.edu.infnet.appvinho.model.domain.Tinto;
import br.edu.infnet.appvinho.model.exceptions.TamanhoTintoInvalidoException;
import br.edu.infnet.appvinho.model.exceptions.ValorZeradoException;

public class TintoTest {

	public static void main(String[] args) {
				
		try {
			Tinto t1 = new Tinto("1234","Português",35,"Taboadella");
			t1.setGelada(false);
			t1.setTamanho(500);
			System.out.println(t1);
			System.out.println("Valor de Venda = R$" + t1.calcularValorVenda());
		} catch (ValorZeradoException | TamanhoTintoInvalidoException e) {
			System.out.println("[ERRO] " + e.getMessage());
		}

		try {
			Tinto t1 = new Tinto("1234","Português",35,"Taboadella");
			t1.setGelada(false);
			t1.setTamanho(200);
			System.out.println(t1);
			System.out.println("Valor de Venda = R$" + t1.calcularValorVenda());
		} catch (ValorZeradoException | TamanhoTintoInvalidoException e) {
			System.out.println("[ERRO] " + e.getMessage());
		}
		
		try {
			Tinto t2 = new Tinto("1235","Italiano",-40,"Primo Reale");
			t2.setGelada(true);
			t2.setTamanho(300);
			System.out.println(t2);
			System.out.println("Valor de Venda = R$" + t2.calcularValorVenda());
		} catch (ValorZeradoException | TamanhoTintoInvalidoException e) {
			System.out.println("[ERRO] " + e.getMessage());
		}
		
		try {
			Tinto t3 = new Tinto("1236", "Francês", 0, "Fleur Saint-Jean Rouge");
			t3.setGelada(true);
			t3.setTamanho(1000);
			System.out.println(t3);
			System.out.println("Valor de Venda = R$" + t3.calcularValorVenda());
		} catch (ValorZeradoException | TamanhoTintoInvalidoException e) {
			System.out.println("[ERRO] " + e.getMessage());
		}
	}
}