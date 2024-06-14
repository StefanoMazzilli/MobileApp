package org.generation.italy.model;

import java.util.ArrayList;

public class MobileApp {
	private String nome;
	private String sistemaOperativo;
	private float prezzo;
	private ArrayList<Recensione> elencoRecensioni;
	private float ricavoTotale;
	
	public MobileApp (String nome, String os, float prezzo) throws Exception {
		//controllo la validità del nome dell'app
		if (!nome.isBlank()) {
			this.nome=nome;
		} else {
			throw new Exception ("Nome app non valido!");
		}
		
		//controllo la validità del nome del sistema operativo
		if (!os.isBlank()) {
			this.sistemaOperativo=os;
		} else {
			throw new Exception ("Sistema operativo non valido!");
		}
		
		//controllo la validità del prezzo
		if (prezzo>=0f) {
			this.prezzo=prezzo;
		} else {
			throw new Exception ("Il prezzo non può essere negativo!");
		}
		
		//inizializzo gli altri attributi a zero o come vuoti
		elencoRecensioni=new ArrayList<Recensione>();
		ricavoTotale=0f;
	}
	
	//download singolo
	public void download() {
		ricavoTotale=ricavoTotale+prezzo;
	}
	
	//download multiplo
	public void download (int numeroDownload) throws Exception{
		if (numeroDownload>0) {
			ricavoTotale=ricavoTotale+(prezzo*numeroDownload);
		} else {
			throw new Exception ("Il numero di download non può essere negativo!");
		}
	}
	
	public void riceviRecensione (Recensione recensione) {
		elencoRecensioni.add(recensione);
	}
	
	public String valutazioneMedia () {
		String valutazioneMedia;
		float media;
		int totStelle=0;
		//mi assicuro che ci siano già delle valutazioni
		if (elencoRecensioni.size()==0) {
			valutazioneMedia="Non ci sono recensioni";
		} else {
			//faccio la somma di tutte le stelle ricevute per la media
			for (Recensione r:elencoRecensioni) {
				totStelle=totStelle+r.getNumeroStelle();
			}
			media=((float)totStelle)/((float)elencoRecensioni.size());
			valutazioneMedia=String.format("%.1f", media)+"/5 stelle";
		}
		return valutazioneMedia;
	}

	public String getNome() {
		return nome;
	}

	public String getSistemaOperativo() {
		return sistemaOperativo;
	}

	public float getPrezzo() {
		return prezzo;
	}

	public ArrayList<Recensione> getElencoRecensioni() {
		return elencoRecensioni;
	}
	
	public int getNumRecensioni() {
		return elencoRecensioni.size();
	}

	public float getRicavoTotale() {
		return ricavoTotale;
	}
	
	
}
