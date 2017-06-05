package it.unibs.ing.fp.simulazionetraffico;

public class Auto extends Elemento {

	public Auto(Direzione _direzione, int _velocita) {
		super(_direzione, '>', _velocita);
		
	}
	
	public Auto() {
		super(Direzione.DESTRA, '>', 0);
		
	}
	
	public boolean prevaleSu(Elemento e) {
		if(e instanceof Pedone)
			return false;
		else 
			return true;
	}

}
