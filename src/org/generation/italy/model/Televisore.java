package org.generation.italy.model;

public class Televisore {
	private String marca;
    private String modello;
    private int nrPollici;
    private boolean stato;
    private int volume;
    private boolean modalitàHotel;
    private String[] elencoCanali;
    private int canaleCorrente;

    public Televisore(String marca, String modello, int nrPollici) throws Exception {
        this(marca,modello,nrPollici,false);
    }

    public Televisore(String marca, String modello, int nrPollici, boolean modalitàHotel) throws Exception {
        if (!marca.isBlank())
        	this.marca = marca;
        else
        	throw new Exception("Marca non valida!");
        if (!modello.isBlank())
        	this.modello = modello;
        else
        	throw new Exception("Modello non valido!");
        if (nrPollici>0)
        	this.nrPollici = nrPollici;
        else
        	throw new Exception("Nr pollici non valido!");
        this.stato = false;
        this.volume = 0;
        this.modalitàHotel = modalitàHotel;
        this.elencoCanali = new String[]{"RAI 1", "RAI 2", "RAI 3", "Rete 4", "Canale 5", "Italia 1", "La 7", "Canale 8", "Canale 9", "Telelombardia"};
        this.canaleCorrente = 0;
    }

    public void accendi() {
        stato = true;
        canaleCorrente = 1;
    }

    public void spegni() {
        stato = false;
    }

    public void aumentaVolume() {
    	if ((stato==true) && (	//si può aumentare il volume solo se la tv è accesa
    		(volume < 10 && !modalitàHotel) || 	//modalità normale: max 10
    		(volume < 5 && modalitàHotel))) {	//modalità hotel: max 5
            volume++;
        }
    }

    public void diminuisciVolume() {
    	if (stato==true && 	//si può diminuire il volume solo se la tv è accesa
    		volume > 0) {
            volume--;
        }
    }

    public boolean cambiaCanale(int canale) {		//ritorna: true se è stato possibile cambiare il canale; false altrimenti
    	if (stato==true) {	//solo a tv accesa
	        if (canale >= 0 && canale < elencoCanali.length) {
	            canaleCorrente = canale;
	            return true;
	        } else 
	            return false;	        
    	}
    	else 
            return false;
    }

    public String mostraCanale() {
    	if (stato==true) 	//solo a tv accesa
    		return "Stai guardando il canale " + elencoCanali[canaleCorrente];
    	else
    		return "";
        
    }

    public void visualizzaElencoCanali() {
    	if (stato==true) 	//solo a tv accesa
	        for (String canale : elencoCanali) {
	            System.out.println(canale);
	        }
    }

    public String getMarca() {
        return marca;
    }

    public String getModello() {
        return modello;
    }

    public int getNrPollici() {
        return nrPollici;
    }

    public boolean getStato() {
        return stato;
    }

    public int getVolume() {
        return volume;
    }

    public boolean getModalitàHotel() {
        return modalitàHotel;
    }

    public int getCanaleCorrente() {
        return canaleCorrente;
    }

    public void setModalitàHotel(boolean modalitàHotel) {
    	if (stato==true) { 	//solo a tv accesa    	
    		this.modalitàHotel = modalitàHotel;
    		if (modalitàHotel && volume>5)
    			volume=5;
    	}
    }

    @Override
    public String toString() {
        return "Marca: " + marca + ", Modello: " + modello + ", Numero Pollici: " + nrPollici + 
        		"\nStato: " + (stato?"acceso":"spento") + ", Volume: " + volume + ", Modalità: " + 
        		(modalitàHotel?"hotel":"normale") + ", Canale Corrente: " + canaleCorrente;
    }
}
