package br.edu.infnet.appvinho.model.tests;

import br.edu.infnet.appvinho.model.domain.Tinto;
import br.edu.infnet.appvinho.model.exceptions.ValorZeradoException;

public class VinhoTest {

	public static void main(String[] args) {
		
	
		try {
			Tinto t1 = new Tinto("b1caf5", "cafezin", 5, "Cooooffeeee");
			t1.setGelada(false);
			t1.setTamanho(500);
			System.out.println(t1);
		} catch (ValorZeradoException e) {
			System.out.println("[ERRO] " + e.getMessage());
		}

		try {
			Tinto t2 = new Tinto("b2cho10", "chopin", 10, "Brahhh");
			t2.setGelada(true);
			t2.setTamanho(300);
			System.out.println(t2);
		} catch (ValorZeradoException e) {
			System.out.println("[ERRO] " + e.getMessage());
		}

		try {
			Tinto t3 = new Tinto("b3suc8", "Suquin", 8, "Dafruta");
			t3.setGelada(true);
			t3.setTamanho(1000);
			System.out.println(t3);
		} catch (ValorZeradoException e) {
			System.out.println("[ERRO] " + e.getMessage());
		}
	}
}
