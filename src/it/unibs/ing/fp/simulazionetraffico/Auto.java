package it.unibs.ing.fp.simulazionetraffico;

public class Auto extends Elemento {

	public Auto(Direzione _direzione, int _velocita) {
		super(_direzione, '>', _velocita);
		
	}
	
	public Auto() {
		super(Direzione.STOP, '>', 0);
		
	}

}
