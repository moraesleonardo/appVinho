package br.edu.infnet.appvinho.model.domain;

import br.edu.infnet.appvinho.model.exceptions.TamanhoBrancoInvalidoException;
import br.edu.infnet.appvinho.model.exceptions.ValorZeradoException;

public class Branco extends Vinho {

	private boolean espumante;
	private int pack;
	private String marca;

	public Branco(String codigo, String procedencia, float valor, String marca) throws ValorZeradoException {
		super(codigo, procedencia, valor);
		this.marca = marca;
	}

	@Override
	public float calcularValorVenda() throws TamanhoBrancoInvalidoException {
		
		if(pack < 3) {
			throw new TamanhoBrancoInvalidoException("Não é possível vender menos do que três vinhos no pack!");
		}
		
		return this.getValor() + (espumante ? 3 : 0); // + tamanho * 0.08f;
	}
	
	@Override
	public String toString() {
		
		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append(";");
		sb.append(espumante ? "espumante" : "vinho");
		sb.append(";");
		sb.append(pack);
		sb.append(";");
		sb.append(marca);

		return sb.toString();
	}
	
	public boolean isEspumante() {
		return espumante;
	}
	public void setEspumante(boolean espumante) {
		this.espumante = espumante;
	}
	public int getPack() {
		return pack;
	}
	public void setPack(int pack) {
		this.pack = pack;
	}
	public String getMarca() {
		return marca;
	}
}
