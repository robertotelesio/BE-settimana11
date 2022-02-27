package it.epicode.be.segreteria.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SegreteriaDB {

	private Map<String, Studente> studentiList = new HashMap<String, Studente>();
	private Map<String, CorsoDiLaurea> corsiList = new HashMap<String, CorsoDiLaurea>();

	public boolean aggiungiStudente(Studente s) {
		if (!studentiList.containsValue(s)) {
			studentiList.put(s.getMatricola(), s);
		} else {
			return false;
		}

		return true;
	}

	public boolean aggiungiCorso(CorsoDiLaurea corso) {
		if (!corsiList.containsValue(corso)) {
			corsiList.put(corso.getCodiceCorso(), corso);
		} else {
			return false;
		}

		return true;
	}

	

	public boolean cancellaStudente(String matricolaS) {
		if (studentiList.containsKey(matricolaS)) {
			studentiList.remove(matricolaS);
		} else {
			return false;
		}

		return true;
	}

	public boolean cancellaCorso(String codicecorso) {
		if (corsiList.containsKey(codicecorso)) {
			corsiList.remove(codicecorso);
		} else {
			return false;
		}

		return true;
	}

	public Collection<Studente> getAllStudenti() {
		return studentiList.values();
	}

	public Collection<CorsoDiLaurea> getAllCorsiLaurea() {
		return corsiList.values();
	}

	

}
