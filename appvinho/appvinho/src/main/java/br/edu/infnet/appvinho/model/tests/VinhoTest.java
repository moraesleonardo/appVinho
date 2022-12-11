package br.edu.infnet.appvinho.model.tests;

import br.edu.infnet.appvinho.model.domain.Branco;
import br.edu.infnet.appvinho.model.domain.Rose;
import br.edu.infnet.appvinho.model.domain.Tinto;
import br.edu.infnet.appvinho.model.exceptions.ValorZeradoException;

public class VinhoTest {

	public static void main(String[] args) {
		
		//tinto
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
		
		//rose
		try {
			Rose r1 = new Rose("1134","Português",25,"Biscardo");
			r1.setBest_seller(false);
			r1.setPremios(5);
			System.out.println(r1);
			
		} catch (ValorZeradoException e) {
			System.out.println("[ERRO] " + e.getMessage());
		}

		try {
			Rose r2 = new Rose("1135","Italiano",35,"Tormaresca");
			r2.setBest_seller(true);
			r2.setPremios(3);
			System.out.println(r2);
			
		} catch (ValorZeradoException e) {
			System.out.println("[ERRO] " + e.getMessage());
		}
		
		try {
			Rose r3 = new Rose("1136", "Francês", 70, "Villa Riviera");
			r3.setBest_seller(true);
			r3.setPremios(1);
			System.out.println(r3);
			
		} catch (ValorZeradoException e) {
			System.out.println("[ERRO] " + e.getMessage());
		}
		
		//branco
		try {
			Branco b1 = new Branco("1254","Português",32,"Duorum");
			b1.setEspumante(false);
			b1.setPack(4);
			System.out.println(b1);
		} catch (ValorZeradoException e) {
			System.out.println("[ERRO] " + e.getMessage());
		}
		try {
			Branco b2 = new Branco("1255","Italiano",30,"Castellani");
			b2.setEspumante(true);
			b2.setPack(3);
			System.out.println(b2);
		} catch (ValorZeradoException e) {
			System.out.println("[ERRO] " + e.getMessage());
		}
		
		try {
			Branco b3 = new Branco("1256", "Francês", 27, "Saint-Émilion");
			b3.setEspumante(true);
			b3.setPack(10);
			System.out.println(b3);
		} catch (ValorZeradoException e) {
			System.out.println("[ERRO] " + e.getMessage());
		}
		
	}
}
