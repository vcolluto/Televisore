package org.generation.italy.model;

import java.util.Random;

public class Canale {
	private String nome;
	private int frequenza;
	private int potenzaSegnale;		//da 0 a 100
	
	
	public Canale(String nome, int frequenza, int potenzaSegnale) throws Exception {		//valori iniziali (creo l'oggetto). Ha senso creare l'oggetto con valori non validi? Sì => valori predefiniti; No => genero un'eccezione 
		super();
		if (!nome.isBlank())
			this.nome = nome;
		else
			throw new Exception("nome non valido");
		if (frequenza>0)
			this.frequenza = frequenza;
		else
			throw new Exception("frequenza non valida");
		if (potenzaSegnale>=0 && potenzaSegnale<=100)
			this.potenzaSegnale = potenzaSegnale;
		else
			throw new Exception("potenza segnale non valida");		
	}
	
	public Canale(String nome, int frequenza) throws Exception {		//valori iniziali (creo l'oggetto). Ha senso creare l'oggetto con valori non validi? Sì => valori predefiniti; No => genero un'eccezione 
		this(nome, frequenza,(new Random()).nextInt(101));	//creo un canale con potenza segnale casuale			
	}



	public int getPotenzaSegnale() {
		return potenzaSegnale;
	}


	public void setPotenzaSegnale(int potenzaSegnale) {		//ho già creato l'oggetto (se il parametro non è valido posso decidere di lasciare l'oggetto nello stato attuale)
		if (potenzaSegnale>=0 && potenzaSegnale<=100)
			this.potenzaSegnale = potenzaSegnale;
	}


	public String getNome() {
		return nome;
	}


	public int getFrequenza() {
		return frequenza;
	}

	@Override
	public String toString() {
		String ris="";
		ris= "Canale [nome=" + nome + ", frequenza=" + frequenza + ", potenzaSegnale=";
		
		int nrPallini=potenzaSegnale/10;
		for (int i=1;i<=nrPallini;i++)
			ris+="*";
		ris+="]";
		
		return ris;
		
	}
	
	

	
}
