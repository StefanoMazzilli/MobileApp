package org.generation.italy.model;

import java.time.LocalDate;

public class Recensione {
	private LocalDate data;
	private String nomeUtente;
	private int numeroStelle;
	private String testo;
	
	//primo metodo costruttore con commento
	public Recensione(String nomeUtente, int numeroStelle, String testo) throws Exception{
		//controllo la validità del nome
		if (!nomeUtente.isBlank()) {
			this.nomeUtente=nomeUtente;
		} else {
			throw new Exception ("Nome utente non valido!");
		}
		
		//controllo la validità del numero di stelle
		if (numeroStelle<1||numeroStelle>5) {
			throw new Exception ("Numero stelle non valido!");
		} else {
			this.numeroStelle=numeroStelle;
		}
		
		this.testo=testo;
		
		//imposto la data corrente
		data=LocalDate.now();
	}
	
	//secondo metodo costruttore senza commento
	public Recensione (String nomeUtente, int numeroStelle) throws Exception {
		//controllo la validità del nome
		if (!nomeUtente.isBlank()) {
			this.nomeUtente=nomeUtente;
		} else {
			throw new Exception ("Nome utente non valido!");
		}
		
		//controllo la validità del numero di stelle
		if (numeroStelle<1||numeroStelle>5) {
			throw new Exception ("Numero stelle non valido!");
		} else {
			this.numeroStelle=numeroStelle;
		}
		
		this.testo="--- NESSUN TESTO ---";
		
		//imposto la data corrente
		data=LocalDate.now();
	}

	public LocalDate getData() {
		return data;
	}

	public String getNomeUtente() {
		return nomeUtente;
	}

	public int getNumeroStelle() {
		return numeroStelle;
	}

	public String getTesto() {
		return testo;
	}

	@Override
	public String toString() {
		return "[Data: " + data + ", \nNome Utente: " + nomeUtente + ", \nNumero Stelle: " + numeroStelle + "/5, \nCommento: "
				+ testo + "]";
	}
	
}
