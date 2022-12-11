package br.edu.infnet.appvinho.model.tests;

import br.edu.infnet.appvinho.model.domain.Cliente;
import br.edu.infnet.appvinho.model.exceptions.ClienteInvalidoException;

public class ClienteTest {

	public static void main(String[] args) {

		try {
			Cliente s1 = new Cliente("Paulo", "043.177.789-10", "paulo@paulo.com");
			System.out.println(s1);
		} catch (ClienteInvalidoException e) {
			System.out.println("[ERRO] " + e.getMessage());
		}

		try {
			Cliente s2 = new Cliente(null, "043.177.789-11", "marcos@marcos.com");
			System.out.println(s2);
		} catch (ClienteInvalidoException e) {
			System.out.println("[ERRO] " + e.getMessage());
		}

		try {
			Cliente s3 = new Cliente("Pedro", null, "pedro@pedro.com");
			System.out.println(s3);
		} catch (ClienteInvalidoException e) {
			System.out.println("[ERRO] " + e.getMessage());
		}

		try {
			Cliente s3 = new Cliente("João", "043.177.789-12", null);
			System.out.println(s3);
		} catch (ClienteInvalidoException e) {
			System.out.println("[ERRO] " + e.getMessage());
		}
	}
}