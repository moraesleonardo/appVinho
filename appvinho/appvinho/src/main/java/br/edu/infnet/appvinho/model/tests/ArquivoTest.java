package br.edu.infnet.appvinho.model.tests;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import br.edu.infnet.appvinho.model.domain.Tinto;
import br.edu.infnet.appvinho.model.domain.Compra;
import br.edu.infnet.appvinho.model.domain.Rose;
import br.edu.infnet.appvinho.model.domain.Vinho;
import br.edu.infnet.appvinho.model.domain.Branco;
import br.edu.infnet.appvinho.model.domain.Cliente;
import br.edu.infnet.appvinho.model.exceptions.CompraSemVinhoException;
import br.edu.infnet.appvinho.model.exceptions.CompraSemClienteException;
import br.edu.infnet.appvinho.model.exceptions.ClienteInvalidoException;
import br.edu.infnet.appvinho.model.exceptions.ValorZeradoException;

public class ArquivoTest {

	public static void main(String[] args) {
		
		try {
			String arq = "pedidos.txt";
			
			try {
				FileReader fileR = new FileReader(arq);
				BufferedReader leitura = new BufferedReader(fileR);
				
				FileWriter fileW = new FileWriter("out_"+arq);
				BufferedWriter escrita = new BufferedWriter(fileW);
				
				String linha = leitura.readLine();			
				String[] campos = null;
				
				List<Vinho> vinhos = new ArrayList<Vinho>();
				Compra compra = null;

				while(linha != null) {
					
					campos = linha.split(";");
					
					switch (campos[0].toUpperCase()) {
					case "C":					
						try {						
							compra = new Compra(new Cliente(campos[5], campos[3], campos[4]), vinhos);
							compra.setDescricao(campos[1]);
							compra.setWeb(Boolean.valueOf(campos[2]));
						} catch (ClienteInvalidoException | CompraSemClienteException | CompraSemVinhoException e) {
							System.out.println("[ERRO] " + e.getMessage());
						}
						break;
						
					case "T":					
						try {
							Tinto tinto = new Tinto(campos[1], campos[2], Float.valueOf(campos[3]), campos[6]);
							tinto.setGelada(Boolean.valueOf(campos[4]));
							tinto.setTamanho(Integer.valueOf(campos[5]));
							vinhos.add(tinto);
						} catch (ValorZeradoException e) {
							System.out.println("[ERRO] " + e.getMessage());
						}
						break;
												
					case "R":
						try {
							Rose rose = new Rose(campos[1], campos[2], Float.valueOf(campos[3]), campos[6]);
							rose.setBest_seller(Boolean.valueOf(campos[4]));
							rose.setPremios(Integer.valueOf(campos[5]));
							vinhos.add(rose);
    					} catch (ValorZeradoException e) {
							System.out.println("[ERRO] " + e.getMessage());
		    			}
					break;											
					
					case "B":	
						try {
							Branco branco = new Branco(campos[1], campos[2], Float.valueOf(campos[3]), campos[6]);
							branco.setEspumante(Boolean.valueOf(campos[4]));
							branco.setPack(Integer.valueOf(campos[5]));
							vinhos.add(branco);
						} catch (ValorZeradoException e) {
							System.out.println("[ERRO] " + e.getMessage());
						}
						break;
				
					default:
						System.out.println("Registro inválido!!!");
						break;
					}

					linha = leitura.readLine();
				}
				
				escrita.write(compra.obterLinha());
				System.out.println(compra.obterLinha());
				
				escrita.close();
				leitura.close();
				fileR.close();
				
			} catch (IOException e) {
				System.out.println("[ERRO] " + e.getMessage());
			} 
	
			
		} finally {
			System.out.println("Processamento realizado com sucesso!!!");
		}		
	}
}