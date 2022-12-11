package br.edu.infnet.appvinho.model.exceptions;

public class CompraSemVinhoException extends Exception {

	private static final long serialVersionUID = 1L;

	public CompraSemVinhoException(String mensagem) {
		super(mensagem);
	}
}