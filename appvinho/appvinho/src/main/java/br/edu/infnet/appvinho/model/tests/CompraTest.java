package br.edu.infnet.appvinho.model.tests;

import java.util.ArrayList;
import java.util.List;

import br.edu.infnet.appvinho.model.domain.Tinto;
import br.edu.infnet.appvinho.model.domain.Compra;
import br.edu.infnet.appvinho.model.domain.Vinho;
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

		try {
			Tinto t1 = new Tinto("b1caf5", "cafezin", 5, "Cooooffeeee");
			t1.setGelada(false);
			t1.setTamanho(500);

			vinhosV1.add(t1);
			vinhosV2.add(t1);
			vinhosV4.add(t1);
		} catch (ValorZeradoException e) {
			System.out.println("[ERRO] " + e.getMessage());
		}

		try {
			Tinto t2 = new Tinto("b2cho10", "chopin", 10, "Brahhh");
			t2.setGelada(true);
			t2.setTamanho(500);

			vinhosV2.add(t2);
			vinhosV3.add(t2);
			vinhosV4.add(t2);
		} catch (ValorZeradoException e) {
			System.out.println("[ERRO] " + e.getMessage());
		}

		try {
			Tinto t3 = new Tinto("b3suc8", "Suquin", 8, "Dafruta");
			t3.setGelada(true);
			t3.setTamanho(500);

			vinhosV3.add(t3);
			vinhosV4.add(t3);
		} catch (ValorZeradoException e) {
			System.out.println("[ERRO] " + e.getMessage());
		}

		try {
			Compra c1 = new Compra(new Cliente("huguinho", "12312312312", "hugo@hugo.com"), vinhosV1);
			c1.setDescricao("Primeiro pedido");
			c1.setWeb(false);
			c1.imprimir();
		} catch (ClienteInvalidoException | CompraSemClienteException | CompraSemVinhoException e) {
			System.out.println("[ERRO] " + e.getMessage());
		}

		try {
			Compra c2 = new Compra(new Cliente("zezinho", "12312312312", "ze@ze.com"), vinhosV2);
			c2.setDescricao("Segundo pedido");
			c2.setWeb(true);
			c2.imprimir();
		} catch (ClienteInvalidoException | CompraSemClienteException | CompraSemVinhoException e) {
			System.out.println("[ERRO] " + e.getMessage());
		}

		try {
			Compra c3 = new Compra(new Cliente("luizinho", "12312312312", "luiz@luiz.com"), vinhosV3);
			c3.setDescricao("Terceiro pedido");
			c3.setWeb(true);
			c3.imprimir();
		} catch (ClienteInvalidoException | CompraSemClienteException | CompraSemVinhoException e) {
			System.out.println("[ERRO] " + e.getMessage());
		}

		try {
			Compra c4 = new Compra(new Cliente("mariazinha", "12312312312", "maria@maria.com"), vinhosV4);
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