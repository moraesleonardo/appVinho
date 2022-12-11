package br.edu.infnet.appvinho.model.domain;

import br.edu.infnet.appvinho.model.exceptions.TamanhoRoseInvalidoException;
import br.edu.infnet.appvinho.model.exceptions.ValorZeradoException;

public class Rose extends Vinho {

	private boolean best_seller;
	private int premios;
	private String marca;

	public Rose(String codigo, String procedencia, float valor, String marca) throws ValorZeradoException {
		super(codigo, procedencia, valor);
		this.marca = marca;
	}

	@Override
	public float calcularValorVenda() throws TamanhoRoseInvalidoException {
		
		if(premios > 5) {
			throw new TamanhoRoseInvalidoException("O vinho só poderá ser vendido com reserva antecipada. Favor entrar em contato com o nosso setor de vendas pelo telefone!");
		}
		
		return this.getValor() + (best_seller ? 20 : 0) + premios * 10;
	}
	
	@Override
	public String toString() {
		
		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append(";");
		sb.append(best_seller ? "best_seller" : "lançamento");
		sb.append(";");
		sb.append(premios);
		sb.append(";");
		sb.append(marca);

		return sb.toString();
	}
	
	public boolean isBest_seller() {
		return best_seller;
	}
	public void setBest_seller(boolean best_seller) {
		this.best_seller = best_seller;
	}
	public int getPremios() {
		return premios;
	}
	public void setPremios(int premios) {
		this.premios = premios;
	}
	public String getMarca() {
		return marca;
	}
}
