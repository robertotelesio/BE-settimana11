package it.epicode.be.segreteria.model;

import lombok.Builder;
import lombok.Data;

@Data
public class CorsoDiLaurea {

	private String codiceCorso;
	private String nome;
	private String indirizzo;
	private int numEsami = 10;
	
	@Builder
	public CorsoDiLaurea(String codiceCorso, String nome, String indirizzo, int esami) {
		this.codiceCorso = codiceCorso;
		this.nome = nome;
		this.indirizzo = indirizzo;
		this.numEsami = esami;
	}

	public CorsoDiLaurea() {
		
	}

	@Override
	public String toString() {
		return "Iscritto a :" + nome + "[codiceCorso= " + codiceCorso + ", nome= " + nome + ", indirizzo= " + indirizzo + ", esami= "
				+ numEsami + "]";
	}
	
	
}
