package br.edu.infnet.appvinho.model.domain;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import br.edu.infnet.appvinho.model.exceptions.CompraSemVinhoException;
import br.edu.infnet.appvinho.model.exceptions.CompraSemClienteException;

public class Compra {

	private String descricao;
	private boolean web;
	private LocalDateTime data;
	private Cliente cliente;
	private List<Vinho> vinhos;
	
	public Compra(Cliente cliente, List<Vinho> vinhos) throws CompraSemClienteException, CompraSemVinhoException {
		
		if(cliente == null) {
			throw new CompraSemClienteException("Não existe cliente associado ao pedido!");
		}
		
		if(vinhos == null) {
			throw new CompraSemVinhoException("Não existe vinho associado ao pedido!");
		}

		this.cliente = cliente;
		this.vinhos = vinhos;
		
		data = LocalDateTime.now();
	}
	
	public void imprimir(){
		System.out.println("Compra: " + this);
		System.out.println("Cliente: " + cliente);
		System.out.println("Qtde Vinhos: " + vinhos.size());
		System.out.println("Vinhos:");
		for(Vinho v : vinhos) {
			System.out.println("- " + v.getProcedencia());
		}
	}
	
	public String obterLinha() {	
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("MM/yyyy");
		
		return this.getData().format(formato)+";"+
			   this.getDescricao()+";"+
			   this.getCliente()+";"+
			   this.getVinhos().size()+"\r\n";
	}
	
	
	@Override
	public String toString() {
		
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
		
		return  String.format("%s;%s;%s", 
				descricao, 
				web ? "web" : "loja",  
				data.format(formato)
			);
	}

	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public boolean isWeb() {
		return web;
	}
	public void setWeb(boolean web) {
		this.web = web;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public List<Vinho> getVinhos() {
		return vinhos;
	}
	public LocalDateTime getData() {
		return data;
	}
}