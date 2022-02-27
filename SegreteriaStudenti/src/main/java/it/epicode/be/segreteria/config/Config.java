package it.epicode.be.segreteria.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import it.epicode.be.segreteria.model.CorsoDiLaurea;
import it.epicode.be.segreteria.model.SegreteriaDB;
import it.epicode.be.segreteria.model.Studente;

@Configuration
public class Config {

	@Bean
	@Scope("prototype")
	public Studente studente() {

		return new Studente();

	}

	@Bean
	public CorsoDiLaurea corsoLaurea() {

		return new CorsoDiLaurea();

	}

	@Bean
	public SegreteriaDB segreteriadb() {

		return new SegreteriaDB();
	}
}
