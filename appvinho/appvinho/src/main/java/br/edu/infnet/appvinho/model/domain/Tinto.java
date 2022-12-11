package br.edu.infnet.appvinho.model.domain;

import br.edu.infnet.appvinho.model.exceptions.TamanhoTintoInvalidoException;
import br.edu.infnet.appvinho.model.exceptions.ValorZeradoException;

public class Tinto extends Vinho {

	private boolean gelada;
	private int tamanho;
	private String marca;

	public Tinto(String codigo, String procedencia, float valor, String marca) throws ValorZeradoException {
		super(codigo, procedencia, valor);
		this.marca = marca;
	}

	@Override
	public float calcularValorVenda() throws TamanhoTintoInvalidoException {
		
		if(tamanho < 500) {
			throw new TamanhoTintoInvalidoException("O tamanho do vinho está inválido!");
		}
		
		return this.getValor() + (gelada ? 3 : 0) + tamanho * 0.08f;
	}
	
	@Override
	public String toString() {
		
		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append(";");
		sb.append(gelada ? "gelada" : "temperatura ambiente");
		sb.append(";");
		sb.append(tamanho);
		sb.append(";");
		sb.append(marca);

		return sb.toString();
	}
	
	public boolean isGelada() {
		return gelada;
	}
	public void setGelada(boolean gelada) {
		this.gelada = gelada;
	}
	public int getTamanho() {
		return tamanho;
	}
	public void setTamanho(int tamanho) {
		this.tamanho = tamanho;
	}
	public String getMarca() {
		return marca;
	}
}