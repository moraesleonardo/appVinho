package br.edu.infnet.appvinho.model.tests;

import java.util.ArrayList;
import java.util.List;

import br.edu.infnet.appvinho.model.domain.Tinto;
import br.edu.infnet.appvinho.model.domain.Compra;
import br.edu.infnet.appvinho.model.domain.Rose;
import br.edu.infnet.appvinho.model.domain.Vinho;
import br.edu.infnet.appvinho.model.domain.Branco;
import br.edu.infnet.appvinho.model.domain.Cliente;
import br.edu.infnet.appvinho.model.exceptions.CompraSemVinhoException;
import br.edu.infnet.appvinho.model.exceptions.CompraSemClienteException;
import br.edu.infnet.appvinho.model.exceptions.ClienteInvalidoException;
import br.edu.infnet.appvinho.model.exceptions.ValorZeradoException;

public class CompraTest {

	public static void main(String[] args) {
		List<Vinho> vinhosV1 = new ArrayList<Vinho>();
		List<Vinho> vinhosV2 = new ArrayList<Vinho>();
		List<Vinho> vinhosV3 = new ArrayList<Vinho>();
		List<Vinho> vinhosV4 = new ArrayList<Vinho>();

		//Tinto
		try {
			Tinto t1 = new Tinto("1234","Português",35,"Taboadella");
			t1.setGelada(false);
			t1.setTamanho(500);
			vinhosV1.add(t1);
			vinhosV2.add(t1);
			vinhosV4.add(t1);
		} catch (ValorZeradoException e) {
			System.out.println("[ERRO] " + e.getMessage());
		}
		
		try {
			Tinto t2 = new Tinto("1235","Italiano",40,"Primo Reale");
			t2.setGelada(true);
			t2.setTamanho(500);
			vinhosV2.add(t2);
			vinhosV3.add(t2);
			vinhosV4.add(t2);
		} catch (ValorZeradoException e) {
			System.out.println("[ERRO] " + e.getMessage());
		}
		
		try {
			Tinto t3 = new Tinto("1236", "Francês", 78, "Fleur Saint-Jean Rouge");
			t3.setGelada(true);
			t3.setTamanho(500);
			vinhosV3.add(t3);
			vinhosV4.add(t3);
		} catch (ValorZeradoException e) {
			System.out.println("[ERRO] " + e.getMessage());
		}
		
		//Rose
		try {
			Rose r1 = new Rose("1134","Português",25,"Biscardo");
			r1.setBest_seller(false);
			r1.setPremios(5);
			vinhosV1.add(r1);
			vinhosV2.add(r1);
			vinhosV4.add(r1);			
		} catch (ValorZeradoException e) {
			System.out.println("[ERRO] " + e.getMessage());
		}

		try {
			Rose r2 = new Rose("1135","Italiano",35,"Tormaresca");
			r2.setBest_seller(true);
			r2.setPremios(3);
			vinhosV2.add(r2);
			vinhosV3.add(r2);
			vinhosV4.add(r2);	
		} catch (ValorZeradoException e) {
			System.out.println("[ERRO] " + e.getMessage());
		}
		
		try {
			Rose r3 = new Rose("1136", "Francês", 70, "Villa Riviera");
			r3.setBest_seller(true);
			r3.setPremios(1);
			vinhosV3.add(r3);
			vinhosV4.add(r3);		
		} catch (ValorZeradoException e) {
			System.out.println("[ERRO] " + e.getMessage());
		}
		
		//Branco
		try {
			Branco b1 = new Branco("1254","Português",32,"Duorum");
			b1.setEspumante(false);
			b1.setPack(4);
			vinhosV1.add(b1);
			vinhosV2.add(b1);
			vinhosV4.add(b1);			
		} catch (ValorZeradoException e) {
			System.out.println("[ERRO] " + e.getMessage());
		}
		try {
			Branco b2 = new Branco("1255","Italiano",30,"Castellani");
			b2.setEspumante(true);
			b2.setPack(3);
			vinhosV2.add(b2);
			vinhosV3.add(b2);
			vinhosV4.add(b2);	
		} catch (ValorZeradoException e) {
			System.out.println("[ERRO] " + e.getMessage());
		}
		
		try {
			Branco b3 = new Branco("1256", "Francês", 27, "Saint-Émilion");
			b3.setEspumante(true);
			b3.setPack(10);
			vinhosV3.add(b3);
			vinhosV4.add(b3);		
		} catch (ValorZeradoException e) {
			System.out.println("[ERRO] " + e.getMessage());
		}
		
		try {
			Compra c1 = new Compra(new Cliente("Paulo", "043.177.789-10", "paulo@paulo.com"), vinhosV1);
			c1.setDescricao("Primeiro pedido");
			c1.setWeb(false);
			c1.imprimir();
		} catch (ClienteInvalidoException | CompraSemClienteException | CompraSemVinhoException e) {
			System.out.println("[ERRO] " + e.getMessage());
		}
		
		try {
			Compra c2 = new Compra(new Cliente("Pedro", "043.177.789-11", "pedro@pedro.com"), vinhosV2);
			c2.setDescricao("Segundo pedido");
			c2.setWeb(true);
			c2.imprimir();
		} catch (ClienteInvalidoException | CompraSemClienteException | CompraSemVinhoException e) {
			System.out.println("[ERRO] " + e.getMessage());
		}

		try {
			Compra c3 = new Compra(new Cliente("João", "043.177.789-12", "joao@joao.com"), vinhosV3);
			c3.setDescricao("Terceiro pedido");
			c3.setWeb(true);
			c3.imprimir();
		} catch (ClienteInvalidoException | CompraSemClienteException | CompraSemVinhoException e) {
			System.out.println("[ERRO] " + e.getMessage());
		}

		try {
			Compra c4 = new Compra(new Cliente("Maria", "043.177.789-13", "maria@maria.com"), vinhosV4);
			c4.setDescricao("Quarto pedido");
			c4.setWeb(true);
			c4.imprimir();
		} catch (ClienteInvalidoException | CompraSemClienteException | CompraSemVinhoException e) {
			System.out.println("[ERRO] " + e.getMessage());
		}

		try {
			Compra c5 = new Compra(null, vinhosV4);
			c5.setDescricao("Quinto pedido");
			c5.setWeb(true);
			c5.imprimir();
		} catch (CompraSemClienteException | CompraSemVinhoException e) {
			System.out.println("[ERRO] " + e.getMessage());
		}

		try {
			Cliente s6 = new Cliente("mariazinha", "12312312312", "maria@maria.com");
		
			Compra c6 = new Compra(s6, null);
			c6.setDescricao("Sexto pedido");
			c6.setWeb(true);
			c6.imprimir();
		} catch (ClienteInvalidoException | CompraSemClienteException | CompraSemVinhoException e) {
			System.out.println("[ERRO] " + e.getMessage());
		}
	}
}