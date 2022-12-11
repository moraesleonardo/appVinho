package br.edu.infnet.appvinho.model.tests;

import br.edu.infnet.appvinho.model.domain.Tinto;
import br.edu.infnet.appvinho.model.exceptions.ValorZeradoException;

public class VinhoTest {

	public static void main(String[] args) {
		
	
		try {
			Tinto t1 = new Tinto("1234","Português",35,"Taboadella");
			t1.setGelada(false);
			t1.setTamanho(500);
			System.out.println(t1);
		} catch (ValorZeradoException e) {
			System.out.println("[ERRO] " + e.getMessage());
		}

		try {
			Tinto t2 = new Tinto("1235","Italiano",40,"Primo Reale");
			t2.setGelada(true);
			t2.setTamanho(300);
			System.out.println(t2);
		} catch (ValorZeradoException e) {
			System.out.println("[ERRO] " + e.getMessage());
		}

		try {
			Tinto t3 = new Tinto("1236", "Francês", 78, "Fleur Saint-Jean Rouge");
			t3.setGelada(true);
			t3.setTamanho(1000);
			System.out.println(t3);
		} catch (ValorZeradoException e) {
			System.out.println("[ERRO] " + e.getMessage());
		}
		
	}
}
