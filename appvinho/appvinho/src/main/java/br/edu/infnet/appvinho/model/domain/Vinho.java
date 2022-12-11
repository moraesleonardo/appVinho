package br.edu.infnet.appvinho.model.domain;

import br.edu.infnet.appvinho.model.exceptions.TamanhoBrancoInvalidoException;
import br.edu.infnet.appvinho.model.exceptions.TamanhoRoseInvalidoException;
import br.edu.infnet.appvinho.model.exceptions.TamanhoTintoInvalidoException;
import br.edu.infnet.appvinho.model.exceptions.ValorZeradoException;

public abstract class Vinho {

	private String codigo;
	private String procedencia;
	private float valor;
	
	public Vinho(String codigo, String procedencia, float valor) throws ValorZeradoException {
		
		if(valor == 0) {
			throw new ValorZeradoException("O valor do vinho está zerado!");
		}
		
		if(valor < 0) {
			throw new ValorZeradoException("O valor do vinho está negativo!");
		}

		this.codigo = codigo;
		this.procedencia = procedencia;
		this.valor = valor;
	}
	
	public abstract float calcularValorVenda() throws TamanhoTintoInvalidoException, TamanhoBrancoInvalidoException, TamanhoRoseInvalidoException;

	@Override
	public String toString() {
		
		StringBuilder sb = new StringBuilder();
		sb.append(codigo);
		sb.append(";");
		sb.append(procedencia);
		sb.append(";");
		sb.append(valor);

		return sb.toString();
	}

	public String getCodigo() {
		return codigo;
	}
	public String getProcedencia() {
		return procedencia;
	}
	public float getValor() {
		return valor;
	}	
}