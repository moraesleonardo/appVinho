package br.edu.infnet.appvinho.model.exceptions;

public class CompraSemClienteException extends Exception {

	private static final long serialVersionUID = 1L;

	public CompraSemClienteException(String mensagem) {
		super(mensagem);
	}
}