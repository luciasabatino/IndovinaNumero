package it.polito.tdp.indonumero;

import java.security.InvalidParameterException;

public class Model {

	//qui dentro verrà trasferito l'algoritmo: ci si concentra sul gioco
	private int NMAX=100;
	private int TMAX=7;
	
	private int segreto; //numero da indovinare
	private int tentativi; //tentativi già fatti
	
	private boolean inGame;

	public Model() {
		this.inGame=false;
	}
	
	//le azioni che posso fare per far avanzare il gioco sono
	// 1) iniziare una partita nuova
	// 2) fare un tentativo
	
	/**
	 * Avvia una nuova partita, generando un nuovo numero segreto
	 */
	//1)
	public void newGame() {
		this.segreto= (int) (Math.random()*NMAX)+1; //numero intero compreso tra 1 e 100 inclusi
    	this.tentativi=0;
    	this.inGame=true;
	}
	
	/**
	 * Fai un tentativo di indovinare il numero segreto
	 * @param t valore numerico del tentativo
	 * @return 0 se indovinato, +1 se troppo grande, -1 se troppo piccolo
	 */
	
	//2)
	public int tentativo(int t) {
		//t è il valore tentato dall'utente
		if(!inGame) {
			throw new IllegalStateException("Partita non attiva");
		}
		
		if(!valoreValido(t)) {
			throw new InvalidParameterException("Tentativo fuori range");
		}
		
		this.tentativi++;
		if(this.tentativi==this.TMAX) {
			this.inGame = false;
		}
		
		if(t==this.segreto) {
			//il gioco è finito
			this.inGame=false;
			return 0;
		}
		if(t<this.segreto)
			return -1;
		return 1;
	}
	
	public boolean isInGame() {
		return inGame;
	}
	
	public int getTentativi() {
		return tentativi;
	}

	public int getNMAX() {
		return NMAX;
	}

	public int getTMAX() {
		return TMAX;
	}
	
	/**
	 * Controlla se il tentativo fornito rispetta del regole formali del gioco, cioè è nel range [1,NMAX]
	 * @param tentativo
	 * @return {@code true} se il tentativo è valido
	 */
	
	public boolean valoreValido(int tentativo) {
		return tentativo>=1 && tentativo<=this.NMAX;
	}

	public int getSegreto() {
		// TODO Auto-generated method stub
		return segreto;
	}
	
	
}
