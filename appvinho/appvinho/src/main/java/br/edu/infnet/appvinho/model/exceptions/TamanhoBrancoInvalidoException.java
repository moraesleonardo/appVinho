package br.edu.infnet.appvinho.model.exceptions;

public class TamanhoBrancoInvalidoException extends Exception {

	private static final long serialVersionUID = 1L;

	public TamanhoBrancoInvalidoException(String mensagem) {
		super(mensagem);
	}
}