package org.generation.italy;

import java.util.ArrayList;
import java.util.Scanner;

import org.generation.italy.model.MobileApp;
import org.generation.italy.model.Recensione;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//variabili
		String nomeApp = new String();
		String nomeOs = new String();
		float prezzo;
		boolean appFatta=false;
		MobileApp app;
		String scelta;
		int nDownload, nStelle;
		String nomeUtente = new String();
		String commento = new String();
		Recensione r;
		ArrayList<Recensione> elencoRecensioni;
		String ricavo = new String();
		Scanner sc=new Scanner(System.in);
		
		System.out.print("Benvenuto! ");
		//ciclo per la creazione di un'app
		do {
			try {
				System.out.println("Creiamo una nuova app!");
				System.out.print("Iniziamo con il nome: ");
				nomeApp = sc.nextLine();
				System.out.print("Inserire il nome del sistema operativo su cui lavora: ");
				nomeOs = sc.nextLine();
				System.out.print("Infine, inserisci il prezzo a cui vuoi venderla:  ");
				prezzo = Float.parseFloat(sc.nextLine());
				
				//provo a creare l'app
				app = new MobileApp(nomeApp, nomeOs, prezzo);
				System.out.println("Applicazione creata con successo!");
				appFatta=true;
				// ----- GESTIONE APPLICAZIONE -----
				do {
					System.out.println("\n\nMenù di gestione dell'applicazione: "+app.getNome());
					System.out.println("Scegliere l'azione da eseguire con il numero associato");
					System.out.println("1) Download applicazione\n"
							+ "2) Download multiplo\n"
							+ "3) Ricevi recensione\n"
							+ "4) Visualizza recensioni\n"
							+ "5) ESCI");
					scelta = sc.nextLine();
					
					switch (scelta) {
					case "1":
						System.out.println("\nDownload dell'applicazione in corso...");
						app.download();
						System.out.println("Download completato!");
						break;
						
						
					case "2":
						System.out.println("\nQuanti download vuoi compiere?");
						nDownload=Integer.parseInt(sc.nextLine());
						System.out.println("Download multipli dell'applicazione in corso...");
						try {
							app.download(nDownload);
							System.out.println("Download completati!");
						} catch (Exception e) {
							System.err.println("ATTENZIONE! "+e.getMessage());
						}
						break;
						
					case "3":
						System.out.println("\nInserimento recensione.");
						System.out.print("Inserire il nome utente: ");
						nomeUtente = sc.nextLine();
						System.out.print("Inserire il numero delle stelle: ");
						nStelle = Integer.parseInt(sc.nextLine());
						System.out.println("Inserire il commento alla recensione (facoltativo):");
						commento=sc.nextLine();
						try {
							if (commento.isBlank()) {
								r = new Recensione (nomeUtente, nStelle);
							} else {
								r = new Recensione (nomeUtente, nStelle, commento);
							}
							app.riceviRecensione(r);
							System.out.println("Recensione aggiunta con successo!");
						} catch (Exception e) {
							System.err.println("Recensione non aggiunta! "+e.getMessage());
						}
						break;
						
					case "4":
						if (app.getNumRecensioni()>0) {
							//ci sono delle recensioni dell'app
							System.out.println("Ecco le recensioni ricevute fino ad ora:");
							//ciclo for in cui mostro le varie recensioni
							elencoRecensioni = new ArrayList<Recensione>();
							elencoRecensioni = app.getElencoRecensioni();
							for (int i = 0; i < app.getNumRecensioni(); i++) {
								System.out.println("Numero "+(i+1)+":");
								System.out.println(elencoRecensioni.get(i).toString());
								System.out.println();
							}
							
						} else {
							//non ci sono recensioni
							System.out.println("Non ci sono recensioni dell'applicazione");
						}
						break;
						
					case "5":
						System.out.println("Arrivederci!");
						break;
					default:
						System.out.println("Inserimento non valido!");
					}
					//mostro lo stato dell'applicazione solo se l'utente non ha selezionato ESCI
					if (!scelta.equals("5")) {
						System.out.println("\nValutazione media dell'app: "+app.valutazioneMedia());
						ricavo = String.format("%.2f", app.getRicavoTotale());
						System.out.println("Ricavo totale dell'app: "+ricavo+"€");
						System.out.println("\n\nPremere INVIO per continuare");
						sc.nextLine();
					}
				} while (!scelta.equals("5"));
				
			} catch (Exception e) {
				System.err.println("ATTENZIONE!! "+e.getMessage());
			}
		} while (!appFatta);
		
		sc.close();
	}

}
