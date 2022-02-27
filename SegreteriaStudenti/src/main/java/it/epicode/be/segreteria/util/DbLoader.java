package it.epicode.be.segreteria.util;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import it.epicode.be.segreteria.model.CorsoDiLaurea;
import it.epicode.be.segreteria.model.SegreteriaDB;
import it.epicode.be.segreteria.model.Studente;


@Component
public class DbLoader implements CommandLineRunner {

	@Autowired
	ApplicationContext ctx;

	@Override
	public void run(String... args) throws Exception {

		SegreteriaDB segreteriadb = ctx.getBean(SegreteriaDB.class);
		valorizzaDb(segreteriadb);

	}


	private void valorizzaDb(SegreteriaDB SegreteriaDB) {

			CorsoDiLaurea c1 = CorsoDiLaurea.builder().codiceCorso("1").nome("diritto").indirizzo("Roma").esami(30).build();
			CorsoDiLaurea c2 = CorsoDiLaurea.builder().codiceCorso("2").nome("informatica").indirizzo("Roma").esami(25).build();
			CorsoDiLaurea c3 = CorsoDiLaurea.builder().codiceCorso("3").nome("Medicina").indirizzo("Milano").esami(25).build();
			CorsoDiLaurea c4 = CorsoDiLaurea.builder().codiceCorso("4").nome("Psicologia").indirizzo("Perugia").esami(25).build();
			CorsoDiLaurea c5 = CorsoDiLaurea.builder().codiceCorso("5").nome("Storia").indirizzo("Napoli").esami(25).build();
			CorsoDiLaurea c6 = CorsoDiLaurea.builder().codiceCorso("6").nome("Lingue").indirizzo("Cosenza").esami(25).build();

			Studente s1 = Studente.builder().nome("Roberto").cognome("Telesio").cittaResidenza("Cosenza").dataNascita(LocalDate.parse("2003-02-17")).email("telesioroberto@gmail.com").corsoDiLaurea(c1).build();
			Studente s2 = Studente.builder().nome("Giovanni").cognome("Rossi").cittaResidenza("Roma").dataNascita(LocalDate.parse("2003-3-15")).email("giovannirossi.com").corsoDiLaurea(c2).build();
			Studente s3 = Studente.builder().nome("Giuseppe").cognome("verdi").cittaResidenza("Roma").dataNascita(LocalDate.parse("2002-12-17")).email("giuverdi@gmail.com").corsoDiLaurea(c3).build();
			Studente s4 = Studente.builder().nome("Giorgio").cognome("Gialli").cittaResidenza("Milano").dataNascita(LocalDate.parse("2000-06-17")).email("giogialli@gmail.com").corsoDiLaurea(c4).build();
			Studente s5 = Studente.builder().nome("Marcello").cognome("Marconi").cittaResidenza("Bologna").dataNascita(LocalDate.parse("2001-02-14")).email("marcelloni@gmail.com").corsoDiLaurea(c5).build();
			Studente s6 = Studente.builder().nome("Francesco").cognome("Franco").cittaResidenza("Napoli").dataNascita(LocalDate.parse("2002-02-04")).email("francocesco@gmail.com").corsoDiLaurea(c6).build();
			
			

			SegreteriaDB.aggiungiStudente(s1);
			SegreteriaDB.aggiungiStudente(s2);
			SegreteriaDB.aggiungiStudente(s3);
			SegreteriaDB.aggiungiStudente(s4);
			SegreteriaDB.aggiungiStudente(s5);
			SegreteriaDB.aggiungiStudente(s6);
			
		}
			
	}


