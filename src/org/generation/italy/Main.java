package org.generation.italy;

import java.util.Scanner;

import org.generation.italy.model.Televisore;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Televisore televisore = null;
		String scelta;
		do{
			System.out.println("\n\n\n\n\n\n\nGestione televisore:");
			System.out.println("1. Crea televisore");
			System.out.println("2. Accendi");
			System.out.println("3. Spegni");
			System.out.println("4. Aumenta volume");
			System.out.println("5. Diminuisci volume");
			System.out.println("6. Cambia canale");
			System.out.println("7. Mostra canale");
			System.out.println("8. Visualizza elenco canali");
			System.out.println("9. Imposta modalità hotel");
			System.out.println("0. Esci");

			if (televisore != null) {
				System.out.println(televisore.toString());
			}

			System.out.print("\nInserisci la tua scelta:");
			scelta = sc.nextLine();

			switch (scelta) {
			case "1":		
				try {
					System.out.print("Inserisci la marca:");
					String marca = sc.nextLine();
					System.out.print("Inserisci il modello:");
					String modello = sc.nextLine();
					System.out.print("Inserisci il numero di pollici:");
					int nrPollici = Integer.parseInt(sc.nextLine());
					/*int nrPollici = sc.nextInt();
					sc.nextLine();*/
					System.out.print("Modalità hotel (true/false):");
					boolean modalitàHotel = Boolean.parseBoolean(sc.nextLine());						
				
					televisore = new Televisore(marca, modello, nrPollici, modalitàHotel);
					
					
					System.out.println("Televisore creato.");
				} catch(Exception e) {
					System.out.println("Dati non corretti, televisore non creato!");
					System.err.println(e.toString());
				}
				
				break;
			case "2":
				if (televisore != null) {
					televisore.accendi();
					System.out.println("Televisore acceso.");
				} else
					System.out.println("Creare prima il televisore!");
					
				break;
			case "3":
				if (televisore != null) {
					televisore.spegni();
					System.out.println("Televisore spento.");
				} else
					System.out.println("Creare prima il televisore!");
				break;
			case "4":
				if (televisore != null) {
					televisore.aumentaVolume();
				} else
					System.out.println("Creare prima il televisore!");
				break;
			case "5":
				if (televisore != null) {
					televisore.diminuisciVolume();
				} else
					System.out.println("Creare prima il televisore!");
				break;
			case "6":
				if (televisore != null) {
					System.out.print("Inserisci il canale (0-9):");
					int canale = Integer.parseInt(sc.nextLine());
					if (televisore.cambiaCanale(canale))
						System.out.println("Canale impostato");
					else
						System.out.println("Impossibile cambiare canale");
				} else
					System.out.println("Creare prima il televisore!");
				break;
			case "7":
				if (televisore != null) {
					System.out.println(televisore.mostraCanale());
				} else
					System.out.println("Creare prima il televisore!");
				break;
			case "8":
				if (televisore != null) {
					//televisore.visualizzaElencoCanali();
					//esempio di utilizzo della "dotted notation": il "." consente di accedere agli oggetti interni 
					for(int i=0;i<televisore.getElencoCanali().length;i++) {
						System.out.println(televisore.getElencoCanali()[i].getNome() + 
								" frequenza: "+televisore.getElencoCanali()[i].getFrequenza()+
								" segnale: "+televisore.getElencoCanali()[i].getPotenzaSegnale()+
								" data ultima ricezione: "+
								televisore.getElencoCanali()[i].getDataUltimaRicezione().getDayOfMonth() + "/"+
								televisore.getElencoCanali()[i].getDataUltimaRicezione().getMonthValue()+ "/"+ 
								televisore.getElencoCanali()[i].getDataUltimaRicezione().getYear());
//								telev		arraycanali	   canale		localdate			int					
						
					}
						
				} else
					System.out.println("Creare prima il televisore!");
				break;
			case "9":
				if (televisore.getModalitàHotel())	//sono in modalità hotel => passo in modalità normale
					televisore.setModalitàHotel(false);	
				else
					televisore.setModalitàHotel(true);
				
				break;
			case "0":
				System.out.println("Arrivederci!");
			default:
				System.out.println("Scelta non valida. Riprova.");
				break;
			}
			System.out.println("\nPremi invio per continuare...");
			sc.nextLine();
		} while (!scelta.equals("0"));
		sc.close();
	}

}
