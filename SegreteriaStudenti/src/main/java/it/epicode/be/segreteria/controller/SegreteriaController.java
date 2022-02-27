package it.epicode.be.segreteria.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.servlet.ModelAndView;

import it.epicode.be.segreteria.model.CorsoDiLaurea;
import it.epicode.be.segreteria.model.SegreteriaDB;
import it.epicode.be.segreteria.model.Studente;

@Controller
public class SegreteriaController {

	Logger log = LoggerFactory.getLogger(getClass());

	@Autowired
	ApplicationContext ctx;

	public SegreteriaDB getSegreteriaDb() {
		return ctx.getBean(SegreteriaDB.class);
	}

	
	@GetMapping("/stampastudenti")
	public ModelAndView stampaStudenti() {
		return new ModelAndView("studentiview", "studentiList", getSegreteriaDb().getAllStudenti());
	}
	
	
	@GetMapping("/stampacorsi")
	public ModelAndView stampaCorsi() {
		return new ModelAndView("corsiview", "corsiList", getSegreteriaDb().getAllCorsiLaurea());
	}


	@GetMapping("/eliminastudente/{matricola}")
	public ModelAndView eliminaStudente(@PathVariable("matricola") String matricola) {
		getSegreteriaDb().cancellaStudente(matricola);
		return new ModelAndView("studentiview", "studentiList", getSegreteriaDb().getAllStudenti());
	}
	
	@GetMapping("/eliminacorso/{codicecorso}")
	public ModelAndView eliminaCorso(@PathVariable("codicecorso") String codicecorso) {
		getSegreteriaDb().cancellaCorso(codicecorso);
		return new ModelAndView("corsiview", "corsiList", getSegreteriaDb().getAllCorsiLaurea());
	}


	@GetMapping("/studente/mostraformaggiungi")
	public ModelAndView mostraFormAggiungi(Studente studente) {

		ModelAndView modelandview = new ModelAndView("inseriscistudente", "corsiList",
				getSegreteriaDb().getAllCorsiLaurea());
		return modelandview;
	}

	
	@PostMapping("/studente/inserisci")
	public String inserisciStudente(Studente studente, BindingResult result, Model model) {

		getSegreteriaDb().aggiungiStudente(studente);
		model.addAttribute("studentiList", getSegreteriaDb().getAllStudenti());
		model.addAttribute("corsiList", getSegreteriaDb().getAllCorsiLaurea());
		return "studentiview";
	}
	
	
	@GetMapping("/corso/mostraformaggiungi")
	public ModelAndView mostraFormAggiungiCorso(CorsoDiLaurea corso) {

		ModelAndView modelandview = new ModelAndView("inseriscicorso", "corsiList",
				getSegreteriaDb().getAllCorsiLaurea());
		return modelandview;
	}
	
	
	@PostMapping("/corso/inserisci")
	public String inserisciCorso(CorsoDiLaurea corso, BindingResult result, Model model) {

		getSegreteriaDb().aggiungiCorso(corso);
		model.addAttribute("corsiList", getSegreteriaDb().getAllCorsiLaurea());
		return "corsiview";
	}
	
	

}
