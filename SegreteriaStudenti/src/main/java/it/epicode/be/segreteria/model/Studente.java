package it.epicode.be.segreteria.model;

import java.time.LocalDate;

import lombok.Builder;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
@Data
public class Studente {

	
	private String matricola;
	private String nome;
	private String cognome;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate dataNascita;
	private String email;
	private String indirizzo;
	private String cittaResidenza;
	private CorsoDiLaurea corsoDiLaurea;

	@Builder
	public Studente(String matricola, String nome, String cognome, LocalDate dataNascita, String email, String indirizzo,
			String cittaResidenza, CorsoDiLaurea corsoDiLaurea) {

		this.matricola = matricola;
		this.nome = nome;
		this.cognome = cognome;
		this.dataNascita = dataNascita;
		this.email = email;
		this.indirizzo = indirizzo;
		this.cittaResidenza = cittaResidenza;
		this.corsoDiLaurea = corsoDiLaurea;
	}

	public Studente() {

	}

	@Override
	public String toString() {
		return "Studente [matricola= " + matricola + ", nome= " + nome + ", cognome= " + cognome + ", dataNascita= "
				+ dataNascita + ", email= " + email + ", indirizzo= " + indirizzo + ", cittaResidenza= " + cittaResidenza
				+ ", corsoLaurea= " + corsoDiLaurea + "]";
	}

}
